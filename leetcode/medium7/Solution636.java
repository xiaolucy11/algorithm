package algorithm.medium7;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/10/24.
 */
public class Solution636 {
    public  class  Interval{
        int start;
        int end;
        Interval(int _start, int _end){
            start = _start;
            end = _end;
        }
    }


    //Wrong Solution
    public int[] exclusiveTime(int n, List<String> logs){
        int[] result = new int[n];
        Map<Integer, Interval> map = new TreeMap<>();

        for(int i = 0; i < logs.size(); i++){
            String[] partions = logs.get(i).split("\\:");
            int functionId = Integer.parseInt(partions[0]);
            int timeStamp = Integer.parseInt(partions[2]);
            if(map.containsKey(functionId)){
                if(partions[1].equals("end")){
                    Interval interval = map.get(functionId);
                    interval.end = timeStamp;
                }
            }else {
                Interval createInterval = new Interval(timeStamp, 0);
                map.put(functionId, createInterval);
            }
        }

        Interval startInterval = map.get(0);
        int startTime = startInterval.start;
        int endTime = startInterval.end;
        result[0] = endTime - startTime + 1;
        for(Integer key: map.keySet()){
            if(key == 0){
                continue;
            }
            Interval keyInterval = map.get(key);
            int idStartTime = keyInterval.start;
            int idEndTime =  keyInterval.end;
            if(idStartTime > startTime && idEndTime < endTime){
                result[key-1] -= (idEndTime - idStartTime + 1);
            }else {
                startTime = idStartTime;
                endTime = idEndTime;
            }
            result[key] = (idEndTime - idStartTime + 1);
        }

        return  result;
    }

    //Accepted ---59ms
    public int[] exclusiveTime1(int n, List<String> logs){
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.add(Integer.parseInt(logs.get(0).split(":")[0]));

        for(int i = 1; i < logs.size(); i++){
            String[] partions = logs.get(i).split(":");
            int functionId = Integer.parseInt(partions[0]);
            int timeStamp = Integer.parseInt(partions[2]);
            if(partions[1].equals("start")){
                String[] preLogs = logs.get(i-1).split(":");
                int preFunctionId = Integer.parseInt(preLogs[0]);
                int preStartTime = Integer.parseInt(preLogs[2]);
                if(preLogs[1].equals("start")) {
                    result[preFunctionId] += (timeStamp - preStartTime);
                }else {
                    if(!stack.isEmpty()) {
                        int lastingFunctionId = stack.peek();
                        result[lastingFunctionId] += (timeStamp - preStartTime - 1);
                    }
                }
                stack.add(functionId);
            }else {
                String[] preLogs = logs.get(i-1).split(":");
                int preFunctionId = Integer.parseInt(preLogs[0]);
                int preStartTime = Integer.parseInt(preLogs[2]);
                if(preLogs[1].equals("start")){
                    result[preFunctionId] += (timeStamp - preStartTime +1);
                }else {
                    result[functionId] += (timeStamp - preStartTime);
                }
                stack.pop();
            }
        }
        return  result;
    }

    @Test
    public  void  test(){
       /* List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");

        int n = 2;*/

     /*  int n = 8;
        List<String> logs = new ArrayList<>();
        String[] strs = {"0:start:0","1:start:5","2:start:6","3:start:9",
                "4:start:11","5:start:12","6:start:14","7:start:15","1:start:24","1:end:29","7:end:34","6:end:37","5:end:39","4:end:40","3:end:45","0:start:49","0:end:54","5:start:55","5:end:59","4:start:63","4:end:66","2:start:69","2:end:70","2:start:74","6:start:78","0:start:79","0:end:80","6:end:85","1:start:89","1:end:93","2:end:96",
                "2:end:100","1:end:102","2:start:105","2:end:109","0:end:114"};
        for(int i = 0; i < strs.length; i++){
            logs.add(strs[i]);
        }*/

     int n = 3;
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("0:end:0");
        logs.add("1:start:1");
        logs.add("1:end:1");
        logs.add("2:start:2");
        logs.add("2:end:2");
        logs.add("2:start:3");
        logs.add("2:end:3");

        long startTime = System.currentTimeMillis();
        int[] result = exclusiveTime1(n, logs);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + "   ");
        }
        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }
}
