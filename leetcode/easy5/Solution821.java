package interview.easy5;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/3 0003.
 */
public class Solution821 {
    //Accepted -----7ms
    public  int[] shortestToChar(String S, char C){
        int length = S.length();
        int[] result = new int[length];
        int slow = -100000, quick = 0;
        while (S.charAt(quick) != C){
            quick++;
        }
        int index = 0;
        while (index < length){
            if(S.charAt(index) != C){
                result[index] = Math.min(quick - index, index - slow);
                index++;
            }else {
                result[index++] = 0;
                slow = quick;
                quick++;
                while (quick < length && S.charAt(quick) != C){
                    quick++;
                }
                if(quick == length){
                    quick = Integer.MAX_VALUE;
                }
            }
        }
        return  result;
    }

    @Test
    public  void  test(){
        String  S = "loveleetcode";
        char C = 'e';
        int[] result = shortestToChar(S, C);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
