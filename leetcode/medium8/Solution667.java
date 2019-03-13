package algorithm.medium8;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/29.
 */
public class Solution667 {
    //Accepted ----3ms
    public int[] constructArray(int n, int k){
        int[] arr = new int[n];
        int left = 1, right = k + 1;
        int index = 0;
        int flag = 0;
        while (index < k + 1){
            if(flag == 0){
                arr[index++] = left;
                left++;
                flag = 1;
            }else {
                arr[index++] = right;
                right--;
                flag = 0;
            }
        }

        for(int i = k + 2; i <= n; i++){
            arr[index++] = i;
        }
        return  arr;
    }

    @Test
    public  void  test(){
        int n = 6;
        int k = 2;
        int[] result = constructArray(n,k);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + "  ");
        }
        System.out.println();
    }
}
