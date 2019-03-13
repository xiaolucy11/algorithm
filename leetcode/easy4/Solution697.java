package interview.easy4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/28 0028.
 */
public class Solution697 {
    //Accepted ------23ms
    public  int findShortestSubArray(int[] nums){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
           if(!map.containsKey(nums[i])){
               List<Integer> list = new ArrayList<>();
               list.add(i);
               map.put(nums[i], list);
           }else {
               map.get(nums[i]).add(i);
           }
        }
        int maxCount = 0;
        int minLenght = 50000;
        for(Integer key : map.keySet()){
            int listLen = map.get(key).size();
            int diff = map.get(key).get(listLen - 1) - map.get(key).get(0) + 1;
            if(listLen > maxCount){
                maxCount = listLen;
                minLenght = diff;
            }else if(listLen == maxCount ){
                if(diff < minLenght) {
                    minLenght = diff;
                }
            }else {
                continue;
            }
        }
     return  minLenght;
    }

    @Test
    public  void  test(){
        int[] nums = {1,2,2,3,1,4,2};
        System.out.print(findShortestSubArray(nums));
    }
}
