package algorithm.medium8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by youlu on 2018/11/4.
 */
public class Solution722 {
    //accepted ----4ms
    /*
        ugly code, too many if - else statement
     */
    public List<String> removeComments(String[] source){
        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        int index = 0;
        int flag = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index < source.length){
            if(stack.isEmpty()) {
                stringBuilder = new StringBuilder();
            }

                int i = 0;
            flag = 0;
                while (i < source[index].length()){
                    if(source[index].charAt(i) == '/'){
                       if(!stack.isEmpty()){
                         /*  if(i + 1 < source[index].length() && source[index].charAt(i+1) == '*'){
                               stack.push('/');
                               i += 2;
                           }else {
                               i++;
                           }*/
                         i++;
                       }else {
                           if(i+1 < source[index].length() &&
                                   source[index].charAt(i+1) == '/'){
                               if(stringBuilder.length() != 0) {
                                   result.add(stringBuilder.toString());
                               }
                               flag = 1;
                               break;
                           }else if(i + 1 < source[index].length() &&
                                   source[index].charAt(i+1) == '*'){
                               stack.push('/');
                               i += 2;
                           }else {
                               stringBuilder.append(source[index].charAt(i));
                               i++;
                           }
                       }

                    }else {
                        if(source[index].charAt(i) == '*'){
                            if(i + 1 < source[index].length() && source[index].charAt(i+1) == '/'){
                                if(!stack.isEmpty()) {
                                    stack.pop();
                                    i++;
                                }else {
                                    stringBuilder.append(source[index].charAt(i));
                                }
                            }else {
                                if(stack.isEmpty()){
                                    stringBuilder.append(source[index].charAt(i));
                                }
                            }
                        }else {
                            if(stack.isEmpty()){
                                stringBuilder.append(source[index].charAt(i));
                            }
                        }
                        i++;

                    }
                }
                if(flag == 1){
                    index++;
                    continue;
                }
                if(i >= source[index].length()){
                    if(stack.isEmpty() && stringBuilder.length() != 0){
                        result.add(stringBuilder.toString());
                    }
                    index++;
                }

        }
        return  result;
    }

    @Test
    public  void  test(){
      /*  String[] source = {"*//**//*Test program *//**//*", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "*//**//* This is a test", "   multiline  ",
                "   comment for ", "   testing *//**//*", "a = b + c;", "}"};*/

//        String[] source = {"a/*comment", "line", "more_comment*/b"};
//      String[] source = {"main() {", "   int x = 1; // Its comments here", "   x++;", "   cout << x;", "   //return x;", "   x--;", "}"};
//        String[] source = {"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"};
        String[] source = {"void func(int k) {" ,"// this function does nothing /*", "   k = k*2/4;","   k = k/2;*/", "}"};

        List<String> result = removeComments(source);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
    }
}
