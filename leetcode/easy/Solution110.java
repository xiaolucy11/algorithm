package interview.easy;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/13 0013.
 */
public class Solution110 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public int computeMaxHeightOfTree(TreeNode root){
        if(root == null){return 0;}
        if((root.left == null) && (root.right == null)){
            return 1;
        }
        return 1 + Math.max(computeMaxHeightOfTree(root.left), computeMaxHeightOfTree(root.right));

    }
    public boolean isBalanced(TreeNode root){
        int leftHeight = computeMaxHeightOfTree(root.left);
        int rightHeight = computeMaxHeightOfTree(root.right);
        if(Math.abs(leftHeight  - rightHeight) > 1){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    @Test
    public void  test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(2);
        TreeNode l31 = new TreeNode(3);
        TreeNode l32 = new TreeNode(3);
        TreeNode l41 = new TreeNode(4);
        TreeNode l42 = new TreeNode(4);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l21.right = l32;
        l31.left = l41;
        l31.right = l42;

        System.out.print(isBalanced(l1));

    }
}
