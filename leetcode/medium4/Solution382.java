package algorithm.medium4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by youlu on 2018/9/26.
 */

//Accepted ----- 92ms
public class Solution382 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode head;
    public List<Integer> list;

    public Solution382(ListNode head){
        this.head = head;
        this.list = new ArrayList<>();
        ListNode p = head;
        while (p != null){
            list.add(p.val);
            p = p.next;
        }
    }

    public  int getRandom(){
        Random random = new Random();
        int index = random.nextInt(list.size());
        return  list.get(index);
    }

    @Test
    public  void  test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        Solution382 s = new Solution382(l1);
        int randomListNodeValue = s.getRandom();
        System.out.print(randomListNodeValue);
    }

}
