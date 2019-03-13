package interview.easy3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/14 0014.
 */
public class Solution507 {

    //Accepted ------9ms
    public List<Integer> divisors(int num){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 2; i < (int)Math.sqrt(num) + 1; i++){
            if(num % i == 0){
                list.add(i);
                list.add(num / i);
            }
        }
        return  list;
    }
    public boolean checkPerfectNumber(int num){
        if(num == 1){return  false;}
        List<Integer> list = divisors(num);
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }
        if(sum == num){
            return  true;
        }
        else {
            return  false;
        }
    }


    @Test
    public  void  test(){
        long startTime = System.currentTimeMillis();
        System.out.println(checkPerfectNumber(6));
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
