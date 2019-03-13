package algorithm.medium6;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by youlu on 2018/10/8.
 */
public class Solution462 {
    //Accepted -----8ms
    /*
        time complexity O(nlog(n))

        it can be optimized, using findKth function to find midium element,
        and compute abs different
     */
    public  int minMoves2(int[] nums){
        Arrays.sort(nums);
        int length = nums.length;
        if(length % 2 == 1){
            int midValue = nums[length / 2];
            int sum = 0;
            for(int i = 0; i <length; i++){
                sum += Math.abs(nums[i] - midValue);
            }
            return  sum;
        }else {
            int midValue1 = nums[length / 2];
            int midValue2 = nums[length / 2 - 1];
            int sum1 = 0, sum2 = 0;
            for(int i = 0; i < length; i++){
                sum1 += Math.abs(nums[i] - midValue1);
                sum2 += Math.abs(nums[i] - midValue2);
            }
            return  Math.min(sum1, sum2);
        }
    }

    @Test
    public  void  test(){
        int[] nums = {1,2,3};
        long startTime = System.currentTimeMillis();
        System.out.println("result : " + minMoves2(nums));
        long endTime = System.currentTimeMillis();
        System.out.println("running time : " + (endTime - startTime));
    }
}
