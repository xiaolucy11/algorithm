package interview.medium3;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2018/9/9 0009.
 */
public class Solution199 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public  void  search(List<Integer> list, TreeNode root){
        if(root == null){
            return;
        }

        list.add(root.val);
        if(root.left == null && root.right == null){
            return;
        }else if(root.right != null){
            search(list, root.right);
        }else {
            search(list, root.left);
        }

    }
    //Wrong Solution
    public List<Integer>  rightSideView(TreeNode root){
        if(root == null){
            return  new ArrayList<Integer>();
        }
        List<Integer> list = new ArrayList<>();
        search(list, root);
        return list;
    }



    //Accepted ----4ms
    /*
        it can be optimized. when add TreeNode to input, from right to left.
        when the size of input is more than 1, break.
         you only to add  value of the first elment to result list
     */
    public List<Integer>  rightSideView1(TreeNode root){
        List<Integer> result = new ArrayList<>();
        List<TreeNode> input = new ArrayList<>();
        input.add(root);
        Queue<List<TreeNode>> queue = new ArrayDeque<>();
        queue.add(input);

        while (!queue.isEmpty()){
            List<TreeNode> output = queue.poll();
            int length = output.size();
            result.add(output.get(length-1).val);

            input = new ArrayList<>();
            for(int i = 0; i < length; i++){
                TreeNode node = output.get(i);
                if(node.left != null){
                    input.add(node.left);
                }

                if(node.right != null){
                    input.add(node.right);
                }

            }

            if(input.size() > 0){
                queue.add(input);
            }
        }
        return  result;
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(3);
        TreeNode l32 = new TreeNode(4);
        //TreeNode l34 = new TreeNode(4);

        l1.left = l21;
        l1.right = l22;

        l21.right = l32;
        //l22.right = l34;

        List<Integer> list = rightSideView1(l1);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + "  ");
        }
    }
}
