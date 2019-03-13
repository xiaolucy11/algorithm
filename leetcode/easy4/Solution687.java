package interview.easy4;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Administrator on 2018/7/26 0026.
 */
public class Solution687 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public  int longestPath(TreeNode root){
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null){
            return  0;
        }

        int leftValue = 0;
        if(root.left != null && root.left.val == root.val ){
            leftValue = longestPath(root.left) + 1;
        }
        int rightValue = 0;
        if(root.right != null && root.right.val == root.val){
            rightValue = longestPath(root.right) + 1;
        }
        return  Math.max(leftValue, rightValue) ;
    }
    public  int computeLongestOfNode(TreeNode root){
        if(root == null){
            return  0;
        }
        if(root.left == null && root.right == null){
            return  0;
        }

        int leftValue = 0;
        if(root.left != null && root.left.val == root.val){
            leftValue = longestPath(root.left) + 1;
        }
        int rightValue = 0;
        if(root.right != null&& root.right.val == root.val){
            rightValue = longestPath(root.right) + 1;
        }
        return  leftValue + rightValue;
    }

    //Accepted ------22ms
    //iteratively  vesion
    public  int longestUnivaluePath(TreeNode root){
        if(root == null){
            return  0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int maxValue = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            int value = computeLongestOfNode(node);
            if(value > maxValue){
                maxValue = value;
            }
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return  maxValue;
    }


    // recursive version , wrong solution
    public  int longestUnivaluePath1(TreeNode root){
        if(root == null){
            return  0;
        }
        if(root.left == null && root.right == null){
            return  0;
        }

        int leftValue = 0;
        if(root.left != null && root.left.val == root.val){
            leftValue = longestUnivaluePath1(root.left) + 1;
        }
        int rightValue = 0;
        if(root.right != null&& root.right.val == root.val){
            rightValue = longestUnivaluePath1(root.right) + 1;
        }
        int temp1 = longestUnivaluePath1(root.left);
        int temp2 = longestUnivaluePath1(root.right);
        int maxValue1 = Math.max(leftValue + rightValue, temp1);
        int result = Math.max(maxValue1, temp2);
        return  result;
    }

    public  int result ;

    // equal to compute longest path of tree node
    public  int help(TreeNode root){
        int leftPath = longestUnivaluePath2(root.left);
        int rightPath = longestUnivaluePath2(root.right);

        int leftValue = 0;
        int rightValue = 0;
        if(root.left != null && root.left.val == root.val){
            leftValue = leftPath + 1;
        }
        if(root.right != null && root.right.val == root.val){
            rightValue = rightPath + 1;
        }

        result = Math.max(leftValue+rightValue, result);
        return  Math.max(leftValue, rightValue);
    }
    public  int longestUnivaluePath2(TreeNode root){
        result = 0;
        help(root);
        return  result;
    }

    @Test
    public  void  test(){
      /*  TreeNode l1 =  new TreeNode(5);
        TreeNode l21 = new TreeNode(4);
        TreeNode l22 = new TreeNode(5);
        TreeNode l31 = new TreeNode(1);
        TreeNode l32 = new TreeNode(1);
       // TreeNode l33 = new TreeNode(3);
        TreeNode l34 = new TreeNode(5);
//        TreeNode l44 = new TreeNode(5);
//        l34.right = l44;
     *//*   TreeNode l45 = new TreeNode(3);
        TreeNode l46 = new TreeNode(3);
        TreeNode l51 = new TreeNode(3);
        TreeNode l52 = new TreeNode(3);
        TreeNode l61 = new TreeNode(3);

        l33.left = l45;
        l33.right = l46;
        l46.left = l51;
        l46.right = l52;
        l51.left = l61;*//*




        l1.left = l21;
        l1.right = l22;

        l21.left = l31;
        l21.right = l32;

        l22.right = l34;
       *//* l22.left = l33;*/

        TreeNode l1 = new TreeNode(4);
        TreeNode l21 = new TreeNode(-7);
        TreeNode l22 = new TreeNode(-3);
        TreeNode l33 = new TreeNode(-9);
        TreeNode l34 = new TreeNode(-3);
        TreeNode l41 = new TreeNode(9);
        TreeNode l42 = new TreeNode(-7);
        TreeNode l51 = new TreeNode(6);
        TreeNode l52 = new TreeNode(-6);
        TreeNode l53 = new TreeNode(-6);
        TreeNode l61 = new TreeNode(0);
        TreeNode l62 = new TreeNode(6);
        TreeNode l63 = new TreeNode(5);
        TreeNode l64 = new TreeNode(9);
        TreeNode l71 = new TreeNode(-1);
        TreeNode l72 = new TreeNode(-4);
        TreeNode l73 = new TreeNode(-2);
        TreeNode l43 = new TreeNode(-4);

        l1.left = l21;
        l1.right = l22;

        l22.left = l33;
        l22.right = l34;

        l33.left = l41;
        l33.right = l42;
        l34.left = l43;

        l41.left = l51;
        l42.left = l52;
        l42.right = l53;

        l51.left = l61;
        l51.right = l62;
        l52.left = l63;
        l53.left = l64;

        l61.right = l71;
        l62.left = l72;
        l63.left = l73;

        System.out.print(longestUnivaluePath(l1));
    }
}
