package algorithm.hard1;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by youlu on 2018/12/9.
 */
public class Solution76 {

    //Accepted ----38ms
    /*
        code is not clean
        Map can be replaced by new int[128]
     */
    public  String minWindow(String s, String t){
        Map<Character, Integer> tMap1 = new HashMap<>();
        Map<Character, Integer> tMap2 = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();

        for(int i = 0; i < t.length(); i++){
            tMap1.put(t.charAt(i), tMap1.getOrDefault(t.charAt(i), 0) + 1);
            tMap2.put(t.charAt(i), tMap2.getOrDefault(t.charAt(i), 0) + 1);
        }

        int end = 0;
        int count  =0;
        while (end < s.length()){
            if(tMap1.containsKey(s.charAt(end))){
                int value1 = tMap1.get(s.charAt(end));
                if(value1 == 1){
                    count++;
                }
                if(value1 > 0){
                    tMap1.put(s.charAt(end), value1 - 1);
                }

                sMap.put(s.charAt(end), sMap.getOrDefault(s.charAt(end), 0) + 1);
                if(count == tMap1.keySet().size()){
                    break;
                }
            }

            end++;
        }

        if(count < tMap1.keySet().size()){
            return  "";
        }

        int start = 0;

        while (start < end){
            if(!tMap2.containsKey(s.charAt(start))){
                start++;
            }else {
                break;
            }
        }

        int minWindow = end - start + 1;
        queue.add(s.substring(start,end+1));

        while (end < s.length()){
            char ch = s.charAt(start);
            start++;
            sMap.put(ch, sMap.get(ch) - 1);

            while (start < end){
                if(!tMap2.containsKey(s.charAt(start)) ){
                    start++;
                }else  if(sMap.get(s.charAt(start)) > tMap2.get(s.charAt(start))){
                    int value2 = sMap.get(s.charAt(start));
                    sMap.put(s.charAt(start), value2 - 1);
                    start++;
                }else {
                    break;
                }
            }


            if(sMap.get(ch) >= tMap2.get(ch)){
                if(end - start + 1 < minWindow) {
                    queue.poll();
                    queue.add(s.substring(start, end + 1));
                    minWindow = Math.min(end - start + 1, minWindow);
                }
                continue;
            }else {
                end++;
            }
            while (end < s.length()){
                if(s.charAt(end) != ch){
                    if (tMap2.containsKey(s.charAt(end))){
                        sMap.put(s.charAt(end), sMap.getOrDefault(s.charAt(end), 0) + 1);
                    }
                    end++;
                }else {
                    sMap.put(s.charAt(end), sMap.getOrDefault(s.charAt(end), 0) + 1);
                    break;
                }
            }

            if(end < s.length() && (end - start + 1 < minWindow)){
                queue.poll();
                queue.add(s.substring(start, end + 1));
                minWindow = Math.min(end - start + 1, minWindow);
            }
        }

        return  queue.poll();
    }


    /*
        code from other
     */
    public  String minWindow1(String s, String t){
        if (s == null | t == null)
            return "";

        //Set up array
        int[] dict = new int[128];
        for (char c : t.toCharArray())
            dict[c]++;

        //HashMap set up, set up pointers
        int start = 0;
        int end = 0;
        int count = t.length();
        int head = -1;
        int minLength = Integer.MAX_VALUE;

        while (end < s.length()) {
            //Subtract 1 from current char
            //if its still > 0 in map, decrement the counter
            if (dict[s.charAt(end++)]-- > 0)
                count--;

            while (count == 0) {
                if (dict[s.charAt(start++)]++ == 0)
                    count++;

                if (end - start + 1 < minLength) {
                    head = start - 1;
                    minLength = end - start + 1;
                }
            }
        }

        return head == -1 ? "" : s.substring(head, head + minLength);
    }





    @Test
    public  void  test(){
       /* String s = "ADOBECODEBANC";
        String t = "ABC";*/

      /* String s = "ab";
        String t = "b";*/

     /* String s = "abcabdebac";
        String t = "cda";*/

     /*String s = "adobecodebancbbcaa";
        String t = "abc";*/

     String s = "aabaabaaab";
        String t = "bb";

        long startTime = System.currentTimeMillis();
        String result = minWindow(s,t);
        long endTime = System.currentTimeMillis();

        System.out.println("result : "  + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
