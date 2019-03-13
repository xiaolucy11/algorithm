package interview.easy3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/22 0022.
 */
public class Solution606 {
    public class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public void  tree2strHelp(StringBuilder result, TreeNode root){
        if(root == null){return; }
        if(root != null){
            result.append(Integer.toString(root.val));
        }
        if((root.left == null ) && (root.right == null)){
            return;
        }else  if(root.left == null && root.right != null){
            result.append("()");

            result.append('(');
            tree2strHelp(result, root.right);
            result.append(')');
            //tree2strHelp(result, root.left);
        }else  if(root.right == null && root.left != null){
            result.append('(');
            tree2strHelp(result, root.left);
            result.append(')');
        }else {
            result.append('(');
            tree2strHelp(result, root.left);
            result.append(')');

            result.append('(');
            tree2strHelp(result, root.right);
            result.append(')');
        }
//        System.out.println("result : " + result);
    }

    //Accepted -----10ms
    public  String tree2str(TreeNode t){
        StringBuilder result = new StringBuilder();
        tree2strHelp(result, t);
        return  result.toString();
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(3);
        TreeNode l32 = new TreeNode(4);

        l1.left = l21;
        l1.right = l22;

        l21.left = l32;
        System.out.println(tree2str(l1));
    }
}
