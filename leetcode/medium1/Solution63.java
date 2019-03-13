package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/13 0013.
 */
public class Solution63 {
    // recursive solution, may be time out
    public  int search(int[][] matrix,int[][] obstacleGrid, int row, int col){
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        if((row == rowLen - 1 && col == colLen - 2) ||
                (row == rowLen - 2 && col == colLen - 1)){
            matrix[row][col] = 1;
            return  matrix[row][col];
        }
        if(obstacleGrid[row][col] == 1){
            matrix[row][col] = 0;
            return  matrix[row][col];
        }

        int rightStep = 0;
        if(col + 1 < colLen){
            rightStep = search(matrix, obstacleGrid, row, col+1);
        }
        int downStep = 0;
        if(row + 1 < rowLen){
            downStep = search(matrix, obstacleGrid, row  + 1, col);
        }
        matrix[row][col] = rightStep + downStep;
        return  matrix[row][col];
    }

    public  boolean findRow(int[][] obstacleGrid, int col){
        for(int i = col; i < obstacleGrid[0].length; i++){
            if(obstacleGrid[obstacleGrid.length - 1][i] == 1){
                return true;
            }
        }
        return  false;
    }

    public  boolean findCol(int[][] obstacleGrid, int row){
        for(int i = row; i < obstacleGrid.length; i++){
            if(obstacleGrid[i][obstacleGrid[0].length - 1] == 1){
                return  true;
            }
        }
        return  false;
    }

    //Accetped -----1ms
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int rowLength = obstacleGrid.length;
        int colLength = obstacleGrid[0].length;
        int[][] dp = new int[rowLength][colLength];
        if(rowLength == 1 && colLength == 1){
            if(obstacleGrid[0][0] == 1){
                return 0;
            }else {
                return 1;
            }
        }

        for(int i = rowLength - 1; i >= 0; i--){
            for(int j = colLength - 1; j >= 0; j--){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if((i == rowLength - 1) && (j == colLength - 1)){
                    dp[i][j] = 0;
                }else if(i == rowLength - 1){
                    if(findRow(obstacleGrid, j)) {
                        dp[i][j] = 0;
                    }else {
                        dp[i][j] = 1;
                    }
                }else if(j == colLength - 1){
                    if(findCol(obstacleGrid, i)) {
                        dp[i][j] = 0;
                    }else {
                        dp[i][j] = 1;
                    }
                }else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return  dp[0][0];
    }
    @Test
    public  void  test(){
        int[][] obstacleGrid = {{0,0},{1,1},{0,0}};
        int result = uniquePathsWithObstacles(obstacleGrid);
        System.out.print(result);
    }
}
