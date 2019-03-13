package interview.medium1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/10 0010.
 */
public class Solution24 {
    public  class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public  ListNode swapTwoNode(ListNode p1, ListNode p2){
        p1.next = p2.next;
        p2.next = p1;
        return  p2;
    }
//Accepted -------2ms
    public ListNode swapPairs(ListNode head){
        ListNode p = head;
        if(p.next != null){
            ListNode tempNode = p.next.next;
            head = swapTwoNode(p,p.next);
            p.next = tempNode;
        }else {
            return  head;
        }
        ListNode q = head.next;
        p = head.next.next;
        while (p != null){
            if(p.next != null){
                ListNode node = p.next.next;
                ListNode temp = swapTwoNode(p, p.next);
                q.next = temp;
                p.next = node;
                if(p.next != null){
                    p = p.next;
                }else {
                    break;
                }

                q = q.next.next;
            }else {
                break;
            }
        }
        return  head;
    }

    @Test
    public  void  test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
       l2.next = l3;
//        l3.next = l4;


        ListNode result = swapPairs(l1);
        while (result != null){
            System.out.print(result.val + "  ");
            result = result.next;
        }
    }
}
