package algorithm.hard2;

import org.junit.Test;

import java.util.*;

public class Solution316 {
    public List<String> list;
    public char[] arr ;
    public  int totalCount;


    public  void  search(String s, StringBuilder sb, int index, Set<Character> set){
        if(index == s.length()){
//            int b = list.get(0).compareTo(sb.toString());
            if(sb.length() == totalCount && list.get(0).compareTo(sb.toString()) > 0){
                list.clear();
                list.add(sb.toString());
            }
            return;
        }

        char ch = s.charAt(index);
        if(!set.contains(ch)){
            search(s,sb,index+1,set);

            sb.append(ch);
            set.add(ch);
            search(s,sb,index+1, set);
            sb.deleteCharAt(sb.length()-1);
            set.remove(ch);
        }else {
            search(s,sb,index+1, set);
        }
    }

    public String removeDuplicateletters(String s){
        list = new ArrayList<>();
        StringBuilder minSb = new StringBuilder();
        arr = new char[26];
        for(int i = 0; i < s.length(); i++){
            minSb.append('z');
            int index = (int)(s.charAt(i) - 'a');
            if(arr[index] == 0){
                arr[index]++;
                totalCount++;
            }
        }
        list.add(minSb.toString());

        search(s,new StringBuilder(),0,new HashSet<>());
        return  list.get(0);
    }

    public class  Element{
        char c;
        int index;
        Element(char _c, int _index){
            c = _c;
            index = _index;
        }
    }


    //Accepted -----15ms
    /*
        increasing stack
     */
    public String removeDuplicateletters1(String s){
        if(s.length() == 0){
            return  "";
        }

        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i),i);
        }

        Set<Character> set = new HashSet<>();
        Deque<Element> deque = new ArrayDeque<>();
        set.add(s.charAt(0));
        deque.addLast(new Element(s.charAt(0),0));
        for(int i = 1; i < s.length();i++){
           Element top = deque.peekLast();
            /*if(top.c == s.charAt(i)){
                deque.pollLast();
                deque.addLast(new Element(s.charAt(i),i));
                continue;
            }*/
            /*if( top.c != s.charAt(i) && set.contains(s.charAt(i))){
                continue;
            }*/

           if(set.contains(s.charAt(i))){
               continue;
           }
                while (!deque.isEmpty()){
                    Element e  = deque.peekLast();
                    /*if(map.get(s.charAt(i)) == i && !set.contains(s.charAt(i))){
                        deque.addLast(new Element(s.charAt(i),i));
                        break;
                    }*/
                    if(e.c > s.charAt(i)){
                        if(map.get(e.c) <= i){
                            set.add(s.charAt(i));
                            deque.addLast(new Element(s.charAt(i), i));
                            break;
                        }
                        Element temp =  deque.pollLast();
                        set.remove(temp.c);
                    }else {
                            if(e.c != s.charAt(i)) {
                                set.add(s.charAt(i));
                                deque.addLast(new Element(s.charAt(i), i));
                            }
                        break;
                    }
                }
                if(deque.isEmpty()){
                    set.add(s.charAt(i));
                    deque.addLast(new Element(s.charAt(i), i));
                }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            Element element = deque.pollFirst();
            sb.append(element.c);
        }
        return  sb.toString();
    }

    @Test
    public  void test(){
        String s = "bcabc";
//        String s = "cbacdcbc";
//        String s = "cbacjfjkkdowcnkdkooiehfhdksjjfjdkqbbvbvbmmmcmmcaksksieieiooqowdcbc";
//        String s = "bbcaac";
//        String s = "bcbac";
//        String s = "abacb";


        long startTime = System.currentTimeMillis();
        String result = removeDuplicateletters1(s);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time :" + (endTime - startTime));
    }
}
