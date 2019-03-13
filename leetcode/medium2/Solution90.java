package interview.medium2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2018/8/31 0031.
 */
public class Solution90 {
    public  boolean find(int[] nums, int length, int value){
        for(int i = length-1; i >= 0; i--){
            if(nums[i] == value){
                return  true;
            }
        }
        return  false;
    }
    public  boolean equalsBetweenTwoLists(List<Integer> list1, List<Integer> list2){
        for(int i = 0; i < list1.size(); i++){
            if(list1.get(i) != list2.get(i)){
                return  false;
            }
        }
        return  true;
    }

    public  boolean isDuplicate(List<List<Integer>> lists, List<Integer> list){
        for(int i = 0; i < lists.size(); i++){
            if((lists.get(i).size() == list.size()) &&
                    (equalsBetweenTwoLists(lists.get(i), list))){
                return  true;
            }
        }
        return  false;
    }
    public  void  generate(List<List<Integer>> lists, List<Integer> list,int[] nums,int index){
        if(index == nums.length){
            return;
        }

        for(int i = index; i < nums.length; i++) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(nums[i]);

            List<Integer> list2 = new ArrayList<>();
            list2.addAll(list);
            list2.add(nums[i]);
            list2.sort(Comparator.naturalOrder());

            if(!isDuplicate(lists, list2)) {
                lists.add(list2);
            }

            generate(lists, list2, nums, i + 1);

            if (!isDuplicate(lists, list1)) {
                lists.add(list1);
               // lists.add(list2);
            }

            generate(lists, list1, nums, i + 1);
        }

    }

    //Accepted ------32ms
    /*
        too complicated
     */
    public List<List<Integer>> subsetWithDup(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        result.add(new ArrayList<Integer>());
        list.add(nums[0]);
        result.add(list);
        generate(result, list, nums, 1);
        return  result;
    }
    public  void  generate1(List<List<Integer>> lists, List<Integer> list, int[] nums, int index){
        lists.add(list);
        if(index == nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            temp.add(nums[i]);
            generate1(lists, temp, nums, i+1);
            //list.remove(list.size()-1);
        }
    }

    //Accepted -----3ms
    /*
        part reference from other
     */
    public List<List<Integer>> subsetWithDup1(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);
        generate1(result, list, nums, 0);
        return  result;

    }

    @Test
    public  void  test(){
        int[] nums = {1,2,3};
        List<List<Integer>> result = subsetWithDup1(nums);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
