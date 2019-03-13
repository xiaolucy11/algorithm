package interview.easy1;

import org.junit.Test;

import  java.util.Vector;

/**
 * Created by Administrator on 2018/6/27 0027.
 */
public class Solution258 {
    public int nextNum(int num){
        Vector<Integer> vector = new Vector<>();
        while(num >= 10){
            int mod = num % 10;
            vector.add(mod);
            num = num / 10;
        }
        vector.add(num);
        int sum = 0;
        for(int i = 0; i < vector.size(); i++){
            sum += vector.get(i);
        }
        return  sum;
    }

    @Test
    public  void  test1(){
        System.out.print(nextNum(11));
    }
    public int addDigits(int num){
        if (num > 0 && num < 9){return  num;}
        int nextNumber = nextNum(num);
        while(nextNumber >= 10){
            nextNumber = nextNum(nextNumber);
        }
        return nextNumber;
    }

    public  int addDigits1(int num){
        return  1 + (num - 1)%9;
    }

    @Test
    public void  test2(){
        System.out.print(addDigits(38));
    }
}
