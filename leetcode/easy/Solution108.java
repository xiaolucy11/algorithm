package interview.easy;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2018/6/13 0013.
 */
public class Solution108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
        public  String treeNodeToString(TreeNode root) {
            if (root == null) {
                return "[]";
            }

            String output = "";
            Queue<TreeNode> nodeQueue = new LinkedList<>();

            nodeQueue.add(root);
            while(!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.remove();

                if (node == null) {
                    output += "null, ";
                    continue;
                }

                output += String.valueOf(node.val) + ", ";
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
            }
            return "[" + output.substring(0, output.length() - 2) + "]";
        }

        public TreeNode sortedArrayToBST(int[] nums){
            if(nums == null){return null;}
            if(nums.length == 1){return new TreeNode(nums[0]);}
            if(nums.length == 2){
                TreeNode root1 = new TreeNode(nums[1]);
                TreeNode left1 = new TreeNode(nums[0]);
                root1.left = left1;
                return root1;
            }

            int len = nums.length;
            int midValue = nums[len / 2];
            System.out.println("len : " + len +"  midValue:  " + midValue );
            int[] leftNums = new int[len / 2];
            int[] rightNums = new int[len / 2];
            TreeNode root = new TreeNode(nums[len / 2]);

            int leftIndex = 0;
            int rightIndex = 0;
            for(int i = 0; i < len / 2; i++){
                leftNums[leftIndex++] = nums[i];
            }
            for(int j = len / 2 + 1; j < len; j++){
                rightNums[rightIndex++] = nums[j];
            }

            TreeNode leftResult = sortedArrayToBST(leftNums);
            TreeNode rightResult = sortedArrayToBST(rightNums);

            root.left = leftResult;
            root.right = rightResult;

            return root;
        }

        public TreeNode  help(int[] nums, int start, int end){
            if(start == end){
                return new TreeNode(nums[start]);
            }
            if(start > end){return null;}
            int mid =  start + (end - start + 1 ) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = help(nums, start, mid - 1);
            root.right = help(nums, mid+1, end);
            return root;

        }
        public TreeNode sortedArrayToBST1(int[] nums){
            return help(nums, 0, nums.length - 1);
        }

        @Test
        public void  test(){
            int[] nums = new int[]{-10, -3, 1, 5, 9};
            //int[] nums = new int[4];
            TreeNode result = sortedArrayToBST1(nums);
            String str = treeNodeToString(result);
            for(int i = 0; i < str.length(); i++){
                System.out.print(str.charAt(i) + " ");
            }

        }

}
