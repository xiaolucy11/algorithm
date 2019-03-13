package interview.easy1;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2018/6/23 0023.
 */
public class Solution225 {
    private Queue<Integer> q1;
    private  Queue<Integer> q2;

    public  void  Solution225(){
        q1 = new ConcurrentLinkedQueue<>();
        q2 = new ConcurrentLinkedQueue<>();
    }

    public  void push(int x ) {
        q1.add(x);
    }

    public int pop(){
        while(q1.size() != 1){
            int temp1 = q1.poll();
            q2.add(temp1);
        }
        int result = q1.poll();
        while (!q2.isEmpty()){
            int temp2 = q2.poll();
            q1.add(temp2);
        }

        return  result;
    }

    public  int top(){
        while (q1.size() != 1){
            int value1 = q1.poll();
            q2.add(value1);
        }
        int result = q1.poll();
        while (!q2.isEmpty()){
            int value2 = q2.poll();
            q1.add(value2);
        }
        q1.add(result);
        return  result;
    }
    public  boolean empty(){
        return  q1.isEmpty();
    }


    @Test
    public  void test(){
        Solution225();
        push(1);
        push(4);
        push(6);
        int pop1 = pop();
        int top1 = top();
        int pop2 = pop();
        System.out.print(pop2);
    }
}
