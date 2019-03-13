package interview.easy;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

/**
 * Created by Administrator on 2018/6/11 0011.
 */
public class Solution100 {
    public class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        if((p == null) && (q != null)){return false;}
        if((p != null) && (q == null)){return false;}
        if((p == null) && (q == null)){return false;}

        if((p.left == null) && (p.right == null) && (q.left == null) && (q.right == null)){
            if(p.val == q.val){return true;}
            else {return false;}
        }
        if(p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else {
            return false;
        }
    }

    @Test
    public  void test(){
        TreeNode q = new TreeNode(1);
        TreeNode q1 = new TreeNode(2);
       // TreeNode q2 = new TreeNode(3);
        //q.left = q1;
        q.right = q1;

        TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        //TreeNode p2 = new TreeNode(3);
        p.left = p1;
        //p.right = p2;

        System.out.print(isSameTree(p, q));
    }
}
