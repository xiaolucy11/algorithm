package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/31 0031.
 */
public class Solution746 {
    public  int getValue(int[] cost, int start, int end){
        if(start > end){
            return Integer.MAX_VALUE;
        }

        if (start == end){
            return  0;
        }

        if(end == 1){
            return  Math.min(cost[end], cost[end - 1]);
        }

        return  Math.min(getValue(cost, start + 1, end ), getValue(cost, start + 2, end)) + cost[start];

    }

    //Time limit Exceeded
    public  int minCostClimblingStairs(int[] cost){
       return  Math.min(getValue(cost, 0, cost.length), getValue(cost, 1, cost.length));
    }


    //Accepted ---- 17ms
    public  int minCostClimblingStairs1(int[] cost){
        if(cost.length == 2){
            return  Math.min(cost[0], cost[1]);
        }
        int index = cost.length -  3;
        int sum = 0;
        int length = cost.length;
        int[] arr = new int[length];
        arr[length - 1] = cost[length - 1];
        arr[length - 2] = cost[length - 2];
        while (index > -1){
            if(cost[index] + arr[index + 1] > cost[index] + arr[index + 2]){
                arr[index] = cost[index] + arr[index + 2];
            }else {
                arr[index] = cost[index] + arr[index + 1];
            }
            index--;
        }
        if(arr[0] < arr[1]){
            return  arr[0];
        }else {
            return arr[1];
        }
    }

    @Test
    public  void  test(){
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.print(minCostClimblingStairs1(cost));
    }
}
