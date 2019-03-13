package interview.medium2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/2 0002.
 */
public class Solution113 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public int sumOfList(List<Integer> list){
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }
        return  sum;
    }

    public  void  generate(List<List<Integer>> lists,List<Integer> list,  TreeNode root, int sum){
       list.add(root.val);
        if(root.left == null && root.right == null){
            if(sumOfList(list) == sum) {
                lists.add(list);
            }
            return;
        }
        if(sumOfList(list) >= sum){
            return;
        }
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        leftList.addAll(list);
        rightList.addAll(list);
        if(root.left != null) {
            generate(lists, leftList, root.left, sum);
        }
        if(root.right != null) {
            generate(lists, rightList, root.right, sum);
        }
    }

    //Accepted ----12ms
    /*
        recursive solution
     */
    public  List<List<Integer>> pathSum(TreeNode root, int sum){
        if(root == null){
            return  new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        generate(lists, list, root, sum);

        return  lists;
    }

    /*
        it can be optimized. in generate funcion, not copy the parameter list,
        rather than, add the root.val; then recursive call;
        finally, remove the last element in list
     */



    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(5);
        TreeNode l21 = new TreeNode(4);
        TreeNode l22 = new TreeNode(8);
        TreeNode l31 = new TreeNode(11);
        TreeNode l33 = new TreeNode(13);
        TreeNode l34 = new TreeNode(4);
        TreeNode l41 = new TreeNode(7);
        TreeNode l42 = new TreeNode(2);
        TreeNode l43 = new TreeNode(5);
        TreeNode l44 = new TreeNode(1);

        l1.left = l21;
        l1.right = l22;

        l21.left = l31;
        l22.left = l33;
        l22.right = l34;

        l31.left = l41;
        l31.right = l42;
        l34.left = l43;
        l34.right = l44;

        List<List<Integer>> result = pathSum(l1, 22);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + "  ");
            }
            System.out.println();
        }

    }
}
