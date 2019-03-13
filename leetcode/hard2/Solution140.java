package algorithm.hard2;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/12/22.
 */
public class Solution140 {
    public List<List<String>> lists;

    public  void  search(String s, int index,Set<String> set,int maxWordLength, List<String> list){
        if(index == s.length()){
            lists.add(new ArrayList<>(list));
        }

        for(int i = index; i < s.length(); i++){
            String subStr = s.substring(index,i+1);
            if(subStr.length() > maxWordLength){
                return;
            }
            if(set.contains(subStr)){
                list.add(subStr);
                search(s, i+1, set, maxWordLength,list);
                list.remove(list.size()-1);
            }
        }
    }


    //Time Limit Exceed
    public List<String> wordBreak(String s,List<String> wordDict){
        lists = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int maxWordLength = 0;
        for (int i = 0; i < wordDict.size(); i++){
            set.add(wordDict.get(i));
            maxWordLength = Math.max(maxWordLength, wordDict.get(i).length());
        }


        search(s,0,set,maxWordLength, new ArrayList<>());
        List<String> result = new ArrayList<>();
        for(int i = 0; i < lists.size(); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < lists.get(i).size(); j++){
               sb.append(lists.get(i).get(j));
                if(j != lists.get(i).size() - 1){
                    sb.append(' ');
                }
            }
            result.add(sb.toString());
        }


        return result;
    }


    public class  Pair{
        int start;
        int end;
        Pair(int _x, int _y){
            start = _x;
            end = _y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (start != pair.start) return false;
            return end == pair.end;

        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            return result;
        }
    }

    public Map<Pair, List<String>> map;

    public List<String> search1(String s, int start, int end, Set<String> set, int maxWordLength ){
        if(start > end){
            return  new ArrayList<>();
        }
        if(start == end){
            String sub1 = s.substring(start, start+1);
            List<String> list1 = new ArrayList<>();
            if(set.contains(sub1)){
                list1.add(sub1);
            }

            map.put(new Pair(start, end), list1);
            return  list1;
        }

        List<String> result = new ArrayList<>();
        String subStr = s.substring(start, end + 1);
        for(int i = start + 1; i <= end; i++){
            String sub = s.substring(start,i);
            if(sub.length() > maxWordLength){
                break;
            }

            if(!set.contains(sub)){
                continue;
            }

            List<String> rightSentence = new ArrayList<>();
            Pair rightInterval = new Pair(i , end );

            if(map.containsKey(rightInterval)){
                rightSentence = map.get(rightInterval);
            }else {
                rightSentence = search1(s, i, end ,set,maxWordLength);
            }

            if(rightSentence.size() != 0){
                for(int m = 0; m < rightSentence.size(); m++){
                    StringBuilder sb = new StringBuilder(sub);
                    sb.append(' ');
                    sb.append(rightSentence.get(m));
                    result.add(sb.toString());
                }
            }
        }

        if(set.contains(subStr)){
            result.add(subStr);
        }
        map.put(new Pair(start, end), result);
        return  result;
    }


    //Accepted -----6ms
    /*
        dp algorithm
     */
    public List<String> wordBreak1(String s,List<String> wordDict){
        map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int maxWordLength = 0;
        for (int i = 0; i < wordDict.size(); i++){
            set.add(wordDict.get(i));
            maxWordLength = Math.max(maxWordLength, wordDict.get(i).length());
        }

        return  search1(s, 0, s.length() - 1, set, maxWordLength);
    }

    public  List<String> stringArrToList(String[] words ){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            list.add(words[i]);
        }
        return  list;
    }


    @Test
    public  void  test(){
       /* String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");*/

       /* String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");*/

      /*String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
               "aaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaa" +
               "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";*/

      /* String s = "aaaaaaaaaaaaaaaaaaaaaaaaa";
        String[] words = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa",
                "aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        List<String> wordDict = stringArrToList(words);*/

      String s = "ab";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("b");

        long startTime = System.currentTimeMillis();
        List<String> result = wordBreak1(s,wordDict);
        long endTime = System.currentTimeMillis();


        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i) + "  ");
        }


        System.out.println("running time : " + (endTime - startTime));


    }
}
