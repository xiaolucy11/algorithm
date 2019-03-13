package algorithm.hard1;

import org.junit.Test;
public class Naturali3 {

    /*
        time complexty : O(n)
     */
    public  int maxProfit(int[] prices, int p){
        if(prices.length <= 1){
            return 0;
        }
        int profit = 0;
        int buy = prices[0];
        for(int i = 1; i < prices.length; i++){
            profit = Math.max(profit, prices[i] + buy - p);
            buy = Math.max(buy, profit - prices[i]);
        }

        return  profit;
    }


    @Test
    public  void  test(){
        int[] prices = {0,2,1,8,4,9};
        int p = 2;

        long startTime = System.currentTimeMillis();
        int result = maxProfit(prices,p);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
