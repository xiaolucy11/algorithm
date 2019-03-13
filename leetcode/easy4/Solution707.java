package interview.easy4;

import interview.easy.Solution7;
import interview.easy3.Solution559;

/**
 * Created by Administrator on 2018/7/29 0029.
 */


//reference from other
public class Solution707 {
    public  class  Node{
        int val;
        Node next;
        Node(int x){
            val = x;
        }
    }

    public  Node header;
    public  int size ;
    public Solution707(){
        header = null;
        size = 0;
    }

    private   Node getIndex(int index){
        if(size == 0 || index > size -1){
            return null;
        }
        if(index <= 0){
            return  header;
        }
        int count = 1;
        Node p = header.next;

        while (count < index){
            count++;
            p = p.next;
        }
        return  p;
    }
    public  int get(int index){
       Node p = getIndex(index);
        return  p != null ? p.val : -1;

    }

   /* public  Node getIndex(int index){
        if(index < 0 || index > size - 1){
            return null;
        }

        Node p = header;
        int count = 1;
        while (p != null){
            if(count == index){
                return p;
            }else {
                count++;
                p = p.next;
            }
        }
        return  null;
    }
    */
    public  void  addAtHeader(int val){
        addAtIndex(0, val);
    }
    public  void  addAtTail(int val){
        addAtIndex(size, val);
    }

    public  void  addAtIndex(int index, int val){
        if(index > size){
            return;
        }
        Node p = getIndex(index - 1);
        Node insertNode = new Node(val);
        if(p == null){
            header =  insertNode;
        }else  if(index == 0){
            insertNode.next = header;
            header = insertNode;
        }else {
            insertNode.next = p.next;
            p.next = insertNode;
        }
        size++;

    }

    public  void  deleteAtIndex(int index){
        if(size == 0 || index < 0 || index > size){
            return;
        }
        Node p = header;
        if(index == 0){
            header = header.next;
            p.next = null;
        }


        int count = 1;
        Node q = getIndex(index - 1);
        if(q.next != null){
            q.next = q.next.next;
        }

    }
}
