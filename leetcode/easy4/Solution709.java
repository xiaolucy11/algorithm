package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/29 0029.
 */
public class Solution709 {

    //Accepted -----1ms
    public String toLowerCase(String str){
       char[] charArray = str.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            char ch = charArray[i];
            if(ch >= 'A' && ch <= 'Z'){
                charArray[i] = (char) (ch - 'A' + 'a');
            }
        }
        return  new String(charArray);
    }

    @Test
    public  void  test(){
        String str = "heLLo";
        System.out.print(toLowerCase(str));
    }
}
