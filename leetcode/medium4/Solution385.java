package algorithm.medium4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by youlu on 2018/9/26.
 */
public class Solution385 {
    public  class   NestedInteger{
        public  NestedInteger(){

        }
        public  NestedInteger(int value){

        }

        public  void  add(NestedInteger nestedInteger){

        }
    }

    public  NestedInteger deserialize(String s){
        if (s.isEmpty())
            return null;
        if (s.charAt(0) != '[') // ERROR: special case
            return new NestedInteger(Integer.valueOf(s));

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int l = 0; // l shall point to the start of a number substring;
        // r shall point to the end+1 of a number substring
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (ch == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                l = r+1;
            } else if (ch == ']') {
                String num = s.substring(l, r);
                if (!num.isEmpty())
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }
                l = r+1;
            } else if (ch == ',') {
                if (s.charAt(r-1) != ']') {
                    String num = s.substring(l, r);
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                l = r+1;
            }
        }

        return curr;
    }

    /*
        my own solutin, not using NestedInteger Class
        when using NestedInteger Class, is not easy to debug
     */
    public List<Object> deserialize1(String s){
        Stack<String> stack1 = new Stack<>();
        Stack<List<Object>> stack2 = new Stack<>();
        int index = 0;
        while (index < s.length()){
            if(s.charAt(index) == '['){
                stack1.push(Character.toString(s.charAt(index)));
                index++;
            }else if(s.charAt(index) >= 0 && s.charAt(index) <= 9){
                int temp = index;
                while ((temp < s.length()) && (s.charAt(temp) >= 0 &&
                        s.charAt(temp) <= 9)){
                    temp++;
                }
                String subStr = s.substring(index, temp);
                stack1.push(subStr);
                index = temp;
            }else if(s.charAt(index) == ',' || s.charAt(index) == '-'){
                index++;
            }else {
                List<Object> list = new ArrayList<>();
                list.add(stack1.pop());
                if(!stack2.isEmpty()){
                    List<Object> top = stack2.peek();
                    list.add(top);
                }
                stack2.add(list);
            }
        }

        return  stack2.peek();
    }
}
