package algorithm.medium10;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by youlu on 2018/11/30.
 */
public class Solution833 {


    //Accepted -----6ms
    public String findReplaceString(String S, int[] indexes,String[] sources,String[] targets){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < indexes.length; i++){
            map.put(indexes[i], i);
        }

        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < S.length()){
            if(map.containsKey(index)){
                String replaceStr = sources[map.get(index)];
                if((replaceStr.length() <= S.length() - index) && (
                        S.substring(index, replaceStr.length() + index).equals(replaceStr)
                        )){
                    sb.append(targets[map.get(index)]);
                    index += replaceStr.length() ;
                }else {
                    sb.append(S.charAt(index));
                    index++;
                }
            }else {
                sb.append(S.charAt(index));
                index++;
            }
        }

        return  sb.toString();
    }



    @Test
    public  void  test(){
        String S = "abcd";
        int[] indexes = {0,2};
        String[] sources = {"ab","ec"};
        String[] targets = {"eee", "ffff"};


        long startTime = System.currentTimeMillis();
        String result = findReplaceString(S,indexes, sources, targets);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
