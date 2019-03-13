package interview.easy4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/31 0031.
 */
public class Solution762 {
    public List<Integer> toBits(int nums){
        List<Integer> result = new ArrayList<>();
        while (nums > 1){
            int mod = nums % 2;
            int div = nums / 2;
            result.add(mod);
            nums = div;
        }
        result.add(nums);
        return  result;
    }

    public  boolean isPrime(int num){
        if((num == 2) || (num == 3 ) || (num == 5) || (num == 7) || (num == 11)
                || (num == 13) || (num == 17) || (num == 19)){
            return  true;
        }else {
            return  false;
        }
    }

    public  boolean judge(int num){
        List<Integer> list = toBits(num);
        int oneCount = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == 1){
                oneCount++;
            }
        }
        return isPrime(oneCount);
    }

    public  int computeOne(int num){
        int count = 0;
        while (num > 0){
            count++;
            num = (num - 1) & num;
        }
        return  count;
    }

    //Accepted ----181ms
    public  int countPrimeSetBits(int L, int R){
        int count = 0;
        for(int i = L; i <= R; i++){
            if(judge(i)){
                count++;
            }
        }
        return  count;
    }

    //Accoted ---24ms
    public  int countPrimeSetBits1(int L, int R){
        int count = 0;
        for(int i = L; i <= R; i++){
            int value = computeOne(i);
            if(isPrime(value)){
                count++;
            }
        }
        return  count;
    }

    @Test
    public  void  test(){
        System.out.print(countPrimeSetBits(10, 15));
    }
}
