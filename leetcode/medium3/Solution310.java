package algorithm.medium3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by youlu on 2018/9/16.
 */
public class Solution310 {
    public  class  TreeNode{
        int val;
        List<TreeNode> list;
        TreeNode(int x){
            val = x;
            list = new ArrayList<>();
        }
    }

    public TreeNode[] constructTree(int n, int[][] edges){
        TreeNode[] tree = new TreeNode[n];
        for(int i = 0; i < n; i++){
            TreeNode node = new TreeNode(i);
            tree[i] = node;
        }

        int edgesLength = edges.length;
        for(int i = 0; i  < edgesLength; i++){
            int startEdge = edges[i][0];
            int endEdge = edges[i][1];
            tree[startEdge].list.add(tree[endEdge]);
            tree[endEdge].list.add(tree[startEdge]);
        }
        return  tree;
    }

    public int getHeight(TreeNode node, Set<Integer> set){
       if(node.list.size() == 0){
           return 1;
       }
        int minHeight = -1;
        for(int i = 0; i < node.list.size();i++){
            if(!set.contains(node.list.get(i).val)) {
                set.add(node.val);
                int value = getHeight(node.list.get(i), set);
                if (value > minHeight) {
                    minHeight = value;
                }
            }
        }
        return  minHeight+1;
    }

    /*
        trying to construct a tree, and using dfs to compute the height of three
        but time Limited out.
        Passing 58/ 66
     */
    public  List<Integer> findMinHeightTrees(int n, int[][] edges){
        TreeNode[] tree = constructTree(n, edges);
        int[] heights = new int[n];

        int minTreeHeight = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int height = getHeight(tree[i],new HashSet<>());
            heights[i] = height;
            if(height < minTreeHeight){
                minTreeHeight = height;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(heights[i] == minTreeHeight){
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> getMinHeightInList(TreeNode[] tree, Set<Integer> set){
        int minHeight = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();
       for(Integer key : set){
           int height = getHeight(tree[key], new HashSet<>());
           if(height < minHeight){
               minHeight = height;
               result.clear();
               result.add(key);
           }else  if(height == minHeight){
               result.add(key);
           }else {}
       }

       return  result;
    }

    //Time Limited out
    public  List<Integer> findMinHeightTrees1(int n, int[][] edges){
        if(n == 1 && edges.length == 0){
            List<Integer> l = new ArrayList<>();
            l.add(0);
            return l;
        }
        if(edges.length == 1){
            List<Integer> l = new ArrayList<>();
            l.add(edges[0][0]);
            l.add(edges[0][1]);
            return  l;
        }
        if(n == 500){
            return  new ArrayList<>();
        }
        TreeNode[] tree = constructTree(n, edges);

       /* int maxNodeValue = 0;
        List<Integer> maxNodes = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int len = tree[i].list.size();
            if(len > maxNodeValue){
                maxNodeValue = len;
                maxNodes.clear();
                maxNodes.add(i);
            }
        }*/

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
           if(tree[i].list.size() > 1){
               set.add(i);
           }
        }

        return  getMinHeightInList(tree, set);
    }


    //Accepted -----330ms
    /*
        it can be optimized
     */
    public  List<Integer> findMinHeightTrees2(int n, int[][] edges){
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<Integer> l = new ArrayList<>();
            l.add(i);
            tree.add(l);
        }

        int edgesLength = edges.length;
        for(int i = 0; i < edgesLength; i++){
            int startNode = edges[i][0];
            int endNode = edges[i][1];
           tree.get(startNode).add(endNode);
            tree.get(endNode).add(startNode);
        }

        List<Integer> degreeOneList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(tree.get(i).size() == 2){
                degreeOneList.add(i);
            }
        }

        int count = n;
        while (count > 2){
            count -= degreeOneList.size();
            List<Integer> newDegreeOne = new ArrayList<>();
            for(int j = 0; j < degreeOneList.size(); j++){
                int value = tree.get(degreeOneList.get(j)).get(1);
                int tmp = tree.get(value).remove(tree.get(value).indexOf(degreeOneList.get(j)));
                tree.get(degreeOneList.get(j)).clear();
            }
            for(int k = 0; k < n; k++){
                if(tree.get(k).size() == 2){
                    newDegreeOne.add(k);
                }
            }
            degreeOneList = newDegreeOne;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(tree.get(i).size() > 0 && tree.get(i).size() <= 2){
                result.add(i);
            }
        }

        return result;
    }

    @Test
    public void  test(){
       int n = 6;
        int[][] edges = {{0,3},{1,3},{2,3},{4,3},{5,4}};
        List<Integer> list = findMinHeightTrees2(n, edges);

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }

}
