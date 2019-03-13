package interview.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/15 0015.
 */

//代码质量有点差
public class Solution118 {
    public List<List<Integer>> generate(int numRows){
        if(numRows == 0){
            List<List<Integer>> ll = new ArrayList<>();
            return ll;
        }
        if(numRows == 1){
            List<Integer> l1 = new ArrayList<>();
            l1.add(1);
            List<List<Integer>> ll  = new ArrayList<>();
            ll.add(l1);
            return ll;
        }
            List<List<Integer>> temp = generate(numRows - 1);
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for(int i = 1; i < numRows-1; i++){
                current.add(temp.get(numRows - 2).get(i- 1) + temp.get(numRows - 2).get(i));
            }
            current.add(1);
            temp.add(current);
            return temp;
    }

    @Test
    public void test(){
        List<List<Integer>> result = generate(5);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }
}
