package algorithm.medium6;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/10/7.
 */
public class Solution454 {
    //Accepted -----118ms
    public  int fourSumCount(int[] A, int[] B, int[] C, int[] D){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int value = A[i] + B[j];
                list.add(value);
            }
        }

        for(int m = 0; m < C.length; m++){
            for(int n = 0; n < D.length; n++){
                int value = C[m] + D[n];
                map.put(value, map.getOrDefault(value,0) + 1);
            }
        }

        int count = 0;
        for(int i = 0; i < list.size(); i++){
            if(map.containsKey(-1 * list.get(i))){
                count += map.get(-1 * list.get(i));
            }
        }
        return  count;
    }

    @Test
    public  void  test(){
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = {0,2};

       /* int[] A = {-1,-1};
        int[] B = {-1,1};
        int[] C = {-1,1};
        int[] D = {1,-1};*/

        long startTime = System.currentTimeMillis();
        int result = fourSumCount(A, B, C, D);
        long endTime = System.currentTimeMillis();
        System.out.println("result :  " + result);
        System.out.println("runnint time : " + (endTime - startTime));

    }
}
