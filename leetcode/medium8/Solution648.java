package algorithm.medium8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by youlu on 2018/10/26.
 */
public class Solution648 {
    //Accepted ----63ms
    /*
        using trie tree , to decrease search time from O(log(n)) to O(1)
     */
    public  String replaceWords(List<String> dict, String sentence){
        Set<String> set = new HashSet<>();
        for(int i = 0; i < dict.size(); i++){
            set.add(dict.get(i));
        }

        String[] words = sentence.split("\\s+");
        List<String> stringList = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            int flag = 0;
            for(int j = 1; j < words[i].length() && j <= 101; j++){
                String subStr = words[i].substring(0,j);
                if(set.contains(subStr)){
                   stringList.add(subStr);
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                stringList.add(words[i]);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            stringBuilder.append(stringList.get(i));
            if(i != words.length - 1){
                stringBuilder.append(" ");
            }
        }

        return  stringBuilder.toString();
    }

    @Test
    public  void  test(){
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String sentence = "the cattle was rattled by the battery";

        long startTime = System.currentTimeMillis();
        String result = replaceWords(dict, sentence);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
