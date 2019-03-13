package interview.easy3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2018/7/18 0018.
 */
public class Solution559 {
    public class Node {
        int val;
        List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //Time Limit Exceeded   ------ recurively version
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children.size() == 0) {
            return 1;
        }

        int maxdepth = 0;
        for (Node node : root.children){
            if (maxDepth(node) > maxdepth) {
                maxdepth = maxDepth(node);
            }
        }

        return  maxdepth + 1;
    }

    public  int maxDepth1(Node root){
        if (root == null) {
            return 0;
        }
        if (root.children.size() == 0) {
            return 1;
        }

        Queue<List<Node>> queue = new ConcurrentLinkedQueue<>();

        List<Node> output = new ArrayList<Node>();
        List<Node> input = new ArrayList<Node>(){{add(root);}};
        queue.add(input);
        int level = 0;
        while (!queue.isEmpty()){
            output = queue.poll();
            input = new ArrayList<>();
            for(Node node : output){
                if(node.children.size() != 0){
                    input.addAll(node.children);
                }
            }
            if(input.size() != 0) {
                queue.add(input);
            }
            level++;
        }

        return  level;
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

        System.out.print(maxDepth1(l1));
    }
}
