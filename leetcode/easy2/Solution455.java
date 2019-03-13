package interview.easy2;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/7/10 0010.
 */
public class Solution455 {
    //Accepted ---------10ms
    public  int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0, sIndex = 0;
        int count = 0;
        while((gIndex < g.length) && (sIndex < s.length)){
            if(g[gIndex] <= s[sIndex]){
                count++;
                gIndex++;
                sIndex++;
            }else {
                sIndex++;
            }
        }
        return  count;
    }

    @Test
    public  void  test(){
        int[] g = new int[]{1,2};
        int[] s = new int[]{1,2,3};
        System.out.print(findContentChildren(g,s));
    }
}
