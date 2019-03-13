package algorithm.medium7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by youlu on 2018/10/20.
 */
public class Solution565 {
    public int nextElementSet(int[] nums, int value, int[] arr){
      Set<Integer> set = new HashSet<>();
        while (!set.contains(value)){
            arr[value] = 1;
            set.add(value);
            value = nums[value];
        }

        return set.size();
    }


    //Accepted ----44ms
    public  int arrayNestint(int[] nums ){
        int longestLength = 0;
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
                if (nextElementSet(nums, nums[i],arr) > longestLength) {
                    longestLength = nextElementSet(nums, nums[i],arr);
                }
            }
        }
        return  longestLength;
    }

    /*
        not using Set to judge duplicate elment

        code from other
     */
    public int arrayNesting1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) continue;
            int count = 0;
            int index = i;
            while (nums[index] >= 0) {
                count++;
                int next = nums[index];
                nums[index] = -1;
                index = next;
            }
            result = Math.max(result, count);
        }
        return result;
    }



    @Test
    public  void  test(){
     int[] A = {5,4,0,3,1,6,2};
//        int[] A = {1,0,3,4,2};
        long startTime = System.currentTimeMillis();
        int result = arrayNestint(A);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
