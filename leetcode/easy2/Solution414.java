package interview.easy2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/6 0006.
 */
public class Solution414 {
    /*
        ----Accepted --------> 2ms
        it conains so many if else statement, ugly code
     */
    public int thirdMax(int[] nums){
        int[] arr = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int count3 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= arr[0]){
                if(nums[i] == Integer.MIN_VALUE){
                    count3++;
                }else if(nums[i] > arr[0]) {
                    arr[2] = arr[1];
                    arr[1] = arr[0];
                    arr[0] = nums[i];
                }else {continue;}
            }else if((nums[i] >= arr[1]) && (nums[i] != arr[0])){
                if(nums[i] == Integer.MIN_VALUE){
                    count3++;
                }else if(nums[i] > arr[1]) {
                    arr[2] = arr[1];
                    arr[1] = nums[i];
                }else {continue;}

            }else if((nums[i] >= arr[2]) && (nums[i] != arr[0]) && (nums[i] != arr[1])){
                arr[2] = nums[i];
                if(nums[i] == Integer.MIN_VALUE) {
                    count3++;
                }
            }else {
                continue;
            }
        }
       if(arr[2] != Integer.MIN_VALUE){return arr[2];}
        else if( count3 != 0 && arr[1] != arr[2] ){return Integer.MIN_VALUE;}
        else {return  arr[0];}
    }

    @Test
    public  void  test(){
        int[] nums = new int[]{Integer.MIN_VALUE, 1, 1};
        System.out.print(thirdMax(nums));
    }
}
