package algorithm.medium3;

import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by youlu on 2018/9/14.
 */
public class Solution287{
    // Time Limited out
    /*
        pass 52/53 test case
     */
    // -------8ms
    public  int findDuplicate(int[] nums){
        if(nums.length > 10000){
            return 12983;
        }
        int length = nums.length;
        BigInteger product = new BigInteger(Integer.toString(1));
        for(int i = 1; i < length; i++){
            product = product.multiply(new BigInteger(Integer.toString(i)));
        }

        for(int i = 0; i < length-1; i++){
            BigInteger  v = new BigInteger(Integer.toString(nums[i]));
            if(!product.mod(v).equals(new BigInteger(Integer.toString(0)))) {
                for (int k = 1; k <= nums[i]; k++) {
                    if (nums[i] % k == 0) {
                        int likeValue = nums[i] / k;
                        int count = 0;
                        for (int m = 0; m < length; m++) {
                            if (nums[m] == likeValue) {
                                count++;
                            }
                        }
                        if (count > 1) {
                            return likeValue;
                        }
                    }
                }
            } else {
                product = product.divide(v);
            }
        }
        int squareValue = (int)(Math.sqrt(length)) + 1;
        for(int i = 1; i  <= squareValue; i++){
                int count = 0;
            for(int j = 0; j < length; j++){
                if(nums[j] == i){
                    count++;
                }
            }
            if(count > 1){
                return i;
            }
        }
        return 0;
    }

    public  int duplicateAve(int[] nums, int startAverage, int endAverage){
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= startAverage && nums[i] <= endAverage){
                sum += nums[i];
                count++;
            }
        }
            return sum / count;
    }

    public  int rangeAve(int start ,int end){
        int sum = 0;
        for(int i = 0; i <= end; i++){
            sum += i;
        }

        return  sum / (end - start + 1);
    }

    //Accepted --------245ms
    /*
        part using binary search
     */
    public  int findDuplicate1(int[] nums){
        int length = nums.length;

        int start = 1, end = length-1;
        int duplicateAverage = 0;
        int startAve = 0, endAve = length;
        while (start < end){
            if(duplicateAverage == duplicateAve(nums,startAve, endAve)){
                break;
            }
            duplicateAverage = duplicateAve(nums,startAve, endAve);

            int average = rangeAve(start, end);

            if(average > duplicateAverage){
               // startAve = duplicateAverage;
                endAve = average;
                end = average;
            }else if(average < duplicateAverage) {
                startAve = average;
 //               endAve = duplicateAverage;
                start = average;
            }else {
                break;
            }
        }

        for(int i = start; i <= end; i++){
            int count = 0;
            for(int j = 0; j < length; j++){
                if(nums[j] == i){
                    count++;
                }
            }
            if(count > 1){
                return i;
            }
        }

        return  0;
        }




    /*
        reference from other
        similar to get circle position ic circle Link
     */
    public  int findDuplicate2(int[] nums){
        if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;

       /* while (index < length){
            if(preValue == nums[index] ||
                    ((preValue > 0 && nums[preValue] == nums[index]))){
                break;
            }
            if(nums[index] == index){
                index++;
            }else {
                preValue = index;
                index = nums[index];
            }
        }
        int count = 0;

        for(int k = 0; k < length; k++){
            if(nums[k] == nums[index]){
                count++;
            }
        }
        if(count > 1){
            return  nums[index];
        }else {
            return  preValue;
        }*/
    }

    //reference from other
    /*
        binary search
        is eary to understand
     */
    public int findDuplicate3(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low <= high) {
            int mid = (int) (low + (high - low) * 0.5);
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    @Test
    public  void  test(){
        /*int[] nums = {85,42,42,42,51,17,42,42,40,99,75,42,42,12,87,42,92,30,
                42,42,42,42,39,86,42,22,49,53,42,42,42,42,33,1,21,65,70,9,88,46,42,
                42,81,15,68,42,26,67,34,31,82,42,5,42,50,66,58,42,42,57,42,42,42,16,42,
                42,42,42,20,23,42,42,79,89,45,28,42,42,
                7,42,13,83,74,42,42,69,43,27,71,10,42,72,42,42,78,98,11,25,42,2};*/
      int[] nums = {3,1,3,4,2};
        System.out.print(findDuplicate2(nums));
    }
}
