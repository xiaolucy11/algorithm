package interview.easy;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/9 0009.
 */
public class Solution70 {
    public int climbStairs(int n){
        if(n == 1){return 1;}
        if(n == 2){return 2;}
        else{
            int[] result = new int[n];
            result[0] = 1;
            result[1] = 2;
            for(int i = 2; i < n; i++){
                result[i] = result[i - 1] + result[i - 2];
            }
            return result[n-1];
        }
    }

    @Test
    public  void  test(){
        int stairNum = 4;
        int result = climbStairs(stairNum);
        System.out.println(result);
    }
}
