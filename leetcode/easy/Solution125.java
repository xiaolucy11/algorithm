package interview.easy;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/16 0016.
 */
public class Solution125 {
    public boolean isPalindrome(String s){
        s = s.replaceAll("[:|,|\\s]" , "").toLowerCase();
        int left = 0, right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return  false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void  test1(){
        String s = "race a car";

        System.out.print(isPalindrome(s));
    }
}
