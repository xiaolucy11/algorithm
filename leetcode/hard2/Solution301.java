package algorithm.hard2;

import org.junit.Test;

import java.util.*;

public class Solution301 {

    public Set<String> set;
    public  int maxLenght;
    public boolean isValidParentheses(char[] chars,int start, int end){
        if(end <= start){
            return  true;
        }
        Stack<Character> stack = new Stack<>();
        int index = start;
        while (index <= end){
            if(chars[index] == '('){
                stack.push(chars[index]);
                index++;
            }else if(chars[index] == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
                index++;
            }else {
                index++;
            }
        }
        return  true;
    }

    public boolean check(char[] chars,int start, int end){
        if(end <= start){
            return  true;
        }
        Stack<Character> stack = new Stack<>();
        int index = start;
        while (index <= end){
            if(chars[index] == '('){
                stack.push(chars[index]);
                index++;
            }else if(chars[index] == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
                index++;
            }else {
                index++;
            }
        }
        if(stack.isEmpty()){
            return  true;
        }else {
            return false;
        }
    }

    public  String toValidString(char[] chars,int start, int end){
        StringBuilder sb = new StringBuilder();
        for(int i = start; i <= end; i++){
            if(chars[i] != '#'){
                sb.append(chars[i]);
            }
        }
        return  sb.toString();
    }

    public void  search(char[] chars, int index){
       if(isValidParentheses(chars,0,index-1)){
           if(index == chars.length){
               if(!check(chars,0,index-1 )){
                   return;
               }
               String str = toValidString(chars,0,index-1);
//               System.out.println(str);
               if(str.length() > maxLenght){
                   set.clear();
                   set.add(str);
                   maxLenght = str.length();
               }else if(str.length() == maxLenght){
                   set.add(str);
               }else {
               }
           }else {
               char ch = chars[index];
               if(ch == '(' || ch == ')') {
                   chars[index] = '#';
                   search(chars, index + 1);
                   chars[index] = ch;
               }

               search(chars,index+1);
           }
       }
    }

    //Accepted ----670ms
    /*
        trackback
        too slow
     */
    public List<String> removeInvalidParentheses(String s){
        if(s.length() == 1){
            List<String> temp = new ArrayList<>();
            if(s.charAt(0) == '(' || s.charAt(0) == ')'){
                temp.add("");
            }else {
                temp.add(Character.toString(s.charAt(0)));
            }
            return temp;
        }
        set = new HashSet<>();
        maxLenght = 0;
        List<String> lists = new ArrayList<>();
        char[] chars = s.toCharArray();
        search(chars,0);

        for(String str: set){
            lists.add(str);
        }

        return  lists;
    }

    @Test
    public void  test(){
//        String s = "(a)())()";
//        String s  = "(";
        String s = "((s(())()(()))((((((";

        long startTime = System.currentTimeMillis();
        List<String> result = removeInvalidParentheses(s);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
        System.out.println("running time : " + (endTime - startTime));
    }
}
