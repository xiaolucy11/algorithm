package algorithm.medium7;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/18.
 */
public class Solution542 {

    public  void  leftUpSearch(int[][] matrix, int[][] result, int row, int col, int distance){
        if(matrix[row][col] == 0){
            return;
        }
        if(distance < result[row][col]) {
            result[row][col] = distance;
        }


            if (row - 1 >= 0) {
                leftUpSearch(matrix, result, row - 1, col, distance + 1);
            }
            if (col - 1 >= 0) {
                leftUpSearch(matrix, result, row, col - 1, distance + 1);
            }

    }

    public  void  rightUpSearch(int[][] matrix, int[][] result, int row, int col, int distance){
        if(matrix[row][col] == 0){
            return;
        }
        if(distance < result[row][col]) {
            result[row][col] = distance;
        }

            if (row - 1 >= 0) {
                rightUpSearch(matrix, result, row - 1, col, distance + 1);
            }
            if (col + 1 < matrix[0].length) {
                rightUpSearch(matrix, result, row, col + 1, distance + 1);
            }

    }

    public  void  leftDownSearch(int[][] matrix, int[][] result , int row, int col, int distance) {
        if (matrix[row][col] == 0) {
            return;
        }
        if (distance < result[row][col]) {
            result[row][col] = distance;
        }

            if (row + 1 < matrix.length) {
            leftDownSearch(matrix, result, row + 1, col, distance + 1);
         }
            if (col - 1 >= 0) {
            leftDownSearch(matrix, result, row, col - 1, distance + 1);
            }

    }


    public  void  rightDownSearch(int[][] matrix, int[][] result, int row, int col, int distance){
        if(matrix[row][col] == 0){
            return;
        }
        if(distance < result[row][col]) {
            result[row][col] = distance;
        }

            if(col + 1 < matrix[0].length){
                rightDownSearch(matrix, result, row, col+1, distance+1);
            }
            if(row +1 < matrix.length){
                rightDownSearch(matrix, result, row+1, col, distance+1);
            }


    }


    //Time Limit exceed
    public  int[][] updateMatrix(int[][] matrix){
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[][] result = new int[rowLength][colLength];

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(matrix[i][j] == 0){
                    result[i][j] = 0;
                    if(i - 1 >= 0){
                        leftUpSearch(matrix, result, i-1, j, 1);
                        rightUpSearch(matrix, result, i-1,j,1);
                    }

                    if( i + 1 < matrix.length){
                        leftDownSearch(matrix, result, i+1,j, 1);
                        rightDownSearch(matrix, result,i+1, j,1);
                    }

                    if(j - 1 >= 0){
                        leftUpSearch(matrix,result,i,j-1,1);
                        leftDownSearch(matrix,result,i,j-1,1);
                    }

                    if(j +1 < matrix[0].length){
                        rightDownSearch(matrix,result,i,j+1,1);
                        rightUpSearch(matrix, result,i,j+1,1);
                    }
                }
            }
        }

        return  result;
    }


    //Accepted -----15ms
    /*
        level order travesal
        time complexity O(m * n * (m + n))
     */
    public  int[][] updateMatrix1(int[][] matrix){
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[][] result = new int[rowLength][colLength];
        int circleCount = rowLength + colLength;

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(matrix[i][j] != 0) {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int circle = 0;
        while (circle <= circleCount){
            int count = 0;
            for(int i = 0; i < rowLength; i++){
                for(int j = 0; j < colLength; j++){
                    if(result[i][j] == circle){
                        count++;

                        //up
                        if(i - 1 >= 0 && result[i-1][j] == Integer.MAX_VALUE){
                            result[i-1][j] = result[i][j] + 1;
                        }

                        //down
                        if(i+1 < rowLength && result[i+1][j] == Integer.MAX_VALUE){
                            result[i+1][j]= result[i][j]+1;
                        }

                        //left
                        if(j - 1 >= 0 && result[i][j-1] == Integer.MAX_VALUE){
                            result[i][j-1] = result[i][j] + 1;
                        }

                        //right
                        if(j+1 < colLength && result[i][j+1] == Integer.MAX_VALUE){
                            result[i][j+1] = result[i][j] + 1;
                        }
                    }
                }
            }
            if(count == 0){
                break;
            }
            circle++;
        }

        return result;

    }


    @Test
    public  void  test(){
        int[][] matrix = {{0,0,0},{0,1,0},{0,0,0}};
//        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
       /* int[][] matrix = {{0, 0, 1, 0, 1, 1, 1, 0, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                        { 0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
                            {1, 1, 1, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}};*/

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }

        System.out.println("----------------------------------------------------------------");
        long startTime = System.currentTimeMillis();
        int[][] result = updateMatrix1(matrix);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.length;i++){
            for(int j = 0; j < result[i].length;j++){
                System.out.print(result[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("running time :  " + (endTime - startTime));
    }
}
