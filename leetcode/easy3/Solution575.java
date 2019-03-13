package interview.easy3;

import org.junit.Test;

import javax.net.ssl.SSLContext;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/20 0020.
 */
public class Solution575 {
    public  int distributionCandies(int[] candies){
        int lenght = candies.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < lenght; i++) {
            map.put(candies[i], map.getOrDefault(candies[i], 0) + 1);
        }
        int keyNumber = 0;
        for(Integer key : map.keySet()){
            keyNumber++;
        }
        if(keyNumber > lenght / 2){
            return  lenght / 2;
        }else {
            return  keyNumber;
        }
    }
    @Test
    public  void  test(){
        int[] candies = {1,1,1,3,3,3};
        System.out.print(distributionCandies(candies));
    }
}
