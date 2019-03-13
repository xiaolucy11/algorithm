package algorithm.medium8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by youlu on 2018/10/25.
 */

public class Solution646 {

    //Accepted ---83ms
    /*
        dp algorithm
        time complexity O(n^2)
        it can be optimized
     */
    public int search(int[][] pairs, int index, int[] arr){
        int length = 1;
        int lastValue = pairs[index][1];

        for(int i = index + 1; i < pairs.length; i++){
            if(pairs[i][0] > lastValue){
                length++;
                lastValue = pairs[i][1];
                arr[i] = 1;
            }
        }
        return  length;
    }
    public  int findLongestChain(int[][] pairs){
        int maxLength = 0;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0]){
                    return -1;
                }else if(o1[0] > o2[0]){
                    return 1;
                }else {
                    return o1[1] - o2[1];
                }
            }
        });

        int[] arr = new int[pairs.length];
        arr[pairs.length - 1] = 1;

        for(int i = pairs.length - 2; i >= 0; i--){
            int index = i + 1;
            int value = 0;
            while (index < pairs.length){
                if(pairs[index][0] > pairs[i][1]){
                    if(arr[index] > value){
                        value = arr[index];
                    }
                }
                index++;
            }
            arr[i] = value + 1;
            if(arr[i] > maxLength){
                maxLength = arr[i];
            }
        }

        return  maxLength;
    }

    //code from other
    /*
        using new arr[maxValue],to decrease searching time
     */
    public int findLongestChain1(int[][] pairs) { //DP? brute force time??
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        int res = 1;
        int[] pre = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] == pre[0]) {
                continue;
            } else {
                if (pairs[i][1] <= pre[1]) {
                    pre = pairs[i];
                } else if (pairs[i][0] > pre[1]){
                    pre = pairs[i];
                    res++;
                }
            }
        }
        return res;
    }

    @Test
    public  void  test(){
        int[][] pairs = {{1,2},{2,3},{3,4}};
//        int[][] pairs = {{7,9},{4,5},{7,9},{-7,-1},{0,10},{3,10},{3,6},{2,3}};
        long startTime = System.currentTimeMillis();
        int result = findLongestChain(pairs);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
