package interview.easy;

import org.junit.Test;
import sun.awt.AWTAccessor;

/**
 * Created by Administrator on 2018/6/3 0003.
 */
public class Solutin14 {
    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        int minLen = 100000, strsLen = strs.length;
        for(int i = 0; i < strsLen; i++){
            if (strs[i].length() < minLen){
                minLen = strs[i].length();
            }
        }
        if(minLen ==1){
            for(int i = 1; i < strsLen; i++){
                if(strs[i].charAt(0) != strs[0].charAt(0)){
                    return "";
                }
            }
        }
        for(int i = 1; i <= minLen; i++){
            String commonStr = strs[0].substring(0,i);
            System.out.println(commonStr);
            for(int j = 1; j < strsLen; j++){
                //System.out.println(strs[j].substring(0,i));
                if(!commonStr.equals(strs[j].substring(0, i))){
                    return strs[0].substring(0, i-1);
                }
            }
        }
        return strs[0].substring(0, minLen+1);
    }

    @Test
    public void test(){
        String[] strs = new String[]{"flower","flow","flight"};
        //String[] strs = new String[]{"dog","racecar","car"};
        String result = longestCommonPrefix(strs);
        System.out.println(result );
    }
}
