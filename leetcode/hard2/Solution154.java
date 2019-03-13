package algorithm.hard2;

import org.junit.Test;

public class Solution154 {


    //Accepted ------1ms
    /*
        time complexity O(log(n))

        bound condition is too complex
     */
    public int find(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }
        if(end - start == 1){
            return Math.min(nums[start], nums[end]);
        }

        int mid = start + (end - start) / 2;
        if(nums[mid -1] < nums[mid] && nums[mid] < nums[mid+1]){
            if(nums[end] > nums[mid]) {
                return find(nums, start, mid);
            }else {
                return find(nums,mid,end);
            }
        }else if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]){
            return find(nums, mid+1, end);
        }else if(nums[mid-1] > nums[mid] && nums[mid] <  nums[mid+1]){
            return find(nums,mid, end);
        }else if(nums[mid-1] > nums[mid] && nums[mid] > nums[mid+1]){
            return  find(nums,mid,end);
        }else {
            if(nums[mid-1] == nums[mid] && nums[mid] == nums[mid+1]){
                if(nums[end] == nums[mid] && nums[mid] == nums[start]) {
                    return  find(nums,start+1,end-1);
                }else if(nums[start] == nums[mid] && nums[mid] != nums[end]){
                    if(nums[mid] < nums[end]){
                        return find(nums, start, mid);
                    }else {
                        return  find(nums, mid, end);
                    }
                }else if(nums[start] != nums[mid] && nums[mid] == nums[end]){
                    if(nums[start] < nums[mid]){
                        return find(nums, start, mid);
                    }else {
                        return  find(nums, mid, end);
                    }
                }else {
                    if(nums[mid] < nums[end]){
                        return  find(nums, start,mid);
                    }else {
                        return find(nums,mid,end);
                    }
                }
            }else if(nums[mid-1] != nums[mid] && nums[mid] == nums[mid+1]){
                if(nums[mid] > nums[end]){
                    return find(nums,mid,end);
                }else {
                    return  find(nums,start,mid);
                }
            }else {
                if(nums[mid] > nums[mid+1]){
                    return nums[mid+1];
                }else {
                    if(nums[mid] >= nums[end]){
                        return  find(nums,mid,end);
                    }else {
                        return find(nums, start, mid);
                    }
                }
            }
        }
    }


    public int findMin(int[] nums){
        return  find(nums,0,nums.length-1);
    }

    /*
        code from other
     */
    public int findMin1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }

            int mid = left + (right - left) / 2;

            // 左中右相等的時候無法判斷, min可能在左中或中右
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[mid] >= nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return Math.min(nums[left], nums[right]);
    }


    @Test
    public  void  test(){
//        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {1,2,3};
//        int[] nums = {2,2,2,1,1,2};
//        int[] nums = {1,10,10,10,10};
//        int[] nums = {10,1,10,10,10};
//        int[] nums = {3,3,3,3,3,3,3,3,1,3};
//        int[] nums = {1,1,2,2,0,0};
//        int[] nums = {0,0,1,1,2,0};
//        int[] nums = {0,1,1,2,3,0};
        int[] nums = {10,10,10,-10,-10,-10,-10,-9,-9,-9,-9,-9,-9,-9,-8,-8,-8,-8,
                -8,-8,-8,-8,-7,-7,-7,-7,-6,-6,-6,-5,-5,-5,-4,-4,-4,-4,-3,-3,-2,-2,-2,-2,
                -2,-2,-2,-2,-1,-1,-1,-1,-1,0,0,0,0,0,0,0,1,1,1,1,2,2,2,2,2,2,
                2,3,3,3,4,4,4,5,5,5,5,6,6,6,7,7,7,7,7,8,8,8,8,9,9,9,9,9,9,9,10,10};


        long startTime = System.currentTimeMillis();
        int result = findMin(nums);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
