package interview.easy2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/6 0006.
 */
public class Solution343 {
    public  boolean isChar(char ch){
        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')){
            return true;
        }else {
            return false;
        }
    }

    //Accepted ------1ms
    public  int countSegments(String s){
        String[] result = s.split(" ");
        int count = 0;
        for(int i = 0; i < result.length; i++){
            if(result[i].equals("")){
                count++;
            }
            System.out.print(result[i] + " ");
        }
        return  result.length - count;
    }

    @Test
    public  void  test(){
        String s = "hello,,:  my  name is john";
        System.out.print(countSegments(s));
    }
}
