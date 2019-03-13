package algorithm.medium7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by youlu on 2018/10/22.
 */
public class Solution609 {

    //Accepted ---51ms
    public List<List<String>> findDuplicate(String[] paths){
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < paths.length; i++){
            String[] files = paths[i].split("\\s");
            String directory = files[0];
            for(int j = 1; j < files.length; j++){
                int index = 0;
                while((index < files[j].length()) && (files[j].charAt(index) != '(') ){
                    index++;
                }
                String fileName = files[j].substring(0,index);
                String fileContent = files[j].substring(index+1, files[j].length());

                if(map.containsKey(fileContent)){
                    List<String> l = map.get(fileContent);
                    l.add(directory + "/" + fileName);
                    map.put(fileContent,l);
                }else {
                    List<String> stringList = new ArrayList<>();
                    stringList.add(directory + "/" + fileName);
                    map.put(fileContent, stringList);
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet()){
            List<String> input = map.get(key);
            if(input.size()  > 1){
                result.add(input);
            }
        }
        return  result;
    }

    @Test
    public  void  test(){
        String[] paths = new String[4];
        paths[0] = "root/a 1.txt(abcd) 2.txt(efgh)";
        paths[1] = "root/c 3.txt(abcd)";
        paths[2] = "root/c/d 4.txt(efgh)";
        paths[3] = "root 4.txt(efgh)";

        long startTime = System.currentTimeMillis();
        List<List<String>> result = findDuplicate(paths);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + "  ");
            }
            System.out.println();
        }
    }
}
