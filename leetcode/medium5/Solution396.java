package algorithm.medium5;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/29.
 */
public class Solution396 {
    public  void move(int[] A){
        int temp = A[0];
        for(int i = 0; i < A.length-1; i++){
            A[i] = A[i+1];
        }
        A[A.length-1] = temp;

    }

    public  int computeSum(int[] A){
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum += i * A[i];
        }

        return  sum;
    }

    //Accepted ---590ms
    /*
        brute solution
        time complexity O(n^2)
     */
    public int maxRotateFunction(int[] A){
        int maxValue = computeSum(A);
        int count = A.length - 1;

        while (count > 0){
            move(A);
            int value = computeSum(A);
            if(value > maxValue){
                maxValue = value;
            }
            count--;
        }

        return  maxValue;
    }

    //Accepted ----3ms
    /*
        time complexity O(n^2)
     */
    public int maxRotateFunction1(int[] A){
        if(A.length == 0){
            return  0;
        }
        int length  = A.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE, currentSum = 0;
        for(int i = 0; i < length; i++){
            sum += A[i];
            currentSum += i * A[i];
        }

        for(int i = 0; i < length; i++){
            currentSum = currentSum - (sum - A[i]) + A[i] * (length - 1);
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }

        return  maxSum;
    }

    @Test
    public  void  test(){
        //int[] A = {4,5,2,6};
        int[] A = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        long startTime = System.currentTimeMillis();
        int result = maxRotateFunction1(A);
        long endTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("runnint time : " + (endTime - startTime));
    }
}
