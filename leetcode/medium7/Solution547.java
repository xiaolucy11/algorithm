package algorithm.medium7;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/19.
 */
public class Solution547 {
    public void search(int[][] M, int row, int col){
        M[row][col] = 0;
        for(int j = 0; j < M.length; j++){
            if(M[row][j] == 1){
                   M[row][j] = 0;
                    search(M, j, row);
            }
        }

    }


    //Accepted -----12ms
    public  int findCircleNum(int[][] M){
        int count = 0;
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M.length; j++){
                if(M[i][j] == 1){
                    count++;
                    search(M,i,j);
                }
            }
        }

        return  count;
    }


    @Test
    public  void  test(){
//        int[][] M = {{1,1,0},{1,1,0},{0,0,1}};
//        int[][] M = {{1,1,0},{1,1,1},{0,1,1}};
        int[][] M = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};

        long startTime = System.currentTimeMillis();
        int result = findCircleNum(M);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
