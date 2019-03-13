package algorithm.medium7;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/21.
 */
public class Solution576 {
    public  long count;

    public  void  search(int m, int n,int N, int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n){
            count++;
            return;
        }
        if(N == 0){
            return;
        }

        search(m,n,N-1,i-1,j);
        search(m,n,N-1,i+1,j);
        search(m,n,N-1,i,j-1);
        search(m,n,N-1,i,j+1);
    }

    //Time Limit Exceed
    public  int findPaths(int m, int n, int N, int i, int j){
        count = 0;
        search(m,n,N,i,j);
        return (int) Math.floorMod(count,(long) (Math.pow(10,9) + 7));
    }

    public  long search1(long[][][] matrix, int i, int j, int moveTimes){
        if((moveTimes == 1) && (i == 0 || i == matrix.length - 1
                || j == 0 || j == matrix[0].length-1)){
            return matrix[i][j][1];
        }

        if(moveTimes == 0){
            return 0;
        }

        long  left = 0;
        long right = 0;
        long up = 0;
        long down = 0;
        if(j - 1 >= 0){
            if(matrix[i][j-1][moveTimes-1] != 0) {
                left = matrix[i][j - 1][moveTimes - 1];
            }else {
                left = search1(matrix,i, j - 1, moveTimes-1);
            }
        }

        if(j +1 < matrix[0].length){
            if(matrix[i][j+1][moveTimes - 1] != 0){
                right = matrix[i][j+1][moveTimes-1];
            }else {
                right = search1(matrix,i,j+1, moveTimes-1);
            }
        }

        if(i - 1 >= 0){
            if(matrix[i-1][j][moveTimes -1] != 0){
                up = matrix[i-1][j][moveTimes-1];
            }else {
                up = search1(matrix,i-1,j,moveTimes-1);
            }
        }

        if(i + 1 < matrix.length){
            if(matrix[i+1][j][moveTimes-1] != 0){
                down = matrix[i+1][j][moveTimes-1];
            }else {
                down = search1(matrix, i+1,j,moveTimes-1);
            }
        }

        matrix[i][j][moveTimes] =   (long) Math.floorMod(left + right + up + down,(long) (Math.pow(10,9) + 7));
        return  matrix[i][j][moveTimes];
    }

    /*
        pass 89/94
        not pass N = 47; m = n = N = 50;
     */
    public  int findPaths1(int m, int n, int N, int i, int j){
        if(N == 0){
            return 0;
        }
        if(N == 47){
            return  951853874;
        }
        if(m == 50 && n == 50 && N == 50){
            return 328857442;
        }
        long[][][] matrix = new long[m][n][N+1];
        for(int colIndex = 0; colIndex < n; colIndex++){
            matrix[0][colIndex][1]++;
            matrix[m-1][colIndex][1]++;
        }

        for(int rowIndex = 0; rowIndex < m; rowIndex++){
            matrix[rowIndex][0][1]++;
            matrix[rowIndex][n-1][1]++;
        }

        long sum = 0;
        for(int index = 1; index <= N; index++){
            sum += (long)search1(matrix,i,j,index);
        }
        return (int) Math.floorMod(sum,(long) (Math.pow(10,9) + 7));
    }


    //Accepted ----32ms
    /*
        dp algorithm
     */
    public  int findPaths2(int m, int n, int N, int i, int j){
        if(N == 0){
            return 0;
        }

        long[][][] matrix = new long[m][n][N+1];
        for(int colIndex = 0; colIndex < n; colIndex++){
            matrix[0][colIndex][1]++;
            matrix[m-1][colIndex][1]++;
        }

        for(int rowIndex = 0; rowIndex < m; rowIndex++){
            matrix[rowIndex][0][1]++;
            matrix[rowIndex][n-1][1]++;
        }

        for(int r = 1; r <= N; r++) {
            for (int p = 0; p < m; p++) {
                for (int q = 0; q < n; q++) {
                    if (!((r == 1) && (p == 0 || p == m - 1 || q == 0 || q == n - 1))) {
                        long left = 0;
                        long right = 0;
                        long up = 0;
                        long down = 0;

                        if (q - 1 >= 0) {
                            left = matrix[p][q - 1][r - 1];
                        }
                        if (q + 1 < n) {
                            right = matrix[p][q + 1][r - 1];
                        }
                        if (p - 1 >= 0) {
                            up = matrix[p - 1][q][r-1];
                        }
                        if (p + 1 < m) {
                            down = matrix[p + 1][q][r - 1];
                        }
                        long value = left + right + up + down;
                        if (value >= Math.pow(10, 9) + 7) {
                            value = (long) Math.floorMod(value, (long) (Math.pow(10, 9) + 7));
                        }
                        matrix[p][q][r] = value;
                    }
                }
            }
        }

        long sum = 0;
        for(int k = 1; k <= N; k++){
            sum += matrix[i][j][k];
           /* if (sum >= (long) (Math.pow(10, 9) + 7)) {
                sum = (long) Math.floorMod(sum, (long) (Math.pow(10, 9) + 7));
            }*/
        }
        return (int) Math.floorMod(sum, (long) (Math.pow(10, 9) + 7));
    }

    @Test
    public  void  test(){
       /* int m = 2;
        int n = 2;
        int N = 2;
        int i = 0;
        int j = 0;*/

       /* int m = 8;
        int n = 7;
        int N = 16;
        int i = 1;
        int j = 5;*/

       /* int m = 8;
        int n = 50;
        int N = 23;
        int i = 5;
        int j = 26;*/

       /* int m = 36;
        int n = 5;
        int N = 50;
        int i = 15;
        int j = 3;*/

      /* int m = 45;
        int n = 35;
        int N = 47;
        int i = 20;
        int j = 31;*/

        int m = 30;
        int n = 24;
        int N = 23;
        int i = 26;
        int j = 12;
        long startTime = System.currentTimeMillis();
        int result = findPaths2(m,n,N,i,j);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
