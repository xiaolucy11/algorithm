package algorithm.medium8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by youlu on 2018/11/5.
 */

//Accepted ---189ms
 /*
        it can be optimized
     */
public class Solution729 {
    public  class  Interval{
        int start;
        int end;
        Interval(int _start, int _end){
            start = _start;
            end = _end;
        }
    }

    public List<Interval> list;
    public  Solution729(){
        list = new ArrayList<>();
    }

    public  boolean book(int start, int end){
        if(list.size() == 0){
            list.add(new Interval(start, end));
            return true;
        }
        if(end <= list.get(0).start || start >= list.get(list.size()-1).end){
            list.add(new Interval(start, end));
            Collections.sort(list, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    if(o1.start < o2.start){
                        return  -1;
                    }else if(o1.start > o2.start){
                        return  1;
                    }else {
                        return  o1.end - o2.end;
                    }
                }
            });
            return  true;
        }else {
            for(int i = 0; i < list.size(); i++){
                if((start >= list.get(i).start && start < list.get(i).end) ||
                        (end > list.get(i).start && end <= list.get(i).end) || (
                                list.get(i).start >= start && list.get(i).end <= end
                        )|| (
                                list.get(i).end > start && list.get(i).end <= end
                        )){
                    return  false;
                }
            }

            list.add(new Interval(start, end));
            Collections.sort(list, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    if(o1.start < o2.start){
                        return  -1;
                    }else if(o1.start > o2.start){
                        return  1;
                    }else {
                        return  o1.end - o2.end;
                    }
                }
            });

            return true;
        }
    }

    public  static  void  main(String[] args){
        Solution729 myCalendar = new Solution729();
        long startTime = System.currentTimeMillis();
       /* boolean b1 = myCalendar.book(47,50);
        boolean b2 = myCalendar.book(33,41);
        boolean b3 = myCalendar.book(39,45);
        boolean b4 = myCalendar.book(33,42);
        boolean b5 = myCalendar.book(25,32);
        boolean b6 = myCalendar.book(36,35);
        boolean b7 = myCalendar.book(19,25);
        boolean b8 = myCalendar.book(3,8);
        boolean b9 = myCalendar.book(8,13);
        boolean b10 = myCalendar.book(18,27);*/

       boolean b1 = myCalendar.book(37,50);
        boolean b2 = myCalendar.book(33,50);
        boolean b3 = myCalendar.book(4,17);
        boolean b4 = myCalendar.book(35,48);
        boolean b5 = myCalendar.book(8,25);
        long endTime = System.currentTimeMillis();

     /*   System.out.println("result1 : " + b1);
        System.out.println("result2 : " + b2);
        System.out.println("result3 : " + b3);
        System.out.println("result4 : " + b4);
        System.out.println("result5 : " + b5);
        System.out.println("result6 : " + b6);
        System.out.println("result7 : " + b7);
        System.out.println("result8 : " + b8);
        System.out.println("result9 : " + b9);
        System.out.println("result10 : " + b10);*/

        System.out.println("result1 : " + b1);
        System.out.println("result2 : " + b2);
        System.out.println("result3 : " + b3);
        System.out.println("result3 : " + b4);
        System.out.println("result3 : " + b5);
        System.out.println("running time : " + (endTime - startTime));

    }
}
