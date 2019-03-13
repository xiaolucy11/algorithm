package algorithm.hard1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youlu on 2018/12/4.
 */
public class Solution30 {

    public  boolean isSubString(String str, String[] words){
        int len = words[0].length();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        int index = 0;
        while (index < str.length()){
            String subStr = str.substring(index, index + len);
            if(map.containsKey(subStr) && map.get(subStr) > 0){
                map.put(subStr, map.get(subStr) - 1);
                index += len;
            }else {
                return  false;
            }
        }

        return  true;
    }

    //Accepted ---167ms
    /*
        it can be optimized,
        adjust step by words[0].lenght or words[0].length * words.length
     */
    public List<Integer> findSubstring(String s, String[] words){
        if(s.length() == 0 || words.length == 0){
            return  new ArrayList<>();
        }
        int oneWordLength = words[0].length();
        int totalWordsLength = oneWordLength * words.length;


        List<Integer> list = new ArrayList<>();
        for(int i = 0; i + totalWordsLength <= s.length(); i++){
            if(isSubString(s.substring(i, i+totalWordsLength), words)) {
                list.add(i);
            }
        }

        return  list;
    }


    @Test
    public  void  test(){
       /* String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};*/

       /*String s = "wordgoodstudentgoodword";
        String[] words = {"word", "student"};*/

       String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};


        long startTime = System.currentTimeMillis();
        List<Integer> result = findSubstring(s, words);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }
}
