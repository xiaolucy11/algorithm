package interview.medium2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/4 0004.
 */
public class Solution137 {

    //reference from other
    public  int singleNumber(int[] nums){
        int a=0;
        int b=0;
        for(int c:nums){
            int ta=(~a&b&c)|(a&~b&~c);
            b=(~a&~b&c)|(~a&b&~c);
            a=ta;
        }
        //we need find the number that is 01,10 => 1, 00 => 0.
        return a|b;
    }
}
