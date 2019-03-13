package interview.medium1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/9 0009.
 */
public class Solution17 {
    private Map<Character, String> map;

    private void  init(){
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5',"jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public  void produceString(String[] arr, int index, String str, List<String> list) {
        if (index == arr.length - 1) {
            for (int i = 0; i < arr[index].length(); i++) {
                String temp = str + Character.toString(arr[index].charAt(i));
                list.add(temp);
            }
        } else {
            for (int i = 0; i < arr[index].length(); i++) {
                produceString(arr, index + 1, str + Character.toString(arr[index].charAt(i)), list);
            }
        }
    }

    //Accepted ------3ms
    public List<String> letterCombinations(String digits){
        init();
        List<String> list = new ArrayList<>();
        String[] arr = new String[digits.length()];
        for(int i = 0; i < digits.length(); i++){
            arr[i] = map.get(digits.charAt(i));
        }
        produceString(arr,0, "", list);
        return  list;
    }

    @Test
    public  void  test(){
        String digits = "23";
        List<String> result = letterCombinations(digits);
        System.out.println(result.size());

        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
    }
}
