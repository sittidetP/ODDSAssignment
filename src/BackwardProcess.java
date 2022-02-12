
import java.util.LinkedHashMap;
import java.util.Map;



public class BackwardProcess {

    
    LinkedHashMap<Integer, Integer> fwdResultMap;
    String fwdResult;
    public BackwardProcess(Map fwdResultMap, String fwdResult) {
        this.fwdResultMap = (LinkedHashMap<Integer, Integer>)fwdResultMap;
        this.fwdResult = fwdResult;
    }

    public int StartBackwardProcess() {
        String resultD = D(fwdResult);
        String resultE = E(resultD);
        
        return 0;
    }

    private String D(String fwdResult) {
        String result = "";
        String word = "";
        int startCharIndex = 0;
        while (startCharIndex < fwdResult.length()) {
            if (fwdResult.charAt(startCharIndex) == '6') {
                word = fwdResult.substring(startCharIndex, startCharIndex + 6);
            } else {
                word = fwdResult.substring(startCharIndex, startCharIndex + 8);
            }
            //System.out.println("word : " + word);
            for (int i = 0; i < word.length() - 1; i += 2) {
                String wB2num = word.charAt(i) + "" + word.charAt(i + 1);
                int numFormW = Integer.parseInt(wB2num);
                result += (char) numFormW;
            }
            //System.out.println("word.length() + startCharIndex : " + (word.length() + startCharIndex));
            //System.out.println("fwdResult.charAt(word.length() + startCharIndex) : " + fwdResult.charAt(word.length() + startCharIndex));
            result += fwdResult.charAt(word.length() + startCharIndex);
            startCharIndex += word.length() + 1;
            //System.out.println(startCharIndex);
        }
        System.out.println("D : " + result);
        return result;
    }
    
    private String E(String d){
        String lowerD = d.toLowerCase(); //ทำให้สตริงทั้งสายเป็นตัวพิมพ์เล็กทั้งหมด
        int startStrRound = 0;
        String result = "";
        for(Map.Entry entry: fwdResultMap.entrySet()){
            int numIndex = (int)entry.getKey();
            if(numIndex == -1)
                continue;
            for(int i = startStrRound; i < numIndex; ++i){
                String charStrD = lowerD.charAt(numIndex - 1 - i + startStrRound)+"";
                String charToSetIn = charStrD;
                if(i == startStrRound){
                    charToSetIn = charStrD.toUpperCase();
                }
                result+=(charToSetIn);
                //System.out.println("ch : " + lowerD.charAt(numIndex - 1 - i + startStrRound) + ", index : " + (numIndex - 1 - i + startStrRound));
            }
            startStrRound = numIndex + 1;
            result += entry.getValue();
        }
        System.out.println("E : " + result);
        return result;
    }
}
