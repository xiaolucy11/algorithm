package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/19 0019.
 */
public class Solution171 {
    public int titleToNumber(String s){
        String str = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int sum = 0;
        int multiply = 1;
        for(int i = s.length() - 1; i >= 0; i--){
            int num = str.indexOf(s.charAt(i));
            sum += multiply * num;
            multiply *= 26;
        }
        return  sum;
    }

    @Test
    public  void  test(){
        int result = titleToNumber("AB");
        System.out.print(result);
    }
}
