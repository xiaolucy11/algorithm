package interview.easy5;

import org.junit.Test;

/**
 * Created by Administrator on 2018/8/2 0002.
 */
public class Solution796 {

    //Accepted -----2ms
    public  boolean rotateString(String A, String B){
        if(A.length() != B.length()){
            return  false;
        }
        int indexA = 0, indexB = 0;
        while (indexA < A.length()){
            if(A.charAt(indexA) != B.charAt(indexB)){
                indexA++;
            }else {
                int temp = indexA;
                while ((temp < A.length()) && (A.charAt(temp) == B.charAt(indexB))){
                    temp++;
                    indexB++;
                }
                if(temp == A.length()){
                    break;
                }else {
                    indexA++;
                    indexB = 0;
                }
            }
        }
        if(indexA == A.length()){
            return  false;
        }
        indexA--;
        indexB = B.length() - 1;
        while (indexA >= 0){
            if(A.charAt(indexA) != B.charAt(indexB)){
                return  false;
            }
            indexA--;
            indexB--;
        }
        return true;
    }

    @Test
    public  void  test(){
        String A = "vcuszhlbtpmksjleuchmjffufrwpiddgyynfujnqblngzoogzg";
        String B =  "fufrwpiddgyynfujnqblngzoogzgvcuszhlbtpmksjleuchmjf";
        System.out.print(rotateString(A, B));
    }
}
