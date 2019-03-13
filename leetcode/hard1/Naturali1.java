package algorithm.hard1;

import org.junit.Test;


public class Naturali1 {
    /*
        time complexity : O(min(n,m))
     */
    public  String combine(String a, String b){
        int  indexA = a.length() - 1;
        int indexB = 0;
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        while( (indexA >= 0) && (indexB < b.length())){
            if (aArray[indexA] == bArray[indexB]){
                indexA--;
                indexB++;
            }
            else{
                break;
            }
        }
        return a.substring(0,indexA+1) + b.substring(indexB, b.length());
    }

    @Test
    public  void  test(){
        String a = "abcdef";
        String b = "fedha";

        String result = combine(a,b);
        System.out.println("result : " + result);
    }
}
