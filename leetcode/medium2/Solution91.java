package interview.medium2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/31 0031.
 */
public class Solution91 {

    public  int count;
    public  int[] stringToArray(String s){
        int length = s.length();
        int[] array = new int[length];
        for(int i = 0; i < length; i++){
            array[i] = (int)(s.charAt(i) - '0');
        }

        return  array;
    }


    //Accepted ------1ms
    // dp algorithm
    public  int numDecodings(String s){
        if(s == null || s.charAt(0) == '0'){
            return 0;
        }
        int length = s.length();
        int[] nums = stringToArray(s);
        int[]  result = new int[s.length() + 1];
        result[1] = 1;
        for(int i = 1; i < s.length(); i++){
            int value = 10 * nums[i-1] + nums[i];
            if(nums[i] == 0){
                if(value == 0 || value > 26){
                    return 0;
                }else {
                    if(i > 1) {
                        result[i + 1] = result[i-1];
                    }else {
                        result[i+1] = result[i];
                    }
                }
                continue;
            }
            if(value == nums[i]){
                result[i+1] = result[i];
                continue;
            }
            if(value <= 26){
                if(i > 1) {
                    result[i + 1] = result[i] +  result[i-1];
                }else {
                    result[i+1] = result[i] + 1;
                }
            }else {
                result[i+1] = result[i];
            }
        }
        return  result[length];
    }

    public  int search(int[] nums, int index){
        if(index < 0){
            return 1;
        }
        int count1 = 0;
        if(nums[index] != 0){
            count1 = search(nums, index-1);
        }
        int count2 = 0;
        if(index - 1 >= 0){
            int value = 10 * nums[index-1] + nums[index];
            if(value <= 26 && value != nums[index]){
                count2 = search(nums, index-2);
            }
        }
        return  count1 + count2;
    }

    //Accepted ---------506ms
    // no effecience
    public  int numDecodings1(String s){
        if(s == null || s.charAt(0) == '0'){
            return 0;
        }

        int length = s.length();
        int[] nums = stringToArray(s);
        for(int i = 1; i < length; i++){
            int value = 10 * nums[i-1] + nums[i];
            if(nums[0] == 0 && ( value == 0 || value > 26)){
                return 0;
            }
        }
        return  search(nums, length-1);
    }

    @Test
    public  void  test(){
        String s = "1212";
        System.out.print(numDecodings(s));
    }
}
