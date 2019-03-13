package algorithm.medium6;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by youlu on 2018/10/13.
 */
public class Solution503 {

    //Accepted ----- 56ms
    /*
        time complexity O(n log(n))
     */
    public int[] nextGreaterElements(int[] nums){
        if(nums.length == 0){
            return  new int[0];
        }
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = Integer.MIN_VALUE;
        }
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();

        priorityQueue1.add(nums[nums.length-1]);
        for(int i = nums.length -1; i >= 0; i--){
            while (!priorityQueue1.isEmpty()){
                int peek = priorityQueue1.peek();
                if(peek > nums[i]){
                    arr[i] = peek;
                    break;
                }else {
                    int temp = priorityQueue1.poll();
                }
            }

            priorityQueue1.add(nums[i]);
        }

       /* int start = 0, queueIndex = 1;
        priorityQueue1.add(nums[0]);
        while (start < nums.length){
            while (queueIndex < nums.length){
                int peek = priorityQueue1.peek();
                if(peek > nums[start]){
                    break;
                }else {
                    priorityQueue1.add(nums[queueIndex]);
                    if(nums[queueIndex] > nums[start]){
                        break;
                    }
                    queueIndex++;
                }
            }
            if(queueIndex == nums.length){
                priorityQueue1.clear();
                start++;
                if(start < nums.length) {
                    queueIndex = start;
                    priorityQueue1.add(nums[queueIndex]);
                }
            }else {
                int peek = priorityQueue1.peek();
                arr[start++] = peek;
            }
        }*/


        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){
                    return -1;
                }else if(o1 < o2){
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        int last = nums.length - 1, index = 1;
        priorityQueue2.add(nums[0]);
        while (last > index){
            while (index < last){
                int leftMax = priorityQueue2.peek();
                if(leftMax > nums[last]){
                    break;
                }else {
                    priorityQueue2.add(nums[index]);
                    index++;
                }
            }

            int top = priorityQueue2.peek();
            while (last >= index){
                if(arr[last] != Integer.MIN_VALUE){
                    last--;
                    continue;
                }

                if(nums[last] < top){
                    arr[last] = top;
                    last--;
                }else {
                    break;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == Integer.MIN_VALUE){
                arr[i] = -1;
            }
        }

        return  arr;
    }

    @Test
    public  void  test(){
//        int[] nums = {1,2,1};
//        int[] nums = {1,2,3,4,3};
//        int[] nums = {1,2,3,4,5};
//        int[] nums = {1,2,3,4,5,6,5,4,5,1,2,3};
        int[] nums = {100,1,11,1,120,111,123,1,-1,-100};
//        int[] nums = {-1,0};
        long startTime = System.currentTimeMillis();
        int[] result = nextGreaterElements(nums);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + "  ");
        }
        System.out.println();
        System.out.println("running time : " + (endTime - startTime));

    }
}
