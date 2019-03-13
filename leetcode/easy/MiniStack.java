package interview.easy;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 2018/6/17 0017.
 */
public class MiniStack {
    private Stack<Integer> stack  ;
    private  Stack<Integer> miniStack  ;
    /** initialize your data structure here. */
    public MiniStack() {
        stack = new Stack<>();
        miniStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(miniStack.isEmpty() ||  x < miniStack.peek()){
            miniStack.push(x);
        }
    }

    public void pop() {
        if(!stack.isEmpty() && !miniStack.isEmpty() && (stack.peek().equals(miniStack.peek()))){
            miniStack.pop();
        }
        stack.pop();
    }

    public int top() {
        if(!miniStack.isEmpty()){
            return  stack.peek();
        }
        return Integer.MIN_VALUE;

    }

    public int getMin() {
        if(!miniStack.isEmpty()){
            return  miniStack.peek();
        }
        return Integer.MIN_VALUE;

    }

    @Test
    public void test(){
        MiniStack mstack = new MiniStack();
        mstack.push(-2);;
        mstack.push(0);
        mstack.push(-3);

        System.out.print(mstack.getMin());
    }
}
