package algorithm.medium4;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/9/20.
 */
public class Solution332 {
    public  int finMinistLexicalOrder(List<String> list){
        String minOrderStr = list.get(0);
        int index = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).compareTo(minOrderStr) < 0){
                minOrderStr = list.get(i);
                index = i;
            }
        }

        return  index;
    }

    public  boolean mapIsEmpty(Map<String, List<String>> map){
        for(String key : map.keySet()){
            if(map.get(key) != null ||
                    map.get(key).size() != 0){
               return  false;
            }
        }

        return  true;
    }

    public  void  travesal(List<String> result, Map<String, List<String>> map,String departureString){
        if(map.get(departureString) == null ||
                map.get(departureString).size() == 0){
            return;
        }
        List<String> arriveList = new ArrayList<>(map.get(departureString));
        List<String> copyList = new ArrayList<>(map.get(departureString));
        for(int i = 0; i < arriveList.size(); i++){
            String arriveCity = arriveList.get(i);
            result.add(arriveCity);
            arriveList.remove(i);
            map.replace(departureString,arriveList);
            travesal(result, map, arriveCity);

            if(!mapIsEmpty(map)){
                map.put(departureString, copyList);
                result.remove(result.size() - 1);
            }else {
                return;
            }
        }
    }


    /*
        Wrong Solution
     */
    public List<String> findItinerary(String[][] tickets ){
        int length = tickets.length;
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < length; i++){
            String keyString = tickets[i][0];
            String valueString = tickets[i][1];
            if(map.containsKey(keyString)){
                List<String> list = map.get(keyString);
                list.add(valueString);
            }else {
                List<String> newList = new ArrayList<>();
                newList.add(valueString);
                map.put(keyString, newList);
            }
        }

        for(String key : map.keySet()){
            List<String> str = map.get(key);
            Collections.sort(str);
            map.put(key, str);
        }

        List<String> result = new ArrayList<>();
        String firstCity = "JFK";
        result.add(firstCity);

        travesal(result, map, firstCity);
        return  result;
    }

    public  class  Node{
        String depature;
        List<String> arrival;

        public Node(String _depature){
            depature = _depature;
            arrival = new ArrayList<>();
        }
    }

    public int findInNodes(String str, Node[] nodes, int index){
        for(int i = 0; i < index; i++){
            if(nodes[i].depature.equals(str)){
                return i;
            }
        }
        return  -1;
    }
    public  boolean isEmptyInNodes(Node[] nodes, Map<String, Integer> map){
       for(String key : map.keySet()){
           if(nodes[map.get(key)].arrival.size() != 0){
               return  false;
           }
       }
        return true;
    }


    public  void  travesal(List<String> result, Node[] nodes,Map<String, Integer> map,
                           String depatureString){
        if(!map.containsKey(depatureString)){
            return;
        }
        List<String> arrivalList = nodes[map.get(depatureString)].arrival;
        List<String> copyArrivalList = new ArrayList<>(nodes[map.get(depatureString)].arrival);
        for(int i = 0; i < copyArrivalList.size(); i++){
            String arrivalString = copyArrivalList.get(i);
            result.add(arrivalString);
            arrivalList.remove(i);
            travesal(result, nodes, map, arrivalString);

            if(!isEmptyInNodes(nodes,map)){
                arrivalList.add(i,arrivalString);
                result.remove(result.size()-1);
            }else {
                return;
            }
        }
    }

    //Accepted ------- 19ms
    /*
        graph travesal and traceback
     */
    public  List<String> findItinerary1(String[][] tickets ){
        int length = tickets.length;
        Node[] nodes = new Node[length];
        nodes[0] = new Node("JFK");
        Map<String, Integer> map = new TreeMap<>();
        map.put("JFK",0);

        int nodesIndex = 1;
        for(int i = 0; i < length; i++){
            String depatureStr = tickets[i][0];
            String arrivalStr = tickets[i][1];

            if(!map.containsKey(depatureStr)){
                nodes[nodesIndex] = new Node(depatureStr);
                nodes[nodesIndex].arrival.add(arrivalStr);
                map.put(depatureStr,nodesIndex);
                nodesIndex++;
            }else {
                int findIndex = map.get(depatureStr);
                nodes[findIndex].arrival.add(arrivalStr);
            }

        }

        for(int i = 0; i < nodesIndex; i++){
            Collections.sort(nodes[i].arrival);
        }

        List<String> result = new ArrayList<>();
        result.add("JFK");
        travesal(result, nodes, map, "JFK");
        return  result;
    }


    @Test
    public  void  test(){
        //String[][] tickets = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},
                {"ATL","JFK"},{"ATL","SFO"}};
        //String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        long startTime = System.currentTimeMillis();
        List<String> list = findItinerary1(tickets);
        long endTime = System.currentTimeMillis();
        System.out.println("runnint time : " + (endTime - startTime));

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + "   ");
        }
    }
}
