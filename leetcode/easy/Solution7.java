package interview.easy;

import org.junit.Test;

import java.util.Map;
import java.util.Vector;

/**
 * Created by Administrator on 2018/6/1 0001.
 */
public class Solution7 {
    public Vector<Integer> integerToVec(int x){
        Vector<Integer> intVector = new Vector<Integer>();
        int a = Math.abs(x);

        if (a < 10){
            intVector.add(a);
            return intVector;
        }
        while(a >= 10){
            int b = a % 10;
            a = a / 10;
            intVector.add(b);
        }
        intVector.add(a);
        return intVector;
    }

    @Test
    public  void test1(){
        int x = 1534236469;
        Vector<Integer> v = integerToVec(x);
        for(int i = 0; i < v.size(); i++){
            System.out.print( v.get(i));
        }
    }
    public int vecToInteger(Vector<Integer> v){
        int sum = 0;
        for (int i = 0; i < v.size(); i++){
            int tmp = 10 * sum + v.get(i);
            if( ((tmp - v.get(i)) / 10 != sum) || (tmp < Integer.MIN_VALUE) ){
                return 0;
            }
            sum = tmp;
        }
        return sum;
    }
    @Test
    public void test2(){
        Vector<Integer> v = integerToVec(-2147483648);

       // for(int i = 0; i < v.size(); i++){
        //    System.out.print( v.get(i) + " ");
       //

        System.out.print(vecToInteger(v));
    }
    public int solution(int x){
        Vector<Integer> v = integerToVec(x);
        int result = vecToInteger(v);
        if(x > 0){
            return result;
        }
        else{
            return -1 * result;
        }
    }

    @Test
    public void testSolution(){
        System.out.println(solution(-2147483648));
       // System.out.println(Math.pow(2,31) -1  );
        //System.out.println(-(1 << 31 ));
        //System.out.println(1 << 31 -1);
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("Integer.MIN_VALUE:  " + Integer.MAX_VALUE );
    }
}
