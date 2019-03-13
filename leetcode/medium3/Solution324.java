package algorithm.medium3;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by youlu on 2018/9/18.
 */
public class Solution324 {

    //Accepted -------6ms
    /*
        time comlexity O(nlog(n))
        space complexity  O(n)
     */
    public  void  wiggleSort(int[] nums){
        int length = nums.length;
        Arrays.sort(nums);
       int[] result = new int[length];
        int mid = 0;
        if(length % 2 == 0){
           mid = length / 2;
        }else {
          mid = length / 2 + 1;
        }

        int index1 = length - 1;
        for(int i = 1;i < length; i += 2){
            result[i] = nums[index1--];
        }
        int index2 = mid - 1;
        for(int i = 0; i < length; i += 2){
            result[i] = nums[index2--];
        }
        for(int i = 0; i < length; i++){
            nums[i] = result[i];
        }
    }

    @Test
    public  void  test(){
        int[] nums = {1,3,2,2,3,1};
        wiggleSort(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
