package interview.easy3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/21 0021.
 */
public class Solution598 {

    //Accepted ----4ms
    public  int maxCount(int m, int n, int[][] ops){
        if(ops.length == 0){
            return  m * n;
        }
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        int opsLength = ops.length;
        for(int i = 0; i < opsLength; i++){
            if(ops[i][0] < minRow){
                minRow = ops[i][0];
            }
            if(ops[i][1] < minCol){
                minCol = ops[i][1];
            }
        }
        if(minRow <= m && minCol <= n) {
            return minRow * minCol;
        }else if(minCol <= n){
            return  m * minCol;
        }else if(minRow <= m) {
            return  minRow;
        }else {
            return  m * n;
        }
    }

    @Test
    public  void  test(){
        int[][] ops = {{2,2}, {3,3},{1,2}};
        System.out.print(maxCount(3,3, ops));
    }
}
