package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/30 0030.
 */
public class Solution345 {
    public  boolean isVowel(char ch){
        if((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u') || (ch == 'A') || (ch == 'E')|| (ch == 'I') || (ch == 'O') ||(ch == 'U' )){
            return  true;
        }else {
            return  false;
        }
    }
    public String reverseVowels(String s){
        String vowelsString = "";
        for(int i = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                vowelsString += s.charAt(i);
            }
        }
        vowelsString = new StringBuffer(vowelsString).reverse().toString();
        int index = 0;
        char[] charString = s.toCharArray();
        for(int i = 0; i < charString.length; i++){
            if(isVowel(charString[i])){
                charString[i] = vowelsString.charAt(index);
                index++;
            }
        }
        return  new String(charString);
    }

    public  String reverseVowels1(String s){
        char[] charString = s.toCharArray();
        int left = 0, right = charString.length - 1;
        while(left < right){
            while((left < right) && (!isVowel(charString[left]))){
                left++;
            }
            while((left < right) && (!isVowel(charString[right]))){
                right--;
            }
            //because terminal condition is left == right
            if(left < right){
                char tmp = charString[left];
                charString[left] = charString[right];
                charString[right] = tmp;
            }
            left++;
            right--;
        }
        return new String(charString);
    }
    @Test
    public void test(){
        String s = "leetcode";
        System.out.print(reverseVowels1(s));
    }
}
