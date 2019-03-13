package algorithm.medium9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/11/11.
 */
public class Solution779 {

    //Memory  Limit Excced
    public  int kthGrammar(int N, int K){
        if(N == 1){
            return 0;
        }

       List<List<Character>> lists = new ArrayList<>();
        List<Character> l1 = new ArrayList<>();
        l1.add('0');
        lists.add(l1);

        for(int i = 1; i < N;i++){
           List<Character> pre = lists.get(i-1);
            List<Character> current = new ArrayList<>();
            for(int j = 0; j < pre.size(); j++){
                if(pre.get(j) == '0'){
                    current.add('0');
                    current.add('1');
                }else {
                    current.add('1');
                    current.add('0');
                }
            }
            lists.add(current);
        }

        for(int i = 0; i < lists.size(); i++){
            for(int j = 0; j < lists.get(i).size(); j++){
                System.out.print(lists.get(i).get(j) + "  ");
            }

            System.out.println();
        }

        return  lists.get(N-1).get(K-1) - '0';
    }

    public  int help(int N, int K, int flag){
        if(N == 1){
            if(flag == 0) {
                return 0;
            }else {
                return  1;
            }
        }

       /* if(N == 2){
            if(K == 0 ){
                if(flag == 0) {
                    return 0;
                }else {
                    return  1;
                }
            }else {
                if(flag == 0){
                    return 1;
                }else {
                    return 0;
                }
            }
        }*/

        int totalNumber = (int) Math.pow(2, N-1);
        int divisor = 0;
        if(K < totalNumber / 2) {
            divisor = (K + 1) / 2;
        }else {
            divisor = (K - totalNumber / 2 + 1) / 2 + (totalNumber / 4);
        }
        int value1 = 0;
        if(K % 2 == 0) {
            value1 = help(N - 1, divisor, 1);
        }else {
            value1 = help(N-1, divisor, 0);
        }

        if(value1 == 0){
            if(flag == 0){
                return 0;
            }else {
                return 1;
            }
        }else {
            if(flag == 0){
                return 1;
            }else {
                return 0;
            }
        }
    }



    //Accepted -----3ms
    /*
        recursive algorithm
     */
    public  int kthGrammar1(int N, int K){
        if(N == 1 || K == 1){
            return 0;
        }


        int total = (int)Math.pow(2,N-1);
        if(K <= total / 2){
            if(K % 2 == 0){
                return  help(N-1, (K+1) / 2,1);
            }else {
                return  help(N-1, (K+1)/ 2,0);
            }
        }else {
            if(K  % 2 == 0){
                return  help(N-1, (K-total / 2 +1) / 2 + total / 4, 1);
            }else {
                return  help(N-1, (K- total / 2 + 1) / 2 + total / 4, 0);
            }
        }
    }

    @Test
    public  void  test(){
      /* int N = 30;
        int K = 434991989;*/
      /* int N = 4;
        int K =5;*/

      int N = 4;
        int K = 5;

        long startTime = System.currentTimeMillis();
        int result = kthGrammar1(N,K);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
