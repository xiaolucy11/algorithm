package algorithm.medium10;

import javafx.scene.effect.SepiaTone;
import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/11/22.
 */
public class Solution817 {
    public class  ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public  int search(Map<Integer, Integer> map,Map<Integer,Integer> positionMap,
                       int[] arr,int[] G, int index){
        if(!map.containsKey(G[index]) || !positionMap.containsKey(map.get(G[index]))){
            arr[index] = 1;
            return  1;
        }
        int count = 0;
        int nextIndex = -1;
        int flag = 0;
        while (positionMap.containsKey(map.get(G[index]))){
            int val = map.get(G[index]);
            nextIndex = positionMap.get(val);
            if(arr[nextIndex] == 0){
                count++;
                arr[index] = 1;
                index = nextIndex;
            }else {
                arr[index] = 1;
                flag = 1;
                break;
            }
        }

        if(flag == 1){
            return 0;
        }else {
            arr[nextIndex] = 1;
            return 1;
        }

    }

    /*

    //Accepted -----18ms
        map can be replaced by arr
     */
    public  int numComponents(ListNode head,int[] G){
        Map<Integer, Integer> map = new HashMap<>();
        ListNode p = head;
        while (p.next != null){
            map.put(p.val, p.next.val);
            p = p.next;
        }
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> positonMap = new HashMap<>();
        int[] arr = new int[G.length];
        for(int i = 0; i < G.length; i++){
            set.add(G[i]);
            positonMap.put(G[i],i);
        }
        int count = 0;
        for(int i = 0; i < G.length; i++){
            if(arr[i] == 0) {
                count += search(map, positonMap, arr, G, i);
            }
        }
        return  count;
    }


    @Test
    public  void  test(){
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

//        int[] G = {0,4,1,3};
//        int[] G = {3,4,0,2,1};
        int[] G = {3,2,4};

        long startTime = System.currentTimeMillis();
        int result = numComponents(l1,G);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }

}
