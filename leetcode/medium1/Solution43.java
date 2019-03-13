package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/10 0010.
 */
public class Solution43 {

    //Accepted -----78ms
    //Using StringBuilder can decrease running time
    public String multiply(String num1, String num2){
        int length1 = num1.length();
        int length2 = num2.length();
        String[] array = new String[length2];
        for(int i = 0; i < length2; i++){
            array[i] = "";
            int temp = i;
            while (temp > 0){
                array[i] += "0";
                temp--;
            }
        }

        int flag = 0;
        int arrayIndex = 0;
        for(int index2 = length2 - 1; index2 >= 0; index2--){
            flag = 0;
            int value2 = (int)(num2.charAt(index2) - '0');
            for(int index1 = length1 - 1; index1 >= 0; index1--){
                int value1 = (int)(num1.charAt(index1) - '0');
                int sum = value1 * value2  + flag;
                if(sum > 9){
                    flag = sum / 10;
                    sum -= flag * 10;
                    array[arrayIndex] = Integer.toString(sum) + array[arrayIndex];
                }else {
                    flag = 0;
                    array[arrayIndex] = Integer.toString(sum) + array[arrayIndex];
                }
            }
            if(flag != 0){
                array[arrayIndex] = Integer.toString(flag) + array[arrayIndex];
            }
            arrayIndex++;
        }
        int maxLength = array[length2 - 1].length();
        for(int i = 0 ; i< array.length; i++){
            int len = array[i].length();
            int temp = maxLength - len;
            while (temp > 0 ){
                array[i]  = "0" + array[i];
                temp--;
            }
        }

        flag = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(int k = maxLength - 1; k >= 0; k--){
            int sum = 0;
            for(int i = 0; i < length2; i++){
                sum += (int)(array[i].charAt(k) - '0');
            }
            int value = sum + flag;
            if(value > 9){
                flag = value / 10;
                sum = value - flag * 10;
                stringBuilder.append((char)(sum + '0'));
            }else {
                flag = 0;
                stringBuilder.append((char)(value + '0'));
            }
        }
        if(flag > 0){
            stringBuilder.append(flag);
        }
        return  stringBuilder.reverse().toString();
    }

    @Test
    public  void  test(){
        String num1  = "2";
        String num2 = "3";
        String result = multiply(num1, num2);
        System.out.print(result);
    }
}
