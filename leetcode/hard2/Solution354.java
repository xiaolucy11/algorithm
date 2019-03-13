package algorithm.hard2;

import org.junit.Test;

import java.util.*;

public class Solution354 {
    public  class Retangle{
        int width;
        int height;
        Retangle(int _width, int _height){
            width = _width;
            height = _height;
        }
    }


    //Accepted --- 561ms
    /*
        time complexity O(n^2)
     */
    public  int maxEnvelopes(int[][] envelopes){
        if(envelopes.length == 0){
            return 0;
        }
        List<Retangle> list = new ArrayList<>();

        for(int i = 0; i < envelopes.length; i++){
            list.add(new Retangle(envelopes[i][0],envelopes[i][1]));
        }
        Collections.sort(list, new Comparator<Retangle>() {
            @Override
            public int compare(Retangle o1, Retangle o2) {
                if (o1.width > o2.width){
                    return 1;
                }else if (o1.width < o2.width){
                    return -1;
                }else {
                    if(o1.height > o2.height){
                        return 1;
                    }else if (o1.height < o2.height){
                        return -1;
                    }else {
                        return 0;
                    }
                }
            }
        });

       int[] arr = new int[list.size()];
       int maxValue = 0;


       for(int i = 0; i < list.size();i++){
           int curMax = 0;
           for(int j = i-1; j >=0; j--){
               if(list.get(j).width < list.get(i).width && list.get(j).height < list.get(i).height){
                   curMax = Math.max(curMax,arr[j]);
               }

           }
           arr[i] = curMax + 1;
           maxValue = Math.max(arr[i],maxValue);
       }
       return maxValue;
    }

    public  int maxEnvelopes1(int[][] envelopes){
        if(envelopes.length == 0){
            return 0;
        }
        List<Retangle> list = new ArrayList<>();
        Retangle[] retangles = new Retangle[envelopes.length];
        for(int i = 0; i < envelopes.length; i++){
            retangles[i] = new Retangle(envelopes[i][0],envelopes[i][1]);
        }
        Arrays.sort(retangles, new Comparator<Retangle>() {
            @Override
            public int compare(Retangle o1, Retangle o2) {
                if (o1.width > o2.width){
                    return 1;
                }else if (o1.width < o2.width){
                    return -1;
                }else {
                    if(o1.height > o2.height){
                        return 1;
                    }else if (o1.height < o2.height){
                        return -1;
                    }else {
                        return 0;
                    }
                }
            }
        });

        int[] arr = new int[list.size()];
        int len = 0;
        for(int i = 0; i < retangles.length; i++){
            int index= Arrays.binarySearch(arr,0,len,retangles[i].height);
            if(index < 0){
                index = -1 * (index + 1);
            }
            arr[index] = retangles[i].height;
            if(index == len){
                len++;
            }
        }
        return  len;
    }


    @Test
    public  void  test(){
//        int[][] envelope = {{5,4},{6,4},{6,7},{2,3},{1,1}};
//       int[][] envelope = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
 //       int[][] envelope = {{46,89},{50,53},{52,68},{72,45},{77,81}};
        int[][] envelope = {{4,5},{4,6},{6,7},{2,3},{1,1}};
        long startTime = System.currentTimeMillis();
        int result = maxEnvelopes1(envelope);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
