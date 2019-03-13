package algorithm.medium9;

import org.junit.Test;

/**
 * Created by youlu on 2018/11/14.
 */
public class Solution791 {

    //Accepted -----4ms
    /*
        greedy algorithm
     */
    public  String customSortString(String S, String T){
        int[] arr = new int[26];

        for(int i = 0; i < T.length(); i++){
            int index = (int)(T.charAt(i) - 'a');
            arr[index]++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i< S.length(); i++){
            int value = (int)(S.charAt(i) - 'a');
            if(arr[value] != 0){
                while (arr[value] > 0){
                    sb.append(S.charAt(i));
                    arr[value]--;
                }
            }
        }

        for(int j = 0; j < 26; j++){
            char ch = (char)('a' + j);
            while (arr[j] > 0){
                sb.append(ch);
                arr[j]--;
            }
        }

        return  sb.toString();
    }


    @Test
    public  void  test(){
        String S = "cba";
        String T = "abcd";

        String result = customSortString(S, T);

        System.out.println(result);
    }
}
