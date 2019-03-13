package interview.medium2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/2 0002.
 */
public class Solution109 {
    public  class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    //Accepted ------2ms
    public  TreeNode sortedListToBST(ListNode head){
        if(head == null){
            return  null;
        }
        if(head.next == null){
            return  new TreeNode(head.val);
        }

        int totalCount = 0;
        ListNode p = head;
        while (p != null){
            totalCount++;
            p = p.next;
        }

        int middleCount = 1;
        ListNode q = head.next;
        p = head;

        while (q != null){
            if(middleCount == totalCount / 2){
                break;
            }
            middleCount++;
            p = p.next;
            q = q.next;
        }
        p.next = null;
        TreeNode root = new TreeNode(q.val);
        TreeNode leftNode = sortedListToBST(head);
        TreeNode rightNode = sortedListToBST(q.next);

        root.left = leftNode;
        root.right = rightNode;
        return  root;

    }

    /*
        for testing
     */
    public  void  travesal(List<Integer> list, TreeNode root){
        if(root != null){
            travesal(list, root.left);
            list.add(root.val);
            travesal(list, root.right);
        }
    }
    public List<Integer> inorder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        travesal(list, root);
        return  list;
    }

    @Test
    public  void  test(){
        ListNode l1 = new ListNode(-10);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        TreeNode result = sortedListToBST(l1);
        List<Integer> list= inorder(result);

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + "  ");
        }
    }

}
