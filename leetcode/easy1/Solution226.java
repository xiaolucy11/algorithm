package interview.easy1;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2018/6/24 0024.
 */
public class Solution226 {
    public class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public void  travelByLevel(TreeNode root ){
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
            System.out.print(temp.val + " ");
        }
        System.out.println();
    }
    public  TreeNode invertTree(TreeNode root){
        if(root == null){return  null;}
        if((root.left == null) && (root.right == null)){
            return  root;
        }

        TreeNode leftInvertNode = invertTree(root.left);
        TreeNode rightInvertNode = invertTree(root.right);
        root.left = rightInvertNode;
        root.right = leftInvertNode;
        return  root;
    }

    @Test
    public  void  test(){
        TreeNode root = new TreeNode(4);
        TreeNode level11 = new TreeNode(2);
        TreeNode level12 = new TreeNode(7);
        TreeNode level21 = new TreeNode(1);
        TreeNode level22 = new TreeNode(3);
        TreeNode level23 = new TreeNode(6);
        TreeNode level24 = new TreeNode(9);

        root.left = level11;
        root.right = level12;

        level11.left = level21;
        level11.right = level22;
        level12.left = level23;
        level12.right = level24;

        travelByLevel(root);
        System.out.println("-----------Invert Tree----------------------");
        TreeNode result = invertTree(root);
        travelByLevel(result);

    }
}
