package algorithm.hard1;

import org.junit.Test;

/**
 * Created by youlu on 2018/12/5.
 */
public class Solution44 {

    public  boolean help(String s , String p, int indexS, int indexP){
        if(indexS == s.length() && indexP == p.length()){
            return  true;
        }
        if(indexP == p.length() && indexS < s.length()){
            return  false;
        }

        if(indexS == s.length()){
                while (indexP < p.length()){
                    if(p.charAt(indexP) != '*'){
                        break;
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

         if(p.charAt(indexP) == '?'){
             return help(s, p, indexS+1, indexP+1);
         }else if(p.charAt(indexP) == '*'){
             return help(s,p, indexS,indexP+1) || help(s,p, indexS+1, indexP+1) ||
                     help(s,p, indexS+1, indexP);
         }else {
             if(p.charAt(indexP) == s.charAt(indexS)){
                 return  help(s,p, indexS+1, indexP+1);
             }else {
                 return  false;
             }
         }
    }

    public int memorySearch(String s, String p, int indexS, int indexP, int[][] matrix){
        if(indexS > 0 && indexP == 0){
           if(p.charAt(indexP) == '*'){
               matrix[indexS][indexP] = 1;
           }else {
               matrix[indexS][indexP] = 0;
           }
           return  matrix[indexS][indexP];
        }

        if(indexS == 0 && indexP > 0) {
            int temp1 = indexP;
            if (s.charAt(indexS) == p.charAt(indexP)){
                temp1--;
                while (temp1 >= 0) {
                    if (p.charAt(temp1) == '*') {
                        temp1--;
                    } else {
                        break;
                    }
                }

            if (temp1 < 0) {
                matrix[indexS][indexP] = 1;
            } else {
                matrix[indexS][indexP] = 0;
            }

            return  matrix[indexS][indexP];
        }else {
                int count = 0;
                int temp2 = indexP;
                while (temp2 >= 0) {
                    if (p.charAt(temp2) == '*') {
                        temp2--;
                    }else if(count == 0 && (p.charAt(temp2) == s.charAt(indexS) || p.charAt(temp2) == '?')) {
                        temp2--;
                        count++;
                    } else {
                        break;
                    }
                }

                if (temp2 < 0) {
                    matrix[indexS][indexP] = 1;
                } else {
                    matrix[indexS][indexP] = 0;
                }

                return  matrix[indexS][indexP];
            }
        }


        if(indexS == 0 && indexP == 0){
            if(p.charAt(indexP) == '*' || p.charAt(indexP) == '?'){
                matrix[0][0] = 1;
            }else {
                if(p.charAt(indexP) == s.charAt(indexS)){
                    matrix[0][0] = 1;
                }else {
                    matrix[0][0] = 0;
                }
            }
            return  matrix[0][0];
        }

        if(p.charAt(indexP) == '?'){
            if( (indexS - 1 >= 0 && indexP - 1 >= 0)&& (matrix[indexS - 1][indexP-1] != -1)){
                matrix[indexS][indexP] = matrix[indexS-1][indexP-1];
            }else {
                matrix[indexS][indexP] = memorySearch(s,p, indexS-1, indexP-1, matrix);
            }
            return  matrix[indexS][indexP];
        }else if(p.charAt(indexP) == '*'){
            int v1 = 0, v2 = 0, v3 = 0;
            if(  indexP - 1 >= 0 && matrix[indexS][indexP-1] != -1){
                v1 = matrix[indexS][indexP-1];
            }else {
                v1 = memorySearch(s,p, indexS,indexP-1, matrix);
            }

            if(  (indexS - 1 >= 0 && indexP - 1 >= 0)&& matrix[indexS-1][indexP-1] != -1){
                v2 = matrix[indexS-1][indexP-1];
            }else {
                v2 = memorySearch(s,p, indexS-1, indexP-1, matrix);
            }

            if(  indexS - 1 >= 0 &&matrix[indexS-1][indexP] != -1){
                v3 = matrix[indexS-1][indexP];
            }else {
                v3 = memorySearch(s,p, indexS-1, indexP, matrix);
            }

            if(v1 == 1 || v2 == 1 || v3 == 1){
                matrix[indexS][indexP] = 1;
            }else {
                matrix[indexS][indexP] = 0;
            }
            return  matrix[indexS][indexP];
        }else {
            if(p.charAt(indexP) == s.charAt(indexS)){
                if( (indexS - 1 >= 0 && indexP - 1 >= 0)&& matrix[indexS - 1][indexP-1] != -1){
                    matrix[indexS][indexP] = matrix[indexS-1][indexP-1];
                }else {
                    matrix[indexS][indexP] = memorySearch(s,p, indexS-1, indexP-1, matrix);
                }
            }else {
                matrix[indexS][indexP] = 0;
            }

            return  matrix[indexS][indexP];
        }
    }



    //Accepted ----51ms
    /*
        dp algorithm
        memorization searching
     */
    public  boolean isMatch(String s, String p){

        if( s.length() == 0 &&  p.length() == 0){
            return  true;
        }
        if( p.length() == 0 &&  s.length() != 0){
            return  false;
        }

        if( s.length() == 0){
            int indexP = 0;
            while (indexP < p.length()){
                if(p.charAt(indexP) != '*'){
                    break;
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

        int[][] matrix = new int[s.length()][p.length()];

        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < p.length(); j++){
                matrix[i][j] = -1;
            }
        }
        int result =   memorySearch(s,p, s.length()-1, p.length()-1, matrix);

        if(result == 1){
            return true;
        }else {
            return  false;
        }
    }


    @Test
    public  void  test(){
       /* String s = "aa";
        String p = "a";*/

      /* String s = "a";
        String p = "a*";*/

      /*String s = "aab";
        String p = "c*a*b";*/

      String s = "a";
        String p = "?*";

      /*String s = "aa";
        String p = "*";*/

    /* String s = "cb";
        String p = "?a";*/

   /* String s =  "adceb";
        String p = "*a*b";
*/
     /*   String s = "acdcb";
        String p = "a*c?b";*/

     /* String s = "b";
        String p = "*?*?*";*/
    /* String s = "babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab";
        String p = "***bba**a*bbba**aab**b";*/

    /*String s = "";
        String p = "*";*/

        long startTime = System.currentTimeMillis();
        boolean b = isMatch(s,p);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + b);
        System.out.println("running time : " + (endTime - startTime));
    }
}
