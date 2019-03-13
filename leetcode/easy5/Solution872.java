package interview.easy5;

import interview.easy4.Solution687;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/6 0006.
 */
public class Solution872 {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public void  inorder(List<Integer> list, TreeNode root){
        if(root != null){
            if(root.left == null && root.right == null){
                list.add(root.val);
            }
            inorder(list, root.left);
            inorder(list, root.right);

        }
    }

    //Accepted ---------2ms
    public  boolean leafSimilar(TreeNode root1, TreeNode root2){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(list1, root1);
        inorder(list2, root2);
        if(list1.size() != list2.size()){
            return  false;
        }
        for(int i = 0; i < list1.size(); i++){
            if(list1.get(i) != list2.get(i)){
                return  false;
            }
        }
        return  true;
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(3);
        TreeNode l21 = new TreeNode(5);
        TreeNode l22 = new TreeNode(1);
        TreeNode l31 = new TreeNode(6);
        TreeNode l32 = new TreeNode(2);
        TreeNode l33 = new TreeNode(9);
        TreeNode l34 = new TreeNode(8);
        TreeNode l43 = new TreeNode(7);
        TreeNode l44 = new TreeNode(4);

        l1.left = l21;
        l1.right = l22;

        l21.left = l31;
        l21.right = l32;
        l22.left = l33;
        l22.right = l34;

        l32.left = l43;
        l32.right = l44;
        List<Integer> list = new ArrayList<>();
        inorder(list, l1);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
