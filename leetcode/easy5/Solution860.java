package interview.easy5;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/6 0006.
 */
public class Solution860 {

    //Accepted ----5ms
    public  boolean lemonadeChange(int[] bills){
        int[] arr = new int[3];
        if(bills[0]  != 5){
            return  false;
        }
        arr[0]++;
        for(int i = 1; i < bills.length; i++){
            if(bills[i] == 5){
                arr[0]++;
            }else if(bills[i] == 10) {
                if(arr[0] == 0){
                    return  false;
                }
                arr[0]--;
                arr[1]++;
            }else {
                if(arr[1] >= 1 && arr[0] >= 1){
                    arr[1]--;
                    arr[0]--;
                }else if(arr[1] == 0 && arr[0] >= 3){
                    arr[0] -= 3;
                }else {
                    return  false;
                }
            }
        }
        return  true;
    }

    @Test
    public  void  test(){
        int[] bills = {5,5,10,10,20};
        System.out.print(lemonadeChange(bills));
    }
}
