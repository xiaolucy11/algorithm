package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/29 0029.
 */
public class Solution81 {
    public  boolean binarySearch(int[] nums, int start, int end, int target){
        if(start > end){
            return false;
        }

        int mid = start + (end - start) / 2;
        if(nums[mid] == target){
            return  true;
        }else if(nums[mid] > target) {
           return binarySearch(nums, start, mid-1, target);
        }else {
            return  binarySearch(nums, mid + 1, end, target);
        }
    }

    //Accepted ----1ms
    public boolean search(int[] nums, int target){
        if(nums.length == 0){
            return  false;
        }
        int index = 0;
        while (index < nums.length - 1){
            if(nums[index] <= nums[index + 1]){
                index++;
            }else {
                break;
            }
        }

        if(nums[0] == target){
            return  true;
        }else  if(nums[0] > target){
            return  binarySearch(nums, index + 1, nums.length - 1, target);
        }else {
            return  binarySearch(nums, 0, index, target);
        }
    }


    // Accepted  ------1ms
    // ugly code, it contains too many statements of if -esle
    public  boolean search1(int[] nums, int target){
        if(nums.length == 0){
            return  false;
        }

        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return  true;
            }else {

                if(nums[left] > nums[mid]){
                    if(target > nums[mid] && target <= nums[right]){
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }

                }else if(nums[left] < nums[mid]){
                    if(target >= nums[left] && target < nums[mid]){
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }

                }else {
                    if(mid == left){
                        left = mid + 1;
                    }else {
                        left = left + 1;
                    }

                }

              /*   if((nums[left] > target && nums[mid] > target)
                        || (nums[left] < target && nums[mid] > target) ){
                    right = mid - 1;
                }*/

            }

            }
           /* if(nums[mid] == target){
                return  true;
            }else {
                if(nums[left] == nums[mid]){
                       left = mid + 1;
                }else if(nums[left] > nums[mid]){
                    if(target <= nums[right]){
                        left = mid;
                    }else {
                        right = mid - 1;
                    }
                }else {
                    if(target < nums[mid] && target < nums[left]){
                        left = mid + 1;
                    }else if(target < nums[mid] && target >= nums[left]){
                        right = mid;
                    }else if(target)
                }
*/


        if(nums[left] == target){
            return  true;
        }else {
            return  false;
        }
    }

    //reference from other
    public  boolean search2(int[] nums, int target){
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            } else if (nums[mid] > nums[start]){
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                start++;
            }
        }
        return false;
    }

    @Test
    public  void  test(){
        int[] nums = {1,1,3,1};
        System.out.print(search1(nums, 3));
    }
}
