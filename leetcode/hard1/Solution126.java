package algorithm.hard1;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/12/18.
 */
public class Solution126 {

    public  boolean check(String str1, String str2){
        int count = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                count++;
            }
        }

        if(count == 1){
            return  true;
        }else {
            return  false;
        }

    }


    //Accepted ----649ms
    /*
        dp algorithm
        from buttom to top by using queue
        time consuming mainly on creating space
     */
    public List<List<String>> findLadders(String beginWord, String endWord,List<String> wordList){
        Map<String, List<List<String>>> paths= new HashMap<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < wordList.size(); i++){
            map.put(wordList.get(i),i);
        }

        if(!map.containsKey(endWord)){
            return  new ArrayList<>();
        }

        int[] arr = new int[wordList.size()];
        Queue<List<String>> queue = new ArrayDeque<>();
        List<String> input = new ArrayList<>();
        input.add(endWord);
        queue.add(input);
        arr[map.get(endWord)] = 1;
        List<String> pre = new ArrayList<>();

        List<List<String>> lastLists = new ArrayList<>();
        List<String> last = new ArrayList<>();
        last.add(endWord);
        lastLists.add(last);
        paths.put(endWord, lastLists);

        while (!queue.isEmpty()){
            List<String> output = queue.poll();
            input = new ArrayList<>();

            for(int i = 0; i < output.size(); i++){
                for(int j = 0; j < wordList.size(); j++){
                    if(arr[j] == 0 && check(wordList.get(j), output.get(i))){
                        input.add(wordList.get(j));
                        arr[map.get(wordList.get(j))]=1;
                    }
                }

                List<List<String>> subPaths = new ArrayList<>();
                for(int k = 0; k < pre.size(); k++) {

                    if (check(output.get(i), pre.get(k))) {
                        List<List<String>> lists = paths.get(pre.get(k));
                        for (int m = 0; m < lists.size(); m++) {
                            List<String> temp = new ArrayList<>(lists.get(m));
                            temp.add(0, output.get(i));
                            subPaths.add(temp);
                        }
                    }
                }
                if(subPaths.size() != 0) {
                    paths.put(output.get(i), subPaths);
                }
            }
            pre = output;
            if(!input.isEmpty()){
                queue.add(input);
            }

        }

        List<List<String>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int minPath = Integer.MAX_VALUE;
        for(int i = 0; i < wordList.size(); i++){
            if(check(beginWord, wordList.get(i))){
                if(paths.containsKey(wordList.get(i))){
                    int val = paths.get(wordList.get(i)).get(0).size();
                    if(val < minPath){
                        minPath = val;
                        list.clear();
                        list.add(i);
                    }else if(val == minPath){
                        list.add(i);
                    }else {}
                }
            }
        }

        if(list.size() == 0){
            return  new ArrayList<>();
        }

        for(int i = 0; i < list.size(); i++){
            List<List<String>> l = paths.get(wordList.get(list.get(i)));
            for(int j = 0; j < l.size(); j++){
                List<String> pathsList = new ArrayList<>(l.get(j));
                pathsList.add(0, beginWord);
                result.add(pathsList);
            }
        }

        return result;

    }

    @Test
    public  void  test(){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
//        wordList.add("cog");

        long startTime = System.currentTimeMillis();
        List<List<String>> result = findLadders(beginWord,endWord, wordList);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + "  ");
            }

            System.out.println();
        }

        System.out.println("running time : " + (endTime - startTime));
    }
}
