package interview.easy3;

import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2018/7/16 0016.
 */
public class Solution532 {
    /*public  int[] delete(int[] nums){
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int[] result = new int[set.size()];
        int index = 0;
        for(Integer value : set){
            result[index++] = value;
        }
        return  result;
    }*/
    public  boolean isInList(List<Integer> list, int value){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == value){
                return  true;
            }
        }
        return  false;
    }
    //running time exceed
    public  int findPairs(int[] nums, int k){
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        for( int i = 0; i < nums.length; i++){
            if((i > 0) && (nums[i] == nums[i-1])){continue;}
            for( int j = i + 1; j < nums.length; j++){
                if(nums[j] == nums[j-1]){continue;}
                boolean b1 = (!map.containsKey(nums[i])) || !isInList(map.get(nums[i]), nums[j]);
                boolean b2 = (!map.containsKey(nums[j])) || !isInList(map.get(nums[j]), nums[i]);
                if(Math.abs(nums[i] - nums[j]) == k && b1 && b2){
                    if(map.containsKey(nums[i])) {
                        List<Integer> l = map.get(nums[i]);
                        l.add(nums[j]);
                        map.put(nums[i], l);
                    }else {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[j]);
                        map.put(nums[i], l );
                    }
                    System.out.println(i + ":  " + j + "   " + nums[i] + " ---" + nums[j]);
                    count++;
                }
            }
        }
        return  count;
    }

    //Accepted --- 138ms
    public  int findPairs1(int[] nums, int k){
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if((i > 0) && nums[i] == nums[i-1]){continue;}
            int flag1 = 0, flag2 = 0;
            for(int j = i + 1; j < nums.length; j++){
                if( nums[i] - k == nums[j]){
                    flag1 = 1;
                }
                if(nums[i] + k == nums[j] &&  k != 0){
                    flag2 = 1;
                }
                if(flag1 == 1 && flag2 == 1){
                    break;
                }
            }
            if(flag1 == 1 && flag2 == 1){
                map.put(nums[i], 2);
            }else if((flag1 == 1 && flag2 == 0) || (flag1 ==0 && flag2 == 1)){
                map.put(nums[i],1);
            }else {
                continue;
            }
        }
        int count = 0;
        for(Integer key: map.keySet()){
            count += map.get(key);
        }
        return  count;
    }
    //Accepted ----- 52ms
    public  int findPairs2(int[] nums, int k){
        if(k < 0){return  0;}
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){continue;}
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] - nums[i] == k){
                    count++;
                    break;
                }
            }
        }
        return  count;
    }


    public  int findPairs3(int[] nums, int k){
        if(k < 0){return  0;}
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        if(k == 0){
            for(Integer key : map.keySet()){
                if(map.get(key) > 1){count++;}
            }
        }
        if(k > 0){
            for(Integer key : map.keySet()){
                if(map.containsKey( key - k) ){
                    count++;
                }
            }
        }
        return  count;
    }

    @Test
    public  void  test(){
        int[] nums = new int[]{1,1,1,2,1};
        long sartTime = System.currentTimeMillis();
       System.out.println(findPairs3(nums, 1));
        long endTime = System.currentTimeMillis();
        System.out.println("running time :" + (endTime - sartTime));
    }
}
