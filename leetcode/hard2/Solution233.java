package algorithm.hard2;

import org.junit.Test;

public class Solution233 {
    public int digitOne(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1'){
                count++;
            }
        }
        return  count;
    }


    //Time Limit Exceed
    public  int countDigitOne(int n){
        int totalCount = 0;
        for(int i = 1; i <= n; i++){
            totalCount += digitOne(Integer.toString(i));
        }
        return  totalCount;
    }


    /*
        math problem
     */
    public  int countDigitOne1(int n){
        if (n <= 0) {
            return 0;
        }
        int m = n;
        int sum = 0;
        int e = 1;
        while (n > 0) {
            int r = n % 10;
            n /= 10;
            if (r == 0) {
                sum += n * e;
            } else if (r > 1) {
                sum += (n + 1) * e;
            } else { // r == 1
                sum += m - n * 9 * e - e + 1;
            }
            e *= 10;
        }
        return sum;
    }


    @Test
    public  void  test(){
        int n = 100;

        long startTime = System.currentTimeMillis();
        int result = countDigitOne(n);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
