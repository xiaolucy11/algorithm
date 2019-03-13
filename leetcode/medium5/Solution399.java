package algorithm.medium5;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/9/30.
 */
public class Solution399 {
    public  class Pair{
        String number;
        double value;
        Pair(String number, double value){
            this.number = number;
            this.value = value;
        }
    }


    public class Node{
        String number;
        List<Pair> list;
        Node(String number){
            this.number = number;
            list = new ArrayList<>();
        }

    }

    public  class  Element{
        String str1;
        String str2;
        Element(String str1, String str2){
            this.str1 = str1;
            this.str2 = str2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Element element = (Element) o;

            if (!str1.equals(element.str1)) return false;
            return str2.equals(element.str2);

        }

        @Override
        public int hashCode() {
            int result = str1.hashCode();
            result = 31 * result + str2.hashCode();
            return result;
        }
    }


    public int find(Node[] nodes,int index, String dividend){
        for(int i = 0; i < index; i++){
            if(nodes[i].number.equals(dividend)){
                return i;
            }
        }
        return -1;
    }

    public  boolean canArrive(Node[] graph, int index,int graphLength,
                              String target,List<Double> list, Set<String> path){
        Node head = graph[index];
        for(int i = 0; i < head.list.size(); i++){
            if(head.list.get(i).number.equals(target)){
                list.add(head.list.get(i).value);
                return  true;
            }
            int nextIndex = find(graph,graphLength,head.list.get(i).number);
            if(nextIndex != -1 && !path.contains(head.list.get(i).number)) {
                list.add(head.list.get(i).value);
                path.add(head.list.get(i).number);
                if(canArrive(graph, nextIndex, graphLength, target, list,path)){
                    return  true;
                }else {
                    list.remove(list.size() - 1);
                    path.remove(head.list.get(i).number);
                }
            }
        }

        return  false;
    }


    public double graphDSF(Node[] graph, int index,int graphLength, String target){
        Node head = graph[index];
        List<Double> list = new ArrayList<>();
        Set<String> path = new HashSet<>();
        boolean b = canArrive(graph, index,graphLength, target, list,path);
        if(list.size() == 0){
            return -1;
        }
        double result = 1.0;
        for(int i = 0; i < list.size(); i++){
            result *= list.get(i);
        }

        return  result;
    }

    //Accepted ----4ms
    /*
        graph dfs algorithm
     */
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries){
        Set<String> set = new HashSet<>();
        int equationsLength = equations.length;
        Node[] graph = new Node[2 * equationsLength];
        Map<Element, Double> map = new HashMap<>();
        int index = 0;

        for(int i = 0; i < equationsLength; i++){
            String dividend = equations[i][0];
            String divisor = equations[i][1];

            set.add(dividend);
            set.add(divisor);
            map.put(new Element(dividend,divisor), values[i]);
            map.put(new Element(divisor, dividend), (1.0 / values[i]));
            Pair quotient = new Pair(divisor, values[i]);

            int insertIndex = find(graph,index, dividend);
            if(insertIndex != -1){
                graph[insertIndex].list.add(quotient);
            }else {
                graph[index] = new Node(dividend);
                graph[index].list.add(quotient);
                index++;
            }

            int insertSecondIndex = find(graph,index, divisor);
            Pair secondQuotient = new Pair(dividend, (1.0 / values[i]));
            if(insertSecondIndex != -1){
                graph[insertSecondIndex].list.add(secondQuotient);
            }else {
                graph[index] = new Node(divisor);
                graph[index].list.add(secondQuotient);
                index++;
            }

        }

        int queriesLength = queries.length;
        double[] result = new double[queriesLength];
        for(int i = 0; i < queriesLength; i++){
            Element e = new Element(queries[i][0], queries[i][1]);
            if(!set.contains(queries[i][0]) || !set.contains(queries[i][1])){
                result[i] = -1.0;
            }else if(map.containsKey(e)){
                result[i] = map.get(e);
            }else {
                if(queries[i][0].equals(queries[i][1])){
                    result[i] = 1.0;
                }else {
                    int dividendIndex = find(graph,index,e.str1);
                    result[i] = graphDSF(graph, dividendIndex,index,e.str2);
                }
            }
        }

        return  result;
    }

    @Test
    public  void  test(){
       /* String[][] equations = {{"a","b"},{"b","c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};*/
     /* String[][] equations = {{"x1","x2"},{"x2","x3"},{"x3","x4"},{"x4","x5"}};
        double[] values = {3.0,4.0,5.0,6.0};
        String[][] queries = {{"x1","x5"},{"x5","x2"},{"x2","x4"},{"x2","x2"},
                {"x2","x9"},{"x9","x9"}};*/

        String[][] equations = {{"a","b"},{"c","d"}};
        double[] values = {1.0,1.0};
        String[][] queries = {{"a","c"},{"b","d"},{"b","a"},{"d","c"}};
        long startTime = System.currentTimeMillis();
        double[] result = calcEquation(equations,values, queries);
        long endTime = System.currentTimeMillis();
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + "  ");
        }
        System.out.println();
        System.out.println("runnint time : " + (endTime - startTime));
    }
}
