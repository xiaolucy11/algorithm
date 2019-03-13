package algorithm.medium3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/9/13.
 */
public class Solution241 {

    public  void  help(List<Integer> list , List<String> stringList){
        if(stringList.size() == 1){
            list.add(strToSum(stringList.get(0)));
            return;
        }
        if(stringList.size() == 2){
            list.add(strToSum(stringList.get(1)) * (-1));
        }

        for(int i = 0; i < stringList.size() - 2; i++){
            if(!stringList.get(i).equals("+") &&
                    !stringList.get(i).equals("-") &&
                    !stringList.get(i).equals("*") &&
                    !stringList.get(i).equals("/")){
                int value1 = strToSum(stringList.get(i));
                String operation = stringList.get(i+1);
                int value2 = strToSum(stringList.get(i+2));
                String computeResult = "";
                if(operation.equals("-")){
                    computeResult = Integer.toString(value1 - value2);
                }else if(operation.equals("+")){
                    computeResult = Integer.toString(value1 + value2);
                }else if(operation.equals("*")){
                    computeResult = Integer.toString(value1 * value2);
                }else {
                    computeResult = Integer.toString(value1 / value2);
                }
                List<String> temp = new ArrayList<>();
                temp.addAll(stringList);
                temp.remove(i);
                temp.remove(i);
                temp.remove(i);

                temp.add(i, computeResult);
                help(list, temp);
            }
        }
    }

    public  boolean isDigit(char ch){
        if((ch >= '0') && (ch <= '9')){
            return  true;
        }
        return  false;
    }

    public int toSum(String s){
        int sum = 0;
        int multuply = 1;
        int length = s.length();

        for(int i = length - 1; i >= 0; i--){
            int number = (int)(s.charAt(i) - '0');
            sum += multuply * number;
            multuply *= 10;
        }
        return  sum;
    }

    public int strToSum(String s){
        if(s.charAt(0) == '-'){
            return toSum(s.substring(1,s.length())) * -1;
        }else {
            return  toSum(s);
        }
    }

    public List<Integer> diffWaysToCompute(String output){
        List<Integer> list = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        int length = output.length();
        int index = 0;
        while (index < length){
            if(!isDigit(output.charAt(index))){
                stringList.add(Character.toString(output.charAt(index)));
                index++;
                continue;
            }

            int nextIndex = index;
            while ((nextIndex < length) && (isDigit(output.charAt(nextIndex)))){
                nextIndex++;
            }
            String subStr = output.substring(index, nextIndex);
            int value = strToSum(subStr);
            stringList.add(Integer.toString(value));
            index = nextIndex;
        }
        help(list, stringList);
        return list;
    }

    @Test
    public  void  test(){
        String output = "2*3-4*5";
        List<Integer> result = diffWaysToCompute(output);

        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
    }
}
