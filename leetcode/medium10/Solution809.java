package algorithm.medium10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/11/18.
 */
public class Solution809 {
    public  class  Pair{
        char ch;
        int count;
        Pair(char _ch, int _count){
            ch = _ch;
            count = _count;
        }
    }

    public List<Pair> construct(String str){
        int index = 0;
        List<Pair> list = new ArrayList<>();
        while (index < str.length()){
            int temp = index + 1;
            while ((temp < str.length()) && (str.charAt(temp) == str.charAt(index))){
                temp++;
            }
            Pair p = new Pair(str.charAt(index), temp - index);
            list.add(p);
            index = temp;
        }

        return  list;
    }

    public  boolean compare(List<Pair> list1, List<Pair> list2){
        if(list1.size() != list2.size()){
            return  false;
        }

        for(int i = 0; i < list1.size(); i++){
            if(list1.get(i).ch != list2.get(i).ch){
                return  false;
            }else {
                if(list2.get(i).count > list1.get(i).count){
                    return  false;
                }
                if(list2.get(i).count < list1.get(i).count && list1.get(i).count < 3){
                    return  false;
                }
            }
        }

        return  true;
    }

    //Accepted ---5ms
    public  int expressiveWords(String S, String[] words){
        List<Pair> sList = construct(S);
        int sum = 0;
        for(int i = 0; i < words.length; i++){
            List<Pair> queryList = construct(words[i]);
            if(compare(sList, queryList)){
                sum++;
            }
        }

        return  sum;
    }

    @Test
    public  void  test(){
        String  S = "heeellooo";
        String[] words = {"hello","hi","helo"};

        long startTime = System.currentTimeMillis();
        int result = expressiveWords(S, words);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
