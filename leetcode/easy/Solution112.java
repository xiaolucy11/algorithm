package interview.easy;

/**
 * Created by Administrator on 2018/6/14 0014.
 */
public class Solution112 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public boolean hasPathSum(TreeNode root, int sum){
        if(root == null){return false;}
        if((root.left == null) && (root.right == null)){
            if(sum == root.val){return true;}
            else {return false;}
        }else if((root.left != null) && (root.right == null)){
                return hasPathSum(root.left, sum - root.val);
        }else if ((root.left == null) && (root.right != null)){

                return hasPathSum(root.right, sum - root.val);
        }else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
