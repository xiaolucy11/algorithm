package algorithm.medium4;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/24.
 */
public class Solution375 {

    public  int getMoneyAmount(int n){
        int averageCount = (int)(Math.log(n) / Math.log(2)) ;
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        return  sum * averageCount / n;
    }

    @Test
    public  void  test(){
        int n= 4;
        int result = getMoneyAmount(n);
        System.out.print(result);
    }
}
