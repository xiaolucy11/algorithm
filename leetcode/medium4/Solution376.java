package algorithm.medium4;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/25.
 */
public class Solution376 {
    public  int search(int[] nums, int index, int flag){
        if(index == -1){
            return 0;
        }
        if(index == 0){
            return  1;
        }

        if(flag == 1){
            int biggerValueIndex = index - 1;
            while (biggerValueIndex >=0 ){
                if(nums[biggerValueIndex] > nums[index]){
                    break;
                }
                biggerValueIndex--;
            }
            return  search(nums, biggerValueIndex, 0 ) + 1;
        }else {
            int smallerValueIndex = index -  1;
            while (smallerValueIndex >= 0){
                if(nums[smallerValueIndex] < nums[index]){
                    break;
                }
                smallerValueIndex--;
            }
            return search(nums, smallerValueIndex, 1) + 1;
        }
    }

    public int wiggleMaxLength(int[] nums){
        if(nums.length == 0){
            return  0;
        }else if(nums.length == 1){
            return 1;
        } else {
           int value1 = search(nums, nums.length-1, 1);
            int value2 = search(nums, nums.length-1, 0);
            return  Math.max(value1, value2);
        }
    }


    @Test
    public  void  test(){
        //int[] nums = {1,7,4,9,2,5};
        //int[] nums = {1,17,5,10,13,15,10,5,16,8};
        //int[] nums = {1,2,3,4,5,6,7,8,9};
        //int[] nums = {0,0};
        int[] nums = {33,53,12,64,50,41,45,21,97,35,47,92,39,0,93,55,40,
                46,69,42,6,95,51,68,72,9,32,84,34,64,6,2,26,98,3,43,30,60,
                3,68,82,9,97,19,27,98,99,4,30,96,37,9,78,43,64,4,65,30,84,
                90,87,64,18,50,60,1,40,32,48,50,76,100,57,29,63,53,46,57,93,98,42,
                80,82,9,41,55,69,84,82,79,30,79,18,97,67,23,52,38,74,15};
        System.out.println("length of nums : " + nums.length);
        long startTime = System.currentTimeMillis();
        int result = wiggleMaxLength(nums);
        System.out.println(result);
        long endTime = System.currentTimeMillis();
        System.out.println("running time : " + (endTime - startTime));
    }
}
