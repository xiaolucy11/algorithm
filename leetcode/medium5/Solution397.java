package algorithm.medium5;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/29.
 */
public class Solution397 {
    //Memory Limit Exceed
    public  int integerReplacement(int n){
        int[] arr = new int[n+1];
        arr[1] = 0;
        for(int i = 2; i <= n; i++){
            if(i % 2 == 0){
                arr[i] = arr[i / 2 ] + 1;
            }else {
                int value1 = arr[(i-1) / 2];
                int value2 = arr[(i+1) / 2];
                arr[i] = Math.min(value1, value2) + 2;
            }
        }
        return  arr[n];
    }

    //Accepted ---4ms
    /*
        when n = Integer.MAX_VALUE, cause stackoverflow
        when n < Integer,MAX_VALUE, not this problem,so write the bound test in if statement
     */
    public  int integerReplacement1(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return  1;
        }
        if(n == Integer.MAX_VALUE){
            return  32;
        }
        if(n % 2 == 0){
            return integerReplacement1(n / 2) + 1;
        }else {
            return Math.min(integerReplacement1((n-1) / 2), integerReplacement1((n+1)/ 2)) + 2;
        }
    }


    @Test
    public  void  test(){
       // int n = 65535;
        //int n = 100000000;
        int n = Integer.MAX_VALUE - 2;
        long startTime = System.currentTimeMillis();
        int result =  integerReplacement1(n);
        long endTime =  System.currentTimeMillis();
        System.out.println(result);
        System.out.println("runnint time : " + (endTime - startTime));
    }
}
