package algorithm.medium7;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/10/22.
 */
public class Solution593 {
    public  int distance(int[] p1,int[] p2){
        return  (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1])*(p1[1] - p2[1]);
    }

    //Accepted ----12ms
    public  boolean validSquare(int[] p1, int[] p2,int[] p3, int[] p4){
        Set<Integer> set = new TreeSet<>();
        set.add(distance(p1,p2));
        set.add(distance(p1,p3));
        set.add(distance(p1,p4));
        set.add(distance(p2,p3));
        set.add(distance(p2,p4));
        set.add(distance(p3,p4));

        if(set.size() != 2){
            return  false;
        }

        List<Integer> list = new ArrayList<>();
        for(Integer value : set){
            list.add(value);
        }


        if(list.get(1) == 2 * list.get(0)){
            return true;
        }else {
            return  false;
        }
    }


    @Test
    public  void  test(){
      /* int[] p1 = {0,0};
        int[] p2 = {1,1};
        int[] p3 = {1,0};
        int[] p4 = {0,1};*/

        int[] p1 = {1134,-2539};
        int[] p2 = {492,-1255};
        int[] p3 = {-792,-1897};
        int[] p4 = {-150,-3181};

        long startTiem = System.currentTimeMillis();
        boolean b = validSquare(p1,p2,p3,p4);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + b);
        System.out.println("running time : " + (endTime - startTiem));
    }
}
