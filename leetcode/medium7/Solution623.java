package algorithm.medium7;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by youlu on 2018/10/23.
 */
public class Solution623 {
    public  class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    //Accepted ----10ms
    public  TreeNode addOneRow(TreeNode root, int v, int d){
        if(d == 1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return  node;
        }

        Queue<List<TreeNode>> queue = new ArrayDeque<>();
        List<TreeNode> input = new ArrayList<>();
        input.add(root);
        queue.add(input);
        int level = 1;
        while (!queue.isEmpty()){
            List<TreeNode> output = queue.poll();
            if(level == d - 1){
                for(int i = 0; i < output.size(); i++){
                    TreeNode leftNode = new TreeNode(v);
                    leftNode.left = output.get(i).left;
                    output.get(i).left = leftNode;

                    TreeNode rightNode = new TreeNode(v);
                    rightNode.right = output.get(i).right;
                    output.get(i).right = rightNode;
                }
                break;
            }else {
                input = new ArrayList<>();
                for(int i = 0; i < output.size(); i++){
                    if(output.get(i).left != null){
                        input.add(output.get(i).left);
                    }

                    if(output.get(i).right != null){
                        input.add(output.get(i).right);
                    }
                }

                if(!input.isEmpty()){
                    queue.add(input);
                    level++;
                }
            }
        }

        return  root;
    }

    public  void  preOrder(TreeNode root, List<Integer> list){
        if(root != null){
            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }

    //for testing
    public  List<Integer> preTravesal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return  list;
    }


    @Test
    public  void  test(){
       /* TreeNode l1 = new TreeNode(4);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(6);
        TreeNode l31 = new TreeNode(3);
        TreeNode l32 = new TreeNode(1);
        TreeNode l33 = new TreeNode(5);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l21.right = l32;
        l22.left = l33;

        int v = 1;
        int d = 2;*/

      /* TreeNode l1 = new TreeNode(4);
        TreeNode l21 = new TreeNode(2);
        TreeNode l31 = new TreeNode(3);
        TreeNode l32 = new TreeNode(1);

        l1.left = l21;
        l21.left = l31;
        l21.right = l32;
        int v = 1;
        int d = 3;
*/


      TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(3);
        TreeNode l31 = new TreeNode(4);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        int v = 5;
        int d = 4;


        long startTime = System.currentTimeMillis();
        TreeNode result = addOneRow(l1, v, d);
        List<Integer> preOrderList = preTravesal(result);
        for(int i = 0; i < preOrderList.size(); i++){
            System.out.print(preOrderList.get(i) + "  ");
        }
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("running time : " + (endTime- startTime));
    }
}
