package algorithm.hard2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution282 {
    public  List<String> lists;

    public void  search(String num, int target, StringBuilder stringBuilder,
                        int index){
        if(index == num.length()){
            System.out.println(stringBuilder.toString());
            if(check(num, stringBuilder,target)){
                lists.add(stringBuilder.toString());
            }
            return;
        }

        stringBuilder.append(num.charAt(index));
        if(index == num.length() - 1){
            search(num,target,stringBuilder,index+1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            return;
        }
        stringBuilder.append("+");
        search(num,target,stringBuilder,index+1);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        stringBuilder.append("-");
        search(num,target,stringBuilder,index+1);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        stringBuilder.append("*");
        search(num,target,stringBuilder,index+1);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        search(num,target,stringBuilder,index+1);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

    }

    public  List<String> splitStr(String str){
        List<String> list = new ArrayList<>();
        int start = 0, end = 0;

        while (end < str.length()){
            if(str.charAt(end) >= '0' && str.charAt(end) <= '9'){
                end++;
            }else {
                list.add(str.substring(start,end));
                list.add(Character.toString(str.charAt(end)));
                end++;
                start = end;
            }
        }

        if(start != str.length()){
            list.add(str.substring(start,end));
        }
        return  list;
    }
    public  boolean check(String num,StringBuilder stringBuilder, int target){
        String str = stringBuilder.toString();
        if(num.length() == str.length()){
            return  false;
        }
        List<String> words = splitStr(str);
        Stack<String> stack = new Stack<>();
        int index = 0;

        while (index < words.size()){
            if(words.get(index).equals("*")){
                int value1 = Integer.parseInt(stack.pop());
                if(words.get(index+1).length() > 1 && words.get(index+1).charAt(0) == '0'){
                    return false;
                }
                int value2 = Integer.parseInt(words.get(index+1));
                stack.push(Integer.toString(value1 * value2));
                index += 2;
            }else {
                if(words.get(index).length() > 1 && words.get(index).charAt(0) == '0'){
                    return  false;
                }
                stack.push(words.get(index));
                index++;
            }
        }

        Stack<String> reverseStack = new Stack<>();
        while (!stack.isEmpty()){
            reverseStack.push(stack.pop());
        }

        while (reverseStack.size() != 1){
            int value1 = Integer.parseInt(reverseStack.pop());
            String op = reverseStack.pop();
            int value2 = Integer.parseInt(reverseStack.pop());
            if(op.equals("+")){
                reverseStack.push(Integer.toString(value1 + value2));
            }else {
                reverseStack.push(Integer.toString(value1 - value2));
            }
        }
        int result = Integer.parseInt(reverseStack.pop());
        if (result == target){
            return true;
        }else {
            return false;
        }
    }
    public  int maxValue(String num){
        int result = 1;
        for (int i = 0; i < num.length(); i++){
            int value = num.charAt(i) - '0';
            if(value != 0){
                result *= value;
            }
        }
        return result;
    }


    //not accepted
    /*
        run too slow
     */
    public List<String> addOperators(String num, int target){
        if(maxValue(num) < target){
            return  new ArrayList<>();
        }
        lists = new ArrayList<>();
        search(num, target,new StringBuilder(),0);
        return  lists;
    }

   public  List<String> result;
    public void  search1(String num, int target, String path, int index, long sum, long preMulti){
        if(index == num.length()){
            if(sum == target){
                result.add(path);
            }
            return;
        }
        for(int i = index; i < num.length();i++){
            long value = Long.parseLong(num.substring(index,i+1));
            String subStr = num.substring(index, i+1);
            if(i != index && num.charAt(index) == '0'){
                break;
            }

            if(index == 0){
                search1(num,target, subStr,i+1,value,value);
            }else {
                search1(num,target,path+ "+" + subStr,i+1,sum+value,value);
                search1(num,target,path + "-" + subStr, i+1, sum-value,-1 * value);
                search1(num,target, path + "*" + subStr,i+1,sum - preMulti + preMulti * value,
                        preMulti *value);
            }
        }
    }

    //Accepted ----231ms
    /*
        idea from other
        have tricks in setting preMulti variable
     */
    public List<String> addOperators1(String num, int target){
        result = new ArrayList<>();
        if(num.length() == 0){
            return  result;
        }
        search1(num,target,"",0,0,0);
        return  result;
    }

    @Test
    public  void  test(){
      /* String num = "123";
       int target = 6;*/

      String num = "232";
      int target = 8;

    /* String num = "105";
     int target = 5;*/

   /* String num = "00";
    int target = 0;*/

   /* String num = "123456789";
    int target = 45;*/

       long startTime = System.currentTimeMillis();
       List<String> result = addOperators1(num,target);
       long endTime = System.currentTimeMillis();

       for (int i = 0; i < result.size(); i++){
           System.out.print(result.get(i) + " ");
       }
       System.out.println();
       System.out.println("running time :" + (endTime - startTime));
    }

    @Test
    public  void  test1(){
        StringBuilder sb = new StringBuilder("1+2*3");
        String num = "123";
        int target = 6;
        boolean b = check(num,sb, target);
        System.out.print(b);

    }

}
