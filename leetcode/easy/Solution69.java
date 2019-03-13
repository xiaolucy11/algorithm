package interview.easy;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/9 0009.
 */
public class Solution69 {
    public int mySqrt(int x){
        double sqrtValue = Math.sqrt(x);
        int diff = x;
        for(int i = 0; i <= sqrtValue; i++){
            if(x - i * i  < diff){
                diff = x - i*i;

            }

        }
        return (int)(Math.sqrt(x - diff));
    }
    @Test
    public void test(){
        int x = 8;
        int result = mySqrt(x);
        System.out.print(result);

    }
}
