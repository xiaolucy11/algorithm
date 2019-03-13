package interview.easy2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/11 0011.
 */

public class Solution463 {
    public int islandPerimeter(int[][] grid){
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int perimeter = 0, haveIsland = 0;
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < columnLength; j++){
                if(grid[i][j] == 1){
                    haveIsland = 0;
                    if((i-1 >= 0) && (grid[i-1][j] == 1) ){ haveIsland++;}
                    if((i+1 < rowLength) && (grid[i+1][j] == 1)){haveIsland++;}
                    if((j - 1 >= 0) && (grid[i][j-1] == 1)){haveIsland++;}
                    if((j+1 < columnLength) && (grid[i][j+1] == 1)){haveIsland++;}
                    perimeter += 4 - haveIsland;
                    }
                }
            }
            return  perimeter;
        }



    @Test
    public  void t000000000000est(){
        int[][] grid = {{1,0}};
        System.out.print(islandPerimeter(grid));
    }
}
