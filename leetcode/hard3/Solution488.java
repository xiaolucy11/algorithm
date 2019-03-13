package algorithm.hard3;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution488 {
    public String concat(char[] chars){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != ' ') {
                sb.append(chars[i]);
            }
        }
        return  sb.toString();
    }


    public Boolean allSingle(char[] chars){
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == chars[i-1]){
                return  false;
            }
        }
        return  true;
    }

    public  Map<Character,Integer> copyMap(Map<Character,Integer> map){
        Map<Character,Integer> result = new HashMap<>();
        for(Character ch : map.keySet()){
            result.put(ch, map.get(ch));
        }
        return  result;
    }
    public boolean allEmptySymbol(char[] chars){
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != ' '){
                return  false;
            }
        }
        return true;
    }
    public char[] insertChar(char[] chars,int index, char ch){
        char[] result = new char[chars.length + 1];
        int j = 0;
        for(int i = 0; i < chars.length; i++){
            result[j++] = chars[i];
            if(i == index){
                result[j++] = ch;
            }
        }

        return  result;
    }


    public  int minStep;

    public  void search(char[] boardChars, Map<Character,Integer> map, int step){
        if(allEmptySymbol(boardChars)){
            minStep = Math.min(step,minStep);
        }
        char[] chars = concat(boardChars).toCharArray();
        /*if(isEmptyOfMap(map)){
            for(int j = 0; j < chars.length; j++){

            }
        }*/
        if(allSingle(chars)){

            if((chars.length == 2) &&((map.containsKey(chars[0]) && map.get(chars[0]) >=2)) &&
                    (map.containsKey(chars[1]) && map.get(chars[1]) >=2)){
                minStep = Math.min(minStep, step+4);
            }
            if((chars.length == 1) && (map.containsKey(chars[0])) &&
                    (map.get(chars[0]) >= 2)){
                minStep = Math.min(minStep,step+2);
            }
            return;
        }

        for(int i = 0; i < chars.length; i++){
            int temp = i;
            while ((temp < chars.length) && (chars[i] == chars[temp])){
                temp++;
            }
            int count = temp - i;
            if(count >= 3){
                for(int j = i; j < temp; j++){
                    chars[j] = ' ';
                }
                search(chars,map,step);
                return;
            }else if (count ==2){
                if(map.containsKey(chars[i]) && map.get(chars[i]) >=1){
                    char ch = chars[i];
                    chars[i] = ' ';
                    chars[i+1] = ' ';
                    map.put(ch,map.get(ch) -1);
                    search(chars,map,step+1);

                    chars[i] = ch;
                    chars[i+1] = ch;
                    map.put(ch,map.get(ch) + 1);
                    if(i != temp) {
                        i = temp - 1;
                    }
                }
            }else {
                if(map.containsKey(chars[i]) && map.get(chars[i]) >=1) {
                    char[] inChars = insertChar(chars, i, chars[i]);
                    map.put(chars[i],map.get(chars[i]) - 1);
                    search(inChars,map,step+1);

                    map.put(chars[i],map.get(chars[i]) + 1);
                }
            }
        }
    }


    //Accepted ----168ms
    /*
        code is not clean
     */
    public  int findMinStep(String board, String hand){
        minStep = Integer.MAX_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < hand.length(); i++){
            map.put(hand.charAt(i), map.getOrDefault(hand.charAt(i),0) +1);
        }
        search(board.toCharArray(),map,0);

        return  minStep != Integer.MAX_VALUE? minStep:-1;
    }


    @Test
    public  void  test(){
       /* String board = "WRRBBW";
        String hand = "RB";*/

       /* String board = "WWRRBBWW";
        String hand = "WRBRW";*/

      /* String board = "G";
       String hand = "GGGGG";*/

      /* String board = "RBYYBBRRB";
       String hand = "YRBGB";*/

//      String board = "WWGWGW";
//      String hand = "GWBWR";

    String board = "RWYWRRWRR";
    String hand = "YRY";

        long startTime = System.currentTimeMillis();
        int result = findMinStep(board,hand);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
