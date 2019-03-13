package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/1 0001.
 */
public class Solution766 {

    //Accepted --- 24ms
    public  boolean isToeplitzMatrix(int[][] matrix){
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[][] flagMatrix = new int[rowLength][colLength];

        for(int i = 0; i < rowLength; i++){
            for (int j = 0; j < colLength; j++){
                if(flagMatrix[i][j] == 0){
                    flagMatrix[i][j] = 1;
                    int index = 1;
                    while((i + index < rowLength) && (j + index < colLength)){
                        if(matrix[i + index][j + index] == matrix[i][j]){
                            flagMatrix[i + index][j + index] = 1;
                            index++;
                        }else {
                            return  false;
                        }
                    }
                }
            }
        }

        return  true;
    }

    @Test
    public  void  test(){
        int[][] matrix = {{1,2}, {2,2}};
        System.out.print(isToeplitzMatrix(matrix));
    }
}
