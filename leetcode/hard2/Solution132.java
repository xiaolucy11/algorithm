package algorithm.hard2;

import org.junit.Test;

/**
 * Created by youlu on 2018/12/20.
 */
public class Solution132 {

    public  int[][] matrix;
    public int search(int[][] dp, int start, int end){
        if(start == end){
            return  dp[start][end];
        }

        int minPatition = Integer.MAX_VALUE;
        for(int index = end - 1; index >= start; index--){
            int value1 =0, value2 = 0;
            if(matrix[index+1][end] != 0){
                value1 = matrix[index+1][end];
            }else {
                value1 = search(dp, index+1, end);
            }

            if(matrix[start][index] != 0){
                value2 = matrix[start][index];
            }else {
                value2 = search(dp, start, index);
            }
            minPatition = Math.min(minPatition, value1 + value2);
        }

        minPatition = Math.min(minPatition, dp[start][end]);
        matrix[start][end] = minPatition;
        return  matrix[start][end];
    }


    /*
        pass 28/ 29 test case
        not pass the last case, the size is bigger than 1000
        dp algorithm, using memorization search
     */
    public  int minCut(String s){
        if(s.length() == 0){
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        matrix = new int[s.length()][s.length()];
        for(int step = 0; step < s.length(); step++){
            for(int i = 0; i < s.length(); i++){
                int start = i, end = start + step;
                if(end >= s.length()){
                    continue;
                }
                if(start == end){
                    dp[start][end] = 1;
                }else {
                    int min = Math.min(dp[start+1][end],dp[start][end-1]) + 1;
                    if(s.charAt(start) == s.charAt(end)){
                        if(end - start == 1){
                            min = 1;
                        }else {
                            if(dp[start+1][end -1] == 1) {
                                min = Math.min(min, dp[start + 1][end - 1]);
                            }else {
                                min = Math.min(min, dp[start+1][end-1] + 2);
                            }
                        }
                    }

                    dp[start][end] = min;
                }
            }
        }
        return search(dp,0, s.length()-1) - 1;
    }

    public int search1(int[][] dp, String s,int start, int end){
        if(start == end){
            dp[start][end] = 1;
            return  dp[start][end];
        }

        if(end - start == 1){
            if(s.charAt(start) == s.charAt(end)){
                dp[start][end] = 1;
            }else {
                dp[start][end] = 2;
            }
            return  dp[start][end];
        }

        if(s.charAt(start) == s.charAt(end)){
            int value1 = 0;
            if(dp[start+1][end-1] != 0){
                value1 = dp[start+1][end-1];
            }else {
                value1 = search1(dp,s,start+1, end-1);
            }

            if(value1 == 1){
                dp[start][end] = 1;
                return  dp[start][end];
            }
        }


        int minPatition = Integer.MAX_VALUE;
        for(int index = end - 1; index >= start; index--){
            int value1 =0, value2 = 0;
            if(dp[index+1][end] != 0){
                value1 = dp[index+1][end];
            }else {
                value1 = search1(dp, s,index+1, end);
            }

            if(dp[start][index] != 0){
                value2 = dp[start][index];
            }else {
                value2 = search1(dp,s, start, index);
            }
            minPatition = Math.min(minPatition, value1 + value2);
        }

//        minPatition = Math.min(minPatition, dp[start][end]);
        dp[start][end] = minPatition;
        return  dp[start][end];
    }

    public  int minCut1(String s){
        if(s.length() == 0){
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];

        return  search1(dp,s, 0, s.length() - 1) - 1;
    }

    //Accepted ----19ms
    /*
        dp algorithm ,from buttom to top
     */
    public  int minCut2(String s){
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            int min = i + 1;
            for(int j = 0; j <= i; j++){
                if((s.charAt(i) == s.charAt(j)) && (i - j <= 2 || dp[j+1][i-1] == 1)){
                    if(j == 0){
                        min = 1;
                    }else {
                        min  = Math.min(min, dp[0][j-1]+1);
                    }
                    dp[j][i] = 1;
            }

            }
            dp[0][i] = min;
        }
        return  dp[0][s.length()-1] - 1;
    }


    @Test
    public  void  test(){
 //       String s = "caaab";
//        String s = "ccaacabacb";
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        long startTime = System.currentTimeMillis();
        int result = minCut2(s);
        long endTime = System.currentTimeMillis();

//        System.out.println("length : " + s.length());
        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
