package algorithm.medium5;

import com.sun.xml.internal.ws.server.sei.SEIInvokerTube;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by youlu on 2018/10/2.
 */
public class Solution417 {
    public  int[][] toPacific;
    public  int[][] toAtlantic;
    //1-left, 2-right, 3-up, 4-down
    //not be used
    public  boolean search(int[][] matrix, int row , int col, int direction){
        if(direction == 1){
            if(col == 0){
                return true;
            }else {
                if(matrix[row][col-1] > matrix[row][col] ){
                    return  false;
                }else {
                    if(matrix[row][col-1] == 0){
                        return  true;
                    }
                   return search(matrix,row,col-1, 1);
                }
            }
        }else if(direction == 2){
            if(col == matrix[0].length-1){
                return  true;
            }else {
                if(matrix[row][col + 1] > matrix[row][col]){
                    return  false;
                }else {
                    if(matrix[row][col+1] == 0){
                        return  true;
                    }
                    return  search(matrix, row, col+1, 2);
                }
            }
        }else if(direction == 3){
            if(row == 0){
                return  true;
            }else {
                if(matrix[row-1][col] > matrix[row][col]){
                    return  false;
                }else {
                    if(matrix[row-1][col] == 0){
                        return  true;
                    }
                    return  search(matrix, row-1, col,3);
                }
            }
        }else {
            if(row == matrix.length - 1){
                return  true;
            }else {
                if(matrix[row + 1][col] > matrix[row][col]){
                    return  false;
                }else {
                    if(matrix[row+1][col] == 0){
                        return  true;
                    }
                    return  search(matrix, row +1, col, 4);
                }
            }
        }
    }


    //not be used
    public  boolean searchLeft(int[][] matrix, int[][] toMatrix, int row, int col){
        if(col == 0){
            return  true;
        }

        if(matrix[row][col-1] > matrix[row][col]){
            return  false;
        }else {
            if(toMatrix[row][col-1] == 1){
                toMatrix[row][col] = 1;
                return  true;
            }else {
                if(searchLeft(matrix,toMatrix, row, col-1)){
                    toMatrix[row][col-1] = 1;
                    return  true;
                }
            }
        }

        return  false;
    }


    //not be used
    public  boolean searchUp(int[][] matrix, int[][] toMatrix, int row, int col){
        if(row == 0){
            return  true;
        }

        if(matrix[row - 1][col] > matrix[row][col]){
            return  false;
        }else {
            if(toMatrix[row-1][col] == 1){
                toMatrix[row][col] = 1;
                return  true;
            }else {
                if(searchUp(matrix, toMatrix, row-1, col)){
                    toMatrix[row][col] = 1;
                    return  true;
                }
            }
        }
        return  false;
    }


    //not be used
    public  boolean searchRight(int[][] matrix, int[][] toMatrix, int row, int col){
        if(col == matrix[0].length-1){
            return true;
        }

        if(matrix[row][col+1] > matrix[row][col]){
            return  false;
        }else {
            if(toMatrix[row][col+1] == 1){
                toMatrix[row][col] = 1;
            }else {
                if(searchRight(matrix, toMatrix, row, col+1)){
                    toMatrix[row][col] = 1;
                    return true;
                }
            }
        }

        return  false;
    }


    //not be used
    public  boolean searchDown(int[][] matrix, int[][] toMatrix, int row, int col){
        if(row == matrix.length - 1){
            return  true;
        }

        if(matrix[row+1][col] > matrix[row][col]){
            return  false;
        }else {
            if(toMatrix[row+1][col] == 1){
                toMatrix[row][col] = 1;
            }else {
                if(searchDown(matrix, toMatrix, row+1, col)){
                    toMatrix[row][col] = 1;
                    return  true;
                }
            }
        }
        return  false;
    }

    //not be used
    public  boolean check(int[][] matrix,int[][] toMatrix, int row, int col){
        boolean b1 = searchLeft(matrix, toMatrix, row, col);
        if(b1){
            return  true;
        }

        boolean b2 = searchRight(matrix, toMatrix, row, col);
        if(b2){
            return  true;
        }

        boolean b3 = searchUp(matrix, toMatrix, row, col);
        if(b3){
            return  true;
        }

        boolean b4 = searchDown(matrix, toMatrix, row, col);
        if(b4){
            return  true;
        }

        return  false;
    }

    public class  Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public  boolean pacificSearch(int[][] matrix, int[][] toMatrix, int row, int col, Set<Point> set){
        if(row == 0 || col == 0){
            return  true;
        }

        Point curPoint = new Point(row, col);
        set.add(curPoint);
        if(matrix[row-1][col] <= matrix[row][col]){
            if(toMatrix[row-1][col] == 1){
                toMatrix[row][col] = 1;
                return  true;
            }else {
                Point p = new Point(row-1, col);
                if(!set.contains(p) && pacificSearch(matrix, toMatrix, row-1, col,set)){
                    toMatrix[row][col] = 1;
                    return  true;
                }
            }
        }

