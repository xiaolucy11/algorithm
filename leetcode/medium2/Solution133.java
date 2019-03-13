package interview.medium2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/4 0004.
 */
public class Solution133 {
    public  class UndirectedGraphNode{
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x){
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public  int find(List<UndirectedGraphNode> list , int value){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).label == value){
                return i;
            }
        }
        return  -1;
    }

    public  void  generate(UndirectedGraphNode node,List<UndirectedGraphNode> list){
       int index1 = find(list, node.label);
        UndirectedGraphNode generateNode = list.get(index1);
        for(int i = 0; i < node.neighbors.size(); i++){
            int index2 = find(list, node.neighbors.get(i).label);
            if(index2 == -1){
                UndirectedGraphNode temp = new UndirectedGraphNode(node.neighbors.get(i).label);
                list.add(temp);
                generateNode.neighbors.add(temp);
                generate(node.neighbors.get(i), list);
            }else {

                if(generateNode.label == node.neighbors.get(i).label){
                   generateNode.neighbors.add(generateNode);
                }else {
                    generateNode.neighbors.add(list.get(index2));
                }

            }
        }
    }


    //Accepted -----23ms
    /*
        not effencent
     */
    public  UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if(node == null){
            return null;
        }
        if(node.neighbors.size() == 0){
            return new UndirectedGraphNode(node.label);
        }

        UndirectedGraphNode node1 = new UndirectedGraphNode(node.label);
        List<UndirectedGraphNode> list = new ArrayList<>();
        list.add(node1);
        generate(node, list);

        return node1;
    }

    public  void  generate1(UndirectedGraphNode node, int value, Map<Integer, UndirectedGraphNode>map){
        UndirectedGraphNode nextNode = null;
        if(map.containsKey(value)){
            nextNode = map.get(value);
        }

        for(int i = 0; i < node.neighbors.size(); i++){
            int neighborsValue = node.neighbors.get(i).label;
            if(!map.containsKey(neighborsValue)){
                UndirectedGraphNode temp = new UndirectedGraphNode(neighborsValue);
                map.put(neighborsValue, temp);
                nextNode.neighbors.add(temp);
                generate1(node.neighbors.get(i), neighborsValue, map);
            }else {
                if(map.get(neighborsValue) == nextNode){
                    nextNode.neighbors.add(nextNode);
                }else {
                    nextNode.neighbors.add(map.get(neighborsValue));
                }
            }
        }
    }

    //Accepted -----5ms
    public  UndirectedGraphNode cloneGraph1(UndirectedGraphNode node){
        if(node == null){
            return null;
        }
        if(node.neighbors.size() == 0){
            return  new UndirectedGraphNode(node.label);
        }

        UndirectedGraphNode node1 = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        map.put(node.label, node1);
        generate1(node, node.label, map);
        return  node1;
    }
}
