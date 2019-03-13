package interview.easy4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/27 0027.
 */
public class Solution695 {
    public  class  Point{
        int x;
        int y;
        Point(int _x, int _y){
            x = _x;
            y = _y;
        }
    }
    public  boolean find(List<Point> list, Point p){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).x == p.x && list.get(i).y == p.y){
                return  true;
            }
        }
        return  false;
    }

    public  int search(int[][] grid, int row, int col, List<Point> path){
        if(row < 0 || row >= grid.length || col > grid[0].length || col < 0){
            return  0;
        }
        if(grid[row][col] == 0){
            return  0;
        }
        int count = 1;
        path.add(new Point(row , col));
        if(row - 1 >= 0 && grid[row-1][col] == 1 && !find(path, new Point(row - 1, col))){
            path.add(new Point(row , col));
            count += search(grid, row-1, col, path) ;

        }
        if(row + 1 < grid.length && grid[row+1][col] == 1 && !find(path, new Point(row + 1, col))){
            path.add(new Point(row , col));
            count += search(grid, row+1, col, path);

        }
        if(col - 1 >=0 && grid[row][col-1] == 1 && !find(path, new Point(row, col - 1))){
            path.add(new Point(row, col));
            count += search(grid, row, col-1, path);

        }
        if(col + 1 < grid[0].length && grid[row][col+1] == 1 && !find(path, new Point(row, col + 1))){
            path.add(new Point(row, col));
            count += search(grid, row, col+1, path);

        }
        return  count;

    }
    public  boolean allEqualToOne(int[][] grid){
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(grid[i][j] != grid[0][0]){
                    return false;
                }
            }
        }
        return  true;
    }


    //Accepted ------416ms
    //normal solution
    public  int maxAreaOfIsland(int[][] grid){
        int rowLength = grid.length;
        int colLength = grid[0].length;
        if(allEqualToOne(grid)){
            return  rowLength * colLength;
        }
        int result = 0;
        List<Point> longestPath = new ArrayList<>();
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(grid[i][j] == 1 && !find(longestPath, new Point(i,j))){
                    List<Point> path = new ArrayList<>();
                    int square = search(grid, i, j, path);
                    System.out.println("i : " + i + "  j: " + j + " " + square + " ");
                    if(square > result){
                      result = square;
                        longestPath = path;
                    }
                }
            }
        }
        return  result;
    }

    /*
    *  greate solution from web, using the operation grid[i][j] = 0 when dfs
    * */

    @Test
    public  void  test(){
       /* int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};*/

       int[][] grid = {{1,1,0,0,0},
               {1,1,0,0,0},
               {0,0,0,1,1},
               {0,0,0,1,1}};
        List<Point> path = new ArrayList<>();
        System.out.print(search(grid,0,0, path ));
        //System.out.print(maxAreaOfIsland(grid));
    }
}
