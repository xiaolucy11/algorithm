package algorithm.medium8;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by youlu on 2018/10/30.
 */
public class Solution672 {
    public  Set<String> set;

    public  void  flipAllLights(char[] chars){
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '0'){
                chars[i] = '1';
            }else {
                chars[i] = '0';
            }
        }
    }

    public  void  backFlipAllLights(char[] chars){
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '1'){
                chars[i] = '0';
            }else {
                chars[i] = '1';
            }
        }
    }

    public  void flipEvenNumbers(char[] chars){
        for(int i = 0; i < chars.length; i++){
            if((i + 1) % 2 == 1){
                if(chars[i] == '0'){
                    chars[i] = '1';
                }else {
                    chars[i] = '0';
                }
            }
        }
    }

    public  void  backFlipEvenNumber(char[] chars){
        for(int i = 0; i < chars.length; i++){
            if((i + 1) % 2 == 1){
                if(chars[i] == '1'){
                    chars[i] = '0';
                }else {
                    chars[i] = '1';
                }
            }
        }
    }

    public  void  flipOddNumber(char[] chars){
        for(int i = 0 ; i< chars.length; i++){
            if((i + 1) % 2 == 0){
                if(chars[i] == '1'){
                    chars[i] = '0';
                }else {
                    chars[i] = '1';
                }
            }
        }
    }

    public  void  backFlipOddNumber(char[] chars){
        for(int i = 0; i < chars.length; i++){
            if((i + 1) % 2 == 0){
                if(chars[i] == '0'){
                    chars[i] = '1';
                }else {
                    chars[i] = '0';
                }
            }
        }
    }

    public  void  flipThirdNumber(char[] chars){
        for(int i = 0; i < chars.length; i++){
            if(i % 3 == 0){
                if(chars[i] == '0'){
                    chars[i] = '1';
                }else {
                    chars[i] = '0';
                }
            }
        }
    }

    public  void  backFlipThirdNumber(char[] chars){
        for(int i = 0; i < chars.length; i++){
            if(i % 3 == 0){
                if(chars[i] == '1'){
                    chars[i] = '0';
                }else {
                    chars[i] = '1';
                }
            }
        }
    }

    public  void  search(char[] chars, int m){
        if(m == 0){
            String str = new String (chars);
            if(!set.add(str)){
                set.add(str);
            }
            return;
        }

        flipAllLights(chars);
        search(chars,m-1);
        backFlipAllLights(chars);

        flipEvenNumbers(chars);
        search(chars, m-1);
        backFlipEvenNumber(chars);

        flipOddNumber(chars);
        search(chars, m-1);
        backFlipOddNumber(chars);

        flipThirdNumber(chars);
        search(chars, m-1);
        backFlipThirdNumber(chars);

    }


    //Accepted ----23ms
    public  int flipLights(int n, int m){
        char[] chars = new char[n];
        for(int i = 0; i < n; i++){
            chars[i] = '1';
        }
        set = new HashSet<>();

        if(m < 4) {
            search(chars, m);
        }else {
            search(chars, 4);
        }
        return  set.size();
    }

    public  int flipLights1(int n, int m){
        if(m==0) return 1;
        if(n==1) return 2;
        if(n==2&&m==1) return 3;
        if(n==2) return 4;
        if(m==1) return 4;
        if(m==2) return 7;
        if(m>=3) return 8;
        return 8;
    }

    @Test
    public  void  test(){
        int n = 8;
        int m = 8;

        long startTime = System.currentTimeMillis();
        int result = flipLights(n,m);
        long endTime = System.currentTimeMillis();
        System.out.println("result :" + result);
        System.out.println("running time : " + (endTime - startTime));
    }

    @Test
    public  void  test1(){
        for(int i = 1; i <= 20; i++){
            for(int j = 1; j <= 10; j++){
                System.out.print( "  ( "  + i + " : " + j + " ) = " + flipLights(i,j) );
            }
            System.out.println();
        }
    }
}
