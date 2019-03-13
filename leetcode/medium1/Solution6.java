package interview.medium1;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 2018/8/8 0008.
 */
public class Solution6 {

    //Accepted --------81ms
    public  String convert(String s, int numRows){
        if(numRows == 1){
            return  s;
        }

        int length = s.length();
        char[][] arr = new char[numRows][length];

        int row = 0, col = 0;
        for(int i = 0; i < s.length(); i++){
            if((col % (numRows - 1) == 0) && (row < numRows)){
                arr[row++][col] = s.charAt(i);
            }else if((col % (numRows - 1) == 0) && (row == numRows)){
                row  -= 2;
                col++;
                arr[row][col] = s.charAt(i);
                if (row > 0 ){
                    row--;
                    col++;
                }else {
                    row++;
                }
            }else {
                arr[row--][col++] = s.charAt(i);
            }
        }
        String result = "";
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < length; j++){
                System.out.print(arr[i][j]);
                if(arr[i][j] != '\0' ){
                    result += Character.toString(arr[i][j]);
                }
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        return  result;
    }


    //Accepted -------68ms
    // using StringBuider to decrease running time
    public  String convert1(String s, int numRows){
        int diff = numRows * 2 - 2;
        int changeDiff = diff - 2;
        int index = 0;
        String result = "";
        while (index < s.length()){
            result += Character.toString(s.charAt(index));
            index += diff;
        }
        index = 1;
        while (index < numRows - 1){
           /* queue.add(index);
            while (!queue.isEmpty()){
                int i = queue.peek();
                result += Character.toString(s.charAt(i));
                if(i + changeDiff < s.length() && changeDiff != diff){
                    queue.add(i + changeDiff);
                }
                if(i + diff < s.length()){
                    queue.add( i + diff);
                }
            }*/
           int mul = 1;
            int first = index;
            int second = index + changeDiff;

            while (true) {
                if(first < s.length()){
                    result += Character.toString(s.charAt(first));
                    first += diff;
                }else {
                    break;
                }

                if(second < s.length()){
                    result += Character.toString(s.charAt(second));
                    second += diff;
                }else {
                    break;
                }
            }
            index++;
            changeDiff -= 2;
        }
        index = numRows - 1;
        while (index < s.length()){
            result += Character.toString(s.charAt(index));
            index += diff;
        }
        return  result;
    }

    @Test
    public  void  test(){
       //String s = "PAYPALISHIRING";
        String s = "ABCD";
        String result1 = convert(s, 2);
        String result2 = convert1(s, 2);
        System.out.print("result1 : " + result1 + "  result2 : " + result2 + "  " +result1.equals(result2));
    }
}
