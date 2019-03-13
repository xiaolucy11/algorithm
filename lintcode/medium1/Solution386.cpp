//
// Created by 20589 on 2019/3/8.
//
#include <string>
#include <map>
#include <iostream>

using  namespace std;
class Solution386{
private:
    int minIndex(map<char, int> &mp){
        int res = 1000000;
        for(map<char,int>::iterator it=mp.begin(); it != mp.end(); it++){
            res = min(res,it->second);
        }
        return  res;
    }

public:
    //Accepted -----302ms
    int lengthOfLongestSubstringkDistinct(string &s, int k){
        if(k == 0){return 0;}
        map<char, int> mp;
        int count = 0,left = 0;
        int maxLen = 0;
        for(int i = 0; i < s.size(); i++){
            if(mp.find(s[i]) != mp.end()){
                mp[s[i]] = i;
            } else{
                if(count < k){
                    count++;
                    mp[s[i]] = i;
                } else{
                    int firstIndex = minIndex(mp);
                    maxLen = max(maxLen,i - left);
                    left = firstIndex + 1;
                    mp.erase(s[firstIndex]);
                    mp[s[i]] = i;
                }
            }
        }
        maxLen = max(maxLen,(int)s.size() - left);
        return  maxLen;
    }
};


/*
int main(){
 //   string s = "eceba";
//    string s = "WORLD";
    string s = "nfhiexxjrtvpfhkrxcutexxcodfioburrtjefrgwrnqtyzelvtpvwdvvpsbudwtiryqzzy";
    int k = 25;
    Solution386 solution;

    int result = solution.lengthOfLongestSubstringkDistinct(s,k);
    cout << "length of s:" << s.size() << endl;
    cout << "result : " << result << endl;

}

 */