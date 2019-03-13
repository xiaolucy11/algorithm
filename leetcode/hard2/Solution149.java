package algorithm.hard2;

import org.junit.Test;

import java.lang.annotation.Target;
import java.util.*;

public class Solution149 {
    public  class Point{
        int x;
        int y;
        Point(){
            x = 0;
            y = 0;
        }
        Point(int a, int b){
            x = a;
            y = b;
        }
    }

    public  class  Pair{
        int x;
        int y;
        Pair(int a, int b){
            x = a;
            y = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int get(int value){
        if (value == 1){
            return  2;
        }
        for(int i = 3; i <= value; i++){
            if(i*(i-1) / 2 == value){

                return i;
            }
        }
        return 0;
    }

    public  int compute(int value){
        if(value == 1){
            return  1;
        }
        return value * (value - 1) / 2;
    }


    //Wrong Solution
    public  int maxPoints(Point[] points){
        if(points.length == 1){
            return 1;
        }
        Map<Double,Integer> map = new HashMap<>();
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x > o2.x){
                    return  1;
                }else if(o1.x < o2.x){
                    return -1;
                }else {
                    return o1.y - o2.y;
                }

            }
        });
        Pair[] pairs = new Pair[points.length];
        Map<Pair, Integer> duplicateMap = new HashMap<>();
        for(int i = 0; i < pairs.length; i++){
            pairs[i] = new Pair(points[i].x, points[i].y);
            duplicateMap.put(pairs[i], duplicateMap.getOrDefault(pairs[i],0) + 1);
        }
        List<Pair> list = new ArrayList<>();
        for(Pair key: duplicateMap.keySet()){
            list.add(key);
        }

        if(list.size() == 1){
            return duplicateMap.get(list.get(0));
        }

        Map<Integer, Integer> zeroSlopMap = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                int startCount = duplicateMap.get(list.get(i));
                int endCount = duplicateMap.get(list.get(j));
                int value = startCount * endCount ;
                if(startCount != 1){
                    value += compute(startCount);
                }
                if(endCount !=1){
                    value += compute(endCount);
                }

                double temp = 0;
                if(list.get(i).x != list.get(j).x) {
                    temp = 1.0 * (list.get(j).y - list.get(i).y) / (list.get(j).x - list.get(i).x);
                    map.put(temp, map.getOrDefault(temp,0) + value);;
                }else {
                   zeroSlopMap.put(list.get(i).x, zeroSlopMap.getOrDefault(list.get(i).x, 0) + value);
                }
            }
        }

        int maxValue = 0;
        int maxZeroSlop = 0;
        for(Double key: map.keySet()){
            int count = get(map.get(key));
            maxValue = Math.max(maxValue,count);
        }

        for(Integer key: zeroSlopMap.keySet()){
            maxValue = Math.max(maxValue, get(zeroSlopMap.get(key)));
        }
        return  maxValue;
    }

    public int gcd(int a, int b){
        int c = a % b;
        while (c != 0){
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }

    //Accepted -----28ms
    /*
        time complexity O(n^2)
     */
    public  int maxPoints1(Point[] points){
        if(points.length == 1){
            return 1;
        }
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x > o2.x){
                    return  1;
                }else if(o1.x < o2.x){
                    return -1;
                }else {
                    return o1.y - o2.y;
                }

            }
        });

        int maxValue = 0;
        for(int i = 0; i < points.length; i++){
            Map<Pair, Integer> map = new HashMap<>();
            int count = 0;
            for(int j = i + 1; j < points.length;j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    count++;
                    continue;
                }
                if(points[i].x == points[j].x){
                    map.put(new Pair(Integer.MAX_VALUE,1), map.getOrDefault(new Pair(Integer.MAX_VALUE,1),0) + 1);
                }else {
                   int div = gcd(points[i].y - points[j].y, points[i].x - points[j].x);
                   Pair pair = new Pair((points[i].y - points[j].y) / div,(points[i].x - points[j].x) / div);
                    map.put(pair, map.getOrDefault(pair,0) + 1);
                }
            }

            if(map.keySet().size() == 0){
                maxValue = Math.max(maxValue,1+count);
            }else {
                for (Pair key : map.keySet()) {
                    maxValue = Math.max(maxValue, map.get(key) + 1 + count);
                }
            }

        }

        return  maxValue;
    }


    @Test
    public  void  test(){
      /*  Point[] points = new Point[3];
        points[0] = new Point(1,1);
        points[1] = new Point(2,2);
        points[2] = new Point(3,3);*/
//       Point[] points = new Point[3];
//       points[0] = new Point(4,0);
//       points[1] = new Point(4,-1);
//       points[2] = new Point(4,5);

    /* Point[] points = new Point[2];
     points[0] = new Point(0,0);
     points[1] = new Point(0,0);*/

    /* Point[] points = new Point[3];
     points[0] = new Point(1,1);
     points[1] = new Point(1,1);
     points[2] = new Point(1,1);*/


   /* Point[] points = new Point[4];
    points[0] = new Point(3,1);
    points[1] = new Point(12,3);
    points[2] = new Point(3,1);
    points[3] = new Point(-6,-1);*/

     /* Point[] points = new Point[6];
       points[0] = new Point(1,1);
       points[1] = new Point(3,2);
       points[2] = new Point(5,3);
       points[3] = new Point(4,1);
       points[4] = new Point(2,3);
       points[5] = new Point(1,4);*/


      Point[] points = new Point[3];
      points[0] = new Point(0,0);
      points[1] = new Point(1,1);
      points[2] = new Point(0,0);

   /* Point[] points = new Point[3];
    points[0] = new Point(0,0);
    points[1] = new Point(94911151,94911150);
    points[2] = new Point(94911152,94911151);*/

        long startTime = System.currentTimeMillis();
        int result = maxPoints1(points);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }



    @Test
    public  void  test1(){
        int a = 4;
        int b = 6;
        int c = gcd(a,b);
        System.out.println(c);
    }
}
