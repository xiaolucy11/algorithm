package algorithm.hard1;

import java.util.PriorityQueue;
public class Naturali2 {

    /*
        brute soltion using PriorityQueue with the size of k
        time complexity : O(n^2)
     */
    public int kthLargest1(int[]arr, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                int minValue = Math.min(arr[i],arr[j]);
                priorityQueue.add(minValue);
                if(priorityQueue.size() > k){
                    priorityQueue.poll();
                }
            }
        }

        while (priorityQueue.size() > 1){
            priorityQueue.poll();
        }
        return  priorityQueue.poll();
    }


    /*
        我的想法是，List的数产生于arr,里面存在很多重复的元素，也就是求k-th in arr
        没有测试样例，不太清楚具体表达kth 什么意思，包不包括重复元素
        time complexity : O(n)
     */
    public int kthLargest2(int[]arr, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            priorityQueue.add(arr[i]);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }

        }

        while (priorityQueue.size() > 1){
            priorityQueue.poll();
        }
        return  priorityQueue.poll();
    }
}
