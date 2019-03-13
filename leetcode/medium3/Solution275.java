package algorithm.medium3;

import org.junit.Test;

/**
 * Created by youlu on 2018/9/14.
 */
public class Solution275 {
    public  int binarySearch(int[] citations ,int start, int end){
        if(start > end){
            return 0;
        }
        if(start == end){
            if(citations.length - start <= citations[start]){
                return citations.length - start;
            }else {
                return 0;
            }
        }

        int mid = start + (end - start) / 2;
        int startLength = citations.length - start;
        int midLength = citations.length - mid;

        if(startLength <= citations[start]){
            return  startLength;
        }else if(midLength <= citations[mid]){
            return binarySearch(citations, start, mid);
        }else {
            return  binarySearch(citations, mid+1, end);
        }
    }

    //Accepted ---11ms
    /*
        time complexity O(log(n))
     */
    public  int hIndex(int[] citations){
        if(citations.length == 0){
            return 0;
        }
        return binarySearch(citations, 0, citations.length-1);
    }


    @Test
    public  void  test(){
        int[] citations = {11,12};
        System.out.print(hIndex(citations));
    }
}
