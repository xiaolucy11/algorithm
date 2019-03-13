package interview.medium3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2018/9/5 0005.
 */
public class Solution142 {
    public  class  ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    //Accepted ----11ms
    public  ListNode detectCycle(ListNode head){
        if(head == null || head.next == null ){
            return  null;
        }
        if(head.next == head){
            return  head;
        }

        ListNode slow = head, quick = head.next;
        Set<ListNode> set = new HashSet<>();

        while (quick != null){

            if(set.contains(slow)){
                return slow;
            }else {
                    set.add(slow);
                    slow = slow.next;
                    quick = quick.next;
                    if(quick != null) {
                        quick = quick.next.next;
                    }else {
                        break;
                    }
            }
        }

        return  null;
    }


    //part reference from other
    //Accepted ------1ms
    public  ListNode detectCycle1(ListNode head){
        if(head == null || head.next == null ){
            return  null;
        }
        if(head.next == head){
            return  head;
        }

        ListNode slow = head, quick = head.next;
        int slowCount = 1, quickCount = 2;

        while (quick != null){
            if(quick != slow){
                slow = slow.next;
                slowCount++;
                quick = quick.next;
                if(quick != null){
                    quick = quick.next;
                    quickCount += 2;
                }else {
                    break;
                }
            }else {
                break;
            }
        }

        if(quick == null){
            return null;
        }


        ListNode p = head;
        slow = slow.next;
        while (p != slow){
            p = p.next;
            slow = slow.next;
        }
        return  p;
    }
}
