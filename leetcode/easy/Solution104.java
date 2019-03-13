package interview.easy;

/**
 * Created by Administrator on 2018/6/12 0012.
 */
public class Solution104 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public int maxDepth(TreeNode root){
        if(root == null){return 0;}
        if((root.left == null) && (root.right == null)){return 1;}
        else return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


}
