package algorithm.hard2;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;


import java.util.Stack;

public class Solution224 {
    public boolean isDigit(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        } else {
            return false;
        }
    }



    //Accepted ---137ms
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        int index = 0;

        s = s.trim();
        while (index < s.length()) {
            if (s.charAt(index) == '(') {
                stack.push(Character.toString(s.charAt(index)));
                index++;
            } else if (s.charAt(index) == '+') {
                stack.push(Character.toString(s.charAt(index)));
                index++;
            } else if (s.charAt(index) == '-') {
                int temp = index + 1;
                while ((temp < s.length()) && (isDigit(s.charAt(temp)))) {
                    temp++;
                }

                if(index == 0 || s.charAt(index-1) == '('){
                    String sub1 = s.substring(index, temp);
                    stack.push(sub1);
                }else {
                    stack.push(Character.toString(s.charAt(index)));
                    if(index+1 != temp) {
                        stack.push(s.substring(index + 1, temp));
                    }
                }
                index = temp;
            } else if (s.charAt(index) == ' ') {
                index++;
            } else if (isDigit(s.charAt(index))) {
                int temp = index;
                while ((temp < s.length()) && (isDigit(s.charAt(temp)))) {
                    temp++;
                }
                String sub3 = s.substring(index, temp);
                stack.push(sub3);
                index = temp;
            } else {
                while (!stack.isEmpty()) {
                    int value1 = Integer.parseInt(stack.pop());
                    if(stack.peek().equals("(")){
                        stack.pop();
                        stack.push(Integer.toString(value1));
                        break;
                    }
                    String op = stack.pop();
                    int value2 = Integer.parseInt(stack.pop());
                    if(stack.isEmpty() || stack.peek().equals("(")){
                        stack.pop();
                        if(op.equals("-")){
                            stack.push(Integer.toString(value2 - value1));
                        }else {
                            stack.push(Integer.toString(value1 + value2));
                        }
                        break;
                    }else {
                        String preOp = stack.pop();
                        stack.push("+");
                        if(preOp.equals("+") && op.equals("+")){
                            stack.push(Integer.toString(value1 + value2));
                        }else if(preOp.equals("+") && op.equals("-")){
                            stack.push(Integer.toString(value2 - value1));
                        }else if(preOp.equals("-") && op.equals("+")){
                            stack.push(Integer.toString(value1 - value2));
                        }else if(preOp.equals("-") && op.equals("-")){
                            stack.push(Integer.toString(-1 * (value1 + value2)));
                        }
                    }
                }
                index++;
            }
        }


        while (stack.size() != 1){
            int value1 = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int value2 = Integer.parseInt(stack.pop());
            if(stack.isEmpty()){
                if(op.equals("-")){
                    stack.push(Integer.toString(value2 - value1));
                }else {
                    stack.push(Integer.toString(value1 + value2));
                }
            }else {
                String preOp = stack.pop();
                stack.push("+");
                if(preOp.equals("+") && op.equals("+")){
                    stack.push(Integer.toString(value1 + value2));
                }else if(preOp.equals("+") && op.equals("-")){
                    stack.push(Integer.toString(value2 - value1));
                }else if(preOp.equals("-") && op.equals("+")){
                    stack.push(Integer.toString(value1 - value2));
                }else if(preOp.equals("-") && op.equals("-")){
                    stack.push(Integer.toString(-1 * (value1 + value2)));
                }
            }
        }
        return Integer.parseInt(stack.pop());

    }


    @Test
    public  void  test(){
        String s = "1 + 1";
//        String s = " -2-1 + 2 ";
//        String s =  "(1+(4+5+2)-3)+(6+8)";
//        String s = "(1)";
//        String s = "1-(5)";


        long startTime = System.currentTimeMillis();
        int result = calculate(s);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
