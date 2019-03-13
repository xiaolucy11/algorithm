package algorithm.medium7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youlu on 2018/10/20.
 */
public class Solution560 {
    public  int kEqualZero(int[] nums ){
        int sum = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++ ){
            sum += nums[i];
            if(map.containsKey( sum)){
                count++;
            }
            map.put(sum,i);
        }
        return count;
    }


    //Wrong Solution
    public  int subarraySum(int[] nums, int k){
        if(nums.length == 1){
            if(nums[0] == k){
                return 1;
            }else {
                return 0;
            }
        }
        if(k == 0){
            return kEqualZero(nums);
        }
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            sum = (sum + nums[i]) % k;
            Integer index = map.get(sum);
            if(index != null){
                count++;
            }
            map.put(sum, i);
        }
        if(count == 0){
            return 0;
        }else {
            return count + 1;
        }
    }

    //Accepted ----27ms
    /*
        time complexity O(n)
     */
    public  int subarraySum1(int[] nums, int k){
        int sum = 0, count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> start = new ArrayList<>();
        start.add(-1);
        map.put(0,start);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                List<Integer> list = map.get(sum - k);
                count += list.size();
            }
            if(map.containsKey(sum)){
                List<Integer> input = map.get(sum);
                input.add(i);
                map.put(sum, input);
            }else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(sum, l);
            }
        }

        return count;
    }

    @Test
    public  void  test(){
        int[] nums = {1,1,1};
        int k = 2;
   /*int[] nums = {-1,-1,1};
        int k = 0;*/
  /* int[] nums = {1,2,3};
        int k = 3;*/


        long startTime = System.currentTimeMillis();
        int result = subarraySum1(nums, k);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }


    @Test
    public  void  test1(){
        System.out.println(0 % 2);
    }
}
