package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/31 0031.
 */
public class Solution747 {

    //Accepted ---9ms
    public int dominantIndex(int[] nums){
        int maxValue =  -1;
        int maxValueIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if( i != maxValueIndex && nums[i] != 0 && maxValue / nums[i] < 2){
                return -1;
            }
        }
        return  maxValueIndex;
    }

    @Test
    public  void  test(){
        int[] nums = {1,2,3,4};
        System.out.print(dominantIndex(nums));
    }
}
