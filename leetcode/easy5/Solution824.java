package interview.easy5;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/3 0003.
 */
public class Solution824 {
    public  String convert(String str, int index){
        String aStr = "";
        for(int i = 1; i <= index; i++){
            aStr += Character.toString('a');
        }

        String result = "";
        if((str.charAt(0) == 'a')|| (str.charAt(0) == 'e') || (str.charAt(0) == 'i') ||
                (str.charAt(0) == 'o') || (str.charAt(0) == 'u') || (str.charAt(0) == 'A') || (str.charAt(0) == 'E') ||
                (str.charAt(0) == 'I') || (str.charAt(0) == 'O' ) || (str.charAt(0) == 'U')){
            result += str;
            result += "ma";
        }else {
            result += str.substring(1, str.length());
            result += Character.toString(str.charAt(0));
            result += "ma";
        }

        result += aStr;
        return  result;
    }

    //Accepted ----10ms
    public String  toGoalLatin(String S){
        String[] words = S.split(" ");
        String result = "";

        for(int i = 0; i < words.length; i++){
            result += convert(words[i], i+1);
            if(i != words.length - 1){
                result += " ";
            }
        }
        return  result;
    }

    @Test
    public  void  test(){
        String  S = "The quick brown fox jumped over the lazy dog";
        System.out.print(toGoalLatin(S));
    }

}
