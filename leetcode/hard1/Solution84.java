package algorithm.hard1;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/12/11.
 */
public class Solution84 {

    //Accepted
    /*
        brute solution
        time complexity O(n^2)
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int maxArea = heights[0];

        int min = 0;
        for (int i = 0; i < heights.length; i++) {
            min = heights[i];
            maxArea = Math.max(heights[i], maxArea);
            for (int j = i + 1; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                maxArea = Math.max(maxArea, (j - i + 1) * min);
            }
        }

        return maxArea;
    }

    //Wrong solution
    public int largestRectangleArea1(int[] heights) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int maxValue = -1, minValue = Integer.MAX_VALUE;
        for (int i = 0; i < heights.length; i++) {
            if (!map.containsKey(heights[i])) {
                Set<Integer> set1 = new HashSet<>();
                set1.add(i);
                map.put(heights[i], set1);
            } else {
                Set<Integer> set2 = new HashSet<>();
                set2.add(i);
                map.put(heights[i], set2);
            }

            if (heights[i] > maxValue) {
                maxValue = heights[i];
            }
            if (heights[i] < minValue) {
                minValue = heights[i];
            }
        }

        int maxHeight = maxValue;

        return 0;
    }

    public int largestRectangleArea2(int[] height){
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    @Test
    public  void test(){
//        int[] heights = {2,1,5,6,2,3};
        int[] heights = {0,9};

        long startTime = System.currentTimeMillis();
        int result = largestRectangleArea(heights);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
