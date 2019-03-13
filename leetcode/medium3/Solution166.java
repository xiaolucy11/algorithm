package interview.medium3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/9/8 0008.
 */
public class Solution166 {
    public  int find(StringBuilder stringBuilder, char ch){
        int lenght = stringBuilder.length();
         int index = 0;
        while (stringBuilder.charAt(index) != '.' ){
            index++;
        }

        while (index < lenght){
            if(stringBuilder.charAt(index) != ch){
                index++;
            }else {
                return  index;
            }
        }
        return  -1;
    }


    public String fractionToDecimal(int numerator, int denominator){
        if(numerator == 0){
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if(numerator < 0){
            stringBuilder.append('-');
            numerator = Math.abs(numerator);
        }
        if(denominator < 0){
            stringBuilder.append('-');
            denominator = Math.abs(denominator);
        }
        int[] nums = new int[10];
        if(numerator > denominator){
            int div = numerator / denominator;
            numerator   = numerator - div * denominator;
            stringBuilder.append((char)(div + '0'));

            if(numerator == 0){
                return  stringBuilder.toString();
            }

            stringBuilder.append('.');
        }else {
            stringBuilder.append('0');
            stringBuilder.append('.');
        }

        while (numerator < denominator){
            int count = 0;
            while (numerator < denominator){
                numerator *= 10;
                count++;
                if(count > 1){
                    stringBuilder.append('0');
                }
            }

            int div = numerator / denominator;
            if(nums[div] == 0){
                stringBuilder.append((char)(div + '0'));
                nums[div]++;
            }  else {
                int sameNumIndex = find(stringBuilder, ((char)(div + '0')));
                StringBuilder result = new StringBuilder();
                for(int i = 0; i < stringBuilder.length(); i++){
                    if(i != sameNumIndex){
                        result.append(stringBuilder.charAt(i));
                    }else {
                        result.append('(');
                        result.append(stringBuilder.charAt(i));
                    }
                }
                result.append(')');
                return  result.toString();
            }
            numerator = numerator - div * denominator;

            if(numerator == 0){
                return  stringBuilder.toString();
            }
        }
       return  "";
    }

    @Test
    public  void  test(){
       int n = 4;
        int m = 333;
        String result = fractionToDecimal(n, m);
        System.out.print(result);
    }
}
