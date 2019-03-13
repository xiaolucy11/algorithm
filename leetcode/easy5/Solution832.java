package interview.easy5;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/4 0004.
 */
public class Solution832 {
    public void  flipImage(int[][] A, int row){
        int colLength = A[row].length;
        int left = 0, right = colLength - 1;
        while (left < right){
            int temp = A[row][left];
            A[row][left] = A[row][right];
            A[row][right] = temp;
            left++;
            right--;
        }
    }

    //Accepted   ------4ms
    public  void  invertImage(int[][] A, int row){
        int colLength = A[row].length;
        for(int i = 0; i < colLength; i++){
            if(A[row][i] == 1){
                A[row][i] = 0;
            }else {
                A[row][i] = 1;
            }
        }
    }
    public  int[][] flipAndInvertImage(int[][] A){
        int rowLength = A.length;
        for(int i = 0; i < rowLength; i++){
            flipImage(A, i);
            invertImage(A, i);
        }
        return  A;
    }

    @Test
    public  void  test(){
        int[][] A = {{1,1,0,0},{1,0,0,1}, {0,1,1,1},{1,0,1,0}};
        int[][] result = flipAndInvertImage(A);
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
