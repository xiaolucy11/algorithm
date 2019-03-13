package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/12 0012.
 */
public class Solution59 {
    public  void  move(int[][] matrix, int row, int col, int index){
        int length = matrix.length;
        if(index == length * length){
            return;
        }

        //move from left to right
        if((col - 1 >= 0) && (matrix[row][col - 1] == index - 1)){
            if((col + 1 >= length) || (matrix[row][col+1] != 0)){
                if((row + 1 >= length) || matrix[row + 1][col] != 0){
                    return;
                }
                matrix[row+1][col] = index + 1;
                move(matrix, row + 1, col, index + 1);
                return;
            }
            matrix[row][col+1] = index + 1;
            move(matrix,row, col+1,index+1);
        }else if((row - 1 >= 0) && (matrix[row-1][col] == index - 1)){
            if((row + 1 >= length) || (matrix[row + 1][col] != 0)){
                matrix[row][col-1] = index+1;
                move(matrix, row,col-1, index+1);
                return;
            }
            matrix[row + 1][col] = index + 1;
            move(matrix, row+1, col, index+1);
        }else if((col + 1 < length) && (matrix[row][col+1] == index - 1)){
            if((col - 1 < 0) || (matrix[row][col  - 1] != 0)){
                matrix[row - 1][col] = index+1;
                move(matrix, row-1, col, index+1);
                return;
            }
            matrix[row][col-1] = index+1;
            move(matrix, row, col-1, index+1);
        }else if((row + 1 < length) && (matrix[row+1][col] == index-1)){
            if((row - 1 <0) || (matrix[row-1][col] != 0)){
                matrix[row][col+1] = index+1;
                move(matrix, row, col+1, index+1);
                return;
            }
            matrix[row-1][col] = index+1;
            move(matrix, row-1, col, index+1);
        }else {
            return;
        }
    }

    //Accepted ----------1ms
    public  int[][] generateMatrix(int n){
        if(n == 1){
            int[][] m = new int[1][1];
            m[0][0] = 1;
            return  m;
        }
        int[][] matrix = new int[n][n];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        move(matrix, 0, 1, 2);
        return matrix;
    }

    @Test
    public  void  test(){
        int[][] matrix = generateMatrix(4);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println(" ");
        }
    }
}
