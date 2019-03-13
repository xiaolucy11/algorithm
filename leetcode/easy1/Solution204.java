package interview.easy1;

import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2018/6/21 0021.
 */
public class Solution204 {
    public  boolean isPrime(int n){
        for (int i = 2 ; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return  false;
            }
        }
        return  true;
    }
    public  int countPrime(int n){
        int count = 0;
        for (int i = 2; i <= n; i++){
            if(isPrime(i)){
                count++;
            }
        }
        return  count;
    }

    public  int countPrime1(int n){

        int[] arr =  new int[n + 1];
        for(int i = 2; i < n; i++){
            arr[i] = i;
        }
        int count = 0;
        int index = 2;
        boolean[] b= new boolean[n+1];

        while (index < n) {
            if (!b[index]) {
                if (isPrime(arr[index])) {
                    int temp = (n - 1) / arr[index];
                    while (temp > 1) {
                        b[temp * arr[index]] = true;
                        temp--;
                    }
                    count++;
                } else {
                    int div = (n - 1) / arr[index];
                    while (div > 1) {
                        b[div * arr[index]] = true;
                        div--;
                    }
                }
            }
            index++;
        }

        return  count;
    }
    public int countPrimes(int n){
        int count = 0;
        int index = 2;
        boolean[] b= new boolean[n+1];

        while (index < n) {
            if (!b[index]) {
                int temp = (n - 1) / index;
                while (temp > 1) {
                    b[temp * index] = true;
                    temp--;
                }
            }
            index++;
        }
        for(int i = 2; i < n; i++){
            if(!b[i]){
                count++;
            }
        }

        return  count;
    }

    @Test
    public  void  test(){
        System.out.print(countPrime1(1500000));
    }
}
