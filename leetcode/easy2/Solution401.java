package interview.easy2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/7/4 0004.
 */
public class Solution401 {
    //Accepted --------4ms
    public List<String> chooseHouse(int num1){
        if(num1 == 0){
            return  new ArrayList<String>(){{add("0");}};
        }
        else if(num1 == 1){
            return  new ArrayList<String>(Arrays.asList("1","2","4","8"));
        }else  if(num1 == 2){
            return  new ArrayList<String>(Arrays.asList("3","5","6","9","10"));
        }else if(num1 == 3){
            return  new ArrayList<String>(){{add("11");
            add("7");}};
        }else {
            return  null;
        }
    }
    public  List<String> chooseMiniter(int num2){
        if(num2 == 0){
            return  new ArrayList<String>(){{add("00");}};
        }else if(num2 == 1){
            return  new ArrayList<String>(Arrays.asList("01","02","04","08","16","32"));
        }else if(num2 == 2){
            return new ArrayList<String>(Arrays.asList("03","05","06","09","10","12","17","18","20",
                    "24","33","34","36","40","48"));
        }else  if(num2 == 3){
            return  new ArrayList<String>(Arrays.asList("07","11","13","14","19","21","22","25","26","28",
                    "35","37","38","41","42","44","49","50","52","56"));
        }else if(num2 == 4){
            return  new ArrayList<String>(Arrays.asList("15","23","27","29","30","39","43","45","46","51","53","54","57","58"));
        }else if(num2 == 5){
            return new ArrayList<String>(){{add("59");add("55"); add("47"); add("31");}};
        }else {
            return  null;
        }
    }
    public List<String> readBinaryWatch(int num){

       if( num > 8){return  new ArrayList<String>();}
        List<String> result = new ArrayList<>();
        List<String> hour;
        List<String> minuter;
        for(int i = 0; i <= 3; i++){
            hour = chooseHouse(i);
            if((num - i >= 0) && (num - i < 6)){
                minuter = chooseMiniter(num - i);
            }else if(num -i > 5){
                continue;
            }else {
                break;
            }
            for(int hourIndex = 0; hourIndex < hour.size(); hourIndex++){
                for(int minuterIndex = 0; minuterIndex < minuter.size();minuterIndex++){
                    String  temp = hour.get(hourIndex) + ":" + minuter.get(minuterIndex);
                    result.add(temp);
                }
            }
        }
        return  result;
    }

    @Test
    public  void  test(){
        List<String> l = readBinaryWatch(4);
        System.out.println(l.size());
        for(int i = 0; i < l.size(); i++){
            System.out.print(l.get(i) + "  ");
        }
    }

}
