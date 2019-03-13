package interview.easy3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/23 0023.
 */
public class Solution643 {
    //wrong solution
    public double findMaxAverage(int[] nums, int k){
        double maxValue = 0;
        for(int i = 0; i < k; i++){
            maxValue += nums[i];
        }

        int slow = 0, quick = k;
        while (quick < nums.length){
            int i = 0;
            double preSum = 0, postSum = 0;
            int flag = 0;
            while(i < k && quick + i < nums.length){
                preSum += nums[slow + i];
                postSum += nums[quick + i];
                if(postSum > preSum){
                    maxValue = maxValue - preSum + postSum;
                    slow = slow + i + 1;
                    quick = quick + i + 1;
                    flag = 1;
                    break;
                }else {
                    i++;
                }
            }
            if(flag == 0){
                quick += i;
            }
        }
        return  maxValue / k;
    }
    //Time Limit Exceeded
    public  double findMaxAverage1(int[] nums, int k){
        double maxValue = 0;
        for(int i = 0; i < k; i++){
            maxValue += nums[i];
        }
        for(int j = 1; j + k < nums.length; j++){
            double sum = 0;
            int index = j;
            while (index < j + k){
                sum += nums[index];
                index++;
            }
            if(sum > maxValue){
                maxValue = sum;
            }
        }
        return  maxValue / k;
    }


    //Accepted ------16ms
    public  double findMaxAverage2(int[] nums, int k){

        double[] sumArray = new double[nums.length];
        sumArray[0] = nums[0];
        for(int i = 1; i < k; i++){
            sumArray[i] = sumArray[i-1] + nums[i];
        }

        double maxValue = sumArray[k-1];

        for(int i = k ; i < nums.length; i++){
            sumArray[i] = sumArray[i-1] + nums[i];
            if(sumArray[i] - sumArray[i-k] > maxValue){
                maxValue = sumArray[i] - sumArray[i-k];
            }
        }
        System.out.println("maxValue: " + maxValue);
        return maxValue/k;


    }

    @Test
    public  void  test(){
        int[] nums = new int[]{1,12,-5,-6,-2,3,7,-9,22,12,-10,-14,60};
        System.out.println(findMaxAverage2(nums, 4));
    }
}
