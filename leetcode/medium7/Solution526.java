package algorithm.medium7;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by youlu on 2018/10/17.
 */
public class Solution526 {
    public  int count;


    public void  search(int[] arr, int index,int N){
        if(index > N ){
            count++;
            return;
        }

        for(int i = 1; i < arr.length; i++){
            if(arr[i] == 0 && (i % index == 0 || index % i == 0)){
                arr[i] = 1;
                search(arr, index+1, N);
                arr[i] = 0;
            }
        }
    }


    //Accepted ---69ms
    public  int countArrangement(int N){
        count = 0;
        int[] arr = new int[N+1];
        search(arr,1,N);

        return  count;
    }


    @Test
    public  void  test(){
        int N = 3;
        long startTime = System.currentTimeMillis();
        int result = countArrangement(N);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
