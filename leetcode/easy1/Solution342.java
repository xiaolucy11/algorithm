package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/29 0029.
 */
public class Solution342 {
    public  boolean isPowerOfFour(int num){
        if(num <= 0){ return  false;}
        for(int i = 0; i < 16;i++){
            if( Math.pow(4, i) == num){return  true;}
            if(Math.pow(4, i) > Integer.MAX_VALUE){break;}
        }
        return false;
    }

    @Test
    public  void  test(){
        System.out.print(isPowerOfFour(5));
    }
}
