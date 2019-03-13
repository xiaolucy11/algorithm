package interview.easy4;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
public class Solution653 {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public  TreeNode search(TreeNode root, int value){
        if(root == null){return  null;}
        if(root.val == value){
            return  root;
        }

       TreeNode leftResult = search(root.left, value);
        TreeNode rightResult = search(root.right, value);
        if(leftResult != null){
            return leftResult;
        }else if(rightResult != null){
            return  rightResult;
        }else {
            return  null;
        }
    }

    //Accepted ------19ms
    public  boolean findTarget(TreeNode root, int k){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode result = search(root, k - node.val);
            if(result != null && result != node){
                return  true;
            }
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return  false;
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(0);
        TreeNode l21 = new TreeNode(-2);
        TreeNode l22 = new TreeNode(3);
        //TreeNode l31 = new TreeNode(2);
        TreeNode l32 = new TreeNode(-1);
        TreeNode l34 = new TreeNode(4);


        l1.left = l21;
        l1.right = l22;

        //l21.left = l31;
        l21.right = l32;

        l22.right = l34;

        System.out.println(findTarget(l1, -2));
    }
}
