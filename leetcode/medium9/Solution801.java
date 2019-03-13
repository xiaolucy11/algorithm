package algorithm.medium9;

import org.junit.Test;

/**
 * Created by youlu on 2018/11/16.
 */
public class Solution801 {
    public  int minSwap;
    public  boolean isIncreasing(int[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i - 1] >= arr[i]){
                return  false;
            }
        }
        return  true;
    }

    public  void  search(int[] A, int[] B, int[] swapA, int[] swapB, int index, int swap ){
        if(index == A.length){
            if(swap < minSwap){
                minSwap = swap;
            }
            return;
        }

        if(A[index] > swapA[index - 1] && B[index] > swapB[index - 1]){
            swapA[index] = A[index];
            swapB[index] = B[index];
            search(A,B,swapA, swapB,index+1,swap);
            swapA[index] = 0;
            swapB[index] = 0;
        }

        if(A[index] > swapB[index-1] && B[index] > swapA[index-1]){
            swapA[index] = B[index];
            swapB[index] = A[index];
            search(A,B,swapA,swapB, index+1, swap+1);
            swapA[index] = 0;
            swapB[index] = 0;
        }
    }

    //Time Limit Exceed
    public  int minSwap(int[] A, int[] B){
        if(isIncreasing(A) && isIncreasing(B)){
            return 0;
        }
        minSwap = 10001;

        int[] swapA1 = new int[A.length];
        int[] swapA2 = new  int[A.length];
        int[] swapB1 = new int[B.length];
        int[] swapB2 = new int[B.length];

        swapA1[0] = A[0];
        swapB1[0] = B[0];

        swapA2[0] = B[0];
        swapB2[0] = A[0];

        search(A,B,swapA1,swapB1,1,0);
        search(A,B,swapA2,swapB2,1,1);

        return  minSwap;
    }

    public  void  swapPosition(int[] A, int[] B, int index){
        int temp = A[index];
        A[index] = B[index];
        B[index] = temp;
    }

    public  int help(int[] A, int[] B, int start, int end){
        if(start >= end){
            return  0;
        }

        int index = start;
        while ((index < end) && (A[index] < A[index+1] &&
                B[index] < B[index+1])){
            index++;
        }
        if(index < end){
            int value1 = 0;
            if(B[index] >= A[index+1] || A[index] > B[index+1]){
                value1 = 1001;
            }else {
                swapPosition(A, B, index);
                value1 = help(A, B, index + 1, end) + help(A,B, start, index);
                swapPosition(A, B, index);
            }

            int value2 = 0;
            if(A[index] >= B[index+1] || B[index] >= A[index+1]){
                value2 = 1001;
            }else {
                swapPosition(A, B, index + 1);
                value2 = help(A, B, index + 2, end);
                swapPosition(A, B, index + 1);
            }

            return  Math.min(value1, value2) + 1;
        }else {
            return  0;
        }
    }

    //Time Limit Exceed
    public  int minSwap1(int[] A, int[] B){
            return  help(A,B,0, A.length-1);

    }

    public int dfs(int[] A,int[] B, int i,Integer[][] dp,int swap){

        if(i==A.length){
            return 0;
        }
        if(dp[i][swap]!=null)
            return dp[i][swap];
        int min1=Integer.MAX_VALUE;
        if(i==0 || A[i] > A[i-1] && B[i] > B[i-1]){
            min1=dfs(A,B,i+1,dp,0);
        }
        int min2=Integer.MAX_VALUE;
        if(i==0 || A[i] > B[i-1] && B[i] >A[i-1]){
            swapPosition(A,B,i);
            min2=dfs(A,B,i+1,dp,1)+1;
            swapPosition(A,B,i);
        }
        dp[i][swap]=Math.min(min1,min2);
        return dp[i][swap];
    }

    //Accepted --11ms
    /*
        1.code from other
        2.memorization search
        3. this dynamic programming problem is similar to stock buy and sell,
            in ith, there exist two decision

     */
    public  int minSwap2(int[] A, int[] B){
        Integer[][] dp = new Integer[A.length][2];//0 no swap, 1:swap

        return dfs(A,B,0,dp,0);
    }


    @Test
    public  void  test(){
       /* int[] A = {1,3,5,4};
        int[] B = {1,2,3,7};*/

      /* int[] A = {3,3,8,9,10};
        int[] B = {1,7,4,6,8};*/
     /* int[] A = {0,4,4,5,9};
        int[] B = {0,1,6,8,10};*/

       /* int[] A= {0,7,8,10,10,11,12,13,19,18};
        int[] B = {4,4,5,7,11,14,15,16,17,20};*/
       int[] A = {2,1,6,7,8,13,15,11,18,13,20,24,17,28,22,23,36,37,39,34,
                43,38,48,41,46,48,49,50,56,55,59,60,62,64,66,75,69,70,71,74,
                87,78,95,97,81,99,85,101,90,91,93,95,107,109,101,111,106,114,
                115,117,118,115,121,122,123,124,125,126,134,131,133,136,142,149,
                151,152,145,156,158,150,162,159,161,165,169,170,169,174,172,176,
                177,181,183,192,186,188,189,196,198,200};
        int[] B = {0,4,10,11,12,9,10,16,12,19,15,16,25,20,33,34,27,29,32,40,35,
                45,40,50,51,52,53,55,52,58,58,61,62,66,71,68,78,81,83,84,75,91,79,
                80,98,83,100,89,102,103,105,106,96,98,110,105,113,109,110,111,112,
                120,116,118,126,130,131,133,129,137,138,140,137,138,140,142,154,147,
                149,159,152,163,164,163,166,168,171,170,
                175,176,177,181,186,184,193,194,195,190,195,200};


        long startTime = System.currentTimeMillis();
        int result = minSwap2(A, B);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
