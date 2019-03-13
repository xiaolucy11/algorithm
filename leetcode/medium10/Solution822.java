package algorithm.medium10;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youlu on 2018/11/27.
 */
public class Solution822 {
    public  int swap(Map<Integer, List<Integer>> map, int[] fronts,
                      int[] backs,int index){
        List<Integer> list = map.get(fronts[index]);
        if(list.size() == 1){
            return fronts[list.get(0)];
        }

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != index){
                if(fronts[list.get(i)] == backs[list.get(i)]){
                    return 0;
                }
            }
        }

        return fronts[index];
    }

    public  int notSwap(Map<Integer, List<Integer>> map, int[] fronts, int[] backs,int index){
        if(!map.containsKey(backs[index])){
            return  backs[index];
        }
        List<Integer> list = map.get(backs[index]);
        for(int i = 0; i < list.size(); i++){
            if(fronts[list.get(i)] == backs[list.get(i)]){
                return 0;
            }
        }

        return backs[index];
    }



    //Accepted -----19ms
    /*
        code is not clean
     */
    public int flipgame(int[] fronts,int[] backs){
        Map<Integer,List<Integer>>  map = new HashMap<>();
        for(int i = 0; i < fronts.length; i++){
            if(map.containsKey(fronts[i])){
                List<Integer> l1 = map.get(fronts[i]);
                l1.add(i);
                map.put(fronts[i],l1);
            }else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(fronts[i],temp);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < backs.length; i++){
            if(backs[i] != fronts[i]){
                int val1 = swap(map,fronts,backs,i);
                if(val1 != 0 && val1 < min){
                    min = val1;
                }

                int val2 = notSwap(map,fronts,backs,i);
                if(val2 != 0){
                    min = Math.min(min, val2);
                }

            }
        }

        if(min == Integer.MAX_VALUE){
            return 0;
        }else {
            return min;
        }
    }



    @Test
    public  void  test(){
        int[] fronts = {1,2,4,4,7};
        int[] backs = {1,3,4,1,3};

        long startTime = System.currentTimeMillis();
        int result = flipgame(fronts, backs);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
