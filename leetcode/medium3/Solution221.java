package interview.medium3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/9/11 0011.
 */
public class Solution221 {
    public  boolean isSquare(char[][] matrix, int row, int col, int length){
        for(int i = row; i < row + length; i++){
            for(int j = col; j < col + length; j++){
                if(matrix[i][j] != '1'){
                    return false;
                }
            }
        }

        return  true;
    }


    public int maxSquare(char[][] matrix, int row, int col){
        int rowIndex = row;
        int colIndex = col;
        while ((colIndex < matrix[0].length) && (matrix[row][colIndex] == '1')){
            colIndex++;
        }

        while ((rowIndex < matrix.length) && (matrix[rowIndex][col]== '1')){
            rowIndex++;
        }

        int leftLenght = colIndex - col;
        int downLength = rowIndex - row;
        int len = Math.min(leftLenght, downLength);

        while (len > 0){
            if(isSquare(matrix, row, col, len)){
                break;
            }else {
                len--;
            }
        }
       /* for(int i = row; i < row + len; i++){
            for(int j = col; j < col + len; j++){
                matrix[i][j] = '0';
            }
        }*/
        return  len;
    }

    //Accepted -----13ms
    /*
        brute solution
     */
    public  int maximalSquare(char[][] matrix){
        if(matrix.length == 0){
            return 0;
        }
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int maxSquare = 0;
        for(int i = 0; i < rowLength; i++){
            for(int j  = 0; j < colLength; j++){
                if(matrix[i][j] == '1'){
                    int square = maxSquare(matrix, i,j);
                    if(square > maxSquare){
                        maxSquare = square;
                    }
                }
            }
        }
        return  maxSquare * maxSquare;
    }


    //Accepted -----9ms
    /*
        dp
        part reference from other
     */
    public  int maximalSquare1(char[][] matrix){
        if(matrix.length == 0){
            return 0;
        }
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int[][] dp = new int[rowLength][colLength];

        int maxValue = 0;
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(matrix[i][j] == '1'){
                    if(i-1 >= 0 && j - 1 >= 0 && dp[i-1][j-1] > 0){
                        int value = Math.min(dp[i][j-1],dp[i-1][j]);
                        dp[i][j] = Math.min(dp[i-1][j-1],value) + 1;
                    }else {
                        dp[i][j] = 1;
                    }

                    if(dp[i][j] > maxValue){
                        maxValue = dp[i][j];
                        // System.out.println("i = " + i + "  j  = " + j + " maxValue == " + maxValue);
                    }
                }
            }
        }
        return maxValue * maxValue;
    }

    @Test
    public  void  test() {
       char[][] matrix = {{'1','0','1','0','0','1','1','1','0'},
        {'1','1','1','0','0','0','0','0','1'},
        {'0','0','1','1','0','0','0','1','1'},
        {'0','1','1','0','0','1','0','0','1'},
        {'1','1','0','1','1','0','0','1','0'},
        {'0','1','1','1','1','1','1','0','1'},
        {'1','0','1','1','1','0','0','1','0'},
        {'1','1','1','0','1','0','0','0','1'},
        {'0','1','1','1','1','0','0','1','0'},
        {'1','0','0','1','1','1','0','0','0'}};
       //char[][] matrix  = {{'1'}};

        int result = maximalSquare1(matrix);
        System.out.print(result);
    }
}
