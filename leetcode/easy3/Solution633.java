package interview.easy3;

import org.junit.Test;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/23 0023.
 */
public class Solution633 {
    //Accepted -------9ms
    public  boolean judgeSquareSum(int c){
        int upBound = (int) Math.sqrt(c) + 1;

        int a = 0, b = upBound;
        while (a <= b){
            int value = a * a + b*b;
            if(value == c){
                return  true;
            }else  if(value < c){
                a++;
            }else {
                b--;
            }
        }

        return  false;
    }

    @Test
    public void  test(){
        long startTime = System.currentTimeMillis();
        System.out.println(judgeSquareSum(Integer.MAX_VALUE));
        long endTime = System.currentTimeMillis();
        System.out.println("running time : " + (endTime - startTime));
    }
}
