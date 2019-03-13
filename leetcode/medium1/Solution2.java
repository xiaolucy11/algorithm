package interview.medium1;

import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2018/8/7 0007.
 */
public class Solution2 {
    public  class  ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    //Accepted --------26ms
    public  ListNode addTwoNumber(ListNode l1, ListNode l2){
        int flag = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int count1 = 0, count2 = 0;
        while(p1.next != null){
            count1++;
            p1 = p1.next;
        }

        while (p2.next != null){
            count2++;
            p2 = p2.next;
        }
        ListNode longerList = null;
        if(count1 >= count2){
            longerList = l1;
            p2 = l2;
            p1 = l1;

        }else {
            p1 = l2;
            p2 = l1;
            longerList = l2;
        }
        int value = 0;
        while ((p1 != null) && (p2 != null)){
             value = p1.val + p2.val + flag;
            if(value >9){
                p1.val = value - 10;
                flag = 1;
            }else {
                p1.val = value;
                flag = 0;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        while(p1 != null){
            int temp = p1.val + flag;
            if(temp > 9){
                p1.val = temp - 10;
                flag = 1;
            }else{
                p1.val = temp;
                flag = 0;
            }
            p1 = p1.next;
        }
        if(flag == 1){
            ListNode last = new ListNode(flag);
            while (longerList.next != null){
                longerList = longerList.next;
            }

           longerList.next = last;
        }
        if(count1 >= count2){
            return  l1;
        }else {
            return  l2;
        }
    }

    @Test
    public  void  test(){
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);

        l11.next = l12;
        l12.next = l13;

        l21.next = l22;
        l22.next = l23;
        ListNode result = addTwoNumber(l11, l21);
        System.out.print(result.next.next.val);
    }
}
