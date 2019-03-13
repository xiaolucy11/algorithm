package interview.easy;

import org.junit.Test;

import java.util.Vector;

/**
 * Created by Administrator on 2018/6/11 0011.
 */
public class Solution101 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public boolean isSymmetric(TreeNode root){
        if(root == null){return true;}

        if((root.left == null) && (root.right == null)){return true;}

        if(( root.right != null && root.left != null) ){
            if(root.left.val == root.right.val) {
                return isSymmetric(root.left) && isSymmetric(root.right);
            } else{
                return  false;
            }
        }else{
            return false;
        }
    }
    public Vector<Integer> preTraver1(TreeNode root){
        Vector<Integer> vector = new Vector<>();
        if(root != null){
            vector.add(root.val);
            Vector<Integer> leftVector = preTraver1(root.left);
            vector.addAll(leftVector);
            Vector<Integer> rightVector = preTraver1(root.right);
            vector.addAll(rightVector);

        }
        return vector;
    }
    public Vector<Integer> preTraver2(TreeNode root){
        Vector<Integer> vector = new Vector<>();
        if(root != null){
            vector.add(root.val);
            Vector<Integer> rightVector = preTraver2(root.left);
            vector.addAll(rightVector);
            Vector<Integer> leftVector = preTraver2(root.right);
            vector.addAll(leftVector);
        }
        return vector;
    }
    public boolean isSysmetric1(TreeNode root){
        if(root == null){return true;}
        else {
            Vector<Integer> vec1 = preTraver1(root);
            Vector<Integer> vecc2 = preTraver2(root);
            for(int i = 0; i < vec1.size(); i++){
                if(vec1.get(i) != vecc2.get(i)){
                    return false;
                }
            }
            return true;
        }
    }

    //true code
    public  boolean judge(TreeNode l, TreeNode r){
        if(l == null &&  r == null){return  true;}
        else if((l != null) && (r != null)){
            if(l.val == r.val) {
                return judge(l.left, r.right) && judge(l.right, r.left);
            }else{
                return false;
            }
        }else {
            return  false;
        }

    }
    public boolean isSysmetric2(TreeNode root){
        if(root == null){return true;}
        else {
            return judge(root.left, root.right);
        }
    }
    @Test
    public  void test(){
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);
        TreeNode left21 = new TreeNode(3);
        TreeNode left22 = new TreeNode(4);
        TreeNode right21 = new TreeNode(4);
        TreeNode right22 = new TreeNode(3);

        root.left = left1;
        root.right = right1;

        left1.left = left21;
        left1.right = left22;

        right1.left = right21;
        right1.right = right22;

        /*
        Vector<Integer> result = preTraver(root);
        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        */
        System.out.print(isSysmetric2(root));

    }
}
