package algorithm.medium9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by youlu on 2018/11/6.
 */
public class Solution735 {

    //Accepted ----396ms
    /*
        it can be optimize, worst time complexity O(n^2),but it can be optimized to O(n)
     */
    public  int[] asteroidCollision(int[] asteroids){

        while (true){
            int leftPositive = -1;
            int flag = 0;
            for(int i = 0; i < asteroids.length; i++){
                if(asteroids[i] == 0){
                    continue;
                }else if(asteroids[i] > 0){
                    leftPositive = i;
                }else {
                    if(leftPositive == -1){
                      continue;
                    }else {
                        if(asteroids[leftPositive] == Math.abs(asteroids[i])){
                            asteroids[leftPositive] = 0;
                            asteroids[i] = 0;
                        }else if(asteroids[leftPositive]  < Math.abs(asteroids[i])){
                            asteroids[leftPositive] = 0;
                        }else {
                            asteroids[i] = 0;
                        }
                        flag = 1;
                        break;
                    }
                }
            }

            if(flag == 0){
                break;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] != 0){
                list.add(asteroids[i]);
            }
        }

        int[] result = new int[list.size()];
        int index = 0;
        for(int i = 0; i < list.size(); i++){
            result[index++] = list.get(i);
        }

        return  result;
    }


    //Accepted ----25ms
    /*
        time complextiy O(n)
     */
    public  int[] asteroidCollision1(int[] asteroids){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] > 0){
                stack.add(i);
            }else if(asteroids[i] < 0){
                while (!stack.isEmpty()){
                    int top = stack.peek();
                    if(asteroids[top] < Math.abs(asteroids[i])){
                        asteroids[top] = 0;
                        stack.pop();
                    }else if(asteroids[top] > Math.abs(asteroids[i])){
                        asteroids[i] = 0;
                        break;
                    }else {
                        asteroids[top] = 0;
                        asteroids[i] = 0;
                        stack.pop();
                        break;
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] != 0){
                list.add(asteroids[i]);
            }
        }

        int[] result = new int[list.size()];
        int index = 0;
        for(int i = 0; i < list.size(); i++){
            result[index++] = list.get(i);
        }

        return  result;
    }

    @Test
    public  void  test(){
        int[] asteroids = {5,10,-5};
//        int[] asteroids = {8,-8};
 //       int[] asteroids = {10,2,-5};
//        int[] asteroids = {-2,-1,1,2};
 //       int[] asteroids = {-2,-2,1,-2};

        long startTime = System.currentTimeMillis();
        int[] result = asteroidCollision1(asteroids);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + "  ");
        }

        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }

}
