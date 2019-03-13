package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/19 0019.
 */
public class Solution172 {
    public int countFive(int n){
        if(n % 5 == 0){
            int count = 0;
            while((n >= 5) && (n % 5 == 0)){
                count++;
                n = n / 5;
            }
            return  count;
        }else {
            return  0;
        }
    }
    public int traillingZeroes(int n){
        int traiZerosNum = 0;
        for(int i = 1; i <= n; i++){
            if(i % 5 == 0){
                traiZerosNum += countFive(i);
            }
        }
        return  traiZerosNum;
    }

    public  int traillingZeros1(int n){
        if( n > 0 && n < 5){return  0;}
        int div = n / 5;
        return  div + traillingZeros1(div);
    }
    @Test
    public  void test(){
        int result  = traillingZeros1(125);
        System.out.print(result);
    }
}
