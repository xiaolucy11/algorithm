package algorithm.medium7;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlu on 2018/10/20.
 */
public class Solution556 {
    public  int toSum(char[] chars){
        int sum = 0;
        int mutilply = 1;
        for(int i = chars.length - 1; i >= 0; i--){
            sum += ((int)(chars[i] - '0')) * mutilply;
            mutilply *= 10;
        }

        return  sum;
    }


    //Accepted ---3ms
    public int nextGreaterElement(int n){
        char[] chars = Integer.toString(n).toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = chars.length - 1; i >= 0; i--){
            for(int j = i - 1; j >= 0; j--){
                if(chars[j] < chars[i]){
                    if(!map.containsKey(j)) {
                        map.put(j, i);
                    }else {
                        int value = map.get(j);
                        if(chars[i] < chars[value]){
                            map.put(j,i);
                        }
                    }
                }
            }
        }
        if(map.isEmpty()) {
            return -1;
        }else {
            int maxValue = -1;
            for(Integer key : map.keySet()){
                if(key > maxValue){
                    maxValue = key;
                }
            }

            char temp = chars[maxValue];
            chars[maxValue] = chars[map.get(maxValue)];
            chars[map.get(maxValue)] = temp;
            Arrays.sort(chars,maxValue + 1, chars.length);
            int result = toSum(chars);
            if(Integer.toString(result).equals(new String(chars))) {
                return toSum(chars);
            }else {
                return -1;
            }
        }
    }


    @Test
    public  void  test(){
        int n = 12;
//        int n = 21;
//        int n = 1234;
 //       int n = 230241;
//        int n = 12443322;
//        int n =  1999999999;
        long startTime = System.currentTimeMillis();
        int result = nextGreaterElement(n);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
