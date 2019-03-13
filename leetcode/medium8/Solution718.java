package algorithm.medium8;

import org.junit.Test;

/**
 * Created by youlu on 2018/11/3.
 */
public class Solution718 {

    //Accepted ----94ms
    /*
        dp algorithm
        similar to longes commone sequence,
     */
    public  int findLength(int[] A, int[] B){
        int[][] dp = new int[A.length+1][B.length+1];
        int longestLenght = 0;
        for(int i = 0; i < A.length+1; i++){
            for(int j = 0; j < B.length + 1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j] > longestLenght){
                        longestLenght = dp[i][j];
                    }
                }else {
                    dp[i][j] =0;
                }
            }
        }
        return  longestLenght;
    }

    public  int findLength1(int[] A, int[] B){
        int longesLength = 0;

        return  0;
    }

    @Test
    public  void  test(){
        /*int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};*/

        int[] A = {0,1,1,1,1};
        int[] B = {1,0,1,0,1};

        int result = findLength(A,B);
        System.out.println("result : " + result);
    }
}
