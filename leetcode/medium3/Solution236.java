package algorithm.medium3;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/12.
 */
public class Solution236 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public boolean find(TreeNode root, TreeNode p){
        if(root == null){
            return false;
        }

        if(root == p){
            return  true;
        }else {
            return find(root.left,p) || find(root.right, p);
        }

    }

    //Accepted ----10ms
    /*
        ugly code
        contains too many if-else statements
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(find(p,q)){
            return p;
        }

        if(find(q, p)){
            return q;
        }
        if((root.left == p && root.right == q) ||
                (root.left == q && root.right == p)){
            return root;
        }

        if((find(root,q) && find(root,q) &&
                !(find(root.left,q) && find(root.left,p)) &&
                !(find(root.right,q) && find(root.right,p)))){
            return root;
        }

        if(find(root.left, p) && find(root.left,q)){
            return lowestCommonAncestor(root.left,p, q);
        }else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }


    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(3);
        TreeNode l21 = new TreeNode(5);
        TreeNode l22 = new TreeNode(1);
        TreeNode l31 = new TreeNode(6);
        TreeNode l32 = new TreeNode(2);
        TreeNode l33 = new TreeNode(0);
        TreeNode l34 = new TreeNode(8);
        TreeNode l43 = new TreeNode(7);
        TreeNode l44 = new TreeNode(4);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l21.right = l32;

        l22.left = l33;
        l22.right = l34;

        l32.left = l43;
        l32.right = l44;

       TreeNode p = l33;
        TreeNode q = l34;
        System.out.print(lowestCommonAncestor(l1,p,q).val);
    }

}
