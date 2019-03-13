package interview.medium1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2018/8/11 0011.
 */
public class Solution49 {
    private int[] arr1 = new int[26];
    private int[] arr2  = new int[26];

    private  void  init(){
        for(int i = 0; i < 26; i++){
            arr1[i] = 0;
            arr2[i] = 0;
        }
    }
    public  boolean isEquals(String str1, String str2){
        if(str1.length() != str2.length()){
            return  false;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for(int i = 0; i < chars1.length; i++){
            if(chars1[i] != chars2[i]){
                return  false;
            }
        }

        return  true;
    }
    public  boolean check(String str1, String str2){
        if(str1.length() != str2.length()){
            return  false;
        }

        init();
        for(int i = 0; i < str1.length(); i++){
            int value1 = str1.charAt(i) - 'a';
            int value2 = str2.charAt(i) - 'a';
            arr1[value1]++;
            arr2[value2]++;
        }
        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i]){
                return  false;
            }
        }
        return  true;
    }

    public int find(List<List<String>> lists, String str){
        for(int i = 0; i < lists.size(); i++){
           String headStr = lists.get(i).get(0);
            if(check(headStr, str)){
               return i;
            }
        }
        return  -1;
    }

    //Accepted ------948ms
    //slower than solution with running time 16ms,which use Map data structure,
    // but there is big difference between them;
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> lists = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            int index  = find(lists, strs[i]);
            if(index == -1){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                lists.add(list);
            }else {
                lists.get(index).add(strs[i]);
            }
        }

        return  lists;
    }

    @Test
    public void  test(){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + "  ");
            }
            System.out.println("  ");
        }
    }
}
