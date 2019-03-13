package algorithm.medium6;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/8.
 */

public class Solution456 {

    //Wrong solution
    public boolean find132pattern(int[] nums){
        if(nums.length == 0){
            return  false;
        }
        int length = nums.length;
        int[] leftToRightMin = new int[length];
        int[] rightToLeftMax = new int[length];
        int[] rightToLeftMin = new int[length];
        int min = nums[0], max = nums[length - 1], rightMin = nums[length-1];
        leftToRightMin[0] = min;
        rightToLeftMax[length - 1] = max;
        rightToLeftMin[length-1] = rightMin;

        for(int i = 1; i < length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
            leftToRightMin[i] = min;
        }

        for(int i = length - 2; i >= 0; i--){
            if(nums[i] > max){
                max = nums[i];
            }
            rightToLeftMax[i] = max;
            if(nums[i] < rightMin){
                rightMin = nums[i];
            }
            rightToLeftMin[i] = rightMin;
        }

        for(int i = 1; i < length - 1; i++){
            if((nums[i] >leftToRightMin[i-1]) && (nums[i] > rightToLeftMax[i+1]) && (
                    rightToLeftMax[i+1] > leftToRightMin[i-1]
                    )){
                return  true;
            }
        }
        return  false;
    }

    public  boolean help(int[] nums, int start, int end){
        if(end - start < 2){
            return  false;
        }

        int maxValue = Integer.MIN_VALUE;
        int maxValueIndex = -1;
        for(int i = start; i < end; i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }

        if(maxValueIndex == start){
            return  help(nums, start+1, end);
        }

        if(maxValueIndex == end){
            return  help(nums, start, end-1);
        }

        int rightMax = Integer.MIN_VALUE;
        int leftMin = Integer.MAX_VALUE;
        int rightIndex = maxValueIndex + 1, leftIndex = maxValueIndex - 1;

        while (rightIndex <= end){
            if(nums[rightIndex] < maxValue && nums[rightIndex] > rightMax){
                rightMax = nums[rightIndex];
            }
            rightIndex++;
        }

        while (leftIndex >=  start){
            if((nums[leftIndex] < maxValue) && (nums[leftIndex] < leftMin)){
                leftMin = nums[leftIndex];
            }
            leftIndex--;
        }

        if(leftMin < rightMax){
            return  true;
        }else {
            return help(nums,start, maxValueIndex-1) || help(nums, maxValueIndex+1, end);
        }
    }

    //Wrong solution
    public boolean find132pattern1(int[] nums){
        int maxValue = Integer.MIN_VALUE;
        int maxValueIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }

        int rightMax = Integer.MIN_VALUE;
        int leftMin = Integer.MAX_VALUE;
        int rightIndex = maxValueIndex + 1, leftIndex = maxValueIndex - 1;

        while (rightIndex < nums.length){
            if(nums[rightIndex] < maxValue && nums[rightIndex] > rightMax){
                rightMax = nums[rightIndex];
            }
            rightIndex++;
        }

        while (leftIndex >= 0){
            if((nums[leftIndex] < maxValue) && (nums[leftIndex] < leftMin)){
                leftMin = nums[leftIndex];
            }
            leftIndex--;
        }

        if(leftMin < rightMax){
            return  true;
        }else {
            return  false;
        }
    }

    public  int findRightMax(int[] nums, int index){
        int maxValue = Integer.MIN_VALUE;
        for(int i = index + 1; i < nums.length; i++){
            if(nums[i] < nums[index] && nums[i] > maxValue){
                maxValue = nums[i];
            }
        }
        return  maxValue;
    }

    public  int findLeftMin(int[] nums, int index){
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < index; i++){
            if(nums[i] < nums[index] && nums[i] < minValue){
                minValue = nums[i];
            }
        }

        return  minValue;
    }

    //Accepted -- 676ms
    /*
        time complexity O(n^2)
     */
    public boolean find132pattern2(int[] nums){
        for(int i = 0; i < nums.length;i++){
            int leftMin = findLeftMin(nums,i);
            int rightMax = findRightMax(nums,i);
            if(leftMin < rightMax){
                return  true;
            }
        }

        return  false;
    }


    //Accepted ---- 269ms
    /*
        time complexity O(nlong(n))
     */
    public boolean find132pattern3(int[] nums){
        return  help(nums, 0, nums.length-1);
    }


    @Test
    public  void  test(){
//        int[] nums = {1,2,3,4};
//        int[] nums = {3,1,4,2};
//        int[] nums = {-1,3,2,0};
       int[] nums = {2,3,1,4};
//       int[] nums = {-2,1,2,-2,1,2};
//       int[] nums = {1,3,2,4};
//        int[] nums = {8,10,4,6,5};
        long startTime = System.currentTimeMillis();
        System.out.println("result : " + find132pattern3(nums));
        long endTime = System.currentTimeMillis();
        System.out.println("runnint time : " + (endTime - startTime));
    }
}
