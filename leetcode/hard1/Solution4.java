package algorithm.hard1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by youlu on 2018/12/1.
 */
public class Solution4 {

    public  double help(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2){
      if((end1 == start1) && (end2 == start2)){
          return (nums1[start1] + nums2[start2]) / 2.0;
      }

      if((end1 == start1) || (end2 == start2)){
          List<Integer> list = new ArrayList<>();
          for(int i = start1; i <= end1; i++){
              list.add(nums1[i]);
          }
          for(int j = start2; j <= end2; j++){
              list.add(nums2[j]);
          }
          Collections.sort(list);
          if(list.size() % 2 == 1){
              return  list.get(list.size() / 2);
          }else {
              return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.0;
          }
      }

      int totalLength = end1 - start1 + 1 + end2 + start2 + 1;
      int mid1 = start1 + (end1 - start1) / 2;
      int mid2 = start2 + (end2 - start2) / 2;
        if(nums1[mid1] == nums2[mid2]){
            if(totalLength % 2 == 1) {
                return nums1[mid1];
            }else {
                int min = Math.min(nums1[mid1+1], nums2[mid2 + 1]);
                if(min != nums1[mid1]) {
                    return (min + nums1[mid1]) / 2.0;
                }else {
                    return  nums1[mid1];
                }
            }
        }else if(nums1[mid1] > nums2[mid2]){
            int half1 = (end1 - start1 + 1) / 2;
            while (half1 > 0){
                if(nums1[end1] >= nums2[end2]){
                    end1--;
                }else {
                    end2--;
                }
                half1--;
            }
            return help(nums1,start1,end1,nums2, mid2, end2);
        }else {
            int half2 = (end2 - start2 + 1) / 2;
            while (half2 > 0){
                if(nums1[end1] >= nums2[end2]){
                    end1--;
                }else {
                    end2--;
                }
                half2--;
            }
            return help(nums1,mid1, end1, nums2, start2,end2);
        }
    }

    public  double arrayMedian(int[] nums, int start,int end){
        int len = end - start + 1;
        int mid = start + (end - start) / 2;
        if(len % 2 == 1) {
            return  nums[mid];
        }else {
            return (nums[mid] + nums[mid + 1]) / 2.0;
        }
    }

    public  double oneArrayMedian(int[] nums, int start,int end){
        int mid = start + (end - start) / 2;
        return  nums[mid];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        if(nums1.length == 0){
           return  arrayMedian(nums2,0, nums2.length - 1);
        }

        if(nums2.length == 0){
           return  arrayMedian(nums1, 0, nums1.length - 1);
        }

        return  help(nums1,0, nums1.length - 1, nums2, 0, nums2.length - 1);
    }



    @Test
    public  void  test(){
      /* int[] nums1 = {1,3};
        int[] nums2 = {2};*/

     int[] nums1 = {1,2};
        int[] nums2 = {3,4};

     /*   int[] nums1 = {1,2};
        int[] nums2 = {-1,3};*/

   /* int[] nums1 = {1,2};
        int[] nums2 = {1,1};*/
    /* int[] nums1 = {3,4};
        int[] nums2 = {1,2,5};*/


        long startTime = System.currentTimeMillis();
        double result = findMedianSortedArrays(nums1, nums2);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
