package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
public class Solution657 {

    //Accepted -----14ms
    public  boolean judgeCircle(String moves){
        int leftCount = 0, rightCount = 0, upCount = 0, downCount = 0;
        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'R'){
                rightCount++;
            }
            if(moves.charAt(i) == 'L'){
                leftCount++;
            }
            if(moves.charAt(i) == 'U'){
                upCount++;
            }
            if(moves.charAt(i) == 'D'){
                downCount++;
            }

        }
        if(leftCount == rightCount && upCount == downCount){
            return true;
        }else {
            return false;
        }
    }

    @Test
    public  void  test(){
        String moves = "LL";
        System.out.println(judgeCircle(moves));
    }
}
