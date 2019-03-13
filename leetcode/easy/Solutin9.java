package interview.easy;

import org.junit.Test;

import java.util.Vector;

/**
 * Created by Administrator on 2018/6/2 0002.
 */
public class Solutin9 {
    public Vector<Integer> integerToVec(int x){
        Vector<Integer> v = new Vector<>();
        while(x >= 10){
            int a = x % 10;
            x = x /10;
            v.add(a);
        }
        v.add(x);
        return v;
    }
    public boolean isPalindrome(int x){
        if ( x < 0){
            return false;
        }
        Vector<Integer> vec = integerToVec(x);
        int first = 0, last = vec.size() -1 ;
        while(first <= last){
            if(vec.get(first) == vec.get(last)){
                first++;
                last--;
            }
            else {
                return false;
            }
        }
        return true;
    }

    @Test
    public  void test(){
        int x = 21;
        System.out.print(isPalindrome(x));
    }
}
