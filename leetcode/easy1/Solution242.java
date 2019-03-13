package interview.easy1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/26 0026.
 */
public class Solution242 {

    public  boolean isAnagram(String s, String t){
        // can be refacotoried
        if((s.equals("") && (t.equals("")))){return  true;}
        if(s.length() == 1 && t.length() == 1){
            if(s.charAt(0) == t.charAt(0)){
                return  true;
            }else {
                return  false;
            }
        }
        if (s.equals(t)){return  false;}
        if(s.length() != t.length()){return  false;}

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++ ){
            if(!map1.containsKey(s.charAt(i))){
                map1.put(s.charAt(i), 1);
            }else {
                int value1 = map1.get(s.charAt(i)) + 1;
                map1.put(s.charAt(i), value1);
            }

            if(!map2.containsKey(t.charAt(i))){
                map2.put(t.charAt(i), 1);
            }else {
                int value2 = map2.get(t.charAt(i)) + 1;
                map2.put(t.charAt(i), value2);
            }
        }

        for(Character key : map2.keySet()){
            System.out.println("map1 : " + key + " :" + map1.get(key) + "  " + "map2  " + key + " :" + map2.get(key));
            if(!map1.containsKey(key) || map1.get(key) != map2.get(key)){
                return  false;
            }
        }
        return  true;
    }

    //Accepted
    public  boolean isAnagram1(String s, String t){
        if((s.equals("") && (t.equals("")))){return  true;}
        if(s.length() == 1 && t.length() == 1){
            if(s.charAt(0) == t.charAt(0)){
                return  true;
            }else {
                return  false;
            }
        }
        if (s.equals(t)){return  false;}
        if(s.length() != t.length()){return  false;}

        int[] countS = new int[26];
        int[] countT = new int[26];
        for(int i = 0; i < s.length(); i++){
            int indexS = s.charAt(i) - 'a';
            countS[indexS]++;

            int indexT = t.charAt(i) - 'a';
            countT[indexT]++;
        }

        for(int i = 0; i < 26; i++){
            if(countS[i] != countT[i]){
                return  false;
            }
        }
        return  true;

    }

    @Test
    public  void  test(){
        String s = "anagram";
        String t = "nagaran";
        System.out.print(isAnagram1(s, t));
    }
}
