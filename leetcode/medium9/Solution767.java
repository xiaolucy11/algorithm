package algorithm.medium9;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/11/9.
 */
public class Solution767 {
    public List<String> list;

    public  void  search(int[] arr, int index ,String S,StringBuilder stringBuilder){
        if(list.size() > 0){
            return;
        }
        if(stringBuilder.length() == S.length()){
            list.add(stringBuilder.toString());
            return;
        }

        for(int i = 0; i < 26; i++){
            if(arr[i] != 0 && i != index){
                stringBuilder.append((char) ('a' + i));
                arr[i]--;
                search(arr,i,S,stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                arr[i]++;
            }
        }

    }

    //Time Limit Excced
    /*
        trackback failed
     */
    public  String reorganizeString(String S){
        list = new ArrayList<>();
        int[] arr = new int[26];

        for(int i = 0; i < S.length(); i++){
            int index = S.charAt(i) - 'a';
            arr[index]++;
        }

        for(int i = 0; i < 26;i++){
            if(arr[i] != 0 && list.size() == 0) {
                search(arr, i, S, new StringBuilder());
            }
        }

        if(list.size() == 1){
            return  list.get(0);
        }else {
            return  "";
        }
    }

    public  class  Element{
        char ch;
        int frequent;
        Element(char _ch, int _frequent){
            ch = _ch;
            frequent = _frequent;
        }
    }


    //Accepted ----14ms
    /*
        greedy algorithm
     */
    public  String reorganizeString1(String S){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i),0) + 1);
        }
        PriorityQueue<Element> priorityQueue = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.frequent > o2.frequent){
                    return  -1;
                }else if(o1.frequent < o2.frequent){
                    return  1;
                }else {
                    return  o1.ch - o2.ch;
                }
            }
        });

        for(Character ch : map.keySet()){
            Element e = new Element(ch, map.get(ch));
            priorityQueue.add(e);
        }

        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()){
            Element e1 = priorityQueue.poll();
            if(priorityQueue.isEmpty()){
                if(e1.frequent < 2){
                    return (sb.append(e1.ch)).toString();
                }else {
                    return "";
                }
            }else {
                Element e2 = priorityQueue.poll();
                int frequent = e2.frequent;
                while ( frequent > 0){
                    sb.append(e1.ch);
                    sb.append(e2.ch);
                    frequent--;
                    e1.frequent--;
                    e2.frequent--;
                }
                if(e1.frequent > 0) {
                    priorityQueue.add(e1);
                }
            }
        }
        return  sb.toString();
    }

    @Test
    public  void  test(){
        String S = "aab";
//        String S = "aaab";
//        String S = "eqpspvbpppwpgyppppe";

        long startTime = System.currentTimeMillis();
        String result = reorganizeString1(S);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
