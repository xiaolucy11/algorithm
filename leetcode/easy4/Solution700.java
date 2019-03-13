package interview.easy4;

/**
 * Created by Administrator on 2018/7/28 0028.
 */
public class Solution700 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    //Accepted ----2ms
    public  TreeNode searchBST(TreeNode root, int val){
        if(root == null){
            return  null;
        }
        if(root.val == val){
            return root;
        }else if(root.val > val){
            return  searchBST(root.left, val);
        }else {
            return  searchBST(root.right, val);
        }
    }
}
