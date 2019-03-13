package interview.easy;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/15 0015.
 */
public class Solution121 {
    public int maxProfit(int[] prices){
        int minPrice = prices[0];
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice  = prices[i];
            }else{
                if(prices[i] - minPrice > profit){
                    profit = prices[i] - minPrice;
                }
            }
        }
        return profit;
    }
    @Test
    public void test(){
        int[] prices = new int[]{7,1,5,3,6,4};
        int result = maxProfit(prices);
        System.out.println(result);
    }
}
