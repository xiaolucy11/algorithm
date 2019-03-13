package interview.medium2;

import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2018/9/1 0001.
 */
public class Solution103 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    //Accepted ------2ms
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        if(root == null){
            return  new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<List<TreeNode>> queue = new ArrayDeque<>();
        List<TreeNode> input = new ArrayList<>();
        input.add(root);
        queue.add(input);
        int level = 1;
        while (!queue.isEmpty()){

            List<TreeNode> nodes = queue.poll();
            List<Integer> list = new ArrayList<>();
            /*
                input.clear();
                this is some problems
             */
            input = new ArrayList<>();

            for(int i = nodes.size() - 1; i >= 0; i--) {
                list.add(nodes.get(i).val);
                if (level % 2 == 1) {
                    if (nodes.get(i).right != null) {
                        input.add(nodes.get(i).right);
                    }
                    if (nodes.get(i).left != null) {
                        input.add(nodes.get(i).left);
                    }
                }else {
                    if (nodes.get(i).left != null) {
                        input.add(nodes.get(i).left);
                    }
                    if (nodes.get(i).right != null) {
                        input.add(nodes.get(i).right);
                    }
                }
            }

            Collections.reverse(list);
            result.add(list);
            level++;
            if(!input.isEmpty()) {
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
        List<List<Integer>> result =  zigzagLevelOrder(l1);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + "  ");
            }
            System.out.println();
        }
    }

}
