package interview.easy3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/14 0014.
 */
public class Solution504 {
    public String convertToBase7(int num){
        int absNum = Math.abs(num);
        String str = "";
        while (absNum >= 7){
            int mod = absNum % 7;
            int div = absNum / 7;
            str = (char)(mod + '0') + str;
            absNum = div;
        }
        str = (char)(absNum + '0') + str;
        if(num < 0){
            str = '-' + str;
        }
        return  str;
    }

    @Test
    public  void  test(){
        System.out.print(convertToBase7(-7));
    }
}
