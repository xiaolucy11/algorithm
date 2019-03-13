package algorithm.medium7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youlu on 2018/10/16.
 */
public class Solution525 {
    public  int findMaxLength(int[] nums){
        int totalZeros = 0, totalOnes = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                totalZeros++;
            }else {
                totalOnes++;
            }
        }

        int first = 0, last = nums.length-1;
        while (first < last){
            if(totalOnes == totalZeros){
                break;
            }else if(totalZeros < totalOnes){
                if(nums[first] == 0){
                    first++;
                }else if(nums[last] == 0){
                    last--;
                }else {
                    first++;
                }
            }else {

            }
        }
        return 0;
    }

    //Time Limit Exceeded
    public  int findMaxLength1(int[] nums){
        int maxZerosCount = 0;
        for (int i = 0; i < nums.length; i++){
            int zerosCount = 0, onesCount = 0;
            for(int j = i ; j < nums.length; j++){
                if(nums[j] == 0){
                    zerosCount++;
                }else {
                    onesCount++;
                }
                if(onesCount == zerosCount && onesCount > maxZerosCount){
                    maxZerosCount = onesCount;
                }
            }
        }
        return  2 * maxZerosCount;
    }

    @Test
    public  void  test(){
//        int[] nums = {0,1};
        int[] nums = {0,1,0};

        long startTime = System.currentTimeMillis();
        int result = findMaxLength1(nums);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
