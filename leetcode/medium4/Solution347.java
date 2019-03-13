package algorithm.medium4;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/9/23.
 */
public class Solution347 {
    public  class  Element{
        int element;
        int frequent;
        Element(int _element, int _frequent){
            element = _element;
            frequent = _frequent;
        }
    }


    //Accepted ------ 14ms
    public List<Integer> topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;  i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        List<Element> list = new ArrayList<>();
        for(Integer key : map.keySet()){
            Element e = new Element(key, map.get(key));
            list.add(e);
        }

        PriorityQueue<Element> priorityQueue = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.frequent > o2.frequent){
                    return  -1;
                }else  if(o1.frequent < o2.frequent){
                    return  1;
                }else {
                    return 0;
                }
            }
        });

        for(int i = 0; i < list.size(); i++){
            priorityQueue.add(list.get(i));
        }

       List<Integer> result = new ArrayList<>();
        int count = k, index = 0;
       while (count > 0){
           Element e = priorityQueue.poll();
           result.add(e.element);
           count--;
       }

       return  result;
    }


    @Test
    public  void  test(){
        int[] nums = {1};
        int K = 1;
        List<Integer> result = topKFrequent(nums,K);

        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "   ");
        }
    }
}
