package interview.medium2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/9/2 0002.
 */
public class Solution114 {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public  TreeNode findLastNode(TreeNode root){
        if(root == null){
            return  null;
        }
        TreeNode p = root;
        while (p.right != null){
            p = p.right;
        }
        return  p;
    }

    public TreeNode flattenHelp(TreeNode root){
        if(root == null){
            return  null;
        }
        if(root.left == null && root.right == null){
            return  root;
        }

        TreeNode leftNode = flattenHelp(root.left);
        TreeNode rightNode = flattenHelp(root.right);

        TreeNode leftLatNode = findLastNode(leftNode);
        root.left = null;
        if(leftNode != null){
            root.right = leftNode;
            leftLatNode.right = rightNode;
        }else {
            root.right = rightNode;
        }
        return  root;
    }

    //Accepted --------9ms
    public  void flatten(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode r = flattenHelp(root);

    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(5);
        TreeNode l31 = new TreeNode(3);
        TreeNode l32 = new TreeNode(4);
        TreeNode l34 = new TreeNode(6);

        l1.left = l21;
        l1.right = l22;

        l21.left = l31;
        l21.right = l32;

        l22.right = l34;

        flatten(l1);

        TreeNode t = l1;
        while (t != null){
            System.out.print(t.val + "  ");
            t = t.right;
        }
    }
}
