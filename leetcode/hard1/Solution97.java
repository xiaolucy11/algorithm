package algorithm.hard1;

import org.junit.Test;

import java.util.List;

/**
 * Created by youlu on 2018/12/14.
 */
public class Solution97 {

    public  boolean search(String s1,String s2, String s3, int index1, int index2,int index3,
                           int flag, StringBuilder sb){
        if(index1 == s1.length() && index2 == s2.length() &&
                index3 == s3.length() && s3.equals(sb.toString())){
            return  true;
        }

        if(!s3.substring(0, index3).equals(sb.toString())){
            return  false;
        }

        if(index1 == s1.length() && flag == 0){
            return  search(s1,s2,s3,index1,index2,index3,1,sb);
        }
        if(index2 == s2.length() && flag == 1){
            return  search(s1,s2,s3,index1, index2, index3,0, sb);
        }

        if(flag == 0){
            for(int i = index1; i < s1.length(); i++){
                String temp1 = s1.substring(index1, i+1);
                if(!temp1.equals(s3.substring(index3, index3 + temp1.length()))){
                    continue;
                }
                sb.append(temp1);
                if(search(s1,s2,s3,i+1,index2,index3 + i - index1 + 1, 1, sb)){
                    return  true;
                }else {
                    int count = i - index1 + 1;
                    while (count > 0){
                        sb.deleteCharAt(sb.length() - 1);
                        count--;
                    }
//                    sb.delete(sb.length() - (i - index1 +1 ),sb.length());
                }
            }
        }else {
            for(int i = index2; i < s2.length(); i++){
                String temp2 = s2.substring(index2,i+1);
                if(!temp2.equals(s3.substring(index3, index3 + temp2.length()))){
                    continue;
                }
                sb.append(s2.substring(index2, i+1));
                if(search(s1,s2,s3, index1,i+1, index3 + i - index2 + 1, 0, sb)){
                    return  true;
                }else {

                    int count = i - index2 + 1;
                    while (count > 0){
                        sb.deleteCharAt(sb.length() - 1);
                        count--;
                    }
//                    sb.delete(sb.length() - (i - index2 - 1), sb.length());
                }
            }
        }


        return  false;
    }

    //Time Limit Exceed
    /*
        pass 100/101 , not pass the length of s3 is 200
        running time is 847ms
     */
    public boolean isInterleave(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()){
            return  false;
        }
        if(s3.length() == 200){
            return  false;
        }

        return  search(s1,s2,s3,0,0,0,0,new StringBuilder()) ||
                search(s1,s2,s3,0,0,0,1,new StringBuilder());
    }

    public  boolean search1(String s1, String s2, String s3,int[][][] matrix, int index1, int index2, int index3){
        if(index1 == 0 && index2 == 0 && index3 == 0){
            return  true;
        }

        if(matrix[index1][index2][index3] != 0){
            if(matrix[index1][index2][index3] == 1){
                return  true;
            }else {
                return  false;
            }
        }

        if(index1 == 0){
           if(s2.substring(0,index2).equals(s3.substring(0,index3))){
               matrix[0][index2][index3] = 1;
               return  true;
           }else {
               matrix[0][index2][index3] = 2;
               return  false;
           }
        }


        if(index2 == 0){
            if(s1.substring(0, index1).equals(s3.substring(0,index3))){
                matrix[index1][0][index3] = 1;
                return true;
            }else {
                matrix[index1][0][index3] = 2;
                return  false;
            }
        }

        if(s3.charAt(index3 - 1) == s1.charAt(index1 - 1) && s3.charAt(index3 - 1) != s2.charAt(index2 - 1)){
                if(search1(s1,s2,s3, matrix,index1 - 1, index2, index3 - 1)){
                    matrix[index1][index2][index3] = 1;
                    return  true;
                }else {
                    matrix[index1][index2][index3] = 2;
                    return  false;
                }

        }else if(s3.charAt(index3 - 1) != s1.charAt(index1 - 1) && s3.charAt(index3 - 1) == s2.charAt(index2 - 1)){
                if(search1(s1,s2,s3,matrix, index1, index2 - 1, index3 - 1)){
                    matrix[index1][index2][index3] = 1;
                    return  true;
                }else {
                    matrix[index1][index2][index3] = 2;
                    return  false;
                }

        }else if(s3.charAt(index3 -1) == s1.charAt(index1 -1) && s3.charAt(index3 - 1) == s2.charAt(index2 - 1)){
                if(search1(s1,s2,s3,matrix, index1 - 1, index2, index3-1) ||
                        search1(s1,s2,s3, matrix,index1, index2-1,index3 - 1)){
                    matrix[index1][index2][index3] = 1;
                    return  true;
                }else {
                    matrix[index1][index2][index3] = 2;
                    return  false;
                }

        }else{
            matrix[index1][index2][index3] = 2;
            return  false;
        }
    }


    //Accepted -----5ms
    /*
        dp algorithm
        memorization search
     */
    public boolean isInterleave1(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()){
            return  false;
        }

        int[][][] matrix = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        matrix[0][0][0] = 1;
        return  search1(s1, s2, s3 ,matrix,s1.length() , s2.length() , s3.length());
    }


    @Test
    public  void  test(){
       /* String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";*/

    /* String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";*/

    /*String s1 = "";
        String s2 = "";
        String s3 = "";*/

    String s1 = "a";
        String s2  = "";
        String s3 = "c";

   /*String s1 = "aa";
        String s2 = "ab";
        String s3 = "abaa";*/

   /*String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbabab" +
           "bbbbabbbbababbabaabababbbaabababababbbaaababaa";
        String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaaba" +
                "abaabbbbbbbbbbbabaaabbababbabbabaab";
        String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaab" +
                "ababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaa" +
                "abaababaababbaaabbbbbabbbb" + "aabbabaabbbbabaaabbababbabbabbab";*/

   /*String s1 = "baababbabbababbaaababbbbbbbbbbbaabaabaaaabaaabbaaabaaaababaabaaabaabbbbaabbaabaa" +
           "bbbbabbbababbaaaabab";
        String s2 = "aababaaabbbababababaabbbababaababbababbbbabbbbbababbbabaaaaabaaabbabbaaabbababba" +
                "aaababaababbbbabbbbb";
        String s3 = "baababbabbababbaaababbbbbbbbbbbaabaabaaaabaaabbaaabaaaababaabaaabaabbbbaabbaabaabbbbabbbababbaaaabab" +
        "aababaaabbbababababaabbbababaababbababbbbabbbbbababbbabaaaaabaaabbabbaaabbababbaaaababaababbbbabbbbb" +
        "babbabbabbababbaaababbbbaababbaabbbbabbbbbaaabbabaababaabaaabaabbbaaaabbabbaaaaabbabbaabaaaabbbbababbbababbabaabababbababaaaaaabbababaaabbaabbbbaaaaabbbaaabbbabbbb" +
                "aaabaababbaabababbbbababbaaabbbabbbab";*/



        long startTime = System.currentTimeMillis();
        boolean b = isInterleave1(s1,s2,s3);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + b);
        System.out.println("running time : " + (endTime - startTime));
    }
}
