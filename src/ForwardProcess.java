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
    //String[] numStr;

    public ForwardProcess(int numInput) {
        this.numInput = numInput;
    }
    
    public void StartForwardProcess(int num){
        String resultA = A(num);
        B(resultA);
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
        
        if(numMod10 % 2 == 0){ //หาว่าเลขตัวหลัง เป็นเลขคี่หรือเลขคู่
            result += "Even" + numMod10;
        }else{
            result += "Odd" + numMod10;
        }
        System.out.println("A : " + result);
        return result;
    }
    
    private String B(String a){
        //int amountOfNum = 0;
        String cleanA = a.replaceAll("\\D+", ""); //เอาตัวอักษรออกให้หมด (แทนที่ตัวอักษรที่ไม่ใช่ตัวเลข(0 - 9) ด้วย "")
        System.out.println(cleanA);
        System.out.println(a);
        System.out.println(a.toUpperCase());
        return "";
    }
    
    
    
    
}
