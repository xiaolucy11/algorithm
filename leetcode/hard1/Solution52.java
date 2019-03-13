package algorithm.hard1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youlu on 2018/12/6.
 */
public class Solution52 {

    public List<Map<Integer,Integer>> lists;

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

    //Accepted ---17ms
    public  int totalNQueens(int n){
        lists = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            Map<Integer, Integer> map =  new HashMap<>();
            map.put(i,0);
            search(n,1,map);
        }

        return  lists.size();
    }


    @Test
    public  void  test(){
        int n = 8;

        long startTime = System.currentTimeMillis();
        int result = totalNQueens(n);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
