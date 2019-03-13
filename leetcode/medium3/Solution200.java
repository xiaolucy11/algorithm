package interview.medium3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/9/9 0009.
 */
public class Solution200 {
    public  void  search(char[][] grid, int row, int col){
        grid[row][col] = '0';
        if(row - 1 >= 0 && grid[row-1][col] == '1'){
            search(grid, row-1, col);
        }

        if(row + 1 < grid.length && grid[row+1][col] == '1'){
            search(grid, row+1, col);
        }

        if(col - 1 >= 0 && grid[row][col-1] == '1'){
            search(grid, row, col-1);
        }

        if(col+1 < grid[0].length && grid[row][col+1] == '1'){
            search(grid, row, col+1);
        }

    }

    //Accepted ------4ms
    public int numIslands(char[][] grid){
        if(grid.length == 0){
            return  0;
        }
        int count = 0;
        int rowLength = grid.length;
        int colLenght = grid[0].length;

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLenght; j++){
                if(grid[i][j] == '1'){
                    count++;
                    search(grid, i, j);
                }
            }
        }
        return count;
    }

    @Test
    public  void  test(){
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.print(numIslands(grid));
    }
}
