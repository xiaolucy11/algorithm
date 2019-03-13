package algorithm.medium6;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/11.
 */
public class Solution486 {

    public  int getMaxNumber(int[] nums, int start,int end, int sum){
        if(end - start == 1){
            return  Math.max(nums[start], nums[end]);
        }else if(end - start == 2){
            return nums[start] + nums[end];
        }else {
            int secondPlayerMax1 = getMaxNumber(nums, start+1, end, sum - nums[start]);
            int firstPlayerMax1 = sum - secondPlayerMax1;

            int secondPlayerMax2 = getMaxNumber(nums, start, end - 1, sum - nums[end]);
            int firstPlayerMax2 = sum - secondPlayerMax2;

            return  Math.max(firstPlayerMax1, firstPlayerMax2);

        }
    }

    //Accepted ---- 24ms
    public boolean PredictTheWinner(int[] nums){
        if(nums.length == 1){
            return  true;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        int firstMaxValue = getMaxNumber(nums,0, nums.length-1, sum);
        if(firstMaxValue >= (sum - firstMaxValue)){
            return true;
        }else {
            return  false;
        }
    }

    /*
        it can be optimized, using dp algorithm
     */

    @Test
    public  void  test(){
//        int[] nums = {1,5,2};
//        int[] nums = {1,5,233,7};
        int[] nums = {2,4,55,6,8};
        long startTime = System.currentTimeMillis();
        boolean b = PredictTheWinner(nums);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + b);
        System.out.println("runnig time : " + (endTime - startTime));
    }
}
