package algorithm.medium6;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/11.
 */
public class Solution477 {
    public  int countOnes1(int value){
        int count = 0;
        while (value > 0){
            count += value & 0x01;
            value /= 2;
        }
        return count;
    }

    public int countOnes2(int value){
        int count = 0;
        while (value > 0){
            value = value & (value - 1);
            count++;
        }
        return  count;
    }
    public  int totalHammingDistance(int[] nums){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int value = (nums[i]^nums[j]);
                sum += countOnes2(value);
            }
        }

        return  sum;
    }

    public int[] ones;

    public  void countZerosAndOnes(int value){
        int index = 29;
        while (value > 0){
            int lastElement = value & 0x01;
            if(lastElement == 1){
                ones[index]++;
            }
            value /= 2;
            index--;
        }
    }
    public  int get(int value){
        if(value == 1){
            return  0;
        }
        return  (value - 1) * value / 2;
    }

    //Accepted ----48ms
    /*
        time complexity O(n)
     */
    public  int totalHammingDistance1(int[] nums){
        ones = new int[30];
        int maxValue = 0;
        for(int i = 0; i < nums.length; i++){
            countZerosAndOnes(nums[i]);
            if(nums[i] > maxValue){
                maxValue = nums[i];
            }
        }
        int lenght = nums.length;
        int comparingNumber = (lenght-1) * lenght / 2;
        int representBits = 0;
        while ( maxValue > 1){
           representBits++;
            maxValue /= 2;
        }
        if(maxValue == 1){
            representBits++;
        }

        int index = 29, sum = 0;
        while (index >= (29 - representBits + 1)){
            sum += get(ones[index]);
            sum += get(lenght - ones[index]);
            index--;
        }
        return  representBits * comparingNumber - sum;
    }

    /*
        it can be optimized, using bit operation
     */

    @Test
    public  void  test(){
//        int[] nums = {4,14,2};
        int[] nums =  {1,2,3,4};
        long startTime = System.currentTimeMillis();
        int result = totalHammingDistance1(nums);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
