package algorithm.medium3;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/9/16.
 */
public class Solution306 {
    public int flag ;
    public  int isEqual(String str1, String str2, String str3){
        BigInteger value1 = new BigInteger(str1);
        BigInteger value2 = new BigInteger(str2);
        BigInteger value3 = new BigInteger(str3);

       return  value1.add(value2).compareTo(value3);
    }

    public  void search(List<String> stringList, String num, int index){
            if(index == num.length()){
                if(stringList.size() > 2) {
                    flag = 1;
                    return;
                }else {
                    return;
                }
            }
           /* if(num.charAt(index) == '0'){
                if(stringList.size() < 2) {
                    stringList.add(Character.toString(num.charAt(index)));
                    index = index+1;
                }else {
                   int len = stringList.get(stringList.size()-1).length();
                    stringList.remove(stringList.size()-1);
                    index = index - len;
                }
            }*/

            for(int i = index; i < num.length() ; i++){
                String subStr = "";
                if(i + 1 < num.length()) {
                    if(num.charAt(i+1) != '0') {
                        subStr = num.substring(index, i + 1);
                    }else {
                        subStr = num.substring(index,i+2);
                        i++;
                    }
                }
                if(stringList.size() < 2){
                   /* if(stringList.size() == 0 && subStr.length() >= (num.length() / 2)){
                        return;
                    }*/
                   if(subStr.length() <= (num.length() - i + 1)) {
                       stringList.add(subStr);
                       search(stringList, num, i + 1);
                       stringList.remove(stringList.size() - 1);
                   }else {
                       return;
                   }

                }else {
                    String str1 = stringList.get(stringList.size()-1);
                    String str2 = stringList.get(stringList.size()-2);
                    if(subStr.length() > str2.length() + 1){
                        return;
                    }
                    if( subStr.length() >= str2.length()
                            && isEqual(str1, str2, subStr) == 0){
                        stringList.add(subStr);
                        search(stringList,num, i+1);
                        stringList.remove(stringList.size() - 1);
                    }
                }
            }
    }

    public  void search1(List<String> stringList, String num, int index){
        if(index == num.length()){
            if(stringList.size() > 2) {
                flag = 1;
                for(int j = 0; j < stringList.size(); j++){
                    System.out.print(stringList.get(j) + " ");
                }
               return;
            }else {
                return;
            }
        }

        int length = stringList.get(stringList.size()-1).length();
        int size = stringList.size();
        if(size > 3) {
            String str1 = stringList.get(stringList.size() - 1);
            String str2 = stringList.get(stringList.size() - 2);
            if (index + length <= num.length()) {
                String subStr = num.substring(index, index + length);

                if (isEqual(str1, str2, subStr) == 0) {
                    stringList.add(subStr);
                    search1(stringList, num, index + length);
                    stringList.remove(stringList.size() - 1);
                    }
                }

            if (flag == 0 && index + length + 1 <= num.length()) {
                String subStr = num.substring(index, index + length + 1);
                if (isEqual(str1, str2, subStr) == 0 && (num.charAt(index) != '0')) {
                    stringList.add(subStr);
                    search1(stringList, num, index + length + 1);
                    stringList.remove(stringList.size()-1);
                    }
                }
            }else {
            for(int i = index; i < num.length(); i++){
                String subStr = num.substring(index, i+1);
                if(size < 2){
                    if((num.charAt(index) != '0') ||
                            (num.charAt(index) == '0') && i == index){
                        stringList.add(subStr);
                        search1(stringList,num,i+1);
                        stringList.remove(stringList.size()-1);
                    }
                }else {
                    String str1 = stringList.get(stringList.size()-1);
                    String str2 = stringList.get(stringList.size()-2);
                    if(((num.charAt(index) != '0') ||
                            (num.charAt(index) == '0') && i == index)){
                        if(isEqual(str1, str2, subStr) == 0) {
                            stringList.add(subStr);
                            search1(stringList, num, i + 1);
                            stringList.remove(stringList.size() - 1);
                        }else if(isEqual(str1, str2,subStr) < 0){
                            return;
                        }else {

                        }
                    }
                }
            }
        }
        }


        //Accepted ----13ms
    /*
        it can be optimized
     */
    public boolean isAdditiveNumber(String num){
        if(num.length() < 3){
            return  false;
        }
        flag = 0;
        int lenght = num.length();
        if(num.charAt(0) == '0'){
            List<String> stringList = new ArrayList<>();
            stringList.add(Character.toString(num.charAt(0)));
            search1(stringList, num,1);
        }
       else {
            for (int i = 0; i <= lenght / 2 + 1; i++) {
                List<String> stringList = new ArrayList<>();
                stringList.add(num.substring(0, i + 1));
                search1(stringList, num, i + 1);
            }
        }

        if(flag == 1){
            return  true;
        }else {
            return  false;
        }
    }

    @Test
    public  void  test(){
        String num = "2461016264268110179";
        long startTime = System.currentTimeMillis();
        System.out.println(isAdditiveNumber(num));
        long endTime = System.currentTimeMillis();
        System.out.println("running time : " + (endTime - startTime));
    }
}
