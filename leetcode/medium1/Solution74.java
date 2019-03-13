package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/14 0014.
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix.length == 0 || matrix[0].length == 0){return false;}
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        if(matrix[rowLength -1][colLength-1] < target || matrix[0][0] > target){
            return  false;
        }

        int row = 0;
        while (row < rowLength  ){
            if(matrix[row][colLength - 1] == target){
                return  true;
            }else  if(matrix[row][colLength-1] < target){
                row++;
            }else {
                break;
            }
        }
        for(int i = 0; i < colLength;i++){
            if(matrix[row][i] == target){
                return  true;
            }
        }
        return  false;
    }

    @Test
    public  void test(){
        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
        int target = 13;
        System.out.print(searchMatrix(matrix, target));
    }
}
