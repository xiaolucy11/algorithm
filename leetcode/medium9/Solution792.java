package algorithm.medium9;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by youlu on 2018/11/14.
 */
public class Solution792 {
    public  boolean isSubsequences(String s, String t){
    int indexS = 0, indexT = 0;
    while ((indexS < s.length()) && (indexT < t.length())){
        if(s.charAt(indexS) == t.charAt(indexT)){
            indexS++;
            indexT++;
        }else {
            indexT++;
        }
    }

    if(indexS == s.length()){
        return  true;
    }else {
        return  false;
    }
}

    //Accepted -----517ms
    /*
        not effecient
     */
    public  int numMatchingSubseq(String S, String[] words ){
        int count  = 0;
        for(int i = 0; i < words.length; i++){
            if(isSubsequences( words[i], S)){
                count++;
            }
        }

        return  count;
    }

    /*
        code from other
        brilliant idea
     */
    public  int numMatchingSubseq1(String S, String[] words ){
        Map<Character, Deque<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.putIfAbsent(c, new LinkedList<String>());
        }
        for (String word : words) {
            map.get(word.charAt(0)).addLast(word);
        }

        int count = 0;
        for (char c : S.toCharArray()) {
            Deque<String> queue = map.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.removeFirst();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        return count;
    }

    @Test
    public  void  test(){
        String S = "abcde";
        String[] words = {"a","bb","acd","ace"};

        long startTime = System.currentTimeMillis();
        int result = numMatchingSubseq(S, words);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
