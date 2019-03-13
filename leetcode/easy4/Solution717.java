package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/29 0029.
 */
public class Solution717 {
    public  boolean judge(int[] bits, int start, int end){
        if(end == 0){
            if (bits[end] == 0){
                return  true;
            }else {
                return  false;
            }
        }

        if(end == 1){
            if(bits[end] == 1 && bits[end - 1] == 0){
                return  false;
            }else {
                return  true;
            }
        }

        if(bits[end] == 1 && bits[end - 1] == 0){
            return  false;
        }else if(  bits[end] == 1 && bits[end -1] == 1){
            return  judge(bits, start, end - 2);
        }else {
            return judge(bits, start, end - 1) || judge(bits, start, end - 2);
        }
    }

    //Accepted --- 5ms6
    public  boolean isOneBitCharacter(int[] bits){
        return judge(bits, 0, bits.length - 2);
    }

    @Test
    public void  test(){
        int[] bits = {1,1,0,0};
        System.out.print(isOneBitCharacter(bits));
    }
}
