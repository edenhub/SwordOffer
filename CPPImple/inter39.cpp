#include <iostream>

using namespace std;

struct BinaryTreeNode{
    int val;
    BinaryTreeNode *left,*right;

    BinaryTreeNode(){}
    BinaryTreeNode(int _val):val(_val),left(0),right(0){}
};

int deep(BinaryTreeNode* root){
    if(root ==0) return 0;
    if(root->left == 0 && root->right == 0) return 1;

    int deepLeft = deep(root->left);
    int deepRight = deep(root->right);

    return (deepLeft > deepRight) ? (deepLeft+1) : (deepRight+1);
}

int main(){
       BinaryTreeNode *n11=new BinaryTreeNode(8);
    BinaryTreeNode *n12=new BinaryTreeNode(8);
    BinaryTreeNode *n13=new BinaryTreeNode(9);
    BinaryTreeNode *n14=new BinaryTreeNode(2);
    BinaryTreeNode *n15=new BinaryTreeNode(2);
    BinaryTreeNode *n16=new BinaryTreeNode(7);

    n11->left = n12; 
    n12->left = n13; n12->right = n14;
    n14->left = n15; n14->right = n16;
    int d = deep(n11);
    cout<<d<<endl;
    return 0;
}