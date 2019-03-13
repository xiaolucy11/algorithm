package interview.easy1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/26 0026.
 */
public class Solution257 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root){
        if(root == null){return  new ArrayList<>();}
        if(root.left == null && root.right == null){
            List<String> l1 = new ArrayList<>();
            l1.add(Integer.toString(root.val));
            return  l1;
        }

        List<String> leftList = binaryTreePaths(root.left);
        List<String> rightList = binaryTreePaths(root.right);
        if(leftList != null) {
            for (int i = 0; i < leftList.size(); i++) {
                String str1 = Integer.toString(root.val) + "->" + leftList.get(i);
                leftList.set(i, str1);
            }
        }
        if(rightList != null) {
            for (int j = 0; j < rightList.size(); j++) {
                String str2 = Integer.toString(root.val) + "->" + rightList.get(j);
                rightList.set(j, str2);
            }
        }
        if(leftList != null && rightList == null){return  leftList;}
        else  if(leftList == null && rightList != null){return  rightList;}
        else {
            leftList.addAll(rightList);
            return leftList;
        }

    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(3);
        TreeNode l32 = new TreeNode(5);
        TreeNode l33 = new TreeNode(7);

        l1.left = l21;
        l1.right = l22;

        l21.right = l32;
        l22.left = l33;

        List<String> result = binaryTreePaths(l1);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
    }
}
