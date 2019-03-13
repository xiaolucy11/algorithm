package interview.easy;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/5 0005.
 */
public class Solution28 {
    public int strStr(String haystack, String needle){
        if(haystack == null ){
            return -1;
        }
        if(needle == null){
            return 0;
        }
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        for(int i = 0; i <= haystackLen - needleLen; i++){
            if(needle.equals(haystack.substring(i,i+needleLen))){
                return i;
            }
        }
        return -1;
    }
    @Test
    public void test(){
        String haystack = "hello";
        String needle = "ll";
        int index = strStr(haystack, needle);
        System.out.print(index);
    }
}
