package interview.easy2;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/12 0012.
 */
public class Solution482 {
    //Accepted ---- 700ms
    public String licenseKeyFormatting(String s, int k){
        String[] strArray = s.split("-");
        String str = "";
        for(int i = 0; i < strArray.length; i++){
            str += strArray[i];
        }
        str = str.toUpperCase();
        if(str.length() <= k){return  str;}
        String result = "";
        int j = str.length() - k;
        for(; j >= 0; j = j - k){
            if( (j - k < 0)  ){
                if(j == 0){
                    result = str.substring(j , j+k) + result;
                }else {
                    result = "-".concat(str.substring(j, j + k)) + result;
                }
                break;
            }else {
                result = "-".concat(str.substring(j, j+k)) + result;
            }
        }

        result = str.substring(0, j) + result;
        return  result;
    }

    //Accepted ------700ms
    public  String licenseKeyFormatting1(String S, int K){
        String result = "";
        int count = 0;
        for(int i = S.length() - 1; i >= 0; i--){

            if((count != K-1) && (S.charAt(i) != '-')){
                char ch = S.charAt(i);
                if(ch >= 'a' && ch <= 'z'){
                    ch = (char) (ch - 'a' + 'A');
                }
                result = ch + result;
                count++;
            }
            else if (count == K - 1 && S.charAt(i) != '-'){
                char ch = S.charAt(i);
                if(ch >= 'a' && ch <= 'z'){
                    ch = (char) (ch - 'a' + 'A');
                }
                result = "-" + ch + result;
                count = 0;
            }else {
                continue;
            }

        }
        if(result.equals("")){return result;}
        else if(result.charAt(0) == '-') {
            return result.substring(1, result.length());
        }else {
            return  result;
        }
    }

    //reference from other
    public String licenseKeyFormatting2(String S, int K){
        String str1 = S.replaceAll("-","").trim();
        StringBuilder stringBuilder = new StringBuilder();

        int count = 0;
        for (int i = str1.length() - 1; i >= 0; i--){
            char ch = str1.charAt(i);
            count++;
            stringBuilder.append(Character.toUpperCase(ch));
            if (count == K && i != 0){
                stringBuilder.append("-");
                count = 0;
            }
        }
        return  stringBuilder.reverse().toString();
    }

    @Test
    public  void  test(){
        String S = "--a-a-a-a--";
        int K = 2;
        System.out.println(S.replace("-","").trim());
        System.out.print(licenseKeyFormatting1(S, K));
    }
}
