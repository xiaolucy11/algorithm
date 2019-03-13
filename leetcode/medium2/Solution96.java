package interview.medium2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/9/1 0001.
 */
public class Solution96 {
    public  int generate(int[] nums, int start, int end){
        if(end < 0 || start >= nums.length || start > end){
            return 0;
        }
        if(start == end){
            return 1;
        }

        int count = 0;
        for(int i = start; i <= end; i++){
            int leftValue = generate(nums, start, i-1);
            int rightValue = generate(nums, i+1, end);
            if(leftValue != 0 && rightValue != 0){
                count += leftValue * rightValue;
            }else if(leftValue != 0){
                count += leftValue;
            }else if(rightValue != 0){
                count += rightValue;
            }else {
                count += 0;
            }
        }
        return  count;
    }

    //Time limited out
    public  int numTrees(int n){
        int[] array = new int[n+1];
        for(int i = 1; i <= n; i++){
            array[i] = i;
        }
        return  generate(array, 1, n);
    }


    //Accepted -------0ms
    public  int numTrees1(int n){
        if(n == 1){
            return  1;
        }
        if(n == 2){
            return 2;
        }
        int[] array = new int[n + 1];
        int[] result = new int[n+1];
        array[1] = 1;
        array[2] = 2;

        for(int i = 3; i < n+1; i++){
            int count = 0;
            for(int index = 1; index <= i; index++){
                int leftLength = index - 1;
                int rightLength = i - index;
                if(leftLength != 0 && rightLength != 0) {
                    count += array[leftLength] * array[rightLength];
                }else if(leftLength != 0){
                    count += array[leftLength];
                }else if(rightLength != 0){
                    count += array[rightLength];
                }else {
                    count += 0;
                }
            }
            array[i] = count;
        }
        return  array[n];

    }

    @Test
    public  void  test(){
        int n = 9;
        System.out.print(numTrees1(n));
    }
}
