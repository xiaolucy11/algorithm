package algorithm.medium9;

import org.junit.Test;

/**
 * Created by youlu on 2018/11/10.
 */
public class Solution769 {

    public  boolean check(int[] arr, int start, int end){
        for(int i = start; i <= end; i++){
            if((arr[i] < start) || (arr[i] > end)){
                return  false;
            }
        }

        return  true;
    }

    //Accepted ---3ms
    /*
        greedy algorithm
        time complexity O(N^2), but n < 10
     */
    public  int maxChunksToSorted(int[] arr){
        int count = 0;
        int index = 0;

        while (index < arr.length){
           if(arr[index] == index){
               count++;
               index++;
               continue;
           }
           int temp = arr[index];
            int flag = 0;
           while (temp < arr.length){
               if(check(arr, index, temp)){
                   flag = 1;
                   break;
               }else {
                   temp++;
               }
           }


            index = temp + 1;
            if(flag == 1) {
                count++;
            }
        }

        return  count;
    }

    //Accepted ---4ms
    /*
        idea from other
        time complexity O(n)
     */
    public  int maxChunksToSorted1(int[] arr){
        int[] maxFromLeft = new int[arr.length];
        int[] minFromRight = new int[arr.length];

        int max = arr[0];
        maxFromLeft[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            maxFromLeft[i] = max;
        }


        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if(maxFromLeft[i] ==i){
                count++;
            }
        }

        return  count;
    }


    @Test
    public  void  test(){
//        int[] arr = {4,3,2,1,0};
//        int[] arr = {1,0,2,3,4};
        int[] arr = {3,1,0,2,4};
//        int[] arr = {2,1,3,0,4};

        long starTime = System.currentTimeMillis();
        int result = maxChunksToSorted1(arr);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - starTime));
    }
}
