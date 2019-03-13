package algorithm.medium3;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/15.
 */
public class Solution299 {

    //Accepted -----2ms
    public  String getHin(String secret, String guess ){
        if(secret == null){
            return "";
        }
        int length = secret.length();
        int[] array = new int[11];
        int[] bullArray = new int[length];
        int ACount = 0, BCount = 0;
        for(int i = 0; i < length; i++){
            if(secret.charAt(i) == guess.charAt(i)){
                ACount++;
                bullArray[i] = 1;
            }else {
                int value = (int) (secret.charAt(i) - '0');
                array[value]++;
            }
        }

        for(int j = 0; j < length; j++){
            int v = (int)(guess.charAt(j) - '0');
            if(bullArray[j] != 1 && array[v] > 0){
                BCount++;
                array[v]--;
            }
        }

        String result = "";
        result += Integer.toString(ACount);
        result += Character.toString('A');
        result += Integer.toString(BCount);
        result += Character.toString('B');
        return  result;
    }

    @Test
    public  void  test(){
        String secret = "00112233445566778899";
        String guess = "16872590340158679432";

        System.out.print(getHin(secret, guess));
    }
}
