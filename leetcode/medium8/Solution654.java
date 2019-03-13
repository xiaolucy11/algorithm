package algorithm.medium8;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/10/27.
 */
public class Solution654 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public  TreeNode help(int[] nums ,int start, int end){
        if(start > end){
            return null;
        }
        if(start == end){
            return  new TreeNode(nums[start]);
        }

        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = start; i <= end; i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root  = new TreeNode(maxValue);
        root.left = help(nums, start, maxIndex - 1);
        root.right = help(nums, maxIndex+1, end);
        return  root;
    }

    //Accepted ----8ms
    public  TreeNode constructedMaximumBinaryTree(int[] nums){
        return help(nums, 0, nums.length - 1);
    }

    public  void  preOrder(TreeNode root, List<Integer> list){
        if(root  != null){
            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }
    public List<Integer> preTravesal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return  list;
    }



    @Test
    public  void  test(){
        int[] nums = {3,2,1,6,0,5};
        TreeNode root =constructedMaximumBinaryTree(nums);
        List<Integer> list = preTravesal(root);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
