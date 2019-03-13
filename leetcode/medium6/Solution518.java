package algorithm.medium6;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by youlu on 2018/10/15.
 */
public class Solution518 {
    public  int count;

    public  void search(int[] coins,int index, int sum){
        if(sum == 0){
            count++;
            return;
        }

        for(int i = index; i >= 0; i--){
            if(coins[i] <= sum){
                search(coins,i,sum-coins[i]);
            }
        }
    }

    public  int change(int amount, int[] coins){
        if(amount == 0){
            return 1;
        }
        count = 0;
        Arrays.sort(coins);
        for(int i = coins.length - 1; i >= 0; i--){
            if(coins[i] <= amount){
                search(coins,i, amount - coins[i]);
            }
        }

        return count;
    }

    public  int[] arr;
    public int search1(int[] coins, int sum){
        int value = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < coins.length; i++){
            if(coins[i] == sum){
                value += 1;
                continue;
            }
            if(coins[i] < sum && !set.contains(coins[i]) && !set.contains(sum-coins[i])){
                if(arr[sum - coins[i]] != -1 && arr[coins[i]] != -1) {
                    value += arr[sum - coins[i]] * arr[coins[i]];
                }else if(arr[sum - coins[i]] != -1 && arr[coins[i]] == -1) {
                    value += search1(coins, coins[i]) * arr[sum - coins[i]];
                }else if(arr[coins[i]] != -1 && arr[sum - coins[i]] == -1){
                    value += search1(coins, sum-coins[i]) * arr[coins[i]];
                }else {
                    value += search1(coins, sum-coins[i]) * search1(coins, coins[i]);
                }
                set.add(coins[i]);
                set.add(sum - coins[i]);
            }else {
                break;
            }
        }
        arr[sum] = value;
        return arr[sum];
    }


    public  int change1(int amount, int[] coins){
        arr = new int[amount+1];
        arr[0]=1;
        for(int i = 1; i < amount + 1; i++){
           arr[i] = -1;
        }
        Arrays.sort(coins);
        int result = 0;
        for(int i = 0; i < coins.length; i++){
            if(coins[i] <= amount){
                result += search1(coins, amount - coins[i]);
            }
        }
        return result;
    }


    @Test
    public  void  test(){
       int[] coins = {1,2,5};
        int amount = 5;

      /* int[] coins = {2};
        int amount = 3;*/
      /*int[] coins = {10};
        int amount = 10;*/
     /* int[] coins = {3,5,7,8,9,10,11};
        int amount = 500;*/
        long startTime = System.currentTimeMillis();
        int result = change1(amount, coins);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));

    }
}
