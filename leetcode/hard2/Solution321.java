package algorithm.hard2;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Solution321 {
    public  class Pair{
        int index;
        int value;
        Pair(int _index, int _value){
            index = _index;
            value = _value;
        }
    }

    public int[] help(int[] nums, int k){
        int[] result = new int[k];
        int index = 0, index1 = 0;
        while (index < k){
            int temp = index1;
            while ((temp + 1 < nums.length) && (nums[temp] <= nums[temp+1]) &&
                    ((nums.length - temp - 1) >= (k - index))){
                temp++;
            }
            result[index] = nums[temp];
            index++;
            temp++;
            index1 = temp;
        }
        return result;
    }

    //Time Limited Exceed
    public int[] maxNumber(int[] nums1, int[] nums2, int k){
        if(nums1.length == 0){
            return  help(nums2,k);
        }
        if(nums2.length == 0){
            return  help(nums1,k);
        }
        int[] result = new int[k];
        int index = 0, index1 = 0, index2 = 0;
        while (index < k){
            int temp1 = index1, temp2 = index2;


            while (true){
                int flag = 0;
                if((temp1 +1< nums1.length) && (nums1[temp1] < nums1[temp1+1]) &&
                        ((nums1.length - temp1 - 1 + nums2.length - temp2) >= (k - index))){
                    flag = 1;
                    temp1++;
                }
                if((temp2 + 1 < nums2.length) && (nums2[temp2] < nums2[temp2 + 1]) &&
                        ((nums2.length - temp2 - 1 + nums1.length - temp1) >= (k - index))){
                    flag = 1;
                    temp2++;
                }
                if(flag == 0){
                    break;
                }
            }

            if(temp1 == nums1.length){
                result[index] = nums2[temp2];
                temp2++;
            }else if(temp2 == nums2.length){
                result[index] = nums1[temp1];
                temp1++;
            }else {
                if (nums1[temp1] >= nums2[temp2]) {
                    result[index] = nums1[temp1];
                    temp1++;
                } else {
                    result[index] = nums2[temp2];
                    temp2++;
                }
            }
            index++;
            index1 = temp1;
            index2 = temp2;
        }
        return  result;
    }

    public  int compare(List<Integer> list1, List<Integer> list2){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < list1.size(); i++){
            sb1.append(list1.get(i));
        }
        for(int i = 0; i < list2.size(); i++){
            sb2.append(list2.get(i));
        }
        return sb1.toString().compareTo(sb2.toString());
    }
    public List<Integer> search2(int[] nums1, int[] nums2, int i, int j, int length){
        if(length == 0){
            return  new ArrayList<>();
        }
        int index = 0, index1 = i, index2 = j;

            int temp1 = index1 + 1, temp2 = index2 + 1;
            int max1Index = index1, max2Index = index2;
            while (temp1 < nums1.length) {
                if ((nums1.length - temp1 + nums2.length - index2) >= length) {
                    if (nums1[temp1] > nums1[index1] && nums1[temp1] > nums1[max1Index]) {
                        max1Index = temp1;
                    }
                    temp1++;
                } else {
                    break;
                }
            }

            while (temp2 < nums2.length) {
                if ((nums2.length - temp2 + nums1.length - index1) >= length) {
                    if (nums2[temp2] > nums2[index2] && nums2[temp2] > nums2[max2Index]) {
                        max2Index = temp2;
                    }
                    temp2++;
                } else {
                    break;
                }
            }
            if (index1 == nums1.length) {
                List<Integer> res1 = search2(nums1,nums2,i,max2Index+1, length-1);
                res1.add(0,nums2[max2Index]);
                return  res1;
            } else if (index2 == nums2.length) {
                List<Integer> res2 = search2(nums1,nums2,max1Index+1,j, length-1);
                res2.add(0,nums1[max1Index]);
                return  res2;
            } else {
                if (nums1[max1Index] > nums2[max2Index]) {
                    List<Integer> res2 = search2(nums1,nums2,max1Index+1,j, length-1);
                    res2.add(0,nums1[max1Index]);
                    return  res2;
                } else if(nums1[max1Index] < nums2[max2Index]) {
                    List<Integer> res1 = search2(nums1,nums2,i,max2Index+1, length-1);
                    res1.add(0,nums2[max2Index]);
                    return  res1;
                }else {
                    List<Integer> res2 = search2(nums1,nums2,max1Index+1,j, length-1);
                    List<Integer> res1 = search2(nums1,nums2,i,max2Index+1, length-1);
                    if(compare(res1,res2) >= 0){
                        res1.add(0,nums1[max1Index]);
                        return  res1;
                    }else {
                        res2.add(0,nums2[max2Index]);
                        return  res2;
                    }
                }
            }
    }


    //Time Limited Exceed
    public int[] maxNumber1(int[] nums1, int[] nums2, int k){
        if(nums1.length == 0){
            return  help(nums2,k);
        }
        if(nums2.length == 0){
            return  help(nums1,k);
        }
        int[] result = new int[k];
        int index = 0, index1 = 0, index2 = 0;

        while (index < k) {
            int temp1 = index1 + 1, temp2 = index2 + 1;
            int max1Index = index1, max2Index = index2;
            while (temp1 < nums1.length) {
                if ((nums1.length - temp1 + nums2.length - index2) >= (k - index)) {
                    if (nums1[temp1] > nums1[index1] && nums1[temp1] > nums1[max1Index]) {
                        max1Index = temp1;
                    }
                    temp1++;
                } else {
                    break;
                }
            }

            while (temp2 < nums2.length) {
                if ((nums2.length - temp2 + nums1.length - index1) >= (k - index)) {
                    if (nums2[temp2] > nums2[index2] && nums2[temp2] > nums2[max2Index]) {
                        max2Index = temp2;
                    }
                    temp2++;
                } else {
                    break;
                }
            }
            if (index1 == nums1.length) {
                result[index++] = nums2[max2Index++];
                index2 = max2Index;
            } else if (index2 == nums2.length) {
                result[index++] = nums1[max1Index++];
                index1 = max1Index;
            } else {
                if (nums1[max1Index] > nums2[max2Index]) {
                    result[index] = nums1[max1Index];
                    index++;
                    index1 = max1Index;
                    index1++;
                } else if(nums1[max1Index] < nums2[max2Index]) {
                    result[index] = nums2[max2Index];
                    index++;
                    index2 = max2Index;
                    index2++;
                }else {

                }
            }
        }
        return  result;
    }

    //Time Limited Exceed
    public int[] maxNumber2(int[] nums1, int[] nums2, int k){
        if(nums1.length == 0){
            return  help(nums2,k);
        }
        if(nums2.length == 0){
            return  help(nums1,k);
        }
        int[] result = new int[k];

        List<Integer>list = search2(nums1,nums2,0,0,k);
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return  result;
    }


    public  int[] nums;
    //Time Exceed
    public  void search3(int[] nums1, int[] nums2,int i, int j, int length){
        if(length == 0){
            return;
        }
        int  index1 = i, index2 = j;

        int temp1 = index1 + 1, temp2 = index2 + 1;
        int max1Index = index1, max2Index = index2;
        while (temp1 < nums1.length) {
            if ((nums1.length - temp1 + nums2.length - index2) >= length) {
                if (nums1[temp1] > nums1[index1] && nums1[temp1] > nums1[max1Index]) {
                    max1Index = temp1;
                }
                temp1++;
            } else {
                break;
            }
        }

        while (temp2 < nums2.length) {
            if ((nums2.length - temp2 + nums1.length - index1) >= length) {
                if (nums2[temp2] > nums2[index2] && nums2[temp2] > nums2[max2Index]) {
                    max2Index = temp2;
                }
                temp2++;
            } else {
                break;
            }
        }
        if (max1Index == nums1.length) {
            if(nums2[max2Index] >= nums[nums.length - length]){
                nums[nums.length - length] = nums2[max2Index];
                search3(nums1,nums2,i,max2Index+1, length-1);
            }
        } else if (max2Index == nums2.length) {
            if(nums1[max1Index] >= nums[nums.length - length]) {
                nums[nums.length - length] = nums1[max1Index];
                 search3(nums1, nums2, max1Index + 1, j, length - 1);
            }
        } else {
            if (nums1[max1Index] > nums2[max2Index]) {
                if(nums1[max1Index] >= nums[nums.length - length]) {
                    nums[nums.length - length] = nums1[max1Index];
                    search3(nums1, nums2, max1Index + 1, j, length - 1);
                }
            } else if(nums1[max1Index] < nums2[max2Index]) {
                if(nums2[max2Index] >= nums[nums.length - length]) {
                    nums[nums.length - length] = nums2[max2Index];
                    search3(nums1, nums2, i, max2Index + 1, length - 1);
                }
            }else {
                if(nums1[max1Index] >= nums[nums.length - length]){
                    nums[nums.length - length] = nums1[max1Index];
                    search3(nums1, nums2, max1Index + 1, j, length - 1);
                    search3(nums1,nums2,i,max2Index+1, length-1);
                }
            }
        }
    }

    public int[] maxNumber3(int[] nums1, int[] nums2, int k){
        if(nums1.length == 0){
            return  help(nums2,k);
        }
        if(nums2.length == 0){
            return  help(nums1,k);
        }
        nums = new int[k];

        search3(nums1,nums2,0,0,k);
        return  nums;
    }

    public  int[] maxArray(int[] nums, int k){
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++){
            if(queue.isEmpty()){
                queue.push(nums[i]);
            }else {
                while (!queue.isEmpty()){
                    int top = queue.peekLast();
                    if((top < nums[i]) && (queue.size() - 1 + nums.length - i >= k)){
                        queue.pollLast();
                    }else {
                        break;
                    }
                }
                queue.addLast(nums[i]);
            }
        }
        int[] result = new int[k];
        for(int i = 0; i < k;i++){
            int value = queue.pollFirst();
            result[i] = value;
        }
        return  result;
    }

    //num1 is bigger than nums2
    public  boolean compareTwoArray(int[] nums1,int i, int[] nums2, int j){
        if(nums1.length - i == 0){
            return  false;
        }
        if(nums2.length - j == 0){
            return  true;
        }

        int minLength = Math.min(nums1.length - i, nums2.length - j);
        for(int m = 0; m < minLength; m++){
            if(nums1[i+m] > nums2[j+m]){
                return true;
            }else if(nums1[i+m] < nums2[j+m]){
                return  false;
            }else {}
        }
        if(nums1.length - i == nums2.length - j){
            return  true;
        }else if(nums1.length - i > nums2.length - j){
            return  true;
        }else {
            return  false;
        }
    }

    public  int[] mergeArray(int[] nums1, int[] nums2, int k){
        int[] result = new int[k];
        int index = 0, index1 = 0, index2 = 0;
        while (index < k){
            if(compareTwoArray(nums1,index1,nums2,index2)){
                result[index++] = nums1[index1++];
            }else {
                result[index++] = nums2[index2++];
            }
        }
        return result;
    }

    //Accepted ---45m
    /*
        part idea from other
     */
    public int[] maxNumber4(int[] nums1, int[] nums2,int k){
        if(nums1.length == 0){
            return  help(nums2,k);
        }
        if(nums2.length == 0){
            return  help(nums1,k);
        }

        if(nums1.length + nums2.length == k){
            return  mergeArray(nums1,nums2,k);
        }

        int[] result = new int[k];
        for(int i = 0; i <= k; i++){
            if(i <= nums1.length && k - i <= nums2.length){
                int[] arr1 = maxArray(nums1,i);
                int[] arr2 = maxArray(nums2,k-i);
                int[] mergeArr = mergeArray(arr1,arr2,k);
                if(compareTwoArray(mergeArr,0,result,0)){
                    result = mergeArr;
                }
            }
        }

        return  result;
    }


    @Test
    public  void  test(){
       /* int[] nums1 = {3,4,6,5};
        int[] nums2 = {9,1,2,5,8,3};
        int k  = 5;*/

      /* int[] nums1 = {6,7};
       int[] nums2 = {6,0,4};
       int k = 5;*/

     /* int[] nums1 = {3,9};
      int[] nums2 = {8,9};
      int k = 3;*/

    /* int[] nums1 = {1,2};
     int[] nums2 = {};
     int k = 2;*/

    /* int[] nums1 = {6,5,4,6,3,7,5,6,4,5,6,4};
     int[] nums2 = {8,8,6,0};
     int k = 4;*/

   /* int[] nums1 = {8,6,9};
    int[] nums2 = {1,7,5};
    int k = 3;*/

    /*int[] nums1 = {8,9};
    int[] nums2 = {3,9};
    int k = 3;*/

    /*int[] nums1 = {4,6,9,1,0,6,3,1,5,2,8,3,8,8,4,7,2,0,7,1,9,9,0,1,5,9,3,9,
                3,9,7,3,0,8,1,0,9,1,6,8,8,4,4,5,7,5,2,8,2,7,7,7,4,8,5,0,9,6,9,2};
    int[] nums2 = {9,9,4,5,1,2,0,9,3,4,6,3,0,9,2,8,8,2,4,8,6,5,4,4,2,9,5,0,7,3,7,5,9,
                6,6,8,8,0,2,4,2,2,1,6,6,5,3,6,2,9,6,4,5,9,7,8,0,7,2,3};
    int k = 60;*/

   int[] nums1 = {8,9,7,3,5,9,1,0,8,5,3,0,9,2,7,4,8,9,8,1,0,2,0,2,7,2,3,5,4,7,4,1,4,0,1,4,2,1,3,1,5,3,9,3,9,0,1,7,0,6,1,8,5,6,6,5,0,4,7,2,9,2,2,7,6,2,9,2,3,5,7,4,7,0,1,8,3,6,6,3,0,8,5,3,0,3,7,3,0,9,8,5,1,9,5,0,7,9,6,8,5,1,9,6,5,8,2,3,7,1,0,1,4,3,4,4,2,4,0,8,4,6,5,5,7,6,9,0,8,4,6,1,6,7,2,0,1,1,8,2,6,4,0,5,5,2,6,1,6,4,7,1,7,2,2,9,8,9,1,0,5,5,9,7,7,8,8,3,3,8,9,3,7,5,3,6,1,0,1,0,9,3,7,8,4,0,3,5,8,1,0,5,7,2,8,4,9,5,6,8,1,1,8,7,3,2,3,4,8,7,9,9,7,8,5,2,2,7,1,9,1,5,5,1,3,5,9,0,5,2,9,4,2,8,7,3,9,4,7,4,8,7,5,0,9,9,7,9,3,8,0,9,5,3,0,0,3,0,4,9,0,9,1,6,0,2,0,5,2,2,6,0,0,9,6,3,4,1,2,0,8,3,6,6,9,0,2,1,6,9,2,4,9,0,8,3,9,0,5,4,5,4,6,1,2,5,2,2,1,7,3,8,1,1,6,8,8,1,8,5,6,1,3,0,1,3,5,6,5,0,6,4,2,8,6,0,3,7,9,5,5,9,8,0,4,8,6,0,8,6,6,1,6,2,7,1,0,2,2,4,0,0,0,4,6,5,5,4,0,1,5,8,3,2,0,9,7,6,2,6,9,9,9,7,1,4,6,2,8,2,5,3,4,5,2,4,4,4,7,2,2,5,3,2,8,2,2,4,9,8,0,9,8,7,6,2,6,7,5,4,7,5,1,0,5,7,8,7,7,8,9,7,0,3,7,7,4,7,2,0,4,1,1,9,1,7,5,0,5,6,6,1,0,6,9,4,2,8,0,5,1,9,8,4,0,3,1,2,4,2,1,
                8,9,5,9,6,5,3,1,8,9,0,9,8,3,0,9,4,1,1,6,0,5,9,0,8,3,7,8,5};
   int[] nums2 = {7,8,4,1,9,4,2,6,5,2,1,2,8,9,3,9,9,5,4,4,2,9,2,0,5,9,4,2,1,7,2,5,1,2,0,0,5,3,1,1,7,2,3,3,2,8,2,0,1,4,5,1,0,0,7,7,9,6,3,8,0,1,5,8,3,2,3,6,4,2,6,3,6,7,6,6,9,5,4,3,2,7,6,3,1,8,7,5,7,8,1,6,0,7,3,0,4,4,4,9,6,3,1,0,3,7,3,6,1,0,0,2,5,7,2,9,6,6,2,6,8,1,9,7,8,8,9,5,1,1,4,2,0,1,3,6,7,8,7,0,5,6,0,1,7,9,6,4,8,6,7,0,2,3,2,7,6,0,5,0,9,0,3,3,8,5,0,9,3,8,0,1,3,1,8,1,8,1,1,7,5,7,4,1,0,0,0,8,9,5,7,8,9,2,8,3,0,3,4,9,8,1,7,2,3,8,3,5,3,1,4,7,7,5,4,9,2,6,2,6,4,0,0,2,8,3,3,0,9,1,6,8,3,1,7,0,7,1,5,8,3,2,5,1,1,0,3,1,4,6,3,6,2,8,6,7,2,9,5,9,1,6,0,5,4,8,6,6,9,4,0,5,8,7,0,8,9,7,3,9,0,1,0,6,2,7,3,3,2,3,3,6,3,0,8,0,0,5,2,1,0,7,5,0,3,2,6,0,5,4,9,6,7,1,0,4,0,9,6,8,3,1,2,5,0,1,0,6,8,6,6,8,8,2,4,5,0,0,8,0,5,6,2,2,5,6,3,7,7,8,4,8,4,8,9,1,6,8,9,9,0,4,0,5,5,4,9,6,7,7,9,0,5,0,9,2,5,2,9,8,9,7,6,8,6,9,2,9,1,6,0,2,7,4,4,5,3,4,5,5,5,0,8,1,3,8,3,0,8,5,7,6,8,7,8,9,7,0,8,4,0,7,0,9,5,8,2,0,8,7,0,3,1,8,1,7,1,6,9,7,9,7,2,6,3,0,5,3,6,0,5,9,3,9,1,1,0,0,8,1,4,3,0,4,3,7,7,7,4,6,4,0,0,5,7,3,
                2,8,5,1,4,5,8,5,6,7,5,7,3,3,9,6,8,1,5,1,1,1,0,3};
   int k = 500;

        long startTime = System.currentTimeMillis();
        int[] result = maxNumber4(nums1,nums2,k);
//        int[] result1 = maxNumber2(nums1,nums2,k);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();
//        for(int i = 0; i < result1.length; i++){
//            System.out.print(result1[i] + " ");
//        }
//        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }
}
