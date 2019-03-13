package algorithm.medium7;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/17.
 */
public class Solution537 {

    //Accepted ----5ms
    public String complexNumberMultiply(String a, String b){
        String[] aPatition = a.split("\\+");
        String[] bPatition = b.split("\\+");
        int numberA = Integer.parseInt(aPatition[0]);
        int numberB = Integer.parseInt(bPatition[0]);
        int complexA = Integer.parseInt(aPatition[1].substring(0,aPatition[1].length() -1));
        int complexB = Integer.parseInt(bPatition[1].substring(0,bPatition[1].length()-1));
        int resultNumber = numberA * numberB - complexA * complexB;
        int resultComplxt = numberA * complexB + numberB * complexA;
        String result = Integer.toString(resultNumber);
        result += Character.toString('+');
        result += Integer.toString(resultComplxt);
        result += Character.toString('i');
        return result;
    }

    @Test
    public  void  test(){
     /*   String a = "1+1i";
        String b = "1+1i";*/
     String a = "1+-1i";
        String b = "1+-1i";
        String result = complexNumberMultiply(a,b);
        System.out.print(result);
    }
}
