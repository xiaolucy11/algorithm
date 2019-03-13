package algorithm.hard2;

import org.junit.Test;

import java.util.*;

public class Solution315 {

    //Time Limit Exceed
    /*
        time complexity O((nlog(n)^2)
     */
    public List<Integer> countSmaller(int[] nums){
        if(nums.length == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1* (o1 - o2);
            }
        });

        List<Integer>result = new ArrayList<>();
        result.add(0);
        int index = nums.length - 2;
        priorityQueue.add(nums[index+1]);
        while (index >= 0){
            int top = priorityQueue.peek();
            if(top < nums[index]){
                result.add(priorityQueue.size());
                priorityQueue.add(nums[index]);
            }else {
                List<Integer> temp = new ArrayList<>();
                while (!priorityQueue.isEmpty()){
                    int curTop = priorityQueue.peek();
                    if(curTop < nums[index]){
                        result.add(priorityQueue.size());
                        break;
                    }else {
                       int value =  priorityQueue.poll();
                       temp.add(value);
                    }
                }
                if(priorityQueue.isEmpty()){
                    result.add(0);
                }

                for(int i = 0; i < temp.size(); i++){
                    priorityQueue.add(temp.get(i));
                }
                priorityQueue.add(nums[index]);
            }
            index--;
        }
        Collections.reverse(result);
        return  result;
    }

    public  class Node{
        int val;
        Node left;
        Node right;
        int count;
        int leftCount;

        Node(int value){
            val = value;
            left = null;
            right = null;
            count = 1;
            leftCount = 0;
        }
    }

    public  int insert(Node root,int value){
        if(root.val == value){
            root.count++;
            return root.leftCount;
        }else if(value < root.val) {
            root.leftCount++;
            if(root.left == null){
                root.left = new Node(value);
                return 0;
            }else {
                return insert(root.left,value);
            }
        }else {
            if(root.right == null){
                Node node = new Node(value);
                root.right = node;
//                node.leftCount = root.leftCount + root.count;
                return root.leftCount + root.count;
            }else {
                return  root.leftCount + root.count + insert(root.right, value);
            }
        }
    }

    //Accepted ---6ms
    /*
        idea from other
     */
    public List<Integer> countSmaller1(int[] nums){
        if(nums.length == 0){
            return  new ArrayList<>();
        }
        Node root = new Node(nums[nums.length - 1]);
        List<Integer> result = new ArrayList<>();
        result.add(0);
        int index = nums.length - 2;
        while (index >= 0){
            int value = insert(root,nums[index]);
            result.add(value);
            index--;
        }
        Collections.reverse(result);
        return  result;
    }



    @Test
    public  void  test(){
//       int[] nums = {3,5,2,6,4,1};
        int[] nums = {-1,-1};

       long startTime = System.currentTimeMillis();
       List<Integer>result = countSmaller1(nums);
       long endTime = System.currentTimeMillis();

       for(int i = 0; i < result.size(); i++){
           System.out.print(result.get(i) + " ");
       }
       System.out.println();
       System.out.println("running time : " + (endTime - startTime));
    }
}
