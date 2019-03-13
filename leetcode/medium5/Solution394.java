package algorithm.medium5;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by youlu on 2018/9/28.
 */
public class Solution394 {
    public  boolean isChar(char ch){
        if((ch >= 'a' && ch <= 'z') ||
                (ch >= 'A' && ch <= 'Z')){
            return  true;
        }else {
            return  false;
        }
    }

    public  int strToNumber(String s ){
        int sum = 0;
        int multiply = 1;
        for(int i = s.length() - 1; i >= 0; i--){
            sum += multiply * ((int)(s.charAt(i) - '0'));
            multiply *= 10;
        }

        return  sum;
    }


    //Accepted --------5ms
    /*
        using StringBuilder to improve effeciency
     */
    public  String decodeString (String s){
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        String result = "";

        int i = 0;
        while (i < s.length()){
            if((s.charAt(i) >= '0') && (s.charAt(i) <= '9')){
                int numIndex = i;
                while ((numIndex < s.length()) && (s.charAt(numIndex) >= '0'
                        && s.charAt(numIndex) <= '9')){
                    numIndex++;
                }

                numStack.add(strToNumber(s.substring(i,numIndex)));
                i = numIndex;
            }else if(s.charAt(i) == '[') {
                stringStack.add(Character.toString(s.charAt(i)));
                i++;
            }else if(isChar(s.charAt(i))){
                int temp = i;
                while ((temp < s.length()) && (isChar(s.charAt(temp)))){
                    temp++;
                }
                if(!stringStack.isEmpty()) {
                    stringStack.add(s.substring(i, temp));
                }else {
                    result += s.substring(i, temp);
                }
                i = temp;
            }else {
                String subStr = "";
                while (!stringStack.isEmpty()){
                    String topStr = stringStack.peek();
                    if(!topStr.equals("[")){
                        subStr = topStr + subStr;
                        stringStack.pop();
                    }else {
                        stringStack.pop();
                        break;
                    }
                }

                int duplicateCoount = numStack.pop();
                String duplicateStr = "";
                while (duplicateCoount > 0){
                    duplicateStr += subStr;
                    duplicateCoount--;
                }

                if(stringStack.isEmpty()){
                    result += duplicateStr;
                }else {
                    stringStack.add(duplicateStr);
                }

                i++;
            }
        }

          return  result;
    }


    @Test
    public  void  test(){
        //String s =  "3[a]2[bc]";
        //String s = "3[a2[c]]";
        //String s = "2[abc]3[cd]ef";
        //String s = "3[a]2[b4[F]c]";
        String s = "100[leetcode]";
        long startTime = System.currentTimeMillis();
        String result = decodeString(s);
        long endTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("runnint time : " + (endTime - startTime));
    }
}
