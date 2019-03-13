package interview.easy;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 2018/6/4 0004.
 */
public class Solution20 {
    public boolean isValid(String s){
        if((s == null) || (s.length() % 2 == 1)){
            return  false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '['|| s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if( !stack.isEmpty() && stack.peek() == '('){ stack.pop();}
                else {return false;}
            }else  if(s.charAt(i) == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){stack.pop();}
                else {return false;}
            }else  {
                if(!stack.isEmpty() && stack.peek() == '{'){stack.pop();}
                else {return false;}
            }
        }
        if(stack.isEmpty()){return true;}
        else {
            return false;
        }
    }

    @Test
    public void test(){
        String s = "){";
        System.out.println(isValid(s));
    }
}
