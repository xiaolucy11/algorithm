package interview.easy4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/1 0001.
 */
public class Solution784 {
    public  boolean isChar(char ch){
        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
            return  true;
        }
        return  false;
    }
    public  List<String> produce(String S, int start, int end){
        if(start > end){
            return  new ArrayList<String>();
        }
        if(start == end){
            if (!isChar(S.charAt(start))) {
                return new ArrayList<String>() {{
                    add(Character.toString(S.charAt(start)));
                }};
            }else {
                return  new ArrayList<String>(){{add(Character.toString(Character.toLowerCase(S.charAt(start))));
                add(Character.toString(Character.toUpperCase(S.charAt(start))));}};
            }
        }
        List<String> list =  produce(S, start, end -  1);
        List<String> result = new ArrayList<>();
        if(isChar(S.charAt(end))){
            for(int i = 0; i < list.size(); i++){
                result.add(list.get(i) + Character.toString(Character.toLowerCase(S.charAt(end))));
                result.add(list.get(i) + Character.toString(Character.toUpperCase(S.charAt(end))));
            }
        }else {
            for(int i = 0; i < list.size(); i++){
                result.add(list.get(i) + Character.toString(S.charAt(end)));
            }
        }
        return  result;
    }

    //Accepted ----12ms
    public List<String> letterCasePermutation(String S){
        if(S.equals("")){
            return  new ArrayList<String>(){{add("");}};
        }
        return  produce(S, 0, S.length()-1);
    }

    @Test
    public  void  test(){
        String S = "123456";
        List<String > result = letterCasePermutation(S);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
    }
}
