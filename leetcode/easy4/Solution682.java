package interview.easy4;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 2018/7/26 0026.
 */
public class Solution682 {
    //Accepted -----6ms
    public  int calPoints(String[] ops){
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < ops.length; i++){
            if(!ops[i].equals("C") && !ops[i].equals("D") && !ops[i].equals("+")){
                stack.push(Integer.parseInt(ops[i]));
            }else if(ops[i].equals("C")){
                stack.pop();
            }else if(ops[i].equals("D")){
                int value1 = stack.peek();
                stack.push(2 * value1);
            }else {
                int value2 = stack.pop();
                int value3 = stack.pop();
                stack.push(value3);
                stack.push(value2);
                stack.push(value2 + value3);
            }
        }
        while (!stack.isEmpty()){
            int value = stack.pop();
            sum += value;
        }
        return  sum;
    }

    @Test
    public  void  test(){
        String[] ops = {"5", "-2", "4","C","D","9","+", "+"};
        System.out.println(calPoints(ops));
    }
}
