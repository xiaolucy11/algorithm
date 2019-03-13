package interview.easy1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/28 0028.
 */
public class Solution290 {
    public  boolean wordPattern(String pattern, String str){
        Map<Character, String> map = new HashMap<>();
        String[] strArray = str.split(" ");
        if(pattern.length() != strArray.length){return  false;}
        for(int i = 0; i < pattern.length(); i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(strArray[i])){
                    return false;
                }
            }else {
                if(map.containsValue(strArray[i])){return  false;}
                else {
                    map.put(pattern.charAt(i), strArray[i]);
                }
            }
        }
        return  true;
    }

    @Test
    public  void  test(){
        String pattern = "abba";
        String str = "dog dog dpg dog";
        System.out.print(wordPattern(pattern, str));
    }
}
