package algorithm.medium9;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/11/7.
 */
public class Solution740 {
    public class Element{
        int value;
        int frequent;
        Element(int _value, int _frequent){
            value = _value;
            frequent  = _frequent;
        }
    }


    //Wrong solution
    /*
        try greedy algorithm failed
     */
    public  int deleteAndEarn(int[] nums){
        Arrays.sort(nums);
        PriorityQueue<Element> priorityQueue = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.frequent > o2.frequent){
                    return -1;
                }else if(o1.frequent < o2.frequent){
                    return 1;
                }else {
                    if(o1.value > o2.value){
                        return  -1;
                    }else if(o1.value < o2.value){
                        return 1;
                    }else {
                        return 0;
                    }
                }
            }
        });

        int index = 0;
        while (index < nums.length){
            int temp = index;
            while ((temp < nums.length) && (nums[temp] == nums[index])){
                temp++;
            }
            Element e = new Element(nums[index], temp - index);
            priorityQueue.add(e);
            index = temp;
        }

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while (!priorityQueue.isEmpty()){
            Element element = priorityQueue.poll();
            if(!set.contains(element.value)){
                sum += element.frequent * element.value;
                set.add(element.value);
                set.add(element.value - 1);
                set.add(element.value + 1);
            }
        }

        return  sum;
    }

    //Accepted ----11ms
    /*
        dp algorithm
        it can not be sorted
     */
    public  int deleteAndEarn1(int[] nums){
        if(nums.length == 0){
            return  0;
        }
        Arrays.sort(nums);
        List<Element> list = new ArrayList<>();
        int index = 0;
        while (index < nums.length){
            int temp = index;
            while ((temp < nums.length) && (nums[temp] == nums[index])){
                temp++;
            }
            Element e = new Element(nums[index], temp - index);
            list.add(e);
            index = temp;
        }

        if(list.size() == 1){
            return  list.get(0).value * list.get(0).frequent;
        }

        if(list.size() == 2){
            if(list.get(1).value == list.get(0).value + 1) {
                Math.max(list.get(0).value * list.get(0).frequent,
                        list.get(1).value * list.get(1).frequent);
            }else {
                return list.get(0).value * list.get(0).frequent +
                list.get(1).value * list.get(1).frequent;
            }
        }

        int[] choose = new int[list.size()];
        int[] deleted = new int[list.size()];
        choose[0] = list.get(0).value * list.get(0).frequent;
        deleted[0] = 0;

        if(list.get(1).value == list.get(0).value +1) {
            choose[1] = list.get(1).value * list.get(1).frequent;
            deleted[1] = choose[0];
        }else {
            choose[1] = list.get(1).value * list.get(1).frequent + list.get(0).value * list.get(0).frequent;
            deleted[1] = Math.max(choose[0], deleted[0]);
        }

        for(int i = 2; i < list.size(); i++){
            if(list.get(i).value == list.get(i-1).value +1) {
                choose[i] = list.get(i).value * list.get(i).frequent + Math.max(choose[i - 2], deleted[i - 2]);
                deleted[i] = choose[i - 1];
            }else {
                choose[i] = Math.max(choose[i-1], deleted[i-1]) + list.get(i).value * list.get(i).frequent;
                deleted[i] = Math.max(choose[i-1], deleted[i-1]);
            }
        }

        return Math.max(choose[list.size()-1], deleted[list.size() - 1]);
    }

    @Test
    public  void  test(){
//        int[] nums = {3,4,2};
//        int[] nums = {2,2,3,3,3,4};
//        int[] nums = {8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4};
        int[] nums = {1,6,3,3,8,4,8,10,1,3};

        long startTime = System.currentTimeMillis();
        int result = deleteAndEarn1(nums);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
