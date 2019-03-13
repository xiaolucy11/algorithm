package algorithm.medium10;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by youlu on 2018/11/29.
 */
public class Solution825 {

    public  int help(int[] ages, int index){
        int left = index - 1, right = index + 1;
        int count = 0;

        while (left >= 0){
            if(ages[left] > ages[index] / 2 + 7){
                count++;
                left--;
            }else {
                break;
            }
        }

        while (right < ages.length){
            if(ages[right] == ages[index]){
                count++;
                right++;
            }else {
                break;
            }
        }
        return  count;
    }

    //Accepted ----385ms
    /*
        not effecient
     */
    public  int numFriendRequests(int[] ages){
        int sum = 0;
        Arrays.sort(ages);

        for(int i=  0; i < ages.length; i++){
            if(ages[i] > 14) {
                sum += help(ages, i);
            }
        }

        return  sum;
    }


    /*
        dp algorithm
        code from other
     */
    public  int numFriendRequests1(int[] ages){
        // 构建映射数组
        int[] nums = new int[121];
        int[] sums = new int[121];
        int res = 0;
        //计算各个年龄的人数
        for(int i=0; i<ages.length; ++i){
            nums[ages[i]]++;
        }
        //计算年龄小于等于下标人数
        for(int i=1; i<121;++i){
            sums[i] = sums[i-1] + nums[i];
        }
        //低于15没朋友
        for(int i=15; i<121; ++i){
            if(nums[i]==0){
                continue;
            }
            int count = 0;
            count = sums[i] - sums[i/2+7];
            count--; //不包含自己
            res += count*nums[i];
        }
        return res;


    }


    @Test
    public  void test(){
//        int[] ages = {16,16};
//        int[] ages = {16,17,18};
//        int[] ages = {20,30,100,110,120};
        int[] ages = {73,106,39,6,26,15,30,100,71,35,46,112,6,60,110};

        long startTime = System.currentTimeMillis();
        int result = numFriendRequests(ages);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
