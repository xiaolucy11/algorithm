package algorithm.medium9;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by youlu on 2018/11/12.
 */
public class Solution781 {

    //Accepted ---4ms
    /*
        time complextity O(nlog(n))

        it can be optimized,using hashmap, time complexity O(n)
     */
    public  int numRabbits(int[] answers){
        if(answers.length == 0){
            return 0;
        }
        Arrays.sort(answers);
        int sum = 0;
        int index = 0;

        while ((index < answers.length) && (answers[index] == 0)){
            sum++;
            index++;
        }

        if(index == answers.length){
            return  sum;
        }
        sum += answers[index] + 1;
        int flagIndex = index;
        index++;
        for(int i = index; i < answers.length; i++){
            if((answers[i] != answers[flagIndex]) || (
                    answers[i] == answers[flagIndex] && i - flagIndex  > answers[flagIndex]
                    )){
                sum += answers[i] + 1;
                flagIndex = i;
            }
        }

        return  sum;
    }


    @Test
    public  void  test(){
//        int[] answer = {1,1,2};
//        int[] answer = {10,10,10};
//        int[] answer = {1,0,1,0,0};
//        int[] answer = {0,0,0,1,0};
//         int[] answer = {0,0,1,1,1};
        int[] answer = {2,4,4,0,4,4,4,3,0,0};

        long startTime =System.currentTimeMillis();
        int result = numRabbits(answer);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
