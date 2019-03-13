package interview.easy2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/10 0010.
 */
public class Solution461 {
    public  int[] toBits(int x){
        int[] bits = new int[32];
        int index = 31;
        while(x > 1){
            int mod = x % 2;
            int div = x / 2;
            x = div;
            bits[index--] = mod;
        }
        bits[index] = x;
        return  bits;
    }
    public  int hamingDistance(int x, int y){
        int[] xBits = toBits(x);
        int[] yBits = toBits(y);
        int count = 0;
        for(int i = 0; i < 32; i++){
            if(xBits[i] != yBits[i]){
                count++;
            }
        }
        return  count;
    }

    @Test
    public  void  test(){
        System.out.print(hamingDistance(2, 5));
    }
}
