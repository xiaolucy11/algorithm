package algorithm.medium7;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/10/24.
 */
public class Solution638 {
    public  boolean check(List<Integer> list,  int[] need){
        for(int i = 0; i< need.length; i++){
            if(list.get(i) > need[i]){
                return  false;
            }
        }

        return  true;
    }

    public  boolean equal(List<Integer> list1, List<Integer> list2){
        for(int i = 0; i < list1.size() - 1; i++){
            if(list1.get(i)  != list2.get(i)){
                return  false;
            }
        }
        return true;
    }

    public  int search(List<List<Integer>> special, int specialIndex, List<Integer> price,int[] arrNeeds){
        int sum = 0;
        for(int i = specialIndex; i >= 0; i--){

            if(check(special.get(i), arrNeeds)){
                int count = 0;
                while (check(special.get(i), arrNeeds)){
                    count++;
                    for(int index = 0; index < arrNeeds.length; index++){
                        arrNeeds[index] -= special.get(i).get(index);
                    }
                }
                sum += count * special.get(i).get(arrNeeds.length);
            }

        }
        for(int i = 0; i < arrNeeds.length; i++){
            if(arrNeeds[i] != 0){
                sum += arrNeeds[i] * price.get(i);
            }
        }
        return  sum;
    }

    //Accepted ----8ms
    /*
        brute solution,because the max size of array is 100
     */
    public  int shopingOffers(List<Integer> price, List<List<Integer>> special,List<Integer> needs ){
        int[] arrNeeds = new int[needs.size()];
        int originSum = 0;
        for(int i = 0; i < arrNeeds.length; i++){
            if(price.get(i) != 0) {
                arrNeeds[i] = needs.get(i);
            }else {
                arrNeeds[i] = 0;
            }
            originSum += arrNeeds[i] * price.get(i);
        }

        Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int sum1 = 0, sum2 = 0;
                for(int i = 0; i < o1.size() - 1; i++){
                    sum1 += o1.get(i) * price.get(i);
                    sum2 += o2.get(i) * price.get(i);
                }
                int salesOff1 = o1.get(o1.size()-1) - sum1;
                int salesOff2 = o2.get(o2.size()-1) - sum2;

                if(salesOff1 < salesOff2){
                    return 1;
                }else if(salesOff1 > salesOff2){
                    return -1;
                }else {
                    return 0;
                }
            }
        };
        Collections.sort(special, comparator);
        List<Integer> list = new ArrayList<>();
            for(int i = special.size() - 1; i >= 0; i--){
                if(check(special.get(i), arrNeeds)){
                   int value = search(special, i,price, Arrays.copyOfRange(arrNeeds,0, arrNeeds.length));
                    list.add(value);
                }else {
                    list.add(Integer.MAX_VALUE);
                }
            }

            int minValue = originSum;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) < minValue){
                minValue = list.get(i);
            }
        }

        return minValue;


    }

    @Test
    public  void  test(){
        List<Integer> price = new ArrayList<>();
        price.add(3);
        price.add(4);
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> list1  = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        special.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(5);
        special.add(list2);

        List<Integer> needs = new ArrayList<>();
        needs.add(2);
        needs.add(2);

       /* List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(3);
        price.add(4);
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> needs = new ArrayList<>();
        List<Integer> list1  = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        list1.add(0);
        list1.add(4);
        special.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(2);
        list2.add(1);
        list2.add(9);
        special.add(list2);

        needs.add(1);
        needs.add(2);
        needs.add(1);*/
      /*int[][] matrix = {{1,2,2,1,0,4,14},{6,3,4,0,0,1,16},{4,5,6,6,2,4,26},
              {1,1,4,3,4,3,15},{4,2,5,4,4,5,15},{4,0,0,2,3,5,13},{2,4,6,4,3,5,7},{3,3,4,2,2,6,21},
              {0,3,0,2,3,3,15},{0,2,4,2,2,5,24},{4,1,5,4,5,4,25},{6,0,5,0,1,1,14},{4,0,5,2,1,5,8},
              {4,1,4,4,3,1,10},{4,4,2,1,5,0,14},{2,4,4,1,3,1,16},{4,2,3,1,2,1,26},{2,4,1,6,5,3,2},
              {0,2,0,4,0,0,19},{3,1,6,3,3,1,23},{6,2,3,2,4,4,16},{5,3,5,5,0,4,5},{5,0,4,3,0,2,20},
              {5,3,1,2,2,5,8},{3,0,6,1,0,2,10},{5,6,6,1,0,4,12},{0,6,6,4,6,4,21},{0,4,6,5,0,0,22},
              {0,4,2,4,4,6,16},{4,2,1,0,6,5,14},{0,1,3,5,0,3,8},{5,5,3,3,2,0,4},{1,0,3,6,2,3,18},
              {4,2,6,2,2,5,2},{0,2,5,5,3,6,12},{1,0,6,6,5,0,10},{6,0,0,5,5,1,24},{1,4,6,5,6,3,19},
              {2,2,4,2,4,2,20},{5,6,1,4,0,5,3},{3,3,2,2,1,0,14},{0,1,3,6,5,0,9},{5,3,6,5,3,3,11},
              {5,3,3,1,0,2,26},{0,1,1,4,2,1,16},{4,2,3,2,1,4,6},{0,2,1,3,3,5,15},{5,6,4,1,2,5,18},
              {1,0,0,1,6,1,16},{2,0,6,6,2,2,17},{4,4,0,2,4,6,12},{0,5,2,5,4,6,6},{5,2,1,6,2,1,24},
              {2,0,2,2,0,1,14},{1,1,0,5,3,5,16},{0,2,3,5,5,5,6},{3,2,0,6,4,6,8},{4,0,1,4,5,1,6},
              {5,0,5,6,6,3,7},{2,6,0,0,2,1,25},{0,4,6,1,4,4,6},{6,3,1,4,1,1,24},{6,2,1,2,1,4,4},
              {0,1,2,3,0,1,3},{0,2,5,6,5,2,13},{2,6,4,2,2,3,17},{3,4,5,0,5,4,20},{6,2,3,4,1,3,4},
              {6,4,0,0,0,5,16},{3,1,2,5,0,6,11},{1,3,2,2,5,6,14},{1,3,4,5,3,5,18},{2,1,1,2,6,1,1},
              {4,0,4,0,6,6,8},{4,6,0,5,0,2,1},{3,1,0,5,3,2,26},{4,0,4,0,6,6,6},{5,0,0,0,0,4,26},
              {4,3,2,2,0,2,14},{5,2,4,0,2,2,26},{3,4,6,0,2,4,25},{2,1,5,5,1,3,26},{0,5,2,4,0,2,24},
              {5,2,5,4,5,0,1},{5,3,0,1,5,4,15},{6,1,5,1,2,1,21},{2,5,1,2,1,4,15},{1,4,4,0,0,0,1},
              {5,0,6,1,1,4,22},{0,1,1,6,1,4,1},{1,6,0,3,2,2,17},{3,4,3,3,1,5,17},{1,5,5,4,5,2,27},
              {0,6,5,5,0,0,26},{1,4,0,3,1,0,13},{1,0,3,5,2,4,5},
              {2,2,2,3,0,0,11},{3,2,2,1,1,1,6},{6,6,1,1,1,6,26},{1,5,1,2,5,2,12}};
        List<List<Integer>> special = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            List<Integer> input = new ArrayList<>();
            for(int j = 0; j < matrix[i].length; j++){
                input.add(matrix[i][j]);
            }
            special.add(input);
        }

        List<Integer> price = new ArrayList<>();
        price.add(9);
        price.add(6);
        price.add(1);
        price.add(5);
        price.add(3);
        price.add(4);
        List<Integer> needs = new ArrayList<>();
        needs.add(6);
        needs.add(6);
        needs.add(6);
        needs.add(1);
        needs.add(6);
        needs.add(6);*/
        long startTime = System.currentTimeMillis();
        int result = shopingOffers(price, special, needs);
        long endTime = System.currentTimeMillis();

        System.out.println("result ;" + result);
        System.out.println("running time : " + (endTime - startTime));
    }
}
