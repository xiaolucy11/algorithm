package interview.medium3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/9/9 0009.
 */
public class Solution187 {
    //Accepted -------162ms
    /*
        it can be optimized for using Set<>. when it contains, add to list.
     */
    public List<String> findRepeatedDnaSequences(String s){
        Map<String, Integer> map = new TreeMap<>();
        int length = s.length();
        for(int i = 0; i <= length-10; i++){
            String subString = s.substring(i, i+10);
            map.put(subString, map.getOrDefault(subString, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) > 1){
                result.add(key);
            }
        }
        return  result;
    }


    @Test
    public  void  test(){
        String s= "AAAAAAAAAAA";
        List<String> list = findRepeatedDnaSequences(s);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + "  ");
        }
    }
}
