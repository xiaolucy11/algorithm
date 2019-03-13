package interview.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/15 0015.
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex){

        if (rowIndex == 0){
            List<Integer> l = new ArrayList<>();
            l.add(1);
            return l;
        }
        List<Integer> preList = getRow(rowIndex - 1);
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for(int i = 0; i < preList.size()-1; i++){
            result.add(preList.get(i) + preList.get(i+1));
        }
        result.add(1);
        return  result;
    }

    @Test
    public void  test(){
        List<Integer> result = getRow(3);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }
}
