#include <iostream>
#include <vector>


using namespace std;

struct BinaryTreeNode{
    int val;
    BinaryTreeNode *left,*right;

    BinaryTreeNode(){}
    BinaryTreeNode(int _val):val(_val),left(0),right(0){}
};

void findPath(BinaryTreeNode* root,int sum,int tgt,vector<int>& path){
    if(root == 0) return;

    sum += root->val;
    path.push_back(root->val);
    // cout<<"in"<<endl;
    bool isLeaf = root->left == NULL && root->right == NULL;
    if(sum == tgt && isLeaf){
        vector<int>::iterator iter = path.begin();
        while(iter!=path.end()){
            cout<<*iter++<<" ";
        }
        cout<<endl;
    }

    if(root->left!=0)
        findPath(root->left,sum,tgt,path);
    if(root->right!=0)
        findPath(root->right,sum,tgt,path);

    path.pop_back();
}

int main(){
    BinaryTreeNode* n1 = new BinaryTreeNode(10);
    BinaryTreeNode* n2 = new BinaryTreeNode(5);
    BinaryTreeNode* n3 = new BinaryTreeNode(12);
    BinaryTreeNode* n4 = new BinaryTreeNode(4);
    BinaryTreeNode* n5 = new BinaryTreeNode(7);

    n1->left = n2; n1->right = n3;
    n2->left = n4; n2->right = n5;

    vector<int> path;

    findPath(n1,0,22,path);

    return 0;
}