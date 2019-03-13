package interview.easy3;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2018/7/19 0019.
 */
public class Solution572 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    //Accepted ------283ms    not effecient
    public  List<TreeNode> find(TreeNode root, int value){
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        List<TreeNode>  result = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.val == value){
                result.add(node);
            }

            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return result;
    }
    public List<Integer> preOrder(TreeNode root){
        if(root == null){
            return  new ArrayList<Integer>();
        }
        if(root.left == null && root.right == null){
            return  new ArrayList<Integer>(){{add(root.val);}};
        }
        List<Integer> leftList = preOrder(root.left);
        List<Integer> rightList = preOrder(root.right);
        if(leftList.size() != 0){
            leftList.add(0, root.val);
            leftList.addAll(rightList);
            return  leftList;
        }else {
            rightList.add(0, root.val);
            return  rightList;
        }
    }

    public  List<Integer> inOrder(TreeNode root){
        if(root == null){
            return  new ArrayList<Integer>();
        }
        if(root.left == null && root.right == null){
            return  new ArrayList<Integer>(){{add(root.val);}};
        }

        List<Integer> leftList = inOrder(root.left);
        List<Integer> rightList = inOrder(root.right);
        if(leftList.size() != 0){
            leftList.add(root.val);
            leftList.addAll(rightList);
            return  leftList;
        }else {
            rightList.add(0, root.val);
            return rightList;
        }
    }

    public  List<Integer> postOrder(TreeNode root){
        if(root == null){
            return  new ArrayList<Integer>();
        }
        if(root.left == null && root.right == null){
            return  new ArrayList<Integer>(){{add(root.val);}};
        }
        List<Integer> leftList = postOrder(root.left);
        List<Integer> rightList = postOrder(root.right);
        if(leftList.size() != 0){
            leftList.addAll(rightList);
            leftList.add(root.val);
            return  leftList;
        }else {
            rightList.add(root.val);
            return  rightList;
        }
    }

    public  boolean check(TreeNode root, TreeNode t){
        List<Integer> targetNodePreOrder = preOrder(root);
        List<Integer> targetNodeInOrder = inOrder(root);
        List<Integer> tNodePreOrder = preOrder(t);
        List<Integer> tNodeInOrder = inOrder(t);

        if(targetNodeInOrder.size() != tNodePreOrder.size()){
            return false;
        }
        for(int i = 0; i < targetNodeInOrder.size(); i++){
            if((!targetNodePreOrder.get(i).equals(tNodePreOrder.get(i)))  || (targetNodeInOrder.get(i).equals(tNodeInOrder.get(i)))){
                return  false;
            }
        }
        return  true;
    }

    public boolean isSubtree(TreeNode s, TreeNode t){
        if(s == null){return  false;}
        List<TreeNode> list = find(s, t.val);
        if(list.size() == 0){
            return  false;
        }
        for(TreeNode l : list){
            if(check(l, t)){
                return  true;
            }
        }
        return  false;
    }

    //Solution2 ------- failue
    public  boolean isEqual(List<Integer> l1, List<Integer> l2){
        int index1 = 0, index2 = 0;

        while (index1 < l1.size() && !l1.get(index1).equals(l2.get(index2))){
            index1++;
        }
        int index11 = index1;
        while ((index11 < l1.size()) && (index2 < l2.size())){
            if(l1.get(index1).equals(l2.get(index2))){
                index11++;
                index2++;
            }else {
                index1++;
                index11 = index1;
                index2 = 0;
            }
        }
        if(index2 == 0 || index2 != l2.size()){return  false;}
        return  true;
    }

    public  boolean isSubtree1(TreeNode s, TreeNode t){
        if(s == null){
            return  false;
        }
        List<Integer> sPreOrder = preOrder(s);
        List<Integer> sInOrder = inOrder(s);
        List<Integer> tPreOrder = preOrder(t);
        List<Integer> tInOrder = inOrder(t);
        List<Integer> sPostOrder = postOrder(s);
        List<Integer> tPostOrder = postOrder(t);
        if(!isEqual(sPreOrder, tPreOrder) || !isEqual(sInOrder, tInOrder)
                || !isEqual(sPostOrder, tPostOrder)){
            return  false;
        }
        return  true;
    }


    public  boolean isSameTree(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return  true;
        }
        if(s == null || t == null){return  false;}
        if((s.left == null && s.right == null)  && (t.left == null && t.right == null)){
            if(s.val == t.val){return  true;}
            else {
                return  false;
            }
        }
        if(s.val == t.val){
            return  isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }else {
            return  false;
        }
    }
    //Acceped -------14ms
    public  boolean isSubtree2(TreeNode s, TreeNode t){
        if(s == null){
            return false;
        }
        if(s.val == t.val){
            return  (isSameTree(s.left, t.left) && isSameTree(s.right, t.right)) ||
                    (isSubtree(s.left, t) || isSubtree(s.right, t));
        }else {
            return  isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    @Test
    public  void test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(1);
        l1.left = l21;
       /* TreeNode l21 = new TreeNode(4);
        TreeNode l22 = new TreeNode(5);
        TreeNode l31 = new TreeNode(1);
        TreeNode l32 = new TreeNode(2);*/


        TreeNode t1 = new TreeNode(1);
       /* TreeNode t21 = new TreeNode(1);
        TreeNode t22 = new TreeNode(2);

        l1.left = l21;
        l1.right = l22;

        l21.left = l31;
        l21.right = l32;



        t1.left = t21;
        t1.right = t22;*/

       /* TreeNode l1= new TreeNode(1);
        TreeNode l21 = new TreeNode(1);
        l1.left = l21;*/

      /*  List<Integer> preOrder = inOrder(t1);
        for(int i = 0 ; i < preOrder.size(); i++){
            System.out.print(preOrder.get(i) + "  ");
        }*/

      System.out.print(isSubtree2(l1, t1));






    }
}
