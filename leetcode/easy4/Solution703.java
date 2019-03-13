package interview.easy4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2018/7/28 0028.
 */
public class Solution703 {

    //Accepted ----800ms, not good solution
    //another solution  using priority queue
    public List<Integer> list = new ArrayList<>();
    public  int Kth ;

    public  Solution703(int k, int[] nums){
        for (int i = 0; i < nums.length; i++){
            list.add(nums[i]);
        }
        Collections.sort(list, Collections.reverseOrder());
        Kth = k;
    }

    /*public int[] sorted(){
        int[] arr = new int[list.size()];
        int index = 0;
        for(int i = 0; i < list.size(); i++){
            arr[index++] = list.get(i);
        }
        Arrays.s
    }*/

    public  int add(int val){
        list.add(val);
        Collections.sort(list, Collections.reverseOrder());
        return  list.get(Kth - 1);
    }
}
