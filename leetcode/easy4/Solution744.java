package interview.easy4;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/31 0031.
 */
public class Solution744 {
    //Accepted ---7ms
    public char nextGreatestLetter(char[] letters, char target){
        int index = 0;
        int flag = 0;
        while (index < letters.length){
            if(letters[index] > target){
                flag = 1;
                break;
            }else {
                index++;
            }
        }
        if(flag == 1){
            return  letters[index];
        }else {
            return  letters[0];
        }
    }

    @Test
    public  void  test(){
        char[] letters = {'c', 'f', 'j'};
        char target = 'k';
        System.out.print(nextGreatestLetter(letters, target));
    }
}
