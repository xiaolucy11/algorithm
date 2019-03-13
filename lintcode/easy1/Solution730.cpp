//
// Created by 20589 on 2019/2/26.
//

#include <cstdlib>
#include <iostream>

using  namespace std;
class Solution730{
public:
    int myPow(int v, int count){
        int res = 1;
        for(int i = 0; i < count; i++){
            res *= v;
        }
        return  res;
    }

    //Accepted ---50ms
    int subSum(int n){
        if(n == 1){
            return 1;
        }
        int* p = (int*)malloc((n+1) * sizeof(int));
        p[1] = 1;
        for(int i = 2; i < n + 1; i++){
            int count = myPow(2,i-1) ;
            p[i] = p[i-1] * 2 + count * i;
        }

        return  p[n];
    }
};

/*
int main(){
    int n = 5;
    Solution730 s;

    int result = s.subSum(n);
    cout << result << endl;
}
 */
