package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/26 0026.
 */
public class Solution680 {
    //Accepted   ------38ms
    // it can be refactoried
    public  boolean validPalindrome(String s){
        int start = 0, end = s.length() - 1;
        while (start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else {
                int leftIndex1 = start + 1;
                int rightIndex1 = end;
                int flag1 = 0;
                while (leftIndex1 < rightIndex1){
                    if(s.charAt(leftIndex1) == s.charAt(rightIndex1)){
                        leftIndex1++;
                        rightIndex1--;
                    }else {
                        flag1 = 1;
                        break;
                    }
                }
                if(flag1 == 0){return  true;}

                int leftIndex2 = start ;
                int rightIndex2 = end-1;
                int flag2 = 0;
                while (leftIndex2 < rightIndex2){
                    if(s.charAt(leftIndex2) < s.charAt(rightIndex2)){
                        leftIndex2++;
                        rightIndex2--;
                    }else {
                        flag2 = 1;
                        break;
                    }
                }
                if(flag2 == 0 ){return  true;}
                return  false;
            }
        }
        return  true;
    }


    @Test
    public  void  test(){
        String s = "abca";
        System.out.println(validPalindrome(s));
    }
}
