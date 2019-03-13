package interview.easy2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/7 0007.
 */
public class Solution438 {
    public  boolean isanagrams(String s1, String s2){
        if(s1.length() != s2.length()){
            return  false;
        }
        int[] charArray = new int[26];
        for(int i = 0; i < s1.length(); i++){
            charArray[s1.charAt(i) - 'a']++;
        }
        for(int j = 0; j < s2.length(); j++){
            int index = s2.charAt(j) - 'a';
            if(charArray[index] ==0){
                return  false;
            }else {
                charArray[index]--;
            }
        }
        return  true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        if ((s == null) || (s.length() < p.length())) {
            return new ArrayList<Integer>();
        }
        int pLength = p.length();
        String subStr;
        List<Integer> l = new ArrayList<>();
        int[] pArray = new int[26];
        for (int pIndex = 0; pIndex < p.length(); pIndex++) {
            pArray[p.charAt(pIndex ) - 'a']++;
        }
        for (int i = 0; i + pLength <= s.length(); i++) {
            if (pArray[s.charAt(i) - 'a'] == 0) {
                continue;
            }
            int index = i;
            while (index < i + pLength) {
                if (pArray[s.charAt(index) - 'a'] == 0) {
                    i = index;
                    break;
                }
                index++;
            }
            if (index == i + pLength) {
                subStr = s.substring(i, i + pLength);
                if (isanagrams(subStr, p)) {
                    l.add(i);
                }
            }
        }
            return l;

    }


    @Test
    public  void  test(){
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
    }
}
