package algorithm.medium8;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by youlu on 2018/10/29.
 */
public class Solution662 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public boolean allIsEmpty(List<TreeNode> list){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != null){
                return  false;
            }
        }

        return  true;
    }
    public TreeNode isLeftLinkList(TreeNode root){
        TreeNode p  = root;
        while ( p != null){
            if(p.right != null){
                return  p;
            }
            p = p.left;
        }
        return  null;
    }

    public  TreeNode isRightLinkList(TreeNode root){
        TreeNode p = root;
        while (p != null){
            if(p.left != null){
                return  p;
            }
            p = p.right;
        }
        return  null;
    }

    //Accepted ---184ms
    public  int widthOfBinaryTree(TreeNode root){
        TreeNode p = root;
        TreeNode node = isLeftLinkList(root);
        if(node != root){
            if(node == null){
                return 1;
            }
            p = node;
        }else {
            p = isRightLinkList(root);
            if(p == null){
                return 1;
            }
        }

        Queue<List<TreeNode>> queue = new ArrayDeque<>();
        List<TreeNode> input = new ArrayList<>();
        input.add(p);
        queue.add(input);
        int maxWidth = -1;

        while (!queue.isEmpty()){
            List<TreeNode> output = queue.poll();
            int leftNotNull = 0, rightNotNull = output.size() - 1;
            while (leftNotNull < output.size() && output.get(leftNotNull) == null){
                leftNotNull++;
            }

            while ((rightNotNull >= 0) && (output.get(rightNotNull) == null)){
                rightNotNull--;
            }
            if(rightNotNull - leftNotNull + 1> maxWidth){
                maxWidth = rightNotNull - leftNotNull + 1;
            }

            input = new ArrayList<>();
            for(int i = 0; i < output.size(); i++){
                if(output.get(i) == null){
                    input.add(null);
                    input.add(null);
                    continue;
                }
                if(output.get(i).left != null){
                    input.add(output.get(i).left);
                }else {
                    input.add(null);
                }

                if(output.get(i).right != null){
                    input.add(output.get(i).right);
                }else {
                    input.add(null);
                }
            }
            if(!allIsEmpty(input)){
                queue.add(input);
            }
        }

        return  maxWidth;
    }


    @Test
    public  void  test(){
       /* TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(3);
        TreeNode l31 = new TreeNode(5);
        TreeNode l32 = new TreeNode(3);

        l1.left = l21;
        l21.left = l31;
        l21.right = l32;*/

     /*  TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(3);
        TreeNode l22 = new TreeNode(2);
        TreeNode l31 = new TreeNode(5);
        TreeNode l32 = new TreeNode(3);
        TreeNode l34 = new TreeNode(9);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l21.right = l32;
        l22.right = l34;*/

       TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(3);
        TreeNode l22 = new TreeNode(2);
        TreeNode l31 = new TreeNode(5);
        TreeNode l32 = new TreeNode(9);
        TreeNode l41 = new TreeNode(6);
        TreeNode l42 = new TreeNode(7);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l22.right = l32;
        l31.left = l41;
        l32.right = l42;


        long startTime = System.currentTimeMillis();
        int result = widthOfBinaryTree(l1);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }


    @Test
    public  void  test1(){
        TreeNode l1 = new TreeNode(1);
        TreeNode p = l1;
        for(int i = 0; i < 1000; i++){
            TreeNode node = new TreeNode(1);
            p.right = node;
            p = node;
        }

        long startime = System.currentTimeMillis();
        TreeNode b = isRightLinkList(l1);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + b.val);
        System.out.println("running time : " + (endTime - startime));





    }
}
