package algorithm.medium7;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/17.
 */
public class Solution529 {

    public  int adjacentMines(char[][] board, int row, int col){
        int count = 0;

        //left
        if(col - 1 >= 0 &&  board[row][col-1] == 'M') {
            count++;
        }

       //above
        if(row - 1 >= 0 && board[row - 1][col] == 'M'){
            count++;
        }

        //down
        if(row + 1 < board.length && board[row+1][col] == 'M'){
            count++;
        }

        //right
        if(col+1 < board[0].length && board[row][col+1] == 'M'){
            count++;
        }

        //left-above
        if(row-1 >= 0 && col-1 >=0 && board[row-1][col-1] == 'M'){
            count++;
        }

        //right-above
        if(row-1 >= 0 && col+1 < board[0].length && board[row-1][col+1] == 'M'){
            count++;
        }

        //left-down
        if(row+1 < board.length && col-1 >= 0 && board[row+1][col-1] == 'M'){
            count++;
        }

        //right-down
        if(row+1 < board.length && col+1 < board[0].length && board[row+1][col+1] == 'M'){
            count++;
        }
       return count;
    }


    public  void  search(char[][] board, int row, int col){
       if(adjacentMines(board, row, col) == 0){
           board[row][col] = 'B';
           //left
           if(col - 1 >= 0 &&  board[row][col-1] == 'E') {
               search(board,row,col-1);
           }

           //above
           if(row - 1 >= 0 && board[row - 1][col] == 'E'){
               search(board,row-1,col);
           }

           //down
           if(row + 1 < board.length && board[row+1][col] == 'E'){
              search(board,row+1, col);
           }

           //right
           if(col+1 < board[0].length && board[row][col+1] == 'E'){
               search(board,row,col+1);
           }

           //left-above
           if(row-1 >= 0 && col-1 >=0 && board[row-1][col-1] == 'E'){
               search(board,row-1,col-1);
           }

           //right-above
           if(row-1 >= 0 && col+1 < board[0].length && board[row-1][col+1] == 'E'){
               search(board,row-1, col+1);
           }

           //left-down
           if(row+1 < board.length && col-1 >= 0 && board[row+1][col-1] == 'E'){
               search(board,row+1, col-1);
           }

           //right-down
           if(row+1 < board.length && col+1 < board[0].length && board[row+1][col+1] == 'E'){
              search(board, row+1, col+1);
           }
       }else {
           board[row][col] = (char) (adjacentMines(board, row, col) + '0');
       }
    }

    //Accepted -----3ms
    public  char[][] updateBoard(char[][] board, int[] click){
        int row = click[0];
        int col = click[1];
        if(board[row][col] == 'M'){
            board[row][col] = 'X';
            return board;
        }

        if(adjacentMines(board, row,col) == 0){
            search(board, row,col);
        }else {
            board[row][col] = (char) (adjacentMines(board, row,col) + '0');
        }

        return  board;
    }


    @Test
    public  void  test(){
       /* char[][] board = {{'E','E','E','E','E'},
                {'E','E','M','E','E'},
                {'E','E','E','E','E'},
                {'E','E','E','E','E'}};
        int[] click = {3,0};*/
       char[][] board = {{'B','1','E','1','B'},
               {'B','1','M','1','B'},
               {'B','1','1','1','1','B'},
               {'B','B','B','B','B'}};
        int[] click = {1,2};


        long startTime = System.currentTimeMillis();
        char[][] result = updateBoard(board, click);
        long endTime = System.currentTimeMillis();
        for(int i = 0; i <result.length; i++){
            for(int j = 0; j < result[i].length; j++){
                System.out.print(result[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("running time : " + (endTime - startTime));
    }
}
