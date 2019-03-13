package algorithm.medium7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by youlu on 2018/10/16.
 */
public class Solution524 {
    public  boolean isSubsuquence(String s, String str){
        int index1 = 0, index2 = 0;
        while ((index1 < s.length()) && (index2 < str.length())){
            if(s.charAt(index1) == str.charAt(index2)){
                index1++;
                index2++;
            }else {
                index1++;
            }
        }

        if(index2 >= str.length()){
            return  true;
        }else {
            return  false;
        }
    }

    //Accepted ----65ms

    public  String findLongestWord(String s, List<String> d){
        List<String> list = new ArrayList<>();
        int longest = 0;
        for(int i = 0; i < d.size(); i++){
            if(isSubsuquence(s, d.get(i))){
                if(d.get(i).length() > longest){
                    longest = d.get(i).length();
                    list.clear();
                    list.add(d.get(i));
                }else if(d.get(i).length() == longest){
                    list.add(d.get(i));
                }
            }
        }

        if(list.size() == 0){
            return  "";
        }else if(list.size() ==1){
            return list.get(0);
        }else {
            Collections.sort(list);
            return  list.get(0);
        }
    }

    @Test
    public  void  test(){
       /* String s = "abpcplea";
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");*/
      /* String s = "abpcplea";
        List<String> d = new ArrayList<>();
        d.add("a");
        d.add("b");
        d.add("c");*/

      String s = "apple";
        List<String> d = new ArrayList<>();
        d.add("zxc");
        d.add("vbn");

        long startTime = System.currentTimeMillis();
        String result = findLongestWord(s, d);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
