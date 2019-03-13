package algorithm.hard3;

import org.junit.Test;

public class Solution517 {
    private int sum(int[] machines, int start, int end){
        int res = 0;
        for(int i = start; i <= end; i++){
            res += machines[i];
        }
        return  res;
    }

    private  int findMax(int[] machines,  int start, int end){
        int max = -1, index = -1;
        for(int i = start; i <= end; i++){
            if(machines[i] > max){
                index = i;
            }
        }
        return index;
    }

    private  void partion(int[] machines, int start, int end){
        if(start > end){
            return;
        }
        int maxIndex = findMax(machines,start,end);
        if(maxIndex == start){
            int moveStep = machines[maxIndex] - sum(machines,start,end) / (end - start + 1);
            minStep += moveStep;
            machines[maxIndex + 1] += minStep;
            partion(machines,maxIndex + 1, end);
        }else if(maxIndex == end){
            int moveStep = machines[maxIndex] - sum(machines,start,end) / (end - start + 1);
            minStep += moveStep;
            machines[maxIndex - 1] += minStep;
            partion(machines,start, maxIndex-1);
        }else {
            int avg = sum(machines,start, end) / (end - start + 1);
            int moveStep = machines[maxIndex] - avg;
            minStep += moveStep;
            int leftStep = avg * (maxIndex - start ) - sum(machines,start, maxIndex - 1);
            int rightStep = avg * (end - maxIndex) - sum(machines,maxIndex + 1, end);
            machines[maxIndex - 1] += leftStep;
            machines[maxIndex + 1] += rightStep;
            partion(machines,start, maxIndex - 1);
            partion(machines,maxIndex + 1, end);
        }
    }

    public  int minStep;

    //Wrong Solution
    public  int findMinMoves(int[] machines){
        int s = sum(machines,0, machines.length - 1);
        if(s == 0){
            return 0;
        }
        int div = s / machines.length;
        if(div * machines.length != s){
            return -1;
        }

        minStep = 0;
        partion(machines,0,machines.length - 1);
        return  minStep;
    }

    public  int findMinMoves1(int[] machines){
        return 0;
    }


    @Test
    public  void  test(){
        int[] machines = {1,0,5};

        long startTime = System.currentTimeMillis();
        int result  = findMinMoves(machines);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
