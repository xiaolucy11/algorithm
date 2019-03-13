//
// Created by 20589 on 2019/3/13.
//

#include <map>
#include <set>
#include <iostream>
#include <vector>

using  namespace std;

class pairCmp{
    bool  operator() (const pair<int, int> &p1, const pair<int, int> &p2){
        return  p1.second < p2.second;
    }
};
class 

//Accepted ----862ms
class LFUCache{
private:
    map<int, int> store; // key-value
    map<int, int> mp; // key-cout
    map<int,int> ops;
    int capacity,totalOps;
public:
    LFUCache(int capacity){
        this->capacity = capacity;
        totalOps = 0;
    }
    void  set(int key, int value){
        map<int,int>::iterator it = store.find(key);
        if(it == store.end()){
            if(store.size() == capacity){
                int minValue = 100000000;
                vector<int> v;
                for(map<int,int>::iterator mpIt = mp.begin(); mpIt != mp.end(); mpIt++){
                    if(mpIt->second < minValue){
                        minValue = mpIt->second;
                        v.clear();
                        v.push_back(mpIt->first);
                    } else if (mpIt->second == minValue){
                        v.push_back(mpIt->first);
                    }
                }
                int minOps = 1000000,targetKey = -1;
                for(int i = 0; i < v.size(); i++){
                    if(ops[v[i]] < minOps){
                        minOps = ops[v[i]];
                        targetKey = v[i];
                    }
                }
                store.erase(targetKey);
                mp.erase(targetKey);
            }
            store[key] = value;
            mp[key] = 1;
            totalOps++;
            ops[key] = totalOps;
        } else{
            store[key] = value;
            mp[key] = mp[key] + 1;
            totalOps++;
            ops[key] = totalOps;
        }
    }

    int get(int key){
        map<int,int>::iterator  it = store.find(key);
        if(it == store.end()){
            return  -1;
        } else{
            mp[key] = mp[key] + 1;
            totalOps++;
            ops[key] = totalOps;
            return  store[key];
        }
    }
};

int main(){
    LFUCache lfu(3);
    lfu.set(1,10);
    lfu.set(2,20);
    lfu.set(3,30);
    int res1 = lfu.get(1);
    lfu.set(4,40);
    int res2 = lfu.get(4);
    int res3 = lfu.get(3);
    int res4 = lfu.get(2);

    cout << " get(2) : " << res4 << endl;
    int res5 = lfu.get(1);
    lfu.set(5,50);

    int res6 = lfu.get(1);
    int res7 = lfu.get(2);
    int res8 = lfu.get(3);

    cout << "get(3) : " << res8 << endl;
    int res9 = lfu.get(4);
    int res10 = lfu.get(5);
    cout << "get(4) : " << res9 << endl;
}

