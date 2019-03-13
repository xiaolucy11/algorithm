package algorithm.medium9;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by youlu on 2018/11/7.
 */
public class Solution739 {


    //Accepted --- 65ms
    /*
        time complexity O(n)
     */
    public  int[] dailyTemperatures(int[] T){
        Stack<Integer> stack = new Stack<>();
        int[] arr = new  int[T.length];
        for(int i = 0; i < T.length; i++){
            while (!stack.isEmpty()){
                int top = stack.peek();
                if(T[top] < T[i]){
                    arr[top] = (i - top);
                    stack.pop();
                }else {
                    break;
                }
            }
                stack.push(i);
        }

        while (!stack.isEmpty()){
            int index = stack.pop();
            arr[index] = 0;
        }

        return  arr;
    }


    @Test
    public  void  test(){
        int[] T = {73,74,75,71,69,72,76,73};

        int[] arr = dailyTemperatures(T);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "  ");
        }
    }
}
