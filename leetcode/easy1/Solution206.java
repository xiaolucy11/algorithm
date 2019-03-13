package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/22 0022.
 */
public class Solution206 {
    public  class  ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode reverseList(ListNode head){
        if(head == null){
            return  null;
        }
        if(head.next == null){
            return  head;
        }
        // refence problem
        ListNode p = reverseList(head.next);
        while (p.next != null){
            p = p.next;
        }
        p.next = head;
        return  p;

    }


    //Accepted iteratively
    public  ListNode reverseList1(ListNode head){
        if(head == null){
            return  null;
        }
        if(head.next == null){
            return  head;
        }
        ListNode p = head, q = head.next;
        while (q.next != null){
            q = q.next;
            p = p.next;

        }
        ListNode result = q;
        q.next = p;
        p.next = null;
        q = p;
        p = head;

        while (p != q ){
            while (p.next != q){
                p = p.next;
            }
            q.next = p;
            q = p;
            p.next = null;
            p = head;
        }

        return  result;
    }

    // Accepted recursively
    public ListNode reverseList2(ListNode head){
        if(head == null){return  null;}
        if (head.next == null){ return  head;}
        ListNode p = head, q = head.next;
        while (q.next != null){
            p = p.next;
            q = q.next;
        }
        p.next = null;
        ListNode tail = reverseList2(head);
        q.next = tail;
        return  q;
    }


    @Test
    public  void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode result = reverseList2(l1);
        while (result != null){
            System.out.print(result.val + "  ");
            result = result.next;
        }
    }
}
