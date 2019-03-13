package algorithm.medium3;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by youlu on 2018/9/12.
 */
public class Solution227 {
    public  boolean isDigit(char ch){
        if(ch >= '0' && ch <= '9'){
            return  true;
        }
        return false;
    }

    public int toSum(String s){
        int sum = 0;
        int multuply = 1;
        int length = s.length();

        for(int i = length - 1; i >= 0; i--){
            int number = (int)(s.charAt(i) - '0');
            sum += multuply * number;
            multuply *= 10;
        }
        return  sum;
    }
    public int strToSum(String s){
        if(s.charAt(0) == '-'){
            return toSum(s.substring(1,s.length())) * -1;
        }else {
            return  toSum(s);
        }
    }


    //Accepted ------94ms
    public int calculate(String s){
        int length = s.length();
        if(length == 0){
            return 0;
        }
        if(length == 1){
            return (int)(s.charAt(0) - '0');
        }
        Stack<String> stack = new Stack<>();

        int index = 0;
        while (index < length){
            if(s.charAt(index) == ' '){
                index++;
                continue;
            }

            if(s.charAt(index) == '+' || s.charAt(index) == '-' ||
                    s.charAt(index) == '*' || s.charAt(index) == '/') {
                stack.push(Character.toString(s.charAt(index)));
                index++;
                continue;
            }

            int nextIndex = index;
            while ((nextIndex < length) && (isDigit(s.charAt(nextIndex)))){
                nextIndex++;
            }

            int currentValue = strToSum(s.substring(index, nextIndex));
            if(!stack.isEmpty()) {
                String top = stack.peek();
                if(top.equals("*") || top.equals("/")){
                    String temp1 = stack.pop() ;
                    int  temp2 = strToSum(stack.pop());

                   // int currentValue =  (int)(s.charAt(index) - '0');
                    if(top.equals("*")){
                        int value = temp2 * currentValue;
                        stack.push(Integer.toString(value));
                    }

                    if(top.equals("/")){
                        int value = temp2 / currentValue;
                        stack.push(Integer.toString(value));
                    }
                }else {
                    stack.push(Integer.toString(currentValue));
                }
            }else {
                stack.push(Integer.toString(currentValue));
            }
           index = nextIndex;
        }

        Stack<String> stack1 = new Stack<>();
        while (!stack.isEmpty()){
            String str = stack.pop();
            stack1.push(str);
        }

        while (stack1.size() > 1){
            int value1 = strToSum(stack1.pop());
            String operation = stack1.pop();
            int value2 = strToSum(stack1.pop());

            if(operation.equals("+")){
                stack1.push(Integer.toString(value1 + value2 ));
            }
            if(operation.equals("-")){
                stack1.push(Integer.toString(value1 - value2 ));
            }
        }
        String result = stack1.pop();
        if(result.charAt(0) == '-'){
            return  -1 * strToSum(result.substring(1, result.length()));
        }else {
            return strToSum(result);
        }
    }

    @Test
    public  void  test(){
        String s = "2-3+4";
        int result = calculate(s);
        System.out.print(result);
    }

}
