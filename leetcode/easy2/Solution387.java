package interview.easy2;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2018/7/2 0002.
 */
public class Solution387 {

    //Accepted  -----156ms
    public int firstUniqChar(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else {
                int temp = map.get(s.charAt(i)) +1;
                map.put(s.charAt(i), temp);
            }
        }
        for(int j = 0; j < s.length();j++){
            if(map.get(s.charAt(j)) == 1){
                return j;
            }
        }
        return  -1;
    }

    //Accepted ----25ms
    public int firstUniqChar1(String s){
        if(s.length() == 1){return  0;}
        char[] charArray = new char[26];
        int indexValue = 0;
        for(int i = 0; i < s.length();i++){
            indexValue = s.charAt(i) - 'a';
            charArray[indexValue]++;
        }
        for(int j = 0; j < s.length();j++){
            indexValue = s.charAt(j) - 'a';
            if(charArray[indexValue] == 1){
                return j;
            }
        }
        return -1;

    }
    @Test
    public void test(){
        String s = "leetcode";
        System.out.print(firstUniqChar1(s));
    }
}
