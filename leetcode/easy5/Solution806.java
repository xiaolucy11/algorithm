package interview.easy5;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/2 0002.
 */
public class Solution806 {
    //Accepted ----3ms
    public  int[] numberOfLines(int[] widths, String S){
        int lineNumber = 1;
        int  currentWidth = 0;
        for(int i = 0; i < S.length(); i++){
            int width = widths[S.charAt(i) - 'a'];
            if(currentWidth + width > 100){
                lineNumber++;
                currentWidth = width;
            }else {
                currentWidth += width;
            }
        }
        int[] result = new int[2];
        result[0] = lineNumber;
        result[1] = currentWidth;
        return  result;
    }

    @Test
    public  void  test(){
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String S = "bbbcccdddaaa";
        int[] result =  numberOfLines(widths, S);
        System.out.println(result[0] + " : " + result[1]);
    }
}
