package interview.easy3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/21 0021.
 */
public class Solution605 {

    //Accepted -----6ms
    public  boolean canPlaceFlowers(int[] flowerbed, int n){
       int canPlaceFowersNumber = 0;
        int quick = 0;
        while( quick < flowerbed.length && flowerbed[quick] != 1 ){
            quick++;
        }
        if(quick == flowerbed.length){
            if(quick % 2 == 1) {
                canPlaceFowersNumber = quick/ 2 + 1;
            }else {
                canPlaceFowersNumber = quick / 2 ;
            }
            if(n <= canPlaceFowersNumber){return  true;}
            else {return  false;}
        }else {
           if (quick >= 2 ) {
                canPlaceFowersNumber += quick / 2;
            }
        }
        int slow = quick;
        quick++;
        while (quick < flowerbed.length){
            if(flowerbed[quick] == 0){
                quick++;
            }else {
                int zeroLength = quick - slow - 1;
                if(zeroLength >= 3){
                    if(zeroLength % 2 == 0) {
                        canPlaceFowersNumber += zeroLength / 2 - 1;
                    }else {
                        canPlaceFowersNumber += zeroLength / 2;
                    }
                }
                slow = quick;
                quick++;
            }
        }
        if(quick - slow - 1 > 1){
            canPlaceFowersNumber += (quick - slow - 1) /  2;
        }
        if(n <= canPlaceFowersNumber){
            return  true;
        }else {
            return  false;
        }

    }

    @Test
    public  void  test(){
        int[] flowerbed = {0};
        System.out.println( "length of   flowerbeb :  "+ flowerbed.length);
        System.out.print(canPlaceFlowers(flowerbed, 1));
    }
}
