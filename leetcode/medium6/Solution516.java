package algorithm.medium6;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/15.
 */
public class Solution516 {
    public  int search(String str, int start, int end, int[][] matrix){
        if(end - start == 1){
            return 1;
        }
        if(end - start == 2){
            if(str.charAt(start) == str.charAt(end)){
                return 2;
            }else {
                return 1;
            }
        }

        int longestLength = 1;
        for(int i = start; i < end; i++){
            if(str.charAt(i) == str.charAt(end)){
                int value = 1;
                if(matrix[i+1][end-1] != 0) {
                    value = matrix[i+1][end-1];
                }else {
                  value = search(str, i + 1, end - 1,matrix);
                }
                if(value + 2 > longestLength){
                    longestLength = value + 2;
                }
            }
        }

        matrix[start][end] = longestLength;
        return  longestLength;

    }


    public int longestPalindromeSubseq(String s){
        int length = s.length();
        int[][] matrix = new int[length][length];
        return  search(s,0,s.length()-1,matrix);
    }

    @Test
    public  void  test(){
        String s = "bbbab";
        long startTime = System.currentTimeMillis();
        int result = longestPalindromeSubseq(s);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
