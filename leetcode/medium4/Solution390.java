package algorithm.medium4;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/9/27.
 */


public class Solution390 {

    //Time Limit Exceed
    /*
        3374/3377 test cases passed
     */
    public int lastRemaining(int n){
        List<Integer> leftToRight = new ArrayList<>();
        List<Integer> rightToLeft = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            leftToRight.add(i);
        }

        int flag = 1;
        while (true){
            if(flag == 1){
                if(leftToRight.size() == 1){
                    return leftToRight.get(0);
                }

                rightToLeft.clear();

                for(int i = 1; i < leftToRight.size(); i += 2){
                    rightToLeft.add(leftToRight.get(i));
                }
                flag = 0;
            }else {
                if(rightToLeft.size() == 1){
                    return  rightToLeft.get(0);
                }

                leftToRight.clear();

                for(int i = rightToLeft.size()-2; i >= 0; i -= 2){
                    leftToRight.add(rightToLeft.get(i));
                }
                Collections.reverse(leftToRight);
                flag = 1;
            }
        }
    }

    //Time Limit Exceeded
    public int lastRemaining1(int n){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
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
        for(int i = 1; i <= n; i++){
            minHeap.add(i);
        }

        int flag = 1;
        while (true){
            if(flag == 1){
                if(minHeap.size() == 1){
                    return minHeap.peek();
                }

                int count = 0;
                while (!minHeap.isEmpty()){
                    int value1 = minHeap.poll();
                    count++;
                    if(count % 2 == 0){
                        maxHeap.add(value1);
                    }
                }

                flag = 0;
            }else {
                if(maxHeap.size() == 1){
                    return  maxHeap.peek();
                }

                int count = 0;
                while (!maxHeap.isEmpty()){
                    int value2 = maxHeap.poll();
                    count++;
                    if(count % 2 == 0){
                        minHeap.add(value2);
                    }
                }

                flag = 1;
            }
        }
    }


    //Memory Limit Exceed
    public int lastRemaining2(int n){
        if(n == 1){
            return  1;
        }else if(n >= 2 && n <= 5){
            return 2;
        }else {
            int[] array = new int[n + 1];
            array[1] = 1;
            array[2] = 2;
            array[3] = 2;
            array[4] = 2;
            array[5] = 2;

            for(int i = 6; i <= n; i++){
                if(i % 2 == 0){
                    int halfValue = i / 2;
                    int rightToLeftTh = array[halfValue];
                    array[i] = i - (rightToLeftTh - 1) * 2;
                }else {
                    array[i] = array[i-1];
                }
            }
            return  array[n];
        }

    }

    //Accepted ----- 42ms
    public int lastRemaining3(int n){
        if(n == 1){
            return  1;
        }else if(n >= 2 && n <= 5){
            return 2;
        }else {
            if(n % 2 == 1){
                return lastRemaining3(n-1);
            }else {
                int value = lastRemaining3(n / 2);
                return  n - (value - 1) * 2;
            }
        }
    }

    @Test
    public  void  test(){
       /* int n = 10000000;
        long startTime = System.currentTimeMillis();
        int result = lastRemaining1(n);
        long endTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("runnint time : "  + (endTime - startTime));*/

       int count = 0;
        for(int i = 1; i <= 100; i++){
            if(lastRemaining(i) != lastRemaining2(i)){
                count++;
            }
            System.out.println("i = " + i + " :  " + lastRemaining2(i));
        }

        System.out.println("error count : " + count);
    }

    @Test
    public  void  test1(){
         int n = 1000000000;
        long startTime = System.currentTimeMillis();
        int result = lastRemaining3(n);
        long endTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("runnint time : "  + (endTime - startTime));
    }
}
