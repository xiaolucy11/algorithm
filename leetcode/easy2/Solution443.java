package interview.easy2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/8 0008.
 */
public class Solution443 {
    public  int compress(char[] chars){
        int start = 0, end = 0, pre = 0;
        int count1 = 0; // record number of very character
        int count2  = 0; // record total character in the end
        while(end < chars.length){
            if(chars[start] == chars[end]){
                end++;
            }else {
                if(end - start == 1){
                    chars[pre++] = chars[start];
                    count2++;
                    start = end;
                }else {
                    count1 = end - start;
                    String str1 = Integer.toString(count1);
                    count2 += Integer.toString(count1).length();
                    count2++;
                    int index = 0;
                    chars[pre++] = chars[start];
                    while(index < str1.length()){
                        chars[pre++] = str1.charAt(index);
                        index++;
                    }
                    start = end;
                }
            }
        }
        if(end - start > 1) {
            String str2 = Integer.toString(end - start);
            chars[pre++] = chars[start];
            int index2 = 0;
            while(index2 < str2.length()){
                chars[pre++] = str2.charAt(index2);
                index2++;
            }
            count2 += Integer.toString(end - start).length();
        }else {
            chars[pre++] = chars[start];
        }
        count2++;
        // set character in the end to '\0'
        for (int i = pre; i < chars.length;i++){
            chars[i] = '\0';
        }
        // used to print and debuging
        for(int j = 0; j < chars.length; j++){
            System.out.print(chars[j] + "  ");
        }
        System.out.print("\n");
        return  count2;
    }

    @Test
    public  void  test(){
        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        System.out.print(compress(chars));
    }
}
