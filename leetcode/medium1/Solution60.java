package interview.medium1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2018/8/12 0012.
 */
public class Solution60 {
    public  boolean find(String str, char ch){
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ch){
                return true;
            }
        }
        return  false;
    }
    public  void  generate(List<String> lists, String str, char[] chars){
        if(str.length() == chars.length){
            lists.add(str);
            System.out.println("str : " + str);
        }else {
            for(int i = 0; i < chars.length; i++){
                if(!find(str, chars[i])){
                    String temp = str + Character.toString(chars[i]);
                    generate(lists, temp, chars);
                }
            }
        }

    }

    //Time Limit Exceed, not need to compute all permutation
    public String getPermutation(int n, int k){
        char[] chars = new char[n];
        for(int i = 0; i < n; i++){
            chars[i] = (char)(i + 1 + '0');
        }

        List<String> lists = new ArrayList<>();
        for(int i = 0; i < n; i++){
            generate(lists, Character.toString(chars[i]), chars);
        }
        //Collections.sort(lists);
        return lists.get( k-1);
    }

    public  int fib(int n){
        if(n == 0){
            return  0;
        }
        if(n == 1){
            return  1;
        }else {
            return n * fib(n - 1);
        }
    }

    public  int totalCount(int num, int length){
        return (num - 1) * fib(length);
    }

    public  void  find(List<Integer> list, StringBuilder str, int k, int length){
        if(length == 0){
            return;
        }
        for(int i = list.size() - 1; i >= 0; i--){
            int value = totalCount(i+1, length - 1);
            if(value < k){
               str = str.append((char)(list.get(i) + '0'));
                k = k - value;
                list.remove(i);
                find(list, str,k, length - 1);
                return;
            }else if(value == k){
                int index1 = i - 1;
                str = str.append((char)(list.get(index1) + '0'));
                int index2 = list.size() - 1;
                while (index2 >= 0){
                    if(index1 != index2){
                        str = str.append((char)(list.get(index2) + '0'));
                    }
                    index2--;
                }
                return;
            }else {
                continue;
            }
        }
    }

    //Accepted -------9ms
    public String getPermutation1(int n, int k){
        StringBuilder result = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        find(list, result, k, n);
        return  result.toString();

    }

    @Test
    public  void  test(){
        String result = getPermutation1(4,9);
        System.out.println(result);

    }
}
