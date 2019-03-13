package algorithm.hard1;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by youlu on 2018/12/4.
 */
public class Solution32 {


    //Wrong Solution
    public  int longestValidParentheses(String s){
        Stack<Character> stack = new Stack<>();

        int maxLength = 0;
        int curLength = 0;
        int validLength = 0;


        int index = 0;
        while (index < s.length()){
            if(s.charAt(index) == '('){
                stack.add(s.charAt(index));
                index++;
            }else {
                if (!stack.isEmpty()) {
                    char ch = stack.peek();
                    if (ch == '(') {
                        stack.pop();
                        validLength += 2;

                        if(stack.isEmpty()){
                           curLength += validLength;
                            validLength = 0;
                        }

                        index++;
                    }
                }else {
                    maxLength = Math.max(maxLength, curLength);
                    curLength = 0;
                    validLength = 0;
                    index++;
                }
            }
        }

        if(stack.isEmpty()){
            curLength += validLength;
            maxLength = Math.max(maxLength, curLength);
        }else {
            maxLength = Math.max(maxLength, curLength);
            maxLength = Math.max(maxLength, validLength);
        }


        return  maxLength;
    }



    //Accepted ---18ms
    /*
        using stack
     */
    public  int longestValidParentheses1(String s){
      char[] chars = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            chars[i] = 'a';
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.add(i);
            }else {
                if(!stack.isEmpty()){
                    int index = stack.pop();
                    chars[index] = '*';
                    chars[i] = '*';
                }
            }
        }

        int maxLength = 0;

        int charIndex = 0;
        while (charIndex < chars.length){
            if(chars[charIndex] != '*'){
                charIndex++;
            }else {
                int temp = charIndex;
                while ((temp < chars.length) && (chars[temp] == '*')){
                    temp++;
                }

                if(temp - charIndex  > maxLength){
                    maxLength = temp - charIndex ;
                }
                charIndex = temp;
            }
        }

        return  maxLength;
    }


    /*
        code from other
        dp algorithm
     */
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


    @Test
    public  void  test(){
        String s = "(()";
//        String s = ")()())";

//        String s = "()(())";

//        String s = "(()(((()";

        long startTime = System.currentTimeMillis();
        int result  = longestValidParentheses1(s);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
