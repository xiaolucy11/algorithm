package algorithm.hard1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/12/2.
 */
public class Solution10 {

    //Wrong Solution
    public  boolean isMatch(String s, String p){
        char ch = '0';
        int sIndex = 0, pIndex = 0;


        while ((sIndex < s.length()) && (pIndex < p.length())){
            if(s.charAt(sIndex) == p.charAt(pIndex)){
                sIndex++;
                pIndex++;
            }else {
                if(p.charAt(pIndex) == '*'){
                    if(pIndex != 0){
                        ch = p.charAt(pIndex - 1);
                        if(ch == '.') {
                            if (pIndex + 1 < p.length()) {
                                if (p.charAt(pIndex + 1) == s.charAt(sIndex)) {
                                    pIndex += 2;
                                    sIndex++;
                                } else {
                                    sIndex++;
                                }
                            }else {
                                sIndex++;
                            }
                        }else {
                            if(ch == s.charAt(sIndex)){
                                sIndex++;
                            }else {
                                pIndex++;
                            }
                        }
                    }else {
                        pIndex++;
                    }
                }else if(p.charAt(pIndex) == '.'){
                    pIndex++;
                    sIndex++;
                }else {
                    if(pIndex + 1 >= p.length() || p.charAt(pIndex+1) != '*'){
                        return  false;
                    }else {
                        pIndex += 2;
                    }
                }
            }
        }

        while (pIndex < p.length()){
            if(p.charAt(pIndex) == '*' ||
                    p.charAt(pIndex) == ch) {
                pIndex++;
            }else {
                if(pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*'){
                    pIndex += 2;
                }else {
                    break;
                }
            }
        }

        if(sIndex >= s.length() && pIndex >= p.length()){
            return  true;
        }else {
            return  false;
        }
    }


    public  boolean search(String s, String p, StringBuilder stringBuilder,int index){
        if(stringBuilder.length() > s.length() + 1){
            return  false;
        }
        if(index == p.length()){
            if(stringBuilder.length() == s.length()){

                for(int i = 0; i < s.length(); i++){
                    if(stringBuilder.charAt(i) == '.'){
                        continue;
                    }
                    if(stringBuilder.charAt(i) != s.charAt(i)){
                        return  false;
                    }
                }
                return  true;
            }else {
                return  false;
            }
        }


        if(p.charAt(index) == '.'){
            stringBuilder.append(p.charAt(index));
            if(search(s, p,stringBuilder, index+1)){
                return  true;
            }
        }else if (p.charAt(index) == '*'){
            char temp = stringBuilder.charAt(stringBuilder.length() - 1);
            String subStr = stringBuilder.substring(0, stringBuilder.length() - 1);

            if(search(s,p,new StringBuilder(subStr),index+1)){
                return  true;
            }

            StringBuilder duplicateStr = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                duplicateStr.append(temp);
                StringBuilder sb = new StringBuilder();
                sb.append(subStr);
                sb.append(duplicateStr);
                if(search(s,p,sb,index+1)){
                    return  true;
                }
            }

        }else {
            stringBuilder.append(p.charAt(index));
            if(search(s,p,stringBuilder, index+1)){
                return  true;
            }

        }

        return  false;
    }

    public  boolean check(String s, String p){
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            int value = (int)(s.charAt(i) - 'a');
            arr[value]++;
        }

        for(int j = 0; j < p.length(); j++){
            if(p.charAt(j) == '*' || p.charAt(j) == '.'){
                continue;
            }
            int index = (int)(p.charAt(j) - 'a');
            if(arr[index] == 0){
                if(j + 1 < p.length() && p.charAt(j+1) == '*'){
                    continue;
                }else {
                    return  false;
                }
            }
        }
        return  true;
    }


    //Time Limit Exceed
    public  boolean isMatch1(String s, String p){

        if(!check(s,p)){
            return false;
        }
        return  search(s,p, new StringBuilder(), 0);
    }


    public  boolean help(String s, String p,
                         int indexS, int indexP){
        if(indexS == s.length() && indexP == p.length()){
            return  true;
        }
        if(indexP == p.length() && indexS < s.length()){
            return  false;
        }

        if(indexS == s.length()){
            while (indexP < p.length()){
                if(p.charAt(indexP) != '*'){
                    if(indexP + 1 < p.length() && p.charAt(indexP + 1) == '*'){
                        indexP += 2;
                    }else {
                        return false;
                    }
                }else {
                    indexP++;
                }
            }

            if(indexP == p.length()){
                return  true;
            }else {
                return  false;
            }
        }

        if(s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.'){
            if((indexP + 1 < p.length()) && (p.charAt(indexP + 1) == '*')){
                return help(s,p,indexS+1,indexP+2) ||
                        help(s,p,indexS+1, indexP) || help(s,p, indexS,indexP+2);
            }else {
                return help(s, p, indexS + 1, indexP + 1);
            }
        }else {
            if((indexP + 1 < p.length()) && (p.charAt(indexP+1)) == '*'){
                return help(s,p,indexS,indexP+2);
            }else {
                return  false;
            }

            /*if(p.charAt(indexP) == '.'){
                return  help(s,p, indexS+1, indexP + 1);
            }else if(p.charAt(indexP) == '*'){
                char ch = p.charAt(indexP - 1);
                if(ch == s.charAt(indexS)){
                    return help(s,p,indexS+1, indexP);
                }else {
                    return  help(s,p, indexS, indexP+1);
                }
            }else {
                return  false;
            }*/
        }

    }

    //Accepted ----948ms
    /*
        trackbacking
        not effecient
     */
    public  boolean isMatch2(String s, String p){
         return  help(s,p,0,0);
    }

    /*
        code from other
        dp algorithm
     */
    public  boolean isMatch3(String s, String p){
        boolean[][] T = new boolean[s.length() + 1][p.length() + 1];
        T[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') T[0][i] = T[0][i - 2];
        }
        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    T[i][j] = T[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    T[i][j] = T[i][j - 2];
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        T[i][j] = T[i][j] || T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }

        return T[s.length()][p.length()];
    }


    @Test
    public  void  test(){
     /*  String s = "aa";
        String p  = "a";*/

    /*   String s = "a";
        String p = "ab*";*/

     /*  String s = "aa";
        String p = "a*";*/

      String s = "ab";
        String p = ".*";

    /*  String s = "aab";
        String p = "c*a*b";*/

   /*  String s = "mississippi";
        String p = "mis*is*p*.";*/

  /* String s = "ab";
        String p = ".*c";*/


   /*String s = "aaa";
        String p = "a*a";
*/
  /*  String s = "aaa";
        String p = "ab*a*c*a";*/

  /*String s = "bbbba";
        String p = ".*a*a";*/


      /* String s = "aaaaaaaaaaaaab";
        String p = "a*a*a*a*a*a*a*a*a*a*c";*/

        long startTime = System.currentTimeMillis();
        boolean b = isMatch2(s,p);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + b);
        System.out.println("running time : " + (endTime - startTime));


    }
}
