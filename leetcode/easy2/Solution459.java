package interview.easy2;

import org.junit.Test;

import javax.net.ssl.SSLContext;

/**
 * Created by Administrator on 2018/7/10 0010.
 */
public class Solution459 {
    //accepted -----168ms , can find the substring
    public boolean repeatedSubstringPattern(String s){
        if(s.length() == 1){return  false;}
        if(s.length() == 2){return  s.charAt(0) == s.charAt(1);}
        int leftIndex = 1, rightIndex = s.length() - 1;
        while(leftIndex < rightIndex){
            if(s.substring(0,leftIndex).equals(s.substring(rightIndex, s.length()))){
                int subLength = leftIndex;
                int flag =1;
                if(s.length() % subLength != 0){
                   leftIndex++;
                    rightIndex--;
                    continue;
                }
                for(int i = 0; i + subLength <= s.length(); i = i+subLength){
                    if(!s.substring(0, leftIndex).equals(s.substring(i, i+leftIndex))){
                        flag = 0;
                        break;
                    }
                }
                if(flag == 1){
                    return true;
                }
            }
            leftIndex++;
            rightIndex--;
        }
        if(leftIndex == rightIndex && s.substring(0, leftIndex).equals(s.substring(rightIndex, s.length()))){
            return true;
        }else {
            return  false;
        }
    }
    //Accepted ------178ms
    public  boolean repeatedSubstringPattern1(String s){
        if(s.length() == 1){return  false;}
        int slow = 0, quick = 1;
        int equealIndex = -1;
        while(quick < s.length()){
            if(s.charAt(slow) == s.charAt(quick)){
                if(slow == 0) {
                    equealIndex = quick;
                }
                slow++;
                quick++;
            }else {
                if(slow != 0) {
                    slow = 0;
                    quick = equealIndex ;
                }
                quick++;
            }
        }
        if(slow == 0){
            return  false;
        }else {
           quick = 0;
            while(slow < s.length()){
                if(s.charAt(slow) != s.charAt(quick)){
                    return  false;
                }
                slow++;
                quick++;
            }
            return  true;
        }
    }
    /*
        Solution3: 可以采用分n段匹配
     */

    @Test
    public  void  test(){
        String s = "abacababaca";
        System.out.print(repeatedSubstringPattern1(s));
    }
}
