package algorithm.hard2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by youlu on 2018/12/23.
 */
public class Solution145 {
    public class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public void  postOrder(TreeNode root,List<Integer> list){
        if(root != null){
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.val);
        }
    }


    //Accepted ---1ms
    /*
        recursive solution
     */
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return  result;
    }



    //Accepted ----2ms
    /*
        iterative solution
     */
    public List<Integer> postorderTraversal1(TreeNode root){
        if(root == null){
            return  new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        stack.add(root);
        if(root.right != null) {
            stack.add(root.right);
        }

        if(root.left != null) {
            stack.add(root.left);
        }
        root.left = null;
        root.right = null;

        while (!stack.isEmpty()){
            TreeNode top = stack.peek();
            if(top.left == null && top.right == null){
                TreeNode temp = stack.pop();
                list.add(temp.val);
            }else {
                if(top.right != null){
                    stack.add(top.right);
                }
                if(top.left != null){
                    stack.add(top.left);
                }

                top.left = null;
                top.right = null;
            }
        }

        return  list;
    }



    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(4);
        TreeNode l22 = new TreeNode(2);
        TreeNode l34 = new TreeNode(5);
        TreeNode l33 = new TreeNode(3);

        l1.right = l22;
        l22.left = l33;
        l1.left = l21;
        l22.right = l34;


        List<Integer> list = postorderTraversal1(l1);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + "  ");
        }
    }
}
