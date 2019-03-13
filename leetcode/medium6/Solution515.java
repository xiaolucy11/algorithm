package algorithm.medium6;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by youlu on 2018/10/14.
 */
public class Solution515 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public  int maxValueInLevel(List<TreeNode> list){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).val > max){
                max = list.get(i).val;
            }
        }

        return  max;
    }


    //Accepted ------7ms
    public List<Integer> largestValues(TreeNode root){
        if(root == null){
            return  new ArrayList<>();
        }
        Queue<List<TreeNode>>  queue = new ArrayDeque<>();
        List<TreeNode> input = new ArrayList<>();
        input.add(root);
        List<Integer> result = new ArrayList<>();
        queue.add(input);

        while (!queue.isEmpty()){
            List<TreeNode> output = queue.poll();
            input = new ArrayList<>();
            result.add(maxValueInLevel(output));

            for(int i = 0; i < output.size();i++){
                if(output.get(i).left != null){
                    input.add(output.get(i).left);
                }

                if(output.get(i).right != null){
                    input.add(output.get(i).right);
                }
            }

            if(input.size() != 0){
                queue.add(input);
            }
        }

        return  result;
    }



    @Test

    public  void  test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(3);
        TreeNode l22 = new TreeNode(2);
        TreeNode l31 = new TreeNode(5);
        TreeNode l32 = new TreeNode(3);
        TreeNode l34 = new TreeNode(9);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l21.right = l32;
        l22.right = l34;

        long startTime = System.currentTimeMillis();
        List<Integer> result = largestValues(l1);
        long endTime = System.currentTimeMillis();
        for (int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }
}
