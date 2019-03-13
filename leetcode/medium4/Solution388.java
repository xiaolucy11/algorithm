package algorithm.medium4;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/9/27.
 */
public class Solution388 {
    public  boolean isFile(String str){
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '.'){
                return true;
            }
        }

        return  false;
    }

    //Accepted ---- 6ms
    /*
        it can be optimized.
        for computing the level of every string, rather than using Map, also using Stack

        code is ugly, one function contains too many lines of code
        it need to be refactored
     */
    public int lengthLongestPath(String input){
        List<String> stringList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int  index = 0;
        while ((index < input.length()) && (input.charAt(index) != '\n')){
            index++;
        }
        stringList.add(input.substring(0, index));
        map.put(input.substring(0,index),0);

        while (index < input.length()){
            int temp = index+1;
            while ((temp < input.length()) && (input.charAt(temp) == '\t')) {
                temp++;
            }
            int level = temp - index - 1;

            int strIndex = temp;
            while ((strIndex < input.length()) && (input.charAt(strIndex) != '\n')){
                strIndex++;
            }
            stringList.add(input.substring(temp, strIndex));
            map.put(input.substring(temp, strIndex), level);

            index = strIndex;
        }

        if(isFile(stringList.get(0))){
            return  stringList.get(0).length();
        }

        Stack<String> stack = new Stack<>();
        stack.push(stringList.get(0));
        int longestPath = 0, totalStringLengthInStack = stringList.get(0).length() + 1;
        for(int i = 1; i < stringList.size(); i++){
            if(isFile(stringList.get(i))){
                String topStr = stack.peek();
                int topLevel = map.get(topStr);
                if(topLevel < map.get(stringList.get(i))) {
                    if (totalStringLengthInStack + stringList.get(i).length() > longestPath) {
                        longestPath = totalStringLengthInStack + stringList.get(i).length();
                    }
                }else {
                    totalStringLengthInStack -= topStr.length();
                    totalStringLengthInStack--;
                    stack.pop();

                    while (!stack.isEmpty()) {
                        String tempStr = stack.peek();
                        int tempLevel = map.get(tempStr);
                        if (tempLevel < map.get(stringList.get(i))) {
                            break;

                        } else {
                            totalStringLengthInStack -= tempStr.length();
                            totalStringLengthInStack--;
                            stack.pop();
                        }
                    }
                    if(stack.isEmpty()){
                        if(longestPath < stringList.get(i).length()){
                            longestPath = stringList.get(i).length();
                        }
                    }else {
                        if(longestPath < totalStringLengthInStack + stringList.get(i).length()){
                            longestPath = totalStringLengthInStack + stringList.get(i).length();
                        }
                    }
                }
            }else {
                String topString = stack.peek();
                int topLevel = map.get(topString);
                if(topLevel < map.get(stringList.get(i))){
                    stack.push(stringList.get(i));
                    totalStringLengthInStack += stringList.get(i).length();
                    totalStringLengthInStack++;
                }else {
                    totalStringLengthInStack -= topString.length();
                    totalStringLengthInStack--;
                    stack.pop();
                        while (!stack.isEmpty()) {
                            String tempStr = stack.peek();
                            int tempLevel = map.get(tempStr);
                            if (tempLevel < map.get(stringList.get(i))) {
                                stack.push(stringList.get(i));
                                totalStringLengthInStack += stringList.get(i).length();
                                totalStringLengthInStack++;
                                break;

                            } else {
                                totalStringLengthInStack -= tempStr.length();
                                totalStringLengthInStack--;
                                stack.pop();
                            }
                        }
                    if (stack.isEmpty()) {
                        stack.push(stringList.get(i));
                        totalStringLengthInStack += stringList.get(i).length();
                        totalStringLengthInStack++;
                    }
                }
            }
        }
        return  longestPath;
    }


    @Test
    public  void  test(){
        //String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        //String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        //String input = "a\n\tb.txt\na2\n\tb2.txt";
        //String input = "a\n\taa\n\t\taaa\n\t\t\tfile1.txt\naaaaaaaaaaaaaaaaaaaaa\n\tsth.png";
        //String input = "dir\n    file.txt";
        //String input = "dir\n        file.txt";
        String input = "a\n\tb\n\t\tc.txt\n\taaaa.txt";
        long startTime = System.currentTimeMillis();
        int result = lengthLongestPath(input);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("runnint time : " + (endTime - startTime));
    }
}
