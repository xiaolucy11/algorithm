package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/24 0024.
 */
public class Solutin231 {
    public  boolean isPowerOfTwo(int n){
        if(n == 1 || n == 2){return  true;}
        if(n % 2 == 0){
            return isPowerOfTwo(n / 2);
        }else {
            return false;
        }
    }

    public  boolean isPowerOfTwo1(int n){
        if(n <= 0){return  false;}
        if(n == 1 || n == 2){return  true;}
        while (n > 2){
            if( n % 2 == 1){
                return  false;
            }else {
                n = n / 2;
            }
        }
        return  true;
    }

    @Test
    public  void  test(){
        System.out.print(isPowerOfTwo1(218));
    }
}
