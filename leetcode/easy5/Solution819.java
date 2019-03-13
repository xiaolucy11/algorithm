package interview.easy5;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2018/8/3 0003.
 */
public class Solution819 {
    //Accepted ----34ms
    public  String mostCommonWord(String paragraph, String[] banned){
        Map<String, Integer> map = new HashMap<>();
        Set<String > set = new HashSet<>();
        for(int i = 0; i < banned.length; i++){
            set.add(banned[i]);
        }

        String[] strArr = paragraph.toLowerCase().split("[!?',;.\\s]");
        for(int i = 0; i < strArr.length; i++){
            if(!strArr[i].equals("") && !set.contains(strArr[i])){
                map.put(strArr[i], map.getOrDefault(strArr[i], 0) + 1);
            }
        }
        int max = 0;
        String result = "";
        for(String  key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                result = key;
            }
        }
        return   result;
    }

    @Test
    public  void  test(){
        String paragraph = "Bob. hIt, ball";
      /*  String[] result = paragraph.toLowerCase().split("[!?',;.\\s]");
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println("\n" + result.length);*/
      String[] words = {"hit","bob"};
        System.out.print(mostCommonWord(paragraph, words));
    }
}
