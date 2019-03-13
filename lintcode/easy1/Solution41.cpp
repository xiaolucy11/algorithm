//
// Created by 20589 on 2019/2/15.
//

#include <vector>
#include <ctime>
#include <iostream>

using  namespace std;
class Solution41{
public:

    //Accepted -----50ms
    /*
     *  slide window
     */
    int maxSubArray(vector<int> & nums){
        int begin = 0, end = 0;
        int max = -1000000, sum = 0;
        while (end < nums.size()){
            sum += nums[end++];
            max = max > sum ? max : sum;
            while ((sum < 0) && (begin <= end)){
                sum -= nums[begin++];
            }
//            max = max > sum ? max : sum;
        }
        return  max;
    }

};

/*
int main(){
    int arr[] = {-2,2,-3,4,-1,2,1,-5,3};
//    int arr[] = {1,2,3,4};
//    int arr[] = {-1};

    int len = sizeof(arr) / sizeof(arr[0]);
    vector<int > nums(arr,arr + len);
    Solution41 s;

    clock_t  startTime, endTime;
    startTime = clock();
    int result = s.maxSubArray(nums);
    endTime = clock();

    cout << "resullt : " << result << endl;
    cout << "running time : " << (endTime - startTime) << endl;


}
 */