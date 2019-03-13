package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
public class Solution665 {
    //Accepted -------14ms
    public  boolean checkPossibility(int[] nums) {
       /* if (nums.length == 1) {
            return true;
        }
        int count = 0;
        int maxValue = Integer.MIN_VALUE;

        if (nums[0] > nums[1]) {
            count++;
            maxValue = nums[1];
        }else {
            maxValue = nums[0];
        }

        for (int i = 1; i < nums.length-1; i++) {
            if(maxValue != nums[i] &&(nums[i] > nums[i-1] && nums[i] > nums[i+1])
                    || (nums[i] < nums[i-1] && nums[i] < nums[i+1])){
                count++;
            }else {
                if (nums[i] >= maxValue) {
                    maxValue = nums[i];
                } else {
                    count++;
                }
            }
        }
        if(nums[nums.length - 1] < nums[nums.length - 2]){
            count++;
        }
            if (count > 1) {
                return false;
            } else {
                return true;
            }*/

       if(nums.length < 3){
           return  true;
       }
       int slow = 0, quick = 1;
        if(nums[slow] > nums[quick]){
            while(quick + 1 < nums.length){
                if(nums[quick] <= nums[quick + 1]){
                    quick++;
                }else {
                    return  false;
                }
            }
            return  true;
        }
        while (quick < nums.length){
            if(nums[slow] <= nums[quick]){
                quick++;
                slow++;
            }else {
                if(quick == nums.length - 1){return  true;}
               int tempIndex = quick;
                if(nums[tempIndex] >= nums[slow-1]){
                    int flag1 = 0;
                    while (tempIndex + 1 < nums.length){
                        if(nums[tempIndex] <= nums[tempIndex+1]){
                            tempIndex++;
                        }else {
                            flag1 = 1;
                            break;
                        }
                    }
                    if(flag1 == 0){return  true;}
                }


                int index = quick+1;
                if(nums[index] >= nums[slow]){
                    int flag2 = 0;
                    while (index + 1 < nums.length){
                        if(nums[index] <= nums[index+1]){
                            index++;
                        }else {
                            flag2 = 1;
                            break;
                        }
                    }
                    if(flag2 == 0){return  true;}
                }
                return  false;
            }
        }
        return  true;
    }

    @Test
    public  void  test(){
        int[] nums = {4,2,3};
        System.out.println(checkPossibility(nums));
    }

}
