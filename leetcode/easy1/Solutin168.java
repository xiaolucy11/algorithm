package interview.easy1;

import org.junit.Test;

/**
 * Created by Administrator on 2018/6/18 0018.
 */
public class Solutin168 {

    public String convertToTitle(int n){
            String  str = "ZABCDEFGHIJKLMNOPQRSTUVWXY";
            String result = "";
            if((n > 0 ) && ( n < 26)){
                result += str.charAt(n);
                return  result;
            }
            if(n == 26){return "Z";}
            int multiply = n / 26;
            int mod = n % 26;
            if ( multiply > 0 && multiply < 26){
                if(mod > 0) {
                    result += str.charAt(multiply);
                    result += str.charAt(mod);
                    return result;
                }else {
                    result += str.charAt(multiply - 1);
                    result += "Z";
                    return  result;
                }
            }
            String temp = convertToTitle(multiply);
            result += temp;
            result += str.charAt(mod);
            return  result;
        }

        @Test
        public  void  test(){
            String result = convertToTitle(65535);
            System.out.print(result);
        }
    }

