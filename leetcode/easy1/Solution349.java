package interview.easy1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * Created by Administrator on 2018/6/30 0030.
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> set1 = new HashSet<>();
        Vector<Integer> vector = new Vector<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            if(!set1.contains(nums1[i])){
                set1.add(nums1[i]);
            }
        }
        for(int i = 0; i < nums2.length; i++){
            if(!set2.contains(nums2[i])){
               set2.add(nums2[i]);
            }
        }
        for(Integer value : set2){
            if(set1.contains(value)){
                vector.add(value);
            }
        }
       int[] result = new int[vector.size()];
        int index = 0;
        for(int j = 0; j < vector.size(); j++){
            result[index++] = vector.get(j);
        }
        return  result;

    }

    @Test
    public  void  test(){
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        int[] result = intersection(num1, num2);

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + "  ");
        }
    }
}
