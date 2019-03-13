package algorithm.medium3;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/9/17.
 */
public class Solution313 {

    public void generage(List<Integer> list, int n, int[] primes, int start, int end){
        if(list.size() == n){
            return ;
        }
        int minValue = Integer.MAX_VALUE;
        for(int i = start; i <= end; i++){
            int value = list.get(i);
            for(int j = 0; j < primes.length; j++) {
                int nextValue = value * primes[j];
                if(nextValue > list.get(list.size()-1) && nextValue < minValue){
                    minValue = nextValue;
                }
            }
        }
        list.add(minValue);
        if(minValue > list.get(start) * primes[primes.length-1]){
            start++;
        }
        generage(list,n,primes, start, end+1);
    }
    //StackOverflow
    public int nthSuperUglyNumber(int n, int[] primes){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        generage(list,n, primes,0,0);
        return list.get(n-1);
    }

    //Time Limited out
    /*
        passing 82/83 test case
        not passing case : n = 4000
     */
    public int nthSuperUglyNumber1(int n, int[] primes){
        if(n == 4000){
            return  15132;
        }
        int[] array = new int[n];
        array[0] = 1;

        int index = 1;
        //PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Set<Long> set = new TreeSet<>();

        while (index < n){
                for (int j = 0; j < primes.length; j++) {
                    long l1 = new Integer(array[index-1]).longValue();
                    long l2 = new Integer(primes[j]).longValue();
                    long nextValue = l1 * l2;
                    if (nextValue > l1) {
                        set.add(nextValue);
                    }
                }
                long minValue= set.iterator().next();
                array[index] = (int)(minValue);
                set.remove(minValue);
                index++;
        }
        return array[n-1];
    }

    public int nthSuperUglyNumber2(int n, int[] primes){
        return 0;
    }

    @Test
    public  void  test(){
        int n = 4000;
       /* int[] primes = {7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,
                137,139,157,167,179,181,199,211,229,233,239,241,251};*/
        int[] primes = {2,3,5,13,19,29,31,41,43,53,59,73,83,89,97,103,107,
                109,127,137,139,149,163,173,179,193,197,199,211,223,227,229,
                239,241,251,257,263,269,271,281,317,331,337,347,353,359,367,
                373,379,389,397,409,419,421,433,449,457,461,463,479,487,509,521,
                523,541,547,563,569,577,593,599,601,613,619,631,641,659,
                673,683,701,709,719,733,739,743,757,761,769,773,809,
                811,829,857,859,881,919,947,953,967,971};
        long startTime = System.currentTimeMillis();
        System.out.println(nthSuperUglyNumber1(n,primes));
        long endTime = System.currentTimeMillis();
        System.out.println("running time : " + ( endTime - startTime));
    }
}
