package algorithm.medium3;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by youlu on 2018/9/18.
 */
public class Solution322 {

   public  int search(int[] coins, int amount, int[] array){
       if(amount == 0){
           return 0;
       }
       if(amount < coins[0]){
           array[amount] = -1;
           return  -1;
       }

       int minValue = Integer.MAX_VALUE;
       for(int i = coins.length - 1; i >= 0; i--){
           if(coins[i] <= amount){
               int value = amount - coins[i];
               if(array[value] == 0) {
                   int result = search(coins, value, array);
                   if (result >= 0 && minValue > result + 1) {
                      minValue = result + 1;
                      // System.out.println("selected number  : " + coins[i]);
                   }
               }else if(array[value] > 0){
                   if(minValue > array[value] + 1) {
                       minValue = array[value] + 1;
                   }
               }
           }
       }
       if(minValue != Integer.MAX_VALUE){
           array[amount] = minValue;
       }else {
           array[amount] = -1;
       }
      return array[amount];
   }

   //Accpted -----  29ms
    /*  top to down dp alogrithm
        time comlexity O(nlog(n))
        using memorization searching, but not most effecient
     */
    public  int coinChange(int[] coins, int amount){
        Arrays.sort(coins);
        int[] array = new int[amount + 1];
        return search(coins, amount,array);
    }



    public  int search1(int[] coins, int amount, int[] array,int min){
        if(amount == 0){
            return 0;
        }
        if(amount < min){
            array[amount] = -1;
            return  -1;
        }

        int minValue = Integer.MAX_VALUE;
        for(int i = coins.length - 1; i >= 0; i--){
            if(coins[i] <= amount){
                int value = amount - coins[i];
                if(array[value] == 0) {
                    int result = search1(coins, value, array,min);
                    if (result >= 0 && minValue > result + 1) {
                        minValue = result + 1;
                        // System.out.println("selected number  : " + coins[i]);
                    }
                }else if(array[value] > 0){
                    if(minValue > array[value] + 1) {
                        minValue = array[value] + 1;
                    }
                }
            }
        }
        if(minValue != Integer.MAX_VALUE){
            array[amount] = minValue;
        }else {
            array[amount] = -1;
        }
        return array[amount];
    }


    //Accepted -----26ms
    /*
        top to down dp alogrithm
        using memorization searching
     */
    public  int coinChange1(int[] coins, int amount){
        int[] array = new int[amount + 1];
        int length = coins.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < length; i++){
            if(coins[i] < min){
                min = coins[i];
            }
        }
        return search1(coins, amount,array,min);
    }

    /*
        code reference from other
     */
    public int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    @Test
    public  void  test(){
        //int[] coins = {186,419,83,408};
        // int[] coins = {1,2,5};
        int[] coins = {474,83,404,3};
        int amount = 264;
        long startTime = System. currentTimeMillis();
        int result = coinChange1(coins, amount);
        long endTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("runnint time : " + (endTime - startTime));
    }
}
