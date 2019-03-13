package algorithm.medium10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youlu on 2018/11/21.
 */
public class Solution816 {
    public  boolean isAllZeros(String str){
        if(str.length() == 0){
            return  true;
        }
        for(int i =0 ; i < str.length(); i++){
            if(str.charAt(i) != '0'){
                return false;
            }
        }

        return  true;
    }

    public Map<String, String> split(String str){
       Map<String, String> map = new HashMap<>();
        for(int i = str.length() - 1; i > 0; i--){
            String leftStr = str.substring(0,i);
            String rightStr = str.substring(i,str.length());
            if((leftStr.length() == 1 || !isAllZeros(leftStr)) && ((rightStr.length() == 1) || !isAllZeros(rightStr))){
                map.put(leftStr, rightStr);
            }
        }
        return  map;
    }



    public  List<String> permutate(String str1, String str2){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < str1.length() ; i++){
            StringBuilder sb1 = new StringBuilder();
            String rightSub1 = str1.substring(i+1,str1.length());
            if( ((i == 0) || ( str1.substring(0,i+1).charAt(0) != '0')) &&
                    ((i+1 == str1.length()) || rightSub1.charAt(rightSub1.length() -1)  != '0')){
                sb1.append('(');
                sb1.append(str1.substring(0,i + 1));
                if(i != str1.length() - 1) {
                    sb1.append('.');
                    sb1.append(str1.substring(i + 1, str1.length()));
                }
                sb1.append(',');
                sb1.append(' ');
            }else {
                continue;
            }

            for(int j = 0; j < str2.length() ; j++){
                StringBuilder sb2 = new StringBuilder();
                String rightSub2 = str2.substring(j+1,str2.length());
                if( ((j == 0) || (str2.substring(0,j + 1).charAt(0) != '0')) &&
                        ((j + 1 == str2.length()) || rightSub2.charAt(rightSub2.length() - 1) != '0')){
                    sb2.append(str2.substring(0,j + 1));
                    if(j != str2.length()-1) {
                        sb2.append('.');
                        sb2.append(str2.substring(j + 1, str2.length()));
                    }
                    sb2.append(')');
                    String input = sb1.toString() + sb2.toString();
                    list.add(input);
                }
            }
        }

        return  list;
    }


    //Accepted -----31ms
    public List<String> ambiguousCoordinates(String S){
        Map<String, String> map = split(S.substring(1,S.length()-1));
        List<String> result = new ArrayList<>();

        for(String key : map.keySet()){
            result.addAll(permutate(key,map.get(key)));
        }

        return  result;
    }


    @Test
    public  void  test(){
 //       String S = "(123)";
 //       String S = "(00011)";
 //      String S = "(0123)";
 //       String S = "(100)";
        String S = "(0010)";

        long startTime = System.currentTimeMillis();
        List<String> lists = ambiguousCoordinates(S);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < lists.size(); i++){
            System.out.print(lists.get(i) + "  ");
        }
        System.out.println();

        System.out.println("running time : " + (endTime - startTime));
    }
}
