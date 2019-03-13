package interview.easy1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Administrator on 2018/7/1 0001.
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2){
        Map<Integer, Integer> map = new HashMap<>();
        Vector<Integer> vector = new Vector<>();
        for(int i = 0; i < nums1.length; i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i],1);
            }else {
                int temp1 = map.get(nums1[i]);
                map.put(nums1[i], temp1 + 1);
            }
        }
        for(int j = 0; j < nums2.length; j++){
            if(map.containsKey(nums2[j])){
                vector.add(nums2[j]);
                if(map.get(nums2[j]) == 1){
                    map.remove(nums2[j]);
                }else {
                    int temp2 = map.get(nums2[j]);
                    map.put(nums2[j], temp2 - 1);
                }
            }

        }
        int[] result= new int[vector.size()];
        int index = 0;
        for(int k = 0; k < vector.size(); k++){
            result[index++] = vector.get(k);
        }
        return  result;
    }

    @Test
    public void test(){
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        int[] result = intersect(num1, num2);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + "  ");
        }
    }
}
