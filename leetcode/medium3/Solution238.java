package algorithm.medium3;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/13.
 */
public class Solution238 {

    //Accepted ------3ms
    public int[] productExceptionSelf(int[] nums){
        int length = nums.length;
        int[] output = new int[length];
        int[] leftToRight = new int[length];
        int[] rightToLeft = new int[length];

        leftToRight[0] = nums[0];
        for(int i =  1; i < length; i++){
            leftToRight[i] = leftToRight[i-1] * nums[i];
        }

        rightToLeft[length-1] = nums[length-1];
        for(int j = length - 2; j >= 0; j--){
            rightToLeft[j] = rightToLeft[j+1] * nums[j];
        }


        for(int index = 0; index < length; index++){
            int leftValue = 1;
            if(index-1 >= 0){
                leftValue = leftToRight[index-1];
            }

            int rightValue = 1;
            if(index+1 < length){
                rightValue = rightToLeft[index+1];
            }

            output[index] = leftValue * rightValue;
        }

        return  output;
    }


    public int[] productExceptionSelf1(int[] nums){
        int length = nums.length;
        int[] output = new int[length];
        return  output;
    }

    @Test
    public  void  test(){
        int[] nums = {1,0,3,0};
        int[] outputs = productExceptionSelf(nums);

        for(int i = 0; i < outputs.length; i++){
            System.out.print(outputs[i] + "  ");
        }
    }
}
