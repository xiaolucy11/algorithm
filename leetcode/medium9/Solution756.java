package algorithm.medium9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/11/8.
 */
public class Solution756 {

    public  void  produce(List<List<String>> lists, int index, int length,
                          StringBuilder stringBuilder, List<String> produceStringList){
        if(index == length){
            produceStringList.add(stringBuilder.toString());
            return;
        }
        for(int i = 0; i < lists.get(index).size(); i++){
            stringBuilder.append(lists.get(index).get(i).charAt(2));
            produce(lists, index+1, length, stringBuilder, produceStringList);
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
        }
    }

    //Accepted ----21ms
    /*
        search algorithm
     */
    public  boolean pyramidTransition(String bottom, List<String> allowed){
        if(bottom.length() == 1){
            return  true;
        }
        List<String> produceStringList = new ArrayList<>();
        List<List<String>> lists = new ArrayList<>();
        for(int i = 1; i < bottom.length(); i++){
            String str = bottom.substring(i-1,i+1);
            List<String> list = new ArrayList<>();
            for(int j = 0; j < allowed.size(); j++){
                if(str.equals(allowed.get(j).substring(0,2))){
                    list.add(allowed.get(j));
                }
            }
            if(list.size() == 0){
                return  false;
            }

            lists.add(list);
        }

        produce(lists,0,bottom.length() - 1,new StringBuilder(), produceStringList);

        for(int i = 0; i < produceStringList.size(); i++){
            if(pyramidTransition(produceStringList.get(i),allowed)){
                return  true;
            }
        }

        return  false;
    }

    @Test
    public  void  test(){
        String bottom = "XYZ";
        List<String> allowed = new ArrayList<>();
        allowed.add("XYD");
        allowed.add("YZE");
        allowed.add("DEA");
        allowed.add("FFF");

      /* String bottom = "XXYX";
        List<String> allowed = new ArrayList<>();
        allowed.add("XXX");
        allowed.add("XXY");
        allowed.add("XYX");
        allowed.add("XYY");
        allowed.add("YXZ");
*/
        long startTime = System.currentTimeMillis();
        boolean b = pyramidTransition(bottom, allowed);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + b);
        System.out.println("running time : " + (endTime -startTime));
    }
}
