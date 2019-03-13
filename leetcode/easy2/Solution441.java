package interview.easy2;

import org.junit.Test;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/8 0008.
 */
public class Solution441 {
    public  int arrangeCoins(int n){
        if(n <= 0){return  0;}
        if(n ==1){return  1;}
        int  result1 = (int)(2 * Math.sqrt( n / 2)) ;
        System.out.println("result1 : " + result1);
        int result2 = (int)(2 * Math.sqrt( n / 2)) - 1;
        System.out.println("result2 : " + result2);
        int sum2 = 0;
        if(result1 % 2 == 0){
            sum2 = result1 / 2 * (result1 + 1);
        }else {
             sum2 = (result1 + 1) / 2 * result1;
        }
        System.out.println("sum2 : " + sum2);
        if(sum2  <= n){
            return result1;
        }else {
            return  result2;
        }

    }
    @Test
    public  void  test(){
        System.out.println( arrangeCoins(1804289383));

    }
}
