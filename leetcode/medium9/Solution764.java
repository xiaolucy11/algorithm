package algorithm.medium9;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by youlu on 2018/11/9.
 */
public class Solution764 {
    public boolean check(int[][] matrix ,int row, int col, int length){
        if(col - length < 0 || matrix[row][col - length] == 0){
            return false;
        }
        if(col + length >= matrix.length || matrix[row][col + length] == 0){
            return  false;
        }

        if(row - length < 0 || matrix[row - length][col] == 0){
            return  false;
        }

        if(row + length >= matrix.length || matrix[row + length][col] == 0){
            return  false;
        }

        return  true;
    }



    //Accepted ----932ms
    /*
        dp algorithm
        time complexity  not strictly O(n^2)
     */
    public  int orderOfLargestPlusSign(int N, int[][] mines){
        int[][] matrix = new int[N][N];
        int[][] dp = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                matrix[i][j] = 1;
            }
        }

        for(int i = 0; i < mines.length; i++){
            matrix[mines[i][0]][mines[i][1]] = 0;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                dp[i][j] =  matrix[i][j];
            }
        }

        int length = 1;
        while (true){
            int flag = 0;
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix.length; j++){
                    if(dp[i][j] == length){
                        if(check(matrix,i,j, length)){
                           dp[i][j] = length + 1;
                            flag = 1;
                        }
                    }
                }
            }

            if(flag == 0){
                break;
            }else {
                length++;
            }
        }

        int maxLength = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(dp[i][j] > maxLength){
                    maxLength = dp[i][j];
                }
            }
        }
        return  maxLength;
    }

    public int orderOfLargestPlusSign1(int N, int[][] mines) {
        Set<Integer> banned = new HashSet();
        int[][] dp = new int[N][N];

        for (int[] mine: mines)
            banned.add(mine[0] * N + mine[1]);
        int ans = 0, count;

        for (int r = 0; r < N; ++r) {
            count = 0;
            for (int c = 0; c < N; ++c) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = count;
            }

            count = 0;
            for (int c = N-1; c >= 0; --c) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }

        for (int c = 0; c < N; ++c) {
            count = 0;
            for (int r = 0; r < N; ++r) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }

            count = 0;
            for (int r = N-1; r >= 0; --r) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                ans = Math.max(ans, dp[r][c]);
            }
        }

        return ans;
    }

    @Test
    public  void  test(){
        int N = 5;
        int[][] mines = {{4,2}};

//       int N = 1;
//        int[][] mines = {{0,0}};

//      int N = 5;
//        int[][] mines = {{3,0},{3,3}};

        long startTime = System.currentTimeMillis();
        int result = orderOfLargestPlusSign(N, mines);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
