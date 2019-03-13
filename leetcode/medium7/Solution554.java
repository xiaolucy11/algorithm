package algorithm.medium7;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/10/19.
 */
public class Solution554 {
    public  boolean find(List<List<Integer>> store, int index,int value){
        for(int j = 0; j < store.get(index).size(); j++){
            if(store.get(index).get(j) == value){
                return  true;
            }
        }

        return  false;
    }


    //Accepted -----48ms
    /*
        count result can be replaced by wall.size - map.get(mostFrequcyKey)
     */
    public  int leastBricks(List<List<Integer>> wall){
        List<List<Integer>> store = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int bricksTotalLength = 0;
        for(int i = 0; i < wall.get(0).size(); i++){
            bricksTotalLength += wall.get(0).get(i);
        }
        for(int i = 0; i < wall.size(); i++){
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < wall.get(i).size(); j++){
                sum += wall.get(i).get(j);
                list.add(sum);
                map.put(sum, map.getOrDefault(sum,0) +1);
            }
            store.add(list);
        }

        int mostFrequcy = 0, mostFrequcyKey = 0;
        for(Integer key: map.keySet()){
            if(map.get(key) > mostFrequcy && key != bricksTotalLength){
                mostFrequcy = map.get(key);
                mostFrequcyKey = key;
            }
        }

        if(mostFrequcy == 0){
            return  wall.size();
        }
        int count = 0;
        for(int i = 0; i < store.size(); i++){
            if(!find(store, i, mostFrequcyKey)){
                count++;
            }
        }

        return count;
    }



    @Test
    public  void  test1(){
        List<List<Integer>> wall = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,2,1));
        List<Integer> list2  = new ArrayList<>(Arrays.asList(3,1,2));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(1,3,2));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(2,4));
        List<Integer> list5 = new ArrayList<>(Arrays.asList(3,1,2));
        List<Integer> list6 = new ArrayList<>(Arrays.asList(1,3,1,1,1));
        wall.add(list1);
        wall.add(list2);
        wall.add(list3);
        wall.add(list4);
        wall.add(list5);
        wall.add(list6);

        long startTime = System.currentTimeMillis();
        int result = leastBricks(wall);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }

    @Test
    public  void  test2(){
        List<List<Integer>> wall = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(1));
        wall.add(list1);
        wall.add(list2);
        wall.add(list3);

        long startTime = System.currentTimeMillis();
        int result = leastBricks(wall);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
