package interview.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/2 0002.
 */
public class Solutin13 {
    public int romanToInt(String s){
        Map<Character, Integer> map = new HashMap<Character,Integer>(){{put('I',1);put('V',5);put('X',10);put('L',50); put('C',100); put('D',500); put('M',1000);}};
        int sum = 0;
        for(int i = 0; i < s.length() -1; i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                sum -= map.get(s.charAt(i));
            }
            else{
                sum += map.get(s.charAt(i));
            }
        }
        sum += map.get(s.charAt(s.length() -1));

        return sum;
    }
    @Test
    public  void test(){
        String s = "MCMXCIV";
        int sum = romanToInt(s);
        System.out.println(sum);
    }
}
