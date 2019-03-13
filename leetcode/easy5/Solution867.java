package interview.easy5;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/6 0006.
 */
public class Solution867 {
    //Accepted ---3ms
    public  int[][] transpose(int[][] A){
        int rowLength = A.length;
        int colLength = A[0].length;
        int[][] result = new int[colLength][rowLength];

        for(int i = 0; i < colLength; i++){
            for(int j = 0; j < rowLength; j++){
                result[i][j] = A[j][i];
            }
        }

        return  result;
    }

    @Test
    public  void  test(){
        int[][] A = {{1,2,3},{4,5,6}};
        int[][] result = transpose(A);
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
