package algorithm.medium8;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/11/1.
 */
public class Solution692 {
    public  class  Element{
        String word;
        int frequent;
        Element(String str, int _frequent){
            word = str;
            frequent = _frequent;
        }
    }

    //Accepted ----17ms
    /*
        it can be optimized, using min heap, poll the top element
     */
    public List<String> topKFrequent(String[] words, int k){
        PriorityQueue<Element> priorityQueue = new PriorityQueue<>(k, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.frequent > o2.frequent){
                    return  -1;
                }else if(o1.frequent < o2.frequent){
                    return  1;
                }else {
                    return o1.word.compareTo(o2.word);
                }
            }
        });

        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        for (String key : map.keySet()){
            priorityQueue.add(new Element(key, map.get(key)));
        }
        List<String> result = new ArrayList<>();
        int top = k;
        while (top > 0){
            top--;
            result.add(priorityQueue.poll().word);
        }

        return  result;
    }


    @Test
    public  void  test(){
      /*  String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;*/
      String[] words = {"the", "day", "day","is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;

        long startTime = System.currentTimeMillis();
        List<String> result = topKFrequent(words,k);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }
}
