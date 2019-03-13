package interview.easy;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/6/16 0016.
 */
public class Soluttion136 {
    public int singleNumber(int[] nums){
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else {
               int tmp = map.get(nums[i]) + 1;
                map.put(nums[i], tmp);
            }
        }
        for(Integer key : map.keySet()){
            if(map.get(key) == 1){
                return key;
            }
        }
        return -1;
    }
}
