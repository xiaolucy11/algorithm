package interview.easy1;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 2018/6/24 0024.
 */
public class Solution232 {
    private Stack<Integer> stack1;
    private  Stack<Integer> stack2;

    public Solution232(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public  void  push (int x){
        stack1.push(x);
    }

    public  int pop(){
        while (stack1.size() != 1){
            int temp1 = stack1.pop();
            stack2.push(temp1);
        }
        int result = stack1.pop();
        while (!stack2.isEmpty()){
            int temp2 = stack2.pop();
            stack1.push(temp2);
        }
       return result;
    }

    public  int peek(){
        while(stack1.size() != 1){
            int temp1 = stack1.pop();
            stack2.push(temp1);
        }
        int result = stack1.peek();
        while(!stack2.isEmpty()){
            int temp2 = stack2.pop();
            stack1.push(temp2);
        }
        return  result;
    }

    public  boolean empty(){
        return  stack1.isEmpty();
    }



    @Test
    public void  test(){
        push(1);
        push(3);
        push(45);
        int pop1 = pop();
        System.out.println(pop1);
        System.out.println(peek());
        System.out.println(empty());
    }
}
