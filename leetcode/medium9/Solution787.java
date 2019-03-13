package algorithm.medium9;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by youlu on 2018/11/13.
 */
public class Solution787 {
    public  int minPath;

    public  void  dfs(int[][] flights, int src, int dst, int K, int length, Set<Integer> paths){
        if(src == dst){
            if(length < minPath){
                minPath = length;
            }
            return;
        }
        if(K < 0){
            return;
        }
        if(length >= minPath){
            return;
        }

        int index = 0;
        while ((index < flights.length) && (flights[index][0] != src)){
            index++;
        }

        for(int i = 0; i < flights.length; i++){
          /*  if(flights[i][0] != src){
                return;
            }*/

            if(flights[i][0] == src && !paths.contains(flights[i][1])){
                paths.add(flights[i][1]);
                dfs(flights, flights[i][1],dst,K-1, length + flights[i][2],paths);
                paths.remove(flights[i][1]);
            }
        }
    }



    //Accepted ---789ms
    /*
        trackbacking and prune
     */
    public  int findCheapestPrice(int n, int[][] flights,int src,int dst, int K){
        if(src < 0 || dst < 0 || src > n || dst > n){
            return  -1;
        }
        minPath = Integer.MAX_VALUE;

        Arrays.sort(flights, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Set<Integer> paths = new HashSet<>();
        paths.add(src);
        dfs(flights,src,dst,K,0, paths);


        if(minPath != Integer.MAX_VALUE) {
            return minPath;
        }else {
            return  -1;
        }

    }

    //Accepted ---7ms
    /*
        dp algorithm
        part reference from other
     */
    public  int findCheapestPrice1(int n, int[][] flights,int src,int dst, int K){
        if(src < 0 || dst < 0 || src > n || dst > n){
            return  -1;
        }

        int[][] dp = new int[K+2][n];
        for(int i = 0; i < K+2; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = 10000000;
            }
        }

        dp[0][src] = 0;
        for(int i = 1; i < K + 2; i++){
            dp[i][src] = 0;
            for(int j = 0; j < flights.length; j++){
                if(dp[i][flights[j][1]] > dp[i-1][flights[j][0]] + flights[j][2]){
                    dp[i][flights[j][1]] = dp[i-1][flights[j][0]] + flights[j][2];
                }
            }
        }

        if(dp[K+1][dst] == 10000000){
            return  -1;
        }else {
            return  dp[K+1][dst];
        }
    }


    @Test
    public  void  test(){
       /* int n = 3;
        int[][] flight = {{0,1,100}, {1,2,100},{0,2,500}};
        int K = 2;
        int src = 0;
        int dst = 2;*/

      int n = 17;
        int[][] flight = {{0,12,28},{5,6,39},{8,6,59},{13,15,7},{13,12,38},
                {10,12,35},{15,3,23},{7,11,26},{9,4,65},{10,2,38},{4,7,7},{14,15,31},
                {2,12,44},{8,10,34},{13,6,29},{5,14,89},{11,16,13},{7,3,46},{10,15,19},
                {12,4,58},{13,16,11},{16,4,76},{2,0,12},{15,0,22},{16,12,13},{7,1,29},
                {7,14,100},{16,1,14},{9,6,74},{11,1,73},{2,11,60},{10,11,85},{2,5,49},
                {3,4,17},{4,9,77},{16,3,47},{15,6,78},{14,1,90},{10,5,95},{1,11,30},{11,0,37},
                {10,4,86},{0,8,57},{6,14,68},{16,8,3},{13,0,65},{2,13,6},{5,13,5},{8,11,31},
                {6,10,20},{6,2,33},{9,1,3},{14,9,58},{12,3,19},{11,2,74},{12,14,48},{16,11,100},
                {3,12,38},{12,13,77},{10,9,99},{15,13,98},{15,12,71},{1,4,28},{7,0,83},{3,5,100},
                {8,9,14},{15,11,57},{3,6,65},{1,3,45},{14,7,74},{2,10,39},{4,8,73},{13,5,77},
                {10,0,43},{12,9,92},{8,2,26},{1,7,7},{9,12,10},{13,11,64},{8,13,80},{6,12,74},
                {9,7,35},{0,15,48},{3,7,87},{16,9,42},{5,16,64},{4,5,65},{15,14,70},{12,0,13},
                {16,14,52},{3,10,80},{14,11,85},{15,2,77},{4,11,19},{2,7,49},{10,7,78},{14,6,84},
                {13,7,50},{11,6,75},{5,10,46},{13,8,43},{9,10,49},{7,12,64},{0,10,76},{5,9,77},
                {8,3,28},{11,9,28},{12,16,87},{12,6,24},
                {9,15,94},{5,7,77},{4,10,18},{7,2,11},{9,5,41}};
        int src = 13;
        int dst = 4;
        int K = 13;


        long startTime = System.currentTimeMillis();
        int result = findCheapestPrice1(n, flight, src, dst, K);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
