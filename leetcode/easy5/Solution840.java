package interview.easy5;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/4 0004.
 */
public class Solution840 {
    public  boolean isBetween1And9(int[][] grid, int row, int col){
        int[] arr = new int[16];
        for(int i = row; i < row + 3; i++){
            for(int j = col; j < col + 3; j++){
                arr[grid[i][j] ] = 1;
            }
        }

        for(int i = 1; i <= 9; i++){
            if(arr[i] !=  1){
                return  false;
            }
        }
        return  true;
    }

    public  boolean isMagicSquare(int[][] grid, int row, int col){
        if(!isBetween1And9(grid, row, col)){
            return  false;
        }
        int value1 = grid[row][col] + grid[row][col+1] + grid[row][col+2];
        int value2 = grid[row+1][col] + grid[row+1][col+1] + grid[row + 1][col + 2];
        int value3 = grid[row + 2][col] + grid[row+2][col+1] + grid[row+2][col+2];

        int value4 = grid[row][col] + grid[row + 1][col] + grid[row+2][col];
        int value5 = grid[row][col+1] + grid[row+1][col+1] + grid[row+2][col+1];
        int value6= grid[row][col+2] + grid[row+1][col+2] + grid[row+2][col+2];

        int value7 = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2];
        int value8 = grid[row][col+2] + grid[row + 1][col+1] + grid[row+2][col];

        if((value1 == value2) && (value1 == value3) && (value1 == value4) && (value1 == value5)
                && (value1 == value6) && (value1 == value7) && (value1 == value8)){
            return  true;
        }else {
            return  false;
        }
    }

    //Accepted ------4ms
    public  int numMagicSquaresInside(int[][] grid){
        int count = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        for(int i = 0; i + 2 < rowLength; i++){
            for(int j = 0; j + 2 < colLength; j++){
                if (isMagicSquare(grid, i, j)){
                    System.out.println("i : " + i + " j :" + j);
                    count++;
                }
            }
        }
        return  count;
    }

    @Test
    public void  test(){
        int[][] grid  = {{7,0,5},{2,4,6},{3,8,1}};
        System.out.print(numMagicSquaresInside(grid));
    }
}
