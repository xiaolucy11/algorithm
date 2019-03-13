package interview.easy;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 2018/6/16 0016.
 */
public class Solution155 {
    public class MiniStack{
       Stack<Integer> stack ;
        Stack<Integer> miniStack;

        public void MinStack(){
            stack = new Stack<>();
            miniStack = new Stack<>();
        }

        public void push(int x){
            stack.push(x);
            if(!miniStack.isEmpty() ||  x < miniStack.peek()){
                miniStack.push(x);
            }
        }
        public void pop(){
            //need to use equal(), because of needing to compare value of Integer object
           if(!stack.isEmpty() && !miniStack.isEmpty() && stack.peek().equals(miniStack.peek())){
               miniStack.pop();
           }
           stack.pop();
        }
        public int top(){
           return  stack.peek();
        }

        public  int getMin(){
            return  miniStack.peek();
        }

        }

        @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
            stack.push(-2);
            System.out.println(stack.peek());
        }
    }





