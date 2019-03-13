package algorithm.medium6;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/10/14.
 */
public class Solution508 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }


    public int help(List<Integer> allSums ,TreeNode root){
        if(root == null){
            return  0;
        }
        if(root.left == null && root.right == null){
            allSums.add(root.val);
            return  root.val;
        }

        int leftSum = help(allSums, root.left);
        int rightSum = help(allSums,root.right);
        int value = leftSum + rightSum + root.val;
        allSums.add(value);
        return  value;
    }


    //Accepted ----24ms
    /*
        can also to compute highestFrequent element in List
     */
    public int[] findFrequentTreeSum(TreeNode root){
        if(root == null){
            return  new int[0];
        }
        List<Integer> allSums = new ArrayList<>();
        int sum = help(allSums, root);
        List<Integer> highFrequentsum = new ArrayList<>();
        int index = 0, highestFrequent = 0;
       /* Collections.sort(allSums);

        while (index < allSums.size()){
            int temp = index + 1;
            while ((temp < allSums.size()) && (allSums.get(temp) == allSums.get(index))){
                temp++;
            }

            if(temp - index > highestFrequent){
                highestFrequent = temp - index;
                highFrequentsum.clear();
                highFrequentsum.add(allSums.get(index));
            }else if(temp - index == highestFrequent){
                highFrequentsum.add(allSums.get(index));
            }else {

            }
            index = temp;
        }*/

        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < allSums.size(); i++){
            map.put(allSums.get(i), map.getOrDefault(allSums.get(i),0) + 1);
            int  value = map.get(allSums.get(i));
            if(value > highestFrequent){
                highestFrequent = value;
            }
        }

        for(Integer key : map.keySet()){
            int frequent = map.get(key);
            if(frequent == highestFrequent){
                highFrequentsum.add(key);
            }
        }
        int[] result = new int[highFrequentsum.size()];
        for(int i = 0; i < highFrequentsum.size(); i++){
            result[i] = highFrequentsum.get(i);
        }

        return  result;

    }



    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(5);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(-5);

        l1.left = l21;
        l1.right = l22;

        long startTime = System.currentTimeMillis();
        int[] result = findFrequentTreeSum(l1);
        long endTime = System.currentTimeMillis();
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + "  ");
        }

        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }
}
