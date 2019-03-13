package interview.medium2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/9/4 0004.
 */
public class Solution134 {
    //Accepted -----1ms
    public int canCompleteCircuit(int[] gas, int[] cost){
        int[] array = new int[gas.length];
        int length = gas.length;

        array[0] = gas[0] - cost[0];
        int sum = array[0];

        for(int i = 1; i < length; i++){
            int value = gas[i] - cost[i];
            sum += value;
            array[i] = array[i-1] + value;
        }

        if(sum < 0){
            return -1;
        }
        int minValue = Integer.MAX_VALUE;
        int minIndex = length;

        for(int i = 0; i < length; i++){
            if(minValue > array[i] ){
                minIndex = i;
                minValue = array[i];
            }
        }
        if(minIndex == length-1){
            return  0;
        }else {
            return minIndex + 1;
        }
    }

    @Test
    public  void  test(){
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.print(canCompleteCircuit(gas, cost));
    }
}
