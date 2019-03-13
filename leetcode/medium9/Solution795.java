package algorithm.medium9;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;

/**
 * Created by youlu on 2018/11/15.
 */
public class Solution795 {
    public  int help(int[] A, int L, int R){
        int count = 0;
        int index = 0;
        while (index < A.length){
            if(A[index] > R || A[index] < L){
                index++;
            }
           /* else if(A[index] < L){
                    int temp = index + 1;
                    while ((temp < A.length) && A[temp] < L){
                        temp++;
                    }
                    if((temp < A.length)&& (A[temp] >= L && A[temp] <= R)){
                        count += (temp - index );
                    }
                    index = temp;
            }*/
            else {
                int temp = index+1;
                int validIndex = index+1;
                while ((temp < A.length) && A[temp] <= A[temp-1]){
                    if(A[temp] >= L){
                        validIndex++;
                    }
                    temp++;
                }

                int validNumber = validIndex - index;
                int invalidNumber = temp - validIndex;
                count += validNumber * (validNumber + 1) / 2;
                count += validNumber * invalidNumber;
                index = temp;
            }
        }

        return  count;
    }

    //Wrong Solution
    public int numSubarrayBoundedMax(int[] A, int L, int R){
        int[] arr = new int[A.length];
        int index = 0;
        int sum = 0;
        for(int i = A.length - 1; i >= 0; i--){
            arr[index++] = A[i];
            if(A[i] >= L && A[i] <= R){
                sum++;
            }
        }

        return  help(A,L, R) + help(arr, L, R) - sum;
    }


    //Accepted ------28ms
    /*
        time complexity O(n)
     */
    public int numSubarrayBoundedMax1(int[] A, int L, int R){
        Queue<Integer> queue = new ArrayDeque<>();
        int index = 0;
        int sum = 0;
        while (index < A.length){
            if(A[index] > R){
                index++;
                continue;
            }

            int temp = index;
            while ((temp < A.length) && (A[temp] <=R)){
                queue.add(A[temp]);
                temp++;
            }

            while (!queue.isEmpty()){
                int total = 0;
                while (!queue.isEmpty() && queue.peek() < L){
                    queue.poll();
                    total++;
                }

                sum += (total + 1) * queue.size();
                queue.poll();
            }

            index = temp;
        }
        return  sum;
    }

    @Test
    public  void  test(){
        int[] A = {2,1,4,3};
        int L = 2;
        int R = 3;

      /*int[] A = {2,9,2,5,6};
        int L = 2;
        int R = 8;*/

       /* int[] A = {73,55,36,5,55,14,9,7,72,52};
        int L = 32;
        int R = 69;*/

        long startTime = System.currentTimeMillis();
        int result  = numSubarrayBoundedMax1(A, L, R);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
