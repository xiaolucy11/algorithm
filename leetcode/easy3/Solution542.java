package interview.easy3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/16 0016.
 */
public class Solution542 {

    //Accepted ------385ms
    public  String reverseStr(String s, int k){
        if(s.length() <= k){return  new StringBuilder(s).reverse().toString();}
        StringBuilder result = new StringBuilder();
        int flag = 1, start = 0, end = 0;
        while (start + k < s.length()){
            if(flag % 2 == 1){
                end = start + k-1;
                while( end >= start){
                   result.append(s.charAt(end));
                    end--;
                }
                start += k;
                flag++;
            }else {
                end = start;
                while (end < start + k){
                    result.append(s.charAt(end));
                    end++;
                }
                start += k;
                flag++;
            }
        }
        if(flag % 2 == 1){
            end = s.length() - 1;
            while (end >= start){
                result.append(s.charAt(end));
                end--;
            }
        }else {
            end = start;
            while (end < s.length()){
                result.append(s.charAt(end));
                end++;
            }
        }
        return  result.toString();
    }

    @Test
    public  void  test(){
        String s = "abcdefg";
        System.out.print(reverseStr(s, 2));
    }
}
