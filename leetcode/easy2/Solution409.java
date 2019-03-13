package interview.easy2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/5 0005.
 */
public class Solution409 {

    //Accepted -----7ms
    public int longestPalindrome(String s){
        int[] charsArray = new int[52];
        int count1 = 0, count2 = 0;
        int count11 = 0;
        int index = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                 index = s.charAt(i) - 'A';
            }else {
                index = s.charAt(i) - 'a' + 26;
            }
            charsArray[index]++;
        }
        for(int j = 0; j < 52; j++){
            if(charsArray[j] == 0 ){continue;}
            else if(charsArray[j] % 2 == 0){
                count2 += charsArray[j];
            } else {
                count1 += charsArray[j] - 1;
                count11++;
            }
        }
        if(count2 > 0 && count11 >= 1) {
            return count2 + count1 + 1;
        }else if(count2 == 0){
            return  count1 + 1;
        }else {
            return count2 + count1;
        }
    }

    @Test
    public void  test(){
        String str = "b";
        System.out.print(longestPalindrome(str));
    }
}
