//
// Created by 20589 on 2019/2/24.
//

#include <vector>
#include <cstdlib>
#include <map>
#include <iostream>

using  namespace std;
class Solution838{
public:
    //Accepted ------357ms
    int subarraySumEqualsK(vector<int> &nums, int k){
        int len = nums.size();
        if(len == 0){
            return 0;
        }
        int *p = (int*)malloc(len * sizeof(int));
        int res = 0;
        p[0] = nums[0];
        std::map<int,int> mp;
        mp[p[0]] = 1;
        mp[0] = 1;
        for(int i = 1; i < nums.size(); i++){
            p[i] = nums[i] + p[i-1];
            int diff = p[i] - k;
            if (mp.find(diff) != mp.end()){
                res += mp.find(diff)->second;
            }
            if(mp.find(p[i]) != mp.end()){
                mp[p[i]] = mp[p[i]] + 1;
            } else{
                mp[p[i]] = 1;
            }
        }
        free(p);
        p = NULL;
        return  res;
    }
};


/*
int  main(){
//    int arr[] = {1,1,1};
    int arr[] = {2,1,-1,1,2};
    int len = sizeof(arr) / sizeof(arr[0]);
    vector<int > nums(arr, arr + len);
    int k = 3;
    Solution838 s;

    int result = s.subarraySumEqualsK(nums,k);
    cout << result << endl;
}

*/

