package algorithm.hard1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlu on 2018/12/17.
 */
public class Solution124 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public Map<TreeNode, Integer> map;
    public  int maxLength;

    public  boolean isLeaf(TreeNode node){
        if(node.right == null && node.left == null){
            return  true;
        }else {
            return  false;
        }
    }

    public  void search(TreeNode root){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){
            map.put(root, root.val);
            if(root.val > maxLength){
                maxLength = root.val;
            }
           return;
        }


        int leftValue = 0,rightValue = 0;
        if(!map.containsKey(root.left)){
             search(root.left);
        }
        if(root.left != null) {
            leftValue = map.get(root.left);
        }

        if(!map.containsKey(root.right)){
            search(root.right);
        }
        if(root.right != null) {
            rightValue = map.get(root.right);
        }

        if((root.left != null && isLeaf(root.left) &&
                (root.right != null && isLeaf(root.right)))){
            int value1 = root.val + leftValue;
            int value2 = root.val + rightValue;
            int value3 = root.val + leftValue + rightValue;
            maxLength = Math.max(maxLength, Math.max(value1, Math.max(value2, value3)));
            maxLength = Math.max(maxLength, root.val);

            map.put(root, Math.max(root.val, Math.max(value1, value2)));
            return;
        }

        if(leftValue == 0 && rightValue == 0){
                if(root.val > maxLength){
                    maxLength = root.val;
                }
                map.put(root, root.val);

        }else if(leftValue == 0 && rightValue != 0){
            map.put(root, Math.max(root.val, root.val + rightValue));
        }else if(leftValue != 0 && rightValue == 0){
            map.put(root, Math.max(root.val,root.val+ leftValue));
        }else {
            if (leftValue < 0 && rightValue < 0) {
                map.put(root, root.val);
            } else if (leftValue < 0 && rightValue > 0) {
                map.put(root, root.val + rightValue);
            } else if (leftValue > 0 && rightValue < 0) {
                map.put(root, root.val + leftValue);
            } else {
                map.put(root, Math.max(root.val + leftValue, root.val+ rightValue));
                maxLength = Math.max(maxLength, Math.max(root.val,root.val + leftValue));
                maxLength = Math.max(maxLength,Math.max(root.val + rightValue, root.val + leftValue + rightValue));
            }
        }

        if(map.get(root) > maxLength){
            maxLength = map.get(root);
        }
    }


    //Accepted ----- 17ms
    /*
        dp algorithm
     */
    public int maxPathSum(TreeNode root){
        map = new HashMap<>();
        maxLength = Integer.MIN_VALUE;
        search(root);
        return maxLength;
    }


    @Test
    public  void  test(){
        /*TreeNode l1 = new TreeNode(-2);
        TreeNode l21 = new TreeNode(-3);
        TreeNode l22 = new TreeNode(-1);

        l1.left = l21;
        l1.right = l22;*/


       /*TreeNode l1  = new TreeNode(-10);
        TreeNode l21 = new TreeNode(9);
        TreeNode l22 = new TreeNode(20);
        TreeNode l33 = new TreeNode(15);
        TreeNode l34 = new TreeNode(7);

        l1.left = l21;
        l1.right = l22;
        l22.left = l33;
        l22.right = l34;*/

    /* TreeNode l1 = new TreeNode(-1);
        TreeNode l21 = new TreeNode(-2);
        l1.left = l21;*/

    /*TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(-2);
        TreeNode l22 = new TreeNode(-3);
        TreeNode l31 = new TreeNode(1);
        TreeNode l32 = new TreeNode(3);
        TreeNode l33 = new TreeNode(-2);
        TreeNode l41 = new TreeNode(-1);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l21.right = l32;
        l22.left = l33;
        l31.left = l41;*/

        TreeNode l1 = new TreeNode(5);
        TreeNode l21 = new TreeNode(4);
        TreeNode l22 = new TreeNode(8);
        TreeNode l31 = new TreeNode(11);
        TreeNode l33 = new TreeNode(13);
        TreeNode l34 = new TreeNode(4);
        TreeNode l41 = new TreeNode(7);
        TreeNode l42 = new TreeNode(2);
        TreeNode l44 = new TreeNode(1);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l22.left = l33;
        l22.right = l34;
        l31.left = l41;
        l31.right = l42;
        l34.right = l44;


        long startTime = System.currentTimeMillis();
        int result = maxPathSum(l1);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
