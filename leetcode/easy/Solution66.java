package interview.easy;

import org.junit.Test;

import java.util.Vector;

/**
 * Created by Administrator on 2018/6/7 0007.
 */
public class Solution66 {
    public int[] plusOne(int[] digits){
        int sum = 0;
        int multi = 1;
        for(int i = digits.length -1; i >= 0; i--){
            sum += multi * digits[i];
            multi *= 10;
        }
        sum += 1;
        Vector<Integer> vec = new Vector<>();
        while(sum >= 10){
            int a = sum % 10;
            sum = sum / 10;
            vec.add(a);
        }
        vec.add(sum);
        int[] result = new int[vec.size()];
        int index = 0;
        for(int i = vec.size() -1; i >= 0; i--){
            result[index++] = vec.get(i);
        }
        return result;
    }
    @Test
    public void test(){
        int[] digit = new int[]{9,8,7,6,5,4,3,2,1,0};
        int[] result = plusOne(digit);

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }

    }
    public int[] plusOne2(int[] digits){
        if((digits.length == 1) && (digits[digits.length - 1] < 9)){
            digits[digits.length - 1]++;
            return digits;
        }else if ((digits.length == 1) && (digits[digits.length - 1] == 9)){
            int[] result1 = new int[2];
            result1[0] = 1;
            result1[1] = 0;
            return result1;
        }else if(digits[digits.length - 1] < 9){
            digits[digits.length - 1 ]++;
            return digits;
        }
        int[] temp = new int[digits.length - 1];
        for(int i = 0; i < digits.length - 1; i++){
            temp[i] = digits[i];
        }
        int[] tempResult = plusOne2(temp);
        int[] result = new int[tempResult.length + 1];
        for(int k = 0; k < tempResult.length; k++){
            result[k] = tempResult[k];
        }
        result[result.length - 1] = 0;
        return  result;


    }
    @Test
    public void  test2(){
        //int[] digit = new int[]{9,8,7,6,5,4,3,2,1,0};
        int[] digit = new int[]{4,3,2,1};
        int[] result = plusOne2(digit);

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
