//
// Created by 20589 on 2019/3/3.
//

#include <iostream>
#include <cstdlib>

using  namespace std;
class  Solution514{
    /*
private:
    int helper(int index, int n, int colors, bool isSingle){
        if(index > n || colors <= 0){
            return 0;
        }
        if(index == n){
            return  colors;
        }

        if(isSingle){
            int value1 = 0;
            int value2 = 0;
            // index, index + 1 not keep same
            if(dp2[index+1] != -1){
                value1 = dp2[index+1];
            } else{
                value1 = helper(index+1,n,colors,false);
            }

            //index, index+1 keep same
            if(dp1[index+1] != 0){
                value2 = (colors-1) * dp1[index+1];
            } else{
                value2 = (colors - 1) * helper(index+1,n,colors, true);
            }
            dp1[index] = value1 + value2;
            return dp1[index];
        } else{
            int value = 0;
            if(dp1[value] != 0){
                value = (colors - 1) * dp1[index+1];
            } else{
                value = (colors - 1) * helper(index+1, n,colors,true);
            }
            dp2[index] = value;
            return  dp2[index];
        }
    }
*/
public:
   /*
    int numWays(int n, int k){
        for(int i = 0; i < 500;i++){
            dp1[i] = -1;
            dp2[i] = -1;
        }

        int res1 = helper(2,n,k,true);
        int res2 = helper(2,n,k,false);
        cout << res1 << "  " << res2;
        return res1 + k * res2;
    }
*/

   //Accepted ----50ms
   /*
    *   dynamic programming
    */
    int numWays1(int n, int k){
        int* p1 = new int[n+1]();
        int* p2 = new int[n+1]();
        p1[1] = 0;
        p2[1] = k;
        for(int i = 2; i < n+1; i++){
            p1[i] = p2[i-1];
            p2[i] = (p2[i-1] + p1[i-1]) * (k-1);
        }
        int res = p1[n] + p2[n];
        delete []p1;
        delete []p2;
        return res;

    }
};
/*
int main(){
    int n = 4;
    int k = 2;
    Solution514 s;
    int res = s.numWays1(n,k);
    cout << "result : " << res << endl;
}

 */