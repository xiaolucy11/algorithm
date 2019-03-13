//
// Created by 20589 on 2019/2/25.
//

#include <vector>
#include <string>
#include <map>
#include <set>
#include <iostream>
#include <ctime>

using  namespace std;
class Solution856{
public:

    //Accepted ----756ms
    bool  isSentenceSimilarity(vector<string> &words1, vector<string> &words2,
            vector<vector<string> > &pairs){
        if(words1.size() != words2.size()){
            return false;
        }
        map<string, set<string> > mp;
        for(int i = 0; i < pairs.size(); i++){
            string str1 = pairs[i][0];
            string str2 = pairs[i][1];
            if(mp.find(str1) != mp.end()){
                set<string> s1 = mp[str1];
                s1.insert(str2);
                mp[str1] = s1;
            } else{
                set<string> s2;
                s2.insert(str2);
                mp[str1] = s2;
            }

            if(mp.find(str2) != mp.end()){
                set<string> s1 = mp[str2];
                s1.insert(str1);
                mp[str2] = s1;
            } else{
                set<string> s2;
                s2.insert(str1);
                mp[str2] = s2;
            }
        }

        for(int i = 0; i < words2.size(); i++){
            map<string, set<string> >::iterator it1 = mp.find(words1[i]);
            bool  b = false;
            if(it1 != mp.end()){
                set<string> s = it1->second;
                if(s.find(words2[i]) != s.end()){
                    b = true;
                }
            }

            if(!b){
                return false;
            }
        }
        return  true;
    }
};

/*
int main(){
    vector<string> word1;
    word1.push_back("great");
    word1.push_back("acting");
    word1.push_back("skills");
    vector<string> word2;
    word2.push_back("fine");
    word2.push_back("drama");
    word2.push_back("talent");

    vector<vector<string> > pairs;
    vector<string> v0;
    v0.push_back("great");
    v0.push_back("fine");
    pairs.push_back(v0);

    vector<string> v1;
    v1.push_back("drama");
    v1.push_back("acting");
    pairs.push_back(v1);

    vector<string> v2;
    v2.push_back("skills");
    v2.push_back("talent");
    pairs.push_back(v2);


    Solution856 s;
    clock_t startTime = clock();
    bool  res = s.isSentenceSimilarity(word1, word2, pairs);
    clock_t endTime = clock();

    bool b = true;
    cout << b << endl;
    cout << "result : " << res << endl;
    cout << "running time : " << (endTime - startTime) << endl;
}

*/