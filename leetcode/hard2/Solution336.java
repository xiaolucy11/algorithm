package algorithm.hard2;

import org.junit.Test;

import java.util.*;

public class Solution336 {

    public class Pair{
        int x;
        int y;
        Pair(int _x, int _y){
            x = _x;
            y = _y;
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

    public boolean  isPalidrome(String str){
        if(str.length() == 0){return true;}
        int start = 0, end = str.length()-1;
        while (start < end){
            if(str.charAt(start) != str.charAt(end)){
                return  false;
            }else {
                start++;
                end--;
            }
        }
        return true;
    }



    //Accepted ----239ms
    public List<List<Integer>> palidromePairs(String[] words){
        Map<String,Integer> map = new HashMap();
        for(int i = 0; i < words.length; i++){
            map.put(words[i],i);
        }

        Set<String> set = map.keySet();
        Set<Pair> result = new HashSet<>();
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j <= words[i].length();j++){
                String sub1 = words[i].substring(0,j);
                String sub2 = new StringBuilder(words[i].substring(j)).reverse().toString();
                if(isPalidrome(sub1) &&
                        set.contains(sub2)){
                    int index1 = map.get(sub2);
                    if(index1 != i) {
                        result.add(new Pair(index1, i));
                        if(words[index1].equals("")){
                            result.add(new Pair(i,index1));
                        }
                    }
                }

                String sub3 = new StringBuilder(sub1).reverse().toString();
                if(isPalidrome(sub2) && set.contains(sub3)){
                    int index2 = map.get(sub3);
                    if(index2 != i){
                        result.add(new Pair(i,index2));
                    }
                }
            }


        }

        List<List<Integer>> lists = new ArrayList<>();
        for(Pair p : result){
            List<Integer> l = new ArrayList<>();
            l.add(p.x);
            l.add(p.y);
            lists.add(l);
        }

        return  lists;
    }

    @Test
    public  void  test(){
//        String[] words = {"abcd","dcba","lls","s","sssll"};
//        String[] words = {"bat","tab","cat"};
//        String[] words = {"a",""};
//        String[] words = {"a","b","c","ab","ac","aa"};
        String[] words = {"ab","ba","abc","cba"};
        long startTime = System.currentTimeMillis();
        List<List<Integer>> result = palidromePairs(words);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i).get(0) + " : " + result.get(i).get(1));
        }

        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }
}
