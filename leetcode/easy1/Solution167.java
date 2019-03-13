package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/18 0018.
 */
public class Solution167 {
    public int[] towSum(int[] numbers, int target){
        int i = 0;
        int[] result = new int[2];
        while(i < numbers.length){
            int j = i + 1;
            while (j < numbers.length){
                if(numbers[i] + numbers[j] == target){
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return  result;
                }
                j++;
            }
            i++;
        }
        return  result;
    }

    @Test
    public void  test(){
        int[] input = new int[]{2,7,11,15};
        int[]  result = towSum(input, 9);
        System.out.print(result[0] + "    :   " + result[1]);
    }
}
