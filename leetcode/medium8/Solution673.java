package algorithm.medium8;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/30.
 */
public class Solution673 {

    //Accepted ----22ms
    /*
        dp algorithm
        time complexity O(n^2)
     */
    public int findNumberOfLis(int[] nums){
        if(nums.length == 0){
            return  0;
        }
        int[] arr = new int[nums.length];
        int[] counts = new int[nums.length];
        arr[0] = 1;
        counts[0] = 1;
        int maxIncreasingLength = 1;
        int maxCount = 1;
        for(int i = 1; i < nums.length; i++){
            int maxValue = 0;
            int count  = 0;
            for(int j = i - 1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    if(arr[j] > maxValue){
                        maxValue = arr[j];
                        count = counts[j];
                    }else if(arr[j] == maxValue){
                        count += counts[j];
                    }
                }
            }

            arr[i] = maxValue + 1;
            if (maxValue == 0){
                counts[i] = 1;
            }else {
                counts[i] = count;
            }

            if(arr[i] > maxIncreasingLength){
                maxIncreasingLength = arr[i];
                maxCount = counts[i];
            }else if(arr[i] == maxIncreasingLength){
                maxCount += counts[i];
            }
        }

        return  maxCount;
    }

    @Test
    public  void  test(){
        int[] nums = {1,3,5,4,7};
//        int[] nums = {2,2,2,2,2};
//        int[] nums = {1,2,4,3,5,4,7,2};
        long startTime = System.currentTimeMillis();
        int result = findNumberOfLis(nums);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
