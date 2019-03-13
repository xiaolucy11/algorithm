package algorithm.medium8;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by youlu on 2018/10/27.
 */
public class Solution655 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public  class  Element{
        TreeNode node;
        int index;
        Element(TreeNode _node, int _index){
            node = _node;
            index = _index;
        }
    }

    public  int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return  1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    //Accepted ----10ms
    public List<List<String>> printTree(TreeNode root){
        int height = getHeight(root);
        String[][] matrix = new  String[height][(int)Math.pow(2,height) - 1];

        for(int i = 0; i < height; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = "";
            }
        }
        int level = 0;
        int width = ((int)Math.pow(2,height)) / 2;
        matrix[0][width-1] += Integer.toString(root.val);
        Queue<List<Element>> queue = new ArrayDeque<>();
        List<Element> input = new ArrayList<>();
        input.add(new Element(root, width-1));
        queue.add(input);

        while (!queue.isEmpty()){
            List<Element> output = queue.poll();
            input = new ArrayList<>();
            width /= 2;
            level++;
            for(int i = 0; i < output.size(); i++){
                Element element = output.get(i);
                if(element.node.left != null){
                    int leftIndex = element.index -  width;
                    matrix[level][leftIndex] += Integer.toString(element.node.left.val);
                    input.add(new Element(element.node.left, leftIndex));
                }
                if(element.node.right != null){
                    int rightIndex = element.index + width;
                    matrix[level][rightIndex] += Integer.toString(element.node.right.val);
                    input.add(new Element(element.node.right, rightIndex));
                }
            }
            if(!input.isEmpty()){
                queue.add(input);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            List<String> l = new ArrayList<>();
            for(int j = 0; j < matrix[0].length; j++){
                l.add(matrix[i][j]);
            }
            result.add(l);
        }

        return  result;
    }

    @Test
    public  void  test(){
       /* TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        l1.left = l21;*/

      /* TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(3);
        TreeNode l32 = new TreeNode(4);

        l1.left = l21;
        l1.right = l22;
        l21.right = l32;*/

      TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(5);
        TreeNode l31 = new TreeNode(3);
        TreeNode l41 = new TreeNode(4);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l31.left = l41;

        long startTime = System.currentTimeMillis();
        List<List<String>> result = printTree(l1);
        long endTime = System.currentTimeMillis();
        for(int i = 0 ; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + "  ");
            }
            System.out.println();
        }
        System.out.println("running time : " + (endTime - startTime));
    }
}
