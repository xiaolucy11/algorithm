package algorithm.hard2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution410 {
    public  long min;

    public  void search(int[] nums, int m, int[][] matrix,
                         int curIndex,long curMax, int curSplits,long sum){
        if(curIndex == nums.length || curMax > min || curSplits >= m){
            return;
        }

        if(curSplits == m - 1){
            curMax = Math.max(curMax, matrix[curIndex][nums.length-1]);
            min = Math.min(min,curMax);
            return;
        }

        if(curSplits + nums.length - curIndex < m){
            return;
        }

        search(nums,m,matrix,curIndex+1,curMax,curSplits, sum + nums[curIndex]);
        curMax = Math.max(curMax, sum + nums[curIndex]);
        search(nums,m,matrix,curIndex+1,curMax,curSplits+1,0);
    }


    //Time Limited Exceed
    public  int splitArray(int[] nums, int m){
        min = Long.MAX_VALUE;
        map = new HashMap<>();
        int[][] matrix = new int[nums.length][nums.length];
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            arr[i] += arr[i-1] + nums[i];
            matrix[i][i] = nums[i];
            for(int j = i - 1; j >= 0; j-- ){
                matrix[j][i] = arr[i] - arr[j] + nums[j];
            }
        }

        if(m == 0){
            return  matrix[0][nums.length-1];
        }

        search(nums,m,matrix,0,0,0,0);
        return  (int) min;
    }

    public  class  Pair{
        int index;
        int num;
        Pair(int _index, int _num){
            index = _index;
            num = _num;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return index == pair.index &&
                    num == pair.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, num);
        }
    }

    public  Map<Pair, Integer> map ;
    public  int maxInArray(int[] nums, int index){
        int max = 0;
        for(int i = index; i < nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        return max;
    }

    public  int search1(int[] nums, int m, int index,int[][] matrix){
        if(m == 1){
            map.put(new Pair(index,1),matrix[index][nums.length-1]);
            return matrix[index][nums.length-1];
        }
        if(nums.length - index == m){
            return maxInArray(nums,index);
        }

        int max = matrix[0][nums.length-1];
        for(int i = index; i < nums.length; i++){
            if(nums.length - i - 1 >= m-1){
                int value1 = matrix[index][i];
                int value2 = 0;
                if(map.containsKey(new Pair(i+1,m-1))){
                    value2 = map.get(new Pair(i+1, m-1));
                }else {
                    value2 = search1(nums,m-1,i+1,matrix);
                }
                max = Math.min(max, Math.max(value1,value2));
            }
        }
        map.put(new Pair(index,m),max);
        return  max;
    }

    //Accepted ----1158ms
    /*
        memorization search
     */
    public  int splitArray1(int[] nums, int m){
        min = Long.MAX_VALUE;
        map = new HashMap<>();
        int[][] matrix = new int[nums.length][nums.length];
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        matrix[0][0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            arr[i] += arr[i-1] + nums[i];
            matrix[i][i] = nums[i];
            for(int j = i - 1; j >= 0; j-- ){
                matrix[j][i] = arr[i] - arr[j] + nums[j];
            }
        }

        if(m == 1){
            return  matrix[0][nums.length-1];
        }

       /* for(int i = 0; i < nums.length;i++){
            if(nums.length - i - 1 >= m-1){
                int value1 = matrix[0][i];
                int value2 = search1(nums,m-1,i+1,matrix);
                min = Math.min(min,Math.max(value1,value2));
            }else {
                break;
            }
        }*/
        return search1(nums,m,0,matrix);
    }

    @Test
    public void  test(){
        int[] nums = {7,2,5,10,8};
//       int[] nums = {1,2147483647};

        int m = 2;
        /*int[] nums = {5334,6299,4199,9663,8945,3566,9509,3124,6026,6250,7475,5420,9201,
                9501,38,5897,4411,6638,9845,161,9563,8854,3731,5564,5331,4294,3275,1972,1521,
                2377,3701,6462,6778,187,9778,758,550,7510,6225,8691,3666,4622,9722,8011,7247,
                575,5431,4777,4032,8682,5888,8047,3562,9462,6501,7855,505,4675,6973,493,1374,
                3227,1244,7364,2298,3244,8627,5102,6375,8653,1820,3857,7195,7830,4461,7821,5037,
                2918,4279,2791,1500,9858,6915,5156,970,1471,5296,1688,578,7266,4182,1430,4985,5730,7941,3880,607,8776,1348,2974,1094,6733,5177,4975,5421,8190,8255,9112,8651,2797,335,8677,3754,893,1818,8479,5875,1695,8295,7993,7037,8546,7906,4102,7279,1407,2462,4425,2148,2925,3903,5447,5893,3534,3663,8307,8679,8474,1202,3474,2961,1149,7451,4279,7875,5692,6186,8109,7763,7798,2250,2969,7974,9781,7741,4914,5446,1861,8914,2544,5683,8952,6745,4870,1848,7887,6448,7873,128,3281,794,1965,7036,8094,1211,9450,6981,4244,2418,8610,8681,2402,2904,7712,3252,5029,3004,5526,6965,8866,2764,600,631,9075,2631,3411,2737,2328,652,494,6556,9391,4517,8934,8892,4561,9331,1386,4636,9627,5435,9272,110,413,9706,5470,5008,1706,7045,9648,7505,6968,7509,3120,7869,6776,6434,7994,5441,288,492,1617,3274,7019,5575,6664,6056,7069,1996,9581,3103,9266,2554,7471,4251,4320,4749,649,2617,3018,4332,415,2243,1924,69,5902,3602,2925,6542,345,4657,9034,8977,6799,8397,1187,3678,4921,6518,851,6941,6920,259,4503,2637,7438,3893,5042,8552,6661,5043,9555,9095,4123,142,1446,8047,6234,1199,8848,5656,1910,3430,2843,8043,9156,7838,2332,9634,2410,2958,3431,4270,1420,4227,7712,6648,1607,1575,3741,1493,7770,3018,5398,6215,8601,6244,7551,2587,2254,3607,1147,5184,9173,8680,8610,1597,
                1763,7914,3441,7006,1318,7044,7267,8206,9684,4814,9748,4497,2239};
        int m = 9;*/
        /*int[] nums = {2,3,1,2,4,3};
        int m = 5;*/

        System.out.println("lenght : " + nums.length);
        long startTime = System.currentTimeMillis();
        int result = splitArray1(nums,m);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
