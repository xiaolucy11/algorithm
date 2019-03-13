package interview.easy2;

import org.junit.Test;

import java.math.BigInteger;

import java.util.Vector;

/**
 * Created by Administrator on 2018/7/11 0011.
 */
public class Solution479 {
    public  boolean check(long num){
        Vector<Long> vector = new Vector<>();
        while(num > 9){
            long mod = num % 10;
            long div = num / 10;
            vector.add(mod);
            num = div;
        }
        vector.add(num);
        int left = 0, right = vector.size() - 1;
        while(left < right){
            if(!vector.get(left).equals(vector.get(right))){
                return  false;
            }
            left++;
            right--;
        }
        return  true;

    }
    // 1, 2,4,6,8 true, 3, 5, 7 wrong
    // no meaning problem
    public  long largestPalindrome(int n){
        long[] array = {9L,99L,999L,9999L,99999L,999999L,9999999L,99999999L};
        long num = array[n-1];
            for(long i = num; i > 0; i--) {
                for (long j = i ; j > 0; j--) {
                    long l = num * j;
                    System.out.println(l);
                    if (check(l)) {
                        return l;
                    }
                }
            }
            System.out.println(" ");
        return  0;
    }

    public  long computeMod(int n){
        long[] arr1 = {3L, 99L, 999L, 9999L, 99999L, 999999L, 9999999L, 99999999L };
        long[] arr2 = {3L, 91L, 91L, 9901L, 9901L, 999001L, 999001L, 99990001L,};
        long mult1 = arr1[n-1];
        long mult2 = arr2[n - 1];
        return  mult1 * mult2 % 1337;
    }
    public  int largestPalindrome2(int n){
        int result = (int) computeMod(n);
        return  result;
    }

    @Test
    public  void  test(){
        long startTime = System.currentTimeMillis();
        long result = largestPalindrome(3);
        long endTime = System.currentTimeMillis();
        System.out.println(result + "  run time :" + (endTime - startTime));
        System.out.println(90909 % 1337);


    }
}
