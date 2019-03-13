package interview.easy5;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/6 0006.
 */
public class Solution876 {
    public  class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    //Accepted --------1ms
    public ListNode middleNode(ListNode head){
        int length  = 0;
        ListNode p = head;
        while (p != null){
            length++;
            p = p.next;
        }
        int count = 1;
        int middle = length / 2 + 1;
        p = head;
        while (count != middle){
            count++;
            p = p.next;
        }
        return  p;
    }

    @Test
    public  void  test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
       // ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        //l5.next = l6;

        ListNode result = middleNode(l1);
        System.out.print(result.val);
    }
}
