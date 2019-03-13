package algorithm.medium8;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * Created by youlu on 2018/10/26.
 */
public class Solution649 {
    //Accepted -----100ms
    /*
        it can be optimized
        not using two loop, in inner loop, replaced with deletedRadianIndex and deletedDirdIndex
       the running time will be O(N);

       or using LinkedQueue
     */
    public  String predictPartyVictory(String senate){
        int[] arr = new int[senate.length()];
        int totalRadiant = 0, totalDire = 0;

        for(int i = 0; i < senate.length(); i++){
            if(senate.charAt(i) == 'R'){
                totalRadiant++;
            }else {
                totalDire++;
            }
        }

        for(int i = 0; i < senate.length(); i++){
            if(arr[i] == 0){
                if(senate.charAt(i) == 'R'){
                    int index = i+1;
                    int flag = 0;
                    while (index < senate.length()){
                        if((senate.charAt(index) == 'R') ||
                                arr[index] == 1){
                            index++;
                        }else {
                            flag = 1;
                            arr[index] = 1;
                            totalDire--;
                            break;
                        }
                    }
                    if(flag == 0){
                        index = 0;
                        while (index < i){
                            if((senate.charAt(index) == 'R') ||
                                    arr[index] == 1){
                                index++;
                            }else {
                                arr[index] = 1;
                                totalDire--;
                                break;
                            }
                        }
                    }
                }else {
                    int index = i+1;
                    int flag = 0;
                    while (index < senate.length()){
                        if((senate.charAt(index) == 'D') ||
                                arr[index] == 1){
                            index++;
                        }else {
                            flag = 1;
                            arr[index] = 1;
                            totalRadiant--;
                            break;
                        }
                    }
                    if(flag == 0){
                        index = 0;
                        while (index < i){
                            if((senate.charAt(index) == 'D') ||
                                    arr[index] == 1){
                                index++;
                            }else {
                                arr[index] = 1;
                                totalRadiant--;
                                break;
                            }
                        }
                    }
                }
            }
        }

        if(totalDire == 0){
            return "Radiant";
        }else if(totalRadiant == 0){
            return  "Dire";
        }else {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < senate.length(); i++){
                if(arr[i] == 0){
                    stringBuilder.append(senate.charAt(i));
                }
            }
            return  predictPartyVictory(stringBuilder.toString());
        }

    }

    @Test
    public  void  test(){
        String senate = "RD";
//        String senate = "DRRDRDRDRDDRDRDR";

        long startTime = System.currentTimeMillis();
        String result = predictPartyVictory(senate);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
