package algorithm.medium9;

import org.junit.Test;

/**
 * Created by youlu on 2018/11/10.
 */
public class Solution775 {

    //Accepted ---12ms
    /*
        time complextity O(n)
     */
    public  boolean isIdealPermutation(int[] A){
        if(A.length == 1){
            return  true;
        }

        int max = A[0];
        for(int i = 2; i < A.length;i++){
            if(A[i] <  max){
                return  false;
            }
            max = Math.max(max, A[i-1]);
        }

        return  true;
    }

    @Test
    public  void  test(){
//        int[] A = {1,0,2};
//        int[] A = {1,2,0};
        int[] A = {0,2,1};

        long startTime = System.currentTimeMillis();
        boolean b = isIdealPermutation(A);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + b);
        System.out.println("running time : " + (endTime - startTime));
    }

}
