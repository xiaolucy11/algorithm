package algorithm.medium6;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/10/7.
 */
public class Solution452 {
    public  class  Point{
        int start;
        int end;
        Point(int _start, int _end){
            start = _start;
            end = _end;
        }
    }


    //Accepted ----59ms
    /*
        time complexity O(nlong(n))
     */
    public  int findMinArrowShots(int[][] points){
        if(points.length == 0){
            return 0;
        }
        List<Point> pointList = new ArrayList<>();
        for(int i = 0; i < points.length; i++){
            Point p = new Point(points[i][0], points[i][1]);
            pointList.add(p);
        }

        Collections.sort(pointList, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.start > o2.start){
                    return  1;
                }else if(o1.start < o2.start){
                    return  -1;
                }else {
                    if(o1.end > o2.end){
                        return  1;
                    }else if(o1.end < o2.end){
                        return  -1;
                    }else {
                        return 0;
                    }
                }
            }
        });

        int overLapStart = pointList.get(0).start;
        int overLapEnd = pointList.get(0).end;
        int count = 0;
        for(int i = 1; i < pointList.size(); i++){
            int pointStart = pointList.get(i).start;
            int pointEnd = pointList.get(i).end;

            if(pointStart <= overLapEnd){
                overLapStart = pointStart;
                if(pointEnd < overLapEnd){
                    overLapEnd = pointEnd;
                }
            }else {
                count ++;
                overLapStart = pointStart;
                overLapEnd = pointEnd;
            }
        }

        return  count+1;
    }

    /*

     */
    public  int findMinArrowShots1(int[][] points){
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }

    @Test
    public  void  test(){
        int[][] points = {{10,16}, {2,8},{1,6}, {7,12}};
        int result = findMinArrowShots(points);
        System.out.println("result :  " + result);
    }
}
