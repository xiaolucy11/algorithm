package algorithm.medium7;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/21.
 */
public class Solution583 {

    //Accepted ---42ms
    /*
        longest common subsequence
        dp algorithm
     */
    public  int minDistance(String word1, String word2){
        int length1 = word1.length(), length2 = word2.length();
        int[][] matrix = new int[length1 +1][length2 +1];

        for(int i = 0; i <= length1; i++){
            matrix[i][0] = 0;
        }
        for(int j = 0; j <= length2; j++){
            matrix[0][j] = 0;
        }

        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    matrix[i][j] = matrix[i-1][j-1] +1;
                }else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }
        int maxLength = matrix[length1][length2];
        return length1 -  maxLength + length2 - maxLength;
    }

    @Test
    public  void  test(){
        String word1 = "sea";
        String word2 = "eat";

        long startTime = System.currentTimeMillis();
        int result = minDistance(word1, word2);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time ； " + (endTime - startTime));
    }
}
