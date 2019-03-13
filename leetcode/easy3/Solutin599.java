package interview.easy3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/21 0021.
 */
public class Solutin599 {
    //Accepted -----17ms
    public  String[] findRestaurant(String[] list1, String[] list2){
        Map<String, Integer> map1 = new HashMap<>();

        List<String > list = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        for(int i = 0; i < list1.length; i++){
            map1.put(list1[i], i);
        }
        for (int j = 0; j < list2.length; j++){
            if(map1.containsKey(list2[j])){
                if(map1.get(list2[j]) + j < minIndexSum){
                    minIndexSum = map1.get(list2[j]) + j;
                    list.clear();
                    list.add(list2[j]);
                }else  if(map1.get(list2[j]) + j == minIndexSum){
                    list.add(list2[j]);
                }else {

                }
            }
        }
        String[] result = new String[list.size()];
        int index = 0;
        for(int i = 0; i < list.size(); i++){
            result[index++] = list.get(i);
        }
        return  result;
    }

    @Test
    public  void  test(){
        String[] list1 = {"Shogun","Tapioca Express","Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        String[] result = findRestaurant(list1, list2);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
