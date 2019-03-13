package interview.easy3;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/7/20 0020.
 */
public class Solution581 {

    //Accepted -----23ms
    public  int findUnsortedSubarray(int[] nums){
        int[] copyNums = nums.clone();
        Arrays.sort(copyNums);
        int startIndex = 0, endIndex = nums.length - 1;
        int startDiff = 0, endDiff = 0;

        while(startIndex < nums.length){
            if(copyNums[startIndex] == nums[startIndex]){
                startIndex++;
            }else {
                startDiff = startIndex;
                break;
            }
        }
        while (endIndex >= 0){
            if(copyNums[endIndex] == nums[endIndex]){
                endIndex--;
            }else {
                endDiff = endIndex;
                break;
            }
        }

        return  endDiff - startDiff + 1;
    }


    //reference from others ------------- genius solution
    public  int findUnsortedSubarray1(int[] nums){
        if(nums.length == 1){return  0;}
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
        int minIndex = 0, maxIndex = -1;

       for(int i = 0; i < nums.length; i++){
           if(nums[i] >= maxValue){
               maxValue = nums[i];
           }else {
               maxIndex =i;
           }
       }
       for(int j = nums.length - 1; j >= 0; j--){
           if(nums[j] <= minValue){
               minValue = nums[j];
           }else {
               minIndex = j;
           }
       }
       System.out.println("maxIndex : " + maxIndex + "   minIndex : " + minIndex);
       return  maxIndex - minIndex + 1;
    }

    @Test
    public  void  test(){
        int[] nums = {1,2,3,3,3};
        System.out.print(findUnsortedSubarray1(nums));
    }
}
