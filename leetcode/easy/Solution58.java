package interview.easy;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/6 0006.
 */
public class Solution58 {
    public int lengthOfLastWord(String s){
        if (s == null){return 0;}
        String [] str = s.split(" ");
        if(str.length == 0) {return 0;}
        return (str[str.length - 1]).length();
    }
    @Test
    public void test(){
        String s = "Hello";
        int len = lengthOfLastWord(s);
        System.out.println(len);
    }
}
