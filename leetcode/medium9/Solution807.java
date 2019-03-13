package algorithm.medium9;

import org.junit.Test;

/**
 * Created by youlu on 2018/11/17.
 */
public class Solution807 {


    //Accepted ----8ms
    public  int maxIncreaseKeepingSkyline(int[][] grid){
        int[] left = new int[grid.length];
        int[] bottom = new int[grid[0].length];

        for(int i = 0; i < grid.length; i++){
            int max = -1;
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] > max){
                    max = grid[i][j];
                }
            }
            left[i] = max;
        }

        for(int j = 0; j < grid[0].length; j++){
            int max = -1;
            for(int i =0; i < grid.length; i++){
                if(max < grid[i][j]){
                    max = grid[i][j];
                }
            }
            bottom[j] = max;
        }

        int sum = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int min = Math.min(left[i], bottom[j]);
                sum += min- grid[i][j];
            }
        }

       return  sum;
    }



    @Test
    public  void  test(){
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3}, {0,3,1,0}};
        int result = maxIncreaseKeepingSkyline(grid);

        System.out.println("result : " + result);
    }
}
