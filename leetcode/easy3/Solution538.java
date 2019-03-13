package interview.easy3;

import interview.easy2.Solution437;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by Administrator on 2018/7/17 0017.
 */
public class Solution538 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public  int sum = 0;
    public Map<Integer, Integer> map = new HashMap<>();

    public  void  initial(){
        sum = 0;
        map.clear();
    }


    //wrong solution----------first solution
    public  int computeSum(TreeNode root, int val){
        if(root == null){return  0;}
        if(root.left == null && root.right == null){
            if(root.val > val){return root.val;}
            else {return  0;}
        }
        int leftSum = computeSum(root.left, val);
        int rightSum = computeSum(root.right, val);

        return  root.val + leftSum + rightSum;

    }
   public  TreeNode convertBST(TreeNode root){
        if(root == null){return  null;}
        if(root.left == null && root.right == null){return  root;}

       Queue<TreeNode> queue = new ConcurrentLinkedDeque<>();
        queue.add(root);
       while (!queue.isEmpty()){
           TreeNode node = queue.poll();
           node.val = computeSum(root, node.val);
           if(node.left != null){
               queue.add(node.left);
           }
           if(node.right != null){
               queue.add(node.right);
           }
       }
       return  root;
    }


    //seconde solution
    //Accepted -----15ms
    public  void  inOrder1(TreeNode root){
        if(root != null){
            inOrder1(root.left);
            if(!map.containsKey(root.val)){
                sum += root.val;
                map.put(root.val, sum);
            }
            inOrder1(root.right);
        }
    }
    public  void  inOrder2(TreeNode root){
        if(root != null){
            inOrder2(root.left);
            root.val = sum - map.get(root.val) + root.val;
            inOrder2(root.right);
        }
    }

    public TreeNode convertBST1(TreeNode root){
        inOrder1(root);;
        inOrder2(root);
        initial();
        return  root;
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(5);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(13);

        l1.left = l21;
        l1.right = l22;

        TreeNode result = convertBST1(l1);
        System.out.print(result.val + " " + result.left.val + "  " + result.right.val);
    }
}
