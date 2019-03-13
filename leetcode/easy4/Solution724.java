package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/30 0030.
 */
public class Solution724 {

    //Accepted ------20ms
    public  int pivotIndex(int[] nums){
        if(nums.length < 3){
            return  -1;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++){

            if(leftSum == sum - leftSum - nums[i]){
                return  i;
            }
            leftSum += nums[i];
        }
        return  -1;
    }

    @Test
    public  void  test(){
        int[] nums = {1,2,3};
        System.out.println(pivotIndex(nums));
    }
}
