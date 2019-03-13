package interview.easy4;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
public class Solution645 {
    //Accepted -----39ms
    public int[] findErrorNums(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int j = 1; j <= nums.length; j++){
            if(map.containsKey(j) && map.get(j) == 2){
                result[0] = j;
            }
            if(!map.containsKey(j)){
                result[1] = j;
            }
        }
        return  result;
    }


    //Accepted -----16ms
    public int[] findErrorNums1(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[2];
        int index = 0;
        int sum1 = 0, sum2 = 0;
        for(; index < nums.length-1; index++){
            sum1 += index + 1;
            if(nums[index] == nums[index+1]){
                result[0] = nums[index];
            }else {
                sum2 += nums[index];
            }
        }
        sum1 += index+1;
        sum2 += nums[index];
        result[1] = sum1 - sum2;
        /*if (nums[index] != 1) {
            result[1] = 1;
            while (index < nums.length - 1) {
                if (nums[index] == nums[index + 1]) {
                    result[0] = nums[index];
                }
                index++;
            }
        } else {
            while (index < nums.length - 1) {
                if (nums[index] != index + 1) {
                    result[1] = index + 1;
                }
                if (nums[index] == nums[index + 1]) {
                    result[0] = nums[index];
                }
                index++;
            }
            if (nums[index] != index + 1) {
                result[1] = index + 1;
            }
            if (nums[index] == nums[index - 1]) {
                result[0] = nums[index];
            }
        }*/
        return result;
    }

    //solution3  , get new array, record the number range from 1 to nums.length
    public int[] findErrorNums2(int[] nums){
        int[] array = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            array[nums[i]]++;
        }
        int[] result = new int[2];
        for(int i = 1; i < array.length;i++){
            if(array[i] == 0){
                result[1] = array[i]+1;
            }
            if(array[i] > 1){
                result[0] = array[i]+1;
            }
        }
        return  result;
    }


    @Test
    public  void  test(){
        int[] nums = {3,2,3,4,6,5};
        int[] result = findErrorNums2(nums);
        System.out.println("duplicate number : " + result[0] + " missing number : " +result[1]);
    }
}
