package interview.medium1;

import org.junit.Test;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/8/14 0014.
 */
public class Solution78 {
    /*public  boolean find(List<Integer>list ,int key){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == key){
                return  true;
            }
        }
        return  false;
    }*/
    public  void  generate(List<List<Integer>> lists, List<Integer>list,int lastIndex, int[] nums){
        if(list.size() == nums.length){
            return;
        }
        lists.add(list);
        for(int i = lastIndex + 1; i < nums.length; i++){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            temp.add(nums[i]);
            generate(lists, temp, i, nums);
        }
    }

    //Accepted   -------1ms
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> last = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            last.add(nums[i]);
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            generate(lists,list, i, nums);
        }
        lists.add(new ArrayList<>());
        lists.add(last);
        return  lists;
    }

    @Test
    public  void  test(){
        int[] nums = {1,2,3};
        List<List<Integer>> result = subsets(nums);
        for(int i = 0; i < result.size();i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + "  ");
            }
            System.out.println();
        }
    }
}
