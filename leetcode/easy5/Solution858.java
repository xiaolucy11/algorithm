package interview.easy5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/5 0005.
 */
public class Solution858 {
    public  boolean isSame(String A){
        for(int i = 1; i < A.length(); i++){
            if(A.charAt(i) != A.charAt(0)){
                return false;
            }
        }
        return  true;
    }
    public  boolean existSameChar(String A){
        int[] arr = new int[26];
        for(int i = 0; i < A.length(); i++){
            int value = A.charAt(i) - 'a';
            if(arr[value] == 1){
                return  true;
            }
            arr[value]++;
        }
        return  false;
    }

    //Accepted ---5ms
    public  boolean buddyStrings(String A, String B){
        if(A.length() != B.length()){return  false;}
        if(isSame(A) && isSame(B)){
            if(A.charAt(0) == B.charAt(0)){
                return  true;
            }else {
                return  false;
            }
        }
        if(A.equals(B)){return  existSameChar(A);}
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) != B.charAt(i)){
                list.add(i);
            }
        }
        if(list.size() != 2){
            return  false;
        }
        if(A.charAt(list.get(0)) == B.charAt(list.get(1)) &&
                A.charAt(list.get(1)) == B.charAt(list.get(0))){
            return  true;
        }else {
            return  false;
        }
    }

    @Test
    public  void  test(){
        String A = "abab";
        String B = "abab";
        System.out.print(buddyStrings(A, B));
    }
}
