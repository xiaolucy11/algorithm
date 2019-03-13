package interview.medium3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/9/11 0011.
 */
public class Solution220 {

    //Time Limited out
    public  boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
        int length = nums.length;
        long longT = (new Integer(t)).longValue();
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j <= i + k && j < length; j++){
                long value1 = (new Integer(nums[i])).longValue();
                long value2 = (new Integer(nums[j])).longValue();
                long value = value1 - value2;
                if(Math.abs(value) <= longT){
                    return  true;
                }
            }
        }
        return  false;
    }


    public  boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t){
        return  false;
    }

    @Test
    public  void  test(){
        int[] nums = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int k = 1;
        int t = Integer.MAX_VALUE;
        System.out.print(containsNearbyAlmostDuplicate(nums, k, t));
    }


}
