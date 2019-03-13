package interview.medium2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/1 0001.
 */
public class Solution95 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x){
            val = x;
        }
    }

    public List<TreeNode> help(int[] nums, int start, int end){
        if(end < 0 || start >= nums.length || start > end){
            return  new ArrayList<>();
        }
        if(start == end){
            List<TreeNode> list = new ArrayList<>();
            TreeNode node1 = new TreeNode(nums[start]);
            list.add(node1);
            return  list;
        }

        List<TreeNode> result = new ArrayList<>();
        for(int i = start; i <= end; i++){
            TreeNode node2 = new TreeNode(nums[i]);
            List<TreeNode> leftList = help(nums, start, i-1);
            List<TreeNode> rightList = help(nums, i+1, end);

            if(leftList.size() == 0 && rightList.size() == 0){
                result.add(node2);
            }else if(leftList.size() == 0){
                for(int j = 0; j < rightList.size(); j++){
                    TreeNode node3 = new TreeNode(nums[i]);
                    node3.right = rightList.get(j);
                    result.add(node3);
                }
            }else if(rightList.size() == 0){
                for(int j = 0; j < leftList.size(); j++){
                    TreeNode node4 = new TreeNode(nums[i]);
                    node4.left = leftList.get(j);
                    result.add(node4);;
                }
            }else {
                for(int m = 0; m < leftList.size(); m++){
                    for(int n = 0; n < rightList.size(); n++){
                        TreeNode node5 = new TreeNode(nums[i]);
                        node5.left = leftList.get(m);
                        node5.right = rightList.get(n);
                        result.add(node5);
                    }
                }
            }
        }
        return  result;
    }



    //Accepted -------2ms
    public List<TreeNode> generateTrees(int n){
        int[] array = new int[n+1];
        for(int i = 1; i < n+1; i++){
            array[i] = i;
        }
        return help(array, 1, n);
    }

    public  void  inorder(List<Integer> list , TreeNode root){
        if(root != null){
            inorder(list, root.left);
            list.add(root.val);
            inorder(list, root.right);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inorder(result, root);
        return  result;
    }


    @Test
    public  void  test(){
        int n = 3;
        List<TreeNode> result = generateTrees(n);
        for(int i = 0; i < result.size(); i++){
           List<Integer> tranverResult = inorderTraversal(result.get(i));
            for(int j = 0; j < tranverResult.size(); j++){
                System.out.print(tranverResult.get(j) + "  ");
            }
            System.out.println();
        }
    }
}
