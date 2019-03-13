package interview.medium3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2018/9/9 0009.
 */

public class Solution179 {

    //Accepted ------21ms
    public String largestNumber(int[] nums){
        if(nums.length == 0){
            return "";
        }
        List<String> list = new ArrayList<>();
        int length = nums.length;
        for(int i = 0; i < length; i++){
            list.add(Integer.toString(nums[i]));
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;

                int length = str1.length();
                for(int i = 0; i < length; i++){
                    if(str1.charAt(i) > str2.charAt(i)){
                        return 1;
                    }else if(str1.charAt(i) < str2.charAt(i)){
                        return -1;
                    }else {

                    }
                }
                return 0;
            }
        });

        if(list.get(length-1).equals("0")){
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = length-1; i >= 0; i--){
           // System.out.print(list.get(i) + " ");
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }

    @Test
    public  void  test(){
       int[] nums = {10 ,2 };
        System.out.print(largestNumber(nums));
    }

    @Test
    public  void  test1(){
        String o1 = "3";
        String o2 = "30";
        String str1 = o1 + o2;
        String str2 = o2 + o1;
        System.out.print(str1.compareTo(str2));
    }
}
