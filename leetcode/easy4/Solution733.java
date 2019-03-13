package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/30 0030.
 */
public class Solution733 {
    public  void  transfer(int[][] imgage, int[][] flags, int sr, int sc){
        if(sr < 0 || sc < 0 ||sr >= imgage.length || sc >= imgage[0].length){
            return;
        }
        flags[sr][sc] = 1;
        if(sc + 1 < imgage[0].length && imgage[sr][sc] == imgage[sr][sc+1] && flags[sr][sc + 1] != 1){
            flags[sr][sc+1] = 1;
            transfer(imgage, flags, sr, sc+1);
        }

        if(sc - 1 >= 0 && imgage[sr][sc] == imgage[sr][sc - 1] && flags[sr][sc - 1] != 1){
            flags[sr][sc - 1] = 1;
            transfer(imgage, flags, sr, sc - 1);
        }

        if(sr - 1 >= 0 && imgage[sr][sc] == imgage[sr-1][sc] &&  flags[sr-1][sc] != 1){
            flags[sr-1][sc] = 1;
            transfer(imgage, flags, sr-1, sc);
        }

        if(sr + 1 < imgage.length && imgage[sr + 1][sc] == imgage[sr][sc] && flags[sr+1][sc] != 1){
            flags[sr+1][sc] = 1;
            transfer(imgage, flags, sr+1, sc);
        }
    }


    //Accepted ----13ms
    public  int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        int rowLength = image.length;
        int colLength = image[0].length;
        int[][] flags = new int[rowLength][colLength];
        transfer(image, flags, sr, sc);

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(flags[i][j] == 1){
                    flags[i][j] = newColor;
                }else {
                    flags[i][j] = image[i][j];
                }
            }
        }

        return  flags;
    }

    @Test
    public  void  test(){
        int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        int[][] result = floodFill(image, sr, sr, newColor);
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                System.out.print(result[i][j] + "  ");
            }
            System.out.println("  ");
        }
    }
}
