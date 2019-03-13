package algorithm.medium10;

import org.junit.Test;

/**
 * Created by youlu on 2018/11/18.
 */
public class Solution808 {
    /*public  double totalProbability;
    public  void  search(int aVolume, int bVolume, double probability){
        if(aVolume > 0 && bVolume <= 0){
            return;
        }else if(aVolume <= 0 && bVolume > 0){
            totalProbability += probability;
            return;
        }else if(aVolume <= 0 && bVolume <= 0){
            totalProbability += 0.5 * probability;
        }else {
            search(aVolume-100, bVolume, probability*0.25);
            search(aVolume-75, bVolume-25, probability*0.25);
            search(aVolume-50,bVolume-50,probability*0.25);
            search(aVolume-25,bVolume-75,probability*0.25);
        }

    }
    public double soupServings(int N) {
        totalProbability = 0.0;
        search(N,N,1);
        return  totalProbability;
    }*/
    public  double  search(double[][] matrix,int aVolume, int bVolume){
        double sum = 0.0;

        if(aVolume-100 <=0 && bVolume > 0){
            sum += 0.25;
        }else if(aVolume - 100 >= 0 && bVolume <= 0){
            sum += 0.0;
        }else {
            if(matrix[aVolume-100][bVolume] == 0){
                double result1 = search(matrix,aVolume-100,bVolume);
                sum += result1 * 0.25;
            }else {
                sum += matrix[aVolume-100][bVolume] * 0.25;
            }
        }

        if(aVolume-75 <= 0 && bVolume - 25 > 0){
            sum += 0.25;
        }else if(aVolume - 75 <= 0 && bVolume - 25 <= 0){
            sum += 0.25 * 0.5;
        }else if(aVolume - 75 > 0 && bVolume - 25 <= 0){
            sum += 0;
        } else {
            if(matrix[aVolume-75][bVolume-25] == 0){
                double result2 = search(matrix,aVolume-75,bVolume-25);
                sum += result2 * 0.25;
            }else {
                sum += matrix[aVolume-75][bVolume-25] * 0.25;
            }
        }

        if(aVolume-50 <= 0 && bVolume - 50 > 0){
            sum += 0.25;
        }else if(aVolume - 50 <= 0 && bVolume - 50 <= 0){
            sum += 0.25 * 0.5;
        }else if(aVolume - 50 > 0 && bVolume - 50 <= 0){
            sum += 0;
        } else {
            if(matrix[aVolume-50][bVolume-50] == 0){
                double result3 = search(matrix,aVolume-50,bVolume-50);
                sum += result3 * 0.25;
            }else {
                sum += matrix[aVolume-50][bVolume-50] * 0.25;
            }
        }

        if(aVolume - 25 <= 0 && bVolume - 75 > 0){
            sum += 0.25;
        }else if(aVolume - 25 <= 0 && bVolume - 75 <= 0){
            sum += 0.25 * 0.5;
        }else if(aVolume - 25 > 0 && bVolume - 75 <= 0){
            sum += 0;
        } else {
            if(matrix[aVolume-25][bVolume - 75] == 0){
                double result4 = search(matrix,aVolume-25,bVolume-75);
                sum += result4 * 0.25;
            }else {
                sum += matrix[aVolume-25][bVolume-75] * 0.25;
            }
        }

        matrix[aVolume][bVolume] = sum;
        return  sum;
    }

    //Accepted ---- 23ms
    /*
        dp alogrithm and memorizatin
        not good problem
     */
    public  double soupServings(int N){
        if(N == 0){
            return  0.5;
        }
        if(N >= 500){
            return 0.999990;
        }
        double[][] matrix = new double[N+1][N+1];

        return  search(matrix,N,N);
    }


    @Test
    public  void  test(){
//        int N  = 5559;
        int N = 5554;

        long startTime = System.currentTimeMillis();
        double result = soupServings(N);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
