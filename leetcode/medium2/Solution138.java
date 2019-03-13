package interview.medium2;

import javafx.scene.control.RadioMenuItem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/9/4 0004.
 */
public class Solution138 {
    public class RandomListNode{
        int label;
        RandomListNode next, random;
        RandomListNode(int x){
            label = x;
        }
    }

    public  int find(RandomListNode head, RandomListNode node){
        int count = 1;
        RandomListNode p = head;
        while (p != null){
            if(p == node){
                return count;
            }else {
                p = p.next;
                count++;
            }
        }
        return -1;
    }


    public RandomListNode get(RandomListNode copyHead, int count){
        int index = 1;
        RandomListNode p = copyHead;
        while (p != null){
            if(count == index){
                return p;
            }else {
                p = p.next;
                index++;
            }
        }
        return  null;
    }


    //Accepted ------102ms
    /*
        time complexity o(n^2)
     */
    public  RandomListNode copyRandomList(RandomListNode head){
        if(head == null){
            return  null;
        }
        RandomListNode copyHead = new RandomListNode(head.label);
        RandomListNode p = copyHead, q = head.next;

        while (q != null){
            RandomListNode node = new RandomListNode(q.label);
            p.next = node;
            p = p.next;
            q = q.next;
        }

        p = copyHead;
        q = head;
        while (q != null){
            if(q.random != null) {
                int countValue = find(head, q.random);
                RandomListNode nextNode = get(copyHead, countValue);
                p.random = nextNode;
            }

            q = q.next;
            p = p.next;
        }

        return  copyHead;
    }

    public  RandomListNode find2(Map<Integer, RandomListNode> map1,Map<Integer, RandomListNode>map2, RandomListNode node){
        for(Integer key : map1.keySet()){
            RandomListNode result = map1.get(key);
            if (result == node){
                return map2.get(key);
            }
        }
        return  null;
    }

    /*
        using map<Integer, RandomListNode>, to decrease find and get time
        time comlexity o(n)
     */

    //Time limited out------10/12 test case
    public  RandomListNode copyRandomList1(RandomListNode head){
        if(head == null){
            return  null;
        }

        int count = 2;
        RandomListNode p = head.next;
        Map<Integer, RandomListNode> map1 = new TreeMap<>();
        map1.put(1, head);
        Map<Integer, RandomListNode> map2 = new TreeMap<>();
        RandomListNode copyHead = new RandomListNode(head.label);
        map2.put(1, copyHead);

        RandomListNode q = copyHead;
        while (p != null){
            map1.put(count, p);
            RandomListNode node = new RandomListNode(p.label);
            q.next = node;
            q = q.next;
            p = p.next;
            map2.put(count,q);
            count++;
        }
        p = head;
        q = copyHead;
        while (p != null){
            if(p.random != null){
                q.random = find2(map1, map2, p.random);
            }
            p = p.next;
            q = q.next;
        }

        return  copyHead;
    }

    //reference from other

    private HashSet copyNodes(RandomListNode node){
        HashSet<RandomListNode> set = new HashSet<>();
        if(node == null){return null;}
        while(node!= null){
            set.add(node);
            node = node.next;
        }
        return set;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if(head == null){return null;}
        HashSet<RandomListNode> nodes = new HashSet<>();
        HashMap<RandomListNode, RandomListNode> hashmap = new HashMap<>();

        nodes = copyNodes(head);
        for(RandomListNode node: nodes){
            hashmap.put(node, new RandomListNode(node.label));
        }
        for(RandomListNode node:nodes){
            RandomListNode newNode = hashmap.get(node);
            newNode.next = hashmap.get(node.next);
            newNode.random = hashmap.get(node.random);
        }
        return hashmap.get(head);
    }

}
