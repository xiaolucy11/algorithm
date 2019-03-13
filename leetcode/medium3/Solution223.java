package interview.medium3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/9/11 0011.
 */
public class Solution223 {
    public  int computeSharedArea(int A, int B, int C, int D, int E, int F, int G, int H){
        if((C <= E) || (A >= G) || (D <= F) || (B >= H)){
            return 0;
        }

        //  contains
        if((A >= E && A <= G) && (C >= E && C <= G) && (B >= F && B <= H) && (D >= F && D <= H)){
            return (C - A) * (D - B);
        }

        //contains
        if((E >= A && E <= C) && (G >= A && G <= C) && (F >= B && F <= D) &&
                (H >= B && H <= D)){
            return  (G - E) * (H - F);
        }

        /*
            ten kind of  special case
         */
        if((A >= E && A <= G) && (C >= E && C <= G) && (D > H ) && (B >= F && B <= H)){
            return (C - A)  * (H - B);
        }

        if((A >= E && A <= G) && (C >= E && C <= G) && (B < F) && (D > F && D < H)){
            return (C - A) * (D - F);
        }

        if((B >= F && B <= H) && (D > F && D < H) && (A < E) && (C >= E && C <= G)){
            return (C - E) * (D - B);
        }
        if((B >= F && B <= H) && (D > F && D < H) && (C >= G) && (A >= E && A <= G) ){
            return (G - A) * (D - B);
        }


        if((E >= A && E <= C) && (G >= A & G <= C) && (H >= D) && (F >= B & F <= D)){
            return (G - E) * (D - F);
        }
        if((E >= A && E <= C) && (G >= A & G <= C) && (F < B) && (H >= B && H <= D)){
            return (G - E) * (H- B);
        }

        if((F >= B && F <= D) && (H >= B && H <= D) && (E < A) && (G >= A && G < C) ){
            return (H - F) * (G-A);
        }
        if((F >= B && F <= D) && (H >= B && H <= D) && (G > C) && (E >= A && E <= C)){
            return (H - F) * (C - E);
        }

        if((F >= B && F <= D) && (H >= B && H <= D) && (E <= A && G >= C)){
            return (H- F) * (C - A);
        }
        if((A <= E) && (C >= G) && (F <= B) && (H >= D)){
            return (G - E) * (D - B);

        }

        // part overlap
        if((E >= A) && (B >= F && B <= H) && (H <= D && G > C)){
           return (H - B) * (C - E);
        }

        if((E >= A) && (D >= F && D <= H) && (G > C && F > B)){
            return (C - E ) * (D - F);
        }

        if((A >= E) && (H >= B && H <= D) && (F < B && C > G)){
            return (G - A) * (H- B);
        }

        if((A >= E) && (F >= B && F <= D) && (G < C && H > D)){
            return (G - A) * (D - F);
        }
        return 0;
    }

    //Accepted -----3ms
    /*
        ugly code........
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H){
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        int sharedArea = computeSharedArea(A, B, C, D, E,F, G, H);
        return area1 + area2 - sharedArea;

    }

    //reference from other
    public int computeArea1(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a=Math.max(A,E);
        int b=Math.max(B,F);
        int c=Math.min(C,G);
        int d=Math.min(D,H);
        int overlay=0;
        if (a<c&&b<d){
            overlay= (c-a)*(d-b);
        }
        return (C-A)*(D-B)+(G-E)*(H-F)-overlay;
    }


    @Test

    public  void  test(){
        int A = -3;
        int B = -3;
        int C = 3;
        int D = 3;
        int E =  -2;
        int F = -5;
        int G = 1;
        int H =  5;

        int result = computeArea(A, B, C, D,E, F, G, H);
        System.out.print(result);
    }
}
