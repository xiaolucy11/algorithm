//
// Created by 20589 on 2019/1/25.
//
#include <iostream>
#include <vector>
using namespace std;
class Solution{
public:
    vector<int > mergeSortedArray(vector<int > &A, vector<int > &B){
        vector<int > v ;
        int indexA = 0, indexB = 0;
        while ((indexA < A.size()) && (indexB < B.size())){
            if(A[indexA] < B[indexB]){
                v.push_back(A[indexA++]);
            } else{
                v.push_back(B[indexB++]);
            }
        }

        while (indexA < A.size()){
            v.push_back(A[indexA++]);
        }
        while (indexB < B.size()){
            v.push_back(B[indexB++]);
        }

        return  v;
    }
};


/*
int main(){
    int a[4] = {1,2,3,4};
    int b[4] = {2,4,5,6};

    vector<int > A(a,a+4);
    vector<int > B(b,b+4);

    Solution s ;
    vector<int > v = s.mergeSortedArray(A,B);

    for(int i = 0; i < v.size(); i++){
        cout << v[i] < " ";
    }
    cout << endl;
    return  0;
}
*/
