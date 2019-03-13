package algorithm.medium7;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/18.
 */
public class Solution540 {
    public  int binarySearch(int[] nums, int start, int end){
        if(start == end){
            return  nums[start];
        }
        int mid = start + (end - start) / 2;
        if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
            return nums[mid];
        }else if(nums[mid] != nums[mid-1] && nums[mid] == nums[mid+1]){
            int leftLength = mid - start;
            if(leftLength % 2 == 1){
                return binarySearch(nums, start, mid -1);
            }else {
                return  binarySearch(nums, mid+2, end);
            }
        }else {
            int leftLength = mid - 2 - start + 1;
            if(leftLength % 2 == 1){
                return  binarySearch(nums, start, mid -2);
            }else {
                return  binarySearch(nums, mid+1, end);
            }
        }
    }

    //Accepted -----1ms
    /*
        time complexity O(log(n))
     */
    public  int singleNonDuplicate(int[] nums){
        return  binarySearch(nums,0, nums.length-1);
    }


    @Test
    public  void  test(){
//        int[] nums = {1,1,2,3,3,4,4,8,8};
//        int[] nums = {3,3,7,7,10,11,11};
        int[] nums = {1,1,2,2,4,4,5,5,9};

        long startTime = System.currentTimeMillis();
        int result = singleNonDuplicate(nums);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
