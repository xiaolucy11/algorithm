package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
public class Solution661 {
    //Accepted -------17ms
    public  int[][] imageSmoother(int[][] M){
        int rowLength = M.length;
        int colLength = M[0].length;
        int[][] result = new int[rowLength][colLength];
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                int count = 1;
                int sum = M[i][j];
                if(i-1 >= 0){
                    count++;
                    sum += M[i-1][j];
                    if(j - 1 >= 0){
                        count++;
                        sum += M[i-1][j-1];
                    }
                    if(j + 1 < colLength){
                        count++;
                        sum += M[i-1][j+1];
                    }
                }
                if(i + 1 < rowLength){
                    count++;
                    sum += M[i+1][j];
                    if(j - 1 >= 0){
                        count++;
                        sum += M[i+1][j-1];
                    }
                    if(j + 1 < colLength){
                        count++;
                        sum += M[i+1][j+1];
                    }
                }
                if(j - 1 >= 0){
                    count++;
                    sum += M[i][j-1];
                }
                if(j + 1 < colLength){
                    count++;
                    sum += M[i][j+1];
                }
                result[i][j] = sum / count;
            }
        }
        return  result;
    }

    @Test
    public  void  test(){
        int[][] m = {{1,1,1}, {1,0,1},{1,1,1}};
        int[][] result = imageSmoother(m);
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
