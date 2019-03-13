package interview.easy1;
import org.junit.Test;

/**
 * Created by Administrator on 2018/6/17 0017.
 */
public class Solution160 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null) {return null;}


        ListNode p1 = headA, p2 = headB;
        int countA = 0, countB = 0;
        while((p1 != null) && ( p2 != null)){
            countA++;
            countB++;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null){countA++; p1 = p1.next;}
        while (p2 != null) {countB++; p2 = p2.next;}

        ListNode pA = headA, pB = headB;
        int countDiff = Math.abs( countA - countB);
        if(countA < countB){
            while (countDiff > 0){
                countDiff--;
                pB = pB.next;
            }
        }else{
            while (countDiff > 0){
                countDiff--;
                pA = pA.next;
            }
        }
        while ((pA != null) && (pB != null)){
            if( pA == pB){
                return  pA;
            }else {
                pA = pA.next;
                pB = pB.next;
            }
        }
        return  null;
    }

    @Test
    public  void test(){
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);
        ListNode b1 = new ListNode(6);
        ListNode b2 = new ListNode(7);
        ListNode b3 = new ListNode(8);

        a1.next = a2;
        a2.next = c1;
        c1.next = c2;
        c2.next = c3;
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;


        ListNode result = getIntersectionNode(a1, b1);
        System.out.print(result.val);
    }
}
