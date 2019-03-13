package algorithm.medium7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/10/18.
 */
public class Solution539 {


    //Accepted ----13ms
    public  int findMinDifference(List<String> timePoints){
        int[] arr = new int[1440];
        for(int i = 0; i < timePoints.size(); i++){
            String[] timesPartition = timePoints.get(i).split(":");
            int minutes = Integer.parseInt(timesPartition[1]);
            int hour = Integer.parseInt(timesPartition[0]);
            int value = hour * 60 + minutes;
            if(arr[value] != 0){
                return 0;
            }else {
                arr[value]++;
            }
        }

        int minMinutes = Integer.MAX_VALUE;
        int first = 0;
        while (first < 1440 && arr[first] == 0){
            first++;
        }
        int slow = first, quick = first + 1;
        while (quick < 1440){
            if(arr[quick] == 0){
                quick++;
            }else {
                if(quick - slow < minMinutes){
                    minMinutes = quick - slow;
                }
                slow = quick;
                quick++;
            }
        }

        int diffinHeadTail = first + (1440 - slow);
        return  Math.min(minMinutes, diffinHeadTail);
    }


    @Test
    public  void  test(){
      /*  List<String> timePoints  = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");*/
     List<String> timePoints = new ArrayList<>();
        timePoints.add("05:31");
        timePoints.add("22:08");
        timePoints.add("00:35");
        long startTime = System.currentTimeMillis();
        int result = findMinDifference(timePoints);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.print("running time : " + (endTime - startTime));
    }
}
