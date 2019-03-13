package interview.medium1;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 2018/8/13 0013.
 */
public class Solution71 {
    public  boolean isChar(char ch){
        if(ch >= 'a' && ch <= 'z'){
            return  true;
        }
        return  false;
    }
    public  String simplifyPath(String path){
        if(path.length() == 1){
            return "/";
        }
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < path.length()){
            if(path.charAt(index) == '/'){
                if(!stack.isEmpty()){
                    char peekChar = stack.peek();
                    if(peekChar == '.'){
                        char dotChar = stack.pop();
                    }else if(peekChar != '/'){
                        stack.push(path.charAt(index));
                    }else {
                        index++;
                        continue;
                    }
                }else {
                    stack.push(path.charAt(index));
                }
            }else if(path.charAt(index) == '.'){
                if(!stack.isEmpty()){
                    char peekChar = stack.peek();
                    if((peekChar == '.') && (index + 1 < path.length() &&
                        path.charAt(index + 1) == '/')){
                        while (!stack.isEmpty()) {
                            char topChar = stack.pop();
                            if(isChar(topChar)){
                                break;
                            }
                        }
                    }
                    stack.push(path.charAt(index));
                }
            }else {
                stack.push(path.charAt(index));
            }
            index++;
        }
       StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            char c = stack.pop();
            result.append(c);
        }
        String endResult = result.reverse().toString();
        if(  endResult.length() > 1 && endResult.charAt(endResult.length() - 1) == '/'){
            return  endResult.substring(0, endResult.length()-1);
        }
        return  endResult;
    }

    @Test
    public  void  test(){
        String path = "/home//foo/";
        String result = simplifyPath(path);
        System.out.print(result);
    }
}
