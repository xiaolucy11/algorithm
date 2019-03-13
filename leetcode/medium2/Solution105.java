package interview.medium2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/1 0001.
 */
public class Solution105 {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public int search(int[] inorder, int value){
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == value){
                return  i;
            }
        }
        return  -1;
    }

    public  TreeNode help(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2){
        if(start1 > end1 || start2 > end2){
            return null;
        }
        if(start1 == end1 || start2 == end2){
            return  new TreeNode(inorder[start2]);
        }
        TreeNode root = new TreeNode(preorder[start1]);
        int index = search(inorder,preorder[start1]);
        int leftLength = index - start2;
        // int rightLength = end2 - index;
        TreeNode leftNode = help(preorder, start1+1, start1+leftLength, inorder, start2, index-1 );
        TreeNode rightNode = help(preorder, start1+leftLength+1, end1, inorder, index+1, end2);
        root.left = leftNode;
        root.right = rightNode;
        return  root;
    }

    //Accepted ----- 51ms
    public  TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length == 0){
            return  null;
        }

        return  help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length-1);
    }

    public  void  postorder(List<Integer> list, TreeNode root){
        if(root != null){
            postorder(list, root.right);
            list.add(root.val);
            postorder(list, root.left);
        }
    }
    /*
        for testing
     */
    public List<Integer> postTravel(TreeNode root){
        List<Integer> list = new ArrayList<>();
        postorder(list, root);
        return  list;
    }

    @Test
    public  void  test(){
        int[] preorder = {1,2};
        int[] inorder = {2,1};
        TreeNode root = buildTree(preorder, inorder);
        List<Integer> result = postTravel(root);

        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
    }
}
