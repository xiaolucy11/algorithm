package algorithm.hard3;

import org.junit.Test;

import java.util.*;

public class Solution514 {
    public  int minStep;

    public  String dequeToStr(Deque<Character> queue){
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            char ch = queue.pollFirst();
            sb.append(ch);
        }
        return  sb.toString();
    }

    public  Deque<Character> strToDeque(String str){
        Deque<Character> deque = new LinkedList<>();
        for(int i = 0; i < str.length(); i++){
            deque.addLast(str.charAt(i));
        }
        return  deque;
    }

    public  void clockwiseRotate(String ring, String key, int keyIndex, int rotateCount){
        if(keyIndex == key.length()){
            minStep = Math.min(minStep,rotateCount);
            return;
        }
        if(rotateCount >= minStep || rotateCount > ring.length() * key.length()){
            return;
        }

        if(ring.charAt(0) == key.charAt(keyIndex)){
            clockwiseRotate(ring, key, keyIndex+1, rotateCount+1);
            antiClockWiseRotate( ring,key, keyIndex + 1, rotateCount + 1);
        }

        Deque<Character> queue = strToDeque(ring);
        int count = 0;
        while (!queue.isEmpty()){
            char ch = queue.pollLast();
            if(ch == key.charAt(keyIndex)){
                count += 2;
                queue.addFirst(ch);
                break;
            }else {
                queue.addFirst(ch);
                count++;
            }
        }

        String nextStr = dequeToStr(queue);
        clockwiseRotate(nextStr,key,keyIndex+1, rotateCount + count);
        antiClockWiseRotate(nextStr,key,keyIndex+1,rotateCount + count);
    }

    public  void  antiClockWiseRotate(String ring, String key, int keyIndex, int rotateCount){
        if(keyIndex == key.length()){
            minStep = Math.min(minStep,rotateCount);
            return;
        }
        if(rotateCount >= minStep || rotateCount > ring.length() * key.length()){
            return;
        }

        if(ring.charAt(0) == key.charAt(keyIndex)){
            antiClockWiseRotate(ring,key,keyIndex+1, rotateCount + 1);
            clockwiseRotate( ring, key, keyIndex+1, rotateCount + 1);
        }

        Deque<Character> queue = strToDeque(ring);
        int count = 0;
        while (!queue.isEmpty()){
            char ch = queue.pollFirst();
            if(ch == key.charAt(keyIndex)){
                queue.addFirst(ch);
                count++;
                break;
            }else {
                queue.addLast(ch);
                count++;
            }
        }
        String nextStr = dequeToStr(queue);
        antiClockWiseRotate(nextStr,key, keyIndex+1, rotateCount + count);
        clockwiseRotate(nextStr, key, keyIndex + 1, rotateCount + count);
    }


    //Time Limited Exceed
    /*
        using two Deque
     */
    public int findRotateSteps(String ring, String key){
        minStep = Integer.MAX_VALUE;

        clockwiseRotate(ring,key,0,0);
        antiClockWiseRotate(ring,key, 0, 0);
        return  minStep;
    }

    public  int antiClockWise(String ring, char ch){
        for(int i = 0; i < ring.length(); i++){
            if(ring.charAt(i) == ch){
                return i;
            }
        }
        return  -1;
    }

    public  int clockWise(String ring, char ch){
        for(int i = ring.length() - 1; i >= 0; i--){
            if(ring.charAt(i) == ch){
                return  i;
            }
        }
        return  -1;
    }
    public class  Pair{
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

    public Map<Pair,Integer> map;
    public int help(String ring, String key, int  ringIndex, int keyIndex){
        if(keyIndex == key.length()){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i = ringIndex; i < ring.length(); i++){
            if(ring.charAt(i) == key.charAt(keyIndex)){
                int value1 = Math.min(i-ringIndex, ringIndex + ring.length()  - i);
                int value2 = 0;
                if(map.containsKey(new Pair(i,keyIndex+1))){
                    value2 = map.get(new Pair(i, keyIndex+1));
                }else {
                    value2 = help(ring, key, i,keyIndex+1);
                }
                min = Math.min(min, value1 + value2);
            }
        }
        for(int i = 0; i < ringIndex; i++){
            if(ring.charAt(i) == key.charAt(keyIndex)){
                int value1 = Math.min(ringIndex - i, i  + ring.length() - ringIndex);
                int value2 = 0;
                if(map.containsKey(new Pair(i, keyIndex+1))){
                    value2 = map.get(new Pair(i,keyIndex + 1));
                }else {
                    value2 = help(ring, key, i,keyIndex + 1);
                }
                min = Math.min(min, value1 + value2);
            }
        }

        map.put(new Pair(ringIndex, keyIndex), min+1);
        return  min+1;
    }

    //Accepted ----71ms
    /*
        using memorization search
     */
    public int findRotateSteps1(String ring, String key){
        map = new HashMap<>();
        return help(ring, key,0,0);
    }


    @Test
    public  void  test(){
        /*String ring = "godding";
        String key = "gd";*/

        String ring = "abcde";
        String key = "ade";

        /*String ring = "xrrakuulnczywjs";
        String key = "jrlucwzakzussrlckyjjsuwkuarnaluxnyzcnrxxwruyr";*/

        long startTime = System.currentTimeMillis();
        int result = findRotateSteps1(ring, key);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
