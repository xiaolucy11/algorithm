package algorithm.medium4;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by youlu on 2018/9/21.
 */
public class Solution337 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public  List<Integer> getHeight(TreeNode root){
        if(root == null){
            return  new ArrayList<>();
        }

        Queue<List<TreeNode>> queue = new ArrayDeque<>();
        List<TreeNode> input = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        input.add(root);
        queue.add(input);

        while (!queue.isEmpty()){
            List<TreeNode> output = queue.poll();
            input = new ArrayList<>();
            result.add(sum(output));

            for(int i = 0; i < output.size();i++){
                if(output.get(i).left != null){
                    input.add(output.get(i).left);
                }

                if(output.get(i).right != null){
                    input.add(output.get(i).right);
                }
            }

            if(!input.isEmpty()){
                queue.add(input);
            }
        }

        return  result;
    }

    public  int sum(List<TreeNode> list){
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i).val;
        }
        return  sum;
    }

    public int robHelper(List<Integer> list, int index, int[] robs){
        if(index == 0){
            robs[0] = list.get(0);
            return  list.get(0);
        }else if(index == 1){
            robs[index] = list.get(1);
            return list.get(1);
        }else if(index == 2){
            int val = Math.max(list.get(2) + list.get(0), list.get(1));
            robs[index] = val;
            return  val;
        }else if(index == 3){
            int max1 = Math.max(robHelper(list, index-1, robs), list.get(index) + list.get(index-3));
            int max2 = Math.max(list.get(index)+list.get(index-3), max1);
            robs[index] = max2;
            return robs[index];
        } else {
            int result1 = 0, result2 = 0, result3 = 0;
            if(robs[index-1] != 0){
                result1 = robs[index-1];
            }else {
                result1 = robHelper(list, index-1,robs);
            }

            if(robs[index-2] != 0){
                result2 = robs[index-2];
            }else {
                result2 = robHelper(list, index-2, robs);
            }

            if(robs[index-3] != 0){
                result3 = robs[index-3];
            }else {
                result3 = robHelper(list,index-3, robs);
            }

            int maxValue1 = Math.max(result1, list.get(index) + result2);
            int maxValue2 = Math.max(maxValue1, list.get(index) + result3);
            robs[index] = maxValue2;
            return  robs[index];
        }
    }

    //Wrong Solution
    public int rob(TreeNode root){
        if(root == null){
            return  0;
        }
        List<Integer> heightSum = getHeight(root);
        int[] robs = new int[heightSum.size()];

        if(robs.length == 1){
            return  heightSum.get(0);
        }else if(robs.length == 2){
            return  heightSum.get(1);
        }else{
            robs[0] = heightSum.get(0);
            robs[1] = heightSum.get(1);
            return robHelper(heightSum, robs.length-1, robs);
        }

    }

    public int rob1(TreeNode root){
        return 0;
    }


    @Test
    public  void  test(){
       /* TreeNode l1 = new TreeNode(3);
        TreeNode l21 = new TreeNode(4);
        TreeNode l22 = new TreeNode(5);
        TreeNode l31  = new TreeNode(1);
        TreeNode l32 = new TreeNode(3);
        TreeNode l34 = new TreeNode(1);


        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l21.right = l32;
        l22.right = l34;*/

       TreeNode l1 = new TreeNode(4);
        TreeNode l2 = new TreeNode(1);
        TreeNode l3 = new TreeNode(2);
        TreeNode l4 = new TreeNode(3);

        l1.left = l2;
        l2.left = l3;
        l3.left = l4;

        long startTime = System.currentTimeMillis();
        int result = rob(l1);
        long endTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("Running time :  " + (endTime - startTime));
    }
}
