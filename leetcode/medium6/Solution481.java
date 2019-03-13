package algorithm.medium6;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/11.
 */
public class Solution481 {

    //Accepted --- 48ms
    public  int magicalString(int n){
        if(n <= 0){
            return 0;
        }
        if(n <= 3){
            return  1;
        }

        StringBuilder stringBuilder1 = new StringBuilder("122");
        StringBuilder stringBuilder2 = new StringBuilder("122");
        int index2 = 2;
        while (stringBuilder2.length() <= n){
           int value = (int)(stringBuilder2.charAt(index2) - '0');
            if(stringBuilder1.charAt(stringBuilder1.length() - 1) == '2'){
                if(value == 1){
                    stringBuilder1.append('1');
                    stringBuilder2.append('1');
                }else {
                    stringBuilder1.append('1');
                    stringBuilder1.append('1');
                    stringBuilder2.append('1');
                    stringBuilder2.append('1');
                }
            }else {
                if(value == 1){
                    stringBuilder1.append('2');
                    stringBuilder2.append('2');
                }else {
                    stringBuilder1.append('2');
                    stringBuilder1.append('2');
                    stringBuilder2.append('2');
                    stringBuilder2.append('2');
                }
            }
            index2++;
        }

        System.out.println("s : " + stringBuilder2);
        int count = 0;
        for(int i = 0; i < n; i++){
            if(stringBuilder2.charAt(i) == '1'){
                count++;
            }
        }
        return  count;
    }

    @Test
    public  void  test(){
        int n = 7;
        long startTime = System.currentTimeMillis();
        int result = magicalString(n);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
