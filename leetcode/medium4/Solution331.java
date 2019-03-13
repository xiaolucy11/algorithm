package algorithm.medium4;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by youlu on 2018/9/19.
 */
public class Solution331 {
    /*
        Srong solution
     */
    public  boolean isValidSerialization(String preorder){
        if(preorder.length() == 1){
            if(preorder.charAt(0) == '#'){
                return  true;
            }else {
                return  false;
            }
        }
        int strLength = preorder.length();
        char[] chars = new char[strLength ];
        int index = 0;
        for(int i = 0; i < strLength; i++){
            if(preorder.charAt(i) != ','){
                chars[index++] = preorder.charAt(i);
            }
        }

        int endToStartIndex = index - 1;
        if(chars[endToStartIndex] != '#' || endToStartIndex < 1 || chars[endToStartIndex - 1] != '#'){
            return false;
        }
        while (endToStartIndex >= 0){
            if(chars[endToStartIndex] != '#'){
                endToStartIndex--;
            }else {
                if(endToStartIndex - 1 >= 0 && chars[endToStartIndex - 1] != '#'){
                    endToStartIndex -= 2;
                }else if(endToStartIndex - 2 >= 0 && chars[endToStartIndex - 1] == '#'
                        && chars[endToStartIndex - 2] != '#'){
                    endToStartIndex -= 3;
                }else {
                    return  false;
                }
            }
        }
        return  true;
    }

    /*
        Wrong solution
     */
    public  boolean isValidSerialization1(String preorder){
            if(preorder.length() == 0){
                return  true;
            }
        if(preorder.length() == 1){
            if(preorder.charAt(0) == '#'){
                return  true;
            }else {
                return  false;
            }
        }
            if(preorder.length() > 1 && preorder.charAt(0) == '#'){
                return  false;
            }

        int strLength = preorder.length();
        String[] words = preorder.split(",");

        int startIndex = 0;
        int rootIndex = 0;
        Stack<String> stack = new Stack<>();
        stack.push(words[startIndex]);
        while (startIndex < words.length){

            if(rootIndex == startIndex){
                startIndex++;
                continue;
            }else if(startIndex - rootIndex == 1){
                if(!words[startIndex].equals("#")) {
                    rootIndex = startIndex;
                }
            }else if(startIndex - rootIndex == 2) {
                if(!words[startIndex].equals("#")) {
                    rootIndex = startIndex;
                }
            }else if(startIndex - rootIndex > 2) {
                rootIndex = startIndex;
            }
            startIndex++;

            if(words[rootIndex].equals("#")) {
                if(rootIndex == words.length - 1) {
                    return true;
                }
            }
        }

        if(words[rootIndex].equals("#")  && startIndex - rootIndex == 3) {
            return true;
        }else {
            return  false;
        }

    }


    /*
        Wrong Solution
     */
    public  boolean isValidSerialization2(String preorder){
        if(preorder.length() == 0){
            return  true;
        }
        if(preorder.length() == 1){
            if(preorder.charAt(0) == '#'){
                return  true;
            }else {
                return  false;
            }
        }
        if(preorder.length() > 1 && preorder.charAt(0) == '#'){
            return  false;
        }

        Stack<String> stack = new Stack<>();
        String[] words = preorder.split(",");
        int wordsLength = words.length;
        int index = 1;
        stack.push(words[0]);

        while (!stack.isEmpty()){
            String temp = stack.pop();
            if(!temp.equals("#")){

                if(index +1 < wordsLength) {
                    stack.push(words[index +1 ]);
                }else {
                    return  false;
                }

                if(index  < wordsLength) {
                    stack.push(words[index ]);
                }else {
                    return  false;
                }

                index += 2;
            }else {
                index++;
            }
        }

        if(index >= wordsLength || (index == wordsLength - 1 && words[index].equals("#"))){
            return  true;
        }else {
            return  false;
        }
    }


