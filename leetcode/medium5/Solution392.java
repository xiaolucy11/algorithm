package algorithm.medium5;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/28.
 */
public class Solution392 {

    //Accepted ---- 46ms
    public  boolean isSubsequences(String s, String t){
        int sLength = s.length();
        int tLength = t.length();
        int[] array = new int[tLength];
        int max  = 0;
        for(int i = 0; i < tLength; i++){
            if(max == sLength){
                return true;
            }

            if(t.charAt(i) == s.charAt(max)){
                array[i] = max+1;
                max++;
            }else {
                array[i] = max;
            }
        }

        if(max == sLength){
            return  true;
        }else {
            return  false;
        }
    }

    //Accepted --- 34ms
    public  boolean isSubsequences1(String s, String t){
        int indexS = 0, indexT = 0;
        while ((indexS < s.length()) && (indexT < t.length())){
            if(s.charAt(indexS) == t.charAt(indexT)){
                indexS++;
                indexT++;
            }else {
                indexT++;
            }
        }

        if(indexS == s.length()){
            return  true;
        }else {
            return  false;
        }
    }

    @Test
    public void  test(){
        String s = "abc";
        String t = "ahbgdc";
        long startTime = System.currentTimeMillis();
        System.out.println(isSubsequences1(s,t));
        long endTime = System.currentTimeMillis();
        System.out.println("runnint time : " + (endTime - startTime));
    }
}
