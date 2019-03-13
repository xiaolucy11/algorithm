package algorithm.medium10;

import org.junit.Test;

/**
 * Created by youlu on 2018/11/30.
 */
public class Solution837 {
    public double  totalProbability;

    public  void  search(int N, int K, int W, int sum,double probability){
       if(sum >= K){
           if(sum <= N) {
               totalProbability += probability;
           }
           return;
       }


        for(int i = 1; i <= W; i++){
            search(N,K,W,sum+i,probability*(1.0/W));
        }

    }


    //Time Limit Exceed
    public  double new21Game(int N, int K, int W){
        totalProbability = 0;
        search(N,K,W,0,1);
        return totalProbability;
    }


    public  double search1(int N, int K, int W, double[] arr, int value){

        double sum = 0;
        for(int i = 1; i <= W; i++){
            if(value - i >= 0 && value - i < K) {
                sum += arr[value - i] * (1.0 / W);
            }
        }
        arr[value] = sum;
        return  sum;
    }

    //Time Limit Exceed
    /*
        pass 123/146
     */
    public  double new21Game1(int N, int K, int W){
        if(N < K){
            return 0;
        }
       double[] arr = new double[N + 1 ];

        double totalSum = 0;
        arr[0] = 1;
       arr[1] = 1.0 / W;
        if(1 >= K && 1 <= N){
            totalSum += arr[1];
        }


        for(int i = 2; i < N + 1; i++) {
            double temp = search1(N, K, W, arr, i);
            if (i >= K) {
                totalSum += temp;
            }
        }

        return  totalSum;
    }






    //code from other
    /*
        it is math problem
     */
    public  double new21Game3(int N, int K, int W){
        if (K == 0 || N >= K + W) return 1;
        double dp[] = new double[N + 1],  Wsum = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i <= N; ++i) {
            dp[i] = Wsum / W;
            if (i < K) Wsum += dp[i]; else res += dp[i];
            if (i - W >= 0) Wsum -= dp[i - W];
        }
        return res;
    }


    @Test
    public  void  test(){
       /* int N = 10;
        int K = 1;
        int W = 10;*/

     /* int N = 6;
        int K = 1;
        int W = 10;*/

    /*  int N = 21;
        int K = 17;
        int W = 10;*/

    /* int N = 421;
        int K = 400;
        int W = 47;*/
    int N = 5895;
        int K = 3952;
        int W = 4172;


        long startTime = System.currentTimeMillis();
        double result = new21Game1(N,K,W);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));

    }
}
