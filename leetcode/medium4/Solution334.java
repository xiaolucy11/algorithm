package algorithm.medium4;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/20.
 */
public class Solution334 {
    //Accepted ----- 4ms
    public boolean increasingTriplet(int[] nums){
        if(nums.length == 0){
            return  false;
        }
        int length = nums.length;
        int firstNumber = nums[0], secondNumber = Integer.MAX_VALUE;

        for(int i = 0; i < length; i++){
            if(nums[i] < firstNumber){
                firstNumber = nums[i];
            } else if(nums[i] > secondNumber){
                return  true;
            }else if((nums[i]  > firstNumber) && (nums[i] < secondNumber)){
                secondNumber = nums[i];
            }else {

            }
        }

        return  false;
    }

    @Test
    public  void  test(){
        int[] nums = {5,4,3,2,1};
        System.out.print(increasingTriplet(nums));
    }
}
