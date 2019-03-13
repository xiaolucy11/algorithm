package interview.medium3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/8 0008.
 */
public class Solution165 {
    public  String deleteDot(String version){
        StringBuilder str = new StringBuilder();
        int lenght = version.length();
        int index = 0;
        while (index < lenght){
            if(version.charAt(index) == '0'){
                index++;
            }else {
                break;
            }
        }

        while (index < lenght){
            if(version.charAt(index) != '.'){
                str.append(version.charAt(index));
            }
            index++;

        }
        String result = str.toString();
        int taiIndex = result.length()-1;
        while (taiIndex >= 0){
            if(result.charAt(taiIndex) == '0'){
                taiIndex--;
            }else {
                break;
            }
        }
        return  str.substring(0, taiIndex+1);
    }

    public  int stringToNumber(String str){
        List<Integer> list = new ArrayList<>();
        int index = 0;
        int length = str.length();
        while (index < length){
            if(str.charAt(index) == '0'){
                index++;
            }else {
                break;
            }
        }
        while (index < length){
            list.add((int)(str.charAt(index) - '0'));
            index++;
        }

        int sum = 0;
        int multiply = 1;
        for(int i = list.size()-1; i >= 0; i--){
            sum += list.get(i) * multiply;
            multiply *= 10;
        }
        return  sum;
    }
    public  List<String> strSplit(String string){
        List<String> list = new ArrayList<>();
        int first = 0, last = 0;
        int length = string.length();

        while (last < length){
            if(string.charAt(last) != '.'){
                last++;
            }else {
                String subStr = string.substring(first, last);
                list.add(subStr);
                last++;
                first = last;
            }
        }
        if(last > first) {
            list.add(string.substring(first, last));
        }
        return  list;
    }

    //Accepted ------1ms
    public  int compareVersion(String version1, String version2){
        List<String> words1 = strSplit(version1);
        List<String> words2 = strSplit(version2);
        int length1 = words1.size(), length2 = words2.size();
        int len = Math.min(length1, length2);

        for(int i = 0; i < len; i++){
            int value1 = stringToNumber(words1.get(i));
            int value2 = stringToNumber(words2.get(i));
            if(value1 > value2){
                return 1;
            }else if(value1 < value2){
                return -1;
            }else {

            }
        }

        if(length1 > length2){
            for(int i = len; i < length1; i++){
                int value1 = stringToNumber(words1.get(i));
                if(value1 > 0){
                    return  1;
                }
            }
            return 0;
        }else if(length1 < length2){
            for(int i = len; i < length2; i++){
                int value2 = stringToNumber(words2.get(i));
                if(value2 > 0){
                    return -1;
                }
            }
            return 0;
        }else {
            return 0;
        }
    }

    @Test
    public  void  test(){
        String version1 = "1";
        String version2 = "1.10";
        System.out.println(compareVersion(version1, version2));

        // String[] words = version1.split("\\.");
    }
}
