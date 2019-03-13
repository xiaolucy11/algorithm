package algorithm.medium8;

import org.junit.Test;

/**
 * Created by youlu on 2018/11/2.
 */
public class Solution713 {

    public  boolean isAllOne(int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 1){
                return  false;
            }
        }
        return  true;
    }

    public  int fib(int n){
        if(n == 1){
            return 1;
        }
        int[] arr = new int[n+1];
        arr[1] = 1;
        for(int i = 2; i < n+1; i++){
            arr[i] = arr[i-1] * i;
        }
        return  arr[n];
    }

    /*
        dp algorithm , but it can pass the case containing too many 1
        pass test 74 / 84
     */
    public  int numSubarrayProductLessThank(int[] nums, int k){
        if(isAllOne(nums)){
            if(k == 1){
                return 0;
            }else {
                if(nums.length % 2 == 0){
                    return (nums.length / 2) * (nums.length + 1);
                }else {
                    return ((nums.length + 1) / 2) * nums.length;
                }
            }
        }
        int[] arr = new  int[nums.length];
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < k){
                count++;
            }
            arr[i] = nums[i];
        }

        int distance = 1;
        while (true){
            int sum = 0;
            for(int i = 0; i < arr.length; i++){
                if(i + distance < arr.length && arr[i] < k){
                    arr[i] = arr[i] * nums[i+distance];
                    if(arr[i] < k){
                        sum++;
                    }
            }
            }
            if(sum == 0){
                break;
            }
            count += sum;
            distance++;
        }

        return  count;
    }

    //Accepted -----21ms
    /*
        sliding windows
     */
    public  int numSubarrayProductLessThank1(int[] nums, int k){
        if(k <= 1){
            return 0;
        }
        int sum = 0;
        int product = 1;
        int left = 0, right = 0;

        /*while (left < nums.length){
            while (right < nums.length ){
                product *= nums[right];
                if(product < k) {
                    right++;
                }else {
                    break;
                }
            }

            int lenght = right - left;
            if(lenght % 2 == 0){
                sum += (lenght / 2) * (lenght + 1);
            }else {
                sum += lenght * ((lenght + 1) / 2);
            }

            if(right != nums.length){
                if(lenght > 1) {
                    sum -= 1;
                }
            }else {
                break;
            }

            while (product >= k){
                product /= nums[left];
                left++;
            }
            if(left == right && lenght > 1){
                sum++;
            }
            right++;
        }

        return  sum;*/

        while (right < nums.length){
            product *= nums[right];

            while (left <= right && product >= k){
                product /= nums[left];
                left++;
            }
            sum += (right - left + 1);
            right++;
        }

        return  sum;
    }

    /*
        code from other
     */
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

    @Test
    public  void  test(){
       /* int[] nums = {10,5,2,6};
        int k = 100;*/
       int[] nums = new int[48750];
        for(int i = 0; i < 48750; i++){
            nums[i] = 1;
        }
        int k = 5;

    /*  int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int k = 19;*/



        long startTime = System.currentTimeMillis();
       int result = numSubarrayProductLessThank1(nums,k);
//        int result = numSubarrayProductLessThanK2(nums, k);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }

    @Test
    public  void  test1(){
        int[] nums = new int[48750];
        for(int i = 0; i < 48750; i++){
            nums[i] = 1;
        }

        long startTime = System.currentTimeMillis();
        boolean b = isAllOne(nums);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + b);
        System.out.println("running time : " + (endTime - startTime));
    }
}
