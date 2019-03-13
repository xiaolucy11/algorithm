package algorithm.medium8;

import algorithm.medium5.Solution430;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by youlu on 2018/11/4.
 */
public class Solution721 {
    public  List<List<String>> lists;

    public  void  search(List<List<String>> accounts,int index, int[] arr){
        Set<String> set = new TreeSet<>();
        for(int i = 1; i < accounts.get(index).size(); i++){
            set.add(accounts.get(index).get(i));
        }

        for(int i = index + 1; i < accounts.size(); i++){
            if(arr[i] == 0 && accounts.get(i).get(0).equals(accounts.get(index).get(0))){
                int flag = 0;
                for(int j = 1; j < accounts.get(i).size(); j++){
                    if(set.contains(accounts.get(i).get(j))){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 1){
                    for(int j = 1; j < accounts.get(i).size(); j++){
                        set.add(accounts.get(i).get(j));
                    }
                    arr[i] = 1;
                }
            }
        }

        List<String> list  = new ArrayList<>();
        list.add(accounts.get(index).get(0));
        for(String str : set){
            list.add(str);
        }
        lists.add(list);
    }

    //Wrong solution
    public List<List<String>> accountsMerge(List<List<String>> accounts){
        lists = new ArrayList<>();
        int[] arr = new int[accounts.size()];

        for(int i = 0; i < accounts.size(); i++){
            if(arr[i] == 0){
                search(accounts,i,arr);
            }
        }

        return  lists;
    }

    public  class  Node{
        int index;
        List<Integer> list;
        Node(int _index){
            index = _index;
            list = new ArrayList<>();
        }
    }

    public  void  constructGraph(List<List<String>> accounts, int index,Node[] nodes){
        Set<String> set = new TreeSet<>();
        for(int i = 1; i < accounts.get(index).size(); i++){
            set.add(accounts.get(index).get(i));
        }

        for(int i = 0; i < accounts.size(); i++){

            if(i == index){
                continue;
            }
            int flag = 0;
            for(int j = 1; j < accounts.get(i).size();j++){
                if(accounts.get(i).get(0).equals(accounts.get(index).get(0)) &&
                        set.contains(accounts.get(i).get(j))){
                    flag = 1;
                    break;
                }
            }

            if(flag == 1){
                nodes[index].list.add(i);
            }
        }
    }

    public  void  dfs(List<List<String>> accounts,Node[] nodes,int index, int[] arr){
        Queue<Integer> queue = new ArrayDeque<>();
        arr[index] = 1;
        queue.add(index);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            int nodeIndex = queue.poll();
            list.add(nodeIndex);
            List<Integer> output = nodes[nodeIndex].list;
            for(int i = 0; i < output.size();i++){
                if(arr[output.get(i)] == 0){
                    arr[output.get(i)] = 1;
                    queue.add(output.get(i));
                }
            }
        }
        List<String> stringList = new ArrayList<>();
        stringList.add(accounts.get(index).get(0));
        Set<String> set = new TreeSet<>();
        for(int i = 1; i < accounts.get(index).size(); i++){
            set.add(accounts.get(index).get(i));
        }

        for(int i = 0; i < list.size(); i++){
            for(int j = 1; j < accounts.get(list.get(i)).size(); j++){
                set.add(accounts.get(list.get(i)).get(j));
            }
        }

        for(String str : set){
            stringList.add(str);
        }
        lists.add(stringList);
    }

    public List<List<String>> accountsMerge1(List<List<String>> accounts){
        Node[] nodes = new Node[accounts.size()];
        for(int i = 0; i < nodes.length; i++){
            nodes[i] = new Node(i);
        }

        int[] arr = new int[accounts.size()];
        lists = new ArrayList<>();

        for(int i = 0; i < accounts.size(); i++){
            constructGraph(accounts, i, nodes);
        }

        for(int i = 0; i < accounts.size(); i++){
            if(arr[i] == 0){
                dfs(accounts, nodes,i, arr);
            }
        }

        return  lists;
    }

    public  void  constructGrap2(List<List<String>> accounts, int[][] matrix, int index){
        Set<String> set = new TreeSet<>();
        for(int i = 1; i < accounts.get(index).size(); i++){
            set.add(accounts.get(index).get(i));
        }

        for(int i = index + 1; i < accounts.size(); i++){
            if(accounts.get(index).get(0).equals(accounts.get(i).get(0))){
                for(int j = 1; j < accounts.get(i).size(); j++){
                    if(set.contains(accounts.get(i).get(j))){
                        matrix[index][i] = 1;
                        matrix[i][index] = 1;
                    }
                }
            }
        }
    }

