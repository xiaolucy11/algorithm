package algorithm.medium3;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by youlu on 2018/9/13.
 */
public class Solution274 {
    //Accepted ----11ms
    /*
        O(n * long(n))
     */
    public  int hIndex(int[] citations){
        if(citations.length == 0){
            return 0;
        }
        int length = citations.length;
        Arrays.sort(citations);

        int index = 0;
        while (index < length){
            if(citations[index] == 0){
                index++;
                continue;
            }
            int rightCount = length - index;
            if( rightCount <= citations[index ] ){
                return rightCount;
            }
            index++;
        }
        return length - index ;
    }

    //Accepted -------4ms
    /*
        part reference from other
     */
    public  int hIndex1(int[] citations){
        if(citations.length == 0){
            return 0;
        }
        int length = citations.length;
        int[] array = new int[length+1];
        int count = 0;
        for(int i = 0; i < length; i++){
            if(citations[i] > length){
                count++;
            }else{
                array[citations[i]] += 1;
            }
        }

        int sum = 0;
        for(int i = length; i >= 0; i--){
            sum += array[i];
            if(sum + count >= i){
                return i;
            }
        }
        return 0;
    }



    @Test
    public  void  test(){
        int[] citations = {3,0,1,6,5};
        System.out.print(hIndex1(citations));
    }
}
