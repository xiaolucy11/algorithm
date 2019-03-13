package interview.easy4;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/1 0001.
 */
public class Solution771 {
    public  int numJewelsInStones(String J, String S){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < J.length(); i++){
            map.put(J.charAt(i), 1);
        }

        int count = 0;
        for(int i = 0; i < S.length(); i++){
            if(map.containsKey(S.charAt(i))){
                count++;
            }
        }
        return  count;
    }

    @Test
    public void  test(){
        String J = "a";
        String S = "Z";
        System.out.print(numJewelsInStones(J, S));
    }
}
