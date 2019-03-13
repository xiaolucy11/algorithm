package algorithm.hard1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youlu on 2018/12/6.
 */
public class Solution51 {

    public  List<Map<Integer,Integer>> lists;

    public boolean check(Map<Integer,Integer> map, int row, int col, int n){
        int leftcol = col, rightcol = col;
        int leftUp = row, rightUp = row;

        while (leftcol >= 0 && leftUp >= 0){
            if((!map.containsKey(leftcol)) || (map.get(leftcol) != leftUp)){
                leftcol--;
                leftUp--;
            }else {
                return  false;
            }
        }

        while (rightcol < n && rightUp >= 0){
            if((!map.containsKey(rightcol)) || (map.get(rightcol) != rightUp)){
                rightcol++;
                rightUp--;
            }else {
                return  false;
            }
        }

        return  true;
    }

    public  void  search(int n,int index,Map<Integer,Integer> map){
        if(index == n){
            lists.add(new HashMap<>(map));
            return;
        }

        for(int i = 0; i < n; i++){
            if(!map.containsKey(i) && check(map,index,i,n)){
                map.put(i, index);
                search(n, index+1, map);
                map.remove(i,index);
            }
        }
    }

    public  List<String> mapToStr(Map<Integer, Integer> map, int n){
        StringBuilder sb = new StringBuilder();
        char[][] chars = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                chars[i][j] = '.';
            }
        }

        for(Integer key: map.keySet()){
            int index = map.get(key);
            chars[index][key] = 'Q';
        }

        List<String> stringList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            stringList.add(new String(chars[i]));
        }

        return  stringList;

    }


    //Accepted -----13ms
    public List<List<String>> solveNQueens(int n){
        lists = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            Map<Integer, Integer> map =  new HashMap<>();
            map.put(i,0);
            search(n,1,map);
        }

        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i < lists.size(); i++){
            result.add(mapToStr(lists.get(i), n));
        }

        return result;
    }

    @Test
    public  void  test(){
        int n = 5;


        long startTime = System.currentTimeMillis();
        List<List<String>> result = solveNQueens(n);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.println(result.get(i).get(j));
            }
            System.out.println(" soltion : " + i);
            System.out.println("-------------------------------------------");
        }

        System.out.println("running time : " + (endTime - startTime));
    }
}
