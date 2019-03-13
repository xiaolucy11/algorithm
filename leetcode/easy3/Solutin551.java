package interview.easy3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/17 0017.
 */
public class Solutin551 {


    //Accepted --------6ms
    public  boolean checkRecord(String s){
        int absentCount = 0;
        int lateCount = 0;
        int lateIndex = 0;
        int maxCount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'L' && s.charAt(lateIndex) != 'L'){
                lateIndex = i;
            }else  if(s.charAt(i) != 'L' && s.charAt(lateIndex) == 'L'){
                if(i - lateIndex > maxCount){
                    maxCount = i - lateIndex;
                    if(maxCount > 2){return  false;}
                }
                lateIndex = i;
            }else {

            }

            if(s.charAt(i) == 'A'){
                absentCount++;
            }
        }
        while (lateIndex < s.length() &&s.charAt(lateIndex) == 'L'){
            lateCount++;
            lateIndex++;
        }
        if(absentCount > 1 || lateCount > 2){
            return  false;
        }else {
            return  true;
        }
    }


    @Test
    public  void  test(){
        String s = "LPLPLPLPLP";
        System.out.print(checkRecord(s));
    }
}
