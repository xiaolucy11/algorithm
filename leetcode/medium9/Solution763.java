package algorithm.medium9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/11/8.
 */
public class Solution763 {

    //Wrong Solution
    public List<Integer> partitionLabels(String S){
        List<Integer> list = new ArrayList<>();
        int[] starts = new int[26];
        int[] ends = new int[26];

        for(int i = 0; i < 26; i++){
            starts[i] = -1;
            ends[i] = -1;
        }

        for(int i = 0; i < S.length(); i++){
            int index = (int)(S.charAt(i) - 'a');
            if(starts[index] == -1){
                starts[index] = i;
            }else {
                ends[index] = i;
            }
        }

        for(int i = 0; i < 26; i++){
            if(starts[i] != -1&& ends[i] == -1){
                ends[i] = starts[i];
            }
        }

        int start = starts[S.charAt(0) - 'a'], end = ends[S.charAt(0) - 'a'];
        starts[S.charAt(0) - 'a'] = -1;
        ends[S.charAt(0) - 'a'] = -1;


        for(int i = 0; i < 26; i++){
            int v1 = starts[i];
            int v2 = ends[i];
            if(v1 == -1 && v2 == -1){
                continue;
            }

            if(v1 > end && v1 > start){
                list.add(end - start + 1);
                start = v1;
                end = v2;
            }else {
                if(v1 < start){
                    start = v1;
                }
                if(v2 > end){
                    end = v2;
                }
            }
        }

        list.add(end - start + 1);
        return  list;
    }

    //Accepted ----17ms
    /*
        greedy algorithm
     */
    public List<Integer> partitionLabels1(String S){
        List<Integer> list = new ArrayList<>();
        int[] starts = new int[26];
        int[] ends = new int[26];

        for(int i = 0; i < 26; i++){
            starts[i] = -1;
            ends[i] = -1;
        }

        for(int i = 0; i < S.length(); i++){
            int index = (int)(S.charAt(i) - 'a');
            if(starts[index] == -1){
                starts[index] = i;
            }else {
                ends[index] = i;
            }
        }

        for(int i = 0; i < 26; i++){
            if(starts[i] != -1&& ends[i] == -1){
                ends[i] = starts[i];
            }
        }

        int start = starts[S.charAt(0) - 'a'], end = ends[S.charAt(0) - 'a'];
        for(int i = 0; i < S.length(); i++){
            if(i == end){
                list.add(end - start + 1);
                if(i + 1 < S.length()) {
                    start = starts[S.charAt(i+1) - 'a'];
                    end = ends[S.charAt(i+1) - 'a'];
                }else {
                    start = S.length();
                    break;
                }
            }else{
                int v = S.charAt(i) - 'a';
                if(ends[v] > end){
                    end = ends[v];
                }
            }
        }

        if(start < S.length()) {
            list.add(end - start + 1);
        }
        return list;

    }

    @Test
    public  void  test(){
        String S = "ababcbacadefegdehijhklij";
//        String S = "caedbdedda";
//        String  S = "eaaaabaaec";
//        String S = "dccccbaabe";

        List<Integer> result = partitionLabels1(S);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + "  ");
        }
    }
}
