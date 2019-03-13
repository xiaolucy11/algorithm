package interview.medium2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/9/2 0002.
 */
public class Solution116 {
    public  class  TreeLinkNode{
        int val ;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        TreeLinkNode(int x){
            val = x;
        }
    }

    public  void  connect(TreeLinkNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        root.left.next = root.right;
        if(root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }

    @Test
    public  void  test(){
        TreeLinkNode l1 = new TreeLinkNode(1);
        TreeLinkNode l21 = new TreeLinkNode(2);
        TreeLinkNode l22 = new TreeLinkNode(3);
        TreeLinkNode l31 = new TreeLinkNode(4);
        TreeLinkNode l32 = new TreeLinkNode(5);
        TreeLinkNode l33 = new TreeLinkNode(6);
        TreeLinkNode l34 = new TreeLinkNode(7);

        l1.left = l21;
        l1.right = l22;

        l21.left = l31;
        l21.right = l32;
        l22.left = l33;
        l22.right = l34;
        connect(l1);

        TreeLinkNode p = l1;
        p = p.left.right;
        System.out.print(p.next.val);
    }
}
