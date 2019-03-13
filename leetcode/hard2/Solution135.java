package algorithm.hard2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by youlu on 2018/12/21.
 */
public class Solution135 {

    /*
        dp algorithm
        time complexity O(nlog(n))
     */
    public  int candy(int[] ratings){
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for(int i = 0; i < ratings.length; i++){
            if(!map.containsKey(ratings[i])){
                List<Integer> temp1 = new ArrayList<>();
                temp1.add(i);
                map.put(ratings[i], temp1);
            }else {
                List<Integer> temp2 = map.get(ratings[i]);
                temp2.add(i);
                map.put(ratings[i], temp2);
            }
        }

        int[] arr = new int[ratings.length];
        for(Integer key: map.keySet()){
            for(int i = 0; i < map.get(key).size(); i++){
                int leftValue = 0;
                int rightValue = 0;
                int index = map.get(key).get(i);
                if(index - 1 >= 0){
                    leftValue = ratings[index] > ratings[index - 1] ? arr[index-1] + 1 : Integer.MAX_VALUE;
                }else {
                    leftValue = Integer.MAX_VALUE;
                }

                if(index + 1 < ratings.length){
                    rightValue = ratings[index] > ratings[index+1] ? arr[index+1] + 1: Integer.MAX_VALUE;
                }else {
                    rightValue = Integer.MAX_VALUE;
                }
                if(leftValue == Integer.MAX_VALUE && rightValue == Integer.MAX_VALUE){
                    arr[index] = 1;
                }else if(leftValue != Integer.MAX_VALUE && rightValue != Integer.MAX_VALUE){
                    arr[index] = Math.max(leftValue, rightValue);
                }else {
                    arr[index] = Math.min(leftValue, rightValue);
                }
            }
        }

        int totalCount = 0;
        for(int i = 0; i < ratings.length; i++){
            totalCount += arr[i];
        }

        return  totalCount;
    }



    @Test
    public  void  test(){
        int[] ratings = {1,0,2};
//        int[] ratings = {1,2,2};
 //       int[] ratings = {1,3,2,2,1};
//        int[] ratings = {1,3,4,5,2};

        long startTime = System.currentTimeMillis();
        int result = candy(ratings);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
