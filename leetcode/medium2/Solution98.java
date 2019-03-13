package interview.medium2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/1 0001.
 */
public class Solution98 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    /*
        wrong solution
     */
    public  boolean isValidBST(TreeNode root){
       if(root.left != null && root.right != null){
           if(root.left.val < root.val && root.right.val >  root.val){
               return  isValidBST(root.left) && isValidBST(root.right);
           }else {
               return  false;
           }
       }else  if(root.left != null){
           if(root.left.val < root.val){
               return  isValidBST(root.left);
           }else {
               return  false;
           }
       }else  if(root.right != null){
           if(root.right.val > root.val){
               return  isValidBST(root.right);
           }else {
               return  false;
           }
       }else {
           return  true;
       }
    }
    public  void  inorder(List<Integer> list , TreeNode root){
        if(root != null){
            inorder(list, root.left);
            list.add(root.val);
            inorder(list, root.right);
        }
    }


    //Accepted ------- 3ms
    /*
        two pass
     */
    public  boolean isValidBST1(TreeNode root){
        if(root == null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        inorder(list, root);
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) < list.get(i-1)){
                return  false;
            }
        }
        return  true;
    }
    public  int flag ;
    public  void  inorder1(List<Integer> list, TreeNode root){
        if(root != null){
            inorder1(list, root.left);
            if(!list.isEmpty() && root.val <= list.get(list.size() -1)){
                flag = 1;
                return;
            }
            list.add(root.val);
            inorder1(list, root.right);
        }
    }

    //Accepted ---2ms
    /*
        one pass
     */
    public  boolean isValidBST2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        flag = 0;
        inorder1(list, root);
        if(flag == 1){
            return  false;
        }else {
            return  true;
        }
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(5);
        TreeNode l21 = new TreeNode(1);
        TreeNode l22 = new TreeNode(4);
        TreeNode l33 = new TreeNode(3);
        TreeNode l34 = new TreeNode(6);

        l1.left = l21;
        l1.right = l22;

        l22.left = l33;
        l22.right = l34;
        System.out.print(isValidBST2(l1));
    }
}
