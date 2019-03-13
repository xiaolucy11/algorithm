//
// Created by 20589 on 2019/2/28.
//

#include <cstddef>
#include <iostream>

using namespace std;
class ListNode{
public:
    int val;
    ListNode *next;
    ListNode(int val){
        this->val = val;
        this->next = NULL;
    }
};

class Solution166{
private:
    int lenOfLinkList(ListNode* head){
        ListNode* p = head;
        int len = 0;
        while (p != NULL){
            len++;
            p = p->next;
        }

        return  len;
    }

public:
    //Accepted ---407ms
    ListNode* nthToLast(ListNode* head, int n){
        int len = lenOfLinkList(head);
        int toHead = len - n;
        int index = 0;
        ListNode *p = head;
        while (p != NULL){
            if(toHead != index){
                index++;
                p = p->next;
            } else{
                return p;
            }
        }
    }
};

/*
int main(){

    ListNode node1(3);
    ListNode node2(2);
    ListNode node3(1);
    ListNode node4(5);
    node1.next = &node2;
    node2.next = &node3;
    node3.next = &node4;
    int n = 2;
    Solution166 s;


    ListNode node1(1);
    ListNode node2(2);
    ListNode node3(3);
    node1.next = &node2;
    node2.next = &node3;
    int n = 3;
    Solution166 s;
    ListNode *res = s.nthToLast(&node1,n);
    cout << "result : " << res->val << endl;
}

*/
