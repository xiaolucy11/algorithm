package interview.medium1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2018/8/9 0009.
 */
public class Solution22 {
    public  boolean isValid(String str){
        if(str.charAt(0) == ')'){
            return  false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push(str.charAt(i));
            }else {
                if(stack.isEmpty() || stack.peek() == ')'){
                    return  false;
                }else {
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return  true;
        }else {
            return  false;
        }
    }
    public  void  generate(List<String> list, String str, int length , int leftParenthNum, int n){
        if(length  == 2 * n){
            if(isValid(str)){
                list.add(str);
            }
        }else {
            int rightParenthNum = length - leftParenthNum;
            if(rightParenthNum > leftParenthNum){return;}

            if(leftParenthNum == n){
                generate(list, str + Character.toString(')'), length + 1, leftParenthNum, n);
            }else {
                generate(list, str + Character.toString(')'), length + 1, leftParenthNum, n);
                generate(list, str + Character.toString('('), length + 1, leftParenthNum + 1, n);
            }
        }
    }

    //Accepted ---- 8ms
    //  recursive brute search + pruning
    public List<String> generateParenthesis(int n){
        List<String > list = new ArrayList<>();
        generate(list, "(", 1, 1, n);
        return  list;
    }

    @Test
    public  void  test(){
        /*String str  = "(()())";
        System.out.print(isValid(str));*/
        List<String> result = generateParenthesis(100);
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i) + "   :  " + isValid(result.get(i)));
        }
    }
}
