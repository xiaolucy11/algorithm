package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/28 0028.
 */
public class Solution704 {
    public  int searchInterval(int[] nums, int start, int end, int target){
        if(start > end){return  -1;}
        else  if( start == end){
            if(nums[start] == target){
                return start;
            } else {
                return  -1;
            }
        }
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return  mid;
            }else if (nums[mid] > target){
                return  searchInterval(nums, start, mid, target);
            }else {
                return  searchInterval(nums, mid + 1, end, target);
            }

    }

    //Accepted ----2ms
    public  int search(int[] nums, int target){
        return  searchInterval(nums, 0, nums.length - 1, target);
    }

    @Test
    public  void  test(){
        int[] nums = {-1,0,3,5,9,12};
        System.out.print(search(nums, -2));
    }
}
