package algorithm.medium5;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/4.
 */
public class Solution424 {
    //Accepted ------400ms
    /*
        not effecient
     */
    public int characterReplacement(String s, int k){
        int slow = 0, quick = 0;
        int count = 0;
        int maxLength = 0;
        int firstDifferentIndex = 0;

        while (quick < s.length()){
            if(s.charAt(slow) == s.charAt(quick)){
                quick++;
            }else {
                count++;
                if(count == 1){
                    firstDifferentIndex = quick;
                }
                if(count > k){
                    if(quick - slow > maxLength ) {
                        maxLength = quick - slow;
                    }
                        slow = firstDifferentIndex;
                        quick = slow;
                        count = 0;
                }else {
                    quick++;
                }
            }
        }

        int lastLength = 0;
        int value = k - count;
        if(slow  >= value ){
            lastLength = quick - slow + value;
        }else {
            lastLength = quick;
        }
        return  Math.max(maxLength,lastLength);
    }

    @Test
    public  void  test(){
        String s = "ABAB";
        int k = 2;
      /* String s = "AABABBA";
        int k = 1;*/
       /* String s = "ABBB";
        int k = 2;*/
        long startTime = System.currentTimeMillis();
        int result = characterReplacement(s, k);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("runnint time : " + (endTime - startTime));

    }
}
