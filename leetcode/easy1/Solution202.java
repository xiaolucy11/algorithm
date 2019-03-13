package interview.easy1;

import org.junit.Test;

import java.util.Vector;

/**
 * Created by Administrator on 2018/6/21 0021.
 */
public class Solution202 {
    public Vector<Integer> IntegerToVector(int n){
        Vector<Integer> vector = new Vector<>();
        while (n >= 10){
            vector.add(n % 10);
            n = n / 10;
        }
        vector.add(n);
        return  vector;
    }

    public int sumSquare(Vector<Integer> vector){
        int sum = 0;
        for(int i = 0; i < vector.size(); i++){
            sum += vector.get(i) * vector.get(i);
        }
        return  sum;
    }

    public  int nextNumber(int n){
        Vector<Integer> vector = IntegerToVector(n);
        int nextNum = sumSquare(vector);
        Vector<Integer> vector1 = new Vector<>();
        return   nextNum;
    }

    public  int endNumber(int n ){
        if( n == 1){return  1;}
        Vector<Integer> vector = new Vector<>();
        int nextNum = nextNumber(n);
        while(nextNum != 1){
            int nnextNum = nextNumber(nextNum);
            if(nnextNum == 1){return  1;}
             if( vector.contains(nnextNum)){
                return  nnextNum;
            }else {
                 vector.add(nnextNum);
             }
             nextNum = nnextNum;
        }
        return  1;
    }
    public boolean isHappy(int n ){
        int num = endNumber(n);
        if (num == 1){return  true;}
        else {
            return  false;
        }
    }

    @Test
    public  void  test(){
        System.out.print(isHappy(68));
    }
}
