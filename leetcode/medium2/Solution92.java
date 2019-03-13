package interview.medium2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/31 0031.
 */
public class Solution92 {
    public  class  ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    //Accepted -------3ms
    // space complexity o(n)
    public  ListNode reverseBetween(ListNode head, int m, int n){
        List<ListNode> listNodes = new ArrayList<>();
        for(int i = 1; i <= n-m + 1; i++){
            listNodes.add(new ListNode(0));
        }
        int count  = 1, index = 0;
        ListNode p = head;
        while (p != null){
            if(count > n){
                break;
            }

            if(count == m - 1){
                ListNode temp = p;
                p = p.next;
                temp.next = listNodes.get(n-m);
                count++;
                continue;
            }

            if(count >= m && count <= n){
                listNodes.get(index).val = p.val;
                if(index > 0){
                    listNodes.get(index).next = listNodes.get(index-1);
                }
                index++;
            }
            count++;
            p = p.next;
        }
        listNodes.get(0).next = p;

        if(m > 1){
            return  head;
        }else {
            return  listNodes.get(n-m);
        }
    }

    //Accepted ----5ms
    //space o(1)
    public  ListNode reverseBetween1(ListNode head, int m, int n){
        ListNode cur = new ListNode(0);
        ListNode start = new ListNode(0);
        ListNode end = new ListNode(0);
        ListNode pre = new ListNode(0);

        ListNode p = head;
        int count = 1;
        while (p != null){
            if(count > n){
                break;
            }

            if(count == m - 1){
                pre = p;
                count++;
                p = p.next;
                continue;
            }

            if(count >= m && count <= n){
                if(count == n){
                    end = p;
                }
                if(count == m){
                    start = p;
                    cur = p;

                }else {
                    ListNode temp = p.next;
                    p.next = cur;
                    cur = p;
                    p = temp;
                    count++;
                    continue;
                }

            }
            count++;
            p = p.next;
        }
        start.next = p;
        if(m > 1){
            pre.next = end;
            return  head;
        }else {
            return end;
        }
    }


    //reference from other
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        for(int i = 1; i < m; i++){
            cur = cur.next;
            pre = pre.next;
        }
        for(int i = 0; i < n - m; i++){
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
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
        int m = 1;
        int n = 4;

        ListNode result = reverseBetween1(l1, m, n);
        while (result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
