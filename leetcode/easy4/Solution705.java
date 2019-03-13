package interview.easy4;

/**
 * Created by Administrator on 2018/7/29 0029.
 */
public class Solution705 {
    public  class  Node{
        int val;
        Node next;
        Node(int x){
            val = x;
        }
    }

    public Node[] hashtable ;
    public  Solution705(){
        hashtable = new Node[1000];
    }

    public  void  add(int key){
        int index = key % 10000;
        if(hashtable[index] == null){
            hashtable[index] = new Node(key);
        }else {
            Node p = hashtable[index];
            while (p.next != null){
                p = p.next;
            }
            p.next = new Node(key);
        }
    }

    public void  remove(int key){
        int index = key % 1000;
        Node p = hashtable[index];
        if(p.val == key){
            hashtable[index] = p.next;
            return;
        }
        Node pre = p.next;
        while (pre.next != null){
            if(pre.val != key){
                p = pre;
                pre = pre.next;
            }else {
                p.next = pre.next;
                pre = pre.next;
            }
        }
    }

    public boolean contains(int key){
        int index = key % 1000;
        Node p = hashtable[index];
        while (p != null){
            if(p.val != key){
                p = p.next;
            }else {
                return  true;
            }
        }
        return  false;
    }
}
