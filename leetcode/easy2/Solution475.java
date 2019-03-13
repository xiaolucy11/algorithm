package interview.easy2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Created by Administrator on 2018/7/11 0011.
 */
public class Solution475 {

    // wrong solution
    /*public  int findRadius(int[] houses, int[] heaters){
        if(heaters.length == 1){
            return  Math.max(houses[houses.length-1] - heaters[0], heaters[0] - houses[0]);
        }
        int hoursesLength = houses.length;
        int heatersLength = heaters.length;
        int houseIndex = 0, heaterIndex = 0;
        int maxDistance = Integer.MIN_VALUE;
        while (houseIndex < hoursesLength){
            if(houses[houseIndex] != heaters[heaterIndex+1]){
                if(Math.abs(houses[houseIndex] - heaters[heaterIndex]) > maxDistance){
                    maxDistance = Math.abs(houses[houseIndex] - heaters[heaterIndex]);
                }
            }else {
                heaterIndex++;
            }
            houseIndex++;
        }
        return  maxDistance;
    }*/

    //wrong solution
   /* public  int findRadius1(int[] houses, int[] heaters){
        if(heaters.length == 1){
            return  Math.max(houses[houses.length-1] - heaters[0], heaters[0] - houses[0]);
        }
        int hoursesLength = houses.length;
        int heatersLength = heaters.length;
        int houseIndex = 0, heaterIndex = 0;
        int maxDistance = Math.max(Math.abs(houses[0] - heaters[0]), Math.abs(houses[hoursesLength]-heaters[heaterIndex]));
        int flagIndex = -1;
        int count = 0;
        int diff = 0;
        while (houses[houseIndex] != heaters[0]){
            houseIndex++;
        }
        flagIndex = houseIndex;
        while ((houseIndex < hoursesLength) && (heaterIndex + 1 < heatersLength)){
            if(houses[houseIndex] > heaters[heaterIndex] && houses[houseIndex] < heaters[heaterIndex + 1]){
                count++;
            }
            if(houses[houseIndex] == heaters[heaterIndex + 1]){
                if(count % 2 == 0){
                     diff = houses[flagIndex + count] - houses[flagIndex];
                }else {
                    diff = houses[flagIndex + count + 1] - houses[flagIndex];
                }
                if(diff > maxDistance){
                    maxDistance = diff;
                }
            }
        }
        return  0;
    }*/


    public List<Integer> heatersToIndex(int[] hourses, int[] heaters){
        List<Integer> list = new ArrayList<>();
        int index1 = 0, index2 = 0;
        while ((index1 < hourses.length) && (index2 < heaters.length)){
            if(hourses[index1] == heaters[index2]){
                list.add(index1);
                index1++;
                index2++;
            }else if(hourses[index1] < heaters[index2]){
                index1++;
            }else {
                index2++;
            }
        }
        return  list;
    }
    public int  minRadius(int[] hourse, int start, int end){
        int minValue = 0;
        int minRadius = 0;
        for(int i = start; i < end; i++){
            if(hourse[i] - hourse[start] < hourse[end] - hourse[i]){
                 minRadius = hourse[i] - hourse[start];
            }else {
                minRadius = hourse[end] - hourse[i];
            }
            if(minRadius > minValue){
                minValue = minRadius;
            }
        }
        return  minValue;

    }
    public  int findRadius(int[] houses, int[] heaters){
        if(heaters.length == 1){
            return Math.max(heaters[0] - houses[0], houses[houses.length - 1] - heaters[0]);
        }
        List<Integer> list = heatersToIndex(houses, heaters);
        int minValue = 0;
        for(int i = 0; i < list.size() - 1; i++){
            int value1 = minRadius(houses, list.get(i), list.get(i+1));
            if(value1 > minValue){
                minValue = value1;
            }
        }
        if(houses[list.get(0)] - houses[0] > minValue){
            minValue = list.get(0) - houses[0];
        }
        if(houses[houses.length - 1] - houses[list.get(list.size() - 1)] > minValue){
            minValue = houses[houses.length - 1] - houses[list.get(list.size() - 1)];
        }
        return  minValue;
    }
    //Accepted ------ 11ms
    public  int findRadius1(int[] houses, int[] heaters){
        if(heaters.length == 1){
            return Math.max(heaters[0] - houses[0], houses[houses.length - 1] - heaters[0]);
        }
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int index1 = 0, index2 = 0;
        int minRadius = 0;
        while((index1 < houses.length) && (index2 + 1 < heaters.length)){
            if(houses[index1] <= heaters[index2]){
                index1++;
            }else  if(houses[index1] < heaters[index2+1]){
                    int value1 = Math.min(houses[index1] - heaters[index2] , heaters[index2+1]  - houses[index1]);
                    if(value1 > minRadius){
                        minRadius = value1;
                    }
                    index1++;
            }else {
                index2++;
            }
        }
        if(heaters[0] - houses[0] > minRadius){
            minRadius = heaters[0] - houses[0];
        }
        if(houses[houses.length - 1] - heaters[heaters.length - 1] > minRadius){
            minRadius = houses[houses.length - 1] - heaters[heaters.length-1];
        }
        return  minRadius;
    }

    @Test
    public  void  test(){
        int[] hourses = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int[] heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};

        System.out.print(findRadius1(hourses, heaters));
    }
}
