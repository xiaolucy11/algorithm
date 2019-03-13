package interview.medium3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2018/9/5 0005.
 */
public class Solution139 {
    public boolean  search(String s, int start, int end, Set<String> set, int maxLength){
        if(start > end){
            return  true;
        }

        int maxDistance = Math.min(maxLength, end - start + 1);
        for(int i = start +  maxDistance; i > start; i--){
            String subStr = s.substring(start, i);
            if(set.contains(subStr) && search(s, i, end, set, maxLength) ){
                return  true;
            }
        }

        return  false;
    }

    //Time Limited out
    public  boolean wordBreak(String s, List<String> wordDict){

        Set<String> set = new HashSet<>();
        Set<Character> charSet = new HashSet<>();
        //int[] chars = new int[26];
        int strLength = s.length();
        int maxLength = 0;
        for(int i = 0; i < wordDict.size(); i++){
            int len = wordDict.get(i).length();
            if(len > maxLength){
                maxLength = len;
            }
            set.add(wordDict.get(i));

            for(int j = 0; j < len; j++){
                charSet.add(wordDict.get(i).charAt(j));
            }
        }

       for(int i = 0; i < strLength; i++){
            if(!charSet.contains(s.charAt(i))){
                return  false;
            }
        }

      /*  if(isSame(s) && set.contains(Character.toString(s.charAt(0)))){
            return  true;

        }*/
        return  search(s, 0, s.length()-1,set, maxLength);
    }

    public  void  search1(String s, int start, int end, Set<String> set, int[] array){
        if(start >= end){
            return;
        }
        if(set.contains(s.substring(start, end))){
            array[start] = 1;
            return;
        }

        for(int i = start; i < end; i++){
            String subStr = s.substring(start, i+1);
            if(set.contains(subStr) && array[i+1] == 1){
                array[start] = 1;
                return;
            }
        }
    }


    //Accepted ----18ms
    /*
        dp algorithm , using space to decrease running time
     */
    public  boolean wordBreak1(String s, List<String> wordDict){
        Set<String> set = new HashSet<>();
        int sLength = s.length();
        int[] array = new int[sLength];

        for(int i = 0; i < wordDict.size(); i++){
            set.add(wordDict.get(i));
        }

        for(int i = sLength -1; i >= 0; i--){
            search1(s, i, sLength, set, array);
        }

        if(array[0] == 1){
            return  true;
        }else {
            return  false;
        }
    }

    @Test
    public  void  test(){
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
       /* wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("ab");*/

        long startTime = System.currentTimeMillis();
        System.out.println(wordBreak1(s, wordDict));
        System.out.println("running time : " + (System.currentTimeMillis() - startTime));
    }
}
