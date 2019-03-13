package interview.easy1;

import org.junit.Test;
import java.util.Vector;

/**
 * Created by Administrator on 2018/6/25 0025.
 */
public class Solution235 {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p , TreeNode q){
        if(root == null){return  null;}
        if(p.left == q || p.right == q){
            return  p;
        }
        if(q.left == p || q.right == p){
            return  q;
        }
        if((root.left == p && root.right == q) || (root.left == q && root.right == p)){
            return root;
        }
        TreeNode leftLowestNode = lowestCommonAncestor(root.left, p, q);
        if(leftLowestNode != null){
            return  leftLowestNode;
        }else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    //Accepted
    public Vector<TreeNode> ancestors(TreeNode root, TreeNode p){
        if(root == p){return  null;}
        if(root.left == p || root.right == p){
            Vector<TreeNode> result = new Vector<>();
            result.add(root);
            result.add(p);
            return  result;
        }
        Vector<TreeNode> vector = new Vector<>();
        TreeNode pointer = root;
        while( pointer != p){
            vector.add(pointer);
            if(pointer.val < p.val){
                pointer = pointer.right;
            }else {
                pointer = pointer.left;
            }
        }
        vector.add(pointer);
        return  vector;
    }

    public  TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        if(p.left == q || p.right == q){
            return  p;
        }
        if(q.left == p || q.right == p){
            return  q;
        }
        if((root.left == p && root.right == q) || (root.left == q && root.right == p)){
            return root;
        }

        Vector<TreeNode> pAncestors = ancestors(root, p);
        Vector<TreeNode> qAncestors = ancestors(root, q);
        int pIndex = 0, qIndex = 0;
        while((pIndex < pAncestors.size()) && (qIndex < qAncestors.size())){
            if(pAncestors.get(pIndex).val == qAncestors.get(qIndex).val){
                pIndex++;
                qIndex++;
            }else {
                break;
            }
        }
        if(pIndex == pAncestors.size() ){ return pAncestors.get(pIndex - 1);}
        else  if(qIndex == qAncestors.size()) {return  qAncestors.get(qIndex - 1);}
        else {
            return  pAncestors.get(pIndex - 1);
        }
    }

    @Test
    public void  test(){
        TreeNode level1 = new TreeNode(6);
        TreeNode level21 = new TreeNode(2);
        TreeNode level22 = new TreeNode(8);
        TreeNode level31 = new TreeNode(0);
        TreeNode level32 = new TreeNode(4);
        TreeNode level33 = new TreeNode(7);
        TreeNode level34 = new TreeNode(9);
        TreeNode level43 = new TreeNode(3);
        TreeNode level44  = new TreeNode(5);

        level1.left = level21;
        level1.right = level22;

        level21.left = level31;
        level21.right = level32;
        level22.left = level33;
        level22.right = level34;

        level32.left = level43;
        level32.right = level44;

        TreeNode result = lowestCommonAncestor1(level1, level21, level43);
        System.out.print(result.val);
    }
}
