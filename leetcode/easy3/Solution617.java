package interview.easy3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2018/7/22 0022.
 */
public class Solution617 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public  TreeNode  traveral(TreeNode t1, TreeNode t2){
        TreeNode result = new TreeNode(0);
        TreeNode leftNode =  null;
        TreeNode rightNode = null;

            if(t1 != null && t2 != null){
                result.val = t1.val + t2.val;

                leftNode = traveral(t1.left, t2.left);
                result.left = leftNode;
               rightNode =  traveral(t1.right, t2.right);
                result.right = rightNode;

            }else  if(t1 != null && t2 == null){
                result.val = t1.val;

                leftNode = traveral(t1.left, null);
                result.left = leftNode;
                rightNode =  traveral(t1.right, null);
                result.right = rightNode;

            }else if(t2 != null && t1 == null){
                result.val = t2.val;

                leftNode =  traveral(null, t2.left);
                result.left = leftNode;
                rightNode = traveral(null, t2.right);
                result.right = rightNode;

            }else {
                return null;
            }
            return  result;

    }
    //Acceptd -----9ms  mergeTrees(TreeNode t1, TreeNode t2)
    public  TreeNode merge(TreeNode t1, TreeNode t2){
       return  traveral(t1, t2);
    }
    public  List<Integer> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }

        }
        return  list;
    }



    @Test
    public  void  test(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(3);
        TreeNode t22 = new TreeNode(2);
        TreeNode t31 = new TreeNode(5);

        t1.left = t21;
        t1.right = t22;
        t21.left = t31;

        TreeNode  l1 = new TreeNode(2);
        TreeNode l21 = new TreeNode(1);
        TreeNode l22 = new TreeNode(3);
        TreeNode l32 = new TreeNode(4);
        TreeNode l34  = new TreeNode(7);

        l1.left = l21;
        l1.right = l22;
        l21.right = l32;
        l22.right = l34;

        TreeNode result = merge(t1, l1);
        List<Integer> list = levelOrder(result);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + "  ");
        }
    }
}
