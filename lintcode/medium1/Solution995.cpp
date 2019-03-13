//
// Created by 20589 on 2019/3/10.
//
#include <vector>
#include <iostream>

using  namespace std;
class Solution995{
private:
    int help(vector<int> &prices,int* profit, int index){
        if(index == prices.size() - 1){
            profit[index] = 0;
            return 0;
        }
        int value1 = 0;
        if(profit[index+1] != -10000){
            value1 = profit[index+1];
        } else{
            value1 = help(prices,profit,index+1);
        }

        int maxProfit = 0;
        for(int i = index + 1; i < prices.size(); i++){
            if(prices[i] > prices[index]){
                int value2 = 0;
                if(i + 2 >= prices.size()){
                    maxProfit = max(maxProfit, prices[i] - prices[index]);
                } else{
                    if(profit[i+2] != -10000){
                        value2 = profit[i+2];
                    } else{
                        value2 = help(prices,profit,i+2);
                    }
                    maxProfit = max(maxProfit,prices[i] - prices[index] + value2);
                }
            }
        }
            profit[index] = max(maxProfit,value1);
        return  profit[index];
    }

public:
    //Accepted ----- 201ms
    int maxProfit(vector<int> &prices){
        int* profits = new int[prices.size()];
        for(int i = 0; i < prices.size(); i++){
            profits[i] = -10000;
        }

        int result = help(prices,profits,0);
        return result;
    }
};


/*
int main(){
//    int arr[] = {1,2,3,0,2};
    int arr[] = {3,2,6,5,0,3};
    int size = sizeof(arr) / sizeof(int);
    vector<int > prices(arr, arr + size);
    Solution995 s;

    int result = s.maxProfit(prices);
    cout << "result : " << result << endl;
}

 */
