package algorithm.medium4;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/9/25.
 */
public class Solution377 {
    public  void  search(int[] nums,List<Integer> list, Set<List<Integer>> set, int target){
        if(target == 0){
            for(int i = 0; i < list.size(); i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            set.add(new ArrayList<>(list));
        }

        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] <= target){
                int value = target - nums[i];
                list.add(nums[i]);
                search(nums, list, set, value);
                list.remove(list.size()-1);
            }
        }
    }

    //Time Limit Exceed
    public  int combinationSum4(int[] nums, int target){
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        search(nums, new ArrayList<Integer>(),set, target);
        return  set.size();

    }
    public  int help(int[] nums, int[] array, int value){
        if(value < nums[0]){
            return 0;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= value){
                int diff = value - nums[i];
                if(array[diff] != Integer.MIN_VALUE){
                    sum += array[diff];
                }else {
                    sum += help(nums, array, diff);
                }
            }
        }
        return  sum;
    }


    //Accepted ----- 3ms
    /*
        dp Alogrithm
     */
    public  int combinationSum4_1(int[] nums, int target){
        if(nums.length == 0 ){
            return  0;
        }
        Arrays.sort(nums);
        if(target < nums[0]){
            return 0;
        }
        int[] array = new int[target + 1];
        array[nums[0]] = 1;
        int index = 1;

        for(int i = nums[0] + 1; i <= target; i++){
            array[i] = Integer.MIN_VALUE;
        }

        for(int i = nums[0]+1; i <= target; i++){
            if(index < nums.length && i == nums[index]){
                array[i] = 1;
                index++;
            }
            int result = help(nums, array, i);
            if(array[i] == Integer.MIN_VALUE){
                array[i] = 0;
            }
            array[i] += result;
        }

        return array[target];
    }

    public int help1(int[] nums, int[] array, int value){
        if(value < nums[0]){
            return 0;
        }
        if(value == nums[0]){
            return 1;
        }

        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < value){
                int var = value - nums[i];
                if(array[var] != 0){
                    sum += array[var];
                }else {
                    sum += help1(nums, array, var);
                }
            }else if(nums[i] == value){
                sum++;
            }else {}
        }
        array[value] = sum;
        return array[value];
    }

    //Time Limit Exceed
    public  int combinationSum4_2(int[] nums, int target){
        if(nums.length == 0){
            return  0;
        }
        Arrays.sort(nums);
        if(target < nums[0]){
            return 0;
        }
        int[] array = new int[target + 1];
        array[nums[0]] = 1;

        return  help1(nums, array, target);


    }

    @Test
    public  void  test(){
       /* int[] nums = {1,2,3};
        int target = 4;*/

      /*int[] nums = {1,50};
        int target = 200;*/

      /* int[] nums = {4,2,1};
        int target = 32;*/

       /*int[] nums = {3,33,333};
        int target = 10000;*/

     int[] nums = {13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,
                109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,
                223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,
                331,337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,
                443,449,457,461,463,467,479,487,
                491,499,503,509,521,523,541,547,557,563,569,571,577,587,593,599,601,607,615};
        int target = 220;

        long startTime = System.currentTimeMillis();
        int result = combinationSum4_1(nums, target);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("Runnint time : " + (endTime - startTime));
    }
}
