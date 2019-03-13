package algorithm.medium6;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/13.
 */
public class Solution495 {
    //Accepted ------4ms
    public  int findPoisonedDuration(int[] timeSeries, int duration){
        if(timeSeries.length == 0){
            return 0;
        }
        int endTimeOfPoison = 0;
        int totalDuralTime = 0;
        for(int i = 0; i < timeSeries.length-1; i++){
            endTimeOfPoison = timeSeries[i] + duration ;
            if(endTimeOfPoison <= timeSeries[i+1]){
                totalDuralTime += duration;
            }else {
                totalDuralTime += timeSeries[i+1]- timeSeries[i];
            }
        }
        totalDuralTime += duration;
        return  totalDuralTime;
    }

    @Test
    public  void  test(){
        int[] timeSeries = {1,4};
        int duration = 2;
        int result = findPoisonedDuration(timeSeries, duration);
        System.out.println("result : " + result);
    }
}
