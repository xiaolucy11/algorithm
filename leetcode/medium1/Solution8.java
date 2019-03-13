package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/8 0008.
 */
public class Solution8 {
    public  boolean judgeFirstChar(char ch){
        if(ch == '+' || ch == '0' || ch == '-' || ch == '1' || ch == '2'||
        ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7'||
                ch == '8' || ch == '9'){
            return true;
        }else {
            return  false;
        }
    }

    public boolean isDigitChar(char ch){
        if( ch == '0' || ch == '1' || ch == '2'||
                ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7'||
                ch == '8' || ch == '9'){
            return true;
        }else {
            return  false;
        }
    }
    public boolean isNotZero(char ch){
        if( ch == '1' || ch == '2'||
                ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7'||
                ch == '8' || ch == '9'){
            return true;
        }else {
            return  false;
        }
    }

        //Accepted -------22ms
    public  int myAtol(String str){
        if(str.trim().equals("")){
            return  0;
        }
        str = str.trim();
        if(!judgeFirstChar(str.charAt(0))){
            return  0;
        }
      int last = 1;
        while (last < str.length()){
            if(isDigitChar(str.charAt(last))){
                last++;
            }else {
                break;
            }
        }
        int index = last - 1;
        int sum = 0;
        int multiply  = 1;
        int start = 1;
        while (start < str.length()){
            if(str.charAt(start) == '0'){
                start++;
            }else {
                break;
            }
        }
        if(isNotZero(str.charAt(0))){
            start = 0;
        }

        if(index - start + 1 > 10){
            if(str.charAt(0) == '-'){
                return  Integer.MIN_VALUE;
            }else {
                return  Integer.MAX_VALUE;
            }
        }

        while ( index >= start){
            int temp = sum ;
            int value = (int)(str.charAt(index ) - '0');
            sum += multiply * value;
            if((sum < temp)|| (sum - temp) / multiply != value){
                if(str.charAt(0) == '-'){
                    return  Integer.MIN_VALUE;
                }else {
                    return  Integer.MAX_VALUE;
                }
            }
            multiply *= 10;
            index--;
        }
        if(start == 0){
            return  sum;
        }
        if(str.charAt(0) == '-'){
            return -1 * sum;
        }else if(str.charAt(0)  == '+'){
            return sum;
        }else {
            int temp = sum;
            int value = (int)(str.charAt(0) - '0');
            sum += multiply * value;
            if((sum < temp) ||(sum - temp) / value != multiply){
                return  Integer.MAX_VALUE;
            }
            return sum;
        }
    }

    @Test
    public  void  test(){
        String str = "200000000000000000000000000000";
        System.out.println(myAtol(str));
        //System.out.println(Integer.parseInt(str));
    }
}
