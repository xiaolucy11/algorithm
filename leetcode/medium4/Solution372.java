package algorithm.medium4;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/24.
 */
public class Solution372 {
    public  int sum(int[] b){
        int lenght = b.length;
        int sum = 0, multiply = 1;
        for(int i = lenght - 1; i >= 0; i--){
            sum += multiply * b[i];
            multiply *= 10;
        }

        return  sum;
    }


    //not Accepted
    public  int superPow(int a, int[] b){
        int exp = sum(b);
        int ans = 1;
        a = a % 1337;

        while ( exp > 0){
            if(exp % 2 == 1){
                ans = (ans * a) % 1337;
            }
            exp /= 2;
            a = (a * a) % 1337;
        }
        return  ans;
    }

    @Test
    public  void  test(){
        int a = 2;
        int[] b = {1,0};
        System.out.print(superPow(a, b));
    }
}
