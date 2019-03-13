package interview.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/12 0012.
 */
public class Solution107 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public List<List<Integer>> merge(List<List<Integer>> l1, List<List<Integer>> l2){
        if((l1.isEmpty()) && (l2.isEmpty())){return l1;}
        if((l1.isEmpty()) && (!l2.isEmpty())){return l2;}
        if ((!l1.isEmpty()) && (l2.isEmpty())) {return l1;}

        int index1 = l1.size() - 1;
        int index2  = l2.size() - 1;
        while((index1 >= 0) && (index2 >= 0)){
            l1.get(index1).addAll(l2.get(index2));
            index1--;
            index2--;
        }
        while(index2 >= 0){
            l1.add(0,l2.get(index2));
            index2--;
        }
        return l1;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root){
        if(root == null){return  new ArrayList<>();}
        if((root.left == null) && (root.right == null)){
            List<Integer> list1 = new ArrayList<>();
            list1.add(root.val);
            List<List<Integer>> listAndList = new ArrayList<>();
            listAndList.add(list1);
            return listAndList;
        }else{
            List<List<Integer>> left = levelOrderBottom(root.left);
            List<List<Integer>> right = levelOrderBottom(root.right);
            List<List<Integer>> mergelist = merge(left,right);

            List<Integer> list2 = new ArrayList<>();
            list2.add(root.val);
            mergelist.add(list2);
            return mergelist;
        }
    }

    @Test
    public  void test(){
        TreeNode l1 = new TreeNode(3);
        TreeNode l21 = new TreeNode(9);
        TreeNode l22 = new TreeNode(20);
       // TreeNode l31 = new TreeNode(5);
        //TreeNode l32 = new TreeNode(4);
        TreeNode l33 = new TreeNode(15);
        TreeNode l34 = new TreeNode(7);
        TreeNode l43 = new TreeNode(2);

        l1.left = l21;
        l1.right = l22;

        //l21.left = l31;
        //l21.right = l32;

        l22.left = l33;
        l22.right = l34;

        l33.left = l43;
        List<List<Integer>> result = levelOrderBottom(l1);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
