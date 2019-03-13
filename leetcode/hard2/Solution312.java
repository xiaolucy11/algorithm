package algorithm.hard2;

import org.junit.Test;

import java.util.*;

public class Solution312 {
    public  class  Element{
        List<Integer> list;
        Element(){
            list = new LinkedList<>();
        }
        Element(List<Integer> _list){
            list = _list;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element element = (Element) o;
            if(list.size() != element.list.size()){
                return  false;
            }
            for(int i = 0; i < element.list.size(); i++){
                if(list.get(i) != element.list.get(i)){
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(list);
        }
    }

    public Map<Element,Integer> map;
    public int search(int[] nums, List<Integer> l) {
        if (l.size() == 2) {
            int value1 = l.get(0);
            int value2 = l.get(1);
            int temp = value1 * value2 + Math.max(value1, value2);
            map.put(new Element(l), temp);
            return temp;
        } else {
            int maxValue = 0;
            for (int i = 0; i < l.size(); i++) {
               int value = 0;
               if(i == 0){
                   value += l.get(i) * l.get(i+1);
               }else if(i == l.size() - 1){
                   value += l.get(i) * l.get(i-1);
               }else {
                   value += l.get(i) * l.get(i-1) * l.get(i+1);
               }

               List<Integer> temp = new LinkedList<>();
               temp.addAll(l);
               temp.remove(i);
               if(map.containsKey(temp)){
                   value += map.get(temp);
               }else {
                   value += search(nums,temp);
               }
               if(value > maxValue){
                   maxValue = value;
               }

            }
         /*   for(int j = 0; j < l.size(); j++){
                System.out.print(l.get(j));
            }
            System.out.println(" : " + maxValue);
            */
            map.put(new Element(l),maxValue);
            return  maxValue;
        }
    }



    //not accepted
    /*
        brute solution
     */
    public  int maxCoins(int[] nums) {
        if (nums.length == 1) {

        return nums[0];
    }
        map = new HashMap<>();
        List<Integer> l = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            l.add(nums[i]);
        }

        return search(nums,l);

    }

    @Test
    public  void  test(){
        int[] nums = {2,3,1,5,8};
//        int[] nums = {7,9,8,0,7,1,3,5,5,2,3};

        long startTime = System.currentTimeMillis();
        int result = maxCoins(nums);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
