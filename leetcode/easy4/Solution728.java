package interview.easy4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/30 0030.
 */
public class Solution728 {
    public  List<Integer> toDigitArray(int num){
        List<Integer> list = new ArrayList<>();
        while (num > 9){
            int mod = num % 10;
            int div = num / 10;
            list.add(mod);
            num = div;
        }
        list.add(num);
        return  list;
    }
    public  boolean judge(int num){
        List<Integer> list = toDigitArray(num);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == 0){
                return false;
            }
            if(num % list.get(i) != 0){
                return  false;
            }
        }

        return  true;
    }

    //Accepted --- 8ms
    public List<Integer> selfDividingNumber(int left, int right){
        if(left > right){
            return  new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<>();
        for(int i = left;  i <= right; i++){
            if(judge(i)){
                result.add(i);
            }
        }
        return  result;
    }

    @Test
    public  void  test1(){
        List<Integer> result = toDigitArray(120);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }

    @Test
    public  void  test2(){
        List<Integer> result = selfDividingNumber(1, 22);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
    }
}
