package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/14 0014.
 */
public class Solution75 {
    //Accepted -----0ms  one-pass , space O(1)
    public  void  sortColors(int[] nums){
        int length = nums.length;
        if(length == 0 || length == 1){return;}
        int left = 0, right = length - 1;

        while (left < length && nums[left] == 0){
            left++;
        }
        while (right >= 0 && nums[right] == 2){
            right--;
        }


        int i = left;
            while (i <= right){
            if(nums[i] == 2){
                int temp1 = nums[i];
                nums[i] = nums[right];
                nums[right] = temp1;
                while (nums[right] == 2){
                    right--;
                }
            }else if(i > left && nums[i] == 0){
                int temp1 = nums[i];
                nums[i] = nums[left];
                nums[left] = temp1;
                while (nums[left] == 0){
                    left++;
                }
                i = left;
            }else {
               i++;
            }
        }
    }

    @Test
    public  void  test(){
        int[] nums = {2,0,1};
        sortColors(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + "  ");
        }
    }
}
