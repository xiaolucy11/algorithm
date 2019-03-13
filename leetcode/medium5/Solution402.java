package algorithm.medium5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by youlu on 2018/9/30.
 */
public class Solution402 {
    //Wrong solution
    public  String removeKdigits(String num,int k){
        if(num.length() == k){
            return "0";
        }
        char[] chars = num.toCharArray();
        int[] array = new  int[chars.length];
        int count = k;
        int pre = 0, index = 1;
        while (count > 0 && index < num.length()){
            if(chars[index] > chars[pre]){
                array[index] = 1;
                count--;
            }else if(chars[index] < chars[pre]) {
                array[pre] = 1;
                pre = index;
                count--;
            }else {
                index++;
                continue;
            }
           index++;
        }

        index = 0;
        while (index < num.length() && array[index] == 1){
            index++;
        }

        while (count > 0){
            if(chars[index] > chars[pre]){
                array[index] = 1;
                count--;
            }else {
                array[pre] = 1;
                pre = index;
                count--;
            }
            index++;
        }

        String result = "";
        for(int i = chars.length - 1; i >= 0; i--){
            if(array[i] == 0) {
                result = Character.toString(chars[i]) + result;
            }

        }
        if(result.charAt(0) == '0'){
            if(result.length() == 1){
                return "0";
            }else {
                return result.substring(1, result.length());
            }
        }else {
            return result;
        }
    }

    //Wrong solution
    /*
        ugly code
        the logic is too complicated
     */
    public  String removeKdigits1(String num,int k){
        if(num.length() == k){
            return "0";
        }
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>();
        int count = k, index = 1;
        String result = "";
        List<Character> list = new ArrayList<>();
        priorityQueue.add(num.charAt(0));

        while (count > 0 && index < num.length()){
                char ch = num.charAt(index);
                if(ch < priorityQueue.peek()){
                    if(list.size() + 1 >= count){
                        count--;
                        while (count > 0){
                            list.remove(list.size()-1);
                            count--;
                        }
                        priorityQueue.add(ch);
                        index++;
                        break;
                    }else {
                        count -= list.size();
                        count--;
                        list.clear();
                        priorityQueue.add(ch);
                    }
                }else if(ch > priorityQueue.peek()){
                    count--;

                }else {
                    list.add(ch);
                }
                index++;
        }



        if(count == 0){
            for(int j = 0; j < list.size();j++){
                if(list.get(j) != 0 ) {
                    result += Character.toString(list.get(j));
                }
            }

            Character topChar = priorityQueue.poll();
            if(!(topChar.equals('0') && (result.length() == 0))) {
                result += Character.toString(topChar);
            }

            while (index < num.length()){
                result += Character.toString(num.charAt(index));
                index++;
            }
        }else {
            Character topChar = priorityQueue.poll();
            if(!topChar.equals('0')) {
                result += Character.toString(topChar);
            }
            for(int i = 0;i < list.size() - count; i++){
                result += Character.toString(list.get(i));
            }
        }

        if(result.length() == 0){
            return  "0";
        }else {
            int noZeroIndex = 0;
            while ((noZeroIndex < result.length()) && (result.charAt(noZeroIndex) == '0')){
                noZeroIndex++;
            }

            if(noZeroIndex == result.length()){
                return "0";
            }else {
                return result.substring(noZeroIndex, result.length());
            }
        }
    }


    public  char[] remove(char[] chars){
        char[] newChars = new char[chars.length-1];
        int index = 0, newCharsIndex = 0;
        int flag = 0;
        while (index < chars.length - 1){
            if(chars[index] <= chars[index+1] ){
                newChars[newCharsIndex++] = chars[index];
                if(index == chars.length - 2){
                    flag = 1;
                    break;
                }else {
                    index++;
                }
            }else {
                index++;
                break;
            }
        }

        if(flag == 0) {
            while (index < chars.length) {
                newChars[newCharsIndex++] = chars[index];
                index++;
            }
        }
        return  newChars;
    }


    //Accepted ------213ms
    /*
        not effecient
     */
    /*
        it can be optimezed, when remove a charcater, not construct new array, can be replaced 'a'
     */
    public  String removeKdigits2(String num,int k){
        if(num.length() == k){
            return "0";
        }
       char[] chars = num.toCharArray();
        int count = k;

        while (count > 0){
            char[] newChars = remove(chars);
            if(newChars[0] != '0') {
                chars = new char[newChars.length];
                for (int i = 0; i < newChars.length; i++) {
                    chars[i] = newChars[i];
                }
            }else {
                int index = 0;
                while ((index < newChars.length) && (newChars[index] == '0')){
                    index++;
                }
                chars = new char[newChars.length - index];
                int copyIndex = 0;
                for(int i = index; i < newChars.length; i++){
                    chars[copyIndex++] = newChars[i];
                }
            }
            count--;
        }

        String result = "";
        for(int i = 0; i < chars.length; i++){
            result += Character.toString(chars[i]);
        }
        if(result.equals("")){
            return "0";
        }else {
            return result;
        }
    }

    @Test
    public  void test(){
       String num = "1432219";
        int k = 3;
      /* String num = "10200";
        int k = 1;*/
     /*String num = "112";
        int k = 2;*/
     /* String num = "1111111";
        int k = 3;*/

   /* String num = "10";
        int k = 1;*/
 /*  String num = "1107";
        int k = 1;*/

  /* String num = "5337";
        int k = 2;*/

        long startTime = System.currentTimeMillis();
        String result = removeKdigits2(num,k);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("runnint time : " + (endTime - startTime));
    }
}
