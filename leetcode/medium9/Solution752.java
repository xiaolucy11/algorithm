package algorithm.medium9;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by youlu on 2018/11/8.
 */
public class Solution752 {

    public Set<String> set;

    public  boolean check(char[] chars, int index){
        char ch = chars[index];
        int count = 0;
        if(ch == '9'){
            chars[index] = '0';
            if(set.contains(new String(chars))){
                count++;
            }
        }else {
            chars[index] = (char)(ch + 1);
            if(set.contains(new String(chars))){
                count++;
            }

        }


        if(ch == '0'){
            chars[index] = '9';
            if(set.contains(new String(chars))){
                count++;
            }
        }else {
            chars[index] = (char)(ch - 1);
            if(set.contains(new String(chars))){
                count++;
            }
        }

        chars[index] = ch;
        if(count == 2){
            return  true;
        }else {
            return  false;
        }
    }

    public  boolean allContains(char[] chars){
        for(int i = 0; i < chars.length; i++){
            if(!check(chars, i)){
                return  false;
            }
        }

        return  true;
    }

    public  int openLock(String[] deadends, String target){
         Set<String> set = new HashSet<>();

        for(int i = 0; i < deadends.length; i++){
            set.add(deadends[i]);
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add("0000");
        endSet.add(target);
        int step = 0;

        // similar to left and right together transform
        while (!beginSet.isEmpty() && !endSet.isEmpty()){
            Set<String> next = new HashSet<>();
            for(String str : beginSet){
                if(endSet.contains(str)){
                    return  step;
                }
                if(set.contains(str)){
                    continue;
                }
                set.add(str);
                for(int i = 0; i < str.length(); i++){
                    char[] chars1 = new char[str.length()];
                    System.arraycopy(str.toCharArray(),0,chars1,0, str.length());
                    if(str.charAt(i) == '9'){
                        chars1[i] = '0';
                    }else {
                        chars1[i] = (char)(chars1[i] + 1);
                    }
                    String str1 = new String(chars1);
                    if(!set.contains(str1)){
                        next.add(str1);
                    }


                    char[] chars2 = new char[str.length()];
                    System.arraycopy(str.toCharArray(),0,chars2,0, str.length());
                    if(str.charAt(i) == '0'){
                        chars2[i] = '9';
                    }else {
                        chars2[i] = (char)(chars2[i] -1);
                    }
                    String str2 = new String(chars2);
                    if(!set.contains(str2)){
                        next.add(str2);
                    }

                }
            }
            beginSet = endSet;
            endSet = next;
            step++;
        }

        return  -1;

    }

    //Accepted ---110ms
    /*
        idea from other
        genius solution
     */
    public int openLock1(String[] deadends, String target) {
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        begin.add("0000");
        end.add(target);
        int level = 0;
        while(!begin.isEmpty() && !end.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for(String s : begin) {
                if(end.contains(s)) return level;
                if(deads.contains(s)) continue;
                deads.add(s);
                StringBuilder sb = new StringBuilder(s);
                for(int i = 0; i < 4; i ++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if(!deads.contains(s1))
                        temp.add(s1);
                    if(!deads.contains(s2))
                        temp.add(s2);
                }
            }
            level ++;
            begin = end;
            end = temp;
        }
        return -1;
    }

    @Test
    public  void  test(){
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";

        int result = openLock(deadends, target);
        System.out.println("result : " + result);
    }
}
