package interview.medium2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2018/9/3 0003.
 */
public class Solution129 {
    public  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public  void  search(List<List<Integer>> lists, TreeNode root, List<Integer> list){
        if(root.left == null && root.right == null){
            list.add(root.val);
            lists.add(list);
            return;
        }

        if(root.left != null) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            temp.add(root.val);

            search(lists, root.left, temp);
        }
        if(root.right != null) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            temp.add(root.val);

            search(lists, root.right, temp);
        }

       /* if(root.left != null){
            list.add(root.left.val);
            search(lists, root.left, list);
            list.remove(list.size()-1);
        }
        if(root.right != null){
            list.add(root.right.val);;
            search(lists, root.right, list);
            list.remove(list.size()-1);
        }*/


    }
    public List<List<Integer>> paths(TreeNode root){
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        search(lists, root, list);

        return  lists;

    }

    public  int sum(List<Integer> list){
        int sum = 0;
        int multiply = 1;
        for(int  i = list.size()-1; i >= 0; i--){
            sum += list.get(i) * multiply;
            multiply *= 10;
        }
        return  sum;
    }


    //Accepted -----3ms
    public  int sumNumbers(TreeNode root){
        List<List<Integer>> allPaths = paths(root);
        int allSum = 0;

        for(int i = 0; i < allPaths.size(); i++){
            allSum += sum(allPaths.get(i));
        }
        return allSum;
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(3);
        TreeNode l31 = new TreeNode(4);

        l1.left = l21;
        l1.right = l22;

        l21.left = l31;

       /* List<List<Integer>> result = paths(l1);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + "  ");
            }
            System.out.println();
        }*/

       System.out.print(sumNumbers(l1));

    }
}
