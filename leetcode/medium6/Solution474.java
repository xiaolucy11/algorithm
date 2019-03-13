package algorithm.medium6;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by youlu on 2018/10/10.
 */
public class Solution474 {
    public  int maxLength;
    public  void search(int[] zeros, int[] ones,int index, Set<Integer> set, int totalZeros, int totalOnes){
        if(totalZeros == 0 && totalOnes == 0){
           if(set.size() > maxLength){
               maxLength = set.size();
           }
           return;
        }

        if(set.size() > maxLength){
            maxLength = set.size();
        }

        for(int i = index; i < zeros.length; i++){
            int zerosCount = zeros[i];
            int onesCount = ones[i];
            if(totalZeros >= zerosCount && totalOnes >= onesCount && !set.contains(i)){
                set.add(i);
                search(zeros, ones,i+1, set, totalZeros - zerosCount, totalOnes - onesCount);
                set.remove(i);
            }
        }

    }


    public  int findMaxForm(String[] strs, int m, int n){
        maxLength = 0;
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() < o2.length()){
                    return -1;
                }else if(o1.length() > o2.length()){
                    return  1;
                }else {
                    return  o1.compareTo(o2);
                }
            }
        });

        int length = strs.length;
        int[] zeros = new int[length];
        int[] ones = new int[length];
        int totalZeros = 0, totalOnes = 0;
        for(int i = 0; i < length; i++){
            int countZero = 0, countOne = 0;
            for(int j = 0; j < strs[i].length(); j++){
                if(strs[i].charAt(j) == '0'){
                    countZero++;
                }else {
                    countOne++;
                }
            }
            zeros[i] = countZero;
            ones[i] = countOne;
            totalOnes += countOne;
            totalZeros += countZero;
        }

        if(totalOnes <= n && totalZeros <= m){
            return  length;
        }

        int index = 0, result = 0;
        while (index < length ){
            if(m <= 0 || n <= 0){
                break;
            }

            if(zeros[index] == 0 || ones[index] == 0){
                result++;
                index++;
                if(zeros[index] == 0){
                    m--;
                }else {
                    n--;
                }

            }else {
                break;
            }
        }

        for(int i = index; i < zeros.length;i++){
            int zerosNumber = zeros[i];
            int onesNumber = ones[i];
            if(zerosNumber <= m && onesNumber <= n) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                search(zeros, ones,i+1, set, m - zerosNumber, n - onesNumber);
            }
        }
        return  result + maxLength;
    }

    //Wrong solution
    public  int findMaxForm1(String[] strs, int m, int n){
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() < o2.length()){
                    return -1;
                }else if(o1.length() > o2.length()){
                    return  1;
                }else {
                    return  o1.compareTo(o2);
                }
            }
        });

        int count = 0;
        int totalZeros = m, totalOnes = n;
        for(int i = 0; i < strs.length;i++){
            int zerosCount = 0, onesCount = 0;
            for(int j = 0; j < strs[i].length(); j++){
                if(strs[i].charAt(j) == '0'){
                    zerosCount++;
                }else {
                    onesCount++;
                }
            }
            if(zerosCount <= totalZeros && onesCount <= totalOnes){
                count++;
                totalZeros -= zerosCount;
                totalOnes -= onesCount;
            }else {
                break;
            }
        }

        return  count;
    }

    public  class  Element{
        int zerosCount;
        int onesCount;
        Element(int _zerosCount, int _onesCount){
            zerosCount = _zerosCount;
            onesCount = _onesCount;
        }
    }

    public int search1(Element[] elements,int index, int m, int n){
        int result = 0;
        int totalZeros = m, totalOnes = n;
        for(int i = index; i < elements.length; i++){
            if(elements[i].zerosCount <= totalZeros && elements[i].onesCount <= totalOnes){
                result++;
                totalZeros -= elements[i].zerosCount;
                totalOnes -= elements[i].onesCount;
            }
        }
        return  result;
    }

    public  int sortedByZeros(Element[] elements,int m, int n ){
        int length = elements.length;
        Arrays.sort(elements, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.zerosCount < o2.zerosCount){
                    return  -1;
                }else if(o1.zerosCount > o2.zerosCount){
                    return 1;
                }else {
                    if(o1.onesCount < o2.onesCount){
                        return -1;
                    }else if(o1.onesCount > o2.onesCount){
                        return  1;
                    }else {
                        return 0;
                    }
                }
            }
        });

        int maxValue = 0;
        for(int i = 0; i < length; i++){
            int value = search1(elements,i,m,n);
            if(value > maxValue){
                maxValue = value;
            }
        }
        return maxValue;
    }

    public  int sortedByOnes(Element[] elements, int m, int n){
        int length = elements.length;
        Arrays.sort(elements, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.onesCount < o2.onesCount){
                    return -1;
                }else if(o1.onesCount > o2.onesCount){
                    return  1;
                }else {
                    if(o1.zerosCount < o2.zerosCount){
                        return  -1;
                    }else if(o1.zerosCount > o2.zerosCount){
                        return  1;
                    }else {
                        return 0;
                    }
                }
            }
        });

        int maxValue = 0;
        for(int i = 0; i < length; i++){
            int value = search1(elements,i,m,n);
            if(value > maxValue){
                maxValue = value;
            }
        }
        return maxValue;
    }

    public  int sortedByLength(Element[] elements, int m, int n){
        int length = elements.length;
        Arrays.sort(elements, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                int value1 = Math.abs(o1.onesCount - o1.zerosCount);
                int value2 = Math.abs(o2.onesCount - o2.zerosCount);
                return -1 * (value1 - value2);
            }
        });

        int result = 0;
        for(int i = 0; i < length; i++){
            if(elements[i].zerosCount <= m && elements[i].onesCount <= n){
                result++;
                m -= elements[i].zerosCount;
                n -= elements[i].onesCount;
            }else {
                break;
            }
        }
        return  result;
    }

    //Accepted -----13ms
    /*
        brute solution : greedy algorithm and trackbacking
        time complexity O(n^2)
     */
    public  int findMaxForm2(String[] strs, int m, int n){
        int length = strs.length;
        Element[] elements = new Element[length];
        for(int i = 0; i < strs.length;i++){
            int zerosCount = 0, onesCount = 0;
            for(int j = 0; j < strs[i].length(); j++){
                if(strs[i].charAt(j) == '0'){
                    zerosCount++;
                }else {
                    onesCount++;
                }
            }
            Element e = new Element(zerosCount, onesCount);
            elements[i] = e;
        }

        int value1 = sortedByZeros(elements, m, n);
        int value2 = sortedByOnes(elements, m, n);
        return Math.max(value1,value2);

    }

    /*
        other solution : dp algorithm
        0-1 knapsack
     */

    @Test
    public  void  test(){
        String[] strs = {"10","0001","111001","0","1"};
        int m = 3;
        int n = 4;

      /*String[] strs = {"10","1","0"};
        int m = 1;
        int n = 1;*/

       /* String[] strs = {"111","1000","1000","1000"};
        int m = 9;
        int n = 3;*/

      /* String[] strs = {"1100","100000","011111"};
        int m = 6;
        int n = 6;*/

      /* String[] strs = {"10","0001","111001","1","0"};
        int m = 1;
        int n = 1;*/


       /*String[] strs = {"011111","001","001"};
        int m = 4;
        int n = 5;*/

      /*String[] strs = {"0000111","0000111111","01111111","0001","000111111","0000001111111","00011111","000011111","00000011","0111111","0000000001111111","0011","001111",
                "00000001111","0011","0000111111111","0001111111","011111111"};
        int m = 4;
        int n = 6;*/

       /* String[] strs = {"00","000"};
        int m = 1;
        int n = 10;*/
       /* String[] strs = {"0","1101","01","00111","1","10010","0","0","00","1","11","0011"};
        int m = 63;
        int n = 36;*/

        /*String[] strs = {"0","11","1000","01","0","101","1","1","1","0","0","0","0","1","0","0110101","0","11","01",
                "00","01111","0011","1","1000","0","11101","1","0","10","0111"};
        int m = 9;
        int n = 80;*/
        long startTime = System.currentTimeMillis();
        int result = findMaxForm2(strs, m, n);
        long endTime = System.currentTimeMillis();
        System.out.println("result : " + result);
        System.out.println("running time : " + (endTime - startTime));

    }
}
