package interview.easy2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/1 0001.
 */
public class Solution371 {
    public  int getSum(int a, int b){
        int count = a;
        if(b > 0) {
            while (b > 0) {
                count++;
                b--;
            }
        }else {
            while(b < 0){
                count--;
                b++;
            }
        }
        return  count;
    }

    @Test
    public void test(){
        System.out.print(getSum(-1, -2));
    }
}
