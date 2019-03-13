package algorithm.hard2;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Solution480 {
    public  class Pair implements Comparable<Pair> {
        int value;
        int index;
        Pair(int _value, int _index){
            value = _value;
            index = _index;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.value == o.value){
                return this.index - o.index;
            }else {
                if(this.value > o.value){
                    return 1;
                }else if(this.value < o.value){
                    return -1;
                }else {
                    return 0;
                }
            }
        }

    }

    public class BSNode{
        Pair pair;
        BSNode left;
        BSNode right;
        BSNode parent;

        BSNode(Pair p){
            pair = p;
            left = null;
            right = null;
            parent = null;
        }
    }

    public void insert(BSNode root, BSNode node){
        BSNode y = null;
        BSNode x = root;
        int cmp = 0;
        while (x != null){
            y = x;
            cmp = node.pair.compareTo(x.pair);
            if(cmp < 0){
                x = x.left;
            }else {
                x = x.right;
            }
        }
        node.parent = y;
        cmp = node.pair.compareTo(y.pair);
        if(cmp < 0){
            y.left = node;
        }else {
            y.right = node;
        }
    }

    public BSNode minimum(BSNode root){
        if(root == null){
            return  null;
        }
        while (root.left != null){
            root = root.left;
        }
        return  root;
    }

    public BSNode successor(BSNode root){
        if (root.right != null){
            return  minimum(root.right);
        }
        BSNode y = root.parent;
        while ((y != null) && (root == y.right)){
            root = y;
            y = y.parent;
        }
        return  y;
    }

    public BSNode find(BSNode root, Pair pair){
        int cmp = root.pair.compareTo(pair);
        if(cmp == 0){
            return root;
        }else if(cmp < 0){
            return find(root.right, pair);
        }else {
            return find(root.left, pair);
        }
    }


    public BSNode remove(BSNode root,Pair pair ){
        BSNode z = find(root,pair);
        BSNode x = null;
        BSNode y = null;

        if ((z.left == null) || (z.right == null) )
            y = z;
        else
            y = successor(z);

        if (y.left != null)
            x = y.left;
        else
            x = y.right;

        if (x != null)
            x.parent = y.parent;

        if (y.parent == null)
            root = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        if (y != z)
            z.pair = y.pair;

        return  root;
    }

    public  void  inOrder(BSNode root, List<Integer> list){
        if(root != null){
            inOrder(root.left,list);
            list.add(root.pair.value);
            inOrder(root.right,list);
        }
    }

    public List<Integer> inOrderTravesal(BSNode root){
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return  list;
    }

    public  double median(List<Integer> list){
        int len = list.size();
        int mid = len / 2;
        if(len % 2 == 0){
            return  ((double)(list.get(mid)) + (double)(list.get(mid - 1))) / 2.0;
        }else {
            return  list.get(mid);
        }
    }


    //Accepted ----1518ms
    /*
        using binary search tree
     */
    public  double[] medianSlidingWindow(int[] nums,int k){
        if(k == 1){
            double[] temp = new double[nums.length];
            for(int j = 0; j < nums.length; j++){
                temp[j] = nums[j] / 1.0;
            }
            return  temp;
        }

        BSNode root = new BSNode(new Pair(nums[0],0));
        double[] result = new double[nums.length - k + 1];
        int index = 1, res_index = 1;
        while (index < k){
            insert(root,new BSNode(new Pair(nums[index],index)));
            index++;
        }
        result[0] = median(inOrderTravesal(root));
        root = remove(root,new Pair(nums[0],0));
        while (index < nums.length){
            insert(root,new BSNode(new Pair(nums[index],index)));
            double v = median(inOrderTravesal(root));
            result[res_index++] = v;
            root =  remove(root,new Pair(nums[index - k + 1], index - k + 1));
            index++;
        }

        return  result;
    }

    @Test
    public  void  test(){
        /*int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;*/
//        int[] nums = {2147483647,2147483647};

       /* int[] nums = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,
                2147483647,2147483647,-2147483648,2147483647,-2147483648};
        int k = 2;*/


      int[] nums =  {-2147483648,-2147483648,2147483647,-2147483648,1,3,-2147483648,-100,8,17,22,-2147483648,-2147483648,2147483647,2147483647,
                2147483647,2147483647,-2147483648,2147483647,-2147483648};
      int k = 6;


        long startTime = System.currentTimeMillis();
        double[] result = medianSlidingWindow(nums,k);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + "  ");
        }
        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }
}
