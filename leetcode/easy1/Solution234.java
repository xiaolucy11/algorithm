package interview.easy1;

import org.junit.Test;

import java.util.Vector;

/**
 * Created by Administrator on 2018/6/24 0024.
 */
public class Solution234 {
    public  class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public  boolean isPalindrome(ListNode head){
        Vector<Integer> vector = new Vector<>();
        ListNode p = head;
        while(p != null){
            vector.add(p.val);
            p = p.next;
        }
        int left = 0, right = vector.size() -1;
        while (left <= right){
            if(!vector.get(left).equals(vector.get(right))){
                return  false;
            }else {
                left++;
                right--;
            }
        }
        return  true;
    }

    @Test
    public void  test(){
        ListNode p1 = new ListNode(-129);
        ListNode p2 = new ListNode(-129);
        ListNode p3 = new ListNode(2);
        ListNode p4 = new ListNode(5);

        p1.next = p2;

        p3.next = p4;
        System.out.print(isPalindrome(p1));
    }
}
