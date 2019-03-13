package algorithm.medium6;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by youlu on 2018/10/9.
 */
public class Solution467 {

    public  int fib(int n){
        if(n == 1){
            return  1;
        }else {
            if(n <= 26) {
                return n + fib(n - 1);
            }else {
                return  26 + fib(n-1);
            }
        }
    }

    public  void add(String subStr, Set<String> set){
        int length = subStr.length();
        int len = 1;
        while (len <= length){
            for(int i = 0; i < length; i++){
                if(i + len  <= length){
                    set.add(subStr.substring(i, i+len));
                }
            }
            len++;
        }
    }


    //Accepted ----- 459ms
    /*
        not effecient
     */
    public int findSubstringInWraproundString(String p){
        Set<String> set = new HashSet<>();
        int pLength = p.length();
        int index = 0;
        while (index < pLength){
            if(p.charAt(index) == 'z'){
               if(index + 1 < pLength && p.charAt(index + 1) == 'a'){
                   int temp = index + 2;
                   while (temp < pLength){
                       if(p.charAt(temp) == 'a'){
                           if(p.charAt(temp - 1) == 'z'){
                               temp++;
                           }else {
                               break;
                           }
                       }else {
                           if(p.charAt(temp) - p.charAt(temp - 1) == 1){
                               temp++;
                           }else {
                               break;
                           }
                       }
                   }
                   String subStr = p.substring(index, temp);
                   System.out.println(subStr + "  : " + subStr.length());
                   if(subStr.length() >= 26 * 26){
                       return  fib(subStr.length());
                   }
                   add(subStr, set);
                   index = temp;
               }else {
                   if(index + 1 >= pLength){
                       set.add(Character.toString(p.charAt(index)));
                       break;
                   }else {
                       set.add(Character.toString(p.charAt(index)));
                       index++;
                   }
               }
            }else{
                int temp = index + 1;
                while (temp < pLength){
                    if(p.charAt(temp) == 'a'){
                        if(p.charAt(temp - 1) == 'z'){
                            temp++;
                        }else {
                            break;
                        }
                    }else {
                        if(p.charAt(temp) - p.charAt(temp - 1) == 1){
                            temp++;
                        }else {
                            break;
                        }
                    }
                }
                String subStr = p.substring(index, temp);
                System.out.println(subStr + "  :  " + subStr.length());
                if(subStr.length() >= 26 * 26){
                    return fib(subStr.length());
                }
                add(subStr, set);
                index = temp;
            }
        }

        return  set.size();
    }


    @Test
    public  void  test(){
       // String p = "zabfghi";
      /*  String p = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmn" +
                "opqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg" +
                "hijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzab" +
                "cdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvw" +
                "xyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrst" +
                "uvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";*/
       /*String p =  "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrs" +
               "tuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqr" +
               "stuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstu" +
               "vwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";*/
       // String p  = "zabcdefghijklmnopqrstuvwxyz";
        //String p = "cofzxdlhnf";
        String p = "vwxyefghijklmnopqrsomnopqrstuvefghijklmklmnopqrsqrstefghijklmnopqpqrstuvwxyzidefghijbcefghijklmnopqrstuvwghijklmnopqrstuvwhijklmnopbcdefghijklmnopopqrstuvwxyzstuvwxyfghijklmnopqrstuvwxyzmnopqrstuvwxyzhijklmnopfghijklfghijklmnopfghijklmnopqrsttuvwxabcdefghijklmnjklmnopqrstuvwxijklmnopabcdefghijklmnopqopqrstuvfghijklmnopqrstuvefghijkklmnopqrstuvabcdefghijklmnopqabcdefklmnopqefghijklmnopqrmbcdefghmnopqrstulnopqrstklmnopqrstuvwstuvnopqrstuvwxytuvwxhijklmnopqrstuvwxyzijklmnopqrstuabcdefghipqrstulabcdefghijklmnopijklmnopqrsabcdefgcdefghijklmnopqfghijklmnopqrfghijklmnohijklmnopqrstuvwxyzabcdhijklmnopqrstuvghijkrstuvwxyzabcdefghijklmnopqrcdefghijklmfghijklmnopqrstuvghijlmnopopqrstuvwxyjklmndefghijklmnopqrstuvwjklmghijklmnopqrstuvwxyfghijklmdefghijklmnopqrstuvwxfghijklmnopqrshijklmnopqcdefghiabcdefghijklmnopqrsttuvwuvwxyzhijklmnofghijkllmnopqrstuvwxnopqrhijklmnopqrstuvwxyzjklmnopqrstuvwxefghiefghijklmnopqrtuvwxpqrstuvklmnabcdefghijklmnopklefghijklmnopq" +
                "rstuvjklmnopqrsbcdefghijkcdefghijklmfghijklmnopqrstuv";
        long startTime = System.currentTimeMillis();
        int result = findSubstringInWraproundString(p);
        long endTime = System.currentTimeMillis();
        System.out.println("length of p" + p.length());

        System.out.println("result :  " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
