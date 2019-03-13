package algorithm.medium9;

import org.junit.Test;

/**
 * Created by youlu on 2018/11/6.
 */
public class Solution738 {

    //Accepted -----15ms
    public  int monotoneIncreasingDigits(int N){
        char[] chars = Integer.toString(N).toCharArray();
        int index = 0;
        while (index < chars.length){
            if((index + 1 < chars.length) &&
                    (chars[index] <= chars[index+1])){
                index++;
            }else {
                break;
            }
        }
        if(index == chars.length - 1 ){
            return  Integer.parseInt(new String(chars));
        }else if(index == 0){
            chars[0] = (char)(chars[0] - '0' - 1 + '0');
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            if(chars[0] == '0'){
                i++;
            }else {
                stringBuilder.append(chars[i]);
                i++;
            }
            while (i < chars.length){
                stringBuilder.append(9);
                i++;
            }

            return  Integer.parseInt(stringBuilder.toString());
        }else {
            int left = index;
            while (left > 0){
                if(chars[left] >= chars[left-1] + 1){
                    break;
                }else {
                    left--;
                }
            }
            chars[left] = (char)(chars[index] - '0' - 1 + '0');
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j <= left; j++){
                temp.append(chars[j]);
            }
            for(int j = left + 1; j < chars.length; j++){
                temp.append('9');
            }
            return  Integer.parseInt(temp.toString());
        }
    }


    @Test
    public void  test(){
//        int N = 10;
//        int N = 1234;

        int N = 332;
//        int N = 120;
        long startTime = System.currentTimeMillis();
        int result = monotoneIncreasingDigits(N);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
