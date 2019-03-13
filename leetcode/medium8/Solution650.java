package algorithm.medium8;

import org.junit.Test;

import java.util.Map;

/**
 * Created by youlu on 2018/10/26.
 */
public class Solution650 {

    //Accepted ----35ms
    /*
        from down to top
     */
    public  int maxgcd(int n){
        int value = (int)(Math.sqrt(n));
        if(value * value  == n){
            return  value;
        }
        for(int i = n-1; i > value; i--){
            if(n % i == 0){
                return i;
            }
        }
        return  n;
    }

    public  int minSteps(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return  2;
        }
        int[] arr = new int[n+1];
        arr[1] = 0;
        arr[2] = 2;

        for(int i = 3; i <= n; i++){
            if(i % 2 == 0){
                arr[i] = arr[i / 2] + 2;
            }else {
                int gcd = maxgcd(i);
                int value = i / gcd;
                if(value == 1) {
                    arr[i] = arr[value] + gcd;
                }else {
                    arr[i]  = arr[gcd] + value;
                }
            }
        }

        return  arr[n];
    }

    /*
        code from other
        from top to down
     */
    public int minSteps1(int n) {

        int result = 0;
        int d = 2;

        while(n > 1) {
            while( n % d == 0) {
                result += d;
                n = n / d;
            }
            d++;
        }

        return result;

    }

    @Test
    public  void  test(){
        int n = 189;
        System.out.print(minSteps(n));
    }

    @Test
    public  void  test1(){
        System.out.print(maxgcd(189));
    }
}
