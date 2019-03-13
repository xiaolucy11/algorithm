package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/29 0029.
 */
public class Solution80 {
    //Accepted  --------2ms
    public int removeDuplicates(int[] nums){
        int length = nums.length;
        int slow = 0, quick = 0;

        while (quick < length){
            if(nums[slow] == nums[quick]){
                quick++;
            }else {
                if(quick - slow < 2){
                    slow = quick;
                }else {
                    int distance = quick - slow;
                    int index1 = slow + 2, index2 = quick;
                    while (index2 < length){
                        nums[index1++] = nums[index2++];
                    }
                    length -= distance - 2;
                    quick -= distance - 2;
                    slow = quick;
                }
            }
        }
        if(quick - slow == 1){
            return  slow + 1;
        }else {
            return  slow + 2;
        }
    }

    @Test
    public  void  test(){
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int result = removeDuplicates(nums);
        System.out.println(result);
        for(int i = 0; i < result; i++){
            System.out.print(nums[i] + "  ");
        }
    }
}
