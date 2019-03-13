package interview.easy1;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/6/23 0023.
 */
public class Solution219 {
    public  boolean containsNearbyDuplicate(int[] nums, int k){
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int preIndex = map.get(nums[i]);
                if( i - preIndex <= k){return  true;}
                else {
                    map.put(nums[i], i);
                }
            }else {
                map.put(nums[i], i);
            }
        }
        return  false;
    }

    @Test
    public  void  test(){
        int[] nums = new int[]{1,2,3,1,2,3};
        System.out.print(containsNearbyDuplicate(nums, 2));
    }
}
