package algorithm.medium6;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by youlu on 2018/10/14.
 */
public class Solution513 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    //Accepted -level order trav------9ms
    /*ersal
     */
    public  int findBottomLeftValue(TreeNode root){
        Queue<List<TreeNode>> queue = new ArrayDeque<>();
        List<TreeNode> input = new ArrayList<>();
        input.add(root);
        queue.add(input);
        while (!queue.isEmpty()){
            List<TreeNode> output = queue.poll();
            input = new ArrayList<>();
            for (int i = 0; i < output.size(); i++){
                if(output.get(i).left != null){
                    input.add(output.get(i).left);
                }
                if(output.get(i).right != null){
                    input.add(output.get(i).right);
                }
            }

            if(input.size() != 0){
                queue.add(input);
            }else {
                return output.get(0).val;
            }
        }
        return  Integer.MIN_VALUE;
    }


    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(2);
        TreeNode l21 = new TreeNode(1);
        TreeNode l22 = new TreeNode(3);
        TreeNode l31 = new TreeNode(4);
        TreeNode l33 = new TreeNode(5);
        TreeNode l34 = new TreeNode(6);
        TreeNode l43 = new TreeNode(7);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l22.left = l33;
        l22.right = l34;
        l33.left = l43;

        long startTime = System.currentTimeMillis();
        int result = findBottomLeftValue(l1);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
