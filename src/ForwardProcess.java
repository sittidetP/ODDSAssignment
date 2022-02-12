
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teale
 */
public class ForwardProcess {
    int numInput;
    String numStr;
    
    Map<Integer, Integer> numIndexMap; //Key เป็นตำแหน่งของเลขใน A , Value เป็น เป็นเลขที่ในแต่ละหลัก
    //String[] numStr;

    public ForwardProcess(int numInput) {
        this.numInput = numInput;
        numStr = numInput+"";
        numIndexMap = new LinkedHashMap<>();
    }
    
    public void StartForwardProcess(int num){
        String resultA = A(num);
        String resultB = B(resultA);
    }
    
    private String A(int num){
        String result = "";
        int numMod10 = num % 10; //เลขตัวหลัง
        int numDiv10 = num / 10; //เลขตัวหน้า
        
        if(numDiv10 % 2 == 0 && numDiv10 > 0){ //หาว่าเลขตัวหน้า เป็นเลขคี่หรือเลขคู่
            result = "Even" + numDiv10;
        }else if(numDiv10 % 2 != 0 && numDiv10 > 0){
            result = "Odd" + numDiv10;
        }
        
        numIndexMap.put(result.length()-1 , numDiv10);
        
        if(numMod10 % 2 == 0){ //หาว่าเลขตัวหลัง เป็นเลขคี่หรือเลขคู่
            result += "Even" + numMod10;
        }else{
            result += "Odd" + numMod10;
        }
        
        numIndexMap.put(result.length() - 1, numMod10);
        
        /*
        for(Map.Entry entry: numIndexMap.entrySet()){
            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
        }
        */
        System.out.println("A : " + result);
        return result;
    }
    
    private String B(String a){
        String upperA = a.toUpperCase();
        int startStrRound = 0;
        String result = "";
        for(Map.Entry entry: numIndexMap.entrySet()){
            int numIndex = (int)entry.getKey();
            if(numIndex == -1)
                continue;
            for(int i = startStrRound; i < numIndex; ++i){
                result+=(upperA.charAt(numIndex - 1 - i + startStrRound));
                //System.out.println("ch : " + upperA.charAt(numIndex - 1 - i + startStrRound) + ", index : " + (numIndex - 1 - i + startStrRound));
            }
            startStrRound = numIndex + 1;
            result += entry.getValue();
        }
        System.out.println("B : " + result);
        return result;
    }
    
    private String C(String b){
        return "";
    }
}
