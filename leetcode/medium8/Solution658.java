package algorithm.medium8;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by youlu on 2018/10/28.
 */
public class Solution658 {

    public  int find1(int[] arr, int start, int end,int value){
        if(start == end){
            return  start;
        }
        if(end - start == 1){
            return start;
        }

        int mid = start + (end - start) / 2;
        if(arr[mid] == value){
            return  value;
        }else if(arr[mid] > value){
            return  find1(arr, start, mid - 1, value);
        }else {
            return  find1(arr, mid + 1,end, value);
        }
    }

    /*
        binary search
     */
    public  int find2(int[] arr, int value){
        int left = 0, right = arr.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == value){
                return  mid;
            }else if(arr[mid] > value){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return  left;
    }

    public  int find(int[] arr, int value){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == value){
                return  i;
            }
            if (arr[i] > value){
                return i-1;
            }
        }

        return  -1;
    }



    //Accepted -----25ms
    /*
        it can be optimized using binary search
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x){
        if(x <= arr[0]){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < k; i++){
                list.add(arr[i]);
            }
            return  list;
        }
        if(x >= arr[arr.length - 1]){
            List<Integer> list = new ArrayList<>();
            for(int i = arr.length - 1; i >= arr.length - k; i--){
                list.add(arr[i]);
            }
            Collections.reverse(list);
            return  list;
        }

        int index = find(arr, x);
        int left = -1, right = arr.length;
        List<Integer> result = new ArrayList<>();
        if(arr[index] == x){
            result.add(x);
            left = index - 1;
            right = index + 1;
            if(result.size() == k){
                return result;
            }
        }else {
            left = index;
            right = index + 1;
        }
        while ((left >= 0) && (right < arr.length)){
            if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                result.add(arr[left]);
                if(result.size() == k){
                    Collections.sort(result);
                    return  result;
                }
                left--;
            }else {
                result.add(arr[right]);
                if(result.size() == k){
                    Collections.sort(result);
                    return  result;
                }
                right++;
            }
        }
        while (left >= 0){
            result.add(arr[left]);
            if(result.size() == k){
                Collections.sort(result);
                return  result;
            }
            left--;
        }
        while (right < arr.length){
            result.add(arr[right]);
            if(result.size() == k){
                Collections.sort(result);
                return  result;
            }
            right++;
        }
        return  result;
    }


    @Test
    public  void  test(){
       int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;

      /* int[] arr = {1,2,5,8,12};
        int k = 4;
        int x = 3;*/

        long startTime = System.currentTimeMillis();
        List<Integer> list = findClosestElements(arr,k,x);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + "  ");
        }
        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }
}
