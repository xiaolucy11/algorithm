package algorithm.hard2;

import org.junit.Test;

public class Solution327 {


    //Accepted ---173ms
    /*
        brute solution
        time complextiy O(n^2)
     */
    public  int countRangeSum(int[] nums, int lower, int upper){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            long sum = nums[i];
            if(sum >= lower && sum <= upper){
                count++;
            }
            for(int j = i - 1; j >= 0;j--){
                sum += nums[j];
                if(sum >= lower && sum <= upper){
                    count++;
                }
            }
        }

        return  count;
    }

    public  int countRangeSum1(int[] nums, int lower, int upper){
        int count = 0;
        long sum = 0;
        int left = 0, right = 0;

        while (right < nums.length){
            if(nums[right] >= lower && nums[right] <= upper){
                count++;
            }
            if(sum + nums[right] >= lower && sum + nums[left] <= upper){
                count++;
                sum += nums[right];
                right++;
            }else {
                while (left < right){
                    if (sum - nums[left] >= lower && sum - nums[right] <= upper){
                        left++;
                        sum -= nums[left];
                        count++;
                        break;
                    }else {
                        left++;
                    }
                }
            }
        }

        return  count;
    }


    @Test
    public  void  test(){
        int[] nums = {-2,5,-1};
        int lower = -2;
        int upper = 2;

        long startTime = System.currentTimeMillis();
        int result = countRangeSum1(nums, lower, upper);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
