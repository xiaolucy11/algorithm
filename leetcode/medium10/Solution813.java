package algorithm.medium10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/11/19.
 */
public class Solution813 {
    public  class  Element{
        double sum;
        int count;
        Element(double _sum, int _count){
            sum = _sum;
            count = _count;
        }
    }

  /*  public  int find(List<Element> list ) {
        int minIndex = 0;
        double minTotalSum = list.get(0).sum + list.get(1).sum;

        for(int i = 1; i < list.size() - 1; i++){
            double newSum = list.get(i).sum + list.get(i+1).sum;
            if(minTotalSum > newSum){
                minTotalSum = newSum;
                minIndex = i;
            }else if(minTotalSum == newSum){
                if(list.get(minIndex).count + list.get(minIndex + 1).count < list.get(i).count + list.get(i+1).count){
                    minIndex = i;
                }
            }
        }

        return  minIndex;
    }*/

    public  int find(List<Element> list){
        int minIndex = 0;
        double  mergetAve= (list.get(0).sum + list.get(1).sum ) / (list.get(0).count + list.get(1).count);
        double firstTwoAve = list.get(0).sum / list.get(0).count + list.get(1).sum / list.get(1).count;
        double minDecrease = firstTwoAve - mergetAve;
        for(int i = 1; i < list.size() - 1; i++){
             double newAve = (list.get(i).sum + list.get(i+1).sum) / (list.get(i).count + list.get(i+1).count);
            double noMergeAveSum = list.get(i).sum / list.get(i).count + list.get(i+1).sum / list.get(i+1).count;
            double newDecrease = noMergeAveSum - newAve;
            if(minDecrease >  newDecrease){
                minDecrease = newDecrease;
                minIndex = i;
            }
        }
        return  minIndex;
    }


    //Wrong Solution
    /*
         try greedy algorithm fail
     */
    public  double largestSumOfAverages(int[] A, int K){
        double allSum = 0.0;
        List<Element> input = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
            input.add(new Element(A[i], 1));
            allSum += A[i];
        }

        if(K == A.length){
            return  allSum;
        }
        if(K == 1){
            return  allSum / A.length;
        }

        while (true){
            if(input.size() == K){
                int minIndex = find(input);
                double averageSum = (input.get(minIndex).sum / input.get(minIndex).count) +
                        (input.get(minIndex + 1).sum) / input.get(minIndex + 1).count;
                double newAve = (input.get(minIndex).sum + input.get(minIndex + 1).sum) / (
                            input.get(minIndex).count + input.get(minIndex + 1).count
                        );
                if(newAve < averageSum){
                    break;
                }
            }
                List<Element> output = new ArrayList<>();
                int minIndex = find(input);
                for(int i = 0; i < input.size(); i++){
                    if(i != minIndex){
                        output.add(input.get(i));
                    }else {
                        double twoSum = (input.get(i).sum + input.get(i+1).sum) ;
                        output.add(new Element(twoSum, input.get(i).count + input.get(i+1).count));
                        i++;
                    }
                }
                input = output;
            }


        double totalSum = 0.0;
        for(int i = 0; i < input.size(); i++){
            totalSum += input.get(i).sum / input.get(i).count;
        }

        return  totalSum;
}


    public  double help(double[][][] matrix,int[] A, int start, int end,int k){
        if(end < start ||  k == 0){
            return  0;
        }
        double totalSum = 0.0;
        for(int i = start; i <= end; i++){
                totalSum += A[i];
        }


          if(end -start +1 <= k){
              matrix[start][end][k] = totalSum;
              return  totalSum;
          }

          if(k == 1){
              matrix[start][end][k] =   totalSum / (end - start + 1);
              return  matrix[start][end][k];
          }


        double sum = 0.0;
        double maxAve = 0.0;
        for(int i = start; i <= end; i++){
            sum += A[i];
            double subAverage = 0.0;
            if(i + 1 > end){
                subAverage = 0.0;
            } else {
                if (matrix[i + 1][end][k - 1] == 0) {
                    subAverage = help(matrix, A, i + 1, end, k - 1);
                } else {
                    subAverage = matrix[i + 1][end][k - 1];
                }
            }
            maxAve = Math.max(maxAve, (sum / (i - start + 1)) + subAverage);
        }

        matrix[start][end][k] = maxAve;
        return  matrix[start][end][k];
    }

    //Accepted ----28ms
    /*
        dp algorithm,using memorization
     */
    public  double largestSumOfAverages1(int[] A, int K){
        double[][][] matrix = new double[A.length][A.length][K+1];
        return  help(matrix,A, 0, A.length-1, K);

    }


    @Test
    public  void  test(){
       /* int[] A = {9,1,2,3,9};
        int K = 3;*/

       int[] A = {4,1,7,5,6,2,3};
        int K = 4;

       /* int[] A = {3748,521,7935, 3665, 5337};
        int K = 3;*/

      /* int[] A = {9183,4389,9284,9237,6853,1630,7881,8356,8046,2738,5834,7916,8260,3033,9773,
               6566,3629,9581,961,2971};
        int K  = 10;*/

        long startTime = System.currentTimeMillis();
        double result = largestSumOfAverages1(A,K);
        long endTime = System.currentTimeMillis();


        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
