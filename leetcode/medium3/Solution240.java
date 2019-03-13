package algorithm.medium3;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/13.
 */
public class Solution240 {
    //Accepted ----- 12ms
    /*
        similar to binary search. continue to decrease the scope of searching
     */
    public boolean searchMatrix(int[][] matrix, int target){
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

       int row = 0, col = colLength - 1;

        while ((row < rowLength) && (col >= 0)){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                row++;
            }else {
                col--;
            }
        }

        return false;
    }

    @Test
    public void  test(){
        int[][] matrix = {{1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
        int target = 20;
        System.out.print(searchMatrix(matrix, target));
    }
}
