package interview.easy2;

import org.junit.Test;

import java.util.Vector;

/**
 * Created by Administrator on 2018/7/11 0011.
 */
public class Solution476 {
    public  int[] tobinary(int num){
        Vector<Integer> vector = new Vector<>();
        while(num > 1){
            int mod = num % 2;
            int div = num / 2;
            num = div;
            vector.add(mod);
        }
        vector.add(num);
        int[] result = new int[vector.size()];
        int index = 0;
        for(int i = 0; i < vector.size(); i++){
            result[index++] = vector.get(i);
        }
        return  result;
    }
    public  int computeSum(int[] binary){
        int sum = 0;
        int multiply = 1;
        for(int i = binary.length - 1; i >= 0; i--){
            sum += multiply * binary[i];
            multiply *= 2;
        }
        return  sum;
    }
    public  int findComplement(int num){
        int[] array = tobinary(num);
        for(int i = 0; i < array.length; i++){
            if(array[i] == 1){
                array[i] = 0;
            }else {
                array[i] = 1;
            }
        }
        return  computeSum(array);
    }

    @Test
    public  void  test(){
        /*
        int[] result = tobinary(5);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i]);
        }
        System.out.println();
        System.out.print(computeSum(result));
        */

        System.out.println(findComplement(Integer.MAX_VALUE-1));
    }
}
