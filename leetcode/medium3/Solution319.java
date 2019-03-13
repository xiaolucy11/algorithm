package algorithm.medium3;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/17.
 */
public class Solution319 {
    public  int get(int n){
        if(n == 2){
            return 1;
        }
        int count = 0;
        for(int i  = 2; i <= Math.sqrt(n) + 1; i++){
            if(n % i == 0){
                if(i * i == n){
                    count++;
                }else {
                    count += 2;
                }
            }
        }
        return count+1;
    }
    //Time Limited Out
    public int bulbSwitch(int n){
        if(n == 0){
            return 0;
        }
        int count = 1;
        for(int i = 2; i < n; i++){
            int value = get(i);
            if(value % 2 == 0){
                count++;
            }
        }
        if(get(n)  % 2 == 0) {
            return count + 1;
        }else {
            return  count;
        }
    }

    //Accepted --------0ms
    public int bulbSwitch1(int n){
        return  (int) Math.sqrt(n);
    }

    @Test
    public  void  test(){
        int n = 10;
        long startTime = System.currentTimeMillis();
        for(int i = 1; i <= 36; i++){
            System.out.println(i + "  :  " + bulbSwitch(i) );
        }
        // System.out.println(bulbSwitch(n));
        long endTime  = System.currentTimeMillis();
        System.out.println("running time : " + (endTime - startTime));
    }
}
