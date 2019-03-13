package interview.easy3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/15 0015.
 */
public class Solution520 {
    public  boolean isUpperChar(char ch){
        if((ch >= 'A') && (ch <= 'Z')){
            return  true;
        }else {
            return  false;
        }
    }

    //Accepted
    public  boolean detectCapitalUse(String word){
        if(word.length() == 1){return  true;}

        if(isUpperChar(word.charAt(0)) && isUpperChar(word.charAt(1))){
            for(int index1 = 2;  index1 < word.length(); index1++){
                if(!isUpperChar(word.charAt(index1))){
                    return  false;
                }
            }
            return  true;
        }else if(isUpperChar(word.charAt(0)) && !isUpperChar(word.charAt(1))){
            for(int index2 = 2; index2 < word.length(); index2++){
                if(isUpperChar(word.charAt(index2))){
                    return  false;
                }
            }
            return  true;
        }else if(!isUpperChar(word.charAt(0)) && !isUpperChar(word.charAt(1))){
            for(int index3 = 2; index3 < word.length(); index3++){
                if(isUpperChar(word.charAt(index3))){
                    return  false;
                }
            }
            return  true;
        }else {
            return  false;
        }
    }

    @Test
    public  void  test(){
        String word = "FlaG";
        System.out.print(detectCapitalUse(word));
    }

}
