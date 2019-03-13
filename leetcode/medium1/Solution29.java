package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/10 0010.
 */
public class Solution29 {

    //Accepted ---1183ms
    public  int divide(int dividend, int divisor){
        if(dividend == 0){
            return  0;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return  Integer.MAX_VALUE;
        }
        if(dividend == Integer.MIN_VALUE && dividend == Integer.MIN_VALUE){
            return  1;
        }
        if(divisor == 1){
            return  dividend;
        }

        if(divisor == -1){
            return  -1 * dividend;
        }

        if( dividend > 0 && divisor > 0){
            int count = 0;
            while (dividend >= divisor ){
                count++;
                dividend = dividend - divisor;
            }
           return count;
        }else if (dividend < 0 && divisor < 0){
            int count = 0;
            while (dividend <= 0 ){
                count++;
                dividend = dividend - divisor;
            }
            return  count - 1;
        }else if(dividend < 0 && divisor > 0){
            int count = 0;
            while (dividend <= 0){
                count++;
                dividend = dividend + divisor;
            }
            return  -1 * (count - 1 );
        }else {
            int count = 0;
            while (dividend >=  0 ){
                count++;
                dividend = dividend +  divisor;
            }
            return  -1 * (count - 1 );
        }
    }

    public  int divide1(int dividend, int divisor){
        if(dividend == 0){
            return  0;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return  Integer.MAX_VALUE;
        }
        if(dividend == Integer.MIN_VALUE && dividend == Integer.MIN_VALUE){
            return  1;
        }
        if(divisor == 1){
            return  dividend;
        }

        if(divisor == -1){
            return  -1 * dividend;
        }
        if (dividend == Integer.MIN_VALUE){
            if(divisor < 0){
                int count = 0;
                while (dividend <= 0 ){
                    count++;
                    dividend = dividend - divisor;
                }
                return  count - 1;
            }else {
                int count = 0;
                while (dividend <= 0){
                    count++;
                    dividend = dividend + divisor;
                }
                return  -1 * (count - 1 );
            }
        }
        int flag = 1;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            flag = -1;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            flag = -1;
        }
        int result = 0;
        int multiply = 1;
        int sum = 0;
        while (dividend >= divisor){
            multiply = 1;
           int temp = divisor;
            while (dividend >= (temp << 1)){
                temp = temp << 1;
                multiply = multiply << 1;
            }
            result += multiply;
            dividend -= temp;
        }
        if(flag == -1){
            return  -1 * result;
        }else {
            return  result;
        }
    }

    @Test
    public  void  test(){
        int dividend = 7;
        int divisor = -3;
        System.out.print(divide1(dividend, divisor));
    }

}
