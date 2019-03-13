package interview.easy5;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Administrator on 2018/8/2 0002.
 */
public class Solution804 {
    public   String[] codes = {".-","-...","-.-.","-..",".","..-.",
            "--.","....","..",".---","-.-",".-..","--","-.",
            "---",".--.","--.-",".-.","...","-","..-","...-",
            ".--","-..-","-.--","--.."};
    public  String encode(String word){
        String  result = "";
        for(int i = 0; i < word.length(); i++){
            result += codes[word.charAt(i) - 'a'];
        }
        return result;
    }
    //Accepted ---9ms
    public  int uniqueMorseRepresentations(String[] words){

        Set<String> set = new TreeSet<>();
        for(int i = 0; i < words.length; i++){
           // System.out.println(encode(words[i]));
            set.add(encode(words[i]));
        }
        return  set.size();
    }

    @Test
    public  void  test(){
        String[]  words = {"gin", "zen", "gig", "msg"};
        System.out.print(uniqueMorseRepresentations(words));
    }
}
