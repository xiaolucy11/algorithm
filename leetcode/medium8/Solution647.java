package algorithm.medium8;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/25.
 */

public class Solution647 {

    //Accepted ----28ms
    /*
        dp algorithm
        time complexity O(n^2)
        it can be optimized, based on the center of every char
     */
    public  int countSubstring(String s){
        int length = s.length();
        int[][] dp = new int[length][length];
        for(int i = 0; i < length; i++){
            for(int j = i; j < length; j++){
                if(i == j){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = -1;
                }
            }
        }

        for(int i = 0; i < length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(s.charAt(i) == s.charAt(j)){
                    if(i-j == 1 || i -j == 2){
                        dp[j][i] = 1;
                    }else {
                        dp[j][i] = dp[j+1][i-1] == 1? 1 : 0;
                    }
                }else {
                    dp[j][i] = 0;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < length; i++){
            for(int j = i; j < length; j++){
                if(dp[i][j] == 1){
                    count++;
                }
            }
        }

        return  count;
    }

    @Test
    public  void  test(){
//        String s = "abc";
        String s = "aaa";
        long startTime = System.currentTimeMillis();
        int result = countSubstring(s);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
