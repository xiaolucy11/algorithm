package interview.easy5;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 2018/8/5 0005.
 */
public class Solution844 {
    //try success,
    //Accepted ---5ms , run time O(n), space O(1)
    //but terrible code,is bad to read
    public  boolean backspaceCompare(String S, String T){
        int indexS = S.length() - 1;
        int indexT = T.length() - 1;
        while ((indexS >= 0) && (indexT >= 0)){

            if((S.charAt(indexS) != '#') && (T.charAt(indexT) != '#') &&
                    (S.charAt(indexS) != T.charAt(indexT))){
                return  false;
            }

            if((S.charAt(indexS) != '#') && (T.charAt(indexT) != '#') &&
                    (S.charAt(indexS) == T.charAt(indexT))){
                indexS--;
                indexT--;
            }

            if((indexS >= 0) && (S.charAt(indexS) == '#')){
                int temp1 = indexS;
                int skipS = 0;
                while (temp1 >= 0){
                    if(S.charAt(temp1) == '#'){
                        temp1--;
                        skipS++;
                    }else {
                        skipS--;
                        temp1--;
                    }
                    if(skipS == 0){
                        break;
                    }
                }
                indexS = temp1;
            }

            if((indexT >= 0)&&(T.charAt(indexT) == '#')){
                int temp2 = indexT;
                int skipT = 0;
                while (temp2 >= 0){
                    if(T.charAt(temp2) == '#'){
                        temp2--;
                        skipT++;
                    }else {
                        temp2--;
                        skipT--;
                    }
                    if(skipT == 0){
                        break;
                    }
                }
                indexT = temp2;
            }
    }
    while (indexS >= 0){
        if(S.charAt(indexS) != '#'){
            return  false;
        }
        int temp1 = indexS;
        int skipS = 0;
        while (temp1 >= 0){
            if(S.charAt(temp1) == '#'){
                temp1--;
                skipS++;
            }else {
                skipS--;
                temp1--;
            }
            if(skipS == 0){
                break;
            }
        }
        indexS = temp1;
    }

    while (indexT >= 0){
        if(T.charAt(indexT) != '#'){
            return  false;
        }
        int temp2 = indexT;
        int skipT = 0;
        while (temp2 >= 0){
            if(T.charAt(temp2) == '#'){
                temp2--;
                skipT++;
            }else {
                temp2--;
                skipT--;
            }
            if(skipT == 0){
                break;
            }
        }
        indexT = temp2;
    }
        return  true;
    }

    //Accepted ---8ms
    public  boolean backspaceCompare1(String S, String T){
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        String str1 = "";
        String str2 = "";
        for(int i = 0;i < S.length(); i++){
            if(S.charAt(i) != '#'){
                stack1.push(S.charAt(i));
            }else {
                if (!stack1.isEmpty()){
                    char temp1 = stack1.pop();
                }
            }
        }

        for(int i = 0;i < T.length(); i++){
            if(T.charAt(i) != '#'){
                stack2.push(T.charAt(i));
            }else {
                if (!stack2.isEmpty()){
                   char temp2 = stack2.pop();
                }
            }
        }
        while (!stack1.isEmpty()){
            char ch = stack1.pop();
            str1 += Character.toString(ch);
        }
        while (!stack2.isEmpty()){
            char c = stack2.pop();
            str2 += Character.toString(c);
        }
        if(str1.equals(str2)){
            return  true;
        }else {
            return  false;
        }


    }

    @Test
    public  void  test(){
        String S = "ab##";
        String T = "c#d#";
        System.out.print(backspaceCompare(S, T));
    }
}
