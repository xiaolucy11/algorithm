package algorithm.medium10;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by youlu on 2018/11/30.
 */
public class Solution841 {


    //Accepted ----4ms
    /*
        bfs
     */
    public  boolean canVisitAllRooms(List<List<Integer>> rooms){
        int[] arr = new int[rooms.size()];
        arr[0] = 1;
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < rooms.get(0).size(); i++){
            queue.add(rooms.get(0).get(i));
        }

        while (!queue.isEmpty()){
            int roomId = queue.poll();
            if(arr[roomId] == 0){
                for(int i = 0; i < rooms.get(roomId).size(); i++){
                    queue.add(rooms.get(roomId).get(i));
                }

                arr[roomId] = 1;
            }
        }

        for(int j = 0; j < arr.length; j++){
            if(arr[j] == 0){
                return  false;
            }
        }
        return  true;
    }

    @Test
    public  void  test(){
       /* List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        rooms.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        rooms.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        rooms.add(list3);

        List<Integer> list4 = new ArrayList<>();
        rooms.add(list4);*/


       List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        rooms.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(0);
        list2.add(0);
        rooms.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        rooms.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(0);
        rooms.add(list4);

        long startTime = System.currentTimeMillis();
        boolean b = canVisitAllRooms(rooms);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + b);
        System.out.println("running time : " + (endTime - startTime));


    }
}
