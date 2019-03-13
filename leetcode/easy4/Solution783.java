package interview.easy4;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2018/8/1 0001.
 */
public class Solution783 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val  = x;
        }
    }

    //Wrong solution
    public  int minDiffInBST(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int minValue = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                if(node.val - node.left.val < minValue){
                    minValue = node.val - node.left.val;
                }
                queue.add(node.left);
            }

            if(node.right != null){
                if(node.right.val - node.val < minValue){
                    minValue = node.right.val - node.val;
                }
                queue.add(node.right);
            }
        }
        return  minValue;
    }


    public  void travel(List<Integer> list, TreeNode root){
        if(root != null){
            travel(list, root.left);
            list.add(root.val);
            travel(list, root.right);
        }
    }

    //Accepted ---- 3ms
    public  int minDiffInBST1(TreeNode root){
        List<Integer> list = new ArrayList<>();
        travel(list, root);
         int minValue = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) - list.get(i - 1) < minValue){
                minValue = list.get(i) - list.get(i-1);
            }
        }
        return  minValue;
    }

    public  int minValue;
    public  void   travel1(List<Integer> list, TreeNode root){
          if(root != null) {
              travel1(list, root.left);
              if ( !list.isEmpty() && root.val - list.get(list.size() - 1) < minValue) {
                  minValue = root.val - list.get(list.size() - 1);
              }
              list.add(root.val);
              travel1(list, root.right);
          }

    }
 //Accepted -- 3ms  in the process of inorder, to compute the minimum
    public  int minDiffInBST2(TreeNode root){
        minValue = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        travel1(list, root);
        return  minValue;
    }



    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(4);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(6);
        TreeNode l31 = new TreeNode(1);
        TreeNode l32 = new TreeNode(3);

        l1.left = l21;
        l1.right = l22;

        l21.left = l31;
        l21.right = l32;

        System.out.print(minDiffInBST2(l1));
    }
}
