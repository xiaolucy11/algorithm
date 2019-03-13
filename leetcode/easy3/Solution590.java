package interview.easy3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2018/7/20 0020.
 */
public class Solution590 {
    public  class Node{
        int val;
        List<Node> children;

        public  Node(){}
        public  Node(int _val, List<Node> _children){
            val = _val;
            children = _children;
        }
    }

    public  void  postorderHelp(List<Integer> result, Node root){
        if(root.children.size() == 0){
            result.add(root.val);
        }else {
            for(int i = 0; i < root.children.size(); i++){
                postorderHelp(result, root.children.get(i));
            }
            result.add(root.val);
        }
    }

    //Accepted ----- 2ms   Recursive solution
    public  List<Integer> postorder(Node root){
        if(root == null){
            return  new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        postorderHelp(result, root);;
        return  result;
    }


    //Accepted -----9ms   iterative solution
    public  List<Integer> postorder1(Node root){
        if(root == null){
            return  new ArrayList<>();
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack1.add(root);
        while (!stack1.isEmpty()){
            Node node = stack1.pop();
            stack2.add(node);
            if(node.children.size() != 0){
                for(int i = 0; i < node.children.size(); i++){
                    stack1.add(node.children.get(i));
                }
            }
        }
        while (!stack2.isEmpty()){
            Node temp = stack2.pop();
            result.add(temp.val);
        }

        return  result;

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

        List<Integer> result = postorder1(l1);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
    }
}
