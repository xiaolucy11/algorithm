package interview.easy3;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by Administrator on 2018/7/17 0017.
 */
public class Solution543 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    //Accepted ----21ms
    public  int depthOfTree(TreeNode root){
        if(root == null){return 0;}
        if(root.left == null && root.right == null){
            return  0;
        }
        int leftDepth = depthOfTree(root.left);
        int rightDepth = depthOfTree(root.right);
        if(leftDepth > rightDepth ){
            return  leftDepth + 1;
        }else {
            return  rightDepth + 1;
        }
    }

    public  int computeDiameter(TreeNode root){
        int leftMaxLength = depthOfTree(root.left);
        int rightMaxLength = depthOfTree(root.right);
        if(root.left != null && root.right != null){
            return  leftMaxLength + rightMaxLength + 2;
        }else if(root.left!= null && root.right == null){
            return  leftMaxLength + 1;
        }else  if(root.left == null && root.right != null){
            return  rightMaxLength + 1;
        }else {
            return  0;
        }
    }

    public  int diameterOfBinaryTree(TreeNode root){
       int maxDiameter = 0;
        Queue<TreeNode> queue = new ConcurrentLinkedDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            int diameter = computeDiameter(node);
            if(diameter > maxDiameter){
                maxDiameter = diameter;
                System.out.println(node.val + " :   " + maxDiameter);
            }
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return  maxDiameter;
    }



    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(3);
        TreeNode l31 = new TreeNode(4);
        TreeNode l32 = new TreeNode(5);


        l1.left = l21;
        l1.right = l22;

        l21.left = l31;
        l21.right = l32;

        System.out.print(diameterOfBinaryTree(l1));
    }
}
