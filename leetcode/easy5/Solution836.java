package interview.easy5;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/4 0004.
 */
public class Solution836 {
    public  boolean coordinateOverclap(int x1, int x2, int x3, int x4){
        if((x3 > x1 && x3 < x2) || (x4 > x1 && x4 < x2)||
                (x1 > x3 && x1 < x4) || (x2 > x3 && x2 < x4)){
            return  true;
        }
        return  false;
    }


    //Accepted -----2ms
    public  boolean isRectangleOverlap(int[] rec1, int[] rec2){
        int rec1X1 = rec1[0], rec1X2 = rec1[2];
        int rec1Y1 = rec1[1], rec1Y2 = rec1[3];

        int rec2X1 = rec2[0], rec2X2 = rec2[2];
        int rec2Y1 = rec2[1], rec2Y2 = rec2[3];

        /*boolean b1 = coordinateOverclap(rec1X1, rec1X2, rec2X1, rec2X2);
        boolean b2 =  coordinateOverclap(rec1Y1, rec1Y2, rec2Y1, rec2Y2);
        System.out.print("b1 : " + b1 + " b2 : " + b2);*/

        if(coordinateOverclap(rec1X1, rec1X2, rec2X1, rec2X2) &&
                coordinateOverclap(rec1Y1, rec1Y2, rec2Y1, rec2Y2)){
            return  true;
        }else {
            return  false;
        }
    }

    @Test
    public  void  test(){
        int[] rec1 = {2,17,6,20};
        int[] rec2 = {3,8,6,20};
        System.out.print(isRectangleOverlap(rec1, rec2));
        //System.out.print(coordinateOverclap(17,20,8,20));
    }
}
