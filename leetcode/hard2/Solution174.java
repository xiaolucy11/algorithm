package algorithm.hard2;

import org.junit.Test;

public class Solution174 {


    public  int search(int[][] dungeon, int row, int col, int[][] dp){
        if(row == dungeon.length - 1 && col == dungeon[0].length - 1){
            if(dungeon[row][col] < 0){
                dp[row][col] = Math.abs(dungeon[row][col]) + 1;
            }else {
                dp[row][col] = 1;
            }
        }else if(row == dungeon.length-1 && col != dungeon[0].length - 1){
            int value1 = 0;
            if(dp[row][col+1] != Integer.MIN_VALUE){
                value1 = dp[row][col+1];
            }else {
                value1 = search(dungeon,row,col+1,dp);
            }
            if(dungeon[row][col] < 0){
                dp[row][col] = Math.abs(dungeon[row][col]) + value1;
            }else {
                dp[row][col] = Math.max(1, value1 - dungeon[row][col]);
            }
        }else if(row != dungeon.length - 1 && col == dungeon[0].length - 1){
                int value2 = 0;
                if(dp[row+1][col] != Integer.MIN_VALUE){
                    value2  = dp[row+1][col];
                }else {
                    value2 = search(dungeon,row+1, col, dp);
                }
                if(dungeon[row][col] < 0){
                    dp[row][col] = Math.abs(dungeon[row][col]) + value2;
                }else {
                    dp[row][col] = Math.max(1,value2 - dungeon[row][col]);
                }
        }else {
            int right = 0, down = 0;

            int value1 = 0;
            if(dp[row][col+1] != Integer.MIN_VALUE){
                value1 = dp[row][col+1];
            }else {
                value1 = search(dungeon,row,col+1,dp);
            }

            int value2 = 0;
            if(dp[row+1][col] != Integer.MIN_VALUE){
                value2  = dp[row+1][col];
            }else {
                value2 = search(dungeon,row+1, col, dp);
            }

            if(dungeon[row][col] < 0){
                 right = Math.abs(dungeon[row][col]) + value1;
            }else {
                right = Math.max(1, value1 - dungeon[row][col]);
            }

            if(dungeon[row][col] < 0){
                down = Math.abs(dungeon[row][col]) + value2;
            }else {
                down = Math.max(1,  value2 - dungeon[row][col]);
            }

            dp[row][col] = Math.min(right, down);
        }

        return dp[row][col];
    }


    //Accepted -----7ms
    /*
        dp algorithm
        using memorization search
     */
    public  int calculateMinimumHP(int[][] dungeon){
        int[][] dp = new int[dungeon.length][dungeon[0].length];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return search(dungeon,0,0, dp);
    }


    @Test
    public  void  test(){
        int[][] dungeon = {{-2,-3,3},
                {-5,-10,1,},
                {10,30,-5}};
//       int[][] dungeon = {{0,-3},{-10,0}};

        long startTime = System.currentTimeMillis();
        int result = calculateMinimumHP(dungeon);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
