package algorithm.medium8;

import org.junit.Test;

/**
 * Created by youlu on 2018/11/5.
 */
public class Solution725 {
    public  class  ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    //Accepted ----3ms
    public  ListNode[] splitListToParts(ListNode root, int k){
        ListNode p = root;
        int length = 0;
        while (p != null){
            length++;
            p = p.next;
        }

        ListNode[] result = new ListNode[k];
        int[] arr = new int[k];
        int divisor = length / k;
        int difference = length - divisor * k;
        for(int i = 0; i < k; i++){
            arr[i] = divisor;
            if(difference > 0){
                arr[i]++;
                difference--;
            }
        }

        p = root;
        ListNode q = root;
        int totalCount = 0, sum = 0;

        for(int i =0 ; i < k; i++){
            sum += arr[i];
            while (q != null){
               totalCount++;
                if(totalCount == sum){
                    break;
                }
                q = q.next;
            }

            if(q != null){
                result[i] = p;
                p = q;
                q = q.next;
                p.next = null;
                p = q;
            }else {
                result[i] = null;
            }
        }

        return  result;
    }

    @Test
    public  void  test(){
      ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(10);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;

        int k = 3;

        ListNode[] result = splitListToParts(l1, k);

        for(int i = 0; i < result.length; i++){
            ListNode p = result[i];
            while (p != null){
                System.out.print(p.val + "  ");
                p = p.next;
            }

            System.out.println();
        }
    }
}
