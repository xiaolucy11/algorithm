package algorithm.medium5;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/5.
 */
public class Solution436 {
    public  class  Interval{
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

    //Accepted ----513ms
    /*
        brute solution
        time complexity O(n^2)
     */
    public  int[] findRightInterval(Interval[] intervals){
        int length = intervals.length;
        int[] array = new int[length];
        for(int i = 0; i < length; i++){
           int index = 0;
            int startPoint = Integer.MAX_VALUE;
            int targetIndex = -1;
            while (index < length){
                if(index == i){
                    index++;
                }else {
                    if(intervals[index].start >= intervals[i].end){
                        if(intervals[index].start < startPoint){
                            startPoint = intervals[index].start;
                            targetIndex = index;
                        }
                    }
                        index++;

                }
            }
            array[i] = targetIndex;
        }
        return  array;
    }

    @Test
    public  void  test(){
        Interval o1 = new Interval(3,4);
        Interval o2 = new Interval(2,3);
        Interval o3 = new Interval(1,2);
        Interval[] intervals = new Interval[3];
        intervals[0] = o1;
        intervals[1] = o2;
        intervals[2] = o3;

        int[] result = findRightInterval(intervals);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }

}
