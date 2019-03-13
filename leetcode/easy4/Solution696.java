package interview.easy4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2018/7/27 0027.
 */
public class Solution696 {
    public  int minContinueValue(String s){
        int minContinue = Integer.MIN_VALUE;

        int slow = 0, quick = 0;
        while (quick < s.length()){
            if(s.charAt(slow) == s.charAt(quick)){
                quick++;
            }else {
                if(quick - slow  > minContinue){
                    minContinue = quick - slow;
                }
                slow = quick;
                quick++;
            }
        }
        return  minContinue;
    }
    public  List<String> produceStr(int count){
        List<String > list = new ArrayList<>();
        while ( count > 0){
            String str1 = "";
            String str2 = "";
            for(int i = 0; i < count; i++){
                str1 += Character.toString('0');
                str2 += Character.toString('1');
            }
            for(int i = 0; i < count; i++){
                str1 += Character.toString('1');
                str2 += Character.toString('0');
            }
            list.add(str1);
            list.add(str2);
            count--;
        }
        return  list;
    }

    public  int countMatch(String s, String t){
        int indexS = 0, indexT = 0;
        int count = 0;
        while(indexS < s.length()){
            if(s.charAt(indexS) == t.charAt(indexT)){
                int temp = indexS;
                while(temp < s.length() && indexT < t.length()){
                    if(s.charAt( temp) == t.charAt(indexT)){
                        temp++;
                        indexT++;
                    }else {
                        break;
                    }
                }
                if(indexT == t.length()){
                    count++;
                    indexS = temp;
                    indexT = 0;
                }else {
                    indexS++;
                    indexT = 0;
                }

            }else {
                indexS++;
                indexT = 0;
            }
            if(indexT == t.length()){
                count++;
                indexT = 0;
            }
        }
        return  count;
    }
    public  boolean sameChar(String s)
    {
        for(int i  = 1; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(0)){
                return  false;
            }
        }
        return  true;
    }

    // Time limited exceed
    public  int countBinarySubString(String s) {
        int minContinue = minContinueValue(s);

        List<String > list = produceStr(minContinue);

        int result = 0;
        for(int i = 0; i < list.size(); i++){
            result += countMatch(s, list.get(i));
        }
        return  result;
    }

    //Accepted ------19ms
    public  int countBinarySubString1(String s){
        int subLength = 0;
        int count = 0;
        int slow = 0, quick = 0;
        while (quick < s.length()){
            if(s.charAt(slow) == s.charAt(quick)){
                quick++;
            }else {
                if(slow == 0 ){
                    subLength = quick - slow;
                    slow = quick;
                    quick++;
                    continue;
                }
                count += Math.min(quick - slow, subLength);
               /* if(quick - slow > 1 && subLength > 1){
                    count += Math.max(quick - slow, subLength);
                }else {
                    count += 1;
                }*/
                subLength = quick - slow;
                slow = quick;
                quick++;
            }

        }
        if(slow == 0){
            return  0;
        } else{
            count += Math.min(quick - slow, subLength);
           /* if( subLength > 1){
                if(quick - slow > 1) {
                    count += Math.min(quick - slow, subLength);
                }else {
                    count += 1;
                }
            }else {
                count += 1;
            }*/
        }
        return  count;
    }

    @Test
    public void  test(){
        String s = "100111001";
        System.out.println(countBinarySubString1(s));
    }
}
