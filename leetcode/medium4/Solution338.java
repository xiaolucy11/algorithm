package algorithm.medium4;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/21.
 */
public class Solution338 {
    public  int getBits(int num){
        int number = 0;
        while (num > 1){
            number++;
            num /= 2;
        }
        if(num == 1){
            return  number + 1;
        }else {
            return number;
        }
    }

    //Accepted ----4ms
    public  int[] countBits(int num){
        int bitsNumber = getBits(num);
        int[] bits = new int[bitsNumber +1];
        int[] array = new int[num+1];

        bits[0] = 1;
        for(int i = 1; i <= bitsNumber; i++){
            bits[i] = bits[i-1] * 2;
        }

        array[0] = 0;
        int index = 0;
        for(int i = 1; i < array.length; i++){
            if(i == bits[index]){
                array[i] = 1;
                index++;
            }else if(i < bits[index]){
                int val = i - bits[index-1];
                array[i] = array[val] + array[bits[index-1]];
            }else {

            }
        }
        return  array;
    }

    @Test
    public  void test(){
        int num = 3;
        int[] array = countBits(num);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
