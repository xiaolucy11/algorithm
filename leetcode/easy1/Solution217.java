package interview.easy1;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/6/23 0023.
 */
public class Solution217 {
    public  boolean containsDuplicate(int[] nums){
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return  true;
            }else {
                map.put(nums[i], 1);
            }
        }

        return  false;
    }

    @Test
    public void  test(){
        int[] nums = new int[]{1,2,3,4};
        System.out.print(containsDuplicate(nums));
    }
}
