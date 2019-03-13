package algorithm.medium7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/10/22.
 */
public class Solution592 {

    public int gcd(int a, int b){
       if(a < 0 || b < 0){
           return  -1;
       }
       if(b == 0){
           return  a;
       }
       return a % b == 0 ? b:gcd(b, a % b);
    }

    public  int denominatorsGCD(int[] arrDenominators){
        int product = arrDenominators[0];
        for(int i = 1; i < arrDenominators.length; i++){
            int value = gcd(product, arrDenominators[i]);
            product *= arrDenominators[i];
            product /= value;
        }
        return  product;
    }
    public  boolean isDigit(char ch){
        if(ch >= '0' && ch <= '9'){
            return  true;
        }else {
            return  false;
        }
    }

    //Accepted ---6ms
    public String fractionAddition(String expression){
        List<String> numerators = new ArrayList<>();
        List<String> denominators = new ArrayList<>();
        int index = 0;
        while (index < expression.length()){
            if(expression.charAt(index) == '-'){
                int temp1 = index+1;
                while ((temp1 < expression.length()) && (isDigit(expression.charAt(temp1)))){
                    temp1++;
                }
                numerators.add(expression.substring(index,temp1));

                int temp2 = temp1 +1;
                while ((temp2 < expression.length()) && (isDigit(expression.charAt(temp2)))){
                    temp2++;
                }

                denominators.add(expression.substring(temp1+1, temp2));
                index = temp2;
            }else {
                if(expression.charAt(index) =='+'){
                    index++;
                    continue;
                }
                int temp1 = index+1;
                while ((temp1 < expression.length()) && (isDigit(expression.charAt(temp1)))){
                    temp1++;
                }
                numerators.add(expression.substring(index,temp1));

                int temp2 = temp1 +1;
                while ((temp2 < expression.length()) && (isDigit(expression.charAt(temp2)))){
                    temp2++;
                }
                denominators.add(expression.substring(temp1+1, temp2));
                index = temp2;
            }
        }
        int[] arrNumerators = new int[numerators.size()];
        int[] arrDenominators = new int[denominators.size()];
        for(int i = 0; i < numerators.size(); i++){
            arrNumerators[i] = Integer.parseInt(numerators.get(i));
            arrDenominators[i] = Integer.parseInt(denominators.get(i));
        }

        int commonDenominators = denominatorsGCD(arrDenominators);
        int sum = 0;
        for(int i = 0; i < numerators.size(); i++){
            int value = commonDenominators / arrDenominators[i];
            arrNumerators[i] *= value;
            sum += arrNumerators[i];
        }

        int resultGcd = gcd(Math.abs(sum), commonDenominators);
        sum /= resultGcd;
        commonDenominators /= resultGcd;
        return Integer.toString(sum) + "/" + Integer.toString(commonDenominators);
    }

    @Test
    public  void  test(){
        String expression = "-1/2+1/2";
//        String expression = "-1/2+1/2+1/3";
//        String expression = "1/3-1/2";
//        String  expression = "5/3+1/3";
//      String expression = "-5/2+10/3+7/9";
        long startTime = System.currentTimeMillis();
        String result = fractionAddition(expression);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));

    }
}
