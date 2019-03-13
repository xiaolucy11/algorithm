package interview.easy;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/6 0006.
 */
public class Solution38 {
    public String countAndSay(int n){
        if(n <= 0){return "";}
        if(n ==1) {return "1";}
        String output = countAndSay(n-1);
        String result = "";
        int index = 0;
        while(index < output.length()){
            char temp = output.charAt(index);
            int j = index;
            int count = 0;
            //important code in computing count in sequence
            while( (j < output.length()) &&(output.charAt(j) == temp)){
                j++;
                count++;
            }
            index = j;
            result = result + (char)(count + '0');
            result = result + temp;
        }
        return result;
    }

    @Test
    public void test(){
        String result = countAndSay(10);
        System.out.println(result);
    }
}
