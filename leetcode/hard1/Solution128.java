package algorithm.hard1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youlu on 2018/12/19.
 */
public class Solution128 {
    public  int  search(int[] nums, int index, Map<Integer, List<Integer>> map,int[]  arr){
        int max = 0;
        if(!map.containsKey(nums[index] - 1)){
            arr[index] = 1;
            return 1;
        }

        List<Integer> list = map.get(nums[index] - 1);
        for(int i = 0; i < list.size(); i++){
            int value = 0;

            if(arr[list.get(i)] == 0) {
                value = search(nums, list.get(i), map, arr);
            }else {
                value = arr[list.get(i)];
            }
            if(value > max){
                max = value;
            }
        }

        arr[index] = max + 1;
        return  arr[index];
    }


    //Accepted ----- 25ms
    /*
        dp algorithm
        time complexity O(n)
     */
    public int longestConsecutive(int[] nums){
        int maxLenght = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                List<Integer> temp1 = new ArrayList<>();
                temp1.add(i);
                map.put(nums[i], temp1);
            }else {
                List<Integer> temp2 = map.get(nums[i]);
                temp2.add(i);
                map.put(nums[i], temp2);
            }
        }

        int[] arr = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(arr[i] == 0){
                maxLenght = Math.max(maxLenght, search(nums,i,map, arr));
            }else {
                maxLenght = Math.max(maxLenght,arr[i]);
            }
        }

        return  maxLenght;
    }


    /*
        code from other
     */
    public int longestConsecutive1(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int ans = 0;
        HashMap<Integer, Integer> m = new HashMap<>();

        for(int num : nums) {
            if(!m.containsKey(num)) {
                int l = m.containsKey(num - 1) ? m.get(num-1) : 0;
                int r = m.containsKey(num + 1) ? m.get(num+1) : 0;
                int sum = l + r + 1;
                ans = Math.max(ans, sum);
                m.put(num, sum);
                m.put(num - l, sum);
                m.put(num + r, sum);
            }
        }

        return ans;
    }

    @Test
    public  void  test(){
        int[] nums = {100,4,200,1,3,2};


        long startTime = System.currentTimeMillis();
        int result = longestConsecutive(nums);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
