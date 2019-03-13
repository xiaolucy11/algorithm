package interview.medium3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2018/9/5 0005.
 */
public class Solution144 {
    public  class TreeNode{
        int val;
       TreeNode left;
        TreeNode right;
        TreeNode (int x){
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root){

        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);

            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return  result;
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(3);
        TreeNode l31 = new TreeNode(4);
        TreeNode l34 = new TreeNode(5);

        l1.left = l21;
        l1.right = l22;

        l21.left = l31;
        l22.right = l34;

        List<Integer> list = preorderTraversal(l1);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + "  ");
        }
    }
}
