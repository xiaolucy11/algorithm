package interview.easy2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/3 0003.
 */
public class Solution400 {
    public int findNthDigit(int n){
        String s = "";
        for(int i = 1; i <= n; i++){
            s += Integer.toString(i);
        }
        System.out.println(s);
        return s.charAt(n - 1) - '0';
    }

    public  int findNthDigit1(int n){
        if(n == 1){return  1;}
        int countSum = 1, bitNum = 1;
        int temp = 0;
        while( countSum < n){
            bitNum++;
            temp = countSum;
            temp += (bitNum - 1) * Math.pow(10, bitNum-2) * 9;
            if((temp - countSum)/9 == (bitNum - 1) * Math.pow(10, bitNum -2)){
                countSum = temp;
            }else {
                break;
            }
        }
        if(temp == countSum) {
            countSum -= (bitNum - 1) * Math.pow(10, bitNum - 2) * 9;
        }
        bitNum--;
        int startDigit = (int)Math.pow(10, bitNum-1);
        int diff = (n - countSum) / bitNum  ;
        int targetNumber = startDigit + diff;
        System.out.println(targetNumber);
        String s = Integer.toString(targetNumber);
        int targetNumberPosition = countSum + bitNum * diff;
        return  s.charAt(n - targetNumberPosition) -  '0';
    }
    @Test
    public  void  test(){
        System.out.print(findNthDigit1(1000000000));
    }
}
