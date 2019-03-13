package interview.medium1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/11 0011.
 */
public class Solution46 {
    public  boolean find(List<Integer>list, int key){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == key){
                return  true;
            }
        }
        return  false;
    }

    public  void  generate(List<List<Integer>> lists, List<Integer> list, int totalLenght, int[] nums){
        if(totalLenght == nums.length){
            lists.add(list);
            return;
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (!find(list, nums[i])) {
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(list);
                    temp.add(nums[i]);
                    generate(lists, temp, totalLenght + 1, nums);
                }
            }
        }
    }

    //Accepted --------4ms
    public  List<List<Integer>> permute(int[] nums){
        int length = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            generate(lists, list, 1, nums);
        }
        return  lists;
    }

    @Test
    public  void  test(){
        int[] nums = {1,2,3,4};
        List<List<Integer>> result = permute(nums);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + "  ");
            }
            System.out.println(" ");
        }
    }
}
