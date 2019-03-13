package algorithm.medium5;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by youlu on 2018/10/6.
 */
public class Solution445 {
    public  class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    //Accepted -----33ms
    public  ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int length1 = 0, length2 = 0;
        ListNode p1 = l1, p2 = l2;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (p1 != null){
            stack1.add(p1);
            length1++;
            p1 = p1.next;
        }

        while (p2 != null){
            stack2.add(p2);
            length2++;
            p2 = p2.next;
        }

        int flag = 0;
        while ((!stack1.isEmpty()) && (!stack2.isEmpty())){
            ListNode node1 = stack1.pop();
            ListNode node2 = stack2.pop();
            if(length1 > length2){
                int value = node1.val + node2.val +flag;
                if(value > 9){
                    value -= 10;
                    flag = 1;
                }else {
                    flag = 0;
                }
                node1.val = value;
            }else {
                int value = node1.val + node2.val + flag;
                if(value > 9){
                    value -= 10;
                    flag = 1;
                }else {
                    flag = 0;
                }
                node2.val = value;
            }
        }

        if(length1 > length2){
            if(flag == 1) {
                while (!stack1.isEmpty()) {
                    if (flag == 0) {
                        break;
                    }
                    ListNode node = stack1.pop();
                    int value1 = node.val + flag;
                    if (value1 > 9) {
                        value1 -= 10;
                        flag = 1;
                    } else {
                        flag = 0;
                    }
                    node.val = value1;
                }
            }
            if (flag == 1) {
                ListNode head = new ListNode(flag);
                head.next = l1;
                return head;
            }
            return l1;
        }else {
            if(flag == 1){
                while (!stack2.isEmpty()){
                    if(flag == 0){
                        break;
                    }
                    ListNode node = stack2.pop();
                    int value2 = node.val + flag;
                    if(value2 > 9){
                        value2 -= 10;
                        flag = 1;
                    }else {
                        flag = 0;
                    }
                    node.val = value2;
                }
                if(flag == 1){
                    ListNode head = new ListNode(flag);
                    head.next = l2;
                    return  head;
                }
            }
            return  l2;
        }
    }


    @Test
    public  void  test(){
       /* ListNode l1 = new ListNode(7);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        ListNode l14 = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);

        l1.next = l12;
        l12.next = l13;
        l13.next = l14;

        l2.next = l22;
        l22.next = l23;
*/
       ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        l2.next = l22;
        ListNode result = addTwoNumbers(l1,l2);
        while (result != null){
            System.out.print(result.val + "  ");
            result = result.next;
        }
    }
}
