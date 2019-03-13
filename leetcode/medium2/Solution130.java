package interview.medium2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/9/3 0003.
 */
public class Solution130 {
    //Wrong
    public  boolean isConnectToBound(char[][] board, int row, int col){
        if(row == 0 || row == board.length-1 || col == 0 || col == board[0].length-1){
            return  true;
        }

        if(row - 1 >= 0 && board[row-1][col] == 'O'){
            if(isConnectToBound(board, row-1, col)){
                return  true;
            }
        }

        if(row+1 < board.length && board[row+1][col] == 'O' ){
            if(isConnectToBound(board, row+1, col)){
                return true;
            }
        }

        if(col - 1 >= 0 && board[row][col] == 'O'){
            if(isConnectToBound(board, row, col-1)){
                return  true;
            }
        }

        if(col + 1 < board[0].length && board[row][col+1] == 'O'){
            if(isConnectToBound(board, row, col+1)){
                return  true;
            }
        }
        return  false;
    }

    public  void  set(char[][] board, int row, int col){
        if( row == 0 || row == board.length - 1 || col == 0 ||
                col == board[0].length - 1 || board[row][col] == 'O'){
            board[row][col] = 'A';
            if(row - 1 >= 0 && board[row-1][col] == 'O'){
                set(board, row-1, col);
            }

            if(row+1 < board.length && board[row+1][col] == 'O'){
                set(board, row+1, col);
            }

            if(col - 1 >= 0 && board[row][col-1] == 'O'){
                set(board, row, col-1);
            }

            if(col + 1 < board[0].length && board[row][col+1] == 'O'){
                set(board, row, col+1);
            }
        }
    }


    //Accepted -------5ms
    public  void  solve(char[][] board){
        int rowLength = board.length;
        int colLength = board[0].length;

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(board[i][j] == 'O' &&
                        ( i == 0 || i == board.length - 1 || j == 0 ||
                                j == board[0].length - 1)){
                    set(board, i, j);
                    }
                }
            }

            for(int i = 0; i < rowLength; i++){
                for(int j = 0; j < colLength; j++){
                    if(board[i][j] == 'A'){
                        board[i][j] = 'O';
                        continue;
                    }
                    if(board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }
                }
            }
    }


    @Test
    public  void  test(){
        char[][] board = {{'O', 'X', 'X','O', 'X'},
                {'X', 'O', 'O', 'X','O'},
                {'X', 'O', 'X', 'O','X'},
                {'O','X', 'O', 'O','O'},
                {'X', 'X', 'O', 'X', 'O'}};
        solve(board);
        int rowLength = board.length;
        int colLength = board[0].length;

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
