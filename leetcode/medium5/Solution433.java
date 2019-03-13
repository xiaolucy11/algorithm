package algorithm.medium5;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by youlu on 2018/10/4.
 */
public class Solution433 {
    public  boolean oneMutaion(String str1, String str2){
        int count = 0;
        for(int i = 0; i < str1.length();i++){
            if(str1.charAt(i) != str2.charAt(i)){
                count++;
            }
        }
        if(count == 1){
            return  true;
        }else {
            return  false;
        }
    }

    public  int minTransfer;
    public  void search(String start,String end, String[] bank, Set<String> set ){
        if(set.size() > bank.length){
           return;
        }
        if(start.equals(end)){
            if(minTransfer > set.size()){
                minTransfer = set.size();
            }
            return;
        }

        for(int i = 0; i < bank.length; i++){
            if(oneMutaion(start, bank[i]) && !set.contains(bank[i])){
                set.add(bank[i]);
                search(bank[i], end, bank, set);
                set.remove(bank[i]);
            }
        }
    }

    //Accepted -----2ms
    public  int minMutation(String start, String end, String[] bank){
        minTransfer = Integer.MAX_VALUE;
        search(start,end,bank, new HashSet<>());
        if(minTransfer != Integer.MAX_VALUE){
            return  minTransfer;
        }else {
            return -1;
        }
    }

    @Test
    public  void  test(){
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC","AAACCCCC","AACCCCCC"};
        long startTime = System.currentTimeMillis();
        int result = minMutation(start, end, bank);
        long endTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("runnint time : " + (endTime - startTime));;
    }
}
