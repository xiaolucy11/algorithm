package algorithm.hard3;

import org.junit.Test;

import java.util.*;

public class Solution502 {
    public  class MyQueue{
        PriorityQueue<Integer> p;
        MyQueue(){
            p = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -1 * (o1 - o2);
                }
            });
        }
    }
    public PriorityQueue<Integer> storeMax(int[] Captital){
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  -1 * (o1 - o2);
            }
        });
        for (int i = 0; i < Captital.length; i++){
            if(!set.contains(Captital[i])){
                set.add(Captital[i]);
                priorityQueue.add(Captital[i]);
            }
        }

        return  priorityQueue;
    }

    public  int getProfit(Map<Integer,MyQueue> map,PriorityQueue<Integer> maxPriority,
                          int curSum){
        int maxCapital = maxPriority.peek();
        if(curSum >= maxCapital){
            MyQueue queue = map.get(maxCapital);
            curSum += queue.p.poll();
            if(queue.p.isEmpty()){
                map.remove(maxCapital);
                maxPriority.poll();
            }else {
                map.put(maxCapital,queue);
            }
            return  curSum;
        }else {
            int value = curSum;
            while (value >= 0){
                if(!map.containsKey(value)){
                    value--;
                }else {
                    break;
                }
            }
            MyQueue queue = map.get(value);
            curSum += queue.p.poll();
            if(queue.p.isEmpty()){
                map.remove(value);
            }else {
                map.put(value,queue);
            }
            return curSum;
        }
    }

    public int findMaximizedCapital(int k, int W,int[] Profits, int[] Capital){
        Map<Integer, MyQueue> map = new HashMap<>();
        PriorityQueue<Integer> maxPriority = storeMax(Capital);
        int minCapital = Integer.MAX_VALUE;
        for(int i = 0; i < Capital.length; i++){
            if(!map.containsKey(Capital[i])){
                MyQueue q1 = new MyQueue();
                q1.p.add(Profits[i]);
                map.put(Capital[i], q1);
            }else {
                MyQueue q2 = map.get(Capital[i]);
                q2.p.add(Profits[i]);
            }
            minCapital = Math.min(minCapital,Capital[i]);
        }

        if (W < minCapital){
            return 0;
        }
        int count = k;
        int curSum = W;
        while (count > 0){
            curSum = getProfit(map,maxPriority,curSum);
            if(map.keySet().size() == 0){
                break;
            }
            count--;
        }

        return  curSum;
    }

    public  class  Element{
        int profit;
        int capital;
        int index;
        Element(int _profit, int _capital, int _index){
            profit = _profit;
            capital = _capital;
            index = _index;
        }
    }

    public  int help(PriorityQueue<Element> minPriority, PriorityQueue<Element> maxPriority, int curSum){
        if(minPriority.isEmpty()){
            Element e1 = maxPriority.poll();
            curSum += e1.profit;
        }else {
            int maxValue = 0;
            int maxIndex = -1;
            List<Element> list = new ArrayList<>();
            while (!minPriority.isEmpty()){
                Element temp = minPriority.peek();
                if(temp.capital <= curSum){
                    Element e2 = minPriority.poll();
                    list.add(e2);
                    if(e2.profit > maxValue){
                        maxValue = e2.profit;
                        maxIndex = list.size() - 1;
                    }
                }else {
                    break;
                }
            }
            if(!maxPriority.isEmpty()){
                Element maxElement = maxPriority.peek();
                if(maxElement.profit > maxValue){
                    maxValue = maxElement.profit;
                    maxIndex = -1;
                    maxPriority.poll();
                }
            }
            for(int i = 0; i < list.size(); i++){
                if(i != maxIndex){
                    maxPriority.add(list.get(i));
                }
            }
            curSum += maxValue;
        }
        return  curSum;
    }

    //Accepted ----34ms
    /*
        using max priority and min priority
     */
    public int findMaximizedCapital1(int k, int W,int[] Profits, int[] Capital){
        PriorityQueue<Element> minPriority = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.capital == o2.capital){
                    if(o1.profit ==  o2.profit){
                        return  o1.index  - o2.index;
                    }else {
                        return  o1.profit - o2.profit;
                    }
                }else {
                    return  o1.capital - o2.capital;
                }
            }
        });

        PriorityQueue<Element> maxPriority = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.profit == o2.profit){
                     if(o1.capital == o2.capital){
                         return  o1.index - o2.index;
                     }else {
                         return  o1.capital - o2.capital;
                     }
                }else {
                    return -1 * (o1.profit - o2.profit);
                }
            }
        });

        for(int i = 0; i < Capital.length; i++){
            minPriority.add(new Element(Profits[i],Capital[i],i));
        }
        int count = k;
        int curSum = W;

        while (count > 0){
            curSum = help(minPriority,maxPriority,curSum);
            count--;
            if(minPriority.isEmpty() && maxPriority.isEmpty()){
                break;
            }
        }
        return curSum;
    }


    @Test
    public  void  test(){
        /*int k = 2;
        int W = 0;
        int[] Profits = {1,2,3};
        int[] Capital = {0,1,1};*/

        int k = 74;
        int W = 8;
        int[] Profits = {75,486,155,104,72,136,174,194,368,121,258,445,160,383,73,18,437,
                308,509,482,227,469,104,416,257,97,88,82,181,169,463,56,182,249,467,140,328,
                291,115,339,511,73,53,373,220,261,236,296,284,431,178,94,520,196,150,172,26,
                487,96,285,433,404,204,130,313,374,89,140,401,261,76,370,126,230,73,509,377,
                446,480,504,61,82,504,85,241,17,84,412,18,174,469,10,449,114,215,340,414,82,401,61};
        int[] Capital = {249,266,110,94,292,45,290,430,273,481,142,81,52,20,323,0,245,390,455,477,
                170,244,34,446,264,287,341,24,204,59,199,468,74,387,470,9,137,127,51,359,83,379,82,
                19,157,325,17,165,304,376,202,144,282,0,379,304,510,370,507,195,127,422,127,186,494,
                429,303,132,33,250,153,310,216,29,307,0,38,67,471,
                337,521,118,314,355,312,247,142,50,372,499,243,519,460,6,233,444,116,330,426,78};
        long startTime = System.currentTimeMillis();
        int result = findMaximizedCapital1(k,W,Profits,Capital);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
