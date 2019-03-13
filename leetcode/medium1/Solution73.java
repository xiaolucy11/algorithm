package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/13 0013.
 */
public class Solution73 {

    public boolean checkZeroInRow(int[][] matrix, int row){
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[row][i] == 0){
                return  true;
            }
        }

        return  false;
    }

    public  boolean checkZeroInCol(int[][] matrix, int col){
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][col] == 0){
                return  true;
            }
        }

        return  false;
    }

    public  void  setZeroes(int[][] matrix){
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        for(int i = 0; i < rowLength; i++){
            if(!checkZeroInRow(matrix, i)){
                for(int j = 0; j < colLength; j++){
                    if(checkZeroInRow(matrix, j)){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        for(int j = 0; j < colLength; j++){
            if(!checkZeroInCol(matrix, j)){
                for(int i = 0; i < rowLength; i++){
                    if(checkZeroInRow(matrix, i)){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    @Test
    public  void  test(){
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        setZeroes(matrix);

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + "  ");
            }

            System.out.println(" ");
        }
    }
}
