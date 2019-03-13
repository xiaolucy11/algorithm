package algorithm.medium7;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/10/23.
 */
public class Solution611 {

    //Accepted -----140ms
    /*
        time complexity O(n^3)
     */
    public  int triangleNumber(int[] nums){
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                for(int k = j + 1; k < nums.length;k++){
                    if(sum > nums[k]){
                        count++;
                    }else {
                        break;
                    }
                }
            }
        }

        return count;
    }

    public  int triangleNumber1(int[] nums){
        int count = 0;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2){
                    return 1;
                }else if(o1 > o2){
                    return  -1;
                }else {
                    return 0;
                }
            }
        });
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                map.put(nums[i] + nums[j], map.getOrDefault(nums[i] + nums[j], 0)+1 );
            }
        }

        int[] arr = new int[nums[nums.length-1] + nums[nums.length -2] +1];
        int sum = 0;
        for(Integer key : map.keySet() ){
            sum += map.get(key);
            arr[key] = sum;
        }

        int index = 0;
        while (index < arr.length){
            int temp = index+1;
            while ((temp < arr.length) && (arr[temp] == 0)){
                arr[temp++] = arr[index];
            }
            index = temp;
        }
        for(int r = 0; r < nums.length;r++){
            count += arr[nums[r]];
        }

        return  count;
    }

    //Accepted ---380ms
    public  int triangleNumber2(int[] nums){
        int count = 0;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            for(int j = 0;j < i; j++){
                list.add(nums[i] + nums[j]);
            }
        }


        for(int i = 0; i < nums.length; i++){
            int totalNumber = i * (i-1) / 2;
            for(int index = 0; index < totalNumber; index++){
                if(list.get(index) > nums[i]){
                    count++;
                }
            }
        }

        return count;
    }

    /*
        code from other
        using two direction searching, to decreas time complexity
     */
    public int triangleNumber3(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0; int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    ans += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }


    @Test
    public  void  test(){
        int[] nums = {2,2,3,4};

        long startTime = System.currentTimeMillis();
        int result = triangleNumber2(nums);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }

}
