package algorithm.medium10;

import org.junit.Test;

/**
 * Created by youlu on 2018/11/30.
 */
public class Solution838 {

    //Accepted ----19ms
    public  String pushDominoes(String dominoes){
        double[] arr = new double[dominoes.length()];
        for(int i = 0; i < dominoes.length(); i++){
            if(dominoes.charAt(i) == 'L'){
                arr[i] = -1;
                int leftIndex = i-1;
                double leftStep = arr[i] / 2;
                while (leftIndex >= 0){
                    if(arr[leftIndex] < 0 || dominoes.charAt(leftIndex) == 'L'
                            || dominoes.charAt(leftIndex) == 'R'){
                        break;
                    }
                    arr[leftIndex] += leftStep;
                    leftIndex--;
                    leftStep /= 2;
                }
            }else if(dominoes.charAt(i) == 'R'){
                arr[i] = 1;
                double rightStep = arr[i] / 2;
                int rightIndex = i + 1;
                while (rightIndex < dominoes.length()){
                    if(dominoes.charAt(rightIndex) == 'R' ||
                            dominoes.charAt(rightIndex) == 'L'){
                        break;
                    }
                    arr[rightIndex] += rightStep;
                    rightIndex++;
                    rightStep /= 2;
                }
            }else {}
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                sb.append('.');
            }else if(arr[i] < 0){
                sb.append('L');
            }else {
                sb.append('R');
            }
        }

        return  sb.toString();
    }


    @Test
    public void  test(){
//        String dominoes = ".L.R...LR..L..";
        String dominoes = "RR.L";

        long startTime = System.currentTimeMillis();
        String result = pushDominoes(dominoes);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
