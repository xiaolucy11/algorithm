package interview.easy3;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/21 0021.
 */
public class Solution594 {
    // Accepted ------47ms
    public  int findLHS(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int count = Integer.MIN_VALUE;
        for(Integer key : map.keySet()){
            if((map.containsKey(key - 1) && (map.get(key) + map.get(key - 1) > count))){
                count = map.get(key) + map.get(key-1);
            }
            if((map.containsKey(key+1) && (map.get(key) + map.get(key+1) > count))){
                count = map.get(key) + map.get(key+1);
            }
        }
        return  count;
    }

    // sorted solution
    //Accepted -------28ms
    public  int findLHS1(int[] nums){
        Arrays.sort(nums);
        int quick = 0, slow = 0;
        int count = 0;
        while(quick < nums.length){
            if(nums[slow] == nums[quick]){
                quick++;
            }else {
                if(nums[quick] - nums[slow] == 1){
                    int temp = quick;
                    while(temp < nums.length && nums[temp] == nums[quick]){
                        temp++;
                    }
                    if(temp - slow > count){
                        count = temp - slow;
                    }
                    slow = quick;
                    quick = temp;
                }else {
                   slow = quick;
                    quick++;
                }
            }
        }
        return  count;
    }

    @Test
    public  void  test(){
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.print(findLHS1(nums));
    }
}
