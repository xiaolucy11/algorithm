package algorithm.medium5;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/28.
 */
public class Solution393 {
    public  int[] integerToBits(int n){
        int[] arr = new int[8];
        int index = 7;
        while (n > 1){
            int mod = n % 2;
            int div = n / 2;
            arr[index--] = mod;
            n = div;
        }
        arr[index] = n;
        return  arr;
    }

    public  int computeOneBits(int[] arr){
        int count = 0;
        int index = 0;
        while (index < arr.length){
            if(arr[index] == 1){
                count++;
                index++;
            }else {
                break;
            }
        }

        return  count;
    }


    public  boolean check(int[] arr){
        if(arr[0] == 1 && arr[1] == 0){
            return  true;
        }else {
            return  false;
        }
    }

    //Wrong Solution
    public  boolean validUtf8(int[] data){
        int[][] binaryArray = new int[data.length][8];
        for(int i = 0; i < data.length; i++){
            binaryArray[i] = integerToBits(data[i]);
        }

        int oneBits = computeOneBits(binaryArray[0]);
        int count = oneBits;
        if(binaryArray.length == 1 ){
            if(oneBits == 0){
                return  true;
            }else {
                return  false;
            }
        }
        if(oneBits > 4){
            return  false;
        }


        count--;
        for(int i = 1; i < oneBits && i < binaryArray.length ; i++){
            if(check(binaryArray[i])){
                count--;
            }
        }

        if(count != 0){
            return  false;
        }
        for(int i = oneBits; i < binaryArray.length; i++){
            if(binaryArray[i][0] != 0){
                return  false;
            }
        }
        return  true;
    }

    public boolean help(int[][] binaryArray, int index){
        if(index == binaryArray.length){
            return  true;
        }
        int oneBits = computeOneBits(binaryArray[index]);
        if(oneBits == 0){
            return  help(binaryArray, index+1);
        }else if(oneBits == 1){
            return false;
        } else {
            if(index + oneBits  >  binaryArray.length || oneBits > 4){
                return false;
            }
            for(int i = index + 1; i < index + oneBits; i++){
                if(!check(binaryArray[i])){
                    return  false;
                }
            }
            return  help(binaryArray, index + oneBits);
        }
    }

    //Accepted ---- 17ms
    /*
        the problem described is not clear
     */
    public  boolean validUtf8_1(int[] data){
        int[][] binaryArray = new int[data.length][8];
        for(int i = 0; i < data.length; i++){
            binaryArray[i] = integerToBits(data[i]);
        }
        return  help(binaryArray,0);
    }


    @Test
    public  void  test(){
        int n = 197;
        int[] arr = integerToBits(n);
        for(int i = 0; i < 8; i++){
            System.out.print(arr[i] + " ");
        }
    }

    @Test
    public  void  test1(){
        //int[] data = {197,130,1};
        //int[] data = {235,140,4};
        //int[] data = {10};
        //int[] data = {145};
        //int[] data = {240,162,138,147,145};
        int[] data = {250,145,145,145,145};
        //int[] data = {240,162,138,147,17};
        //int[] data = {228,189,160,229,165,189,13,10};
        //int[] data = {255};
        long startTime = System.currentTimeMillis();
        System.out.println(validUtf8_1(data));
        long endTime = System.currentTimeMillis();
        System.out.println("runnint time : " + (endTime - startTime));
    }
}
