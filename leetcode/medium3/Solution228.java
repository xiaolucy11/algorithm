package algorithm.medium3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/9/12.
 */
public class Solution228 {

    //Accepted -------1ms
    public List<String> summaryRanges(int[] nums){
        if(nums.length == 0){
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        int length = nums.length;
        int slow = 0, quick = 0;
        while (quick < length){
            if(nums[quick]-nums[slow] == quick - slow){
                quick++;
            }else {
                if(slow != quick-1) {
                    String str = Integer.toString(nums[slow]) + "->" + Integer.toString(nums[quick - 1]);
                    list.add(str);
                }else {
                    list.add(Integer.toString(nums[slow]));
                }
                slow = quick;
            }
        }
        String lastRange = "";
        if(slow != length - 1){
             lastRange = Integer.toString(nums[slow]) + "->" + Integer.toString(nums[quick - 1]);
        }else{
            lastRange = Integer.toString(nums[slow]);
        }
        list.add(lastRange);
        return list;
    }

    @Test
    public  void  test(){
        int[] nums = {0,2,3,4,6,8,9};
        List<String> result =summaryRanges(nums);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
    }
}
