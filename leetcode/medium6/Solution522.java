package algorithm.medium6;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/15.
 */
public class Solution522 {

    public  boolean isSubsequence(String str1, String str2){
        if(str1.length() < str2.length()){
            int start1 = 0, start2 = 0;
            while (start2 < str2.length() && start1 < str1.length()){
                if(str1.charAt(start1) == str2.charAt(start2)){
                    start1++;
                    start2++;
                }else {
                    start2++;
                }
            }

            if(start1 >= str1.length()){
                return  true;
            }else {
                return  false;
            }
        }else {
            int start1 = 0, start2 = 0;
            while (start1 < str1.length() && start2 < str2.length()){
                if(str1.charAt(start1) == str2.charAt(start2)){
                    start1++;
                    start2++;
                }else {
                    start1++;
                }
            }

            if(start2 >= str2.length()){
                return  true;
            }else {
                return  false;
            }
        }
    }


    public  int findLUSlength(String[] strs){
        int maxLength = strs[0].length();
        /*for(int i = 1; i < strs.length; i++){
            if(strs[i].length() > maxLength){
                maxLength = strs[i].length();
            }
        }

        if(maxLength != strs[0].length()){
            return  maxLength;
        }*/

        int maxdifferent = 0;
        int maxdifferentIndex = 0;
        for(int i = 0; i < strs.length; i++){
            int count = 0;
            for(int j = 0; j < strs.length; j++){
                if(i != j){
                    if(!strs[i].equals(strs[j])){
                        count++;
                    }
                }
            }
            if(count > maxdifferent){
                maxdifferent = count;
                maxdifferentIndex = i;
            }
        }

        if(maxdifferent == strs.length - 1){
            return  maxLength;
        }else {
            return -1;
        }
    }

    @Test
    public  void  test(){
        String[] strs  = {"aba","cdc","eae"};
        long startTime = System.currentTimeMillis();
        int result = findLUSlength(strs);
        long endTime = System.currentTimeMillis();
        System.out.println("result :  " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
