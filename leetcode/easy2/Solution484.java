package interview.easy2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/10 0010.
 */
public class Solution484 {

    //Accepted ------ refer from others
    public int poorPigs(int buckets, int minutesToDie, int minutesTotest){
        int pigs = 0;
        while(Math.pow(minutesTotest / minutesToDie +1, pigs) < buckets){
            pigs++;
        }
        return  pigs;
    }
    @Test
    public  void  test(){
        System.out.print(poorPigs(100, 15, 60));
    }
}
