package algorithm.medium3;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by youlu on 2018/9/17.
 */
public class Solution318 {
    public  boolean shareCommonLetters(String s, String t){
        Set<Character> set = new TreeSet<>();
        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
        }
        for(int j = 0; j < t.length(); j++){
            if(set.contains(t.charAt(j))){
                return true;
            }
        }
        return  false;
    }


    //Accepted -----1204ms
    /*
        brute solution
        time complexity O(n^2)
     */
    public  int maxProduct(String[] words){
        int length = words.length;
        int[][] matrix = new int[length][length];

        int maxValue = 0;
        for(int i = 0; i < length; i++){
           for(int j = i + 1; j < length; j++){
               if(!shareCommonLetters(words[i], words[j])){
                   int value = words[i].length() * words[j].length();
                   if(value > maxValue){
                       maxValue = value;
                   }
               }
           }
        }
        return  maxValue;
    }

    public  int maxProduct1(String[] words){
        return  0;
    }

    @Test
    public  void  test(){
        String[] words = {"a","ab","abc","d","cd","bcd","abcd"};
        System.out.print(maxProduct(words));
    }
}
