package interview.easy4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/2 0002.
 */
public class Solution788 {
    public List<Integer> toDigits(int num){
        List<Integer> result = new ArrayList<>();
        while (num > 9){
            int mod = num % 10;
            int div = num / 10;
            result.add(mod);
            num = div;
        }
        result.add(num);
        return  result;
    }

    public  int toSum(List<Integer> list){
        int sum = 0;
        int muultiply = 1;
        for(int i = list.size() - 1; i >= 0; i++){
            sum += list.get(i) * muultiply;
            muultiply *= 10;
        }
        return  sum;
    }

    public  boolean judge(int num){
        List<Integer> list  = toDigits(num);
        int count1 = 0, count2 = 0;
        for(int i = 0; i < list.size(); i++){
            if((list.get(i) == 2) || (list.get(i) == 5) || (list.get(i) == 6)
                    || (list.get(i) == 9)){
                count1++;
            }
            if ((list.get(i) == 3) || (list.get(i) == 4) || (list.get(i) == 7)) {
                count2++;
            }
        }
        if(count1 > 0 && count2 == 0){
            return  true;
        }else {
            return false;
        }
    }


    //Accepted --- 32ms
    public  int rotatedDigits(int N){
        int count = 0;
        for(int i = 2; i <= N; i++){
            if(judge(i)){
                count++;
                //System.out.println("valid number :" + i);
            }
        }
        return  count;
    }

    //other solution
    public  boolean isValid(int num){
        boolean valid = false;
        while (num > 0){
            if(num % 10 == 2) { valid = true;}
            if(num % 10 == 5) {valid =   true;}
            if(num % 10 == 6 ) { valid =   true;}
            if(num % 10 == 9){valid =  true;}
            if(num % 10 == 3){return  false;}
            if(num % 10 == 4) {return  false;}
            if(num % 10 == 7){return  false;}
            num = num / 10;
        }
        return  valid;

    }


    @Test
    public  void  test1(){
        long startTime = System.currentTimeMillis();
        System.out.println(rotatedDigits(857));
        System.out.println(System.currentTimeMillis() - startTime);
    }


    @Test
    public  void  test2(){
        List<Integer> list = toDigits(857);
        for(int i =  0; i < list.size(); i++){
            System.out.print(list.get(i) + "  ");
        }
    }
}
