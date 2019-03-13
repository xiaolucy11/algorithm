package interview.easy3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/19 0019.
 */
public class Solution566 {
    public  int[][] matrixReshape(int[][] nums, int r, int c){
        int originRow = nums.length;
        int originCol = nums[0].length;
        if(originCol * originRow != r * c){
            return  nums;
        }

        int[] array = new int[originCol * originRow];
        int index = 0;
        for (int i = 0; i < originRow; i++){
            for(int j = 0; j < originCol; j++){
                array[index++] = nums[i][j];
            }
        }

        int[][] result = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                result[i][j] = array[i*c + j];
            }
        }
        return result;
    }


    @Test
    public  void  test(){
        int[][] nums = {{1,2}, {3,4}};
        int[][] result = matrixReshape(nums, 1,4);
        for(int i = 0; i < 1; i++){
            for(int j = 0;j < 4; j++){
                System.out.print(result[i][j] + "  ");
            }
            System.out.println(" ");
        }
    }
}
