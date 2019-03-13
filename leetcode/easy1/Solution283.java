package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/28 0028.
 */
public class Solution283 {

    //Accepted
    public void moveZeroes(int[] nums){
        int rightIndex = nums.length - 1;
        int rightBound = nums.length - 1;
        for(; rightIndex >= 0; rightIndex--){
            if(nums[rightIndex] != 0){
                rightBound = rightIndex;
                break;
            }
        }
        rightIndex = rightBound;
        while (rightIndex != -1){
            if(nums[rightIndex] != 0){
                rightIndex--;
            }else {
                for(int i = rightIndex + 1; i <= rightBound; i++){
                    int temp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = temp;
                }
                rightBound--;
                rightIndex--;
            }
        }

    }

    //Accepted , less run time
    public  void  moveZeros1(int[] nums){
        int length = nums.length;
        int index = 0;
        for(int i = 0; i < length; i++){
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        while (index < length){
            nums[index] = 0;
            index++;
        }
    }

    @Test
    public  void test(){
        int[] nums = new int[]{0,1,0,3,12};
        moveZeros1(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + "  ");
        }
    }
}
