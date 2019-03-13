package algorithm.hard1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by youlu on 2018/12/15.
 */
public class Solution99 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public  TreeNode find(TreeNode root, int value){
        if(root == null){
            return  null;
        }

        if(root.val == value){
            return  root;
        }else if(root.val < value){
            return  find(root.right, value);
        }else {
            return  find(root.left, value);
        }
    }

    public void inorder(TreeNode root, List<TreeNode> list){
        if(root != null){
            inorder(root.left, list);
            list.add(root);
            inorder(root.right, list);
        }
    }

    public  List<TreeNode> inTraversal(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        return  list;
    }


    //Accepted ---44ms
    /*
        space complexity O(n)
     */
    public  void  recoverTree(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        List<TreeNode> copyList = new ArrayList<>(list);

        Collections.sort(copyList, new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o1.val - o2.val;
            }
        });
        int index = 0;
        while (index < list.size()){
            if(list.get(index).val != copyList.get(index).val){
                break;
            }else {
                index++;
            }
        }

        TreeNode node1 = list.get(index);
        TreeNode node2 = copyList.get(index);
        int temp = node1.val;

        node1.val = node2.val;
        node2.val = temp;

    }



    /*
        code from other
        only using two  TreeNode array, to save swap node
     */
    private TreeNode pre = null;
    public void recoverTree1(TreeNode root) {
        if (root == null) return;
        TreeNode[] mistake = new TreeNode[2];

        dfs(root, mistake);

        if (mistake[0] != null && mistake[1] != null) {
            int tmp = mistake[0].val;
            mistake[0].val = mistake[1].val;
            mistake[1].val = tmp;
        }
    }

    private void dfs(TreeNode root, TreeNode[] mistake) {
        if (root == null) return;
        dfs(root.left, mistake);
        if (pre != null && pre.val > root.val) {
            mistake[1] = root;
            if (mistake[0] == null) mistake[0] = pre;
        }
        pre = root;
        dfs(root.right, mistake);
    }



    @Test
    public  void  test(){
       /* TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(3);
        TreeNode l3 = new TreeNode(2);
        l1.left = l2;
        l2.right = l3;*/

       TreeNode l1 = new TreeNode(3);
        TreeNode l21 = new TreeNode(1);
        TreeNode l22 = new TreeNode(4);
        TreeNode l33 = new TreeNode(2);

        l1.left = l21;
        l1.right = l22;
        l22.left = l33;

        List<TreeNode> preSwap = inTraversal(l1);
        for(int i = 0; i < preSwap.size(); i++){
            System.out.print(preSwap.get(i).val + "  ");
        }
        System.out.println();

        long startTime = System.currentTimeMillis();
        recoverTree(l1);
        long endTime = System.currentTimeMillis();
        List<TreeNode> recoverList = inTraversal(l1);
        for(int i = 0; i < recoverList.size(); i++){
            System.out.print(recoverList.get(i).val + "  ");
        }
        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }
}
