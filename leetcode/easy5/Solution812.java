package interview.easy5;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/3 0003.
 */
public class Solution812 {
    static  class  Point {
        int x;
        int y;
        Point(int _x, int _y){
            x = _x;
            y = _y;
        }
    }

    public  double distance(Point point1, Point point2){
        int value = (point1.x - point2.x) * (point1.x - point2.x) + (point1.y - point2.y) * (point1.y - point2.y);
        return  Math.sqrt(value);
    }

    public  double computeArea(Point p1, Point p2, Point p3){
        double length1 = distance(p1, p2);
        double length2 = distance(p1, p3);
        double length3 = distance(p2, p3);
        double sumLen = length1 + length2 + length3;
        double value = sumLen * (sumLen - 2 * length1) * (sumLen - 2 * length2) * (sumLen - 2 * length3);
        return  Math.sqrt(value) / 4;

    }

    //Wrong solution
    public  double largestTrangleArea(int[][] points){
        if(points.length == 3){
            Point p1 = new Point(points[0][0], points[0][1]);
            Point p2 = new Point(points[1][0], points[1][1]);
            Point p3 = new Point(points[2][0], points[2][1]);
            return  computeArea(p1, p2, p3);
        }
        Point xMinPoint = null, xMaxPoint = null;
        Point yMinPoint = null, yMaxPoint = null;
        int xMin = 51, xMax = -51;
        int yMin = 51, yMax = -51;

        for(int i = 0; i < points.length; i++){
            if(points[i][0] < xMin){
                xMin = points[i][0];
                xMinPoint = new Point(points[i][0], points[i][1]);
            }
            if(points[i][0] > xMax){
                xMax = points[i][0];
                xMaxPoint = new Point(points[i][0], points[i][1]);
            }

            if(points[i][1] < yMin){
                yMin = points[i][1];
                yMinPoint = new Point(points[i][0], points[i][1]);
            }

            if(points[i][1] > yMax){
                yMax = points[i][1];
                yMaxPoint = new Point(points[i][0], points[i][1]);
            }
        }

        double area1 = computeArea(xMinPoint, xMaxPoint, yMaxPoint);
        double area2 = computeArea(xMinPoint, xMaxPoint, yMinPoint);
        double area3 = computeArea(xMinPoint, yMaxPoint, yMinPoint);
        double area4 = computeArea(xMaxPoint, yMaxPoint, yMinPoint);


       double value1 = Math.max(area1, area2);
        double value2 = Math.max(value1, area3);
        double value3 = Math.max(value2, area4);
        return  value3;
    }

    //Accepted -----16ms
    //bad problem
    public  double largestTrangleArea1(int[][] points){
        if(points.length == 3){
            Point p1 = new Point(points[0][0], points[0][1]);
            Point p2 = new Point(points[1][0], points[1][1]);
            Point p3 = new Point(points[2][0], points[2][1]);
            return  computeArea(p1, p2, p3);
        }

        double maxValue = 0;
        int length = points.length;


        for(int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
                for(int k = j + 1; k < length; k++){
                    Point p1 = new Point(points[i][0], points[i][1]);
                    Point p2 = new Point(points[j][0], points[j][1]);
                    Point p3 = new Point(points[k][0], points[k][1]);
                    double area = computeArea(p1, p2, p3);
                    if (area > maxValue){
                        maxValue = area;
                    }
                }
            }
        }
        return  maxValue;
    }

    @Test
    public  void  test(){
        int[][] points = {{9,7}, {6,10}, {1,10},{2,7}};
        System.out.print(largestTrangleArea1(points));
    }
}
