package algorithm.medium8;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by youlu on 2018/10/31.
 */
public class Solution688 {
    public  double totalCount;
    public  double inBoardCount;

    public void  move(int N, int K, int row, int col){
        if(K == 0){
            if(row >= 0 && row < N && col >= 0 && col < N){
                totalCount++;
                inBoardCount++;
            }else {
                totalCount++;
            }
            return;
        }

        if(row < 0 || row >= N || col < 0 || col >= N){
            totalCount++;
            return;
        }
        move(N, K-1,row - 2, col - 1);
        move(N, K-1, row - 2,col+1);
        move(N, K-1,row+2, col - 1);
        move(N, K-1, row+2, col + 1);

        move(N, K-1, row - 1,col - 2);
        move(N, K-1, row - 1, col + 2);
        move(N, K-1, row+1, col - 2);
        move(N, K-1, row+1, col+2);
    }
    public  double knightProbability(int N, int K, int r, int c){
        totalCount = 0;
        inBoardCount = 0;

        move(N, K, r, c);
        return inBoardCount / totalCount;
    }

    public  void check(double[][][] matrix ,int K, int row, int col, int k){
        if(K == k){
            return ;
        }
        //row -2, col-1
        if((row - 2 >= 0) && (col - 1 >= 0) ){
            matrix[row -2][col - 1][k+1] += (1.0/ 8) * matrix[row][col][k];
        }
        //row - 2, col+1
        if((row - 2 >=0) && (col + 1 < matrix.length)){
           matrix[row-2][col+1][k+1] += (1.0/ 8) * matrix[row][col][k];
        }

        //row +2, col - 1
        if((row + 2 < matrix.length) && (col - 1 >= 0)){
            matrix[row+2][col-1][k+1] += (1.0/ 8) * matrix[row][col][k];
        }

        //row + 2, col + 1
        if((row + 2 < matrix.length) && (col + 1 < matrix.length)){
            matrix[row+2][col+1][k+1] += (1.0/ 8) * matrix[row][col][k];
        }

        // row - 1, col -2
        if((row - 1 >= 0) && (col - 2 >= 0) ){
            matrix[row-1][col-2][k+1] += (1.0/ 8) * matrix[row][col][k];
        }

        // row-1, col+2
        if((row - 1 >= 0) && (col + 2 < matrix.length)){
           matrix[row-1][col+2][k+1] += (1.0/ 8) * matrix[row][col][k];
        }

        //row + 1, col-2
        if((row + 1 < matrix.length) && (col-2 >= 0)){
            matrix[row+1][col-2][k+1] += (1.0/ 8) * matrix[row][col][k];
        }

        //row + 1, col+2
        if((row + 1 < matrix.length) && (col+ 2 < matrix.length)){
            matrix[row+1][col+2][k+1] += (1.0/ 8) * matrix[row][col][k];
        }

    }

    public  class  Fraction{
        int x;
        int y;
        Fraction(int _x, int _y){
            x = _x;
            y = _y;
        }

    }


    //Accepted -----6ms
    /*
        dp algorithm
        time complexity O(n*n*K)
     */
    public  double knightProbability1(int N, int K, int r, int c){
        double[][][] matrix = new double[N][N][K+1];

        matrix[r][c][0] = 1;
        for(int k = 0; k <= K ; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                  if(matrix[i][j][k] != 0){
                      check(matrix,K, i,j,k);
                  }
                }
            }
        }

        double count = 0.0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(matrix[i][j][K] != 0){
                    count += matrix[i][j][K];
                }
            }
        }

        return  count;
    }

    @Test
    public  void  test(){
        int N = 3;
        int K = 4;
        int r = 0;
        int c = 0;

        long startTime = System.currentTimeMillis();
        double result = knightProbability1(N,K,r,c);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
