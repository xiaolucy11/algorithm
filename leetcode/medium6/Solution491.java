package algorithm.medium6;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/10/12.
 */
public class Solution491 {
    public  void  search(List<List<Integer>> result, List<Integer> list, int[] nums, int index){
        if(index >= nums.length){
            return;
        }

        int i = index, count = 0;
        if(i + 1 < nums.length && nums[i] == nums[i+1]){
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
        }


        while (i + 1 < nums.length && nums[i] == nums[i+1]){
            list.add(nums[i]);
            i++;
            count++;
        }


        if(i + 1 == nums.length && nums[i] == nums[i-1]){
            list.add(nums[i]);
            count++;
            i++;
        }

        if(i != index) {
            result.add(new ArrayList<>(list));
            search(result, list, nums, i);
            while (count > 0) {
                list.remove(list.size() - 1);
                count--;
            }
        }

        for(int j = i; j < nums.length; j++) {
            if (nums[j] >= list.get(list.size() - 1)) {
                if (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    search(result, list, nums, j);
                } else {
                    if (nums[j] != nums[j - 1]) {
                        list.add(nums[j]);
                        search(result, list, nums, j + 1);
                        list.remove(list.size() - 1);
                    }
                }

            }
        }
    }

    public  void  search1(List<List<Integer>> result, List<Integer> list, int[] nums, int index){
        if(index >= nums.length){
            return;
        }


        for(int i = index; i < nums.length; i++){
            if(nums[i] >= list.get(list.size() - 1)) {
                if(nums[i] == nums[i-1] && list.get(list.size() - 1) != nums[i]){
                    continue;
                }
                if (i + 1 < nums.length && nums[i] == nums[i + 1] && nums[i] != nums[i-1]) {
                    list.add(nums[i]);
                    result.add(new ArrayList<>(list));
                    list.remove(list.size() - 1);


                    int temp = i, count = 0;
                    while (temp + 1 < nums.length && nums[temp] == nums[temp + 1]) {
                        list.add(nums[temp]);
                        count++;
                        temp++;
                    }

                    if (temp + 1 == nums.length && nums[temp] == nums[temp - 1]) {
                        list.add(nums[temp]);
                        temp++;
                        count++;
                    }
                    if (temp != i) {
                        result.add(new ArrayList<>(list));
                        search1(result, list, nums, temp);
                        while (count > 0) {
                            list.remove(list.size() - 1);
                            count--;
                        }
                    }
                }else{
                    list.add(nums[i]);
                    result.add(new ArrayList<>(list));
                    search1(result,list, nums, i+1);
                    list.remove(list.size() - 1);
                }
            }
        }

    }

    public  void  search2(List<List<Integer>> result, List<Integer> list, int[] nums, int index){
        if(index >= nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(nums[i] >= list.get(list.size() - 1)){
                if(nums[i] == nums[i-1] && list.get(list.size() - 1) != nums[i]){
                    continue;
                }
                list.add(nums[i]);
                result.add(new ArrayList<>(list));
                search2(result, list, nums, i+1);
                list.remove(list.size() - 1);
            }
        }
    }

    public  void  search3(Set<String> set, String str, int[] nums, int index){
        if(index >= nums.length){
            return;
        }

        int lastNumberIndex  = str.length() - 1;
        while (lastNumberIndex >= 0 ){
            char ch = str.charAt(lastNumberIndex);
            if(ch != ':'){
                lastNumberIndex--;
            }else {
                break;
            }
        }
        String subStr = str.substring(lastNumberIndex + 1, str.length());
        int value = Integer.parseInt(subStr);

        for(int i = index; i  < nums.length; i++){
          if(nums[i] >= value){
              String next =  str;
              next += Character.toString(':');
              String temp = Integer.toString(nums[i]);
              next += temp;
              set.add(next);
              search3(set, next, nums, i+1);
          }
        }

    }

    //Accepted ---- 139ms
    /*
        not effecient
     */
    public List<List<Integer>> findSubsequences(int[] nums){
        if(nums.length == 0 || nums == null){
            return  new ArrayList<>();
        }

        Set<String> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            String str = "";
           str += Integer.toString(nums[i]);
            search3(set, str, nums, i + 1);
        }

        for(String str : set){
            List<Integer> list = new ArrayList<>();
            String[] numbers = str.split(":");
            for(int i = 0; i < numbers.length; i++){
                list.add(Integer.parseInt(numbers[i]));
            }
            result.add(list);
        }
        return  result;
    }



    @Test
    public  void  test(){
//        int[] nums = {4,6,7,7};
//        int[] nums = {4,3,2,1};
//        int[] nums = {1,2,3,8,8};
//        int[] nums = {1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
//        int[] nums = {1,2,3,1,1};
        int[] nums = {-100,-99,-98,-97,-96,-96};
        long startTime = System.currentTimeMillis();
         List<List<Integer>> result  = findSubsequences(nums);
        long endTime = System.currentTimeMillis();
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + "   ");
            }
            System.out.println();
        }

      /* for(String str : set){
           for(int i = 0; i < str.length(); i++){
               System.out.print(str.charAt(i));
           }
           System.out.println();
       }*/

        System.out.println("running time : " + (endTime - startTime));
    }

    @Test
    public  void  test1(){
        System.out.print(Integer.parseInt(Integer.toString(-1000)));
    }
}
