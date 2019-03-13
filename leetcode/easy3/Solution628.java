package interview.easy3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/23 0023.
 */
public class Solution628 {
    public  int[] findMaxAndMin(int[] nums){
        int maxIndex = -1, minIndex = -1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
            if(nums[i] < min){
                min = nums[i];
                minIndex = i;
            }
        }
        int[] result = new int[2];
        result[0] = max;
        result[1] = min;
        nums[maxIndex] = 1;
        nums[minIndex] = 1;

        return  result;
    }

    //Accepted ----7ms
    public  int maximumProduct(int[] nums){
        if(nums.length == 3){
            return  nums[0] * nums[1] * nums[2];
        }
        int[] result1 = findMaxAndMin(nums);
        int[] result2 = findMaxAndMin(nums);
        int[] result3 = findMaxAndMin(nums);
        if(result1[0] >= 0){
            if(result1[0] * result2[0] * result3[0] > result1[1] * result2[1] * result1[0]){
                return  result1[0] * result2[0] * result3[0];
            }else {
                return  result1[1] * result2[1] * result1[0];
            }
        }else {
            return  result1[1] * result2[1] * result3[1];
        }
    }

    @Test
    public  void  test(){
        int[] nums = {-1,-2,-3};
        System.out.print(maximumProduct(nums));
    }
}
