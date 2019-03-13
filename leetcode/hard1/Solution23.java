package algorithm.hard1;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by youlu on 2018/12/3.
 */
public class Solution23 {
    public  class  ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }


    //Accepted ----21ms
    public  ListNode mergeKLists(ListNode[] lists){
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null) {
                priorityQueue.add(lists[i]);
            }
        }

        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode p = head;
        while (!priorityQueue.isEmpty()){
            ListNode node = priorityQueue.poll();
            p.next = node;
            if(node.next != null){
                priorityQueue.add(node.next);
            }
            p = p.next;
            p.next = null;
        }

        return  head.next;
    }


    @Test
    public  void  test(){
       /* ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 =  new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode l31 = new ListNode(2);
        ListNode l32 = new ListNode(6);
        l31.next = l32;



        ListNode[] lists = new ListNode[3];
        lists[0] = l11;
        lists[1] = l21;
        lists[2] = l31;*/

       ListNode[] lists = null;


        long startTime = System.currentTimeMillis();
        ListNode result = mergeKLists(lists);
        long endTime = System.currentTimeMillis();

        while (result != null){
            System.out.print( result.val + "  ");
            result = result.next;
        }
        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }
}
