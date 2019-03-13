package interview.medium3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/9/10 0010.
 */
public class Solution213 {

    //Accepted --------5ms
    public  int rob(int[] nums){
        int length = nums.length;
        if(length ==  0){
            return 0;
        }

        if(length == 1){
            return  nums[0];
        }
        if(length == 2){
            return  Math.max(nums[0], nums[1]);
        }

        int[] arr1 = new int[length];
        int[] arr2 = new int[length];

        arr1[0] = nums[0];
        arr1[1] = nums[1];
        int leftPre1 = 0, leftPre2 = nums[0];

        int firstMax = Math.max(arr1[0], arr1[1]);
        for(int i = 2; i < length-1;i++){
            if(nums[i] + leftPre1 > nums[i] + leftPre2){
                arr1[i] = nums[i] + leftPre1;
            }else {
                arr1[i] = nums[i] + leftPre2;
            }
            if(arr1[i] > firstMax){
                firstMax = arr1[i];
            }

            int temp1 = leftPre2;
            if(arr1[i-1] > leftPre2){
                leftPre2 = arr1[i-1];
            }
            if(temp1 > leftPre1){
                leftPre1 = temp1;
            }
        }

        arr2[1] = nums[1];
        arr2[2] = nums[2];
        int secondMax = Math.max(arr2[1],arr2[2]);
        int secondPre1 = 0, secondPre2 = nums[1];
        for (int i = 3; i < length; i++){
            if(nums[i] + secondPre1 > nums[i] + secondPre2){
                arr2[i] = nums[i] + secondPre1;
            }else {
                arr2[i] = nums[i] + secondPre2;
            }

            if(arr2[i] > secondMax){
                secondMax = arr2[i];
            }

            int  temp2 = secondPre2;
            if(arr2[i-1] > secondPre2){
                secondPre2 = arr2[i-1];
            }
            if(temp2 > secondPre1){
                secondPre1 = temp2;
            }
        }

        return Math.max(firstMax, secondMax);
    }

    @Test
    public  void  test(){
        int[] nums = {4,1,2,7,5,3,1};
        System.out.print(rob(nums));
    }
}
