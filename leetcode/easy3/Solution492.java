package interview.easy3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/13 0013.
 */
public class Solution492 {
    public  int[] constructRectangle(int area){
        int mid = (int)Math.sqrt(area);
        int[] result = new int[2];
        for (int i = mid; i <= area; i++){
            if(area % i == 0){
                if(i > (area / i)) {
                    result[0] = i;
                    result[1] = area / i;
                }else {
                    result[0] = area / i;
                    result[1] = i;
                }
                return  result;
            }
        }
        return  null;
    }

    @Test
    public  void  test(){
        int[] result = constructRectangle(6);
            System.out.print(result[0] + "  " + result[1]);

    }
}
