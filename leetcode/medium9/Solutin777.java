package algorithm.medium9;

import org.junit.Test;

/**
 * Created by youlu on 2018/11/11.
 */
public class Solutin777 {

    //Accepted ----6ms
    /*
        time complextity O(n)
     */
    public  boolean canTransform(String start, String end){
        char[] startChars = start.toCharArray();
        char[] endChars = end.toCharArray();

        for(int i = 0; i < start.length(); i++){
            if(startChars[i] != endChars[i]){
                if(startChars[i] == 'R' && endChars[i] == 'X'){
                    int index = i + 1;
                    while ((index < start.length()) && (startChars[index] == startChars[i])){
                        index++;
                    }

                    if(index < start.length() && startChars[index] == 'X'){
                        startChars[i] = 'X';
                        startChars[index] = 'R';
                    }else {
                        return  false;
                    }
                }else if(startChars[i] == 'X' && endChars[i] == 'L'){
                    int index = i + 1;
                    while ((index < start.length()) && (startChars[index] == startChars[i])){
                        index++;
                    }

                    if(index < start.length() && startChars[index] == 'L'){
                        startChars[i] = 'L';
                        startChars[index] = 'X';
                    }else {
                        return  false;
                    }
                }else {
                    return  false;
                }
            }

        }

        return  true;
    }


    @Test
    public  void  test(){
        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";

     /*  String start = "XXXXXLXXXX";
        String end = "LXXXXXXXXX";*/

        boolean b = canTransform(start, end);
        System.out.println("result : " + b);
    }
}