    public  boolean judge(String[] words, int start, int end){
        if(end - start == 4){
            if((words[end].equals("#") && words[end-1].equals("#") && words[end-2].equals("#")
                    && !words[end-3].equals("#") && !words[end-4].equals("#")) ||
                    (words[end].equals("#") && words[end-1].equals("#") && !words[end-2].equals("#")
                    && (!words[end].equals("#") && !words[end-4].equals("#")))){
                return  true;
            }else {
                return  false;
            }
        }
        if(end - start == 2){
            if(words[end].equals("#") && words[end-1].equals("#") &&
                    !words[start].equals("#")){
                return  true;
            }else {
                return  false;
            }
        }

        return  false;
    }

    public  class  Pair{
        String str;
        int count;
        Pair(String _str, int _count){
            str = _str;
            count = _count;
        }
    }

    //Accepted -----16ms
    /*
        code is writed too complexly, but the logic is simple
        the code need to be refactored
     */
    public  boolean isValidSerialization3(String preorder){
        if(preorder.length() == 0){
            return  true;
        }
        if(preorder.length() == 1){
            if(preorder.charAt(0) == '#'){
                return  true;
            }else {
                return  false;
            }
        }
        if(preorder.length() < 4){
            return  false;
        }
        if(preorder.length() > 1 && preorder.charAt(0) == '#'){
            return  false;
        }

        String[] words = preorder.split(",");
        int wordsLength = words.length;
        int index = 1;
        Stack<Pair> stack = new Stack<>();
        Pair firt = new Pair(words[0],0);
        stack.push(firt);
        while (index + 2 < wordsLength){
            if(!words[index].equals("#")){
                if(words[index+1].equals("#") && words[index+2].equals("#"))
                    {
                       if(stack.isEmpty()){
                           if(index + 2 == wordsLength-1){
                               return  true;
                           }else {
                               return false;
                           }
                        }else {
                            Pair pair = stack.peek();
                            if(pair.count == 1){
                                stack.pop();
                            }else {
                                Pair p =stack.pop();
                                p.count++;
                                stack.push(p);
                        }
                    }
                    index += 3;
                }else {
                    if (stack.isEmpty()){
                        return  false;
                    }
                    Pair insertPair = new Pair(words[index],0);
                    if(!stack.isEmpty()) {
                        Pair root = stack.peek();
                        if(root.count == 1){
                            stack.pop();
                        }else {
                            Pair p = stack.pop();
                            p.count++;
                            stack.push(p);
                        }
                    }
                    stack.push(insertPair);
                    index++;
                }
            }else {
                    if(stack.isEmpty()){
                        return  false;
                    }
                    Pair p = stack.peek();
                    if(p.count == 1){
                        stack.pop();
                    }else {
                        Pair root = stack.pop();
                        root.count++;
                        stack.push(root);
                    }
                index++;
                }
        }

        if(stack.isEmpty() && index < wordsLength){
            return  false;
        }
        if(index >= wordsLength){
            return  true;
        }else  if(index +1 == wordsLength){
            if(words[index].equals("#")){
                return  true;
            }else {
                return  false;
            }
        }else {
            if(words[index].equals("#") && words[index+1].equals("#")){
                return  true;
            }else {
                return  false;
            }
        }
    }

    @Test
    public  void  test(){
        //String preorder =  "2,#,7,#,#,9,1,2,#,#,#";
        // String preorder = "9,#,93,#,9,9,#,#,#";
        //String preorder = "2,0,#,2,#,#,#,2,9,#,6,#,#";
        //String preorder = "9,9,9,19,#,9,#,#,#,9,#,69,#,#,#";

        //String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        //String preorder = "1,#,#,1";
        //String preorder = "1,#,#,#,#";
        //String preorder = "9,#,92,#,#";
       String preorder = "0,0,7,3,#,2,5,#,#,#,7,9,#,#,#,#,#,7,7,#,4,#,4,2,#,#,8,#,#";
        System.out.print(isValidSerialization3(preorder));
    }
}
