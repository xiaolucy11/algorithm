//
// Created by 20589 on 2019/2/20.
//

#include <vector>
#include <string>
#include <iostream>
#include <ctime>

using  namespace std;
class Solution784{
private:
    int commont_prefix(string &str1, string &str2){
        int index = 0;
        while (index < min(str1.length(), str2.length())){
            if(str1[index] == str2[index]){
                index++;
            } else{
                break;
            }
        }
        return index;
    }

public:
    int the_longest_common_prefix(vector<string>& dic, string &target){
        int longest_max = 0;
        for(vector<string>::iterator it = dic.begin(); it != dic.end(); it++){
            longest_max = max(longest_max, commont_prefix(*it,target));
        }
        return  longest_max;
    }
};

/*
int main(){
//    string arr[] = {"abcba","acc","abwsf"};
    string arr[] = {"aaa","bbb","aabb"};
    int arrLen = sizeof(arr) / sizeof(arr[0]);
    vector<string> dic(arr,arr + arrLen );
//    string target = "abse";
    string target = "aaab";
    Solution784 s;
    clock_t startTime = clock();
    int len = s.the_longest_common_prefix(dic,target);
    clock_t endTime = clock();
    std::cout << len << endl;
    cout << "running time : " << (endTime - startTime) << endl;
}
 */

