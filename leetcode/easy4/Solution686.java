package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/26 0026.
 */
public class Solution686 {
    public  boolean match(StringBuilder a, String b){
        int indexa = 0, indexb = 0;
        while (indexa < a.length()){
            if(a.charAt(indexa) == b.charAt(indexb)){
                int temp = indexa;
                int flag = 0;
                while (temp < a.length() &&  indexb < b.length()){
                    if(a.charAt(temp) == b.charAt(indexb)){
                        temp++;
                        indexb++;
                    }else {
                        flag = 1;
                        break;
                    }
                }
                if(indexb == b.length()){
                    return  true;
                }else {
                    indexa++;
                    indexb = 0;
                }
            }else {
                indexa++;
                indexb = 0;
            }
        }
        if(indexb == b.length()){return  true;}
        else {return  false;}
    }

    public  boolean sameChar(String b){
        for(int i = 1; i < b.length(); i++){
            if(b.charAt(i) != b.charAt(0)){
                return  false;
            }
        }
        return  true;
    }


    //Accepted ------31ms
    // not goog problem..........
    public  int repeatedStringMatch(String A, String B){
        if(sameChar(B) && sameChar(A)){
            if(B.charAt(0) == A.charAt(0)){
                if(A.length() >= B.length()){return 1;}
                else {
                    int div = B.length() / A.length();
                    if(div * A.length() == B.length()){
                        return div;
                    }else{
                        return div + 1;
                    }
                }
            }else {
                return  -1;
            }
        }else if((sameChar(A) && !sameChar(B)) || (!sameChar(A) && sameChar(B))){
            return -1;
        }
        StringBuilder aBuilder = new StringBuilder(A);
        int count = 1;
        int indexA = 0;
        int indexB = 0;
        while (indexA < aBuilder.length()){
            if(aBuilder.charAt(indexA) != B.charAt(indexB)) {
                indexA++;
            }else {
                break;
            }
        }
        if(indexA == aBuilder.length()){return  -1;}


        while (true){
          if(match(aBuilder, B)){
              return  count;
          }else {
              if(aBuilder.length() >= 2 * B.length()){
                  return  -1;
              }else {
                  count++;
                  aBuilder.append(A.toCharArray());
              }
          }
        }
    }
    @Test
    public  void  test(){
        String A = "a";
        String B = "aa";
        System.out.print(repeatedStringMatch(A, B));
    }
}
