//
// Created by 20589 on 2019/3/4.
//

#include <cstddef>
#include <algorithm>
#include <iostream>
#include <ctime>

using namespace std;

class TreeNode{
public:
    int val;
    TreeNode* left,*right;
    TreeNode(int val){
        this->val = val;
        this->left = this->right = NULL;
    }
};

class Solution595{
private:
    int help(TreeNode* root, int &longestPath){
        if(root == NULL){
            return 0;
        }
        if(root->left == NULL && root->right == NULL){
            longestPath = max(longestPath,1);
            return 1;
        }
        int res = 1;
        int value1 = help(root->left,longestPath);
        int value2 = help(root->right,longestPath);
        if((root->left != NULL) && (root->left->val == root->val + 1)){
            res = max(res,value1 + 1);
        }
        if((root->right != NULL) && (root->right->val) == root->val + 1){
            res = max(res,value2 + 1);
        }
        longestPath = max(longestPath,res);
        return  res;
    }

public:

    //Accepted ----50ms
    int longestConsecutive(TreeNode* root){
        int longestPath = 0;
        int res = help(root, longestPath);
        return  longestPath;
    }
};

/*
int main(){
    TreeNode l1(1);
    TreeNode l22(3);
    TreeNode l33(2);
    TreeNode l34(4);
    TreeNode l48(5);

    l1.right = &l22;
    l22.left = &l33;
    l22.right = &l34;
    l34.right = &l48;

    TreeNode l1(2);
    TreeNode l22(3);
    TreeNode l33(2);
    TreeNode l41(1);
    l1.right = &l22;
    l22.left = &l33;
    l33.left = &l41;

    Solution595 s;
    time_t startTime  = clock();
    int result = s.longestConsecutive(&l1);
    time_t  endTime = clock();
    cout << "result : " << result << endl;
    cout << "running time : " << (endTime - startTime) << endl;
}

*/