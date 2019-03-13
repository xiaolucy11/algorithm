package interview.easy3;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2018/7/19 0019.
 */
public class Solution563 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public  int sumOfNode(TreeNode root){
        if(root == null){
            return  0;
        }
        if(root.left == null && root.right == null){
            return  root.val;
        }
        return  sumOfNode(root.left) + sumOfNode(root.right) + root.val;
    }


    public  int tiltOfnode(TreeNode root){
        if((root == null) || (root.left == null && root.right == null)){
            return  0;
        }
        return  Math.abs(sumOfNode(root.left) - sumOfNode(root.right));
    }

    //Accepted --------20ms
    public  int findTilt(TreeNode root){
        int result = 0;
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            result += tiltOfnode(node);
            if(node.left != null){
                queue.add(node.left);
            }

            if(node.right != null){
                queue.add(node.right);
            }
        }
        return  result;
    }


    public int result ;
    public  int sumOfNode1(TreeNode root){
        if(root == null){
            return  0;
        }
        int leftSum = sumOfNode1(root.left);
        int rightSum = sumOfNode1(root.right);
        result += Math.abs(leftSum - rightSum);
        return   leftSum + rightSum + root.val;
    }

    //reference from others, is a genius solution
    // use the result variable to record the tilt of node, decrease many operation,

    public  int findTilt1(TreeNode root){
        result = 0;
        int rootSum = sumOfNode1(root);
        return  result;
    }

    @Test
    public  void test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(3);

        l1.left = l21;
        l1.right = l22;

        System.out.print(findTilt1(l1));
    }
}
