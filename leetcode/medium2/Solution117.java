package interview.medium2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/9/2 0002.
 */
public class Solution117 {
    public  class TreeLinkNode{
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x){
            val = x;
        }
    }

    //Accepted ------1ms
    /*
        need to from to left for populating
     */
    public  void  connect(TreeLinkNode root){
        if((root == null) || (root.left == null && root.right == null)){
            return;
        }

        if(root.left != null){
            root.left.next = root.right;
        }
        TreeLinkNode p = root.next;
        while (p != null){
            if(p.left == null && p.right == null){
                p = p.next;
            }else {
                break;
            }
        }
        if(p != null){
            if(p.left != null){
                if(root.right != null){
                    root.right.next = p.left;
                }else {
                    root.left.next = p.left;
                }
            }else {
                if(root.right != null){
                    root.right.next = p.right;
                }else {
                    root.left.next = p.right;
                }
            }
        }
        connect(root.right);
        connect(root.left);

    }

    @Test
    public  void  test(){
        TreeLinkNode l1 = new TreeLinkNode(2);
        TreeLinkNode l21 = new TreeLinkNode(1);
        TreeLinkNode l22 = new TreeLinkNode(3);
        TreeLinkNode l31 = new TreeLinkNode(0);
        TreeLinkNode l32 = new TreeLinkNode(7);
        TreeLinkNode l33 = new TreeLinkNode(9);
        TreeLinkNode l34 = new TreeLinkNode(1);
        TreeLinkNode l41 = new TreeLinkNode(2);
        TreeLinkNode l43 = new TreeLinkNode(1);
        TreeLinkNode l44 = new TreeLinkNode(0);
        TreeLinkNode l47 = new TreeLinkNode(8);
        TreeLinkNode l48 = new TreeLinkNode(8);
        TreeLinkNode l55  = new TreeLinkNode(7);


        l1.left = l21;
        l1.right = l22;

        l21.left = l31;
        l21.right = l32;
        l22.left = l33;
        l22.right = l34;

        l31.left = l41;
        l32.left = l43;
        l32.right = l44;

        l34.left = l47;
        l34.right = l48;


        l44.right = l55;
        connect(l1);
        TreeLinkNode p = l1;
        p = p.left.left.left;
        System.out.print(p.next.next.right.val);
    }
}
