package algorithm.medium4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by youlu on 2018/9/26.
 */
public class Solution386 {
    //Accepted --- 985ms
    /*
        not effecient
     */
    public List<Integer> lexicalOrder(int n){
        List<String> stringList = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            stringList.add(Integer.toString(i));
        }
        Collections.sort(stringList);

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < stringList.size(); i++){
            list.add(Integer.parseInt(stringList.get(i)));
        }
        return list;
    }

    public  int compareList(List<Integer> list1, List<Integer> list2){
        int length1 = list1.size();
        int length2 = list2.size();
        int len = Math.min(length1, length2);

        int index = 0;
        while (index < len){
            if(list1.get(index) > list2.get(index)){
                return  1;
            }else if(list1.get(index) < list2.get(index)){
                return -1;
            }else {
                return 0;
            }
        }

        if(index == length1){
            return -1;
        }else {
            return 1;
        }
    }

    public List<Integer> numberToList(int num){
        List<Integer> list = new ArrayList<>();
        while (num > 9){
            int mod = num % 10;
            int div =  num / 10;
            list.add(mod);
            num = div;
        }
        list.add(num);
        Collections.reverse(list);
        return list;
    }


    public List<Integer> lexicalOrder1(int n){
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = Integer.toString(o1);
                String str2 = Integer.toString(o2);
                if(str1.compareTo(str2) > 0){
                    return 1;
                }else if(str1.compareTo(str2) == 0){
                    return  0;
                }else {
                    return -1;
                }
            }
        });

        return list;
    }


    public  void  generate(List<Integer> list, int value, int n){
        if(value <= n){
            list.add(value);
        }
        if(value * 10 <= n){
            generate(list, value * 10, n);
            int number = value * 10;
            for(int i = 1; i < 10; i++){
                if(number + i <= n){
                    generate(list, number+i, n);
                }
            }

        }
    }

    //Accepted ----- 110ms
    /*
        trackBacking algorithm
     */
    public List<Integer> lexicalOrder2(int n){
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i < 10; i++) {
            generate(list, i, n);
        }

        return  list;
    }


    @Test
    public  void  test(){
        int n = 1;
        long startTime = System.currentTimeMillis();
        List<Integer> result = lexicalOrder2(n);
        long endTime = System.currentTimeMillis();
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
        System.out.println();
        System.out.println("size of result : " + result.size());
        System.out.println("runnint time : " + (endTime - startTime));
    }
}
