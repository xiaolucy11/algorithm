package interview.medium3;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2018/9/11 0011.
 */
public class Solution222 {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x){
            val = x;
        }
    }

    //Time Limited Out
    public  int countNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        List<TreeNode> input = new ArrayList<>();
        Queue<List<TreeNode>> queue = new ArrayDeque<>();
        input.add(root);
        int count = 0;
        queue.add(input);
        while (!queue.isEmpty()){
            List<TreeNode> output = queue.poll();
            count += output.size();
            input = new ArrayList<>();
            for(int i = 0; i < output.size(); i++){
                if(output.get(i).left != null){
                    input.add(output.get(i).left);
                }
                if(output.get(i).right != null){
                    input.add(output.get(i).right);
                }else {
                    break;
                }
            }
            if(input.size() != 0){
                queue.add(input);
            }
        }
        return count;
    }
    public  int getLevel (TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }
        return  1 + getLevel(root.left);
    }

    public int n1;
    public  int n2;
    public int level;

    public  void  search(TreeNode root, int high){
        if(high == level - 1){
            if(root.left != null && root.right != null){
                n2++;
                return;
            }

            if(root.left != null && root.right == null){
                n1++;
                return;
            }
        }

        if(root.left != null && root.right != null){
            n2++;
            search(root.left, high+1);
            search(root.right, high+1);
        }

        if(root.left != null && root.right == null){
            n1++;
            search(root.left, high+1);
        }
    }

    //Time Limited Out
    public  int countNodes1(TreeNode root){
       n1 = 0;
        n2 = 0;
        level = getLevel(root);
        search(root, 1);
        return 2 * n2 + n1 + 1;
    }

    public  int getleftDepth(TreeNode root){
        if(root == null){
            return 0;
        }

       /* if(root.left == null && root.right == null){
            return  1;
        }

        return  1 + getleftDepth(root.left);*/
       TreeNode p = root;
        int count = 0;
        while (p != null){
            count++;
            p = p.left;
        }
        return  count;
    }

    public  int getRightDepth(TreeNode root){
        if(root == null){
            return 0;
        }

       /* if(root.left == null && root.right == null){
            return  1;
        }*/
       TreeNode p = root;
        int count = 0;
        while (p != null){
            count++;
            p = p.right;
        }

        return  count;
    }

    //Accepted ----321ms
    public  int countNodes2(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = getleftDepth(root);
        int rightDepth = getRightDepth(root);

        if(leftDepth == rightDepth){
            return (int) Math.pow(2, leftDepth) - 1;
        }
        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }

    /*
        reference from other
        hard to think out this solution
        */
    public int countNodes3(TreeNode root) {
        int leftHeight = height(root);
        if (leftHeight == 0) {
            return 0;
        }
        int rightHeight = height(root.right);
        if (leftHeight - 1 == rightHeight) {
            return (1 << (leftHeight - 1)) + countNodes(root.right);
        }
        return (1 << (rightHeight)) + countNodes(root.left);
    }
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + height(root.left);
    }



    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(3);
        TreeNode l31 = new TreeNode(4);
        TreeNode l32 = new TreeNode(5);
        TreeNode l33 =new TreeNode(6);

        l1.left = l21;
        l1.right = l22;

        l21.left = l31;
        l21.right = l32;

        l22.left = l33;

        System.out.print(countNodes2(l1));
    }
}
