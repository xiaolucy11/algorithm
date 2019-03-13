//
// Created by 20589 on 2019/2/19.
//
#include <cstddef>
#include <vector>
#include <map>
#include <iostream>

using  namespace std;
class TreeNode{
public:
    int val;
    TreeNode *left, *right;
    TreeNode(int val){
        this->val = val;
        this->left = this->right = NULL;
    }
};

class  Solution661{
private:
     map<TreeNode*, int>  stat(vector<TreeNode*>& v){
        map<TreeNode* ,int> m;
        int index = (int) v.size() - 1;
        int sum = 0;
        while (index >= 0){
            sum += v[index]->val;
            m[v[index]] = sum;
            index--;
        }
         return  m;
    }

    void  preOrder(TreeNode* root, const map<TreeNode*,int >& m){
        if(root != NULL){
            preOrder(root->left, m);
            root->val = (m.find(root))->second;
            preOrder(root->right, m);
        }
    }

public:
    void  inOrder(vector<TreeNode* > & v, TreeNode* root){
        if(root != NULL){
            inOrder(v,root->left);
            v.push_back(root);
            inOrder(v, root->right);
        }
    }

    vector<TreeNode*> travesalBST(TreeNode* root){
        vector<TreeNode* > v;
        inOrder(v, root);
        return  v;
    }

    /*
     * Accepted
     */
    TreeNode* convertBST(TreeNode* root){
        vector<TreeNode*> v = travesalBST(root);
        map<TreeNode* ,int > m = stat(v);
        preOrder(root,m);

        return  root;
    }

    void  help(TreeNode* root, int& m){
      if(root != NULL){
          help(root->right,m);
          m += root->val;
          root->val = m;
          help(root->left,m);
      }
    }

    /*
     *  idea from other
     */
    TreeNode* convertBST1(TreeNode* root){
        int m = 0;
        help(root,m);
        return  root;
    }
};

/*
int main(){
    TreeNode node1(5);
    TreeNode node2(2);
    TreeNode node3(13);
    node1.left = &node2;
    node1.right = &node3;
    Solution661 s;

    TreeNode* result = s.convertBST1(&node1);
    vector<TreeNode*> v=  s.travesalBST(result);
    for(int i = 0; i < v.size(); i++){
        std::cout << v[i]->val << " ";
    }
}*/
