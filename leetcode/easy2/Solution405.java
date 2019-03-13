package interview.easy2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/5 0005.
 */
public class Solution405 {
    public  String positiveNumberToHex(int num){
        if(num == 0){return "0";}
        String result = "" ;
        int multi = 16;
        int mod = 0;
        int div = 1;
        char[] charArray = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c','d','e','f'};

        while(num >0) {
            div = num / multi;
            mod = num % multi;
            if(mod >= 1) {
                result = charArray[mod - 1] + result;
            }else {
                result = "0" + result;
            }
            num = div;
        }

        return  result;
    }

    public String nonPositveNumberToHex(int num){
        if(num == Integer.MIN_VALUE){return "80000000";}
        String result = "";
        char[] charArray = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c','d','e','f'};
        num = Math.abs(num);
        int[] b = new int[32];
        int index = 31;
        while(num >= 2){
            int div = num / 2;
            int mod = num % 2;
            b[index--] = mod;
            num = div;
        }
        b[index] = num;
        for(int i = 0; i < 32; i++){
            if(b[i] == 0){
                b[i] = 1;
            }else {
                b[i] = 0;
            }
        }
        int plus = 1;
        for(int i = 31; i >= 0; i--){
            if(b[i] + plus == 2){
                plus = 1;
                b[i] = 0;
            }else {
                b[i] = b[i] + plus;
                plus = 0;
                break;
            }
        }
        for(int j = 31; j >= 3;j = j - 4){
            int value = b[j]  + 2 * b[j-1] + 4 * b[j-2]+ 8*b[j-3];
            if(value >= 1) {
                result = charArray[value - 1] + result;
            }else {
                result = "0" + result;
            }

        }
        return  result;
    }
    public String toHex(int num){
        if(num >= 0){
            return  positiveNumberToHex(num);
        }else {
            return nonPositveNumberToHex(num);
        }

    }
    @Test
    public void test(){
        int count = 0;
        for(int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++){
            if(!toHex(i).equals(Integer.toHexString(i))){
                System.out.print(i + "  ");
                count++;
            }
        }
        System.out.print(count);
       //System.out.println(toHex(256));
        //System.out.print(Integer.toHexString(256));
    }
}
