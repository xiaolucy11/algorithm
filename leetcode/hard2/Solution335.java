package algorithm.hard2;

import org.junit.Test;

public class Solution335 {

    //Wrong Solution
    public  boolean isSelfCrossing(int[] x){
        int maxY = 0, minY = 0, maxX = 0, minX = 0;
        int index = 0;
        int curX = 0, curY = 0;


        while (index < x.length){
            if(index + 3 >= x.length){
                break;
            }else {
                int count = x[index];
                while (count > 0){
                    curY++;
                    if((curX >= minX && curX <= maxX) &&
                            (curY >= minY && curY <= maxY)){
                        return true;
                    }else {
                        maxY = Math.max(maxY, curY);
                        count--;
                    }
                }
                maxY = Math.max(maxY, curY);
                count = x[index+1];
                while (count > 0){
                    curX--;
                    if((curX >= minX && curX <= maxX) &&
                            (curY >= minY && curY <= maxY)){
                        return true;
                    }else {
                        minX = Math.min(minX,curX);
                        count--;
                    }
                }

                minX = Math.min(minX,curX);
                count = x[index+2];
                while (count > 0){
                    curY--;
                    if((curX >= minX && curX <= maxX) &&
                            (curY >= minY && curY <= maxY)){
                        return true;
                    }else {
                        minY = Math.min(minY,curY);
                        count--;
                    }
                }

                minY = Math.min(minY,curY);
                count = x[index+3];
                while (count > 0){
                    curX++;
                    if((curX >= minX && curX <= maxX) &&
                            (curY >= minY && curY <= maxY)){
                        return true;
                    }else {
                        maxX = Math.max(curX,maxX);
                        count--;
                    }
                }

                maxX = Math.max(curX,maxX);
                index += 4;
            }
        }

        if(index < x.length){
            int count = x[index];
            while (count > 0){
                curY++;
                if((curX >= minX && curX <= maxX) &&
                        (curY >= minY && curY <= maxY)){
                    return true;
                }else {
                    maxY = Math.max(maxY, curY);
                    count--;
                }
            }
            maxY = Math.max(maxY, curY);
            index++;
        }

        if(index < x.length){
            int count = x[index];
            while (count > 0){
                curX--;
                if((curX >= minX && curX <= maxX) &&
                        (curY >= minY && curY <= maxY)){
                    return true;
                }else {
                    minX = Math.min(minX,curX);
                    count--;
                }
            }
            minX = Math.min(minX,curX);
            index++;
        }

        if(index < x.length){
            int count = x[index];
            while (count > 0){
                curY--;
                if((curX >= minX && curX <= maxX) &&
                        (curY >= minY && curY <= maxY)){
                    return true;
                }else {
                    minY = Math.min(minY,curY);
                    count--;
                }
            }
        }

        return  false;
    }

    @Test
    public  void  test(){
//        int[] x = {2,1,1,2};
        int[] x = {1,2,3,4};
//        int[] x = {1,1,1,1};

        boolean b = isSelfCrossing(x);

        System.out.println(b);
    }
}
