package interview.medium1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/7 0007.
 */
public class Solution3 {

    //Accepted --------128ms
    public  int lengthOfLongestSubstring(String s){
        if(s.equals(" ")){return  1;}
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 1;
        int maxValue = 0;
        while (end < s.length()){
            if(!map.containsKey(s.charAt(end))){
                map.put(s.charAt(end), 1);
                end++;
            }else {
                map.clear();
                if(end - start > maxValue){
                    maxValue = end - start;
                }
                start++;
                end = start;
            }
        }
        if(end - start > maxValue){
            maxValue = end - start;
        }
        return  maxValue;
    }

    //Accepted ---------23ms
    public  int lengthOfLongestSubstring1(String s) {
        if (s.equals("")){return 0;}
        if(s.length() == 1){return  1;}
        int start = 0, end = 1;
        int maxValue = 0;
        while (end < s.length()) {
            int temp = start;
            while (temp < end) {
                if (s.charAt(temp) != s.charAt(end)) {
                    temp++;
                } else {
                    break;
                }
            }
            if (temp == end) {
                end++;
            }else {
                if(end - start > maxValue){
                    maxValue = end - start;
                }
                start = temp + 1;
            }
        }
        if(end - start > maxValue){
            maxValue = end - start;
        }
        return  maxValue;
    }

    @Test
    public  void  test(){
        String S = "pwwkew";
        System.out.print(lengthOfLongestSubstring1(S));
    }
}
