package interview.easy;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/10 0010.
 */
public class Solution88 {
    public void merge(int[] num1, int m, int[] num2, int n){
        int index1 = 0, index2 = 0;
        int[] num1Copy = new int[m];
        for(int i = 0; i < m; i++){
        num1Copy[i] = num1[i];
        }
        int index = 0;
        while((index1 < m) && (index2 < n)){
            if(num1Copy[index1] < num2[index2]){
                num1[index++] = num1Copy[index1];
                index1++;
            }
            else{
                num1[index++] = num2[index2];
                index2++;
            }
        }
        while(index1 < m){
            num1[index++] = num1Copy[index1];
            index1++;
        }
        while (index2 < n){
            num1[index++] = num2[index2];
            index2++;
        }
        for(int j = 0; j < n+m; j++){
            System.out.print(num1[j] + " ");
        }
    }

    @Test
    public  void  test(){
        int[] num1 = new int[20];
        int[] num2 = new int[3];
        num1[0] = 1;
        num1[1] = 2;
        num1[2] = 3;
        num2[0] = 2;
        num2[1] = 5;
        num2[2] = 6;
        merge(num1, 3, num2, 3);
    }
}
