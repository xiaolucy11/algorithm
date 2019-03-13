package algorithm.hard1;

import org.junit.Test;

/**
 * Created by youlu on 2018/12/16.
 */
public class Solution115 {


    //Accepted ----8ms
    /*
        dp algorithm
     */
    public  int numDistanct(String s, String t){
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int j = 0; j < t.length() + 1; j++){
            dp[0][j] = 0;
        }

        for(int i = 0; i < s.length() + 1; i++){
            dp[i][0] = 0;
        }

        int count = 0;
        for(int i = 1; i < s.length() + 1; i++){
            if(s.charAt(i-1) == t.charAt(0)){
                count++;
            }
            dp[i][1] = count;
        }

        for(int i = 1; i < s.length() + 1; i++){
            for(int j = 2; j < t.length() + 1; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j] ;

                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }

    @Test
    public  void  test(){
       /* String S = "rabbbit";
        String T = "rabbit";*/

      /* String S = "babgbag";
        String T = "bag";*/
      String S = "aabb";
        String T = "ab";

        long startTime = System.currentTimeMillis();
        int result = numDistanct(S, T);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
