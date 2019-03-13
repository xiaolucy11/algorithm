package algorithm.medium3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/9/15.
 */
public class Solution300 {
    //Accepted ------14ms
    /*
        dp algorithm
        time complexity O(n^2)
     */
    public  int lengthOfLIS(int[] nums){
        int length = nums.length;
        int[] array = new int[length];

        int maxLength = 0;
        for(int i = 0; i < length; i++){
            int index = i -1;
            int maxSubLength = 0;
            while (index >= 0){
                if(nums[index] < nums[i] && array[index] > maxSubLength){
                    maxSubLength = array[index];
                }
                index--;
            }
            if(maxSubLength > 0) {
                array[i] = maxSubLength + 1;
            }else {
                array[i] = 1;
            }
            if(array[i] > maxLength){
                maxLength = array[i];
            }
        }
        return  maxLength;
    }

    public int binarySearch(List<Integer> list, int value){
        int start = 0, end = list.size()-1;
        while (start < end){
            int mid = start + ( end - start) / 2;
            if(list.get(mid) > value){
                end = mid;
            }else if (list.get(mid) < value){
                start = mid+1;
            }else {
                return mid;
            }
        }
        return  start;
    }

    //Accepted -------2ms
    /*
        reference from other ----- O(n long(n))
        genius solutin.
     */
    public  int lengthOfLIS1(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        int insertIndex = -1;
        int length = nums.length;
        list.add(nums[0]);
        int last = nums[0];
        for(int i = 1; i <  length; i++){
            if (nums[i] > last){
                list.add(nums[i]);
                last = nums[i];
            }else if(nums[i] < last){
                insertIndex = binarySearch(list,nums[i]);
                list.set(insertIndex, nums[i]);
                if(insertIndex == list.size() - 1){
                    last = nums[i];
                }
            }
        }
        return  list.size();
    }


    @Test
    public  void  test(){
        int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
        System.out.print(lengthOfLIS1(nums));
    }
}
