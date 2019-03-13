package algorithm.medium8;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlu on 2018/11/3.
 */
public class Solution714 {

    public  int  search(Map<Integer, Integer> map,int[] prices, int index, int fee){
        int sum = 0;
        while (true){
            if(map.containsKey(index)){
                int nextIndex = map.get(index);
                sum += prices[nextIndex] - prices[index]- fee;
                index = nextIndex + 1;
            }else {
                break;
            }
        }

        return  sum;
    }

    public int maxProfit(int[] prices, int fee){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < prices.length; i++){
            int index = i + 1;
            while ((index < prices.length) && (prices[index] - prices[i] <=fee)){
                index++;
            }
            if(index < prices.length){
                map.put(i,index);
            }
        }

        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            if(map.containsKey(i)){
                int profit = search(map, prices, i, fee);
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }

        return  maxProfit;
    }

    //Time Limit Excced
    public int maxProfit1(int[] prices, int fee){
        int[] arr = new int[prices.length];
        arr[0] = 0;
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            int maxValue = 0;
            int index = i - 1;
            while (index >= 0){
                if(prices[i] - prices[index] > fee){
                    int value = 0;
                    if(index - 1 >= 0){
                         value = prices[i] - prices[index] - fee + arr[index-1];
                    }else {
                        value = prices[i] - prices[index] - fee;
                    }
                    if(value > maxValue){
                        maxValue = value;
                    }
                }
                index--;
            }

            if(maxValue > maxProfit){
                maxProfit = maxValue;
                arr[i] = maxValue;
            }else {
                arr[i] = maxProfit;
            }
        }
        return  maxProfit;
    }


    public int maxProfit2(int[] prices, int fee){
        int[] arr = new int[prices.length];
        arr[0] = 0;
        int minIndex = 0, maxIndex = 0;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[maxIndex]){
            for(int j = maxIndex + 1; j < i; j++){
                if(minIndex == 0){
                    arr[i] = Math.max(prices[i] - prices[minIndex] - fee,
                            prices[i] - prices[j] - fee);
                }else {
                    arr[i] = Math.max(prices[i] - prices[minIndex] - fee + arr[minIndex - 1],
                            prices[i] - prices[j] - fee);
                }
            }
                maxIndex = i;
            }
            if(prices[i] < prices[minIndex]){
                minIndex = i;
            }

        }
      return  arr[arr.length - 1];
    }

    @Test
    public  void  test(){
       /* int[] prices = {1,3,2,8,4,9};
        int fee = 2;*/

       /*int[] prices = {1,3,7,5,10,3};
        int fee = 3;*/
     /* int[] prices = {1,2,1,5,3,5,5,4,1,5};
        int fee = 0;*/
     int[] prices = {1,3,2,8,4,9};
        int fee = 2;

        long startTime = System.currentTimeMillis();
        int result = maxProfit2(prices, fee);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
