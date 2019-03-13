package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/30 0030.
 */
public class Solution344 {
    public String reverseString (String s){
        return new StringBuffer(s).reverse().toString();

    }

    @Test
    public  void  test(){
        String s = "hello";
        System.out.print(reverseString(s));
    }
}
