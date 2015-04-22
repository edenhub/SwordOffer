#include <iostream>
#include <queue>

using namespace std;

struct BinaryTreeNode{
    int val;
    BinaryTreeNode *left,*right;

    BinaryTreeNode(){}
    BinaryTreeNode(int _val):val(_val),left(0),right(0){}
};

void travel(BinaryTreeNode* root){
    if(root == 0) return;

    queue<BinaryTreeNode*> qu;
    qu.push(root);
    BinaryTreeNode* pt;

    while(!qu.empty()){
        pt = qu.front();
        qu.pop();
        cout<<pt->val<<" ";

        if(pt->left!=0) qu.push(pt->left);
        if(pt->right!=0) qu.push(pt->right);
    }

}

int main(){
     BinaryTreeNode *n11=new BinaryTreeNode(8);
    BinaryTreeNode *n12=new BinaryTreeNode(18);
    BinaryTreeNode *n13=new BinaryTreeNode(9);
    BinaryTreeNode *n14=new BinaryTreeNode(12);
    BinaryTreeNode *n15=new BinaryTreeNode(2);
    BinaryTreeNode *n16=new BinaryTreeNode(7);

    n11->left = n12; 
    n12->left = n13; n12->right = n14;
    n14->left = n15; n14->right = n16;

    travel(n11);

    return 0;
}