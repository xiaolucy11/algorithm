package algorithm.medium8;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/11/1.
 */
public class Solution698 {

    //Wrong solution
    public  boolean canPartitionKSubsets(int[] nums, int k){
        if(k == 1){
            return  true;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if(sum % k != 0){
            return  false;
        }

        int subSum = sum / k;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i],list);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == subSum){
                count++;
            }else {
                int diff = subSum - nums[i];
                if(!map.containsKey(diff)){
                    return  false;
                }else {
                    List<Integer> temp = map.get(diff);
                    if(temp.size() == 0){
                        return  false;
                    }
                    temp.remove(temp.size() - 1);
                    map.put(diff, temp);
                }
            }
        }

        return  true;
    }

    //Accepted -----7ms
    /*
        trackbacking and memorization
     */
    public boolean search(int[] nums,int index,int totalSum, int sum){
        if(index < 0){
            return false;
        }

        if(nums[index] + sum > totalSum){
            return  false;
        }
        if(nums[index] + sum == totalSum){
            nums[index] = 0;
            return  true;
        }
        sum += nums[index];
        for(int i = index - 1 ; i >= 0; i--){
            if(nums[i] != 0 && search(nums, i,totalSum, sum)){
                nums[index] = 0;
                return  true;
            }
        }
        return  false;
    }


    public  boolean canPartitionKSubsets1(int[] nums, int k){
        if(k == 1){
            return  true;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if(sum % k != 0){
            return  false;
        }
        int subSum = sum / k;

        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] != 0){
                if(!search(nums,i,subSum, 0 )){
                    return  false;
                }
            }
        }

        return  true;
    }

    @Test
    public  void  test(){
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;

     /*int[] nums = {4,15,1,1,1,1,3,11,1,10};
        int k = 3;*/

        long startTime = System.currentTimeMillis();
        boolean b = canPartitionKSubsets1(nums,k);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + b);
        System.out.println("running time : " + (endTime - startTime));
    }
}
