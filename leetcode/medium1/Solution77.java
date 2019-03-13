package interview.medium1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/14 0014.
 */
public class Solution77 {
    public  void  generate(List<List<Integer>> lists, List<Integer> list, int n, int k){
        if(list.size() == k){
            lists.add(list);
            return;
        }else {
            int value = list.get(list.size() - 1);
            for (int i = value + 1; i <= n; i++) {
                List<Integer> temp = new ArrayList<>();
                for(int index = 0; index < list.size(); index++){
                    temp.add(list.get(index));
                }
                temp.add(i);
                generate(lists, temp, n, k);
            }
        }
    }
    //Accepted -----114ms
    // in generate function, copying list spends too much time
    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> lists = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            List<Integer> list = new ArrayList<>();
            list.add(i);
            generate(lists, list, n, k);
        }
        return  lists;
    }

    @Test
    public  void  test(){
        int n = 4;
        int k = 2;
        List<List<Integer>> result = combine(n, k);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + "  ");
            }
            System.out.println("  ");
        }
    }
}
