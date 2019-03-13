package algorithm.medium9;

import org.junit.Test;

/**
 * Created by youlu on 2018/11/12.
 */
public class Solution785 {

    public  boolean dfs(int[][] graph, int[] arr, int index){
        if(arr[index] == 0){
            arr[index] = 1;
            for(int j = 0; j < graph[index].length; j++){
                int v = graph[index][j];
                if(arr[v] == 1){
                    return  false;
                }
                arr[v] = 2;

                if(v > index){
                    if(!dfs(graph, arr,v)){
                        return  false;
                    }
                }
            }
        }else if(arr[index] == 1){
            for(int j = 0; j < graph[index].length; j++){
                int v = graph[index][j];
                if(arr[v] == 1){
                    return  false;
                }
                arr[v] = 2;


                if(v > index){
                    if(!dfs(graph, arr,v)){
                        return  false;
                    }
                }
            }
        }else {
            for(int j = 0; j < graph[index].length; j++){
                int v = graph[index][j];
                if(arr[v] == 2){
                    return  false;
                }
                arr[v] = 1;


                if(v > index){
                    if(!dfs(graph, arr,v)){
                        return  false;
                    }
                }
            }
        }

        return  true;
    }

    //Accepted ----6ms
    /*
        deep search algorithm
     */
    public  boolean isBipartie(int[][] graph){
       int[] arr = new int[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!dfs(graph, arr,i)){
                return  false;
            }
        }

        return  true;
    }

    @Test
    public  void  test(){
       int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
//
//        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
//        int[][] graph = {{1},{0,3},{3},{1,2}};

        long startTime = System.currentTimeMillis();
        boolean b = isBipartie(graph);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + b);
        System.out.println("running time : " + (endTime - startTime));
    }
}
