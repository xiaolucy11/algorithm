package algorithm.medium5;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by youlu on 2018/10/5.
 */
public class Solution435 {
    public  class Interval{
        int start;
        int end;
        Interval(){
            start = 0;
            end = 0;
        }
        Interval(int s, int e){
            start = s;
            end = e;
        }
    }

    //Wrong Solution
    public  int eraseOverlapIntervals(Interval[] intervals){
        if(intervals.length == 0){
            return  0;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int minDeleteIntervals = 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start < o2.start){
                    return -1;
                }else if(o1.start > o2.start){
                    return 1;
                }else {
                    if(o1.end < o2.end){
                        return  -1;
                    }else if(o1.end > o2.end){
                        return  1;
                    }else {
                        return 0;
                    }
                }
            }
        });

        priorityQueue.add(intervals[0].end);
        for(int i = 1; i < intervals.length; i++){
            while (!priorityQueue.isEmpty()){
                int endPoint = priorityQueue.peek();
                if(endPoint <= intervals[i].start){
                    int temp = priorityQueue.poll();
                }else {
                    break;
                }
            }
            int overlapNumber = priorityQueue.size();
            if(overlapNumber > minDeleteIntervals){
                minDeleteIntervals = overlapNumber;
            }
            priorityQueue.add(intervals[i].end);
        }

        return  minDeleteIntervals;
    }

    public  int longestPath(Interval[] intervals, Interval startPoint, int index){
        if(index ==intervals.length - 1){
            return 1;
        }

        for(int i = index + 1; i < intervals.length ; i++){
            if(intervals[i].start >= startPoint.end){
                int value = longestPath(intervals, intervals[i], i);
                return  value + 1;
            }
        }

        return  1;
    }


    //Wrong Solution
    public  int eraseOverlapIntervals1(Interval[] intervals){
        int longestIntervals = 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start < o2.start){
                    return -1;
                }else if(o1.start > o2.start){
                    return 1;
                }else {
                    if(o1.end < o2.end){
                        return  -1;
                    }else if(o1.end > o2.end){
                        return  1;
                    }else {
                        return 0;
                    }
                }
            }
        });
        for(int i = 0; i < intervals.length; i++){
            if(intervals.length - i > longestIntervals){
                int value = longestPath(intervals, intervals[i],i);
                if(value > longestIntervals){
                    longestIntervals = value;
                }
            }
        }
        return  intervals.length - longestIntervals;
    }

    //Accepted -----3ms
    /*
        dp algorithm
        time complexity O(n^2)
     */
    public  int eraseOverlapIntervals2(Interval[] intervals){
        if(intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start < o2.start){
                    return -1;
                }else if(o1.start > o2.start){
                    return 1;
                }else {
                    if(o1.end < o2.end){
                        return  -1;
                    }else if(o1.end > o2.end){
                        return  1;
                    }else {
                        return 0;
                    }
                }
            }
        });
        int maxLongestPath = 0;
        int[] array = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            int index = i -1;
            while (index >= 0){
                if(intervals[index].end <= intervals[i].start){
                    break;
                }else {
                    index--;
                }
            }
            if(index == -1){
                array[i] = 1;
            }else {
                array[i] = array[index] + 1;
            }
            if(array[i] > maxLongestPath){
                maxLongestPath = array[i];
            }
        }

        return  intervals.length - maxLongestPath;
    }

    @Test
    public  void  test(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(10);
        priorityQueue.add(10);

        while (!priorityQueue.isEmpty()){
            int value = priorityQueue.poll();
            System.out.print(value + "  ");
        }
    }

    @Test
    public  void  test1(){
        Interval o1 = new Interval(1,2);
        Interval o2 = new Interval(2,3);
        Interval o3 = new Interval(3,4);
        Interval o4 = new Interval(1,3);
        Interval[] intervals = new Interval[4];
        intervals[0] = o1;
        intervals[1] = o2;
        intervals[2] = o3;
        intervals[3] = o4;

       /*Interval o1 = new Interval(0,4);
        Interval o2 = new Interval(1,3);
        Interval o3 = new Interval(2,6);
        Interval[] intervals = new Interval[3];
        intervals[0] = o1;
        intervals[1] = o2;
        intervals[2] = o3;*/

      /* Interval o1 = new Interval(0,2);
        Interval o2 = new Interval(1,3);
        Interval o3 = new Interval(2,4);
        Interval o4 = new Interval(3,5);
        Interval o5 = new Interval(4,6);
        Interval[] intervals = new Interval[5];
        intervals[0] = o1;
        intervals[1] = o2;
        intervals[2] = o3;
        intervals[3] = o4;
        intervals[4] = o5;*/
     /* Interval o1 = new Interval(1,100);
        Interval o2 = new Interval(11,22);
        Interval o3 = new Interval(1,11);
        Interval o4 = new Interval(2,12);
        Interval[] intervals = new Interval[4];
        intervals[0] = o1;
        intervals[1] = o2;
        intervals[2] = o3;
        intervals[3] = o4;*/

        long startTime = System.currentTimeMillis();
        int result = eraseOverlapIntervals2(intervals);
        long endTime = System.currentTimeMillis();
        System.out.println("result :  " + result);
        System.out.println("runnint time :  " + (endTime - startTime));
    }
}
