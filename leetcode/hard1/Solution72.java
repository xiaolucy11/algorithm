package algorithm.hard1;

import org.junit.Test;

/**
 * Created by youlu on 2018/12/13.
 */
public class Solution72 {



    //Accepted ----12ms
    /*
        dp algorithm
        similar to longest common subSequence
     */
    public  int minDistance(String word1, String word2){
        if(word1.length() == 0){
            return word2.length();
        }
        if(word2.length() == 0){
            return  word1.length();
        }


        int[][] dp = new int[word1.length() + 1][word2.length() + 2];
        for(int i = 0; i < word2.length() + 1; i++){
            dp[0][i] = i;
        }

        for(int j = 0; j < word1.length() + 1; j++){
            dp[j][0] = j;
        }

        for(int i = 1; i < word1.length() + 1; i++){
            for(int j = 1; j < word2.length() + 1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    int min = Math.min(dp[i-1][j], dp[i][j-1]);
                    min = Math.min(min,dp[i-1][j-1]);
                    dp[i][j] = min + 1;
                }
            }
        }

        return  dp[word1.length()][word2.length()];
    }

    @Test
    public  void  test(){
       /* String word1 = "horse";
        String word2 = "ros";*/

       /* String word1 =  "intention";
        String word2 = "execution";*/

       /* String word1 = "";
        String word2 = "a";*/

       String word1 = "distance";
        String word2 = "springbok";
        int result = minDistance(word1, word2);
        System.out.println("result : " + result);
    }
}
