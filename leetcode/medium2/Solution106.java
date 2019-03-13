package interview.medium2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/2 0002.
 */
public class Solution106 {
    public class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    // it can be optimized
    public int search(int[] inorder, int value){
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == value){
                return  i;
            }
        }
        return -1;
    }

    public  TreeNode help(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2){
        if(start1 > end1 || start2 > end2){
            return  null;
        }

        if(start1 == end1 || start2 == end2){
            return  new TreeNode(inorder[start1]);
        }

        TreeNode root = new TreeNode(postorder[end2]);
        int index = search(inorder,postorder[end2]);
        int leftLength = index - start1;
        int rightLength = end1 - index;
        TreeNode rightNode = help(inorder, index+1, end1, postorder,end2 - rightLength, end2-1);
        TreeNode leftNode = help(inorder,start1, index-1, postorder, start2, start2+leftLength-1);

        root.left = leftNode;
        root.right = rightNode;
        return  root;

    }

    //Accepted ------3ms
    public  TreeNode buildTree(int[] inorder, int[] postorder){
        if(inorder.length == 0){
            return  null;
        }
        return  help(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);

    }

    /*
        for testing
     */

    public  void  preOrder(List<Integer> list, TreeNode root){
        if(root != null){
            list.add(root.val);
            preOrder(list, root.left);
            preOrder(list, root.right);
        }
    }

    public List<Integer> preTravesal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        preOrder(list, root);
        return  list;
    }

    @Test
    public  void  test(){
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode result = buildTree(inorder, postorder);
        List<Integer> l = preTravesal(result);
        for(int i = 0; i < l.size(); i++){
            System.out.print(l.get(i) + "  ");
        }
    }
}
