package interview.easy5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/3 0003.
 */
public class Solution811 {

    //Accepted -----64ms
    public List<String> subdomainVisits(String[] cpdomains){
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < cpdomains.length; i++){
            String[] splitStr = cpdomains[i].split("[.\\s]");
            System.out.println("splitStr length : " + splitStr.length);
            int value = Integer.parseInt(splitStr[0]);
            //String[] words = url.split("\\.");
           if(splitStr.length == 3){
                map.put(splitStr[1] + "." + splitStr[2], map.getOrDefault(splitStr[1] + "." + splitStr[2], 0) + value);
              map.put(splitStr[2], map.getOrDefault(splitStr[2], 0) + value);
           }
            if(splitStr.length == 4){
                map.put(splitStr[1] + "." + splitStr[2] + "." + splitStr[3], map.getOrDefault(splitStr[1] + "." + splitStr[2] + "." + splitStr[3], 0) + value);
                map.put(splitStr[2] + "." + splitStr[3], map.getOrDefault(splitStr[2] + "." + splitStr[3], 0) + value);
                map.put(splitStr[3], map.getOrDefault(splitStr[3], 0) + value);
            }
        }

        List<String > result = new ArrayList<>();
        for(String str : map.keySet()){
            String temp = Integer.toString(map.get(str)) + " " + str;
            result.add(temp);
        }
        return  result;
    }

    @Test
    public  void test(){
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> result = subdomainVisits(cpdomains);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }
}
