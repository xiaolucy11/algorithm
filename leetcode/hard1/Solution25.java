package algorithm.hard1;

import org.junit.Test;

/**
 * Created by youlu on 2018/12/3.
 */
public class Solution25 {
    public  class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public  ListNode reverseLinkList(ListNode head){
        ListNode current = head;
        ListNode pre = null;
        ListNode nextNode = current.next;
        while (current != null){
            current.next = pre;
            pre = current;
            current = nextNode;
            if(nextNode != null) {
                nextNode = nextNode.next;
            }
        }
        return  pre;
    }

    public  ListNode toLast(ListNode head){
        ListNode p = head;
        while (p.next != null){
            p = p.next;
        }

        return  p;
    }

    public  int length(ListNode head){
        ListNode p = head;
        int len = 0;
        while (p != null){
            len++;
            p = p.next;
        }

        return  len;
    }


    //Accepted ----4ms
    public  ListNode reverseKGroup(ListNode head, int k){
        int len = length(head);

        if(len == 0){
            return  null;
        }
        if(k > len){
            return  head;
        }

        ListNode p = head;
        ListNode newHead = null;
        ListNode preNode = null;


        int firstBlockCount = 1;
        ListNode firstBlockNode = p;
        while (firstBlockNode != null && firstBlockCount < k){
            firstBlockNode = firstBlockNode.next;
            firstBlockCount++;
        }

        ListNode q = firstBlockNode.next;
        firstBlockNode.next = null;
        newHead = reverseLinkList(p);
        preNode = p;
        p = q;

        while (p != null){
            int count = 1;
            ListNode temp = p;
            while (temp != null && count < k){
                temp = temp.next;
                count++;
            }
            if(count == k && temp != null){
                ListNode nextHead = temp.next;
                temp.next = null;
                ListNode reverseHead = reverseLinkList(p);
                preNode.next = reverseHead;
                preNode = toLast(reverseHead);
                p = nextHead;
            }else {
                preNode.next = p;
                p = temp;
            }
        }

        return  newHead;

    }



    @Test
    public  void  test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

//        ListNode result = reverseLinkList(l1);
        int k = 1;
        ListNode result = reverseKGroup(l1, k);

        while (result != null){
            System.out.print(result.val + "  ");
            result = result.next;
        }

        System.out.println();

    }
}
