package algorithm.medium8;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/10/30.
 */
public class Solution670 {

    //Accepted ----15ms
    /*
        time complexity O(N* long(N))
        it can be optimized,using greedy algoritym,O(N)
     */
    public  int maximumSwap(int num){
        String str = Integer.toString(num);
        int[] arr1 = new int[str.length()];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            int value = (int)(str.charAt(i) - '0');
            arr1[i] = value;
            list.add(value);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * (o1 - o2);
            }
        });

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != arr1[i]){
                int index = list.size() - 1;
                while ((index >= 0) && (arr1[index] != list.get(i))){
                    index--;
                }
                int temp = arr1[i];
                arr1[i] = arr1[index];
                arr1[index] = temp;
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < arr1.length; i++){
            stringBuilder.append(arr1[i]);
        }
        return  Integer.parseInt(stringBuilder.toString());
    }

    @Test
    public  void  test(){
        int num = 2736;
//        int num = 9973;
//        int num = 1993;

        long startTime = System.currentTimeMillis();
        int result = maximumSwap(num);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));

    }
}
