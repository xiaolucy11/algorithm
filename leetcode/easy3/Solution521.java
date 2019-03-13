package interview.easy3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/15 0015.
 */
public class Solution521 {
    public  boolean onlyOneChar(String s){
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(0)){
                return  false;
            }
        }
        return  true;
    }
    //Accepted
    public  int findLUSLength(String a, String b){
        if(a.equals("") && b.equals("")){return -1;}
        if(a.equals(b)){return -1;}
        if(onlyOneChar(a) && onlyOneChar(b) && (a.charAt(0) == b.charAt(0))){
            if(a.length() > b.length()){return a.length();}
            else if(a.length() == b.length()){
                return -1;
            }else {
                return b.length();
            }
        }

        if(a.length() > b.length()){
            return  a.length();
        }else {
            return  b.length();
        }
    }

    @Test
    public void  test(){
        String a = "aaaa";
        String b = "aaa";
        System.out.print(findLUSLength(a, b));
    }
}
