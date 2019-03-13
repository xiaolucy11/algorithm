package algorithm.hard3;


import org.junit.Test;
import org.omg.PortableServer.POA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution587 {
    public class Point{
        int x;
        int y;
        Point(){x = 0; y = 0;}
        Point(int a, int b){
            x = a;
            y = b;
        }
    }
    private double distance(Point a, Point b){
        int len1 = Math.abs(a.x - b.x);
        int len2 = Math.abs(a.y - b.y);

        return  len1 * len1 + len2 * len2;
    }

    private double angle(Point a, Point b){
        double dist = distance(a,b);
        int x1 = b.x - a.x;
        int y1 = b.y - a.y;

        if(y1 >= 0){
            return  Math.acos(x1 / dist);
        }else {
            return  Math.acos(-1 * x1 / dist) + Math.PI;
        }
    }

    private  double reviseAngle(double angle){
        while (angle < 0.){
            angle += 2 * Math.PI;
        }
        while (angle >= 2 * Math.PI){
            angle -= 2 * Math.PI;
        }
        return  angle;
    }

    public int initPoint(Point[] points){
        int index = 0;
        int max = 0, min = 101;
        for(int i = 0; i < points.length; i++){
            if(points[i].y > max){
                max = points[i].y;
                index = i;
                min = points[i].x;
            }else{
                if(points[i].y == max && points[i].x < min){
                    index = i;
                    min = points[i].x;
                }
            }
        }
        return  index;
    }

    public  double cosInVec(Point p1, Point p2){
        double d1 = p1.x * p2.x + p1.y * p2.y;
        double d2 = Math.sqrt((p1.x * p1.x + p1.y * p1.y) * (p2.x * p2.x + p2.y * p2.y));

        if(d1 == 0){
            return  0.0;
        }else {
            return d1 / d2;
        }
    }

    /*
        passing 66/82 test case
        problems exit comparision between double number
     */
    public List<Point> outerTrees(Point[] points){
        int startIndex = initPoint(points);
        Point p1 = points[startIndex];
        List<Point> l = new ArrayList<>();
        l.add(p1);
        Set<Integer> set = new HashSet<>();
        int preIndex = startIndex, nextIndex = 0;
        double  max = -100;
        Point prePoint = new Point(1,0);
        while (true){
            for(int i = 0; i < points.length; i++){
                if(i == preIndex || set.contains(i)){
                    continue;
                }
                double curCos = cosInVec(prePoint,
                        new Point(points[i].x - points[preIndex].x , points[i].y - points[preIndex].y));

                if(curCos > max){
                    max = curCos;
                    nextIndex = i;
                }else {
                    if((Math.abs(curCos - max) < 0.0000001) && (distance(points[preIndex],points[nextIndex]) >
                            distance(points[preIndex], points[i]))){
                        nextIndex = i;
                    }
                }
            }
            if(nextIndex == startIndex){
                break;
            }else {
                l.add(points[nextIndex]);
                set.add(nextIndex);
                prePoint = new Point(points[nextIndex].x - points[preIndex].x,
                        points[nextIndex].y - points[preIndex].y);
                preIndex = nextIndex;
                max = -100;
            }
        }
        return  l;
    }

    @Test
    public void  test(){
        /*Point p1 = new Point(1,1);
        Point p2 = new Point(2,2);
        Point p3 = new Point(2,0);
        Point p4 = new Point(2,4);
        Point p5 = new Point(3,3);
        Point p6 = new Point(4,2);
        Point[] points = {p1,p2,p3,p4,p5,p6};*/

       /* Point p1 = new Point(1,2);
        Point p2 = new Point(2,2);
        Point p3 = new Point(4,2);
        Point[] points = {p1,p2,p3};*/

     /*  Point p1 = new Point(0,2);
       Point p2 = new Point(1,1);
       Point p3 = new Point(2,2);
       Point p4 = new Point(2,4);
       Point p5 = new Point(4,2);
       Point p6 = new Point(3,3);
       Point[] points = {p1,p2,p3,p4,p5,p6};*/

     Point p1 = new Point(4,5);
     Point p2 = new Point(3,0);
     Point p3 = new Point(2,1);
     Point p4 = new Point(1,2);
     Point p5 = new Point(0,3);
     Point p6 = new Point(4,0);
     Point[] points = {p1, p2, p5, p4, p3,p6};

        long startTime = System.currentTimeMillis();
        List<Point> list = outerTrees(points);
        long endTime = System.currentTimeMillis();
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).x + " " + list.get(i).y);
        }
        System.out.println("running time : " + (endTime - startTime));
    }
}
