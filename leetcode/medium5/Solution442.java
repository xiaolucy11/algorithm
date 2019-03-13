package algorithm.medium5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by youlu on 2018/10/5.
 */
public class Solution442 {
    //Accepted -----10ms
    /*
        idea from other, using self Array as a Hashtable
        is similar Bucket sort
     */
    public List<Integer> findDuplicates(int[] nums){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                result.add(Math.abs(nums[i]));
            }else {
                nums[index] = -1 * nums[index];
            }
        }

        return  result;
    }

    @Test
    public  void  test(){
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDuplicates(nums);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
