package interview.medium2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/4 0004.
 */
public class Solution131 {
    public boolean isPalindrome(String s){
        int left = 0, right = s.length()-1;
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return  false;
            }else {
                left++;
                right--;
            }
        }
        return  true;
    }


    public  void  search(List<List<String>> strLists, List<String> list, String s, int start ,int end){
        if(start > end){
            strLists.add(list);
            return;
        }
        for(int i = start; i <= end; i++){
            String subStr = s.substring(start, i+1);
            if(isPalindrome(subStr)){
                List<String > temp = new ArrayList<>();
                temp.addAll(list);
                temp.add(subStr);
                search(strLists, temp, s, i+1, end);
            }
        }
    }

    //Accepted ------11ms
    public List<List<String>>  partition(String s){
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();

        search(result, list, s, 0, s.length()-1);
        return  result;
    }


    /*
        reference from other
        list.add(), then remove it, finally to construct same list for adding to result
     */
    public void process(String s, int index, List<String> list){
        if(index==s.length()){
 //           res.add(new ArrayList<>(list));
        }
        else{
            for(int i = index; i<s.length(); i++){
         //       if(isPalindrome(s,index,i)){
                    list.add(s.substring(index,i+1));
                    process(s,i+1,list);
                    list.remove(list.size()-1);
                }
            }
        }


    @Test
    public  void test(){
        String s = "aab";
        List<List<String>> partionList = partition(s);

        for(int i = 0; i < partionList.size(); i++){
            for(int j = 0; j < partionList.get(i).size(); j++){
                System.out.print(partionList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
