package interview.easy;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/6/16 0016.
 */
public class Solutin141 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    public boolean isRecNode(ListNode node){
        if(node == null || node.next == null){return false;}
        ListNode temp = node.next;
        while(temp != null){
            if(temp == node){
                return true;
            }
            temp = temp.next;
        }
        return  false;
    }
    public boolean hasCycle(ListNode head){
        if(head == null  || head.next == null){return false;}
        ListNode p = head;
        while(p != null){
          if(p.next == p){
              return true;
          }
          ListNode temp = head;
          while(temp != p){
              if(temp == p.next){return  true;}
              temp = temp.next;
          }
        }
        return  false;
    }

    //Accepted
    public boolean hasCycle1(ListNode head){
        if(head == null || head.next == null){return false;}
        ListNode slow = head, quick = head.next;
        while((slow != null) && (quick != null)){
            if(slow == quick ){return  true;}
            slow = slow.next;
            quick = quick.next;
            if(quick != null){
                quick = quick.next;
            }else {
                return  false;
            }
        }
        return false;

    }
}
