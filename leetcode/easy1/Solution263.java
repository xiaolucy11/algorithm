package interview.easy1;

import org.junit.Test;

import java.util.Vector;

/**
 * Created by Administrator on 2018/6/27 0027.
 */
public class Solution263 {
    public boolean isUgly(int num){
        if(num == 1){return  true;}
        if(num >=2 && num <10){
            if((num % 2 == 0) || (num % 5 == 0) || (num % 5 ==0)){
                return true;
        }else {
        return  false;}
        }
        if( num % 2 == 0){return  isUgly(num / 2);}
        if(num % 3 == 0){return  isUgly(num / 3);}
        if (num % 5 == 0){return  isUgly(num / 5);}
        return  false;
    }
    public  boolean isPrime(int n ){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if( n % i == 0){return false;}
        }
        return  true;
    }
    public  Vector<Integer> primeVector(int n){
        int[] nums = new int[n+1];
        Vector<Integer> v = new Vector<>();
        for(int i = 2; i <= n; i++){
            if(nums[i] == 1){continue;}
            if(isPrime(i)){
                int multipy = 2;
                while(multipy * i <= n){
                    nums[multipy * i] = 1;
                    multipy++;
                }
            }
        }
        for(int i = 2; i < n+1; i++){
            if(nums[i] == 0){
                v.add(i);
            }
        }
        return  v;
    }
    public  boolean isUgly1(int num){
        if(num <= 0 || isPrime(num)){return  false;}
        if(num == 1){return  true;}

        if(num % 7 == 0){return  false;}
        else{return  true;}
    }


    @Test
    public  void  test(){
        Vector<Integer> vector = primeVector(10);
        System.out.println(Math.pow(5, 14) > Integer.MAX_VALUE);
        for(int i = 0; i < vector.size(); i++){
            System.out.print(vector.get(i) + "  ");
        }
    }

    //Accepted
    public  boolean isUgly2(int num){
      if(num <= 0) {return  false;}
        if(num == 1){return  true;}
        for(int i = 0; i < 32; i++){
            for(int j = 0; j <= 20; j++){
                for(int k = 0; k < 14; k++) {
                    int multiResult = (int) (Math.pow(2, i) * Math.pow(3, j) * Math.pow(5, k));
                    if (multiResult / Math.pow(2, i) == Math.pow(3, j) * Math.pow(5, k)) {
                        if (multiResult == num) {
                            return true;
                        } else if (multiResult < num) {
                            continue;
                        } else {
                            break;
                        }
                    }else {break;}
                }
            }
        }
        return  false;
    }

    @Test
    public  void  test1(){
        System.out.print(isUgly2(14));
    }
}
