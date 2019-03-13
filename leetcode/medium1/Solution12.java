package interview.medium1;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/8/9 0009.
 */
public class Solution12 {
    public  Map<String, Integer> map;

    public  void  init(){
        map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D",500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L",50);
        map.put("XL", 40);
        map.put("X",10);
        map.put("IX",9);
        map.put("V",5);
        map.put("IV",4);
        map.put("I", 1);
    }

    public  String find(int num){
        for(String  key : map.keySet()){
            if(map.get(key) <= num){
                return  key;
            }
        }
        return  null;
    }

    //Accepted ------52ms
    public  String intToRoman(int num){
        init();
        String result = "";
        while (num > 0){
            String temp = find(num);
            result += temp;
            num -= map.get(temp);
        }
        return  result;
    }

    @Test
    public  void  test(){
        int num = 1994;
        System.out.print(intToRoman(num));
    }
}
