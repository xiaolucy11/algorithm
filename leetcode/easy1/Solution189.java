package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/19 0019.
 */
public class Solution189 {

    //solution10
    public  void rotate1(int[] nums, int k){
        int lenght = nums.length;
        int temp = 0;
        while(k > 0 ){
            temp = nums[lenght - 1];
            for(int i = lenght - 2; i >= 0; i--){
                nums[i+1] = nums[i];
            }
            nums[0] = temp;
            k--;
        }
    }
    @Test
    public  void  test1(){
        int[] nums  = new int[]{1,2,3,4,5,6,7};
        rotate1(nums,3);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + "  ");
        }
    }

    //solution2
    public  void rotate(int[] nums, int start , int end){
        if(start == end) {return ;}
        if(end - start == 1){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            return  ;
        }
        int mid = start + (end - start + 1) / 2;
        rotate(nums, start,mid);
        rotate(nums, mid + 1, end);
        int step = end - mid;
        while (step > 0){
            int temp = nums[end];
            for(int i = end - 1; i >= start; i--){
                nums[i+1] = nums[i];
            }
            nums[start] = temp;
            step--;
        }

    }
    public  void  rotate2(int[] nums, int k ){
        int rotatePosition = nums.length - 1- k;
        while (k > nums.length){
            k = k / nums.length;
        }
        rotate(nums,0, rotatePosition);
        rotate(nums, rotatePosition+1, nums.length - 1);
        rotate(nums, 0, nums.length-1);
    }

    @Test
    public  void  test2(){
        int[] nums = new int[]{1,2,3,4,5,6,7};
        //int[] nums = new int[]{-1,-100,3, 99};
        rotate2(nums, 3);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + "   ");
        }
    }
    //solutin 3
    public void  rotate3(int[] nums, int k){
        int[] temp = new int[k];
        int lenght = nums.length;
        for(int i = lenght  - k, index = 0; i < lenght; i++){
            temp[index++] = nums[i];
        }
        for(int i = lenght - k - 1, j = lenght - 1; i >= 0; i--){
            nums[j] = nums[i];
            j--;
        }
        for(int i = 0; i < k; i++){
            nums[i] = temp[i];
        }
    }

    @Test
    public  void  test3(){
        int[] nums = new  int[]{-1, -100, 3, 99};
        rotate3(nums, 2);
        for(int i = 0; i < nums.length;i++){
            System.out.print(nums[i] + "   ");
        }
    }
}
