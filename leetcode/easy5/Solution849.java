package interview.easy5;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/5 0005.
 */
public class Solution849 {
    public  int maxDistToClosest(int[] seats){
        int maxValue = - 1;
        int left = 0, right = 0;
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 0){
                left = i;
                while ((left >= 0) && (seats[left] == 0)){
                    left--;
                }
                if(left < 0){
                    left = -20001;
                }
                right = i;
                while ((right < seats.length) && (seats[right] == 0)){
                    right++;
                }
                if(right == seats.length){
                    right = 20001;
                }

                int value = Math.min(i - left, right - i);
                if(value > maxValue){
                    maxValue = value;
                }
            }
        }
        return  maxValue;
    }

    @Test
    public  void  test(){
        int[] seats = {1,0,0,0,1,0,1};
        System.out.print(maxDistToClosest(seats));
    }
}
