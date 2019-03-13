package algorithm.medium6;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by youlu on 2018/10/10.
 */
public class Solution473 {
    public  boolean choice(int[] nums,int index, int sum, int squareLength){
        if(sum == squareLength){
            return  true;
        }

        for(int i = nums.length - 1; i >= 0; i--){
            int value = nums[i];
            if(value != 0 && sum + value <= squareLength){
                sum += value;
                nums[i] = 0;
                if(!choice(nums,i- 1, sum, squareLength)){
                    sum -= value;
                    nums[i] = value;
                }else {
                    return true;
                }
            }
        }

        return  false;
    }

    //Accepted ----14ms
    /*
        greedy alogrithm
     */
    public  boolean makesquare(int[] nums){
        if(nums.length == 0){
            return  false;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if(sum % 4 != 0){
            return  false;
        }

        int squareLength = sum / 4;
        int count = 4;

        Arrays.sort(nums);
        while (count > 0){
            for(int i = nums.length - 1; i >= 0;i--){
                if(nums[i] != 0){
                    count--;
                    int value = nums[i];
                    nums[i] = 0;
                    if(!choice(nums,i -1, value, squareLength)){
                        return  false;
                    }else {
                        break;
                    }
                }
            }
        }

        return  true;
    }

    @Test
    public  void  test(){
//        int[] nums = {1,1,2,2,2};
//        int[] nums = {3,3,3,3,4};
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
//        int[] nums = {10,6,5,5,5,3,3,3,2,2,2,2};
        long startTime = System.currentTimeMillis();
        boolean b = makesquare(nums);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + b);
        System.out.println("running time : " + (endTime - startTime));
    }
}
