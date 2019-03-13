package algorithm.hard3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution546 {
    private String toStr(String[] words,int start, int end){
        if(start > end){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(words[start]);
        for(int i = 1 + start; i <= end; i++){
            sb.append('-');
            sb.append(words[i]);
        }
        return sb.toString();
    }

    private int search(String str){
        if(str.equals("")){
            return 0;
        }
        String[] words = str.split("-");
        int start = 0, end = 0;
        int max = 0;
        while (end < words.length){
            if(words[end].equals(words[start])){
                end++;
            }else {
                int step = end - start;
                String leftStr = toStr(words,0,start - 1);
                String rightStr = toStr(words,end, words.length -1);
                String newStr = "";
                if(leftStr.equals("")){
                    newStr = rightStr;
                }else {
                    newStr = leftStr + "-" + rightStr;
                }
                int value = 0;
                if(map.containsKey(newStr)){
                    value = map.get(newStr);
                }else {
                    value = search(newStr);
                }
                max = Math.max(max, step * step + value);
                start = end;
            }
        }
        if(start != end){
            String temp = toStr(words,0, start - 1);
            int vvalue = 0;
            if(map.containsKey(temp)){
                vvalue = map.get(temp);
            }else {
                vvalue = search(temp);
            }
            max = Math.max(max,(end - start) * (end - start) + vvalue);
        }
        map.put(str,max);
        return max;
    }


    //Time Limited Exceed
    /*
        pass 20/60 test case
        many time is consumed on constructing new string
     */
    public Map<String, Integer> map;
    public int removeBoxes(int[] boxes){
        map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append(boxes[0]);
        for(int i = 1; i < boxes.length; i++){
            sb.append('-');
            sb.append(boxes[i]);
        }
        return search(sb.toString());
    }

    public int help(int[] boxes, int left, int right, int appendCount){
        if(left > right){
            return 0;
        }
        while (left < right && boxes[right-1] == boxes[right]){
            right--;
            appendCount++;
        }
        int key = (left * 100 + right) * 100 + appendCount;
        if(mmap.containsKey(key)){
            return mmap.get(key);
        }

        //direct delete, not combine
        int res = (appendCount + 1) * (appendCount + 1) + help(boxes,left, right - 1,0);

        for(int i = left; i < right; i++){
            if(boxes[i] == boxes[right]){
                while (boxes[i+1] == boxes[right]){
                    i++;
                }
                res = Math.max(res, help(boxes,left,i, appendCount + 1)
                    + help(boxes,i + 1, right - 1,0));
            }
        }
        mmap.put(key,res);
        return  res;
    }
    public Map<Integer,Integer> mmap;


    //Accepted ----13ms
    /*
        idea from other
     */
    public int removeBoxes1(int[] boxes){
        mmap = new HashMap<>();
        return help(boxes,0,boxes.length -1,  0);
    }

    @Test
    public  void  test(){
       /* int[] boxes = {1,3,2,2,2,3,4,3,1};*/
        int[] boxes = {3, 8, 8, 5, 5, 3, 9 ,2 ,4, 4, 6, 5, 8, 4, 8, 6, 9, 6, 2, 8, 6,
    4, 1, 9, 5, 3, 10, 5, 3, 3, 9, 8, 8, 6, 5, 3, 7, 4, 9, 6, 3, 9, 4, 3, 5, 10, 7, 6, 10, 7};
//        int[] boxes = {3, 8, 8, 5, 5, 3, 9 ,2 ,4, 4, 6, 5, 8, 4, 8, 6, 9, 6, 2, 8, 6};

        long startTime = System.currentTimeMillis();
        int result = removeBoxes1(boxes);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));

    }

}
