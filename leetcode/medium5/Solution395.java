package algorithm.medium5;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlu on 2018/9/29.
 */
public class Solution395 {
    public  int longestSubstring(String s, int k){
        int length = s.length();
       int[] chars = new int[26];
        int[] array = new int[length];
        int count = 0;

        for(int i = 0; i < length; i++){
            int value = (int)(s.charAt(i) - 'a');
            chars[value]++;
            array[i] = chars[value];
            if(array[i] >= k){
                count++;
            }
        }
        return  0;
    }

    public boolean check(int[] chars, int k){
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != 0 && chars[i] < k){
                return  false;
            }
        }
        return true;
    }


    public int help(String s, int start, int end, int k){
        if( end - start + 1 < k){
            return  0;
        }

        int[] chars = new int[26];
        for(int i = start; i <= end; i++){
            int value = (int)(s.charAt(i) - 'a');
            chars[value]++;

        }

        if(check(chars, k)){
            return end - start + 1;
        }

        int index = end;
        while (index >= start){
            if(chars[(int)(s.charAt(index) - 'a')] < k){
                break;
            }else {
                index--;
            }
        }

        int leftValue = help(s,start,index-1,k);
        int rightValue = help(s, index+1, end,k);
        return  Math.max(leftValue, rightValue);

    }


    //Accepted ------73ms
    /*
        divide and conquer alogrithm

     */
    public  int longestSubstring1(String s, int k){
        return help(s,0, s.length()-1, k);
    }


    /*
        code from other
        using the condition. when it is valid subString, the number every character is more than k
        using for loop to compute the max lenght, but there exist same computation.
     */
    public int longestSubstring2(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] chs = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++chs[s.charAt(i) - 'a'];
        }
        boolean check = false;
        for (int i = 0; i < 26; ++i) {
            if (chs[i] > 0 && chs[i] < k) {
                check = true;
            }
        }
        if (!check) {
            return s.length();
        }

        int end = 0, max = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (chs[s.charAt(i) - 'a'] < k) {
                continue;
            } else {
                end = i;
                while (end < s.length() && chs[s.charAt(end) - 'a'] >= k) {
                    ++end;
                }
                max = Math.max(max, longestSubstring(s.substring(i, end), k));
                i = end;
            }
        }

        return max;
    }


    @Test
    public  void  test(){
        String s = "ababbc";
        //String s = "aaabb";
        //String s = "a";
        //String s = "bbaaacbd";
        int k = 2;
        long startTime = System.currentTimeMillis();
        int result = longestSubstring1(s,k);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("runnint time : " + (endTime - startTime));
    }
}
