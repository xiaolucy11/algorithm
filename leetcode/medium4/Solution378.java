package algorithm.medium4;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/9/25.
 */
public class Solution378 {

    //Accepted ---- 24ms
    /*
        brute solution
     */
    public  int kthSmallest(int[][] matrix, int k){
        List<Integer> list = new ArrayList<>();
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                list.add(matrix[i][j]);
            }
        }
        Collections.sort(list);
        return list.get(k-1);
    }

    public  class  Point{
        int x;
        int y;
        Point(int _x, int _y){
            x = _x;
            y = _y;
        }
    }
    public  Point searchLeftPart(int[][] matrix, int row, int col){

        int minValue = Integer.MAX_VALUE;
        int indexX = matrix.length-1, indexY = matrix[0].length-1;
        for(int i = row+1; i < matrix.length; i++){
            for(int j = 0; j <= col ; j ++){
                if(matrix[i][j] >= matrix[row][col] && matrix[i][j] < minValue){
                    indexX = i;
                    indexY = j;
                }
            }
        }
        return new Point(indexX, indexY);
    }

    public  Point searchRightPart(int[][] matrix, int row, int col){
        int minValue = Integer.MAX_VALUE;
        int indexX = matrix.length-1, indexY = matrix[0].length-1;
        for(int i = 0 ; i <= row; i++){
            for(int j = col + 1; j < matrix[0].length; j++){
                if(matrix[i][j] >= matrix[row][col] && matrix[i][j] < minValue){
                    indexX = i;
                    indexY = j;
                }
            }
        }

        return  new Point(indexX, indexY);
    }

    public  int findKthSmallest(int[][] matrix, int row, int col, int k, int count){
        if(count == k){
            return  matrix[row][col];
        }
        Point leftPoint = searchLeftPart(matrix, row ,col);
        Point rightPoint = searchRightPart(matrix, row, col);

        if(matrix[leftPoint.x][leftPoint.y] < matrix[rightPoint.x][rightPoint.y]){
           return findKthSmallest(matrix, leftPoint.x, leftPoint.y, k, count+1);
        }else {
            return findKthSmallest(matrix, rightPoint.x, rightPoint.y, k, count+1);
        }

    }

    //Wrong Solution
    public  int kthSmallest1(int[][] matrix, int k){
        if(k == 1){
            return  matrix[0][0];
        }
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        if(k == rowLength * colLength){
            return matrix[rowLength-1][colLength-1];
        }

        if(matrix[0][1] < matrix[1][0]){
           return findKthSmallest(matrix,0,1,k,2);
        }else {
            return findKthSmallest(matrix,1,0,k,2);
        }

    }

    public  class  Element{
        int val;
        int row;
        int col;
        Element(int _val, int _row, int _col){
            val = _val;
            row = _row;
            col = _col;
        }
    }

    //Accepted ---- 19ms
    /*
        using min heap
        beats 47.04%
     */
    public  int kthSmallest2(int[][] matrix, int k){
        int n = matrix.length;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        PriorityQueue<Element> priorityQueue = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.val < o2.val){
                    return -1;
                }else  if(o1.val > o2.val){
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        for(int i = 0; i < n; i++){
            Element e = new Element(matrix[i][0],i, 0);
            priorityQueue.add(e);
        }


        int index = 0;
        while (count < k){
            Element element = priorityQueue.poll();
            list.add(element.val);
            count++;
            int curRow = element.row, curCol = element.col;
            if(curCol < n-1){
                Element e = new Element(matrix[curRow][curCol+1], curRow, curCol+1);
                priorityQueue.add(e);
            }else {
                priorityQueue.add(new Element(Integer.MAX_VALUE, n, n));
            }
        }

        return  list.get(k-1);
    }

    /*
        code from other
        using binary search
        is hard to think this solution
     */
    public int kthSmallest3(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    @Test
    public  void  test(){
        int[][] matrix = {{1,5,9},
                {10,11,13},
                {12,13,15}};
        int k = 8;

       /*int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},
               {3,6,9,16,22},{10,13,14,17,24},
               {18,21,23,26,30}};
        int k = 24;*/
        long startTime = System.currentTimeMillis();
        int result = kthSmallest2(matrix, k);
        long endTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
