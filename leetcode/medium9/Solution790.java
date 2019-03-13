package algorithm.medium9;

import org.junit.Test;

import java.util.Map;

/**
 * Created by youlu on 2018/11/14.
 */
public class Solution790 {

    //Accepted ---3ms
    /*
        dp alogrithm
     */
    public  int numTilings(int N){

       if(N == 1){
               return  1;
           }else if(N == 2){
               return  2;
           }else if(N == 3){
               return 5;
           }else {
               long[] arr = new long[N+1];
               long mod = (long) Math.pow(10,9) + 7;
               arr[1] = 1;
               arr[2] = 2;
               arr[3] = 5;

               for(int i = 4; i < N+1; i++){
                   long value = arr[i-1] * 2 + arr[i-3];
                   if(value >= mod){
                       value %= mod;
                   }
                   arr[i] = value;
               }
               return (int)arr[N];
       }
    }

    @Test
    public  void  test(){
       /* for(int i = 1; i <= 30; i++){
            System.out.println(numTilings(i));
        }*/

       int N = 29;
        System.out.println(numTilings(N));
    }
}
