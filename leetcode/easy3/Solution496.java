package interview.easy3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/13 0013.
 */
public class Solution496 {
    //Accepted
    public  int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int flag = 0;
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    flag = 1;
                    map.put(nums2[i], nums2[j]);
                    break;
                }

            }
            if (flag == 0) {
                map.put(nums2[i], -1);
            }

        }
        for (int k = 0; k < nums1.length; k++) {
            result[k] = map.get(nums1[k]);
        }
        return result;
    }

    @Test
    public  void  test(){
        int[] num1 = {2,4};
        int[] num2 = {1,2,3,4};
        int[] result = nextGreaterElement(num1, num2);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
