package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/26 0026.
 */
public class Solution237 {
    public  class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public  void deleteNode(ListNode head, ListNode node){
        ListNode p = head;
        while (p.next != node){
            p = p.next;
        }
        p.next = node.next;
    }

    public  void  deleteNode1(ListNode node){
        ListNode p = node, q = node.next;
        while(q.next != null){
            p.val = q.val;
            p = p.next;
            q = q.next;
        }
        p.val = q.val;
        p.next = null;
    }
    @Test
    public  void  test(){
        ListNode l1 = new ListNode(4);
        ListNode l2  = new ListNode(5);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        deleteNode(l1, l3);

        ListNode p = l1;
        while(p != null){
            System.out.print(p.val + "  ");
            p = p.next;
        }
    }
}
