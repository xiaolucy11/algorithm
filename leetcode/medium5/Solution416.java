package algorithm.medium5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by youlu on 2018/10/2.
 */
public class Solution416 {
    public  boolean help(int[] nums, int index,int totalSum, int sum, List<Integer> list){
       if(index < 0){
           if(totalSum == sum * 2){
               return  true;
           }else {
               return  false;
           }
       }
        if(totalSum == sum * 2){
           return  true;
       }


       for(int i = index; i >= 0; i--){
            if(sum + nums[i] <= totalSum / 2){
                list.add(nums[i]);
                sum += nums[i];
                if(help(nums, i-1,totalSum, sum, list)){
                    return  true;
                }else {
                    sum -= nums[i];
                    list.remove(list.size() - 1);
                }
            }
       }

       return  false;
    }

    //Accepted ---5ms
    /*
        trachbacking
     */
    public boolean canPartition(int[] nums){
        Arrays.sort(nums);
        int totalSum = 0;
        int maxValue = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
            if(nums[i] > maxValue){
                maxValue = nums[i];
            }
        }
        if(totalSum % 2 == 1 || maxValue > totalSum / 2){
            return  false;
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            if (help(nums, i-1, totalSum, nums[i], list)){
                return  true;
            }
        }
        return  false;
    }

    /*
        code from other
     */
    public boolean canPartition1(int[] nums){
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum+1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        return dp[n][sum];
    }

    /*
        0/1 knapsack
        dp algorithm
        code from other
     */
    public boolean canPartition2(int[] nums){
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum+1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }

        return dp[sum];
    }

    @Test
    public  void test(){
//        int[] nums = {1,5,11,5};
//       int[] nums = {1,2,3,5};
        int[] nums = {17,58,41,75,61,70,52,7,38,11,40,58,44,45,4,81,67,54,
                79,80,15,3,14,16,9,66,69,41,72,37,28,3,33,90,56,12,72,49,35,
                22,49,27,49,82,41,77,100,82,18,95,24,51,37,2,34,82,70,53,73,
                32,90,98,81,22,73,76,79,40,27,62,45,96,36,15,63,28,54,88,63,
                37,58,9,62,98,93,72,99,53,91,29,61,31,11,42,20,35,50,68,10,86};
     /*   int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,97,95};*/
//        int[] nums = {100,100,100,100,100,100,100,100};
        long startTime = System.currentTimeMillis();
        System.out.println(canPartition(nums));
        long endTime = System.currentTimeMillis();
        System.out.println("runnint time : " + (endTime - startTime));
    }
}
