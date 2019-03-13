package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/12 0012.
 */
public class Solution62 {
    public  int search(int[][] matrix, int row, int col){
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        if((row == rowLength - 1 && col == colLength - 2) || (row == rowLength - 2
                && col == colLength - 1)){
            return  1;
        }
        int downPaths = 0;
        if(row + 1 < rowLength){
            downPaths = search(matrix, row+1, col);
        }
        int rightPaths = 0;
        if(col + 1 < colLength){
            rightPaths = search(matrix, row, col+1);
        }
        matrix[row][col] = downPaths + rightPaths;
        return  matrix[row][col];
    }


    //time limit exceed
    public  int uniquePaths(int m, int n){
        if(m == 1 || n == 1){
            return  1;
        }
        int[][] matrix = new int[m][n];
        return  search(matrix, 0, 0);
    }

    //Accepted ------0ms
    public  int uniquePaths1(int m, int n){
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return  dp[m-1][n-1];
    }
    @Test
    public  void  test(){
        int m = 112;
        int n = 12;
        long startTime = System.currentTimeMillis();
        System.out.println(uniquePaths1(m, n));
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
