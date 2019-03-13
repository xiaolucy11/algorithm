package interview.easy;

/**
 * Created by Administrator on 2018/6/14 0014.
 */
public class Solution111 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public int minDepth(TreeNode root){
        if(root == null){return 0;}
        if((root.left == null) && (root.right == null)){return 1;}
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
