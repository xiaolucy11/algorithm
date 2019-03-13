package interview.easy3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/13 0013.
 */
public class Solution485 {
    public  int findMaxConsecutiveOnes(int[] nums){
        int count = 0;
        int start = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1 && nums[start] == 0){
                start = i;
            }else if(nums[i] == 0 && nums[start] == 1){
                if(i - start > count){
                    count = i - start;
                }
                start = i;
            }else {
                continue;
            }
        }
        if(nums[start] == 1 && nums.length - start > count){
            return  nums.length - start;
        }else {
            return  count;
        }

    }

    @Test
    public  void  test(){
        int[] nums = {1,1,0,1,1,1};
        System.out.print(findMaxConsecutiveOnes(nums));
    }

}
