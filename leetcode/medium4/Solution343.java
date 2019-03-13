package algorithm.medium4;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/21.
 */
public class Solution343 {
    public  int helper(int n, int[] nums){
        int smallerValue = n / 2;
        int biggerValue = n - smallerValue;
        int maxValue = Integer.MIN_VALUE;
        while (smallerValue >= 4){
            int value = nums[smallerValue] * nums[biggerValue];
            if(value > maxValue){
                maxValue = value;
            }
            smallerValue--;
            biggerValue++;
        }
        return  maxValue;
    }



    //Accepted ----- 0ms
    public  int integerBreak(int n){
        int[] array = {0,0,1,2,4,6,9,12,18,27,36};
        if(n <= 10){
            return  array[n];
        }else {
            int[] nums = new int[n+1];
            for(int i = 0; i <= 10; i++){
                nums[i] = array[i];
            }
            for(int i = 11; i <= n; i++){
                nums[i] = helper(i,nums);
            }

            return  nums[n];
        }
    }


    /*
       code from other
     */
    public int integerBreak1(int n) {
        if (n <= 2)
            return 1;
        if (n == 3)
            return 2;

        int rem = n % 3;
        int sol = 1;
        for (int i = 0; i < (n - 2) / 3; i++)
            sol *= 3;

        if (rem == 0) {
            return sol * 3;
        } else if (rem == 1) {
            return sol * 4;
        }
        return sol * 2;
    }

    @Test
    public  void  test(){
        int n = 14;
        long startTime = System.currentTimeMillis();
        System.out.println(integerBreak(n));
        long endTime = System.currentTimeMillis();
        System.out.println("running time : " + (endTime - startTime));
    }
}
