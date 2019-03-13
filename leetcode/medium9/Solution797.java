package algorithm.medium9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/11/16.
 */
public class Solution797 {
    public  List<List<Integer>> result;

    public  void  search(int[][] graph, int index, List<Integer> list){
        if(index == graph.length - 1){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < graph[index].length; i++){
            int v = graph[index][i];
            list.add(v);
            search(graph, v, list);
            list.remove(list.size() - 1);
        }
    }

    //Accepted ----5ms
    /*
        bfs
     */
    public  List<List<Integer>> allPathsSourceTarget(int[][] graph){
        result = new ArrayList<>();

        for(int i = 0; i < graph[0].length; i++){
            List<Integer> list = new ArrayList<>();
            list.add(0);
            int nextNode = graph[0][i];
            list.add(nextNode);
            search(graph, nextNode, list);
        }

        return  result;
    }


    @Test
    public  void  test(){
        int[][] graph = {{1,2},{3},{3},{}};

        long startTime = System.currentTimeMillis();
        List<List<Integer>> lists = allPathsSourceTarget(graph);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < lists.size(); i++){
            for(int j = 0; j < lists.get(i).size(); j++){
                System.out.print(lists.get(i).get(j) + "  ");
            }

            System.out.println();
        }

        System.out.println("running time : " + (endTime - startTime));
    }
}
