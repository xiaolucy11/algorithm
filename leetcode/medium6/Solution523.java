package algorithm.medium6;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlu on 2018/10/15.
 */
public class Solution523 {

    public  boolean search(int[] nums, int start, int end, int sum,int k){
        if(start == end){
            return  false;
        }
        if(end - start == 1){
            if(sum % k == 0){
                return  true;
            }else {
                return  false;
            }
        }
        if(sum % k == 0){
            return  true;
        }

        int value1 = sum - nums[start];
        int value2 = sum - nums[end];
        if((sum - nums[start]) % k == 0){
            return true;
        }else if((sum - nums[end]) % k == 0){
            return  true;
        }else {
            return  search(nums, start + 1, end - 1, sum - nums[start] - nums[end], k);
        }
    }
    public  boolean checkSubarraySum(int[] nums, int k ){
        int sum = 0;
        for (int i =0; i < nums.length; i++){
            sum += nums[i];
        }

        if(k == 0){
            if(sum  == 0 && nums.length >= 2){
                return  true;
            }else {
                return  false;
            }
        }
        return  search(nums,0, nums.length-1, sum,k);
    }

    //accepted ----32ms
    /*
        brute solution
        time complexity O(nlong(n))
     */
    public  boolean checkSubarraySum1(int[] nums, int k ){
        int sum1 = 0;
        for (int i =0; i < nums.length; i++){
            sum1 += nums[i];
        }

        if(k == 0){
            if(sum1  == 0 && nums.length >= 2){
                return  true;
            }else {
                return  false;
            }
        }

        for(int i = 0; i < nums.length; i++){
            int sum = nums[i];
            for(int j = i +1; j < nums.length; j++){
                sum += nums[j];
                if(sum % k == 0){
                    return  true;
                }
            }
        }
        return  false;
    }

    //Accepted ---9ms
    /*
        idea from other
     */
    public  boolean checkSubarraySum2(int[] nums, int k ){
        int sum1 = 0;
        for (int i =0; i < nums.length; i++){
            sum1 += nums[i];
        }

        if(k == 0){
            if(sum1  == 0 && nums.length >= 2){
                return  true;
            }else {
                return  false;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            sum = (sum + nums[i]) % k;
            Integer pos = map.get(sum);
            if(pos != null){
                if(i - pos >= 1){
                    return  true;
                }
            }else {
                map.put(i,sum);
            }
        }
        return  false;
    }


    @Test
    public  void  test(){
//        int[] nums = {23,2,4,6,7};
//        int[] nums = {23,2,6,4,7};
        int[] nums = {18,373,97,499,525,170,133,376,77,279,257,168,319,335,237,36,236,41,360,131,172,279,405,236,296,377,348,411,135,411,273,230,103,274,211,427,101,243,31,485,282,40,28,81,6,318,502,521,140,110,467,248,404,107,108,129,113,113,333,83,242,194,112,446,463,102,145,107,73,47,53,455,301,150,314,13,180,119,234,509,199,
                503,69,224,228,427,309,497,342,329,518,35,425,343,417,509,85,234,426,334};
        int k = 250;
        System.out.println("length of nums : " + nums.length);
        long startTime = System.currentTimeMillis();
        boolean b = checkSubarraySum2(nums,k);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + b);
        System.out.println("running time : " + (endTime -startTime));
    }
}
