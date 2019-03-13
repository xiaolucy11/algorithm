package interview.easy3;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2018/7/23 0023.
 */
public class Solution637 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    //Accepted ----7ms
    public List<Double> averageOfLevels(TreeNode root){
        List<TreeNode> input = new ArrayList<>();
        List<TreeNode> output = new ArrayList<>();
        Queue<List<TreeNode>> queue = new ArrayDeque<>();
        List<Double> result = new ArrayList<>();

        input.add(root);
        queue.add(input);
        while (!queue.isEmpty()){
            output = queue.poll();
            double sum = 0;
            input = new ArrayList<>();
            for(int i = 0; i <output.size(); i++){
                sum += output.get(i).val;
                if(output.get(i).left != null){
                    input.add(output.get(i).left);
                }
                if(output.get(i).right != null){
                    input.add(output.get(i).right);
                }
            }
            result.add(sum / output.size());
            if(input.size() != 0) {
                queue.add(input);
            }
        }
        return  result;
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(3);
        TreeNode l21 = new TreeNode(9);
        TreeNode l22 = new TreeNode(20);
        TreeNode l33 = new TreeNode(15);
        TreeNode l34 = new TreeNode(7);

        l1.left = l21;
        l1.right = l22;

        l22.left = l33;
        l22.right = l34;

        List<Double> result = averageOfLevels(l1);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
    }
}
