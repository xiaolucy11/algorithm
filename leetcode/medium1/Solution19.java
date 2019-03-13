package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/9 0009.
 */
public class Solution19 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode (int x){
            val = x;
        }
    }

    //Accepted -----9ms
    public ListNode removeNthFromEnd(ListNode head, int n){
        if(n == 0){
            return  head;
        }
        int count = 0;
        ListNode p = head;
        while (p != null){
            count++;
            p = p.next;
        }
        if(n == count){
            head = head.next;
            return  head;
        }
        int fromStartOrder  = count - n + 1;
        count = 2;
        p = head;
        ListNode q = head.next;
        while (q!= null){
            if(count == fromStartOrder ){
                p.next = q.next;
                break;
            }else {
                p = p.next;
                q = p.next;
                count++;
            }
        }
        return  head;
    }

    @Test
    public void  test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode result = removeNthFromEnd(l1, 1);

        while (result != null){
            System.out.print(result.val + "  ");
            result = result.next;
        }
    }
}
