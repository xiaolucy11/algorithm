package algorithm.medium6;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/8.
 */
public class Solution457 {

    //Accepted ---- 1ms
    public  boolean circularArrayLoop(int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int count = 0;
                int index = i;
                int flag = 0, isBackword = 0;
                if(nums[i] > 0){
                    isBackword = 1;
                }
                while (true){
                    int nextIndex = Integer.MIN_VALUE;
                    if(nums[index] > 0){
                        nextIndex = index + nums[index];
                        while (nextIndex >= nums.length){
                            nextIndex = nextIndex - nums.length;
                        }
                    }else {
                        nextIndex = index - Math.abs(nums[index]);
                        while (nextIndex < 0){
                            nextIndex += nums.length;
                        }
                    }
                    nums[index ] = 0;
                    if(nextIndex == i){
                        break;
                    }

                    if((isBackword == 1 && nums[nextIndex] < 0) ||
                            (isBackword == 0 && nums[nextIndex] > 0)){
                        flag = 1;
                        break;
                    }

                    if(nums[nextIndex] == 0){
                        flag = 1;
                        break;
                    }
                    if(nextIndex == index){
                        flag = 1;
                        break;
                    }
                    count++;
                    index = nextIndex;
                }

                if(flag == 0 && count > 0){
                    return true;
                }
            }
        }

        return  false;
    }

    @Test
    public  void  test(){
//        int[] nums = {2,-1,1,2,2};
//        int[] nums = {-1,2};
//        int[] nums = {-2,1,-1,-2,-2};
        int[] nums = {2,-1,1,-2,-2};
        long startTime = System.currentTimeMillis();
        System.out.println("result : " + circularArrayLoop(nums));
        long endTime = System.currentTimeMillis();
        System.out.println("running time : " + (endTime - startTime));
    }
}
