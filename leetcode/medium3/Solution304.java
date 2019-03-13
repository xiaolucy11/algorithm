package algorithm.medium3;

/**
 * Created by youlu on 2018/9/15.
 */


public class Solution304 {
    private int[][] myMatrix;
    private int[][] result;
    /*
    public Solution304(int[][] myMatrix) {
        this.myMatrix = myMatrix;
        if(myMatrix.length != 0) {
            int rowLength = myMatrix.length;
            int colLength = myMatrix[0].length;
            result = new int[rowLength][colLength];
            for (int i = 0; i < rowLength; i++) {
                result[i][0] = myMatrix[i][0];
                for (int j = 1; j < colLength; j++) {
                    result[i][j] = result[i][j - 1] + myMatrix[i][j];
                }
            }
        }
    }*/

    public Solution304(int[][] matrix) {
        if (matrix.length != 0) {
            int rowLenght = matrix.length;
            int colLength = matrix[0].length;
            myMatrix = new int[rowLenght][colLength];

           for(int i = 0; i < rowLenght; i++){
               for(int j = 0; j < colLength; j++){
                   int rowIndex = i;
                   int sum = 0;
                   while (rowIndex >= 0){
                       sum += matrix[rowIndex][j];
                       rowIndex--;
                   }
                   if(j == 0){
                       myMatrix[i][j] = sum;
                   }else {
                       myMatrix[i][j] = myMatrix[i][j-1] + sum;
                   }
               }
           }
        }
    }

    //Accpeted ------113ms
    public  int sumRegion(int row1, int col1, int row2, int col2){
        if(myMatrix.length == 0){
            return 0;
        }
        int sum = 0;
        for(int i = row1; i <= row2; i++){
            if(col1 > 0) {
                sum += (result[i][col2] - result[i][col1 - 1]);
            }else {
                sum += result[i][col2];
            }
        }
        return sum;
    }

    //Accepted ----149ms
    /*
        it can be optimized.
        when inited, using matrix[i-1][j] matrix[i][j-1], matrix[i-1][j-1], rather than loop.
     */
    public  int sumRegion1(int row1, int col1, int row2, int col2){
        if(myMatrix.length == 0){
            return 0;
        }

        if(row1 == 0){
            if(col1 > 0){
                return  myMatrix[row2][col2] - myMatrix[row2][col1-1];
            } else {
                return  myMatrix[row2][col2];
            }
        }else {
            if(col1 > 0){
                return myMatrix[row2][col2] - myMatrix[row1-1][col2] -
                        myMatrix[row2][col1 - 1] + myMatrix[row1-1][col1 - 1];
            }else {
                return myMatrix[row2][col2] - myMatrix[row1-1][col2];
            }
        }
    }

    public static  void  main(String[] args){
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},
                {1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        Solution304 s = new Solution304(matrix);
        int row1 = 1;
        int col = 2;
        int row2 = 2;
        int col2 = 4;
        int result = s.sumRegion1(row1, col, row2, col2);
        System.out.print(result);
    }
}
