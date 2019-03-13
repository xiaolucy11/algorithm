package interview.easy2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/2 0002.
 */
public class Solution383 {
    public  boolean canConstruct(String ransomNote, String magazine){
        if(ransomNote.equals("") && magazine.equals("")){return true;}
        if((magazine.equals("")) || (magazine.length() < ransomNote.length())){return  false;}
        int ransomNoteLenght = ransomNote.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++){
            if(!map.containsKey(magazine.charAt(i))){
                map.put(magazine.charAt(i),1);
            }else {
                int temp1 = map.get(magazine.charAt(i));
                map.put(magazine.charAt(i), temp1+1);
            }
        }
        for(int j = 0;j < ransomNoteLenght;j++){
            if(!map.containsKey(ransomNote.charAt(j)) || map.get(ransomNote.charAt(j)) == 0){
                return false;
            }else {
                int temp2 = map.get(ransomNote.charAt(j));
                map.put(ransomNote.charAt(j), temp2-1);
            }
        }
        return  true;
    }

    @Test
    public  void  test(){
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.print(canConstruct(ransomNote, magazine));
    }
}
