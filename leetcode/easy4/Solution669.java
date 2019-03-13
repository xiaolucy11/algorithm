package interview.easy4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
public class Solution669 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x){
            val = x;
        }
    }
    /*public  void trim(TreeNode root, int L, int R){
        if(root == null){
            return  ;
        }
        if(root.val > R){
            trim( root.left, L, R);
        }

    }*/


    //Accepted -----3ms
    public  TreeNode trimBST(TreeNode root, int L, int R){
        if (root == null){return  null;}

        if(root.val > R){
            //root = root.left;
            return  trimBST(root.left, L, R);
        }
        if(root.val < L){
//          root = root.right;
            return  trimBST(root.right, L, R);
        }
        TreeNode leftTrimNode = trimBST(root.left, L, R);
        TreeNode rightTrimNOde = trimBST(root.right, L, R);
        root.left = leftTrimNode;
        root.right = rightTrimNOde;
        return  root;
    }
    public  void  inorder(List<Integer> list, TreeNode root){
        if(root != null){
            list.add(root.val);
            inorder(list, root.left);
            inorder(list, root.right);
        }
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(3);
        TreeNode l21 = new TreeNode(0);
        TreeNode l22 = new TreeNode(4);
        TreeNode l32 = new TreeNode(2);
        TreeNode l43 = new TreeNode(1);

        l1.left = l21;
        l1.right = l22;
        l21.right = l32;
        l32.left = l43;

        TreeNode result = trimBST(l1,1,2);
        List<Integer> list = new ArrayList<>();
        inorder(list, result);

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + "  ");
        }

    }
}
