package algorithm.medium4;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/19.
 */
public class Solution328 {
    public  class  ListNode{
        int val;
        ListNode next;
        ListNode (int x){
            val = x;
        }
    }

    //Accepted ------ 5ms
    public ListNode oddEventList(ListNode head){
        if(head == null || head.next == null){
            return  head;
        }
        int count = 1;
        ListNode p  = head, q = head.next;
        ListNode evenHead = new ListNode(Integer.MIN_VALUE);
        ListNode evenCur = evenHead;

        while (q != null){
            if(count % 2 == 1){
                evenCur.next = q;
                p.next = q.next;
                q = q.next;
                evenCur = evenCur.next;
                evenCur.next = null;
            }else {
                p = p.next;
                q = q.next;
            }
            count++;
        }
        p.next = evenHead.next;
        return  head;
    }


    @Test
    public  void  test(){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(7);

        l1.next = l2;

        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode result = oddEventList(l1);

        while (result != null){
            System.out.print(result.val + "  ");
            result = result.next;
        }
    }
}
