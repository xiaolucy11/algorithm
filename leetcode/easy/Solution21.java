package interview.easy;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/5 0005.
 */


public class Solution21 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
    public  ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if( (l1 == null) && (l2 == null)){return null;}
        if((l1 == null) && (l2 != null)){return  l2;}
        if((l1 != null) && (l2 == null)) {return l1;}
        ListNode l1Node = l1;
        ListNode l2Node = l2;

        int l1Count = 0, l2Count = 0;
        while(l1Node != null){
            l1Count++;
            l1Node = l1Node.next;
        }
        while(l2Node != null){
            l2Count++;
            l2Node = l2Node.next;
        }
        ListNode[] result = new ListNode[l1Count + l2Count];
        l1Node = l1;
        l2Node = l2;
        int index = 0;
        while((l1Node != null) && (l2Node != null)){
            if(l1Node.val < l2Node.val){
                result[index++] = l1Node;
                l1Node = l1Node.next;
            }
            else{
                result[index++] = l2Node;
                l2Node = l2Node.next;
            }
        }
        while(l1Node != null){
            result[index++] = l1Node;
            l1Node = l1Node.next;
        }
        while (l2Node != null){
            result[index++] = l2Node;
            l2Node = l2Node.next;
        }
        for(int i = 0; i < l1Count + l2Count-1; i++){
            result[i].next = result[i+1];
        }
        return result[0];

    }
    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l1.next = l12;
        l12.next = l13;
        l2.next = l22;
        l22.next = l23;

        ListNode res = mergeTwoLists(l1, l2);
        while(res != null){
            System.out.print(res.val + "  ");
            res = res.next;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if((l1 == null) && (l2 == null)){return null;};
        if((l1 == null) && (l2 != null)) {return l2;}
        if((l1 != null) && (l2 == null)) {return l1;}

        ListNode result = new ListNode(0);
        //ListNode result = null;
        if(l1.val < l2.val){
            result.val = l1.val;
            // result = l1;
            result.next = mergeTwoLists(l1.next, l2);
        }
        else {
            result.val = l2.val;
            // result = l2;
            result.next = mergeTwoLists(l1, l2.next);
        }
        return result;
    }
}
