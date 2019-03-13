package algorithm.medium4;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by youlu on 2018/9/23.
 */
public class Solution365 {
    public  boolean helper(int x, int y, int z, int minCapacity, int maxCapacity){
        if(z == x || z == y ||  z == x + y){
            return  true;
        }

        if(x == minCapacity){
            if(y > x){
                if (helper(0,y-x,z,minCapacity, maxCapacity)){
                    return  true;
                }
            }else {
                 if(helper(y, maxCapacity,z, minCapacity, maxCapacity)){
                     return  true;
                 }
            }
        }else {
            if(y > x){
                int diff = minCapacity - x;
                if(helper(minCapacity, y-diff, z, minCapacity,maxCapacity)){
                    return  true;
                }
            }else {
                if(x + y <= minCapacity){
                    if(helper(x+y, maxCapacity, z, minCapacity, maxCapacity)){
                        return  true;
                    }
                }else {
                    int diff = minCapacity - x;
                    if(helper(minCapacity, y-diff,z, minCapacity, maxCapacity)){
                        return  true;
                    }
                }
            }
        }
        return  false;
    }


    public  class  Element{
        int x;
        int y;
        Element(int _x, int _y){
            x = _x;
            y = _y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Element element = (Element) o;

            if (x != element.x) return false;
            return y == element.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    //Accepted ------- 330ms
    /*
        not effecient
     */
    public  boolean canMeasureWater(int x, int y, int z){
        if(z == 0){
            return  true;
        }
        int min = Math.min(x,y);
        int max = Math.max(x, y);

        Set<Element> elementSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        int biggerValue = max, smallerValue = min;

        while (true){
            Element e = new Element(smallerValue, biggerValue);
            if(elementSet.contains(e)){
                break;
            }else {
                elementSet.add(e);
                set.add(biggerValue);
                set.add(smallerValue);
                set.add(biggerValue + smallerValue);

                if(smallerValue == min){
                    if(biggerValue > smallerValue){
                        biggerValue -= smallerValue;
                    }else {
                        smallerValue = biggerValue;
                        biggerValue = max;
                    }
                }else if(smallerValue == 0){
                    if(biggerValue > min){
                        smallerValue = min;
                        biggerValue -= min;
                    }else {
                        smallerValue = biggerValue;
                        biggerValue = max;
                    }
                }else {
                    if(biggerValue + smallerValue > min){
                        biggerValue = (biggerValue+smallerValue) - min;
                        smallerValue = min;
                    }else {
                        smallerValue = biggerValue + smallerValue;
                        biggerValue = max;
                    }
                }
            }
        }

        for(Integer value : set){
            if(value == z){
                return  true;
            }
        }
        return false;
    }

    /*
        code from other
        using gcd
     */
    public boolean canMeasureWater1(int x, int y, int z) {
        return z==0||(z<=x+y&&z%gcd(x,y)==0);
    }
    public int gcd(int x, int y) {
        return y==0?x:gcd(y, x%y);//y==0表示找到x可以把y整除
    }

    @Test
    public void  test(){
        int x = 3;
        int y = 7;
        int z = 9;
        long statTime = System.currentTimeMillis();
        System.out.println(canMeasureWater(x,y,z));
        long endTime = System.currentTimeMillis();
        System.out.println("runnint time : " + (endTime - statTime));
    }
}
