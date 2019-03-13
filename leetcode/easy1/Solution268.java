package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/28 0028.
 */
public class Solution268 {
    public int missingNumber(int[] nums){
        int length = nums.length;
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i <= length; i++){
            sum1 += i;
        }
        for(int j = 0; j < length; j++){
            sum2 += nums[j];
        }
        return  sum1 - sum2;
    }

    @Test
    public  void  test(){
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.print(missingNumber(nums));
    }
}
