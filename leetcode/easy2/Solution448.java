package interview.easy2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/9 0009.
 */
public class Solution448 {
    //using o(n) space
    public List<Integer> findDisappearedNumber(int[] nums){
       List<Integer> list = new ArrayList<>();
        int[] array = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            array[nums[i] - 1]++;
        }
        for(int j = 0; j < nums.length; j++){
            if(array[j] == 0){
                list.add(j+1);
            }
        }
        return  list;
    }

    //without o(0) space
    public List<Integer> findDisappearedNumbers1(int[] nums){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            nums[Math.abs(nums[i])-1] = -1 * Math.abs( nums[Math.abs(nums[i])-1]);
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        return list;
    }

    @Test
    public void  test(){
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> result = findDisappearedNumbers1(nums);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
    }
}
