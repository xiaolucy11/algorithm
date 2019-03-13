//
// Created by 20589 on 2019/2/17.
//

#include <vector>
#include <algorithm>
#include <iostream>

using  namespace std;
class Interval{
public:
    int start, end;
    Interval(int start, int end){
        this->start = start;
        this->end = end;
    }
};


class  Solution156{
private:
    static bool  lessmask(const Interval& t1, const Interval& t2){
        if(t1.start == t2.start){ return t1.end < t2.end;}
        else{ return  t1.start < t2.start;}
    }
public:
    //Accepted
    vector<Interval> merge(vector<Interval>& intervals){
        vector<Interval> v;
        sort(intervals.begin(), intervals.end(), lessmask);
        int sstart = intervals[0].start, eend = intervals[0].end;
        for(int i = 1; i < intervals.size(); i++){
            int v1 = intervals[i].start;
            int v2 = intervals[i].end;
            if(v1 > eend){
                Interval tmp(sstart, eend);
                v.push_back(tmp);
                sstart = v1;
                eend = v2;
            } else{
                eend = max(v2, eend);
            }
        }


        Interval last(sstart, eend);
        v.push_back(last);

        return  v;
    }
};


/*
int  main(){
    Interval interval1(1,3);
    Interval interval2(2,6);
    Interval interval3(8,10);
    Interval interval4(15,18);
    vector<Interval> intervals;
    intervals.push_back(interval1);
    intervals.push_back(interval4);
    intervals.push_back(interval3);
    intervals.push_back(interval2);

    Solution156 s;
    vector<Interval > result = s.merge(intervals);
    for(int i = 0; i < result.size(); i++){
        std::cout << result[i].start << ": " << result[i].end << endl;
    }

}
*/
