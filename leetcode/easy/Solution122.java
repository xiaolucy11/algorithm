package interview.easy;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/15 0015.
 */
public class Solution122 {
    public  boolean isDescrease(int[] prices, int start, int end){
        for(int i = start + 1; i <= end; i++){
            if(prices[i - 1] < prices[i]){
                return  false;
            }
        }
        return  true;
    }
    public int computeProfit(int[] prices ,int start, int end){
        if(start >= end){return 0;}
        if(isDescrease(prices, start, end)){
            return 0;
        }
        int maxProfit = 0;
        for(int i = end; i >= start; i--){
            for(int j = i - 1; j >= start; j--){
                if((prices[i] > prices[j]) && (prices[i] - prices[j] + computeProfit(prices, start, j - 1) > maxProfit)){
                    maxProfit = prices[i] - prices[j] + computeProfit(prices, start, j-1);
                }
            }
        }
        return  maxProfit;
    }
    public int maxProfit(int[] prices){
        return  computeProfit(prices, 0, prices.length - 1);

    }


    //Accepted
    public int maxProfit1(int[] prices){
        int minPrices = prices[0];
        int maxPrices = prices[0];
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if((prices[i] < maxPrices) ){
                profit += maxPrices - minPrices;
                minPrices = prices[i];
                maxPrices = prices[i];
            }else{
                maxPrices = prices[i];
            }
        }
        profit += maxPrices - minPrices;
        return profit;
    }

    @Test
    public void  test(){
        int[] prices = new int[]{7,6,5,4,3,2,1};
        int profit = maxProfit1(prices);
        System.out.print(profit);
    }
}
