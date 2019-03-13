package interview.easy2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/6 0006.
 */
public class Solution415 {
    public String addString(String num1, String num2){
        String result = "";
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        int prePlus = 0;
        while((index1 >= 0) && (index2 >= 0)){
            int value1 = num1.charAt(index1) - '0';
            int value2 = num2.charAt(index2) - '0';
            if(value1 + value2 + prePlus < 10){
                result = (char)(value1 + value2 + prePlus + '0') + result;
                prePlus = 0;
            }else {
                result = (char)(value1 + value2 + prePlus - 10 + '0' ) + result;
                prePlus = 1;
            }
            index1--;
            index2--;
        }
        while(index1 >= 0){
            int v1 = num1.charAt(index1) - '0';
            if(v1 + prePlus < 10) {
                result = (char)(v1 + prePlus + '0') + result;
                prePlus = 0;
            }else {
                result = (char)(v1 + prePlus - 10 + '0') + result;
                prePlus = 1;
            }
            index1--;
        }

        while (index2 >= 0){
            int v2 = num2.charAt(index2) - '0';
            if(v2 + prePlus < 10){
            result = (char)(v2 + prePlus + '0') + result;
                prePlus = 0;
            }else {
                result = (char)(v2 + prePlus - 10 + '0') + result;
                prePlus = 1;
            }
            index2--;
        }

        if(prePlus != 0) {
            result = (char) (prePlus + '0') + result;
        }
        return  result;
    }

    @Test
    public void test(){
        String num1 = "1";
        String num2 = "9";
        System.out.print(addString(num1, num2));
    }
}
