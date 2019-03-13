package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/20 0020.
 */
public class Solution198 {
    public int robHelp(int[] nums, int start, int end){
        if(start > end){return  0;}
        if(start == end){return  nums[start];}
        if(end - start == 1){return Math.max(nums[start], nums[end]);}
        int robMoney1 = nums[start] + robHelp(nums, start+2, end) ;
        int robMoney2 = nums[start + 1] + robHelp(nums, start + 3, end);
        return robMoney1 > robMoney2 ? robMoney1 : robMoney2;

    }
    public int rob(int[] nums){
        return robHelp(nums, 0, nums.length-1);
    }

    @Test
    public void  test1(){
        int[] nums = new int[]{2,7,9,3,1};
        int maxMoney = rob(nums);
        System.out.print(maxMoney);
    }
    public int rob1(int[] nums){
        if(nums == null || nums.length == 0){return  0;}
        if(nums.length == 1){return nums[0];}
        if( nums.length == 2){return  Math.max(nums[0], nums[1]);}
        int length = nums.length;
        int[] array = new int[length];
        array[length - 1] = nums[length - 1];
        array[length - 2] = nums[length - 2];
        for(int i = length - 3; i >= 0; i--){
            if( (i + 3) < length ){
                int temp = array[i + 2] > array[i + 3] ? array[ i + 2] : array[ i + 3];
                array[i] = temp + nums[i];
            }else {
                array[i] = nums[i] + array[i + 2];
            }
        }
        return array[0]  > array[1] ? array[0] : array[1];
    }

    @Test
    public void  test2(){
        int[] nums = new int[]{2,1,1,2};
        System.out.print(rob1(nums));
    }
}
