package algorithm.hard1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by youlu on 2018/12/7.
 */
public class Solution65 {
    public  int type(String s){
        int noFlag = 0;
        int dotFlag = 0;
        int eFlag = 0;
        Set<Character> set = new HashSet<>();
        char[] chars = {'0','1','2','3','4','5','6','7','8','9','e','.','+','-'};
        for(int j = 0; j < chars.length; j++){
            set.add(chars[j]);
        }

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '.'){
                dotFlag++;
            }else if(s.charAt(i) == 'e'){
                eFlag++;
            }else if(!set.contains(s.charAt(i))){
                return  5; // invalid type
            }else {}
        }

        if((dotFlag == 0) && (eFlag == 0)){
            return 1;   //  exampe : 123456
        }else if((dotFlag == 1) && (eFlag == 0)){
            return  2; // 2.333
        }else if((dotFlag == 0) && (eFlag == 1)){
            return  3; // 2e1
        }else if((dotFlag == 1) && (eFlag == 1)){
            return  4; // 2.3e2 or 2e2.4
        }else {
            return 5;
        }
    }

    public  boolean check(String str){
        if((str.length() == 1) && (str.charAt(0) == '+' || str.charAt(0) == '-')){
            return  false;
        }

        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == '+' || str.charAt(i) == '-'){
                return  false;
            }
        }
        return  true;
    }

    public  boolean checkType2(String str ,int index){
        int i = index -1;
        int leftNumberCount = 0;
        int rightNumberCount = 0;
        while (i >= 0){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                leftNumberCount++;
            }
            i--;
        }

        int j = index + 1;
        while (j < str.length()){
            if(str.charAt(j) >= '0' && str.charAt(j) <= '9'){
                rightNumberCount++;
            }
            j++;
        }

        if(leftNumberCount == 0 && rightNumberCount == 0){
            return  false;
        }else {
            return  true;
        }
    }

    //Accepted ---49ms
    public boolean isNumber(String s){
        if(s.trim().length() == 0){
            return  false;
        }
        s = s.trim();
        int numberType = type(s);
        if(numberType == 5){
            return  false;
        }else if(numberType == 1 ){
           return check(s);
        }else if(numberType == 2){
            int dotIndex = s.indexOf('.');
            if(!checkType2(s, dotIndex)){
                return  false;
            }
            return  check(s);
        } else if(numberType ==3 ){
            int eIndex = s.indexOf('e');
            if(eIndex == 0 || eIndex == s.length() - 1){
                return  false;
            }else {
                return  check(s.substring(0, eIndex)) && check(s.substring(eIndex+1, s.length()));
            }
        }else {
            int eIndex = s.indexOf('e');
            int dotIndex = s.indexOf('.');

            if((dotIndex > eIndex) || (eIndex == 0) || (eIndex == s.length()-1)){
                return  false;
            }else {
                if(eIndex == 1){
                    return false;
                }else {
                    return check(s.substring(0, eIndex)) && check(s.substring(eIndex + 1, s.length()));
                }
            }
        }
    }


    @Test
    public  void  test(){
//        String s = "0.1";
//        String s = "abc";
//        String s = "1 a";
//        String s = "2e10";
//        String s = "-90e3";
//        String s = "1e";
//        String s = "e3";
//        String s = "6e-1";
//        String s = "99e2.5";
//        String s = "53.5e93";
//        String s = "--6";
//        String s = "-+3";
//        String s = "945da2";
//        String s = ".";
//        String s ".e1";
//        String s = "0e";
//        String s = "4e+";
//        String s = " -.";
        String s = "3. ";

        long startTime = System.currentTimeMillis();
        boolean b = isNumber(s);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + b);
        System.out.println("running time : " + (endTime - startTime));


    }
}
