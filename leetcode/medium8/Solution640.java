package algorithm.medium8;

import org.junit.Test;

/**
 * Created by youlu on 2018/10/25.
 */
public class Solution640 {

    //Accepted ---5ms
    /*
        ugly code
     */
    public  boolean isDigit(char ch){
        if(ch >= '0' && ch <= '9'){
            return  true;
        }
        return  false;
    }

    public  String solveEquation(String equation){
        String[] equations = equation.split("=");
        int leftCoefficient = 0, rightCoefficient = 0;
        int leftIndex = 0, rightIndex = 0;
        int leftValue = 0, rightValue = 0;

        while (leftIndex < equations[0].length()){
            if(equations[0].charAt(leftIndex) == 'x'){
                if(leftIndex > 0 && equations[0].charAt(leftIndex - 1) == '-'){
                    leftCoefficient--;
                }else {
                    leftCoefficient++;
                }
                leftIndex++;
                continue;
            }
            if(isDigit(equations[0].charAt(leftIndex))){
                int temp = leftIndex + 1;
                while ((temp < equations[0].length()) && (
                        isDigit(equations[0].charAt(temp))
                )){
                    temp++;
                }
                String subStr = equations[0].substring(leftIndex,temp);
                if(temp < equations[0].length() && equations[0].charAt(temp) == 'x'){
                    if((leftIndex > 0) && equations[0].charAt(leftIndex-1) == '-'){
                        leftCoefficient -= Integer.parseInt(subStr);
                    }else {
                        leftCoefficient += Integer.parseInt(subStr);
                    }
                    temp++;
                }else {
                    if((leftIndex > 0) && equations[0].charAt(leftIndex-1) == '-'){
                        leftValue -= Integer.parseInt(subStr);
                    }else {
                        leftValue += Integer.parseInt(subStr);
                    }
                }
                leftIndex = temp;
            }else {
                leftIndex++;
            }
        }

        while (rightIndex < equations[1].length()){
            if(equations[1].charAt(rightIndex) == 'x'){
                if(rightIndex > 0 && equations[1].charAt(rightIndex-1) == '-'){
                    rightCoefficient--;
                }else {
                    rightCoefficient++;
                }
                rightIndex++;
                continue;
            }

            if(isDigit(equations[1].charAt(rightIndex))){
                int temp = rightIndex + 1;
                while ((temp < equations[1].length()) && (
                        isDigit(equations[1].charAt(temp))
                )){
                    temp++;
                }
                String subStr = equations[1].substring(rightIndex,temp);
                if(temp < equations[1].length() && equations[1].charAt(temp) == 'x'){
                    if((rightIndex > 0) && equations[1].charAt(rightIndex-1) == '-'){
                        rightCoefficient -= Integer.parseInt(subStr);
                    }else {
                        rightCoefficient += Integer.parseInt(subStr);
                    }
                    temp++;
                }else {
                    if((rightIndex > 0) && equations[1].charAt(rightIndex-1) == '-'){
                        rightValue -= Integer.parseInt(subStr);
                    }else {
                        rightValue += Integer.parseInt(subStr);
                    }
                }
                rightIndex = temp;
            }else {
                rightIndex++;
            }
        }
        int totalValue = rightValue - leftValue;
        int totalCoefficient = leftCoefficient - rightCoefficient;
        if(totalCoefficient == 0 && totalValue != 0){
            return "No solution";
        }else if(totalCoefficient == 0 && totalValue == 0){
            return "Infinite solutions";
        }else {
            return "x="+Integer.toString(totalValue / totalCoefficient);
        }
    }
    @Test
    public  void  test(){
//        String equation = "x+5-3+x=6+x-2";
//        String equation = "x=x";
//        String equation = "2x=x";
//       String equation = "2x+3x-6x=x+2";
//        String equation = "x=x+2";
        String equation = "-x=-1";
        String result = solveEquation(equation);
        System.out.print(result);

    }
}
