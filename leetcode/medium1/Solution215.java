package interview.medium1;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 2018/6/21 0021.
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){return  -1;}
                else  if( o1 < o2){return  1;}
                else {
                    return 0;
                }
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, comparator);
        for(int i = 0 ; i < nums.length; i++){
            pq.add(nums[i]);
        }
        System.out.println("container size: " + pq.size());
        while (k > 1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
    @Test
    public  void  test(){
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.print(findKthLargest(nums, 2));
    }
}
