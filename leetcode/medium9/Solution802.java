package algorithm.medium9;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/11/17.
 */
public class Solution802 {
    public  Set<Integer> noCircleSet;
    public  Set<Integer> circleSet;

    public  void   dfs(int[][] graph, int index, Set<Integer> paths){

        if(graph[index].length == 0){
            for(Integer node : paths){
                noCircleSet.add(node);
            }
            return;
        }

         for(int i = 0; i < graph[index].length; i++){
             if(circleSet.contains(index)){
                 return;
             }
             if(circleSet.contains(graph[index][i]) || paths.contains(graph[index][i])){
                 for(Integer node : paths){
                     circleSet.add(node);
                     if(noCircleSet.contains(node)){
                         noCircleSet.remove(node);
                     }
                 }
                 return;
             }else {
                 paths.add(graph[index][i]);
                 dfs(graph, graph[index][i], paths);
                 paths.remove(graph[index][i]);
             }
         }
    }


    //Time Limit Excced
    /*
        pass 92 / 111
     */
    public List<Integer> eventualSafeNodes(int[][] graph){
        noCircleSet = new HashSet<>();
        circleSet = new HashSet<>();
        int[] arr = new int[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!noCircleSet.contains(i) && ! circleSet.contains(i)){
                Set<Integer> paths = new HashSet<>();
                paths.add(i);
                dfs(graph, i, paths);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(Integer val : noCircleSet){
            list.add(val);
        }
        Collections.sort(list);
        return  list;
    }

    //Accepted ----- 196ms
    /*
        not effecient, wasting too many space
     */
    public List<Integer> eventualSafeNodes1(int[][] graph){
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        List<Set<Integer>> setList = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            Set<Integer> set = new HashSet<>();
            if(graph[i].length == 0){
                queue.add(i);
                setList.add(set);
                continue;
            }
            for(int j = 0; j < graph[i].length; j++){
                set.add(graph[i][j]);
                if(map.containsKey(graph[i][j])){
                    Set<Integer> input = map.get(graph[i][j]);
                    input.add(i);
                }else {
                    Set<Integer>  input = new HashSet<>();
                    input.add(i);
                    map.put(graph[i][j], input);
                }
            }
            setList.add(set);
        }

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()){
            int node = queue.poll();
            list.add(node);
            if(map.containsKey(node)){
                Set<Integer> input = map.get(node);
                for(Integer value : input){
                    setList.get(value).remove(node);
                    if(setList.get(value).size() == 0){
                        queue.add(value);
                    }
                }
            }
        }

        Collections.sort(list);
        return  list;
    }

    public boolean search(int[] status, int[][] graph, int node) {
        if (status[node] > 0) {
            return status[node] == 1;
        }

        status[node] = 2;
        for (int next : graph[node]) {
            if (!search(status, graph, next)) {
                return false;
            }
        }
        status[node] = 1;
        return true;
    }

    /*
        code from other
        dfs and memorization
        status : 0 , not visited; 1 : no circle, 2 : circle
        when first visited ,set status 2; after visit all node , set status 1, return true
     */
    public List<Integer> eventualSafeNodes2(int[][] graph) {
        List<Integer> result = new ArrayList<>();

        int len = graph.length;
        int[] status = new int[len];
        for (int i = 0; i < len; i++) {
            if (search(status, graph, i)) {
                result.add(i);
            }
        }
        return result;
    }


    @Test
    public  void  test(){
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{}, {}};

        long startTime = System.currentTimeMillis();
        List<Integer> result = eventualSafeNodes1(graph);
        long endTime = System.currentTimeMillis();


        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }
}
