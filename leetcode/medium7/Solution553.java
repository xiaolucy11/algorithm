package algorithm.medium7;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlu on 2018/10/19.
 */
public class Solution553 {
    public float max(int[] nums, float[][] maxMatrix, float[][] minMatrix, int row, int col){
        if(row == col){
            maxMatrix[row][col] = (float)nums[row];
            return  maxMatrix[row][col];
        }

        if(col - row == 1){
            maxMatrix[row][col] = (float)(nums[row] / nums[col]);
            return maxMatrix[row][col];
        }


        float maxValue = 0;
        if(maxMatrix[row][col-1] == 0) {
             maxValue = max(nums, maxMatrix, minMatrix, row, col - 1);
        }else {
            maxValue = maxMatrix[row][col-1];
        }

        float minValue = 0;
        if(minMatrix[row+1][col] == 0) {
            minValue = min(nums, maxMatrix, minMatrix, row + 1, col);
        }else {
            minValue = minMatrix[row+1][col];
        }

        maxMatrix[row][col] = Math.max((float)(maxValue / nums[col]), (float)(nums[row] /  minValue));
        return  maxMatrix[row][col];
    }

    public  float min(int[] nums, float[][] maxMatrix, float[][] minMatrix, int row, int col){
        if(row == col){
            minMatrix[row][col] = (float)nums[row];
            return  minMatrix[row][col];
        }
        if(col - row == 1){
            minMatrix[row][col] =(float)(nums[row] / nums[col]);
            return  minMatrix[row][col];
        }

        float minValue = minMatrix[row][col - 1];
        if(minMatrix[row][col-1] == 0) {
            minValue = min(nums, maxMatrix, minMatrix, row, col - 1);
        }else {
            minValue = minMatrix[row][col-1];
        }

        float maxValue = 0;
        if(maxMatrix[row+1][col] == 0) {
             maxValue = max(nums, maxMatrix, minMatrix, row + 1, col);
        }else {
            maxValue = maxMatrix[row+1][col];
        }

        minMatrix[row][col] = Math.min((float)(minValue / nums[col]), (float)(nums[row] / maxValue));
        return  minMatrix[row][col];
    }

    public void addParenthes(float[][] maxMatrix, float[][] minMatrix,int[] nums, int row, int col, float result,
                             Map<Integer, Integer> map,int flag ){
        if(col - row == 1){
            if(!map.containsKey(row)) {
                map.put(row, col);
            }
            return;
        }
            float maxValue = maxMatrix[row][col-1];
            float minValue = minMatrix[row+1][col];
            float value1 = (float)(nums[row] / minValue);
            float value2 = (float)(maxValue / nums[col]);

            if(value1 == result){
                map.put(row+1, col);
                addParenthes(maxMatrix, minMatrix, nums, row+1, col, minValue, map,1);
            }else {
                addParenthes(maxMatrix, minMatrix, nums, row, col-1, maxValue,map, 0);
            }
    }

    //Accepted -----9ms
    /*
        dp algorithm
     */
    public  String optimalDivision(int[] nums){
        if(nums.length == 0 ){
            return "";
        }else if(nums.length == 1){
            return Integer.toString(nums[0]);
        }else if(nums.length == 2){
            return Integer.toString(nums[0]) + "/" + Integer.toString(nums[1]);
        }

        int length = nums.length;
        float[][] maxMatrix = new float[length][length];
        float[][] minMatrix = new float[length][length];
        float result = max(nums, maxMatrix, minMatrix, 0, length-1);
        Map<Integer, Integer> map = new HashMap<>();

        addParenthes(maxMatrix, minMatrix, nums, 0, length-1, result, map,0);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(map.containsKey(i)){
                stringBuilder.append('(');
            }
            stringBuilder.append(nums[i]);
            for(Integer key : map.keySet()){
                if(i == map.get(key)){
                    stringBuilder.append(')');
                }
            }
            if(i != length-1){
                stringBuilder.append('/');
            }
        }
        return  stringBuilder.toString();

    }


    /*
        code from other
     */
    public String optimalDivision1(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if(nums.length == 1) sb.append(nums[0]);
        else if(nums.length == 2) sb.append(nums[0]+"/"+nums[1]);
        else if(nums.length > 2){
            sb.append(nums[0]);
            sb.append("/(");
            for(int i=1; i<nums.length-1;i++){
                sb.append(nums[i]+"/");
            }
            sb.append(nums[nums.length-1]+")");
        }

        return sb.toString();
    }

    @Test
    public  void  test(){
        int[] nums = {1000,100,10,2};

        long startTime = System.currentTimeMillis();
       String resullt = optimalDivision(nums);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + resullt);
        System.out.println("running time : " + (endTime - startTime));
    }
}
