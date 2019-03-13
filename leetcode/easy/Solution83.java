package interview.easy;

import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2018/6/10 0010.
 */
public class Solution83 {
    public  class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode deleteDuplicate(ListNode head){
        ListNode p = head;
       if(head == null){
           return  null;
       }
       if(head.next == null){
           return head;
       }
        while((p != null) ){
            ListNode temp = p;
            while((temp != null) && (temp.val == p.val) ){
                temp = temp.next;
            }
            p.next = temp;
            p = p.next;
        }
        /*
        if(p.val == tail.val){
            p.next = null;
        }
        */
        return head;
    }

    @Test
    public  void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode result = deleteDuplicate(l1);
        ListNode pointer = l1;
        while(pointer != null){
            System.out.print(pointer.val + " ");
            pointer = pointer.next;
        }
    }
}
