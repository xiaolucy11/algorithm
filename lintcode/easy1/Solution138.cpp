//
// Created by 20589 on 2019/3/1.
//
#include <vector>
#include <map>
#include <iostream>

using  namespace std;
class Solution138{
public:

    //Accepted ----1715ms
    vector<int> subarraySum(vector<int> &nums){
        vector<int> res;
        if(nums.size() == 0){
            return  res;
        }

        int sum = 0;
        map<int, vector<int> > mp;
        for(int i = 0; i < nums.size(); i++){
            sum += nums[i];
            if(sum == 0){
                res.push_back(0);
                res.push_back(i);
                return  res;
            }
            if(mp.find(sum) != mp.end()){
                vector<int> v = mp.find(sum)->second;
                res.push_back(v[0] + 1);
                res.push_back(i);
                return  res;
            } else{
                vector<int > v;
                v.push_back(i);
                mp[sum] = v;
            }
        }

        return  res;
    }
};


/*
int main(){
//    int arr[] = {-3,1,2,-3,4};
    int arr[] = {-3,1,-4,2,-3,4};
    int len = sizeof(arr) / sizeof(int);
    vector<int> nums(arr, arr + len);
    Solution138 s;
    vector<int> res = s.subarraySum(nums);

    cout << res[0] << " " << res[1] << endl;
}
 */