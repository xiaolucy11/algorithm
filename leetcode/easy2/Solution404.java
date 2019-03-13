package interview.easy2;

import interview.easy1.Solution226;
import org.junit.Test;

import java.util.Vector;

/**
 * Created by Administrator on 2018/7/4 0004.
 */
public class Solution404 {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public  boolean isLeave(TreeNode root){
        if(root == null){return  false;}
        if(root.left == null && root.right == null){return true;}
        else {
            return  false;
        }
    }

    public Vector<TreeNode> findLeftLeaves(TreeNode root){
        if((root == null) && (isLeave(root))){return new Vector<TreeNode>();}
        if(isLeave(root.left) && (isLeave(root.right)|| root.right == null)){
            return  new Vector<TreeNode>(){{add(root.left);}};
        }

        Vector<TreeNode> leftVector;
        if(isLeave(root.left)){
            leftVector = new Vector<TreeNode>(){{add(root.left);}};
        }else if(root.left == null) {
            leftVector = new Vector<TreeNode>();
        }else {
            leftVector = findLeftLeaves(root.left);
        }

        Vector<TreeNode> rightVector ;
        if(isLeave(root.right) || root.right == null){
            rightVector = new Vector<TreeNode>();
        }else {
            rightVector = findLeftLeaves(root.right);
        }

        leftVector.addAll(rightVector);
        return  leftVector;
    }

    public  int sumOfLeftleaves(TreeNode root){
        Vector<TreeNode> result = findLeftLeaves(root);
        int sum = 0;
        for(int i = 0; i < result.size(); i++){
            sum += result.get(i).val;
        }
        return  sum;
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(3);
        TreeNode l2 = new TreeNode(9);
        TreeNode l3 = new TreeNode(2);
        TreeNode l4 = new TreeNode(15);
        TreeNode l5 = new TreeNode(7);

        l1.left = l2;
        l2.left = l3;
        l3.left = l4;
        l4.left = l5;

        Vector<TreeNode> result = findLeftLeaves(l1);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i).val + "  ");
        }
    }
}
