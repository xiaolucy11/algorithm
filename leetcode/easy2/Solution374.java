package interview.easy2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/2 0002.
 */
public class Solution374 {
    public  int guess(int n){
        return  -1;
    }
    //Accepted
    public int guessNumber(int n){
        int left = 1, right = n;
        int mid = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(guess(mid) == 0){
                return  mid;
            }else if(guess(mid) == -1){
               right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return  -1;
    }
    public  int guessInterval(int start,int end, int pick) {
        if(start == pick){return  start;}
        if (end == pick){return  end;}
        int mid = start + (end - start )/2;
        if(mid == pick){
            return  mid;
        }else if(mid < pick){
            return  guessInterval(mid, end, pick);
        }else {
            return  guessInterval(1, mid, pick);
        }
    }
    @Test
    public  void test(){
        System.out.print(guessInterval(1,10, 6));
    }
}
