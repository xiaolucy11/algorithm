package algorithm.medium10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/11/20.
 */
public class Solution814 {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    //Accepted ----2ms
    public  TreeNode pruneTree(TreeNode root){
        if(root == null){
            return  root;
        }
        if(root.left == null && root.right == null){
            if(root.val == 0){
                return  null;
            }else {
                return  root;
            }
        }
        TreeNode leftNode = pruneTree(root.left);
        TreeNode rightNode = pruneTree( root.right);

        if(leftNode == null && rightNode == null && root.val == 0){
            return null;
        }else {
            root.left = leftNode;
            root.right = rightNode;
            return  root;
        }

    }

    public  void  preOrder(TreeNode root, List<Integer> list){
        if(root != null){
            list.add(root.val);
            preOrder(root.left,list);
            preOrder(root.right, list);
        }
    }

    public List<Integer> preTravesal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }


    @Test
    public  void  test(){
       /* TreeNode l1 = new TreeNode(1);
        TreeNode l22 = new TreeNode(0);
        TreeNode l33 = new TreeNode(0);
        TreeNode l34 = new TreeNode(1);

        l1.right = l22;
        l22.left = l33;
        l22.right = l34;*/

       /*TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(0);
        TreeNode l22 = new TreeNode(1);
        TreeNode l31 = new TreeNode(0);
        TreeNode l32 = new TreeNode(0);
        TreeNode l33 = new TreeNode(0);
        TreeNode l34 = new TreeNode(1);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l21.right = l32;
        l22.left = l33;
        l22.right = l34;*/


       TreeNode l1= new TreeNode(1);
        TreeNode l21= new TreeNode(1);
        TreeNode l22= new TreeNode(0);
        TreeNode l31= new TreeNode(1);
        TreeNode l32= new TreeNode(1);
        TreeNode l33= new TreeNode(0);
        TreeNode l34= new TreeNode(1);
        TreeNode l41= new TreeNode(0);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l21.right = l32;
        l22.left = l33;
        l22.right = l34;
        l31.left = l41;

        long startTime = System.currentTimeMillis();
        List<Integer> result = preTravesal(pruneTree(l1));
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i));
        }
        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }
}
