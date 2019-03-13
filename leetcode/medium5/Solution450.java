package algorithm.medium5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/10/6.
 */
public class Solution450 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public TreeNode sucessor(TreeNode root){
        if(root.left.left == null){
            return root;
        }else {
            return  sucessor(root.left);
        }
    }

    public  TreeNode find(TreeNode root, int key){
        if((root.left != null && root.left.val == key) ||
                (root.right != null && root.right.val ==key)){
            return root;
        }else if(root.val > key){
            return  find(root.left, key);
        }else {
            return  find(root.right, key);
        }
    }

    public  boolean exist(TreeNode root, int key){
        if(root == null){
            return  false;
        }
        if(root.val == key){
            return  true;
        }else if(root.val > key){
            return  exist(root.left, key);
        }else {
            return  exist(root.right,key);
        }
    }

    //Accepted ----6ms
    public  TreeNode deleteNode(TreeNode root, int key){
        if(!exist(root, key)){
            return  root;
        }

        if(root.val == key){
            if(root.right == null){
                TreeNode node = root.left;
                root.left = node;
                return  node;
            }else {
                if (root.right.left == null) {
                    root.right.left = root.left;
                    TreeNode node = root.right;
                    root.left = null;
                    root.right = null;
                    return node;
                } else {
                    TreeNode sucessorParent = sucessor(root.right);
                    TreeNode sucessorNode = sucessorParent.left;
                    sucessorParent.left = sucessorNode.right;
                    root.val = sucessorNode.val;
                    return root;
                }
            }
        }else {
            TreeNode targetNodeParent = find(root, key);
            TreeNode targetNode = null;
            if(targetNodeParent.left != null && targetNodeParent.left.val == key){
                targetNode = targetNodeParent.left;
                if(targetNode.right == null){
                    targetNodeParent.left = targetNode.left;
                }else {
                    if(targetNode.right.left == null){
                        targetNodeParent.left = targetNode.right;
                        targetNode.right.left = targetNode.left;
                        targetNode.left = null;
                        targetNode.right = null;
                    }else {
                        TreeNode sucessorParent = sucessor(targetNode.right);
                        TreeNode sucessorNode = sucessorParent.left;
                        sucessorParent.left = sucessorNode.right;
                        targetNode.val = sucessorNode.val;
                    }
                }
            }else {
                targetNode = targetNodeParent.right;
                if(targetNode.right == null){
                    targetNodeParent.right = targetNode.left;
                }else {
                    if(targetNode.right.left == null){
                        targetNodeParent.right = targetNode.right;
                        targetNode.right.left = targetNode.left;
                        targetNode.left = null;
                        targetNode.right = null;
                    }else {
                        TreeNode sucessorParent = sucessor(targetNode.right);
                        TreeNode sucessorNode = sucessorParent.left;
                        sucessorParent.left = sucessorNode.right;
                        targetNode.val = sucessorNode.val;
                    }
                }
            }
            return  root;
        }

    }

    public  void  preOrder(TreeNode root, List<Integer> list){
        if(root != null){
            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }

    public  List<Integer>  travesal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return  list;
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(5);
        TreeNode l21 = new TreeNode(3);
        TreeNode l22 = new TreeNode(9);
        TreeNode l31 = new TreeNode(2);
        TreeNode l32 = new TreeNode(4);
        TreeNode l33 = new TreeNode(6);
        TreeNode l34 = new TreeNode(12);
        TreeNode l41 = new TreeNode(7);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l21.right = l32;
        l22.right = l34;
        l22.left = l33;

        l33.right = l41;

        List<Integer> list = travesal(l1);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + "  ");
        }

        System.out.println();
        System.out.println("after delete.......");
        TreeNode result = deleteNode(l1,0);
        List<Integer> list1 = travesal(result);
        for(int i = 0; i < list1.size(); i++){
            System.out.print(list1.get(i) + "  ");
        }

    }

    @Test
    public  void  test1(){
        TreeNode l1 = new TreeNode(0);
        TreeNode result = deleteNode(l1, 0);
        System.out.println();
    }
}
