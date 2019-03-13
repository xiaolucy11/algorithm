package algorithm.medium6;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/12.
 */
public class Solution494 {
    public  int count;
    public  void  search(int[] nums, int index, int sum , int S){
        if(index == nums.length ){
            if(sum == S) {
                count++;
            }
            return;
        }
        sum += nums[index];
        search(nums, index+1, sum, S);
        sum = sum - 2 * nums[index];
        search(nums, index+1, sum, S);
    }

    //Accepted ---- 838ms
    /*
        brute solution
     */
    public int findTargetSumWays(int[] nums, int S){
        count = 0;
        search(nums, 0, 0,S);
        return  count;
    }

    //Accepted ----330ms
    public int search1(int[] nums, int end, int target){
        if(end == 0){
            if(nums[end] == target && target == -1 * nums[end]){
                return 2;
            }else if((nums[end] == target && nums[end] != -1 * target) ||
                    (nums[end] != target && nums[end] == -1 * target)){
                return  1;
            }else {
                return 0;
            }
        }

        int value1 = search1(nums, end-1, target - nums[end]);
        int value2 = search1(nums, end-1,  target+ nums[end]);
        return  value1 + value2;
    }
    public int findTargetSumWays1(int[] nums, int S){

        int result = search1(nums,nums.length-1, S);
        return  result;

    }


    @Test
    public  void  test(){
       int[] nums = {1,1,1,1,1};
        int S = 3;
     /* int[] nums = {0,0,0,0,0,0,0,0,1};
        int S = 1;*/
        long startTime = System.currentTimeMillis();
        int result = findTargetSumWays1(nums, S);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));

    }
}
