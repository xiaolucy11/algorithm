package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/27 0027.
 */
public class Solutin693 {
    public  boolean hasAlternatingBits(int n){
        String s = Integer.toBinaryString(n);
        System.out.println("String bits : " + s);
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                return  false;
            }
        }
        return  true;
    }

    @Test
    public void  test(){
        System.out.println(hasAlternatingBits(7));

    }
}
