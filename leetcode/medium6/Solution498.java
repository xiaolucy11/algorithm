package algorithm.medium6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/10/13.
 */
public class Solution498 {
    public  void  search(int[][] matrix, int row, int col, List<Integer> list, int direction){
        if((row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[0].length)) {
            list.add(matrix[row][col]);
        }else {
            return;
        }
       /* if(col == matrix[0].length - 1){
            if(row + 1 == matrix.length && direction == 1){
                return;
            }
        }
        if(row == matrix.length -1){
            if(direction == -1 && col + 1 >= matrix[0].length){
                return;
            }
        }*/

        if(direction == 1){
            if(row - 1 < 0 && col + 1 < matrix[0].length){
                search(matrix, row, col+1,list, -1);
            }else if(row - 1 >= 0 && col + 1 >= matrix[0].length){
                search(matrix, row+1, col,list,-1);
            }else if(row - 1 < 0 && col + 1 >= matrix[0].length){
                search(matrix, row +1, col, list, -1);
            } else {
                search(matrix,row-1, col+1, list, 1);
            }
        }else {
            if(col - 1 < 0 && row + 1 < matrix.length){
                search(matrix,row + 1, col, list,1);
            }else if(col - 1 >= 0 && row + 1 >= matrix.length) {
                search(matrix, row, col + 1, list, 1);
            }else if(col - 1 < 0 && row + 1 >= matrix.length) {
                search(matrix, row, col + 1, list, 1);
            } else {
                search(matrix, row +1, col -1, list, -1);
            }
        }
    }


    //Accepted -----13ms
    public  int[] findDiagonalOrder(int[][] matrix){
        if(matrix.length == 0){
            return  new int[0];
        }
        List<Integer> list = new ArrayList<>();
        search(matrix,0,0,list,1);
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }

        return  result;
    }

    @Test
    public  void  test(){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{2,3}};
//        int[][] matrix = {{1,2},{3,4}};
//       int[][] matrix = {{2,5},{8,4},{0,-1}};
        long startTime = System.currentTimeMillis();
        int[] result = findDiagonalOrder(matrix);
        long endTime = System.currentTimeMillis();
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }
}
