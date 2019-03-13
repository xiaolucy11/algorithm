package interview.easy5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/4 0004.
 */
public class Solution830 {
    //Accepted ---10ms
    public List<List<Integer>> largeGroupPositions(String S){
        List<List<Integer>> lists = new ArrayList<>();
        int slow = 0, quick = 0;
        while(quick < S.length()){
            if(S.charAt(slow) == S.charAt(quick)){
                quick++;
            }else {
                if(quick - slow >= 3){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(slow);
                    list.add(quick-1);
                    lists.add(list);
                }
                slow = quick;
                quick++;
            }
        }
        if (quick - slow >= 3){
            List<Integer> list = new ArrayList<Integer>();
            list.add(slow);
            list.add(quick-1);
            lists.add(list);
        }
        return  lists;
    }


    @Test
    public  void  test(){
        String S = "abc";
        List<List<Integer>> result = largeGroupPositions(S);
        for(int i = 0; i < result.size();i++){
            System.out.println(result.get(i).get(0) + ":" + result.get(i).get(1));
        }
    }
}
