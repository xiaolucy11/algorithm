package algorithm.medium5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/10/6.
 */

//Accepted -----36ms
public class Solution449 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void preOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }

    public  void  postOrder(TreeNode root, List<Integer> list){
        if(root != null){
            postOrder(root.left,list);
            postOrder(root.right, list);
            list.add(root.val);
        }
    }


    public String serialize(TreeNode root) {
        if(root == null){
            return  "";
        }
        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> inOrderList = new ArrayList<>();
        preOrder(root, preOrderList);
        inOrder(root, inOrderList);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < preOrderList.size(); i++) {
            result.append(preOrderList.get(i));
            result.append(',');
        }
        result.append(':');

        for (int j = 0; j < inOrderList.size(); j++) {
            result.append(inOrderList.get(j));
            result.append(',');
        }

        return result.toString();
    }

    public TreeNode construct(List<Integer> preOrder, List<Integer> inOrder) {
        if(preOrder.size() == 0){
            return null;
        }
        if (preOrder.size() == 1) {
            TreeNode root = new TreeNode(preOrder.get(0));
            return root;
        }
        int value = preOrder.get(0);
        TreeNode root = new TreeNode(value);
        int index = 0;
        while (index < inOrder.size()) {
            if (inOrder.get(index) == value) {
                break;
            } else {
                index++;
            }
        }

       /* String leftInOrder = inOrder.substring(0, index);
        String rightInOrder = inOrder.substring(index + 1, inOrder.length());
        String leftPreOrder = preOrder.substring(1, leftInOrder.length() + 1);
        String rightPreOrder = preOrder.substring(leftInOrder.length() + 1, preOrder.length());*/
       List<Integer> leftInOrder = new ArrayList<>();
        List<Integer> rightInOrder = new ArrayList<>();
        List<Integer> leftPreOrder = new ArrayList<>();
        List<Integer> rightPreOrder = new ArrayList<>();

        for(int i = 0; i < index; i++){
            leftInOrder.add(inOrder.get(i));
        }

        for(int i = index + 1; i < inOrder.size(); i++){
            rightInOrder.add(inOrder.get(i));
        }

        for(int i = 1; i < leftInOrder.size() + 1; i++){
            leftPreOrder.add(preOrder.get(i));
        }

        for(int i = leftInOrder.size() + 1; i < preOrder.size(); i++){
            rightPreOrder.add(preOrder.get(i));
        }

        TreeNode leftNode = construct(leftPreOrder, leftInOrder);
        TreeNode rightNode = construct(rightPreOrder, rightInOrder);
        root.left = leftNode;
        root.right = rightNode;

        return root;
    }

    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return  null;
        }
        String[] datas = data.split(":");
        String[] words1 = datas[0].split(",");
        String[] words2 = datas[1].split(",");
        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> inOrderList = new ArrayList<>();

        for (int i = 0; i < words1.length; i++) {
            preOrderList.add(Integer.parseInt(words1[i]));
        }

        for (int j = 0; j < words2.length; j++) {
            inOrderList.add(Integer.parseInt(words2[j]));
        }
        return  construct(preOrderList, inOrderList);
    }

    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(8);
        TreeNode l21 = new TreeNode(5);
        TreeNode l22 = new TreeNode(13);
        TreeNode l31 = new TreeNode(3);
        TreeNode l32 = new TreeNode(7);
        TreeNode l33 = new TreeNode(10);
        TreeNode l34 = new TreeNode(16);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l21.right = l32;
        l22.left = l33;
        l22.right = l34;

       List<Integer> preOrderList = new ArrayList<>();
        List<Integer> inOrderList = new ArrayList<>();
        preOrder(l1,preOrderList);
        inOrder(l1,inOrderList);
        for(int i = 0; i < preOrderList.size(); i++){
            System.out.print(preOrderList.get(i) + "  ");
        }
        System.out.println();

        for(int i = 0; i < inOrderList.size(); i++){
            System.out.print(inOrderList.get(i) + "  ");
        }


        TreeNode root = construct(preOrderList, inOrderList);
        List<Integer> postOrder = new ArrayList<>();
        preOrder(root, postOrder);

        System.out.println();
        for(int i = 0; i < postOrder.size(); i++){
            System.out.print(postOrder.get(i) + "  ");
        }
    }

    @Test
    public  void  test1(){
        /*TreeNode l1 = new TreeNode(8);
        TreeNode l21 = new TreeNode(5);
        TreeNode l22 = new TreeNode(13);
        TreeNode l31 = new TreeNode(3);
        TreeNode l32 = new TreeNode(7);
        TreeNode l33 = new TreeNode(10);
        TreeNode l34 = new TreeNode(16);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l21.right = l32;
        l22.left = l33;
        l22.right = l34;*/

        TreeNode l1  = new TreeNode(2);
        TreeNode l21 = new TreeNode(1);
        TreeNode l22 = new TreeNode(3);

        l1.left = l21;
        l1.right = l22;


        String serializeStr = serialize(l1);
        System.out.println(serializeStr);

        TreeNode root = deserialize(serializeStr);
        List<Integer> preOrder = new ArrayList<>();
        preOrder(root, preOrder);
        for(int i = 0; i < preOrder.size(); i++){
            System.out.print(preOrder.get(i) + "  ");
        }
    }
}


