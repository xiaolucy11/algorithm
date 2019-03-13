package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/10 0010.
 */
public class Solution36 {
    private  int[] arr = new int[10];

    public void  init(){
        for(int i = 0; i < 10; i++){
            arr[i] = 0;
        }
    }

    public  boolean checkArr(){
        int count = 0;
        for (int i = 1; i < 10; i++){
            if(arr[i] > 1){
                return  false;
            }
        }
        return  true;
    }
    public  boolean checkRow(char[][] board, int row){
        init();
        int value = 0;
        for(int i = 0; i < 9; i++){
            if(board[row][i] != '.') {
                value = (int) (board[row][i] - '0');
                arr[value]++;
            }
        }
      boolean b =  checkArr();
        if(!b){
            System.out.println("row : " + row + "    invalid");
            return false;
        }else {
            return  true;
        }
    }

    public  boolean checkCol(char[][] board, int col){
       init();
        int value = 0;
        for(int i = 0; i < 9; i++){
            if(board[i][col] != '.') {
                value = (int) (board[i][col] - '0');
                arr[value]++;
            }
        }

        boolean b =  checkArr();
        if(!b){
            System.out.println("col : " + col + "   invalid");
            return false;
        }else {
            return  true;
        }

    }

    public  boolean checkSubBoard(char[][] board, int row, int col){
        init();
        int value = 0;
        for(int i = row; i < row + 3; i++){
            for(int j = col; j < col + 3; j++){
                if(board[i][j] != '.'){
                    value = (int)(board[i][j] - '0');
                    arr[value]++;
                }
            }
        }
        boolean b =  checkArr();
        if(!b){
            System.out.println("row : " + row + ":  col :  " + col +  "  invalid");
            return false;
        }else {
            return  true;
        }
    }

    //Accepted -----24ms
    public boolean isValidSudoku(char[][] board){
        for(int i = 0; i < 9; i++){
            if(!checkRow(board,i) || !checkCol(board, i)){
                return  false;
            }
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(i % 3 == 0 && j % 3 == 0){
                    if(!checkSubBoard(board, i, j)){
                        return  false;
                    }
                }
            }
        }
        return  true;
    }

    @Test
    public  void  test(){
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
    };
    System.out.print(isValidSudoku(board));
    }
}
