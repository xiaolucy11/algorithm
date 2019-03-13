package interview.easy3;

import org.junit.Test;

import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator on 2018/7/15 0015.
 */
public class Solution530 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public Vector<Integer> traver(TreeNode root){
        if(root == null){
            return  new Vector<Integer>();
        }
        if(root.right == null && root.left == null){
            return  new Vector<Integer>(){{add(root.val);}};
        }
        Vector<Integer> leftVector = traver(root.left);
        Vector<Integer> rightVector = traver((root.right));
        if(leftVector.size() != 0 && rightVector.size() != 0) {
            leftVector.add(root.val);
            leftVector.addAll(rightVector);
            return leftVector;
        }else if(leftVector.size() != 0 && rightVector.size() == 0){
            leftVector.add(root.val);
            return  leftVector;
        }else if(leftVector.size() == 0 && rightVector.size() != 0){
            rightVector.add(0, root.val);
            return  rightVector;
        }else {
            return  new Vector<Integer>(); // not return
        }
    }

    //Accepted --------18ms
    public int getMinimumDifference(TreeNode root){
       /* Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        int minValue = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.left != null){
                queue.add(temp.left);
                if(Math.abs(temp.val - temp.left.val) < minValue){
                    minValue = Math.abs(temp.val - temp.left.val);
                }
            }
            if(temp.right != null){
                queue.add(temp.right);
                if(Math.abs(temp.val - temp.right.val) < minValue){
                    minValue = Math.abs(temp.val - temp.right.val);
                }
            }
        }
        return  minValue;*/
       Vector<Integer> vector = traver(root);
        int minValue = Integer.MAX_VALUE;
        for(int i = 1; i < vector.size(); i++){
            if (Math.abs(vector.get(i) - vector.get(i-1)) < minValue){
                minValue = Math.abs(vector.get(i) - vector.get(i-1));
            }
        }
        return  minValue;
    }


    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(3);
        TreeNode l3 = new TreeNode(2);

        l1.right = l2;
        l2.right = l3;

        System.out.print(getMinimumDifference(l1));
    }
}
