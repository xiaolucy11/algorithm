package algorithm.medium7;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/10/23.
 */
public class Solution621 {
    public  class  Element{
        int count;
        char ch;
        Element(int _count, char _ch){
            count = _count;
            ch = _ch;
        }
    }


    //Accepted-----43ms
    /*
        greedy algorithm
     */
    public  int leastInterval(char[] tasks, int n){
        Arrays.sort(tasks);
        int index = 0;
        List<Element> list = new ArrayList<>();
        int maxCount = 0;
        while (index < tasks.length){
            int temp = index + 1;
            while ((temp < tasks.length) && ( tasks[temp] == tasks[index])){
                temp++;
            }
            Element e = new Element(temp - index, tasks[index]);
            if(temp - index > maxCount){
                maxCount = temp - index;
            }
            list.add(e);
            index = temp;
        }

        Comparator<Element> comparator = new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.count < o2.count){
                    return 1;
                }else if(o1.count > o2.count){
                    return -1;
                }else {
                    return  o1.ch - o2.ch;
                }
            }
        };

        Collections.sort(list, comparator);
        int totalInterval = 0;
        while (true){
            if(list.get(0).count == 0){
                break;
            }
                int i = 0;
                while (i <= n) {
                    if ((i < list.size()) && (list.get(i).count != 0)) {
                        list.get(i).count--;
                        i++;
                        totalInterval++;
                    }else {
                        break;
                    }
                }
                Collections.sort(list, comparator);
            if(list.get(0).count != 0){
                totalInterval += (n - i+1);
            }

           /* else {
                int i = 0;
                while (i < list.size()){
                    if(list.get(i).count != 0){
                        totalInterval++;
                        i++;
                    }else {
                        break;
                    }
                }
                break;
            }*/
        }
        return  totalInterval;
    }

    /*
        code from other
     */
    public int leastInterval1(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }

    @Test
    public void  test(){
        char[] tasks = {'A','A','A','B','B','B'};
        int n  = 0;

        long startTime = System.currentTimeMillis();
        int result = leastInterval(tasks, n);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
