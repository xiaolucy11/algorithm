package algorithm.medium4;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/23.
 */
public class Solution357 {
    public  int compute(int n){
        int count = n-1;
        int product = 9, startNumber = 9;
        while (count > 0){
            product *= startNumber;
            startNumber--;
            count--;
        }

        return  product;
    }


    //Accepted ------- 0ms
    public  int countNumbersWithUniqueDigits(int n){
        int[] array = new int[n+1];
        array[0] = 1;
        for(int i = 1; i < n+1; i++){
            int value = compute(i);
            array[i] = array[i-1] + value;
        }

        return  array[n];
    }


    @Test
    public  void  test(){
        int n = 0;
        long  startTime = System.currentTimeMillis();
        System.out.println(countNumbersWithUniqueDigits(n));
        long endTime = System.currentTimeMillis();
        System.out.println("runnint time : " + (endTime - startTime));
    }
}
