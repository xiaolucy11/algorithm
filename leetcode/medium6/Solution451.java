package algorithm.medium6;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/10/7.
 */
public class Solution451 {
    public  class  Element{
        char ch;
        int frequecy;
        Element(char _ch, int _frequency){
            ch = _ch;
            frequecy = _frequency;
        }
    }


    //Accepted ----- 35ms
    /*
        time complexity O(nlog(n))
     */
    public  String frequencySort(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }

        List<Element> list = new ArrayList<>();
        for(Character key : map.keySet()){
            Element e = new Element(key, map.get(key));
            list.add(e);
        }

        Collections.sort(list, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.frequecy > o2.frequecy){
                    return  -1;
                }else if(o1.frequecy < o2.frequecy){
                    return  1;
                }else {
                    if(o1.ch > o2.ch){
                        return  -1;
                    }else if(o1.ch < o2.ch){
                        return  1;
                    }else  {
                        return 0;
                    }
                }
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            Element element = list.get(i);
            int count = element.frequecy;
            while (count > 0){
                stringBuilder.append(element.ch);
                count--;
            }
        }

        return  stringBuilder.toString();
    }

    //Accepted ----- 9ms
    /*
        time complexity O(n)
     */
    public  String frequencySort1(String s){
        int[][] matrix = new int[256][2];
        for(int i = 0; i < 256; i++){
            matrix[i][0] = i;
        }

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            matrix[ch][1]++;
        }

       Arrays.sort(matrix, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               if(o1[1] > o2[1]){
                   return  -1;
               }else if(o1[1] < o2[1]){
                   return  1;
               }else {
                   if(o1[0] > o2[0]){
                       return  -1;
                   }else if(o1[0] < o2[0]){
                       return  1;
                   }else {
                       return 0;
                   }
               }
           }
       });

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 256; i++){
            char ch = (char) matrix[i][0];
            int count = matrix[i][1];
            while (count > 0){
                stringBuilder.append(ch);
                count--;
            }
        }

        return  stringBuilder.toString();
    }


    @Test
    public  void  test(){
       //String  s = "tree";
        String s = "cccaaabbbbbbbddddeeeeedkkkkslllllwwwwwwwwwwwwwwwwwwwwwwwwwllllllllllllrrrrrr";
        long startTime = System.currentTimeMillis();
        String result = frequencySort1(s);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("runnint time : " + (endTime - startTime));
    }
}
