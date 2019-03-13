package interview.easy2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5 0005.
 */
public class Solution412 {
    //Accepted -----2ms
    public List<String> fizzBuzz(int n){
        List<String> l = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5== 0){
                l.add("FizzBuzz");
            }else  if(i % 3== 0){
                l.add("Fizz");
            }else if(i % 5 == 0){
                l.add("Buzz");
            }else {
                l.add(Integer.toString(i));
            }
        }
        return  l;
    }

    @Test
    public  void  test(){
        List<String> result = fizzBuzz(15);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "   ");
        }
    }
}
