package algorithm.hard2;

import java.util.Arrays;

public class Solution164 {

    /*
        time complexity O(nlog(n))
     */
    public  int maximumGap(int[] nums){
        if(nums.length < 2){
            return 0;
        }
        Arrays.sort(nums);

        int max = nums[1] - nums[0];
        for(int i = 2; i < nums.length; i++){
            max = Math.max(max, nums[i] - nums[i-1]);
        }

        return max;
    }


    /*
       no solution
     */
    public  int maximumGap1(int[] nums){
        if(nums.length < 2){
            return 0;
        }

        return 0;
    }

}
