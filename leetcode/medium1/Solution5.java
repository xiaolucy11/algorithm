package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/7 0007.
 */
public class Solution5 {
    public  boolean isPalindrome(String s, int start, int end){
        if(start == end){
            return  true;
        }
        int left = start, right = end;
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return  false;
            }
            left++;
            right--;
        }
        return  true;

    }
    //Acceoted ---- 141ms , O(n*2)
    public String longestPalindrome(String s){
        if(s.length() == 0 || s.length() == 1){
            return  s;
        }
        String result = "";
        for(int i = 0; i < s.length(); i++){
            int end = s.length() - 1;
            while (end > i){
                if(isPalindrome(s, i, end)){
                    break;
                }else {
                    end--;
                }
            }
            if(end - i + 1 > result.length()){
                result = s.substring(i, end + 1);
            }
        }
        return result;
    }

   /* public  String help(String s, int start, int end){
        if(start == end){
            return  Character.toString(s.charAt(start));
        }
        if(isPalindrome(s, start,end)){
            return s.substring(start, end+1);
        }
        String left = help(s, start, end - 1);
        String right = help(s, start + 1, end);
        if(left.length() >= right.length()){
            return left;
        }else {
            return  right;
        }
    }*/

   private  int extend(String s, int start, int end){
       while ((start >= 0) && (end < s.length())){
           if(s.charAt(start) == s.charAt(end)){
               start--;
               end++;
           }else {
               break;
           }
       }
       return  end - start - 1;
   }

   //reference from others
    public String longestPalindrome1(String s){
        if(s.length() == 0 || s.length() == 1){
            return  s;
        }

        int start = 0, end = 0;
        int maxValue = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = extend(s, i, i);
            int len2 = extend(s, i, i+1);
            int max = Math.max(len1, len2);
            if(max > maxValue){
                maxValue = max;
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
        }


        //part reference from others
        public String longestPalindrome2(String s){
            if(s.length() == 0 || s.length() == 1){
                return  s;
            }
            int length = s.length();
            int maxValue = 0;
            int start = 0, end = 0;

            //真正作用是存储所有的子字符串
            int[][] dp = new int[length][length];

            for(int i = 0; i < length; i++){
                for(int j = 0; j <= i; j++){
                    if(s.charAt(j) == s.charAt(i) &&(i - j <= 2 || dp[j+1][i-1] == 1)) {
                        dp[j][i] = 1;

                        if (i - j + 1 > maxValue) {
                            maxValue = i - j + 1;
                            start = j;
                            end = i;
                        }
                    }
                }
            }
            return  s.substring(start, end+1);
        }



    @Test
    public  void  test(){
        String  s= "aaaaa";
        String result = longestPalindrome2(s);
        for(int i = 0; i < result.length(); i++){
            System.out.print(result.charAt(i) + " ");
        }
    }
}