    public  void  bfs(List<List<String>> accounts, int[][] matrix, int index, int[] visited){
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        queue.add(index);
        set.add(index);
        visited[index] = 1;

        while (!queue.isEmpty()){
            int v = queue.poll();
            for(int i = 0; i < matrix.length; i++){
                if(matrix[v][i] == 1 && !set.contains(i)){
                    queue.add(i);
                    set.add(i);
                    visited[i] = 1;
                }
            }
        }

        Set<String> stringSet = new TreeSet<>();
        for(Integer value : set){
            for(int i = 1; i < accounts.get(value).size(); i++){
                stringSet.add(accounts.get(value).get(i));
            }
        }

        List<String> stringList = new ArrayList<>();
        stringList.add(accounts.get(index).get(0));
        for(String str: stringSet){
            stringList.add(str);
        }

        lists.add(stringList);
    }

    //Accepted ---664ms
    /*
        graph algorithm
        not effecient
     */
    public List<List<String>> accountsMerge2(List<List<String>> accounts){
        int[][] matrix = new int[accounts.size()][accounts.size()];
        lists = new ArrayList<>();
        int[] visited = new int[accounts.size()];

        for(int i = 0; i < accounts.size(); i++){
            constructGrap2(accounts,matrix, i);
        }

        for(int i = 0; i < accounts.size(); i++){
            if(visited[i] == 0){
                bfs(accounts, matrix, i,visited);;
            }
        }
        return  lists;
    }

    @Test
    public  void  test(){
       /* List<List<String>> accounts = new ArrayList<>();
        List<String> list1= new ArrayList<>();
        list1.add("John");
        list1.add("johnsmith@mail.com");
        list1.add("john00@mail.com");
        accounts.add(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("John");
        list2.add("johnnybravo@mail.com");
        accounts.add(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("John");
        list3.add("johnsmith@mail.com");
        list3.add("john_newyork@mail.com");
        accounts.add(list3);

        List<String> list4 = new ArrayList<>();
        list4.add("Mary");
        list4.add("mary@mail.com");
        accounts.add(list4);*/

       /*List<List<String>> accounts = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("David");
        list1.add("David0@m.co");
        list1.add("David1@m.co");
        accounts.add(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("David");
        list2.add("David3@m.co");
        list2.add("David4@m.co");
        accounts.add(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("David");
        list3.add("David4@m.co");
        list3.add("David5@m.co");
        accounts.add(list3);

        List<String> list4 = new ArrayList<>();
        list4.add("David");
        list4.add("David2@m.co");
        list4.add("David3@m.co");
        accounts.add(list4);

        List<String> list5 = new ArrayList<>();
        list5.add("David");
        list5.add("David1@m.co");
        list5.add("David2@m.co");
        accounts.add(list5);
*/
      List<List<String>> accounts = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("David");
        list1.add("David0@m.co");
        list1.add("David0@m.co");
        list1.add("David1@m.co");
        list1.add("David2@m.co");
        list1.add("David3@m.co");
        list1.add("David4@m.co");
        list1.add("David5@m.co");
        list1.add("David6@m.co");
        list1.add("David7@m.co");
        accounts.add(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("David");
        list2.add("David0@m.co");
        list2.add("David0@m.co");
        list2.add("David1@m.co");
        list2.add("David2@m.co");
        list2.add("David3@m.co");
        list2.add("David4@m.co");
        list2.add("David5@m.co");
        list2.add("David6@m.co");
        list2.add("David7@m.co");
        accounts.add(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("David");
        list3.add("David2@m.co");
        list3.add("David18@m.co");
        list3.add("David19@m.co");
        list3.add("David20@m.co");
        list3.add("David21@m.co");
        list3.add("David22@m.co");
        list3.add("David23@m.co");
        list3.add("David24@m.co");
        list3.add("David25@m.co");
        accounts.add(list3);

        List<String> list4 = new ArrayList<>();
        list4.add("David");
        list4.add("David3@m.co");
        list4.add("David27@m.co");
        list4.add("David28@m.co");
        list4.add("David29@m.co");
        list4.add("David30@m.co");
        list4.add("David31@m.co");
        list4.add("David32@m.co");
        list4.add("David33@m.co");
        list4.add("David34@m.co");
        accounts.add(list4);

        List<String> list5 = new ArrayList<>();
        list5.add("David");
        list5.add("David1@m.co");
        list5.add("David9@m.co");
        list5.add("David10@m.co");
        list5.add("David11@m.co");
        list5.add("David12@m.co");
        list5.add("David13@m.co");
        list5.add("David14@m.co");
        list5.add("David15@m.co");
        list5.add("David16@m.co");
        accounts.add(list5);


        long startTime = System.currentTimeMillis();
        List<List<String>> result = accountsMerge2(accounts);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + "  ");
            }

            System.out.println();
        }
        System.out.println("running time : " + (endTime - startTime));

    }

    @Test
    public  void  test1(){
        List<List<String>> accounts = new ArrayList<>();
        List<String> list1 = new ArrayList<>();

        long startTime = System.currentTimeMillis();
        List<List<String>> result = accountsMerge1(accounts);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + "  ");
            }

            System.out.println();
        }
        System.out.println("running time : " + (endTime - startTime));
    }
}
