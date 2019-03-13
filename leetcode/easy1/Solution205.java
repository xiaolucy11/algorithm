package interview.easy1;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/6/22 0022.
 */
public class Solution205 {
    public  boolean isIsomorphics(String s, String  t){
        if( (s == null) && ( t == null)){return  true;}
        Map<Character, Character> map = new TreeMap<>();
        for(int i = 0; i < s.length(); i++){

            if(!map.containsKey(t.charAt(i)) ){
                if(!map.containsValue(s.charAt(i))) {
                    map.put(t.charAt(i), s.charAt(i));
                }else {
                    return false;
                }
            }else {
                if(map.get(t.charAt(i)) != s.charAt(i)){
                    return  false;
                }
            }
        }

        return  true;
    }

    @Test
    public  void  test(){
        String s = "paper", t = "title";
        System.out.print(isIsomorphics(s,t));
    }
}
