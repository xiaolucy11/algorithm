package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/13 0013.
 */
public class Solution64 {
    //Accepted -----7ms
    public  int minPathSum(int[][] grid){
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] dp = new int[rowLength][colLength];

        for(int i = rowLength - 1; i >= 0; i--){
            for(int j = colLength - 1; j >= 0; j--){
                if(i == rowLength - 1  && j == colLength - 1){
                    dp[i][j] = grid[i][j];
                }else if(i == rowLength - 1){
                    dp[i][j] = dp[i][j+1] + grid[i][j];
                }else if(j == colLength - 1){
                    dp[i][j] = dp[i+1][j] + grid[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    @Test
    public  void test(){
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        int result = minPathSum(grid);
        System.out.print(result);
    }
}
