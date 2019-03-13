package interview.easy1;

import java.util.Vector;

/**
 * Created by Administrator on 2018/6/29 0029.
 */
public class Solution303 {
    private Vector<Integer> vector;
    public Solution303(int[] nums){
        if(nums == null){return; }
        vector.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            vector.add(vector.get(i - 1) + nums[i]);
        }

    }
    public  int sumRange(int i, int j){
        if(i == 0){return vector.get(j);}
        if(i > j || j < 0 || i > vector.size() || i < 0){
            return 0;
        }
        return vector.get(j) - vector.get(i - 1);
    }
}
