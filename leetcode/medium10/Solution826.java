package algorithm.medium10;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlu on 2018/11/29.
 */
public class Solution826 {
    public  int findMax(int[] difficulty){
        int max = 0;
        for(int i = 0; i < difficulty.length; i++){
            max = Math.max(max, difficulty[i]);
        }

        return  max;
    }

    //Accepted ----78ms
    public int maxProfitAssignment(int[] difficulty, int[] profit,int[] worker){
        int maxValue =findMax(difficulty);
        int[] arr = new int[maxValue + 1];

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < difficulty.length; i++){
            if(!map.containsKey(difficulty[i])) {
                map.put(difficulty[i], i);
            }else {
                int temp = map.get(difficulty[i]);
                if(profit[i] > profit[temp]){
                    map.put(difficulty[i],i);
                }
            }
        }

        arr[0] = 0;
        for(int i = 1;i < arr.length; i++){
            if(!map.containsKey(i)){
                arr[i] = arr[i-1];
            }else {
                int difficultyIndex = map.get(i);
                if(arr[i-1] < profit[difficultyIndex]){
                    arr[i] = profit[difficultyIndex];
                }else {
                    arr[i] = arr[i-1];
                }
            }
        }

        int sum = 0;
        for(int j = 0; j < worker.length; j++){
            int val = 0;
            if(worker[j] > maxValue){
                val = arr[maxValue];
            }else {
                val =  arr[worker[j]];
            }

                sum += val;
        }

        return  sum;
    }


    @Test
    public  void  test(){
       /* int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};*/

     /* int[] difficulty = {13,37,58};
        int[] profit = {4,90,96};
        int[] worker = {34,73,45};*/

    /* int[] difficulty = {85,47,57};
        int[] profit = {24,66,99};
        int[] worker = {40,25,25};*/
   /* int[] difficulty = {68,35,52,47,86};
        int[] profit = {67,17,1,81,3};
        int[] worker = {92,10,85,84,82};*/

   int[] difficulty = {66,1,28,73,53,35,45,60,100,44,59,94,27,88,7,18,83,18,72,63};
    int[] profit = {66,20,84,81,56,40,37,82,53,45,43,96,67,27,12,54,98,19,47,77};
    int[] worker = {61,33,68,38,63,45,1,10,53,23,66,70,14,51,94,18,28,78,100,16};


        long startTime = System.currentTimeMillis();
        int result = maxProfitAssignment(difficulty,profit,worker);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
