package interview.easy1;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/6/18 0018.
 */
public class Solution169 {
    public int majorityElement(int[] nums){
        Map<Integer, Integer> count = new TreeMap<>();
        for(int i = 0; i< nums.length; i++){
            if(count.containsKey(nums[i])){
                int value = count.get(nums[i]);
                count.put(nums[i], value + 1);
            }else {
                count.put(nums[i], 1);
            }
        }
        for(Integer key : count.keySet()){
            if(count.get(key) > nums.length / 2){
                return key;
            }
        }
        return Integer.MIN_VALUE;
    }
    //Moore's Voting Algorithm
    public int majorityElement1(int[] nums){
        int result = 0;
        int count =0 ;
        for(int i = 0; i < nums.length;i++){
            if(count == 0){result = nums[i];}
            else {
                if(result == nums[i]){ count++;}
                else  {count--;}
            }
        }
        return  result;
    }

    @Test
    public  void  test(){
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int result = majorityElement(nums);
        System.out.print(result);
    }
}
