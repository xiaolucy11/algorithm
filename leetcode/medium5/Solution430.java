package algorithm.medium5;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/4.
 */
public class Solution430 {
    public class  Node{
        int val;
        Node prev;
        Node next;
        Node child;

        public Node(){}
        public Node(int _val, Node _prev, Node _next, Node _child){
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    //Accepted -----2ms
    public  Node flatten(Node head){
        if(head == null || (head.child == null && head.next == null)){
            return  head;
        }
        Node p = head;
        while (p != null){
            if(p.child != null){
                Node flatternChild = flatten(p.child);
                Node q = flatternChild;
                while (q.next != null){
                    q = q.next;
                }
                Node temp = p.next;
                q.next = temp;
                if(temp != null) {
                    temp.prev = q;
                }
                p.next = flatternChild;
                p.child = null;
                flatternChild.prev = p;
                p = q;
            }
            p = p.next;
        }
        return head;
    }

    @Test
    public  void  test(){
       /* Node l1 = new Node(1,null,null,null);
        Node l2 = new Node(2,null,null,null);
        Node l3 = new Node(3,null,null,null);
        Node l4 = new Node(4,null,null,null);
        Node l5 = new Node(5,null,null,null);
        Node l6 = new Node(6,null,null,null);
        Node l7 = new Node(7,null,null,null);
        Node l8 = new Node(8,null,null,null);
        Node l9 = new Node(9,null,null,null);
        Node l10 = new Node(10,null,null,null);
        Node l11 = new Node(11,null,null,null);
        Node l12 = new Node(12,null,null,null);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        l11.next = l12;

        l2.prev = l1;
        l3.prev = l2;
        l4.prev = l3;
        l5.prev = l6;
        l6.prev = l5;
        l8.prev = l7;
        l9.prev = l8;
        l10.prev = l9;
        l12.prev = l11;

        l3.child = l7;
        l8.child = l11;
*/
        Node l1 = new Node(1,null,null,null);
        Node l2 = new Node(2,null,null,null);
        Node l3 = new Node(3,null,null,null);
        Node l4 = new Node(4,null,null,null);
        Node l5 = new Node(5,null,null,null);
        Node l6 = new Node(6,null,null,null);
        Node l7 = new Node(7,null,null,null);
        Node l8 = new Node(8,null,null,null);


        l1.child = l2;
        l1.next = l8;
        l8.prev = l1;
        l2.child = l3;
        l3.child = l4;
        l4.child = l5;
        l5.child = l6;
        l6.child = l7;


        Node result = flatten(l1);
        while (result != null){
            System.out.print(result.val + "  ");
            result = result.next;
        }
    }

}
