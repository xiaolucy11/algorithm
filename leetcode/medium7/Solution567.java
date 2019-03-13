package algorithm.medium7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/10/21.
 */
public class Solution567 {
    public  void  permutations(int[] arr, List<Character> characterList, String s1,List<List<Character>> list){
        if(characterList.size() == s1.length()){
            list.add(new ArrayList<>(characterList));
            return;
        }

        for(int i = 0; i < arr.length;i++){
            if(arr[i] != 0){
                char ch = (char)(i + 'a');
                characterList.add(ch);
                arr[i]--;
                permutations(arr, characterList, s1, list);
                characterList.remove(characterList.size()-1);
                arr[i]++;
            }
        }

    }

    public  boolean contains(String s2, List<Character> list){
        int strIndex = 0, listIndex = 0;
        while ((strIndex < s2.length()) && (s2.charAt(strIndex) != list.get(0))){
            strIndex++;
        }
        while ((strIndex < s2.length()) && (listIndex < list.size())){
            if(s2.charAt(strIndex) == list.get(listIndex)){
                strIndex++;
                listIndex++;
            }else {
                return false;

            }
        }

        if(listIndex >= list.size()){
            return  true;
        }else {
            return  false;
        }
    }

    //Time Limit Exceed
    /*
        outmemory : java heap
     */
    public boolean checkInclusion(String s1, String s2){
        int[] arr = new int[26];
        for(int i = 0; i < s1.length(); i++){
            int value = s1.charAt(i) - 'a';
            arr[value]++;
        }

        List<List<Character>> list = new ArrayList<>();
        permutations(arr,new ArrayList<>(), s1, list);
        for(int i = 0; i < list.size(); i++){
            if(contains(s2, list.get(i))){
                return  true;
            }
        }

        return  false;
    }


    public  int[] countChars(String s1){
        int[] arr = new int[26];
        for(int i = 0; i < s1.length(); i++){
            int value = s1.charAt(i) - 'a';
            arr[value]++;
        }
        return  arr;

    }

    public boolean isAllZeros(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                return  false;
            }
        }
        return  true;
    }

    //Accepted -----178ms
    /*
        too many time spended one arr construction
     */
    public boolean checkInclusion1(String s1, String s2){
        for(int i = 0; i < s2.length(); i++){
            int value = s2.charAt(i) - 'a';
            int[] arr = countChars(s1);
            int flag = 0;
            if((arr[value] != 0) && (i + s1.length() <= s2.length())){
                for(int j = i; j < i + s1.length(); j++){
                    int charValue = s2.charAt(j) - 'a';
                    if(arr[charValue] == 0){
                        flag = 1;
                        break;
                    }else {
                        arr[charValue]--;
                    }
                }
                if(flag == 0 && isAllZeros(arr)){
                    return  true;
                }
            }
        }
        return  false;
    }



    @Test
    public  void  test(){
        String s1 = "ooo";
        String s2 = "eidboaooo";

        long startTime = System.currentTimeMillis();
        boolean b = checkInclusion1(s1, s2);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + b);
        System.out.println("running time : " + (endTime - startTime));
    }
}
