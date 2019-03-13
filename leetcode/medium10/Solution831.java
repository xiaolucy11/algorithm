package algorithm.medium10;

import org.junit.Test;

/**
 * Created by youlu on 2018/11/29.
 */
public class Solution831 {
    public  boolean isEmailAddress(String S){
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '@'){
                return  true;
            }
        }
        return  false;
    }

    public  String markEmail(String S){
         String str = S.toLowerCase();
        int index = 0;
        while ((index < S.length()) && (S.charAt(index) != '@')){
            index++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        sb.append("*****");
        sb.append(str.charAt(index-1));
        sb.append(str.substring(index, str.length()));

        return  sb.toString();
    }


    public  String markPhone(String S){
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            if((S.charAt(i) >= '0' && S.charAt(i) <= '9')){
                sb1.append(S.charAt(i));
            }
        }

        StringBuilder sb2 = new StringBuilder();
        if(sb1.length() > 10){
            sb2.append('+');
            int count = sb1.length() - 10;
            while (count > 0){
                sb2.append('*');
                count--;
            }
            sb2.append('-');
        }
        sb2.append("***-***-");
        sb2.append(sb1.substring(sb1.length() - 4,sb1.length()));
        return  sb2.toString();
    }


    //Accepted ----4ms
    public String maskPII(String S){
        if(isEmailAddress(S)){
            return  markEmail(S);
        }else {
            return  markPhone(S);
        }
    }


    @Test
    public  void  test(){
//        String S = "AB@qq.com";
//        String S = "LeetCode@LeetCode.com";
//        String S = "1(234)567-890";
        String S = "86-(10)12345678";


        long startTime = System.currentTimeMillis();
        String result = maskPII(S);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }

}
