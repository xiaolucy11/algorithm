package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/11 0011.
 */
public class Solution50 {

    //Accepted -----17ms
    //can change the step to decrease the running time
    public  double myPow(double x, int n){

        if(x == 0){
            return  1;
        }
        if(x == 1){
            return  1;
        }
        double product = 1;
        if(n == 0){
            return 1.0;
        }else if (n > 0){

            if(n == 1){
                return  x;
            }
            if(n == Integer.MAX_VALUE){
                if((x > 0 && x < 1) || (x < 0 && x > -1)){
                    return 0;
                }else if(x > 1){
                    return Integer.MAX_VALUE;
                }else if(x < -1){
                    return Integer.MIN_VALUE;
                }else {
                    return -1.0;
                }
            }

            while (n > 0){
                product *= x;
                n--;
            }
        }else {
            if(n == Integer.MIN_VALUE){
                if(x > 0 && x < 1){
                    return Integer.MAX_VALUE;
                }else if(x > 1){
                    return 0;
                }else if(x <0 && x > -1){
                    return Integer.MAX_VALUE;
                }else if(x < -1){
                    return 0;
                }else {
                    return 1.0;
                }
            }
            while (n < 0){
                product = (1.0 / x) * product;
                n++;
            }
        }
        return  product;
    }

    @Test
    public  void test(){
        double x = 0.000001;
        int n = Integer.MAX_VALUE;
        System.out.print(myPow(x, n));
    }
}
