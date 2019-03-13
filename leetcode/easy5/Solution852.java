package interview.easy5;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/5 0005.
 */
public class Solution852 {
    public  int binarySearch(int[] A, int start, int end){
        if(end - start == 2){
            if(A[end] > A[start] && A[end] > A[start + 1]){
                return  end;
            }
            if(A[start + 1] > A[start] && A[start + 1] > A[end]){
                return  start + 1;
            }

            if(A[start] > A[start+1] && A[start] >A[end]){
                return  start;
            }
        }
        int mid  = start + (end - start) / 2;
        if(A[mid] > A[mid - 1] && A[mid] > A[mid+1]){
            return  mid;
        }
        if(A[mid - 1] > A[mid] && A[mid] > A[mid+1]){
            return  binarySearch(A, start, mid);
        }
        if(A[mid - 1] < A[mid] && A[mid] < A[mid+1]){
            return  binarySearch(A, mid + 1, end);
        }
        return  -1;
    }

    //Accepted ----2ms
    public  int peakIndexInMountainArray(int[] A){
        return  binarySearch(A, 0, A.length - 1);
    }

    @Test
    public  void  test(){
        int[] A = {3,4,5,1};
        System.out.print(peakIndexInMountainArray(A));
    }
}
