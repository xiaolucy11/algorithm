package interview.medium2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/1 0001.
 */
public class Solution94 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    private  void  help(List<Integer> list, TreeNode root){
        if(root != null){
            help(list, root.left);
            list.add(root.val);
            help(list, root.right);
        }
    }
    //Accepted ----0ms
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        help(result, root);
        return  result;
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        TreeNode l33 = new TreeNode(3);

        l1.right = l21;
        l21.left = l33;
        List<Integer> result = inorderTraversal(l1);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
    }
}
