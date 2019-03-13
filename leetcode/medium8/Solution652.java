package algorithm.medium8;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by youlu on 2018/10/27.
 */
public class Solution652 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public  boolean duplicateSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if ((root1 == null && root2 != null) || (
                root1 != null && root2 == null
        )) {
            return false;
        } else {

        if((root1.left == null && root1.right == null) && (
                root2.left == null && root2.right == null
                )) {
            if (root1.val == root2.val) {
                return  true;
            } else {
                return false;
            }
        }

            if (root1.val == root2.val) {
                if ((root1.left == null && root2.left != null) ||
                        (root1.left != null && root2.left == null)) {
                    return false;
                }

                if ((root1.right == null && root2.right != null) || (
                        root1.right != null && root2.right == null
                )) {
                    return false;
                }
                return duplicateSubtree(root1.left, root2.left) &&
                        duplicateSubtree(root1.right, root2.right);
            } else {
                return false;
            }
        }
    }

    public List<TreeNode> levelOrder(TreeNode root){
        List<TreeNode> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node);
            if(node.left != null){
                queue.add(node.left);
            }

            if(node.right != null){
                queue.add(node.right);
            }
        }
        return  result;
    }

    public  boolean isLeftLink(TreeNode root){
        TreeNode p = root;
        while (p != null){
            if(p.right != null){
                return false;
            }
            p = p.left;
        }
        return  true;
    }

    public  boolean isRightLink(TreeNode root){
        TreeNode p = root;
        while (p != null){
            if(p.left != null){
                return  false;
            }
            p = p.right;
        }
        return  true;
    }

    public  boolean isSubNode(TreeNode root, TreeNode node){
        if(root == null){
            return false;
        }
        if(root.left == node || root.right == node){
            return  true;
        }else {
            return  isSubNode(root.left, node) || isSubNode(root.right, node);
        }
    }

    // pass 122/168
    public List<TreeNode> findDuplicateSubtrees(TreeNode root){
        if(root == null || isLeftLink(root) || isRightLink(root)){
            return  new ArrayList<>();
        }
        List<TreeNode> allNodes = levelOrder(root);
        Collections.sort(allNodes, new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o1.val - o2.val;
            }
        });
        if(allNodes.get(0).val == allNodes.get(allNodes.size() - 1).val &&
                isRightLink(root)){
            return new ArrayList<>();
        }
        int[] arr = new int[allNodes.size()];
        Map<TreeNode,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < allNodes.size(); i++){
            map.put(allNodes.get(i), i);
        }

        List<TreeNode> list = new ArrayList<>();
        for(int i = 0; i < allNodes.size(); i++){
            if(arr[i] == 1){
                continue;
            }

            int index = i + 1;
            int flag = 0;
            while (index < allNodes.size()){
                if(allNodes.get(i).val != allNodes.get(index).val){
                    break;
                }else {
                    if(arr[index] == 0 && (!isSubNode(allNodes.get(i),allNodes.get(index)) &&
                                !isSubNode(allNodes.get(index), allNodes.get(i))) && duplicateSubtree(allNodes.get(i), allNodes.get(index))){
                        flag = 1;
                        arr[map.get(allNodes.get(index))] = 1;
                    }
                    index++;
                }
            }
            if(flag == 1){
                if(allNodes.get(i).left == null && allNodes.get(i).right == null){
                    if(!set.contains(allNodes.get(i).val)){
                        list.add(allNodes.get(i));
                    }
                }else {
                    list.add(allNodes.get(i));
                }
            }

        }
        return  list;
    }


    public Map<String,Integer> map ;
    public List<TreeNode> list;

    public  String search(TreeNode root){
        if(root == null){
            return "";
        }
        String str = Integer.toString(root.val) +":" +search(root.left)+":"+search(root.right);
        map.put(str, map.getOrDefault(str,0) + 1);
        if(map.get(str) == 2){
            list.add(root);
        }
        return  str;
    }

    //Accepted ---39ms
    /*
        from bottom to up
     */
    public List<TreeNode> findDuplicateSubtrees1(TreeNode root){
        map = new HashMap<>();
        list = new ArrayList<>();
        String string = search(root);
        return  list;
    }

    /*
        code from other
        genius solution
     */
    public  int t;
    public  Map<String, Integer> trees;
    public Map<Integer, Integer> count;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees2(TreeNode root){
        t = 1;
        trees = new HashMap<>();
        ans = new ArrayList<>();
        lookup(root);
        return ans;

    }
    public int lookup(TreeNode node) {
        if (node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        int uid = trees.computeIfAbsent(serial, x-> t++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2)
            ans.add(node);
        return uid;
    }


    @Test
    public  void  test(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l21 = new TreeNode(2);
        TreeNode l22 = new TreeNode(3);
        TreeNode l31 = new TreeNode(4);
        TreeNode l33 = new TreeNode(2);
        TreeNode l34 = new TreeNode(4);
        TreeNode l41 = new TreeNode(4);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l22.left = l33;
        l22.right = l34;
        l33.left = l41;

        /*TreeNode l1 = new TreeNode(0);
        TreeNode l21 = new TreeNode(0);
        TreeNode l22 = new TreeNode(0);
        TreeNode l31 = new TreeNode(0);
        TreeNode l32 = new TreeNode(0);
        TreeNode l41 = new TreeNode(0);
        TreeNode l42 = new TreeNode(0);

        l1.left = l21;
        l1.right = l22;
        l21.left  = l31;
        l22.right = l32;
        l32.left = l41;
        l32.right = l42;
*/
        /*TreeNode l1 = new TreeNode(0);
        TreeNode l21 = new TreeNode(0);
        TreeNode l22 = new TreeNode(0);
        TreeNode l31 = new TreeNode(0);
        TreeNode l32 = new TreeNode(0);
        TreeNode l41 = new TreeNode(0);
        TreeNode l42 = new TreeNode(0);
        TreeNode l43 = new TreeNode(0);
        TreeNode l44 = new TreeNode(0);

        l1.left = l21;
        l1.right = l22;
        l21.left = l31;
        l22.right = l32;
        l31.left = l41;
        l31.right = l42;
        l32.left =  l43;
        l32.right = l44;*/

      /*TreeNode l1 = new TreeNode(0);
        TreeNode l2 = new TreeNode(0);
        TreeNode l3 = new TreeNode(0);
        TreeNode l4 = new TreeNode(0);
        TreeNode l5 = new TreeNode(0);
        TreeNode l6 = new TreeNode(0);
        TreeNode l7 = new TreeNode(0);
        TreeNode l8 = new TreeNode(0);
        TreeNode l9 = new TreeNode(0);
        TreeNode l10 = new TreeNode(0);
        TreeNode l11 = new TreeNode(0);
        TreeNode l12 = new TreeNode(0);
        TreeNode l13 = new TreeNode(0);

        l1.right = l2;
        l2.right = l3;
        l3.right = l4;
        l4.right = l5;
        l5.right = l6;
        l6.right = l7;
        l7.right = l8;
        l8.right = l9;
        l9.right = l10;
        l10.right = l11;
        l11.right = l12;
        l11.left = l13;*/


        long startTime = System.currentTimeMillis();
        List<TreeNode> result = findDuplicateSubtrees1(l1);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i).val + "  ");
        }
        System.out.println();
        System.out.println("running time :" + (endTime - startTime));

    }

}
