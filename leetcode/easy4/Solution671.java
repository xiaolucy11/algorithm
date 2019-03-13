package interview.easy4;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
public class Solution671 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    //Accepted -----2ms
    public  int findSecondMinimumValue(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int secondValue = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.val > root.val && node.val < secondValue){
                secondValue = node.val;
            }
            if(node.left != null){
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        if(secondValue != Integer.MAX_VALUE){
            return  secondValue;
        }else {
            return  -1;
        }
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(2);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(2);
//        TreeNode l33 = new TreeNode(5);
//        TreeNode l34 = new TreeNode(7);

        l1.left = l21;
        l1.right = l22;

//        l22.left = l33;
//        l22.right = l34;
        System.out.print(findSecondMinimumValue(l1));
    }
}
