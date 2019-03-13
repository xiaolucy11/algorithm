package algorithm.medium3;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/15.
 */
public class Solution289 {
    public boolean isLive(int[][] board, int row, int col){
        if(board[row][col] == 1 || board[row][col] == 2 ||
                board[row][col] == 3){
            return true;
        }
        return  false;
    }

    public  int generate(int[][] board, int row,int col){
        int  liveCount = 0;
        if(row - 1 >= 0){
            if(isLive(board,row-1, col)){
                liveCount++;
            }

            if(col - 1 >= 0 ){
                if(isLive(board, row-1, col-1)){
                    liveCount++;
                }

            }
            if(col+1 < board[0].length){
                if(isLive(board,row-1,col+1)){
                    liveCount++;
                }

            }
        }

        if(col - 1 >= 0 && isLive(board, row, col-1)){
            liveCount++;
        }

        if(col+1 < board[0].length && isLive(board, row, col+1)){
            liveCount++;
        }
        if(row + 1 < board.length){
            if(col-1 >= 0){
                if(isLive(board, row+1, col-1)){
                    liveCount++;
                }
            }

            if(col+1 < board[0].length){
                if(isLive(board, row+1, col+1)){
                    liveCount++;
                }
            }

            if(isLive(board, row+1, col)){
                liveCount++;
            }
        }

        if((board[row][col] == 1) && (liveCount < 2)){
            return 1;
        }

        if((board[row][col] == 1) && (liveCount == 2 || liveCount == 3)){
            return  2;
        }

        if((board[row][col] == 1) && liveCount > 3){
            return 3;
        }

        if((board[row][col] == 0) && liveCount == 3){
            return 4;
        }

        return 0;
    }

    //Accepted -----3ms
    public  void  gameOfLife(int[][] board){
        int rowLength = board.length;
        int colLength = board[0].length;

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                int value = generate(board, i, j);
                board[i][j] = value;
            }
        }

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(board[i][j] == 1 || board[i][j] == 3){
                    board[i][j] = 0;
                }
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }

                if(board[i][j] == 4){
                    board[i][j] = 1;
                }
            }
        }
    }

    @Test
    public  void  test(){
        int[][] board = {{1,1},{1,0}};
        gameOfLife(board);

        int rowLength = board.length;
        int colLength = board[0].length;
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j <  colLength; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
