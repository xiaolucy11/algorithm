package algorithm.hard2;

import org.junit.Test;

public class Solution329 {
    //Accepted ---127ms
    /*
        dp algorithm
     */
    public int longestIncreasingPath(int[][] matrix){
        if(matrix.length == 0){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int v = 0;
                if(i-1 >= 0 && matrix[i][j] > matrix[i-1][j]){
                    v++;
                }
                if(i+1 < matrix.length && matrix[i][j] > matrix[i+1][j]){
                    v++;
                }
                if(j-1>= 0 && matrix[i][j] > matrix[i][j-1]){
                    v++;
                }
                if(j+1 < matrix[0].length && matrix[i][j] > matrix[i][j+1]){
                    v++;
                }
                if(v == 0){
                    dp[i][j] = 1;
                }
            }
        }

        int maxPath = 1;
        int count = 1;
        while (true){
            int tempPath = maxPath;
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    if(dp[i][j] == count) {
                        if (j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]) {
                                dp[i][j-1] = Math.max(dp[i][j-1],dp[i][j] + 1);
                                tempPath = Math.max(tempPath, dp[i][j-1]);

                        }
                        if(j+1 < matrix[0].length && matrix[i][j] < matrix[i][j+1]){
                             dp[i][j+1] = Math.max(dp[i][j+1],dp[i][j] + 1);
                             tempPath = Math.max(tempPath, dp[i][j+1]);
                        }
                        if(i-1>= 0 && matrix[i][j] < matrix[i-1][j]){
                            dp[i-1][j] = Math.max(dp[i-1][j],dp[i][j] +1);
                            tempPath = Math.max(tempPath,dp[i-1][j]);
                        }
                        if(i+1 < matrix.length && matrix[i][j] < matrix[i+1][j]){
                            dp[i+1][j] = Math.max(dp[i+1][j],dp[i][j]+1);
                            tempPath = Math.max(tempPath,dp[i+1][j]);
                        }
                    }
                }
            }

            if(tempPath <= maxPath){
                return maxPath;
            }else {
                maxPath = tempPath;
                count++;
            }
        }
    }

    /*
        code from other
     */
    public int longestIncreasingPath1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int i=0; i < matrix.length; i++) {
            for(int j=0; j < matrix[0].length; j++) {
                int len = dfs(matrix, i, j, Integer.MIN_VALUE, memo);
                max = Math.max(max, len);
            }
        }

        return max;
    }
    private int dfs(int[][] A, int i, int j, int prev, int[][] memo) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length) return 0;
        int cur = A[i][j];
        if (cur <= prev) return 0;
        if (memo[i][j] != 0) return memo[i][j];
        int ret = 0;
        ret = Math.max(dfs(A, i + 1, j, cur, memo), ret);
        ret = Math.max(dfs(A, i - 1, j, cur, memo), ret);
        ret = Math.max(dfs(A, i, j - 1, cur, memo), ret);
        ret = Math.max(dfs(A, i, j + 1, cur, memo), ret);
        ret += 1;
        memo[i][j] = ret;
        return ret;
    }

    @Test
    public  void test(){
//        int[][] matrix  = {{9,9,4},{6,6,8},{2,1,1}};
        int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};

        long startTime = System.currentTimeMillis();
        int result = longestIncreasingPath(matrix);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
