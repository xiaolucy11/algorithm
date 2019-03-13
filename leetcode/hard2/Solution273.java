package algorithm.hard2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution273 {
    public  String[] lasts = {"Zero","One","Two","Three","Four",
            "Five","Six","Seven","Eight","Nine"};
    public String[] seconds = {"Zeors","Ones","Twenty","Thirty","Forty",
            "Fifty","Sixty","Seventy","Eighty","Ninety"};
    public Map<Integer, String> map;
    public String getName(String s){
        if(s.length() == 1){
            return  lasts[(int)(s.charAt(0) - '0')];
        }else if(s.length() == 2){
            int value = Integer.parseInt(s);
            if(value < 21){
                return map.get(value);
            }else {
                if(s.charAt(1) == '0'){
                    return seconds[(int)(s.charAt(0) - '0')];
                }else {
                    return seconds[(int) (s.charAt(0) - '0')] + " " + lasts[(int) (s.charAt(1) - '0')];
                }
            }
        }else {
            String str1 = "";
            if(s.charAt(0) != '0') {
                str1 += lasts[s.charAt(0) - '0'] + " " + "Hundred";

                if (s.charAt(1) == '0' && s.charAt(2) == '0') {
                    return str1;
                } else {
                    return str1 + " " + getName(s.substring(1, s.length()));
                }
            }else {
                return getName(s.substring(1,s.length()));
            }
        }
    }


    //Accepted ----9ms
    public String numberToWords(int num){
        map = new HashMap<>();
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(4,"Four");
        map.put(5,"Five");
        map.put(6,"Six");
        map.put(7,"Seven");
        map.put(8,"Eight");
        map.put(9,"Nine");
        map.put(10,"Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14,"Fourteen");
        map.put(15,"Fifteen");
        map.put(16,"Sixteen");
        map.put(17,"Seventeen");
        map.put(18,"Eighteen");
        map.put(19,"Nineteen");
        map.put(20,"Twenty");
        String str = Integer.toString(num);
        if(str.length() <= 3){
            return getName(str);
        }else if(str.length() <= 6){
            if(Integer.parseInt(str.substring(str.length()-3)) == 0){
                return getName(str.substring(0,str.length() - 3)) + " " + "Thousand";
            }else {
                return getName(str.substring(0, str.length() - 3)) + " " + "Thousand" + " " +
                        getName(str.substring(str.length() - 3, str.length()));
            }
        }else if(str.length() <= 9 ){
            String str1 = "";
            if(Integer.parseInt(str.substring(str.length()-6)) == 0){
                return getName(str.substring(0, str.length() - 6)) + " " + "Million";
            }
            if(Integer.parseInt(str.substring(str.length()-6, str.length()-3)) != 0){
                 str1  += getName(str.substring(str.length() - 6, str.length() - 3)) + " " +  "Thousand" + " ";
                 if(Integer.parseInt(str.substring(str.length()-3)) == 0){
                     return getName(str.substring(0, str.length() - 6)) + " " + "Million" + " " +
                             getName(str.substring(str.length() - 6, str.length() - 3)) + " " +  "Thousand";
                 }
            }
            String str2 = "";
            if(Integer.parseInt(str.substring(str.length()-3)) != 0){
                str2 += getName(str.substring(str.length()-3));
            }
            return getName(str.substring(0, str.length() - 6)) + " " + "Million" + " " +
                   str1  + str2;
        }else {
            String str1 = "";
            if(Integer.parseInt(str.substring(str.length() - 9)) == 0){
                return getName(str.substring(0,str.length() - 9)) + " " + "Billion";
            }
            String str4 = getName(str.substring(0,str.length() - 9)) + " " + "Billion" + " ";
            if(Integer.parseInt(str.substring(str.length()-9, str.length()-6)) != 0){
                str1 += getName(str.substring(str.length() -9, str.length()-6)) + " " + "Million" + " ";
                if(Integer.parseInt(str.substring(str.length()-6)) == 0){
                    return str4 +  getName(str.substring(str.length() -9, str.length()-6)) + " " + "Million";
                }
            }
            String str2 = "";
            if(Integer.parseInt(str.substring(str.length()-6, str.length()-3)) !=0){
                str2 += getName(str.substring(str.length()-6, str.length() -3)) + " " + "Thousand" + " ";
                if(Integer.parseInt(str.substring(str.length()-6)) == 0){
                    return  str4 + str1 + getName(str.substring(str.length()-6, str.length() -3)) + " " + "Thousand";
                }
            }
            String str3 = "";
            if(Integer.parseInt(str.substring(str.length()-3)) != 0){
                str3 += getName(str.substring(str.length() - 3));
            }

            return  str4 + str1 + str2 + str3;
        }
    }


    @Test
    public  void  test(){
//        int num = 1234567891;
//        int num = 1000000;
        int num = 3055000;

        long startTime = System.currentTimeMillis();
        String result = numberToWords(num);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }

}
