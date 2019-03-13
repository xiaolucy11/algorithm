//
// Created by 20589 on 2019/3/7.
//

#include <vector>
#include <stack>
#include <iostream>

using  namespace std;
class Solution363{
public:

    //Accepted ----50ms
    int trapRainWater(vector<int> &heights){
        if(heights.size() <= 2){
            return  0;
        }
        int sum = 0;
        stack<pair<int,int> > s;
        pair<int, int> p1(heights[0],0);
        s.push(p1);

        for(int i = 1; i < heights.size(); i++){
            pair<int,int> sTop = s.top();
            if(sTop.first > heights[i]){
                pair<int,int> p1(heights[i],i);
                s.push(p1);
            } else if(sTop.first == heights[i]){
                s.pop();
                pair<int, int> p1(heights[i],i);
                s.push(p1);
            } else{
                pair<int, int> temp = s.top();
                s.top();
                int pre = temp.first;
                while (!s.empty()){
                    pair<int,int> top = s.top();
                    if(top.first == heights[i]){
                        sum += (i - top.second - 1) * (min(top.first, heights[i]) - pre);
                        s.pop();
                        pair<int, int> p2(heights[i],i);
                        s.push(p2);
                        break;
                    } else if(top.first > heights[i]){
                        sum += (i - top.second - 1) * (min(top.first, heights[i]) - pre );
                        pair<int, int> p2(heights[i],i);
                        s.push(p2);
                        break;
                    } else {
                        s.pop();
                        sum += (i - top.second - 1) * (min(top.first, heights[i]) - pre );
                        pre = min(top.first, heights[i]);
                    }
                }
                if(s.empty()){
                    pair<int, int> p3(heights[i],i);
                    s.push(p3);
                }
            }

        }

        return  sum;
    }
};

/*
int main(){
    int arr[] = {0,1,0};
//    int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
//    int arr[] = {100,50,99,50,100,50,99,50,100,50};
    int len = sizeof(arr) / sizeof(int);
    vector<int> heights(arr, arr + len);

    Solution363 s;
    int result = s.trapRainWater(heights);
    cout << "result : " << result;
}

 */