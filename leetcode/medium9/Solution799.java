package algorithm.medium9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/11/16.
 */
public class Solution799 {


    //Accepted ---39ms
    /*
        dp algorithm
     */
    public  double champagneTower(int poured, int query_row, int query_glass){
        List<double[]> lists = new ArrayList<>();
       double[] arr0 = new double[1];
        arr0[0] = poured;;
        lists.add(arr0);
        int index = 0;
        while (true){
            int flag = 0;
            double[] currentArr = lists.get(index);
            double[] nextArr = new  double[lists.get(index).length + 1];
            for(int i = 0; i < lists.get(index).length; i++){
                if(currentArr[i] > 1){
                    flag = 1;
                    nextArr[i] += (currentArr[i] - 1) / 2;
                    nextArr[i+1] += (currentArr[i] - 1) / 2;
                    currentArr[i] = 1.0;
                }
            }
            if(flag != 0){
                lists.add(nextArr);
                index++;
                if(lists.size() > 100){
                    break;
                }
            }else {
                break;
            }
        }
        if(query_row >= lists.size()){
            return 0.0;
        }else if(query_glass >= lists.get(query_row).length){
            return  0.0;
        }else {
            return lists.get(query_row)[query_glass];
        }
    }

    @Test
    public  void  test(){
      /*  int poured = 2;
        int query_class = 1;
        int query_row = 1;*/

      int poured = 100000000;
        int query_row = 99;
        int query_class = 99;

        long startTime = System.currentTimeMillis();
        double result = champagneTower(poured, query_row, query_class);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }

}
