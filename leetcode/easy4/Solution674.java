package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
public class Solution674 {

    //Accepted -----3ms
    public int findLengthOfLCIS(int[] nums){
        if(nums.length == 0){
            return  0;
        }
        if(nums.length == 1){
            return  1;
        }
        int slow = 0, quick = 1;
        int maxLength = 0;
        while(quick < nums.length){
            if(nums[quick-1] < nums[quick]){
                quick++;
            }else {
                if(quick - slow > maxLength ){
                    maxLength = quick - slow;
                }
                slow = quick;
                quick++;
            }
        }
        if(quick - slow > maxLength){
            maxLength = quick - slow;
        }
        return  maxLength;
    }

    @Test
    public  void  test(){
        int[] nums = {1,3,5,4,7};
        System.out.print(findLengthOfLCIS(nums));
    }
}
