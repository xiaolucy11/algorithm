package algorithm.medium3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/9/14.
 */
public class Solution279 {
    public  int result ;
    public void  search(List<Integer> squares,int index,List<Integer> list,int sum){
        if(sum > 0 && list.size() >= result){
            return;
        }
        if(sum < 4){
            if(list.size() + sum < result){
                result = list.size() + sum;
            }
            return;
        }
        if(sum == 4){
            if(result > list.size() + 1) {
                result = list.size() + 1;
            }
            return;
        }
        for(int i = index; i >= 0; i--) {
            if (sum >= squares.get(i)) {
                list.add(squares.get(i));
                search(squares, i, list, sum - squares.get(i));
                list.remove(list.size() - 1);
            }
        }
    }
    //Accepted -----58ms
    public  int numSquares(int n){
        result = Integer.MAX_VALUE;
        int number = (int)Math.sqrt(n);
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= number; i++){
            list.add(i*i);
        }
        search(list,list.size() - 1,new ArrayList<>(), n);
        return result;
    }

    public  boolean isSquare(int n){
        int number = (int) Math.sqrt(n);
        if(number * number == n){
            return true;
        }else {
            return  false;
        }
    }


    //Accepted ----40ms
    /*
        dp algorithm
     */
    public  int numSquares1(int n){
        int[] array = new int[n+1];
        for(int i = 1; i <= n; i++){
            if(isSquare(i)){
                array[i] = 1;
            }else {
                int number = (int)Math.sqrt(i);
                int minValue = Integer.MAX_VALUE;
                int index = 2;
                while (index <= number){
                    int res = array[i - index * index];
                    if(res < minValue){
                        minValue = res;
                    }
                    index++;
                }
                if(minValue != Integer.MAX_VALUE) {
                    array[i] = minValue + 1;
                }else {
                    array[i] = array[i-number*number] + 1;
                }
            }
        }
        return array[n];
    }

    @Test
    public  void  test(){
        int n = 13;
        System.out.print(numSquares1(n));
    }
}
