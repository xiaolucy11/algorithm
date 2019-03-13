package interview.easy5;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/7 0007.
 */
public class Solution877 {
    //Accepted -------6ms
    public  int projectionArea(int[][] grid){
        int rowLength = grid.length;
        int colLength = grid[0].length;

        int[] arr1 = new int[colLength];
        int[] arr2 = new int[rowLength];
        int count = 0;
        for(int i = 0; i < rowLength; i++){
            int maxValue = 0;
            for(int j = 0; j < colLength; j++){
                if(grid[i][j] > arr1[j]){
                    arr1[j] = grid[i][j];
                }
                if(grid[i][j] > maxValue){
                    maxValue = grid[i][j];
                }
                if(grid[i][j] != 0){
                    count++;
                }
            }
            arr2[i] = maxValue;
        }
        int sum = count;
        for(int i = 0; i < colLength; i++){
            sum += arr1[i];
        }
        for(int i = 0; i < rowLength; i++){
            sum += arr2[i];
        }

        return  sum;
    }

    @Test
    public  void  test(){
        int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.print(projectionArea(grid));
    }
}
