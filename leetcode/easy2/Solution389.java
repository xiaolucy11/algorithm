package interview.easy2;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/3 0003.
 */
public class Solution389 {

    //Accepted------28ms
    public char findTheDifference(String s, String t){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }else {
                int value1 = map.get(s.charAt(i)) ;
                map.put(s.charAt(i), value1 + 1);
            }
        }
        for(int j = 0; j < t.length(); j++){
            if(map.containsKey(t.charAt(j))){
                if(map.get(t.charAt(j)) != 0){
                    int value2 = map.get(t.charAt(j));
                    map.put(t.charAt(j), value2-1);
                }else {
                    return  t.charAt(j);
                }
            }else {
                return  t.charAt(j);
            }
        }
        return '0';
    }

    public char findTheDifference1(String s, String t){
        int[] charArray = new int[26];
        int indexS = -1;
        int indexT = -1;
        for(int i = 0; i < s.length(); i++){
            indexS = s.charAt(i) - 'a';
            charArray[indexS]++;
        }
        for(int j = 0; j < t.length(); j++){
            indexT = t.charAt(j) - 'a';
            if(charArray[indexT] == 0){
                return t.charAt(j);
            }else {
                charArray[indexT]--;
            }
        }
        return '0';
    }

    @Test
    public  void  test(){
        String s = "abcd";
        String t = "abcde";
        System.out.print(findTheDifference1(s,t));
    }
}
