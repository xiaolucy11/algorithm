package algorithm.medium8;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by youlu on 2018/10/31.
 */
public class Solution678 {

    //Accepted ---5ms
    /*
        time complexity O(n)
     */
    public boolean checkValidString(String s){
        Stack<Integer> leftParenthesStack = new Stack<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                leftParenthesStack.add(i);
            }else if(ch == '*'){
                stack.add(i);
            }else {
                if(!leftParenthesStack.isEmpty()){
                    int temp1 = leftParenthesStack.pop();
                }else {
                    if(!stack.isEmpty()){
                       int temp2 =  stack.pop();
                    }else {
                        return false;
                    }
                }
            }
        }

       while (!leftParenthesStack.isEmpty() && !stack.isEmpty()){
           int value1 = leftParenthesStack.peek();
           int value2 = stack.peek();
           if(value1 < value2){
               leftParenthesStack.pop();
               stack.pop();
           }else {
               break;
           }
       }

       if(leftParenthesStack.isEmpty()){
           return  true;
       }else {
           return  false;
       }
    }

    @Test
    public  void  test(){
        String s = "()";
//        String s = "(*)";
//        String s = "(*))";
//        String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        boolean b = checkValidString(s);
        System.out.print("result : " + b);
    }
}
