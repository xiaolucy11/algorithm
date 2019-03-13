package algorithm.medium5;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/3.
 */
public class Solution419 {
    public class Point{
        int x;
        int y;
        Point(int _x, int _y){
            this.x = _x;
            this.y = _y;
        }
    }

    public  boolean check(Point startPoint, Point endPoint, int row, int col){
        if(startPoint.x == endPoint.x){
            if((startPoint.x == row) && (col >= startPoint.y && col <= endPoint.y)){
                return  true;
            }else {
                return  false;
            }
        }else {
            if(col == startPoint.y && row >= startPoint.x && row <= endPoint.x){
                return  true;
            }else {
                return  false;
            }
        }
    }

    //Wrong solution
    public  int countBattleships(char[][] board){
        int rowLength = board.length;
        int colLength = board[0].length;
        int battleshipsCount = 0;

        int rowIndex = 0, colIndex = 0;
            while ((rowIndex < rowLength) && (colIndex < colLength)){
                if(board[rowIndex][colIndex] == 'X'){
                        int left = colIndex, right = colIndex;
                        int up = rowIndex, down = rowIndex;
                        while ((left >= 0) && (board[rowIndex][left] == 'X')){
                            left--;
                        }
                        while ((right < board[0].length) && (board[rowIndex][right] == 'X')){
                            right++;
                        }

                        while ((up >= 0) && (board[up][colIndex] == 'X')){
                            up--;
                        }
                        while ((down < board.length) && (board[down][colIndex] == 'X')){
                            down++;
                        }

                        if(right - left > down - up){
                           colIndex = right;
                           if(colIndex == colLength){
                               colIndex = 0;
                               rowIndex++;
                           }
                        }else {
                           rowIndex = down;
                            if(rowIndex == rowLength){
                                rowIndex = 0;
                                colIndex++;
                            }
                        }

                        battleshipsCount++;
                }else {
                    colIndex++;
                    if(colIndex == colLength){
                        colIndex = 0;
                        rowIndex++;
                    }
                }
            }


        return  battleshipsCount;
    }

    //Accepte -----4ms
    /*
        one pass
        space complexity O(1)
     */
    public  int countBattleships1(char[][] board){
        int rowLength = board.length;
        int colLength = board[0].length;
        int battleshipsCount = 0;

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(board[i][j] == 'X'){
                    if(!((i - 1 >= 0 && board[i-1][j] == 'X') ||
                            (j - 1 >= 0 && board[i][j-1] == 'X'))){
                        battleshipsCount++;
                    }
                }
            }
        }
        return  battleshipsCount;
    }


    @Test
    public  void  test(){
        char[][] board = {{'X','.','.','X'},
                            {'.','.','.','X'},
                            {'.','.','.','X'}};
      /*  char[][] board = {{'X','.','X'},
                {'X','.','X'}};*/
       /*char[][] board = {{'.','X'},{'X','.'}};*/
        long startTime = System.currentTimeMillis();
        int result = countBattleships1(board);
        long endTime = System.currentTimeMillis();
        System.out.println("result = " + result);
        System.out.println("running time : " + (endTime - startTime));
    }

}
