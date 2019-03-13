package algorithm.medium3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/9/12.
 */
public class Solution230 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x){
            val = x;
        }
    }

    public  int kthSmallValue;

    public  void  search(TreeNode root,List<Integer> list, int k){
        if(root != null){
            search(root.left,list,k);
            list.add(root.val);
            if(list.size() == k){
                kthSmallValue = root.val;
                return;
            }
            search(root.right, list,k);
        }
    }
    //Accepted----2ms
    /*
        it can be optimized.
        not using list, rather than using a count counting the size of list
     */
    public  int kthSmallest(TreeNode root, int k){
        List<Integer> list = new ArrayList<>();
        kthSmallValue = Integer.MIN_VALUE;
        search(root, list, k);
        return kthSmallValue;

    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(5);
        TreeNode l21 = new TreeNode(3);
        TreeNode l22 = new TreeNode(6);
        TreeNode l31 = new TreeNode(2);
        TreeNode l32 = new TreeNode(4);
        TreeNode l41 = new TreeNode(1);

        l1.left = l21;
        l1.right = l22;

        l21.left = l31;
        l21.right = l32;

        l31.left = l41;
        System.out.print(kthSmallest(l1,3));
    }
}
