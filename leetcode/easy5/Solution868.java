package interview.easy5;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/6 0006.
 */
public class Solution868 {

    //Accepted ------11ms
    public  int binaryGap(int N){
        String bytes = Integer.toBinaryString(N);
        int maxDistance = 0;
        int start = 0;
        while(bytes.charAt(start) != '1'){
            start++;
        }

        int end = start+1;
        while (end < bytes.length()){
            if(bytes.charAt(end) != '1'){
                end++;
            }else {
                if(end - start > maxDistance){
                    maxDistance = end - start;
                }
                start = end;
                end++;
            }
        }

        return  maxDistance;
    }


    @Test
    public  void test(){
        System.out.print(binaryGap(8));
    }
}
