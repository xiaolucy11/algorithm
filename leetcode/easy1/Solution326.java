package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/29 0029.
 */
public class Solution326 {
    public  boolean isMathch(int digit){
        if(digit == 1 || digit == 3 || digit == 7 || digit == 9){
            return  true;
        }else {
            return  false;
        }
    }

    // solution wrong
    public boolean isPowerOfThree(int n){
        if(n == 0){
            return false;
        }
        if(n == 3 || n == 1){return  true;}
        int sum = 0;
        int tmp = 0;
        int lastDigit = n % 10;
        while (n > 9){
           tmp = n % 10;
            sum += tmp;
            n /= 10;
        }
        sum += n;
        if((sum % 9 == 0) && (isMathch(lastDigit))){return  true;}
        else {return  false;}
    }

    public  boolean isPowerOfThree1(int n){
        if(n == 0){return  false;}
        for(int i = 0; i <= 20; i++){
            if(Math.pow(3, i) == n){return  true;}
            if( Math.pow(3, i) > Integer.MAX_VALUE){break;}
        }
        return  false;
    }

    @Test
    public  void  test(){
        System.out.print(isPowerOfThree1(27));
    }
}
