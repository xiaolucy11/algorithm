//
// Created by 20589 on 2019/3/11.
//
#include <vector>
#include <set>
#include <algorithm>
#include <iostream>
#include <stack>

using  namespace std;

struct  pairCmp{
    bool operator()(const pair<int,int> &p1, const pair<int,int> &p2){
        if(p1.first == p2.first){
            return  p1.second < p2.second;
    } else{
            return p1.first < p2.first;
        }
    }
};

class Solution1060{
public:
    vector<int > dailyTemperatures(vector<int> &temperatures){
        vector<int> res;
        if(temperatures.size() == 0){
            return  res;
        }
        set<pair<int, int>,pairCmp> s;
        for(int i = temperatures.size() - 1; i >= 0; i--){
            pair<int,int > p(temperatures[i], i);
            s.insert(p);
            set<pair<int,int>, pairCmp>::iterator index = s.find(p);
            set<pair<int, int>, pairCmp>::iterator it = index;
            while (it != s.end()){
                if(it->first == index->first){
                    it++;
                } else{
                    break;
                }
            }

            if(it != s.end()){
                res.push_back(it->second - index->second );
            } else{
                res.push_back(0);
            }
        }

        std::reverse(res.begin(),res.end());
        return res;
    }

    //Accepted ------202ms
    /*
     *  stack
     */
    vector<int > dailyTemperatures1(vector<int> &temperatures){
        vector<int> res;
        if(temperatures.size() == 0){
            return  res;
        }
        int* arr = new int[temperatures.size()];
        stack<pair<int, int> > s;
        for(int i = 0; i < temperatures.size(); i++){
            pair<int, int> p(temperatures[i], i);
            if(s.empty()){
                s.push(p);
            } else{
                while (!s.empty()){
                    pair<int, int> top = s.top();
                    if(top.first >= p.first){
                        s.push(p);
                        break;
                    } else{
                        s.pop();
                        arr[top.second] = p.second - top.second;
                    }
                }

                if(s.empty()){
                    s.push(p);
                }
            }
        }
        while (!s.empty()){
            pair<int, int > top = s.top();
            arr[top.second] = 0;
            s.pop();
        }

        for(int i = 0; i < temperatures.size(); i++){
            res.push_back(arr[i]);
        }

        return  res;
    }
};


/*
int main(){
    int arr[] = {73,74,75,71,69,72,76,73};
    int len = sizeof(arr) / sizeof(arr[0]);
    vector<int> temperatures(arr, arr + len);
    Solution1060 s;

    vector<int> result = s.dailyTemperatures1(temperatures);
    for(int i = 0; i < result.size(); i++){
        cout << result[i] << "  ";
    }
}

 */