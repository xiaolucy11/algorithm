package interview.medium1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/8/11 0011.
 */
public class Solution47 {

    public int find(List<Integer>list, int key){
        int maxIndex = -1;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == key){
                maxIndex = i;
            }
        }
        return  maxIndex;
    }


   public  void  generate(List<List<Integer>> lists, List<Integer> list, int totalLenght, List<Integer> indexs, int[] nums){
        if(totalLenght == nums.length){
            lists.add(list);
            return;
        }else {
            for (int i = 0; i < nums.length; i++) {
                int sameElementIndex = find(list, nums[i]);
                if ((sameElementIndex == -1) || (indexs.get(sameElementIndex) < i)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(list);
                    temp.add(nums[i]);

                    List<Integer> listIndexs = new ArrayList<>();
                    listIndexs.addAll(indexs);
                    listIndexs.add(i);

                    generate(lists, temp, totalLenght + 1,listIndexs, nums);
                }
            }
        }
    }

    //Accepted ------28ms
    public List<List<Integer>> permuteUnique(int[] nums){
        int length = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            List<Integer> indexs = new ArrayList<>();
            indexs.add(i);
           generate(lists, list, 1,indexs, nums);
        }
        return  lists;
    }


    //reference from others
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i - 1])) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }


    @Test
    public  void  test(){
        int[] nums = {1,1,2,2};
        List<List<Integer>> result = permuteUnique(nums);
        for(int i = 0; i < result.size(); i++){
            for(int j  = 0; j < result.get(i).size();j++){
                System.out.print(result.get(i).get(j) + "  ");
            }
            System.out.println(" ");
        }
    }
}
