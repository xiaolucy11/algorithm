package interview.easy3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2018/7/20 0020.
 */
public class Solution589 {
    public  class Node{
        int val;
        List<Node> children;

        public Node(){}
        public  Node(int _val, List<Node> _children){
            val = _val;
            children = _children;
        }
    }

    //Accepted -----6ms
    public  List<Integer> preorder(Node root){
        if(root == null){
            return  new ArrayList<Integer>();
        }
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            result.add(node.val);
            if(node.children.size() != 0){
                for(int i = node.children.size() - 1; i >= 0; i--){
                    stack.add(node.children.get(i));
                }
            }
        }
        return  result;
    }

    //not use return statement to get result, genuinely using the params  reference to get result
    public  void preorderHelp(List<Integer> result, Node root){
        if(root != null){
            result.add(root.val);
        }
        if(root.children.size() != 0){
            for(int i = 0; i < root.children.size(); i++){
                preorderHelp(result, root.children.get(i));
            }
        }
    }


    public  List<Integer> preorder1(Node root){
        if(root == null){
            return  new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        preorderHelp(result, root);
        return result;
    }


    @Test
    public  void  test(){
        Node l1 = new Node(1, new ArrayList<>());
        Node l21 = new Node(3, new ArrayList<>());
        Node l22 = new Node(2, new ArrayList<>());
        Node l23 = new Node(4, new ArrayList<>());
        Node l31 = new Node(5, new ArrayList<>());
        Node l32  = new Node(6, new ArrayList<>());


        l1.children.add(l21);
        l1.children.add(l22);
        l1.children.add(l23);

        l21.children.add(l31);
        l21.children.add(l32);

        List<Integer> result = preorder1(l1);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "   ");
        }
    }
}
