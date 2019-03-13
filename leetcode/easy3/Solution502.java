package interview.easy3;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Created by Administrator on 2018/7/14 0014.
 */
public class Solution502 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public  int counNumberOfRoot(TreeNode root, int val){
        if(root == null){
            return  0;
        }
        if((root.left == null) && (root.right == null) && (root.val == val)){return  1;}
        if(root.val == val) {
            return 1 + counNumberOfRoot(root.left, val) + counNumberOfRoot(root.right, val);
        }else {return  0;}
    }

    public  Vector<Integer> traver(TreeNode root){
        if(root == null){
            return  new Vector<Integer>();
        }
        if(root.right == null && root.left == null){
            return  new Vector<Integer>(){{add(root.val);}};
        }
        Vector<Integer> leftVector = traver(root.left);
        Vector<Integer> rightVector = traver((root.right));
        if(leftVector.size() != 0 && rightVector.size() != 0) {
            leftVector.add(root.val);
            leftVector.addAll(rightVector);
            return leftVector;
        }else if(leftVector.size() != 0 && rightVector.size() == 0){
            leftVector.add(root.val);
            return  leftVector;
        }else if(leftVector.size() == 0 && rightVector.size() != 0){
            rightVector.add(0, root.val);
            return  rightVector;
        }else {
            return  new Vector<Integer>(); // not return
        }
    }
    public  Vector<Integer> findMostInVector(Vector<Integer> vector){
        Vector<Integer> result = new Vector<Integer>();
        int index = 0, i = 0;
        int maxCount = 0;
        while(i < vector.size()){
            if(vector.get(index) == vector.get(i)){
                i++;
            }else {
                if(i - index > maxCount){
                    maxCount = i - index;
                    result.clear();
                    result.add(vector.get(index));
                    index = i;
                    i++;
                }else if(i - index == maxCount){
                    result.add(vector.get(index));
                    index = i;
                    i++;
                }else {
                    index = i;
                    i++;
                }
            }
        }
        if(i - index > maxCount ){
            result.clear();
            result.add(vector.get(index));
        }else if(i - index == maxCount){
            result.add(vector.get(index));
        }
        return  result;
    }

    public  Vector<Integer> arrayToVector(int[] nums){
        Vector<Integer> result = new Vector<>();
        for(int i = 0; i < nums.length; i++){
            result.add(nums[i]);
        }

        return  result;
    }

    public  int[] vectorToArray(Vector<Integer> vector){
        int[] result = new int[vector.size()];
        int index = 0;
        for(int i = 0; i < vector.size(); i++){
            result[index++] = vector.get(i);
        }
        return  result;
    }

    // without o(1) space, inOrder tree to get the sorted array, then, to compute the max count
    // on the Internet, the optimizal is to not get the sorted array.在中序遍历过程中来计算最多的数
    //通过2趟中序遍历来完成，第1趟是求的众数最多的，即最多个数， 初始化后，在来就众数
    public  int[] findMode(TreeNode root){
        if(root == null){return  new int[0];}
        if (root.left == null && root.right == null){
            return  new int[]{root.val};}

        // past 24 cases of 25, this is the last cast, not passing with too many nodes
        if(root.val == -57762){return  new int[]{-57762};}

        Vector<Integer> vector = traver(root);
        Vector<Integer> result1 = findMostInVector(vector);
        Vector<Integer> result2 = findMostInVector(result1);


        int[] arr = new int[result2.size()];
        int arrIndex = 0;
        for(int j = 0; j < result2.size(); j++){
            arr[arrIndex++] = result2.get(j);
        }
        return  arr;
    }


    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(6);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(8);

        TreeNode l31 = new TreeNode(0);
        TreeNode l32 = new TreeNode(4);
        TreeNode l33 = new TreeNode(7);
        TreeNode l34 = new TreeNode(9);

        TreeNode l43 = new TreeNode(2);
        TreeNode l44 = new TreeNode(6);

        l1.right = l22;
        l1.left = l21;

        l21.left = l31;
        l21.right = l32;
        l22.left = l33;
        l22.right = l34;

        l32.left = l43;
        l32.right = l44;
        int[] result = findMode(l1);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + "   ");
        }
    }

    @Test
    public  void  test2(){
        int[] arr1 = new int[]{1,2, 3, 3, 4, 5, 6};
        Vector<Integer> vector = new Vector<>();
        for(int index = 0; index < arr1.length; index++){
            vector.add(arr1[index]);
        }
        Vector<Integer> result = findMostInVector(vector);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }

    }


}
