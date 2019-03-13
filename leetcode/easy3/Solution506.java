package interview.easy3;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/7/14 0014.
 */
public class Solution506 {
    //not be accepted,   using python with same logic
    public  String[] findRelativeRanks(int[] nums){
        Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1.compareTo(o2)  == 1) {
                    return 0;
                }else {
                    return 1;
                }
            }
        });
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(Integer key : map.keySet()){
            System.out.print(map.get(key) + "   ");
        }
       String[] result = new String[nums.length];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            int sortedIndex = map.get(nums[i]);
            if(sortedIndex == 0){
                result[index++] = "Gold Medal";
            }else if(sortedIndex == 1){
                result[index++] = "Silver Medal";
            }else if(sortedIndex == 2){
                result[index++] = "Bronze Medal";
            }else {
                char ch = (char)(sortedIndex + 1 + '0');
                result[index++] = Character.toString(ch);
            }
        }
        return  result;
    }


    @Test
    public  void  test(){
        int[] nums = {5,4,3,2,1};
        String[] result = findRelativeRanks(nums);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
