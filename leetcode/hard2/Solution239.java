package algorithm.hard2;

import org.junit.Test;

import java.util.*;

public class Solution239 {

    public  class  Pair implements  Comparable{
        int index;
        int value;
        Pair(int _index, int _value){
            index = _index;
            value = _value;
        }

        @Override
        public int compareTo(Object o) {
            Pair pair = (Pair) o;
            if(value > pair.value){
                return 1;
            }else if(value < pair.value){
                return -1;
            }else {
                if(index > pair.index){
                    return 1;
                }else if(index < pair.index){
                    return -1;
                }else {
                    return 0;
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return index == pair.index &&
                    value == pair.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, value);
        }

    }


    //Accepted -----30ms
    /*
        time  complexity O(nlog(k))
     */
    public  int[] maxSlidingWindow(int[] nums, int k){
        if(nums.length == 0){
            return  nums;
        }
        List<Integer> list = new ArrayList<>();
        Map<Pair,Integer> map = new TreeMap<>();
        for(int i = 0; i < k; i++){
            map.put(new Pair(i,nums[i]), i);
        }

        int left = 0, right = k;
        while (right < nums.length){
            Pair temp = ((TreeMap<Pair, Integer>) map).lastKey();
            list.add(temp.value);
            map.remove(new Pair(left, nums[left]));
            map.put(new Pair(right, nums[right]), right);
            left++;
            right++;
        }

        Pair lastPair = ((TreeMap<Pair, Integer>) map).lastKey();
        list.add(lastPair.value);

        int[] result = new int[list.size()];
        for(int j = 0; j < list.size(); j++){
            result[j] = list.get(j);
        }

        return  result;
    }

    @Test
    public  void  test(){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;


        long startTime = System.currentTimeMillis();
        int[] result = maxSlidingWindow(nums,k);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }

        System.out.println();
        System.out.println("running time :" + (endTime - startTime));
    }
}
