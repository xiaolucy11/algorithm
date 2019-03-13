package interview.easy3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/17 0017.
 */
public class Solution557 {
    public  String reversedWords(String s){
        String[] words = s.split(" ");
        String result = "";
        for(int i = 0; i < words.length; i++){
            if(i != words.length - 1){
                result += new StringBuilder(words[i]).reverse().toString() + " ";
            }else {
                result += new StringBuilder(words[i]).reverse().toString() ;
            }
        }
        return  result;
    }

    @Test
    public  void  test(){
        String s = "Let's take Leetcode contest";
        System.out.print(reversedWords(s));
    }
}
