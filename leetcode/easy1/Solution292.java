package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/29 0029.
 */
public class Solution292 {


    //iteratively version -------- memory limit
    public  boolean canWinNim(int n){
        if((n == 1) || (n == 2) || (n == 3)){return  true;}

        boolean[] nums = new boolean[n+1];
        nums[1] = true;
        nums[2] = true;
        nums[3] = true;
        for(int i = 4; i <=n; i++){
            if(!nums[i-1] || !nums[i-2] || !nums[i-3]){
                nums[i] = true;
            }else {
                nums[i] = false;
            }
        }
        return nums[n];
    }

    //recursively version --------- timeout
    public  boolean  canWinNim1(int n){
        if((n == 1) || (n == 2 ) || (n == 3)){return  true;}
        return (!canWinNim1(n -1)) || (!canWinNim1(n - 2)) || (!canWinNim1( n - 3));
    }


    //Accepted
    public boolean canWinNim2(int n){
        return  !(n % 4 ==  0);
    }

    @Test
    public  void  test(){
        System.out.print(canWinNim1(6));
    }
}
