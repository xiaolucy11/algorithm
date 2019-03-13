package interview.easy3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/13 0013.
 */
public class Solution500 {

    //Accepted ---------1ms
    public  boolean check(String str){
        int[] charArray = {1,2,3,1,0,1,1,1,0,1,1,1,2,2,0,0,0,0,1,0,0,2,0,2,0,2};
        int lineOfFirstChar = charArray[Character.toLowerCase(str.charAt(0)) - 'a'];
        for(int i = 1; i < str.length(); i++){
            char ch = str.charAt(i);
            if(charArray[Character.toLowerCase(ch) - 'a'] != lineOfFirstChar){
                return  false;
            }
        }
        return  true;
    }
    public  String[] findWords(String[] words){
        List<String> stringList = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            if(check(words[i])){
                stringList.add(words[i]);
            }
        }
        String[] result = new String[stringList.size()];
        int index = 0;
        for(int i = 0; i < stringList.size(); i++){
            result[index++] = stringList.get(i);
        }
        return  result;
    }

    @Test
    public  void  test(){
        String[] words = {"Hello", "Alaska", "Dad","Peace"};
        String[] result = findWords(words);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + "  ");
        }
    }
}
