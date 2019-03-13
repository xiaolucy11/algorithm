package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/20 0020.
 */
public class Solution190 {
    public  int[] IntegerToBinary(int n){
        int[] result = new int[32];
        int index = 31;
        while(n >= 2){
            result[index--] = n % 2;
            n = n / 2;
        }
        result[index] = n;
        return result;
    }

    public  int binaryToInt(int[] binary){
        int sum = 0;
        int mulitply = 1;
        for(int i = binary.length - 1; i >= 0; i--){
            sum += mulitply * binary[i];
            mulitply *= 2;
        }
        return  sum;
    }
    public int reverseBits(int n){
        int[] bit = IntegerToBinary(n);
        int[] temp = new int[32];
        int index = 0;
        for(int i = bit.length - 1; i >= 0; i--){
            temp[index++] = bit[i];
        }
        return  binaryToInt(temp);
    }

    @Test
    public void  test1(){
        //String bit = Integer.toBinaryString(1234);
        //System.out.print(bit);

        int[] bit = IntegerToBinary(2147483647);
        for(int i = 0; i < 32; i++){
            System.out.print(bit[i]);
        }
        System.out.println();
        System.out.print(binaryToInt(bit));


    }

    @Test
    public  void  test2(){
        System.out.print(reverseBits(2147483647));
    }

}
