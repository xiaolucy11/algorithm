package interview.easy;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/8 0008.
 */
public class Solution67 {
    public int[] stringTovec(String string, int len){
        int[] result = new int[len];
        if(len - string.length() == 1){
            int index1 = 0;
            for(int i = 1; i < len; i++){
                result[i] = string.charAt(index1) - '0';
                index1++;
            }
        }
        else{
            int index2 = 0;
            for(int k = len - string.length(); k < len; k++){
                result[k] = string.charAt(index2) - '0';
                index2++;
            }
        }
        return result;
    }
    public String addBinary(String a, String b){
        int maxLen = Math.max(a.length(), b.length());
        int[] str1 =  stringTovec(a, maxLen+1);
        int[] str2 = stringTovec(b, maxLen+1);
        /*
        if(a.length() < b.length()){
            for(int i = 0; i <= maxLen - a.length(); i++){
                str1[i] = 0;
            }
            int indexA = 0;
            for(int i = maxLen - a.length() + 1; i < maxLen; i++){
                str1[i] = a.charAt(indexA) - '0';
                indexA++;
            }
            str2[0] = 0;
            int indexB = 0;
            for(int i = 1; i < maxLen; i++){
                str2[i] = b.charAt(indexB) - '0';
                indexA++;
            }
        }else {
            for(int i = 0; i <= maxLen - b.length(); i++){
                str2[i] = 0 ;
            }
            int indexB = 0;
            for(int i = maxLen - b.length() + 1; i < maxLen; i++){
                str2[i] = b.charAt(indexB) - '0';
                indexB++;
            }
            str1[0] = 0;
            int indexA = 0;
            for(int i = 1; i < maxLen; i++){
                str1[i] = b.charAt(indexA) - '0';
                indexA++;
            }
        }
        */
        int flag = 0;
        String result = "";
        int[] temp = new int[maxLen+1];
        for(int k = maxLen ; k > 0; k--){
            if(str1[k] + str2[k] + flag >= 2){
                temp[k] = str1[k] + str2[k] +flag - 2;
                flag = 1;
            }else{
                temp[k] = str1[k] + str2[k] + flag;
                flag = 0 ;
            }
        }

        for(int i = 1; i < temp.length; i++){
            result +=  (char)(temp[i] + 48);
        }
        if(flag == 1){

            return "1" + result;
        }else{
            return  result;
        }
    }

    @Test
    public void test(){
        String a = "11";
        String b = "1";
        String result = addBinary(a,b);
        System.out.println(result);
    }
}
