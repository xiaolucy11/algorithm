package interview.easy2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/1 0001.
 */
public class Solution367 {

    public boolean isPerfectSquare(int num){
        if(num == 0 || num == Integer.MAX_VALUE){return  false;}

        for(int i = 1; i <= num; i++){
            if( i * i == num){
                return true;
            }
            if(i * i > num){
                return false;
            }
        }
        return  false;
    }

    @Test
    public void  test(){
        System.out.println(isPerfectSquare(15));
        System.out.print((int)Math.sqrt(Integer.MAX_VALUE));
    }

}
