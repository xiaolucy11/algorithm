package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/21 0021.
 */
public class Solution203 {
    public  class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public  ListNode removeElements(ListNode head, int val){
        if(head == null){return  null;}
        if(head.val == val) {
            return removeElements(head.next, val);
        }
        ListNode  slow = head, quick = head.next;
        while (quick != null){
            if( quick.val == val){
                slow.next = quick.next;
                quick = quick.next;
            }else {
                quick = quick.next;
                slow = slow.next;
            }
        }
        return  head;
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode result = removeElements(l1, 6);
        ListNode p = result;
        while( p != null){
            System.out.print(p.val + " -> ");
            p = p.next;
        }

    }
}
