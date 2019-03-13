package algorithm.medium8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/11/1.
 */
public class Solution701 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    //Accepted ----2ms
    public  TreeNode insertIntoBST(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode p = root;
        while (p != null){
            if(p.val < val){
                if(p.right == null){
                    break;
                }else {
                    p = p.right;
                }
            }else {
                if(p.left == null){
                    break;
                }else {
                    p = p.left;
                }
            }
        }

        TreeNode insertNode = new TreeNode(val);
        if(p.val < val){
            p.right = insertNode;
        }else {
            p.left = insertNode;
        }

        return  root;
    }

    public  void  inOrder(TreeNode root, List<Integer> list){
        if(root != null){
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }

    public List<Integer> inTravesal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return  list;
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(4);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(7);
        TreeNode l31 = new TreeNode(1);
        TreeNode l32 = new TreeNode(3);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l21.right = l32;

        int val = 5;

        List<Integer> list1 = inTravesal(l1);
        TreeNode result = insertIntoBST(l1, val);
        List<Integer> list2 = inTravesal(result);

        for(int i = 0; i < list1.size(); i++){
            System.out.print(list1.get(i) + "  ");
        }
        System.out.println();

        for(int i = 0; i < list2.size(); i++){
            System.out.print(list2.get(i) + "  ");
        }
        System.out.println();
    }

}