        if(matrix[row][col - 1] <= matrix[row][col]){
            if(toMatrix[row][col-1] == 1){
                toMatrix[row][col] = 1;
                return  true;
            }else {
                Point p = new Point(row, col-1);
                if(!set.contains(p) && pacificSearch(matrix, toMatrix, row, col-1,set)){
                    toMatrix[row][col] = 1;
                    return  true;
                }
            }
        }

        if(col + 1< matrix[0].length && matrix[row][col+1] <= matrix[row][col]){
            if(toMatrix[row][col + 1] == 1){
                toMatrix[row][col] = 1;
                return  true;
            }else {
                Point p = new Point(row, col+1);
                if(!set.contains(p) && pacificSearch(matrix, toMatrix, row, col+1,set)){
                    toMatrix[row][col] = 1;
                    return  true;
                }
            }
        }

        if(row + 1 < matrix.length && matrix[row][col] >= matrix[row + 1][col]){
            if(toMatrix[row+1][col] == 1){
                toMatrix[row][col] = 1;
                return  true;
            }else {
                Point p = new Point(row+1, col);
                if(!set.contains(p) && pacificSearch(matrix, toMatrix, row+1, col,set)){
                    toMatrix[row][col] = 1;
                    return  true;
                }
            }
        }
        return  false;
    }

    public  boolean atlanticSearch(int[][] matrix, int[][] toMatrix ,int row, int col,Set<Point> set){
        if(row == matrix.length - 1 || col == matrix[0].length - 1){
            return  true;
        }
        Point curPoint = new Point(row, col);
        set.add(curPoint);

        if(row > 0 && matrix[row-1][col] <= matrix[row][col]){
            if(toMatrix[row-1][col] == 1){
                toMatrix[row][col] = 1;
                return  true;
            }else {
                Point p = new Point(row-1, col);
                if(!set.contains(p) && atlanticSearch(matrix, toMatrix, row-1, col,set)){
                    toMatrix[row][col] = 1;
                    return  true;
                }
            }
        }

        if(col > 0 && matrix[row][col - 1] <= matrix[row][col]){
            if(toMatrix[row][col-1] == 1){
                toMatrix[row][col] = 1;
                return  true;
            }else {
                Point p = new Point(row, col-1);
                if(!set.contains(p) && atlanticSearch(matrix, toMatrix, row, col-1,set)){
                    toMatrix[row][col] = 1;
                    return  true;
                }
            }
        }

        if( matrix[row][col+1] <= matrix[row][col]){
            if(toMatrix[row][col + 1] == 1){
                toMatrix[row][col] = 1;
                return  true;
            }else {
                Point p = new Point(row, col+1);
                if(!set.contains(p) && atlanticSearch(matrix, toMatrix, row, col+1, set)){
                    toMatrix[row][col] = 1;
                    return  true;
                }
            }
        }

        if(matrix[row][col] >= matrix[row + 1][col]){
            if(toMatrix[row+1][col] == 1){
                toMatrix[row][col] = 1;
                return  true;
            }else {
                Point p = new Point(row + 1, col);
                if(!set.contains(p) && atlanticSearch(matrix, toMatrix, row+1, col, set)){
                    toMatrix[row][col] = 1;
                    return  true;
                }
            }
        }
        return  false;

    }

    public  void canFlowPacific(int[][] matrix){
       int rowLength = toPacific.length;
        int colLength = toPacific[0].length;
        for(int i = 1; i < rowLength;i++){
            for(int j = 1; j < colLength; j++){
               boolean b =  pacificSearch(matrix, toPacific, i, j, new HashSet<>());
            }
        }

    }

    public  void canFlowAtlantic(int[][] matrix){
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        for(int i = rowLength - 1; i >= 0; i--){
            for(int j = colLength - 1; j >= 0; j--){
               boolean b =  atlanticSearch(matrix, toAtlantic, i,j, new HashSet<>());
            }
        }
    }

    //Accepted ---- 334ms
    /*
        not effecient
     */
    public List<int[]> pacificAtlantic(int[][] matrix){
        if (matrix.length == 0){
            return  new ArrayList<>();
        }
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        toPacific = new int[rowLength][colLength];
        toAtlantic = new int[rowLength][colLength];
        List<int[]> result = new ArrayList<>();

        for(int i = 0 ; i < rowLength; i++){
            toPacific[i][0] = 1;
            toAtlantic[i][colLength-1] = 1;
        }
        for(int i = 0; i < colLength; i++){
            toPacific[0][i] = 1;
            toAtlantic[rowLength-1][i] = 1;
        }


        canFlowPacific(matrix);
        canFlowAtlantic(matrix);
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(toPacific[i][j] == 1 && toAtlantic[i][j] == 1){
                    int[] point = new int[2];
                    point[0] = i;
                    point[1] = j;
                    result.add(point);
                }
            }
        }

        return  result;
    }


    @Test
    public  void  test(){
       /* int[][] matrix = {{1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}};*/
//     int[][] matrix = {{1,1},{1,1},{1,1}};
        int[][] matrix = {{1,2,3},{8,9,4},{7,6,5}};
        long startTime = System.currentTimeMillis();
        List<int[]> result = pacificAtlantic(matrix);
        long endTime = System.currentTimeMillis();
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i)[0] + "  -  " + result.get(i)[1]);
        }
        System.out.println("running time : " + (endTime - startTime));
    }
}
