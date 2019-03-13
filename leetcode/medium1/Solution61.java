package interview.medium1;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 2018/8/12 0012.
 */
public class Solution61 {
    public class  ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    //not be need
    public  ListNode reverse(ListNode head){
        ListNode reverseHead = null;
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null){
            stack.push(p);
            if(p.next == null){
                reverseHead = p;
            }
            p = p.next;
        }
        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            if(!stack.isEmpty()){
                node.next = stack.peek();
            }else {
                node.next = null;
            }
        }
        return  reverseHead;
    }

    //Accepted ------9ms
    public ListNode rotateRight(ListNode head, int k){
        ListNode p = head;
        int count = 0;
        while (p != null){
            count++;
            p = p.next;
        }

        k = k % count;
        if(k == 0){
            return  head;
        }
        int rotateNodeIndex = count - k + 1;
        int fromLeftCount = 1;
        p = head;
        ListNode q = head.next;

        while (q != null){
            fromLeftCount++;
            if(rotateNodeIndex == fromLeftCount){
                break;
            }
            q = q.next;
            p = p.next;
        }
        p.next = null;

        ListNode reverseHead = q;
        ListNode reverseNode = reverseHead;
        while (reverseNode.next != null){
            reverseNode = reverseNode.next;
        }
        reverseNode.next = head;
        return reverseHead;
    }

    @Test
    public  void  test(){
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
       // ListNode l4 = new ListNode(4);
       // ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
       // l3.next = l4;
       // l4.next = l5;

        ListNode result = rotateRight(l1, 4);
        while (result != null){
            System.out.print(result.val + "   ");
            result = result.next;
        }
    }
}
