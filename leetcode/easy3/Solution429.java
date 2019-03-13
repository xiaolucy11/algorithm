package interview.easy3;

import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2018/7/19 0019.
 */
public class Solution429 {
    public  class Node{
        public  int val;
        public List<Node> children;
        public  Node(){}

        public  Node(int _val, List<Node> _children){
            val = _val;
            children = _children;
        }
    }

    public  List<List<Integer>> levelOrder(Node root){
        if(root == null){return  new ArrayList<>();}
        List<List<Integer>> result = new ArrayList<>();
        List<Node> input = new ArrayList<Node>(){{add(root);}};
        List<Node> output = new ArrayList<>();
        Queue<List<Node>> queue = new ConcurrentLinkedQueue<>();
        queue.add(input);
        while (!queue.isEmpty()){
            output = queue.poll();
            List<Integer> temp = new ArrayList<>();

            //reference change ,garbage collection in it
            input = new ArrayList<>();
            for(Node node: output){
                temp.add(node.val);
                if(node.children.size() != 0) {
                    input.addAll(node.children);
                }
            }
            result.add(temp);
            if (input.size() != 0) {
                queue.add(input);
            }
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
        Node l32 = new Node(6, new ArrayList<>());

        l1.children.add(l21);
        l1.children.add(l22);
        l1.children.add(l23);

        l21.children.add(l31);
        l21.children.add(l32);

        List<List<Integer>> result = levelOrder(l1);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + "  ");
            }
            System.out.println(" ");
        }
    }
}
